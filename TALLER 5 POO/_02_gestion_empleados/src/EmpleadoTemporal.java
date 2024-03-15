public class EmpleadoTemporal extends Empleado{
    private String fechaFinContrato;

    public EmpleadoTemporal(String nombre, int edad, int idEmpleados, double salario, String fechaFinContrato) {
        super(nombre, edad, idEmpleados, salario);
        this.fechaFinContrato = fechaFinContrato;
    }


    public String getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(String fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }
}
