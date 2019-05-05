package bo.Androides.MiCafe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class EntidadesListaPlatos extends AppCompatActivity {
    private int imgFoto;
    private String titulo;
    public EntidadesListaPlatos(int imgFoto, String titulo){
        this.imgFoto=imgFoto;
        this.titulo=titulo;
    }
    public int getImgFoto(){return imgFoto;}
    public String getTitulo(){return titulo;}
}