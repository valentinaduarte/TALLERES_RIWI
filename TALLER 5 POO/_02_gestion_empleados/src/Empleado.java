public class Empleado  extends  Persona{
    private int idEmpleados;

    private double salario;


    public Empleado(String nombre, int edad, int idEmpleados,double salario) {
        super(nombre, edad);
        this.idEmpleados = idEmpleados;
        this.salario = salario;
    }

    public int getIdEmpleado() {
        return idEmpleados;
    }

    public void setIdEmpleados(int idEmpleados) {
        this.idEmpleados = idEmpleados;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
