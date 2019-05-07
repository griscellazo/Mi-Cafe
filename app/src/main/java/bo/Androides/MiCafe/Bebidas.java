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
                visorDetalles.putExtra("TITULO", producto.getNombre());
                visorDetalles.putExtra("DETALLE", producto.getDetalle());
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
                "Frutal 2lt",
                "Es un jugo delicioso y refrescante de frutas naturales.",
                13.50,
                R.drawable.frutal_500ml));
        productos.add(new Producto(3,
                "Coca Cola Personal ",
                "Es una sabrosa gaseosa para compartir en familia.",
                2.00,
                R.drawable.coca_500ml));
        productos.add(new Producto(4,
                "Coca Cola 500ml",
                "Es una sabrosa gaseosa para compartir en familia.",
                5.00,
                R.drawable.coca_500ml));
        productos.add(new Producto(5,
                "Coca Cola  2lt",
                "Es una sabrosa gaseosa para compartir en familia.",
                10.50,
                R.drawable.coca_500ml));
        productos.add(new Producto(6,
                "Fanta Personal",
                "Es una sabrosa gaseosa y muy refrescante",
                2.00,
                R.drawable.fanta_500ml));
        productos.add(new Producto(7,
                "Fanta 500ml",
                "Es una sabrosa gaseosa y muy refrescante",
                5.00,
                R.drawable.fanta_500ml));
        productos.add(new Producto(8,
                "Fanta 2lt",
                "Es una sabrosa gaseosa y muy refrescante",
                10.50,
                R.drawable.fanta_500ml));
        productos.add(new Producto(9,
                "Agua 500 ml",
                "Deliciosa agua natural y refrescante",
                4.50,
                R.drawable.agua));
        productos.add(new Producto(10,
                "Agua 1lt",
                "Deliciosa agua natural y refrescante",
                6.50,
                R.drawable.agua));
        productos.add(new Producto(11,
                "Agua 2lt",
                "Deliciosa agua natural y refrescante",
                8.00,
                R.drawable.agua));
        productos.add(new Producto(12,
                "Jugo de manzana ",
                "Delicioso jugo natural",
                5.00,
                R.drawable.jugo_de_manzana));
        productos.add(new Producto(13,
                "Jugo de piña ",
                "Delicioso jugo natural",
                5.00,
                R.drawable.jugo_de_pina));
        productos.add(new Producto(14,
                "Jugo de sandia ",
                "Delicioso jugo natural",
                5.00,
                R.drawable.jugo_de_sandia));
        productos.add(new Producto(15,
                "Jugo de uva ",
                "Delicioso jugo natural",
                5.00,
                R.drawable.jugo_de_uva));
    }
}
