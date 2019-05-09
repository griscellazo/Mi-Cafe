package bo.Androides.MiCafe;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetallesPlatos extends AppCompatActivity {

    private Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_platos);

        opciones = (Spinner) findViewById(R.id.elegir2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        TextView titulo = (TextView) findViewById(R.id.titulodescripcion2);
        TextView detalles = (TextView) findViewById(R.id.descripcion2);

        Intent intent = getIntent();
        Bundle b = ((Intent) intent).getExtras();

        if (b != null) {
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }

    public void verPedidoPlatos (View view){
        Intent intentPlatos = new Intent(this,VerPedido.class);
        startActivity(intentPlatos);
    }

    public void anadido (View view){
        Toast.makeText(this, "Añadido a su lista de pedidos", Toast.LENGTH_SHORT).show();
    }

}
