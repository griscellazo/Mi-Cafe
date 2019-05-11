package bo.Androides.MiCafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ElementoListaSnackYDulces extends AppCompatActivity {

    private Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento_lista_snack_ydulces);
        opciones = (Spinner) findViewById(R.id.elegirSnack);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }
}
