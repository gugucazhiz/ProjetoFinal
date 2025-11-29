package br.ufrn.tads.controllers;

import java.io.IOException;
import java.util.Optional;

import br.ufrn.tads.App;
import br.ufrn.tads.model.User;
import br.ufrn.tads.servicy.imp.Login;
import br.ufrn.tads.servicy.imp.QuestoesServicy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;

public class AjudaController{
    User user1;
    User user;
    QuestoesServicy qs = new QuestoesServicy();
    public void initialize() {
        atualizarTelaNota();

        
        nomeUser.setText(user.getName());
        user_info.setText(user.getName());
        email_info.setText(user.getEmail());
    }
    @FXML
    private Button buttonDeletarTudo;
    
    @FXML
    private Text acertos_humanas;

    @FXML
    private Text acertos_linguagem;

    @FXML
    private Text acertos_mat;

    @FXML
    private Text acertos_nat;

    @FXML
    private Text acertos_totais;

    @FXML
    private Button btn_ajuda;

    @FXML
    private Button btn_calendario;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_provas;

    @FXML
    private Button btn_questoes;

    @FXML
    private Text email_info;

    @FXML
    private Text erros_humanas;

    @FXML
    private Text erros_linguagem;

    @FXML
    private Text erros_mat;

    @FXML
    private Text erros_nat;

    @FXML
    private Text erros_totais;

    @FXML
    private Text nomeUser;

    @FXML
    private Text user_info;

    @FXML
    void ajuda_screen(ActionEvent event) throws IOException{
        App.setRoot("ajuda_configScreen");
    }

    @FXML
    void calendario__screen(ActionEvent event) throws IOException{
        App.setRoot("calendarioScreen");
    }

    @FXML
    void menu_screen(ActionEvent event) throws IOException{
        App.setRoot("menuScreen");
    }

    @FXML
    void prova_screen(ActionEvent event) throws IOException{
        App.setRoot("provaScreen");
    }

    @FXML
    void questoes_screen(ActionEvent event) throws IOException{
        App.setRoot("questoesScreen");
    }

    @FXML
    void apagar(ActionEvent event){
        showConfirmationDialog();
    }

    //  @FXML
    // void apagarDiario(ActionEvent event){
    //     showConfirmationDialogDiario();
    // }

    

    private void showConfirmationDialog() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Deletar Historico");
        alert.setHeaderText("Deseja Apagar todo o historico?");
        alert.setContentText("Ao clicar em OK, a ação será executada.");

        // Mostra o diálogo e aguarda a resposta do usuário
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
                qs.apagarHistoricoDeQuestoes(user.getId());
                atualizarTelaNota();
        } else {
            System.out.println("cancelou");
            }
    }

    // private void showConfirmationDialogDiario() {
    //     Alert alert = new Alert(AlertType.CONFIRMATION);
    //     alert.setTitle("Deletar Historico Diario");
    //     alert.setHeaderText("Deseja Apagar somente o historico Diario?");
    //     alert.setContentText("Ao clicar em OK, a ação será executada.");

    //     // Mostra o diálogo e aguarda a resposta do usuário
    //     Optional<ButtonType> result = alert.showAndWait();

    //     if (result.isPresent() && result.get() == ButtonType.OK) {
    //             qs.apagarHistoricoDiario(user.getId());
    //             atualizarTelaNota();
    //     } else {
    //         System.out.println("cancelou");
    //         }
    // }
    public void atualizarTelaNota(){
        user1 = Login.getUserAtual();
        user = qs.getAcertosUser(user1.getName());
        acertos_totais.setText(Integer.toString(user.getQuest_certas()));
        acertos_humanas.setText(Integer.toString(user.getAcertos_humanas()));
        acertos_linguagem.setText(Integer.toString(user.getAcertos_linguagem()));
        acertos_mat.setText(Integer.toString(user.getAcertos_mat()));
        acertos_nat.setText(Integer.toString(user.getAcertos_nat()));

        erros_totais.setText(Integer.toString(user.getQuest_erradas()));
        erros_humanas.setText(Integer.toString(user.getErros_humanas()));
        erros_linguagem.setText(Integer.toString(user.getErros_linguagem()));
        erros_mat.setText(Integer.toString(user.getErros_mat()));
        erros_nat.setText(Integer.toString(user.getErros_nat()));
    }
}
