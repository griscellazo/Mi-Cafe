package bo.Androides.MiCafe;

import android.content.Context;
import android.content.Intent;
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
    private static final String LOG = RegisterActivity.class.getName();
    private Context mContext;

    private LinearLayout padre;

    private TextView txtUsuario;
    private EditText usuario;

    private TextView txtPassword;
    private EditText password;

    private TextView txtEmail;
    private EditText email;

    private LinearLayout botones;
    private Button enviar;
    private Button limpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        */
        super.onCreate(savedInstanceState);
        Log.w(LOG, "onCreate");

        mContext = this;

        //Padre
        padre = new LinearLayout(mContext);
        padre.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, //Width
                ViewGroup.LayoutParams.MATCH_PARENT)); //Height
        padre.setOrientation(LinearLayout.VERTICAL);
        padre.setPadding(25, 25, 25, 25);
        //padre.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));


        //Usuario
        txtUsuario = new TextView(mContext);
        txtUsuario.setText("Ingrese su usuario");
        txtUsuario.setTextSize(26);
        padre.addView(txtUsuario);

        usuario = new EditText(mContext);
        padre.addView(usuario);

        //Password
        txtPassword = new TextView(mContext);
        txtPassword.setTextSize(26);
        txtPassword.setText("Ingrese su password");
        padre.addView(txtPassword);

        password = new EditText(mContext);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        padre.addView(password);

        //Email
        txtEmail = new TextView(mContext);
        txtEmail.setTextSize(26);
        txtEmail.setText("Ingrese su email");
        padre.addView(txtEmail);

        email = new EditText(mContext);
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        padre.addView(email);

        enviar = new Button(mContext);
        enviar.setText("Enviar Datos");
        enviar.setLayoutParams(new LinearLayout.LayoutParams(
                0, //Width
                ViewGroup.LayoutParams.MATCH_PARENT,
                1)); //Height
        botones.addView(enviar);

        setContentView(padre);


    }






}
