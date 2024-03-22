package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable que va a contener el estado de la conexión
    static Connection objConnection  = null;

    //Método para abrir la conexión entre Java y la base de datos

    public static Connection openConnection() {
        try {
            //Class forname permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales de la base de datos
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = "";

            //Establecemos la conexión
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecte correctamente.");


        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no instalado ");
        }catch (SQLException e){
            System.out.println("Error no se pudo establecer una conexión con la BD");
        }
        return objConnection;
    }

    public static void closeConnection(){
        try{
            //Si hay una conexión activa, la cerramos
            if (objConnection != null) objConnection.close();

        }catch (SQLException e){
            System.out.println("Error:"+ e.getMessage());

        }

    }
}