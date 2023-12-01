package entities;

import java.util.Date;

public class Post {
    
    private static Integer nextId = 1;
    private Integer id;
    private String autor;
    private String conteudo;
    private Date dataDoPost;
    private Boolean curtidas;
    private Boolean compartilhar;
    private Boolean interesse;

    public Post() {
    }

    public Post(String autor, String conteudo, Date dataDoPost, Boolean curtidas, Boolean compartilhar,
            Boolean interesse) {
        this.id = nextId++;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataDoPost = dataDoPost;
        this.curtidas = curtidas;
        this.compartilhar = compartilhar;
        this.interesse = interesse;
    }

    public Integer getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataDoPost() {
        return dataDoPost;
    }

    public Boolean getCurtidas() {
        return curtidas;
    }
    public void setCurtidas(Boolean curtidas) {
        this.curtidas = curtidas;
    }
    public Boolean getCompartilhar() {
        return compartilhar;
    }
    public void setCompartilhar(Boolean compartilhar) {
        this.compartilhar = compartilhar;
    }
    public Boolean getInteresse() {
        return interesse;
    }
    public void setInteresse(Boolean interesse) {
        this.interesse = interesse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id do post: " + id + "\n");
        sb.append("Autor do post: " + autor + "\n");
        sb.append('"' + conteudo + '"' + "\n");
        sb.append("Curtir: " + (curtidas.equals(true) ? "Curtido" : "Não curtido") + "\n");
        sb.append("Compartilhar: " + (compartilhar.equals(true) ? "Compartilhado" : "Não compartilhado") + "\n");
        sb.append("Interesse: " + (interesse.equals(true) ? "Tenho interesse" : "Não tenho interesse") + "\n");
        return sb.toString();

    }
}
