package model;

import database.CRUD;
import database.ConfigDB;
import entity.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements CRUD {


    @Override
    public Object insert(Object object) {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        //2. Castear el objeto
        Book objBook = (Book) object;


        try{
            // 3. Crear el SQL
            String sql = "INSERT INTO book (name,nationality) VALUES(?,?);";

            // 4.Preparar el statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            // 5. Asignar los ?
            objPrepare.setString(1,objBook.getTitle());
            objPrepare.setString(2,objBook.getPublication_year());
            objPrepare.setDouble(3,objBook.getPrice());

            // Ejecutamos el query
            objPrepare.execute();

            // 7. Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objBook.setId(objResult.getInt(1));
            }

            //8. Cerramos el prepareStatement
            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Book insertion was successful.");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error adding Book"+e.getMessage());
        }

        //9. Cerramos la conexión
        ConfigDB.closeConnection();

        return objBook;
    }

    @Override
    public boolean update(Object object) {
        //1. Abrir la conexión
        Connection objConnection  = ConfigDB.openConnection();

        //2. Convertir el objeto
        Book objBook = (Book) object;

        //3. Variable bandera para saber si se actualizó
        boolean isUpdated = false;

        try{
            //4. Creamos la sentencia SQL
            String sql = "UPDATE book SET name = ? , nationatility = ? WHERE  id = ?;";
            //5. Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //6. Dar valor a los ? parámetros de Query
            objPrepare.setString(1,objBook.getTitle());
            objPrepare.setString(2,objBook.getPublication_year());
            objPrepare.setDouble(3,objBook.getPrice());
            objPrepare.setInt(3,objBook.getId());

            //7. Ejecutamos el query
            int rowAffected = objPrepare.executeUpdate();
            if (rowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was successful.");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally {
            //8. Cerrar la conexión
            ConfigDB.closeConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(Object object) {
        //1. Convertir el objeto a la entidad
        Book objBook = (Book) object;

        //2. Variable booleana para medir el estado de la eliminación
        boolean isDeleted = false;

        //3. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        try{
            //4. Escribir la sentencia SQL
            String sql = "DELETE FROM book WHERE id = ?;";

            //5. Preparamos el statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //6. Asignamos valor al signo de interrogación
            objPrepare.setInt(1,objBook.getId());

            //7. Execute update devuelve la cantidad de filas afectadas por la sentencia ejecutada.
            int totalAffectedRows = objPrepare.executeUpdate();

            if(totalAffectedRows > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "The delete was successful.");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //8. Cerramos la conexión
        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> findAll() {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        //2. Inicializar la lista donde se guardaran los registros que devuelve la BD
        List<Object> listBooks = new ArrayList<>();

        try{
            //3. Escribir la sentencia SQL
            String sql = "SELECT * FROM book ORDER BY book.id ASC";

            //4. Utilizar PrepareStatement
            PreparedStatement objPrepareStatement = (PreparedStatement) objConnection.prepareStatement(sql);

            //5. Ejecutar el Query o él prepare
            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            //6. Obtener los resultados
            while (objResult.next()){
                //Creamos una instancia de book
                Book objBook = new Book();

                //Llenamos nuestro objeto con lo que devuelve la base de datos (ResultSet)
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setPublication_year(objResult.getString("publication_year"));

                //Finalmente, agregamos el book a la lista
                listBooks.add(objBook);
            }

            //7. Cerramos la conexión
            ConfigDB.closeConnection();


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data acquisition Error");

        }
        return listBooks;
    }

    @Override
    public Object findById(int id) {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        Book objBook = null;

        try{
            //2. Sentencia SQL
            String sql = "Select * FROM book WHERE id = ?;";

            //3.Preparar el Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //4. Damos valor al ?
            objPrepare.setInt(1,id);

            //5. Ejecutamos el query
            ResultSet objResult = objPrepare.executeQuery();

            //6. Mientras haya un registro siguiente entonces
            while(objResult.next()){
                objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setPublication_year(objResult.getString("publication_year"));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //7. Cerrar la conexión
        ConfigDB.closeConnection();

        return objBook;
    }
}