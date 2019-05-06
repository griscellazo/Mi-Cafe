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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import bo.Androides.MiCafe.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity  {
    private static final String LOG = MainActivity.class.getName();

    private String message;
    private Context mContext;


    private EditText mUsuarioEditText;
    private EditText mPasswordEditText;

    private Button mIniciarSesionButton;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(LOG, "onCreate");

        setContentView(R.layout.activity_main);
        mContext = this;

        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(LOG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(LOG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(LOG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(LOG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(LOG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w(LOG, "onRestart");
    }

    private void initViews() {
        mUsuarioEditText = findViewById(R.id.usuarioEditText);
        mPasswordEditText = findViewById(R.id.contrasenaEditText);
        mIniciarSesionButton = findViewById(R.id.Iniciar_sesion);
    }

    public void registrarClick(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void iniciarSesionClick (View view){
        String usuario = mUsuarioEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        Log.e("Mis datos", usuario + " " + password);

        if (validarUsuario(usuario, password)) {
            Intent intent2 = new Intent(mContext, MenuPrincipal.class);
            intent2.putExtra(Constants.KEY_USUARIO, usuario);
            intent2.putExtra(Constants.KEY_PASSWORD, password);
            startActivity(intent2);
        } else {
            Toast.makeText(mContext, "Usuario o password invalido", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private boolean validarUsuario(String usuario, String password){
        if (usuario == null || usuario.isEmpty()){
            return false;
        }
        if (password == null || usuario.isEmpty()){
            return false;
        }
        DatabaseHelper dbHelper = new DatabaseHelper(this.mContext);
        return dbHelper.login(usuario, password);
    }

    public void eliminarDatos(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
