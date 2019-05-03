package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class ListaBebidas extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"Frutal", "Es un jugo delicioso y refrescante de frutas naturales."},
            {"Coca Cola", "Es una sabrosa gaseosa para compartir en familia."},
            {"Agua", "Sano y refrescante"},
            {"Fanta", "Es una sabrosa gaseosa para compartir en familia."},
            {"Jugo de Uva", "Refrescante y delicioso."},
            {"Jugo de Piña", "Refrescante y delicioso."},
            {"Jugo de Sandia", "Refrescante y delicioso."},
            {"Jugo de Manzana", "Refrescante y delicioso."}

    };

    int [] datosImg = {R.drawable.frutal_500ml, R.drawable.coca_500ml, R.drawable.agua, R.drawable.fanta_500ml,R.drawable.jugo_de_uva,R.drawable.jugo_de_pina,R.drawable.jugo_de_sandia,R.drawable.jugo_de_manzana};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);


        lista = (ListView) findViewById(R.id.Lista1);

        lista.setAdapter(new AdaptadorBebidas(this,datos,datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesBebidas.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][1]);
                startActivity(visorDetalles);
            }
        });



    }
}
