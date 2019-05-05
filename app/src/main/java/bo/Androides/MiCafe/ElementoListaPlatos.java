package bo.Androides.MiCafe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
public class ElementoListaPlatos extends AppCompatActivity {
    private Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento_lista_platos);
        opciones = (Spinner) findViewById(R.id.elegir);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }
}
