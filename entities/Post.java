package entities;

public class Post {
    
    private static Integer nextId = 1;
    private Integer id;
    private String autor;
    private String conteudo;
    private String legenda;
    private Boolean curtidas;
    private Boolean compartilhar;
    private Boolean interesse;

    public Post() {
    }

    public Post(Integer id, String autor, String conteudo, String legenda, Boolean curtidas, Boolean compartilhar,
            Boolean interesse) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.legenda = legenda;
        this.curtidas = curtidas;
        this.compartilhar = compartilhar;
        this.interesse = interesse;
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
    public String getLegenda() {
        return legenda;
    }
    public void setLegenda(String legenda) {
        this.legenda = legenda;
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

    
}
