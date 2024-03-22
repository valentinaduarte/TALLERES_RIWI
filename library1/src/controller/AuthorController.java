package controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import entity.Author;
import model.AuthorModel;
import javax.swing.*;
import java.util.List;

public class AuthorController {
    //Método para listar todos los Authors.
    AuthorModel objAuthorModel;

    public AuthorController() {
        //Crear una instancia del model
        this.objAuthorModel = new AuthorModel();
    }

    public void getAll() {
        String list = this.getAll(this.objAuthorModel.findAll());

        //Mostramos toda la lista
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> listObject){
        String list = " List Authors \n";
        //Iteramos sobre la lista que devuelve el metodo findAll
        for (Object obj : listObject) {
            //Convertimos o casteamos el objeto tipo Object a un Author
            Author objAuthor = (Author) obj;
            //Concatenamos la información
            list += objAuthor.toString() + "\n";
        }

        return list;
    }

    public void create() {
        Author objAuthor = new Author();

        String name = JOptionPane.showInputDialog("Insert name: ");
        String nationality = JOptionPane.showInputDialog("Insert nationality: ");

        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        objAuthor = (Author) this.objAuthorModel.insert(objAuthor);

        JOptionPane.showMessageDialog(null, objAuthor.toString());
    }

    public void delete() {
        String listAuthorString = this.getAll(this.objAuthorModel.findAll());

        int confirm = 1;
        int isDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthorString + "Enter the ID of the Author to delete"));
        Author objAuthor = (Author) this.objAuthorModel.findById(isDelete);

        if (objAuthor == null) {
            JOptionPane.showMessageDialog(null, "Author not found.");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the Author : \n" + objAuthor.toString());

            //Si el usuario escogio que si entonces eliminamos.
            if (confirm == 0) {
                this.objAuthorModel.delete(objAuthor);
            }
        }
    }

    public void update(){
        //Listamos
        String listAuthors = this.getAll(this.objAuthorModel.findAll());

        // Pedimos el id
        int isUpdate = Integer.parseInt(JOptionPane.showInputDialog(listAuthors + "\nEnter the ID of the Author to edit"));

        // Verificar el id
        Author objAuthor = (Author) this.objAuthorModel.findById(isUpdate);

        if(objAuthor == null){
            JOptionPane.showMessageDialog(null,"Author notfound");
        }else{
            String name = JOptionPane.showInputDialog(null, "Enter new name", objAuthor.getName());
            String nationality = JOptionPane.showInputDialog(null, "Enter new nationality", objAuthor.getNationality());

            objAuthor.setName(name);
            objAuthor.setNationality(nationality);

            this.objAuthorModel.update(objAuthor);
        }
    }
}