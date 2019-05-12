package bo.Androides.MiCafe;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetallesPlatos extends AppCompatActivity {

    private Spinner opciones;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_platos);
        mContext = this;

        opciones = (Spinner) findViewById(R.id.elegirPlatos);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

    TextView titulo = (TextView) findViewById(R.id.titulodescripcionPlatos);
    TextView detalles = (TextView) findViewById(R.id.descripcionPlatos);

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

    public void anadidoPlatos (View view){
        Toast.makeText(this, "Añadido a su lista de pedidos", Toast.LENGTH_SHORT).show();
    }

}
