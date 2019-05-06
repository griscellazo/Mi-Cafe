package bo.Androides.MiCafe;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
public class PlatosALaCarta extends AppCompatActivity {
    ListView lista;
    String[][] datos = {
            {"Alitas", "20 Bs.", "Plato con deliciosas alitas y papas"},
            {"Asado a la olla", "18 Bs.", "Asado a la olla, con un delicioso arroz, acompañado de papas"},
            {"Hamburguesa con papas", "15 Bs.", "Deliciosa hamburguesa compañado de papas y deliciosas sslsas"},
            {"Lasagna","20 Bs.", "Es una sabrosa gaseosa para compartir en familia."},
            {"Nuggets", "20 Bs.","Deliciosos nuggets acompañados de papas y su deliciosa salsa"},
            {"Papas a la huancaina","18 Bs.", "Delicioso plato."},
            {"Pollo a la plancha", "18 Bs.","Deliciosa carne acompañado de papas"}
    };
    int [] datosImg = {R.drawable.alitas, R.drawable.asado_a_la_olla, R.drawable.hamburguesa, R.drawable.lasagna,R.drawable.nuggets,R.drawable.papas_a_la_huancaina,R.drawable.pollo_a_la_plancha};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_ala_carta);
        lista = (ListView) findViewById(R.id.Lista2);
        lista.setAdapter(new AdaptadorPlatos(this,datos,datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesBebidas.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][2]);
                startActivity(visorDetalles);
            }
        });
    }
}