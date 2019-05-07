package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetallesBebidas extends AppCompatActivity {

    private Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_bebidas);

        opciones = (Spinner) findViewById(R.id.elegir);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        TextView titulo = (TextView) findViewById(R.id.titulodescripcion);
        TextView detalles = (TextView) findViewById(R.id.descripcion);

        Intent intent = getIntent();
        Bundle b = ((Intent) intent).getExtras();

        if (b!=null){
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }


    public void verPedido(View view){
        Intent intent1 = new Intent (this, VerPedido.class);
        startActivity(intent1);
    }

    public void anadido (View view){
        Toast.makeText(this, "Añadido a su lista de pedidos", Toast.LENGTH_SHORT).show();
    }



}
