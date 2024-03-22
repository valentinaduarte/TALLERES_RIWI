import controller.AuthorController;
import controller.BookController;
import database.ConfigDB;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        AuthorController objAuthorController = new AuthorController();
        BookController objBookController = new BookController();
        String option = "";

        do{

            option = JOptionPane.showInputDialog("""
                    LIBRARY MENU
                    1. Authors Menu
                    2. Books Menu
                    3. Exit
                    
                    Choose an option:
                    """
            );

            switch (option){
                case "1":

                    String option1 = "";
                    do{
                        option1 = JOptionPane.showInputDialog("""
                        AUTHORS MENU
                        1. List Authors
                        2. Insert Author
                        3. Update Author
                        4. Delete Coder
                        5. Exit
                        
                        Choose an option:
                        """
                        );

                        switch (option1){
                            case "1":
                                //List All Coders
                                objAuthorController.getAll();
                                break;

                            case "2" :
                                objAuthorController.create();
                                break;

                            case "3" :
                                objAuthorController.update();
                                break;

                            case "4":
                                objAuthorController.delete();
                                break;
                        }
                        }while(!option1.equals("5"));

                case "2":

                    String option2 = "";
                    do{
                        option2 = JOptionPane.showInputDialog("""
                        BOOKS MENU
                        1. List books
                        2. Insert books
                        3. Update books
                        4. Delete books
                        5. Exit
                        
                        Choose an option:
                        """
                        );

                        switch (option2){
                            case "1":
                                //List All Coders
                                objBookController.getAll();
                                break;

                            case "2" :
                                objBookController.create();
                                break;

                            case "3" :
                                objBookController.update();
                                break;

                            case "4":
                                objBookController.delete();
                                break;
                        }
                    }while(!option2.equals("5"));
                    
            }
        }while(!option.equals("3"));
    }
}