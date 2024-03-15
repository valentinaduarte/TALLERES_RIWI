public class EmpleadoPermanente extends Empleado{
    private int añosAntiguedad;


    public EmpleadoPermanente(String nombre, int edad, int idEmpleados, double salario, int añosAntiguedad) {
        super(nombre, edad, idEmpleados, salario);
        this.añosAntiguedad = añosAntiguedad;
    }

    public int getAñosAntiguedad() {
        return añosAntiguedad;
    }

    public void setAñosAntiguedad(int añosAntiguedad) {
        this.añosAntiguedad = añosAntiguedad;
    }
}
