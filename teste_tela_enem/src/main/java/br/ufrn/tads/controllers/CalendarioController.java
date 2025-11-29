package br.ufrn.tads.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import br.ufrn.tads.App;
import br.ufrn.tads.servicy.imp.Login;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalendarioController {

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
    private Text nomeUser;

    // cards do calendario
    @FXML
    private DatePicker dpDataAlvo;
    @FXML
    private Label lblDiasTotais;
    @FXML
    private Label lblFinaisSemana;
    @FXML
    private Label lblMeses;
    @FXML
    private Label lblHoras;
    @FXML
    private Label lblSegundos;

    private Timeline relogio;

    @FXML
    public void initialize() {

        // calendario com o dia do enem 2026
        dpDataAlvo.setValue(LocalDate.of(2026, 11, 1)); // ENEM 2026
        iniciarContagemTempoReal();

        // ouvindo se a data mudar
        dpDataAlvo.valueProperty().addListener((obs, oldVal, newVal) -> {
            atualizarPainel();
        });

        
        nomeUser.setText(Login.getUserAtual().getName());
    }

    @FXML
    void menu_screen(ActionEvent event) throws IOException {
        App.setRoot("menuScreen");
    }

    @FXML
    void prova_screen(ActionEvent event) throws IOException {
        App.setRoot("provaScreen");
    }

    @FXML
    void questoes_screen(ActionEvent event) throws IOException {
        App.setRoot("questoesScreen");
    }

    @FXML
    void calendario__screen(ActionEvent event) {

    }

    @FXML
    void ajuda_screen(ActionEvent event) throws IOException{
        App.setRoot("ajuda_configScreen");
    }


    private void iniciarContagemTempoReal() {
        relogio = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            atualizarPainel();
        }));
        relogio.setCycleCount(Timeline.INDEFINITE);
        relogio.play();
    }

    private void atualizarPainel() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDate dataAlvo = dpDataAlvo.getValue();

        if (dataAlvo == null) return;

        LocalDateTime dataAlvoHora = dataAlvo.atStartOfDay();

        // se a data ja passou
        if (dataAlvo.isBefore(hoje)) {
            if(lblDiasTotais != null) lblDiasTotais.setText("0");
            return;
        }

        // calculando o tempo com classes proprias do java vindo do java.time
        long diasTotais = ChronoUnit.DAYS.between(hoje, dataAlvo);
        long meses = ChronoUnit.MONTHS.between(hoje, dataAlvo);
        long horasTotais = ChronoUnit.HOURS.between(agora, dataAlvoHora);
        long segundosTotais = ChronoUnit.SECONDS.between(agora, dataAlvoHora);

        // atualizando os cards
        if (lblDiasTotais != null) lblDiasTotais.setText(String.valueOf(diasTotais));
        if (lblMeses != null) lblMeses.setText(String.valueOf(meses));
        if (lblHoras != null) lblHoras.setText(String.valueOf(horasTotais));
        if (lblSegundos != null) lblSegundos.setText(String.valueOf(segundosTotais));

        // loop para percorrer a data alvo (proximo enem) e pegar os fds
        long apenasFds = calcularFinaisSemana(hoje, dataAlvo);

        if (lblFinaisSemana != null) lblFinaisSemana.setText(String.valueOf(apenasFds));
    }

    private long calcularFinaisSemana(LocalDate inicio, LocalDate fim) {
        long fds = 0;
        LocalDate dataAtual = inicio;

        while (dataAtual.isBefore(fim)) {
            DayOfWeek diaSemana = dataAtual.getDayOfWeek();

            // verificando se é sabado ou domingo
            if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
                fds++;
            }

            dataAtual = dataAtual.plusDays(1);
        }
        return fds;
    }
}