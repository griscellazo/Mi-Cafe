package bo.Androides.MiCafe;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ReservarPedido extends AppCompatActivity {


    @RequiresApi (api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        int numero;
        numero = (int) (Math.random() * 30) + 1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservarpedido);
        textViewDescripcionDeTuPedido();

    }



    public void textViewDescripcionDeTuPedido (){
        int numero = (int) (Math.random() * 30) + 1;
        TextView texto = (TextView)findViewById(R.id.textViewDescripcionDeTuPedido);
        String miTexto = ("Su pedido estará en breve, por favor espere en la mesa: " + numero);
        texto.setText(miTexto);
    }

}
