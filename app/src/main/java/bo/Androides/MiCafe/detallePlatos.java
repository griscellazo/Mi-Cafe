package bo.Androides.MiCafe;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class detallePlatos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_platos);
        TextView titulo = (TextView) findViewById(R.id.titulodescripcion2);
        TextView detalles = (TextView) findViewById(R.id.descripcion2);
        Intent intent = getIntent();
        Bundle b = ((Intent) intent).getExtras();
        if (b != null) {
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }
}