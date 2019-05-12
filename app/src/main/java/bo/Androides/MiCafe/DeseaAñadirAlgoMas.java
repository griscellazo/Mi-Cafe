package bo.Androides.MiCafe;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DeseaAñadirAlgoMas extends AppCompatActivity{

    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
    }

    public void retornarAlMenu (View view){
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }

    public void ReservarPedido (View view){
        Intent intent2 = new Intent(this, ReservarPedido.class);
        startActivity(intent2);
    }

    public void MandarPedido (View view){
        Intent intent3 = new Intent(this, MandarPedido.class);
        startActivity(intent3);
    }

    public void eliminarDatos (View view){
        Intent intent4 = new Intent(this, MenuPrincipal.class);
        startActivity(intent4);
    }









}
