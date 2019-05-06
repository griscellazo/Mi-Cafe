package bo.Androides.MiCafe;

import android.content.Intent;
import android.os.Build;

import android.support.annotation.RequiresApi;

import android.support.v7.widget.Toolbar;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuPrincipal extends AppCompatActivity {

    private Toolbar toolbar; // Usaremos un toolbar personalizado, para agregar el icono del Drawer a la izquierda
    private ActionBarDrawerToggle drawerToggle; // El objeto del botón del drawer
    private DrawerLayout drawerLayout; // Nuestro DrawerLayout

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void bebidasClick (View view){
        Intent intent = new Intent(this, Bebidas.class);
        startActivity(intent);
    }

    public void platosALaCartaClick (View view){
        Intent intent2 = new Intent(this,PlatosALaCarta.class);
        startActivity(intent2);
    }

    public void snackYDulcesClick (View view){
        Intent intent3 = new Intent(this, SnackYDulces.class);
        startActivity(intent3);
    }
}
