package bo.Androides.MiCafe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private Context mContext;

    private LinearLayout padre;

    private TextView txtUsuario;
    private EditText usuario;

    private TextView txtContraseña;
    private EditText contraseña;

    private TextView txtEmail;
    private EditText email;

    private LinearLayout botones;
    private Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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

        //contraseña
        txtContraseña = new TextView(mContext);
        txtContraseña.setTextSize(26);
        txtContraseña.setText("Ingrese su contraseña");
        padre.addView(txtContraseña);

        contraseña = new EditText(mContext);
        contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        padre.addView(contraseña);

        //Email
        txtEmail = new TextView(mContext);
        txtEmail.setTextSize(26);
        txtEmail.setText("Ingrese su email");
        padre.addView(txtEmail);

        email = new EditText(mContext);
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        padre.addView(email);

        //Panel de botones
        botones = new LinearLayout(mContext);
        botones.setOrientation(LinearLayout.HORIZONTAL);


        enviar = new Button(mContext);
        enviar.setText(getString(R.string.enviar));
        enviar.setLayoutParams(new LinearLayout.LayoutParams(
                0, //Width
                ViewGroup.LayoutParams.MATCH_PARENT,
                1)); //Height
        botones.addView(enviar);



    }
}
