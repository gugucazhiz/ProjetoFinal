package br.ufrn.tads.model;

public class User {
    private Long id;
    private String name;
    private String senha;
    private String email;
	private int quest_feitas;
	private int quest_certas;
	private int quest_erradas;
    private int acertos_humanas;
    private int erros_humanas;
    private int acertos_linguagem;
    private int erros_linguagem;
    private int acertos_mat;
    private int erros_mat;
    private int acertos_nat;
    private int erros_nat;

    public User(){
        
    }

    public User(String name,
                String senha,
                String email,
	            int quest_feitas,
                int quest_certas,
	            int quest_erradas,
                int acertos_humanas,
                int erros_humanas,
                int acertos_linguagem,
                int erros_linguagem,
                int acertos_mat,
                int erros_mat,
                int acertos_nat,
                int erros_nat){
    if(name.length() <= 4 || senha.length() <= 4){
        throw new IndexOutOfBoundsException("Tamanho Invalido");
    }
    this.name = name;
    this.senha = senha;
    this.email =email;
    this.quest_certas = quest_certas;
    this.quest_erradas = quest_erradas;
    this.quest_feitas =quest_feitas;
    this.acertos_humanas =acertos_humanas;
    this.erros_humanas= erros_humanas;
    this.acertos_linguagem= acertos_linguagem;
    this.erros_linguagem=erros_linguagem;
    this.acertos_mat=acertos_mat;
    this.erros_mat=erros_mat;
    this.acertos_nat=acertos_nat;
    this.erros_nat=erros_nat;
    }
    public User(Long id,
                String name,
                String senha,
                String email,
	            int quest_feitas,
                int quest_certas,
	            int quest_erradas,
                int acertos_humanas,
                int erros_humanas,
                int acertos_linguagem,
                int erros_linguagem,
                int acertos_mat,
                int erros_mat,
                int acertos_nat,
                int erros_nat){
    if(name.length() <= 4 || senha.length() <= 4){
        throw new IndexOutOfBoundsException("Tamanho Invalido");
    }
    this.id = id;
    this.name = name;
    this.senha = senha;
    this.email =email;
    this.quest_certas = quest_certas;
    this.quest_erradas = quest_erradas;
    this.quest_feitas =quest_feitas;
    this.acertos_humanas =acertos_humanas;
    this.erros_humanas= erros_humanas;
    this.acertos_linguagem= acertos_linguagem;
    this.erros_linguagem=erros_linguagem;
    this.acertos_mat=acertos_mat;
    this.erros_mat=erros_mat;
    this.acertos_nat=acertos_nat;
    this.erros_nat=erros_nat;
    }


    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuest_feitas() {
        return quest_feitas;
    }

    public void setQuest_feitas(int quest_feitas) {
        this.quest_feitas = quest_feitas;
    }

    public int getQuest_certas() {
        return quest_certas;
    }

    public void setQuest_certas(int quest_certas) {
        this.quest_certas = quest_certas;
    }

    public int getQuest_erradas() {
        return quest_erradas;
    }

    public void setQuest_erradas(int quest_erradas) {
        this.quest_erradas = quest_erradas;
    }

    public int getAcertos_humanas() {
        return acertos_humanas;
    }

    public void setAcertos_humanas(int acertos_humanas) {
        this.acertos_humanas = acertos_humanas;
    }

    public int getErros_humanas() {
        return erros_humanas;
    }

    public void setErros_humanas(int erros_humanas) {
        this.erros_humanas = erros_humanas;
    }

    public int getAcertos_linguagem() {
        return acertos_linguagem;
    }

    public void setAcertos_linguagem(int acertos_linguagem) {
        this.acertos_linguagem = acertos_linguagem;
    }

    public int getErros_linguagem() {
        return erros_linguagem;
    }

    public void setErros_linguagem(int erros_linguagem) {
        this.erros_linguagem = erros_linguagem;
    }

    public int getAcertos_mat() {
        return acertos_mat;
    }

    public void setAcertos_mat(int acertos_mat) {
        this.acertos_mat = acertos_mat;
    }

    public int getErros_mat() {
        return erros_mat;
    }

    public void setErros_mat(int erros_mat) {
        this.erros_mat = erros_mat;
    }

    public int getAcertos_nat() {
        return acertos_nat;
    }

    public void setAcertos_nat(int acertos_nat) {
        this.acertos_nat = acertos_nat;
    }

    public int getErros_nat() {
        return erros_nat;
    }

    public void setErros_nat(int erros_nat) {
        this.erros_nat = erros_nat;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + quest_feitas;
        result = prime * result + quest_certas;
        result = prime * result + quest_erradas;
        result = prime * result + acertos_humanas;
        result = prime * result + erros_humanas;
        result = prime * result + acertos_linguagem;
        result = prime * result + erros_linguagem;
        result = prime * result + acertos_mat;
        result = prime * result + erros_mat;
        result = prime * result + acertos_nat;
        result = prime * result + erros_nat;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (quest_feitas != other.quest_feitas)
            return false;
        if (quest_certas != other.quest_certas)
            return false;
        if (quest_erradas != other.quest_erradas)
            return false;
        if (acertos_humanas != other.acertos_humanas)
            return false;
        if (erros_humanas != other.erros_humanas)
            return false;
        if (acertos_linguagem != other.acertos_linguagem)
            return false;
        if (erros_linguagem != other.erros_linguagem)
            return false;
        if (acertos_mat != other.acertos_mat)
            return false;
        if (erros_mat != other.erros_mat)
            return false;
        if (acertos_nat != other.acertos_nat)
            return false;
        if (erros_nat != other.erros_nat)
            return false;
        return true;
    }

    
    
}
