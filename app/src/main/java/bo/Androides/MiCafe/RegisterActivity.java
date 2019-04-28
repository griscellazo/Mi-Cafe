package bo.Androides.MiCafe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText nombreEditText;
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


    }

    public void registrar() {

    }

}
