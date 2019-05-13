package bo.Androides.MiCafe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Producto;

public class SnackYDulces extends AppCompatActivity {

    ListView lista;

    List<Producto> productos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_ydulces);


        lista = (ListView) findViewById(R.id.Lista3);
        llenarProductosSnack();

        lista.setAdapter(new AdaptadorSnackYDulces(this, productos));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetallesSnack = new Intent(view.getContext(), DetalleSnackYDulces.class);
                Producto producto = productos.get(position);
                visorDetallesSnack.putExtra("TITULO", producto.getNombre());
                visorDetallesSnack.putExtra("DETALLE", producto.getDetalle());
                visorDetallesSnack.putExtra("PRECIO", producto.getPrecio());
                visorDetallesSnack.putExtra("IMAGEN",producto.getImagen());

                //startActivity(visorDetalles);
                startActivityForResult(visorDetallesSnack,Constants.CODIGO_TRANSACCION_PRODUCTO);
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

                    Producto producto = new Gson().fromJson(json, Producto.class);
                    //   nombreProducto.setText(producto.getNombre());

                }
            }
        }
    }




    private void llenarProductosSnack(){
        productos.add(new Producto(1,
                "Club Social",
                "Deliciosa y crujientes galletas ",
                2,
                R.drawable.club_social));
        productos.add((new Producto( 2,
                "Doritos",
                "Deliciosos y crujientes chips de distintos sabores ",
                5,
                R.drawable.doritos)));
        productos.add(new Producto(3,
                "Alexander Cookie",
                "Deliciosa galleta, de la mejor cafeteria de La Paz ",
                7,
                R.drawable.galletas_alexander));
        productos.add((new Producto( 4,
                "Lays",
                "Sabrosas papas fritas para compartir ",
                5,
                R.drawable.lays)));
        productos.add((new Producto( 5,
                "Oreo",
                "Deliciosa galleta de chocolate con relleno sabor leche",
                2,
                R.drawable.oreo)));
        productos.add((new Producto(6,
                "Sandwich de jamon y queso",
                "Delicioso pan marraqueta con jamon y queso",
                6,
                R.drawable.jamon_y_queso)));
        productos.add((new Producto(7,
                "Sandwich de palta",
                "Delicioso pan marraqueta con palta y tomate",
                5,
                R.drawable.palta)));
        productos.add((new Producto(8,
                "Croissant",
                "Delicioso croissant relleno de jamon y queso",
                6,
                R.drawable.croissant)));
    }
}