package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Producto;
import bo.Androides.MiCafe.model.User;

public class Bebidas extends AppCompatActivity {

    ListView lista;

    List<Producto> productos = new ArrayList<>();

//    private String nombreProducto1 = "HOLA GRIS";
    private TextView nombreProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        lista = (ListView) findViewById(R.id.Lista1);
        nombreProducto = findViewById(R.id.nombreProducto);

        llenarProductos();

        lista.setAdapter(new AdaptadorBebidas(this, productos));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesBebidas.class);
                Producto producto = productos.get(position);
                visorDetalles.putExtra("TIT", producto.getNombre());
                visorDetalles.putExtra("DET", producto.getDetalle());
                visorDetalles.putExtra("PRECIO",producto.getPrecio());
            //    startActivity(visorDetalles);
                startActivityForResult(visorDetalles, Constants.CODIGO_TRANSACCION_PRODUCTO);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.CODIGO_TRANSACCION_PRODUCTO) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String json = data.getStringExtra(Constants.KEY_REGISTRAR_PEDIDO);
                    Log.e("Pedido Recibido", json);

                    Producto producto = new Gson().fromJson(json,Producto.class);
                    nombreProducto.setText(producto.getNombre());
                    /*
                    User usuarioRecibido = new Gson().fromJson(json, User.class);
                    nombreProducto.setText(usuarioRecibido.getNombreUsuario());*/
                }
            }
        }
    }



    private void llenarProductos() {
        productos.add(new Producto(1,
                "Frutal 500",
                "Es un jugo delicioso y refrescante de frutas naturales.",
                5,
                R.drawable.frutal_500ml));
        productos.add(new Producto(2,
                "Frutal 2lt",
                "Es un jugo delicioso y refrescante de frutas naturales.",
                13,
                R.drawable.frutal_500ml));
        productos.add(new Producto(3,
                "Coca Cola Personal ",
                "Es una sabrosa gaseosa para compartir en familia.",
                2,
                R.drawable.coca_500ml));
        productos.add(new Producto(4,
                "Coca Cola 500ml",
                "Es una sabrosa gaseosa para compartir en familia.",
                5,
                R.drawable.coca_500ml));
        productos.add(new Producto(5,
                "Coca Cola  2lt",
                "Es una sabrosa gaseosa para compartir en familia.",
                10,
                R.drawable.coca_500ml));
        productos.add(new Producto(6,
                "Fanta Personal",
                "Es una sabrosa gaseosa y muy refrescante",
                2,
                R.drawable.fanta_500ml));
        productos.add(new Producto(7,
                "Fanta 500ml",
                "Es una sabrosa gaseosa y muy refrescante",
                5,
                R.drawable.fanta_500ml));
        productos.add(new Producto(8,
                "Fanta 2lt",
                "Es una sabrosa gaseosa y muy refrescante",
                10,
                R.drawable.fanta_500ml));
        productos.add(new Producto(9,
                "Agua 500 ml",
                "Deliciosa agua natural y refrescante",
                4,
                R.drawable.agua));
        productos.add(new Producto(10,
                "Agua 1lt",
                "Deliciosa agua natural y refrescante",
                6,
                R.drawable.agua));
        productos.add(new Producto(11,
                "Agua 2lt",
                "Deliciosa agua natural y refrescante",
                8,
                R.drawable.agua));
        productos.add(new Producto(12,
                "Jugo de manzana ",
                "Delicioso jugo natural",
                5,
                R.drawable.jugo_de_manzana));
        productos.add(new Producto(13,
                "Jugo de piña ",
                "Delicioso jugo natural",
                5,
                R.drawable.jugo_de_pina));
        productos.add(new Producto(14,
                "Jugo de sandia ",
                "Delicioso jugo natural",
                5,
                R.drawable.jugo_de_sandia));
        productos.add(new Producto(15,
                "Jugo de uva ",
                "Delicioso jugo natural",
                5,
                R.drawable.jugo_de_uva));
    }
}
