package br.ufrn.tads.servicy.imp;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.tads.model.Question;
import br.ufrn.tads.model.User;
import br.ufrn.tads.model.UserDailyStats;
import br.ufrn.tads.repository.imp.QuestionsDao;
import br.ufrn.tads.repository.imp.UserDao;

public class QuestoesServicy {
    private List<Question> questoes= new ArrayList<>();
    private User user;
    private UserDao userdao = new UserDao();
    private QuestionsDao questionsDao = new QuestionsDao();
    private Question question = null;
    private int acertos_humanas;
    private int erros_humanas;
    private int acertos_linguagem;
    private int erros_linguagem;
    private int acertos_mat;
    private int erros_mat;
    private int acertos_nat;
    private int erros_nat;
    private boolean flagDoAcerto = false;
    public QuestoesServicy(){
    }

    public List<Question> catchQuestoes(){
        try {
            for(int i =1; i<10;i++){
                question = questionsDao.findById((long)i);
                System.out.println(question);
                questoes.add(question);  
            }   
            return questoes;

        } catch (NullPointerException e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return null;
    }

    public List<Question> catchQuestoesPortema(String temaAtual){
        try {
            if(temaAtual.equals("linguagens")){
                for(int i =1; i<46;i++){
                                question = questionsDao.findByTema(temaAtual,(long)i);
                                System.out.println(question);
                                if(question!= null){
                                    questoes.add(question);  
                                }
                                
                            }
            }
            else if(temaAtual.equals("ciencias-humanas")){
                for(int i =45; i<91;i++){
                                question = questionsDao.findByTema(temaAtual,(long)i);
                                System.out.println(question);
                                if(question!= null){
                                    questoes.add(question);  
                                }
                                
                            }
            }
            else if(temaAtual.equals("ciencias-natureza")){
                for(int i =90; i<136;i++){
                                question = questionsDao.findByTema(temaAtual,(long)i);
                                System.out.println(question);
                                if(question!= null){
                                    questoes.add(question);  
                                }
                                
                            }
            }
            else if(temaAtual.equals("matematica")){
                for(int i =135; i<181;i++){
                                question = questionsDao.findByTema(temaAtual,(long)i);
                                System.out.println(question);
                                if(question!= null){
                                    questoes.add(question);  
                                }
                                
                            }
            }               
            return questoes;

        } catch (NullPointerException e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return null;
    }

    public void contagemDequestoes(List<Question> questoes){
        int i = 0;
        for(Question q:questoes){
            flagDoAcerto = false;
            if(q.isAcertouOuNao()){
                i++;
                flagDoAcerto= true;
                verificadorDeAcerto(q);
            }
            else{
                flagDoAcerto = false;
                verificadorDeAcerto(q);
            }
        }
        //setando acertos e erros
        user = Login.getUserAtual();
        user.setQuest_certas(i);
        user.setQuest_erradas(questoes.size()-i);
        user.setQuest_feitas(questoes.size());
        //acertos
        user.setAcertos_humanas(acertos_humanas);
        user.setAcertos_linguagem(acertos_linguagem);
        user.setAcertos_mat(acertos_mat);
        user.setAcertos_nat(acertos_nat);
        //erros
        user.setErros_humanas(erros_humanas);
        user.setErros_linguagem(erros_linguagem);
        user.setErros_mat(erros_mat);
        user.setErros_nat(erros_nat);


        //enviando para banco
        userdao.update(user, null);
        userdao.salvarEstatisticaDiaria(user);
        System.out.println("salvou :"+user.getAcertos_linguagem());
        System.out.println("Acertos = "+i);
        System.out.println("Questoes erradas = "+ (questoes.size()-i));
        System.out.println("Questoes feitas total = "+(questoes.size()));
    }
    
    public void verificadorDeAcerto(Question q){
        if (flagDoAcerto){
            switch (q.getDiscipline()) {
                        case "ciencias-natureza":
                            acertos_nat+= 1;
                            break;
                        case "matematica":
                            acertos_mat+= 1;
                            break;
                        case "linguagens":
                            acertos_linguagem+= 1;
                            break;
                        case "ciencias-humanas":
                            acertos_humanas+= 1;
                            break;    
                        default:
                            break;
                    }
            }
        else{
            switch (q.getDiscipline()) {
                        case "ciencias-natureza":
                            erros_nat+= 1;
                            break;
                        case "matematica":
                            erros_mat+= 1;
                            break;
                        case "linguagens":
                            erros_linguagem+= 1;
                            break;
                        case "ciencias-humanas":
                            erros_humanas+= 1;
                            break;    
                        default:
                            break;
                    }
            }
    }

    public User getAcertosUser(String name){
        User user = userdao.findByName(name);
        System.out.println("carrego :"+user.getAcertos_linguagem());
        return user;
    }

    public List<UserDailyStats> getInformacoesDeAcertoseErrosDiarios(User t){
        return userdao.getEstatisticaDiaria(t.getId());
    }


    public void apagarHistoricoDeQuestoes(Long id){
        userdao.delete(id);
        userdao.deleteDaily(id);
    }

    public void apagarHistoricoDiario(Long id){
        userdao.deleteDaily(id);
    }
}
