package br.ufrn.tads.controllers;

import br.ufrn.tads.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import br.ufrn.tads.servicy.imp.Login;

import java.io.IOException;

public class QuestoesController {

    @FXML
    public void initialize() {
        nomeUser.setText(Login.getUserAtual().getName());
    }
    
    @FXML
    private Button btn_ajuda;

    @FXML
    private Button btn_calendario;

    @FXML
    private Button btn_cnt;

    @FXML
    private Button btn_lct;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_mt;

    @FXML
    private Button btn_provas;

    @FXML
    private Button btn_questoes;

    @FXML
    private Button cht;

    @FXML
    private Text nomeUser;

    @FXML
    void ajuda_screen(ActionEvent event) {

    }

    @FXML
    void calendario__screen(ActionEvent event) {

    }

    @FXML
    void cht_function(ActionEvent event)throws IOException {
        ResponderController.setProvaGeral(false);
        ResponderController.setTemaAtual("ciencias-humanas");
        App.setRoot("responderScreen");
    }

    @FXML
    void cnt_function(ActionEvent event)throws IOException {
        ResponderController.setProvaGeral(false);
        ResponderController.setTemaAtual("ciencias-natureza");
        App.setRoot("responderScreen");
    }

    @FXML
    void lct_function(ActionEvent event)throws IOException {
        ResponderController.setProvaGeral(false);
        ResponderController.setTemaAtual("linguagens");
        App.setRoot("responderScreen");
    }

    @FXML
    void menu_screen(ActionEvent event) throws IOException {
        App.setRoot("menuScreen");
    }

    @FXML
    void mt_function(ActionEvent event)throws IOException {
        ResponderController.setProvaGeral(false);
        ResponderController.setTemaAtual("matematica");
        App.setRoot("responderScreen");
    }

    @FXML
    void prova_screen(ActionEvent event) throws IOException{
        App.setRoot("provaScreen");
    }

    @FXML
    void questoes_screen(ActionEvent event) {

    }

}
