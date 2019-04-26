package bo.Androides.MiCafe;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

//import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String message;
    private Context mContext;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void registrarClick(View view) {
        Toast.makeText(MainActivity.this,"EL CLICK FUNCIONA", Toast.LENGTH_SHORT).show();
      //  Intent intent = new Intent(mContext, RegisterActivity.class);

        Intent intent = new Intent (this, RegisterActivity.class);

        EditText editText = (EditText) findViewById(R.id.editText);

        String message = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {

    }
}
