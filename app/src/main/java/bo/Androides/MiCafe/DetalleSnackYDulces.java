package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleSnackYDulces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_snack_ydulces);
        TextView titulo = (TextView) findViewById(R.id.titulodescripcion3);
        TextView detalles = (TextView) findViewById(R.id.descripcion3);
        Intent intent = getIntent();
        Bundle b = ((Intent) intent).getExtras();
        if (b != null) {
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }
}