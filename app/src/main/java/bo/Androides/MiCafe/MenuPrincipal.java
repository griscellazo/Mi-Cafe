package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void bebidasClick (View view){
        Intent intent = new Intent(this, Bebidas.class);
        startActivity(intent);
    }

    public void platosALaCartaClick (View view){
        Intent intent2 = new Intent(this,PlatosALaCarta.class);
        startActivity(intent2);
    }

    public void snackYDulcesClick (View view){
        Intent intent3 = new Intent(this, SnackYDulces.class);
        startActivity(intent3);
    }
}
