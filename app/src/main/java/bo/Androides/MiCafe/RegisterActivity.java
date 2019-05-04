package bo.Androides.MiCafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;

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
            //email.setError("Ingrese un email valido por favor");

            //Crear una instancia de dialog
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
            dialogo.setNeutralButton("Para que?", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.e("Neutral", "Clicked");
                }
            });

            dialogo.setCancelable(false);
            dialogo.show();

            return;
        }

        User alumno = new User();
        alumno.setNombreUsuario(nombreEditText.getText().toString());
        alumno.setPassword(passwordEditText.getText().toString());

        alumno.setEmail(mailEditText.getText().toString());


        String json = new Gson().toJson(alumno);
        Log.e("UsuarioEnviado", json);

        llenarUsuario(nombreEditText.getText().toString(),
                passwordEditText.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_REGISTRAR_USUARIO, json);
        setResult(RESULT_OK, intent); //OK: funciono, intent --> retornando el valor
        finish(); //Cierra el activity


        Intent intent2 = new Intent(this, Bebidas.class);
        startActivity(intent2);



    }

    private void llenarUsuario (String usuario, String password){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.PREF_USUARIO, usuario);
        editor.putString(Constants.PREF_PASSWORD, password);
        editor.apply();
    }



}
