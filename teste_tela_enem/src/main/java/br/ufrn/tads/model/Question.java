package br.ufrn.tads.model;

import java.util.List;

public class Question {
    public String title;
    public int index;
    public String discipline;
    public String language;
    public int year;
    public String context;
    public List<String> files;
    public String correctAlternative;
    public List<Alternative> alternatives;
    public List<String> topicos;
}
