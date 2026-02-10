/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arp;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.*;

public class Arp {
    public static void main(String[] args) throws Exception {
        ArpEntry[] tabla = ArpReader.readArp();
        System.out.println("Entradas ARP: " + tabla.length);
        for (ArpEntry e : tabla) {
            System.out.println(e);
        }
    }
}

class ArpEntry {
    String ip; String mac; String iface; String state;
    ArpEntry(String ip, String mac, String iface, String state) {
        this.ip = ip; this.mac = mac; this.iface = iface; this.state = state;
    }
    @Override public String toString() { return ip + " " + mac + " " + iface + " " + state; }
}

public class ArpReader {
    public static ArpEntry[] readArp() throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        List<String> cmd;
        if (os.contains("win")) cmd = Arrays.asList("arp", "-a");
        else if (os.contains("mac") || os.contains("darwin")) cmd = Arrays.asList("arp", "-a");
        else cmd = Arrays.asList("ip", "neigh");

        Process p = new ProcessBuilder(cmd).redirectErrorStream(true).start();
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {
            String line; while ((line = br.readLine()) != null) lines.add(line);
        }

        List<ArpEntry> out = new ArrayList<>();
        if (os.contains("win")) parseWindows(lines, out);
        else if (os.contains("mac") || os.contains("darwin")) parseBSD(lines, out);
        else parseLinux(lines, out);

        return out.toArray(new ArpEntry[0]);
    }

    private static void parseWindows(List<String> lines, List<ArpEntry> out) {
        Pattern row = Pattern.compile("\\s*(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+([0-9a-fA-F\\-]{17})\\s+(\\S+)");
        String iface = "unknown";
        for (String s : lines) {
            if (s.toLowerCase().contains("interfaz:")) {
                String[] parts = s.split(":");
                if (parts.length > 1) iface = parts[1].trim().split("\\s+")[0];
                continue;
            }
            Matcher m = row.matcher(s);
            if (m.find()) {
                String ip = m.group(1);
                String mac = m.group(2).replace('-', ':').toLowerCase();
                String state = m.group(3).toLowerCase();
                out.add(new ArpEntry(ip, mac, iface, state));
            }
        }
    }

    private static void parseBSD(List<String> lines, List<ArpEntry> out) {
        Pattern row = Pattern.compile(".*\\((\\d+\\.\\d+\\.\\d+\\.\\d+)\\) at ([0-9a-fA-F:]{17}) on (\\S+).*");
        for (String s : lines) {
            Matcher m = row.matcher(s);
            if (m.find()) out.add(new ArpEntry(m.group(1), m.group(2).toLowerCase(), m.group(3), "complete"));
        }
    }

    private static void parseLinux(List<String> lines, List<ArpEntry> out) {
        Pattern row = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)\\s+dev\\s+(\\S+)(?:\\s+lladdr\\s+([0-9a-fA-F:]{17}))?\\s+(\\S+)");
        for (String s : lines) {
            Matcher m = row.matcher(s);
            if (m.find()) {
                String ip = m.group(1);
                String iface = m.group(2);
                String mac = m.group(3) == null ? "incomplete" : m.group(3).toLowerCase();
                String state = m.group(4).toLowerCase();
                out.add(new ArpEntry(ip, mac, iface, state));
            }
        }
    }
}