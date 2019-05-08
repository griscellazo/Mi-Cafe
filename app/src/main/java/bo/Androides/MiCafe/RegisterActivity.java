package bo.Androides.MiCafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.Expose;


import com.google.gson.Gson;

import bo.Androides.MiCafe.db.DatabaseHelper;
import bo.Androides.MiCafe.model.User;


public class RegisterActivity extends AppCompatActivity {

    private EditText nombreEditText;

    private TextView txtEmail;
    private EditText mailEditText;

    private EditText passwordEditText;

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombreEditText = findViewById(R.id.etRegNombre);
        mailEditText = findViewById(R.id.etCorreo);
        passwordEditText = findViewById(R.id.etContraseña);
        registerButton = findViewById(R.id.btnRegistrarse);


        registerButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm(view);
            }
        });
        getDataFromIntent();
    }

    private void validateForm(View v){
        if (nombreEditText.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su nombre por favor", Toast.LENGTH_SHORT).show();
            return;
        }

        if (passwordEditText.getText().toString().isEmpty()) {
            passwordEditText.setError("Ingrese su contraseña por favor");
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mailEditText.getText().toString()).matches()) {

            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

            //Titulo
            dialogo.setTitle("Email invalido");

            //Mensaje
            dialogo.setMessage("Ingrese un email valido por favor");

            //Icono
            dialogo.setIcon(R.drawable.warning);
            dialogo.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.e("OK", "Clicked");
                }
            });
            dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.e("Cancelar", "Clicked");
                }
            });

            dialogo.setCancelable(false);
            dialogo.show();

            return;
        }

        User cliente = new User();
        cliente.setNombreUsuario(nombreEditText.getText().toString());
        cliente.setPassword(passwordEditText.getText().toString());
        cliente.setEmail(mailEditText.getText().toString());

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.insert(cliente);


        String json = new Gson().toJson(cliente);
        Log.e("UsuarioEnviado", json);

        llenarUsuario(nombreEditText.getText().toString(),
                passwordEditText.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_REGISTRAR_USUARIO, json);
        setResult(RESULT_OK, intent);
        finish();


    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String texto = intent.getStringExtra(Intent.EXTRA_TEXT);
                nombreEditText.setText(texto);
            }
        }
    }

    private void llenarUsuario (String usuario, String password){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.PREF_USUARIO, usuario);
        editor.putString(Constants.PREF_PASSWORD, password);
        editor.apply();
    }



}
