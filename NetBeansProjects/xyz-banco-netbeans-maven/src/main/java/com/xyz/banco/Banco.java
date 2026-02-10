package com.xyz.banco;

public class Banco {
    private static final int MAX_CLIENTES = 100;
    private static final int MAX_EMPLEADOS = 50;
    private static final int MAX_TRANS = 1000;

    private final Cliente[] clientes = new Cliente[MAX_CLIENTES];
    private final Empleado[] empleados = new Empleado[MAX_EMPLEADOS];
    private final Transaccion[] trans = new Transaccion[MAX_TRANS];

    private int nClientes = 0, nEmpleados = 0, nTrans = 0;

    // ===== Clientes =====
    public boolean agregarCliente(Cliente c) {
        if (nClientes >= MAX_CLIENTES) return false;
        if (buscarClienteIdx(c.getId()) >= 0) return false;
        clientes[nClientes++] = c; return true;
    }
    public boolean eliminarCliente(String id) {
        int i = buscarClienteIdx(id);
        if (i < 0) return false;
        for (int j=i; j<nClientes-1; j++) clientes[j] = clientes[j+1];
        clientes[--nClientes] = null; return true;
    }
    public boolean actualizarClienteNombre(String id, String nuevo) {
        int i = buscarClienteIdx(id);
        if (i < 0) return false;
        clientes[i].setNombre(nuevo); return true;
    }
    public Cliente buscarCliente(String id) {
        int i = buscarClienteIdx(id);
        return i>=0 ? clientes[i] : null;
    }
    private int buscarClienteIdx(String id) {
        for (int i=0;i<nClientes;i++) if (clientes[i].getId().equals(id)) return i;
        return -1;
    }
    public void listarClientes() {
        if (nClientes==0) { System.out.println("Sin clientes"); return; }
        for (int i=0;i<nClientes;i++) System.out.println(clientes[i]);
    }
    public void listarClientesAhorro() {
        for (int i=0;i<nClientes;i++) if (clientes[i].tieneAhorro()) System.out.println(clientes[i]);
    }
    public void listarClientesCorriente() {
        for (int i=0;i<nClientes;i++) if (clientes[i].tieneCorriente()) System.out.println(clientes[i]);
    }

    public boolean abrirAhorros(String idCliente, String num, double saldo) {
        Cliente c = buscarCliente(idCliente);
        if (c==null || c.tieneAhorro()) return false;
        c.asignarAhorros(new CuentaAhorros(num, saldo));
        registrar(new Transaccion(Transaccion.Tipo.DEPOSITO, num, saldo));
        return true;
    }
    public boolean abrirCorriente(String idCliente, String num, double saldo) {
        Cliente c = buscarCliente(idCliente);
        if (c==null || c.tieneCorriente()) return false;
        c.asignarCorriente(new CuentaCorriente(num, saldo));
        registrar(new Transaccion(Transaccion.Tipo.DEPOSITO, num, saldo));
        return true;
    }

    // ===== Empleados / Nómina =====
    public boolean agregarEmpleado(Empleado e) {
        if (nEmpleados >= MAX_EMPLEADOS) return false;
        if (buscarEmpleadoIdx(e.getId()) >= 0) return false;
        empleados[nEmpleados++] = e; return true;
    }
    public boolean eliminarEmpleado(String id) {
        int i = buscarEmpleadoIdx(id);
        if (i < 0) return false;
        for (int j=i; j<nEmpleados-1; j++) empleados[j] = empleados[j+1];
        empleados[--nEmpleados] = null; return true;
    }
    public boolean actualizarEmpleado(String id, String cargo, double salario) {
        int i = buscarEmpleadoIdx(id);
        if (i<0) return false;
        empleados[i].setCargo(cargo);
        empleados[i].setSalario(salario);
        return true;
    }
    private int buscarEmpleadoIdx(String id) {
        for (int i=0;i<nEmpleados;i++) if (empleados[i].getId().equals(id)) return i;
        return -1;
    }
    public void listarNomina() {
        double total = 0;
        if (nEmpleados==0) { System.out.println("Sin empleados"); return; }
        for (int i=0;i<nEmpleados;i++) { 
            System.out.println(empleados[i]); 
            total += empleados[i].getSalario();
        }
        System.out.println("Total nómina: $"+String.format("%.2f", total));
    }

    // ===== Operaciones sobre cuentas =====
    public boolean depositar(String numeroCuenta, double monto) {
        Cuenta c = buscarCuenta(numeroCuenta);
        if (c==null) return false;
        c.depositar(monto);
        registrar(new Transaccion(Transaccion.Tipo.DEPOSITO, numeroCuenta, monto));
        return true;
    }
    public boolean retirar(String numeroCuenta, double monto) {
        Cuenta c = buscarCuenta(numeroCuenta);
        if (c==null) return false;
        c.retirar(monto);
        registrar(new Transaccion(Transaccion.Tipo.RETIRO, numeroCuenta, monto));
        return true;
    }
    public Double consultarSaldo(String numeroCuenta) {
        Cuenta c = buscarCuenta(numeroCuenta);
        if (c==null) return null;
        registrar(new Transaccion(Transaccion.Tipo.CONSULTA, numeroCuenta, 0));
        return c.getSaldo();
    }
    private Cuenta buscarCuenta(String numero) {
        for (int i=0;i<nClientes;i++) {
            if (clientes[i].tieneAhorro() && clientes[i].getAhorro().getNumero().equals(numero)) return clientes[i].getAhorro();
            if (clientes[i].tieneCorriente() && clientes[i].getCorriente().getNumero().equals(numero)) return clientes[i].getCorriente();
        }
        return null;
    }

    // ===== Transacciones =====
    private void registrar(Transaccion t) {
        if (nTrans < MAX_TRANS) trans[nTrans++] = t;
    }
    public void listarTransacciones() {
        if (nTrans==0) { System.out.println("Sin transacciones"); return; }
        for (int i=0;i<nTrans;i++) System.out.println(trans[i]);
    }
}
