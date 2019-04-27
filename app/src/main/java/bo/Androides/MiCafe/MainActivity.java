package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private String message;
    private Context mContext;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarClick(View view) {
        //Toast.makeText(MainActivity.this,"EL CLICK FUNCIONA", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
