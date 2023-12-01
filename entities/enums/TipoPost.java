package entities.enums;

public enum TipoPost {
    
    POST("post"),
    REELS("reels");

    private String tipo;

    TipoPost(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
