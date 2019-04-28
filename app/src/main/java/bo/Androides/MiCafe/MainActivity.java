package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String message;
    private Context mContext;
    Spinner opciones;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //opciones=(Spinner)findViewById(R.id.tamaño);

       // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
       // opciones.setAdapter(adapter);
    }

    public void registrarClick(View view) {
        Toast.makeText(MainActivity.this,"EL CLICK FUNCIONA", Toast.LENGTH_SHORT).show();
        //COMENTARIO
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
