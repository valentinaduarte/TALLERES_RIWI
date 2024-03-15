import static java.lang.System.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        Empleado empleado1 = new EmpleadoPermanente("Valentina Duarte",22,1,20000,5);
        Empleado empleado2 = new EmpleadoTemporal("Andres Vera",25,2,20000,"02/04/2022");

        gestionEmpleados.agregarEmpleado(empleado1);
        gestionEmpleados.agregarEmpleado(empleado2);

        gestionEmpleados.mostrarEmpleados();

        gestionEmpleados.eliminarEmpleado(2);


        System.out.println("Despues de eliminar");
        gestionEmpleados.mostrarEmpleados();

    }
}