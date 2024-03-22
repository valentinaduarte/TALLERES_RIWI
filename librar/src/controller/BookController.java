package controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import entity.Book;
import model.BookModel;
import javax.swing.*;
import java.util.List;

public class BookController {
    //Método para listar todos los Books.
    BookModel objBookModel;

    public BookController() {
        //Crear una instancia del model
        this.objBookModel = new BookModel();
    }

    public void getAll() {
        String list = this.getAll(this.objBookModel.findAll());

        //Mostramos toda la lista
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = " List Books \n";
        //Iteramos sobre la lista que devuelve el metodo findAll
        for (Object obj : listObject) {
            //Convertimos o casteamos el objeto tipo Object a un Book
            Book objBook = (Book) obj;
            //Concatenamos la información
            list += objBook.toString() + "\n";
        }
        return list;
    }

    public void create() {
        Book objBook = new Book();

        String title = JOptionPane.showInputDialog("Insert title: ");
        String publication_year = JOptionPane.showInputDialog("Insert publication year: ");

        objBook.setTitle(title);
        objBook.setPublication_year(publication_year);

        objBook = (Book) this.objBookModel.insert(objBook);

        JOptionPane.showMessageDialog(null, objBook.toString());
    }

    public void delete() {
        String listBookString = this.getAll(this.objBookModel.findAll());

        int confirm = 1;
        int isDelete = Integer.parseInt(JOptionPane.showInputDialog(listBookString + "Enter the ID of the Book to delete"));
        Book objBook = (Book) this.objBookModel.findById(isDelete);

        if (objBook == null) {
            JOptionPane.showMessageDialog(null, "Book not found.");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the Book : \n" + objBook.toString());

            //Si el usuario escogio que si entonces eliminamos.
            if (confirm == 0) {
                this.objBookModel.delete(objBook);
            }
        }
    }

    public void update(){
        //Listamos
        String listBooks = this.getAll(this.objBookModel.findAll());

        // Pedimos el id
        int isUpdate = Integer.parseInt(JOptionPane.showInputDialog(listBooks + "\nEnter the ID of the Book to edit"));

        // Verificar el id
        Book objBook = (Book) this.objBookModel.findById(isUpdate);

        if(objBook == null){
            JOptionPane.showMessageDialog(null,"Book not found");
        }else{
            String title = JOptionPane.showInputDialog(null, "Enter new title", objBook.getTitle());
            String publication_year = JOptionPane.showInputDialog(null, "Enter new publication year:", objBook.getPublication_year());

            objBook.setTitle(title);
            objBook.setPublication_year(publication_year);

            this.objBookModel.update(objBook);
        }
    }
}