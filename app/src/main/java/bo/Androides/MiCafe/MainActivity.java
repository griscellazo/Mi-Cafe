package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
    }

    public void registrarClick(View view) {
        Toast.makeText(MainActivity.this,"EL CLICK FUNCIONA", Toast.LENGTH_SHORT).show();
      //  Intent intent = new Intent(mContext, RegisterActivity.class);

    }
}
