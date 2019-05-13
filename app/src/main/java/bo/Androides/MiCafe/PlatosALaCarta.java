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

public class PlatosALaCarta extends AppCompatActivity {

    ListView lista;

    List<Producto> productos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos_ala_carta);

        lista = (ListView) findViewById(R.id.Lista2);

        llenarProductos();
        lista.setAdapter(new AdaptadorPlatos(this, productos));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetallesPlatos = new Intent(view.getContext(), DetallesPlatos.class);
                Producto producto = productos.get(position);
                visorDetallesPlatos.putExtra("TITULO", producto.getNombre());
                visorDetallesPlatos.putExtra("DETALLE", producto.getDetalle());
                visorDetallesPlatos.putExtra("PRECIO", producto.getPrecio());
                visorDetallesPlatos.putExtra("IMAGEN",producto.getImagen());

                startActivityForResult(visorDetallesPlatos, Constants.CODIGO_TRANSACCION_PRODUCTO);
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

    private void llenarProductos () {
                productos.add(new Producto(1,
                        "Alitas",
                        "Plato con deliciosas alitas y papas",
                        20,
                        R.drawable.alitas));
                productos.add(new Producto(2,
                        "Asado a la olla",
                        "Estofado de carne acompañado con arroz y papas cocidas",
                        18,
                        R.drawable.asado_a_la_olla));
                productos.add(new Producto(3,
                        "Hamburguesa",
                        "Hamburguesa de carne de res acompañada con queso y ensalada; aparte vienen papas fritas",
                        15,
                        R.drawable.hamburguesa));
                productos.add(new Producto(4,
                        "Lasagna",
                        "Hojas de pasta italiana con salsa bechamel y bolognesa",
                        20,
                        R.drawable.lasagna));
                productos.add(new Producto(5,
                        "Nuggets",
                        "Nuggets acompañados de papas y salsa golf",
                        20,
                        R.drawable.nuggets));
                productos.add(new Producto(6,
                        "Papas a la huancaina",
                        "Papas servida con la autentica salsa peruana a la huancaina",
                        18,
                        R.drawable.papas_a_la_huancaina));
                productos.add(new Producto(7,
                        "Pollo a la plancha",
                        "Pollo cocido en sarten con un minimo de aceite servido con papas y arroz",
                        18,
                        R.drawable.pollo_a_la_plancha));

            }

        }

