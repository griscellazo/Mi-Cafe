package bo.Androides.MiCafe;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Spinner;

import bo.Androides.MiCafe.model.Pedido;

public class VerPedido extends AppCompatActivity {

    ListView lista;

    private Context context;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @RequiresApi (api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido);
        context = this;

        /*
        lista = (ListView) findViewById(R.id.Lista1);

        lista.setAdapter(new AdaptadorBebidas(this,datos,datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesBebidas.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][1]);
                startActivity(visorDetalles);
            }
        });
        */



    }

    public void pedidoRealizado(View view) {
        Intent intent = new Intent(this, DeseaAñadirAlgoMas.class);
            startActivity(intent);

    }
}


