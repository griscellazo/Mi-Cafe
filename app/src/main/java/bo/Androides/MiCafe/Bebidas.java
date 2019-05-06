package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Producto;

public class Bebidas extends AppCompatActivity {

    ListView lista;

    List<Producto> productos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        lista = (ListView) findViewById(R.id.Lista1);

        llenarProductos();
        lista.setAdapter(new AdaptadorBebidas(this, productos));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesBebidas.class);
                Producto producto = productos.get(position);
                visorDetalles.putExtra("TIT", producto.getNombre());
                visorDetalles.putExtra("DET", producto.getDetalle());
                startActivity(visorDetalles);
            }
        });
    }

    private void llenarProductos() {
        productos.add(new Producto(1,
                "Frutal 500",
                "Es un jugo delicioso y refrescante de frutas naturales.",
                5.00,
                R.drawable.frutal_500ml));
        productos.add(new Producto(2,
                "Frutal 1lt",
                "Es un jugo delicioso y refrescante de frutas naturales.",
                13.50,
                R.drawable.frutal_500ml));
    }
}
