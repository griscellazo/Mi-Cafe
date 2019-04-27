package bo.Androides.MiCafe;

public class EntidadesLista {

    private int imgFoto;
    private String titulo;

    public EntidadesLista(int imgFoto, String titulo){
        this.imgFoto=imgFoto;
        this.titulo=titulo;
    }

    public int getImgFoto(){return imgFoto;}
    public String getTitulo(){return titulo;}
}
