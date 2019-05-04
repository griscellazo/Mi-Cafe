package bo.Androides.MiCafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private String message;
    private Context mContext;
    //

    private EditText mUsuarioEditText;
    private EditText mPasswordEditText;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        opciones = (Spinner) findViewById(R.id.tamano);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones,android.R.layout.simple_spinner_item);

        opciones.setAdapter(adapter);


        opciones=(Spinner)findViewById(R.id.tamano1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter1);

        opciones=(Spinner)findViewById(R.id.tamano2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter2);

        opciones=(Spinner)findViewById(R.id.tamano3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter3);
        */

    }

    public void registrarClick(View view) {
        //Toast.makeText(MainActivity.this,"EL CLICK FUNCIONA", Toast.LENGTH_SHORT).show();
        //COMENTARIO
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /*
    @Override
    public void onClick(View view) {
        String usuario = mUsuarioEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        Log.e("Mis datos", usuario + " " + password);

        if (validarUsuario(usuario, password)) {
            Intent intent = new Intent(mContext, ListaActivity.class);
            intent.putExtra(Constants1.KEY_USUARIO, usuario);
            intent.putExtra(Constants1.KEY_PASSWORD, password);
            startActivity(intent);
        } else {
            Toast.makeText(mContext, "Usuario o password invalido", Toast.LENGTH_SHORT)
                    .show();
        }
      */






    private boolean validarUsuario(String usuario, String password){
        if (usuario == null || usuario.isEmpty()){
            return false;
        }
        if (password == null || usuario.isEmpty()){
            return false;
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        String usuarioGuardado = prefs.getString(Constants.PREF_USUARIO, "");
        String passwordsGuardado = prefs.getString(Constants.KEY_PASSWORD, "");

        return usuario.equals(usuarioGuardado) && password.equals(passwordsGuardado);
    }

    public void eliminarDatos(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }



}
