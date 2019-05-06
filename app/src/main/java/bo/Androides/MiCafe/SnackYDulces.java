package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Producto;

public class SnackYDulces extends AppCompatActivity {

    ListView lista;

    List<Producto> productos = new ArrayList<>();

    String[][] datos = {
            {"Club Social ", "Deliciosa y crujientes galletas "},
            {"Doritos", "Deliciosos y crujientes chips de distintos sabores "},
            {"Alexander Cookie", "Deliciosa galleta, de la mejor cafeteria de La Paz "},
            {"Lays ", "Es una sabrosa gaseosa para compartir en familia."},
            {"Oreo", "Deliciosa galleta con relleno blanco"},


    };

    int [] datosImg = {R.drawable.club_social, R.drawable.doritos, R.drawable.galletas_alexander, R.drawable.lays,R.drawable.oreo};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_ydulces);


        lista = (ListView) findViewById(R.id.Lista3);

        llenarProductos();
        lista.setAdapter(new AdaptadorSnackYDulces(this, productos));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetalleSnackYDulces.class);
                Producto producto = productos.get(position);
                visorDetalles.putExtra("TIT", producto.getNombre());
                visorDetalles.putExtra("DET", producto.getDetalle());
                startActivity(visorDetalles);
            }
        });



    }

    private void llenarProductos(){
        productos.add(new Producto(1,
                "Club Social",
                "Deliciosa y crujientes galletas ",
                2.00,
                R.drawable.club_social));
        productos.add((new Producto( 2,
                "Doritos",
                "Deliciosos y crujientes chips de distintos sabores ",
                5.00,
                R.drawable.doritos)));
        productos.add(new Producto(3,
                "Alexander Cookie",
                "Deliciosa galleta, de la mejor cafeteria de La Paz ",
                7.00,
                R.drawable.galletas_alexander));
        productos.add((new Producto( 4,
                "Lays",
                "Sabrosas papas fritas para compartir ",
                5.00,
                R.drawable.lays)));
        productos.add((new Producto( 5,
                "Oreo",
                "Deliciosa galleta de chocolate con relleno sabor leche",
                2.50,
                R.drawable.oreo)));
    }
}