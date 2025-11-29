package br.ufrn.tads.controllers;

import java.io.IOException;

import br.ufrn.tads.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import br.ufrn.tads.model.*;
import br.ufrn.tads.servicy.InterfaceLogin;
import br.ufrn.tads.servicy.imp.Login;
public class registroController {

    private InterfaceLogin loginReq = new Login();
    User user = null;
    @FXML
    private Text jaExiste;

    @FXML
    private Text tamanhoMin;

    @FXML
    private Text preenchaTodos;

    @FXML
    private Text ajuda_click;

    @FXML
    private TextField email_campus;

    @FXML
    private TextField login_campus;

    @FXML
    private Text login_click;

    @FXML
    private PasswordField pass_campus;

    @FXML
    private Button registro_btn;

    @FXML
    void ajuda_screen(MouseEvent event) {

    }


    @FXML
    void login_page(MouseEvent event) throws IOException{
        App.setRoot("login");
    }


    @FXML
    void registrar(ActionEvent event) {
        if(!pass_campus.getText().isBlank() 
            && !login_campus.getText().isBlank() 
            && !email_campus.getText().isBlank()){
                try {
                    user = new User(login_campus.getText(),
                        pass_campus.getText(),
                        email_campus.getText(),
                        0,
                        0,
                        0,
                        0,
                        0,
                    0,
                        0,
                        0,
                        0,
                        0,
                        0);

                    //Mandando infos para classe concreta login do packge servico
                    //lembrando que view -> controller -> sevicy -> dao
                    loginReq.registerRequest(user);

                    try {
                        App.setRoot("login");
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                    preenchaTodos.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    tamanhoMin.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    jaExiste.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    jaExiste.getStyleClass().add("Error-invisible");
                    preenchaTodos.getStyleClass().add("Error-invisible");
                    tamanhoMin.getStyleClass().add("Error-visible");

                }catch(IllegalArgumentException e){
                    preenchaTodos.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    tamanhoMin.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    jaExiste.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    preenchaTodos.getStyleClass().add("Error-invisible");
                    tamanhoMin.getStyleClass().add("Error-invisible");
                    jaExiste.getStyleClass().add("Error-visible");
                }


        }else{
            System.out.println("Preencha Todos os campos");
                    preenchaTodos.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    tamanhoMin.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    jaExiste.getStyleClass().removeAll(
                        "Error-visible",
                        "Error-invisible"
                    );
                    jaExiste.getStyleClass().add("Error-invisible");
                    tamanhoMin.getStyleClass().add("Error-invisible");
                    preenchaTodos.getStyleClass().add("Error-visible");
        }
        
    }

}
