package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SnackYDulces extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"Club Social ", "Deliciosa y crujientes galletas "},
            {"Doritos", "Deliciosos y crujientes chips de distintos sabores "},
            {"Alexander Cookie", "Deliciosa galleta, de la mejor cafeteria de La Paz "},
            {"Lays ", "Es una sabrosa gaseosa para compartir en familia."},
            {"Oreo", "Deliciosa galleta con relleno blanco"},


    };

    int [] datosImg = {R.drawable.club_social, R.drawable.doritos, R.drawable.galletas_alexander, R.drawable.lays,R.drawable.oreo};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_ydulces);


        lista = (ListView) findViewById(R.id.Lista3);

        lista.setAdapter(new AdaptadorSnackYDulces(this,datos,datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetalleSnackYDulces.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][1]);
                startActivity(visorDetalles);
            }
        });



    }
}