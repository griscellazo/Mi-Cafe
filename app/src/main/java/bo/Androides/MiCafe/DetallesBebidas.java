package bo.Androides.MiCafe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import bo.Androides.MiCafe.db.DatabaseHelper;
import bo.Androides.MiCafe.model.Pedido;
import bo.Androides.MiCafe.model.Producto;
import bo.Androides.MiCafe.model.User;

public class DetallesBebidas extends AppCompatActivity {

    private Spinner opciones;

    private Context mContext;
    private DatabaseHelper dbHelper;

    private TextView nombreProducto;
    private Double precioProducto;

    private double precio;
    private int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_bebidas);
        this.mContext = this;
        dbHelper = new DatabaseHelper(this.mContext);

        nombreProducto = findViewById(R.id.titulodescripcionBebidas);
       // precioProducto

        opciones = (Spinner) findViewById(R.id.elegirBebidas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        // id = (TextView) findViewById(R.id.idBebidas) ;
        TextView nombre = (TextView) findViewById(R.id.titulodescripcionBebidas);
        TextView detalle = (TextView) findViewById(R.id.descripcionBebidas);
        TextView precio = (TextView) findViewById(R.id.precioBebidas);
        ImageView imagen = (ImageView) findViewById(R.id.imagenBebidas);


        Intent intent = getIntent();
        Bundle b = ((Intent) intent).getExtras();

        if (b!=null){
         //   Producto producto = new Producto(id, nombre, detalle, precio, imagen);
            nombre.setText(b.getString("TIT"));
            detalle.setText(b.getString("DET"));
          //  precio.setText(String.valueOf(producto.getPrecio()));

            imagen.setImageResource(b.getInt("IMG"));
        }
    }



    public void anadidoBebidas (View view){
        Toast.makeText(this, "Añadido a su lista de pedidos", Toast.LENGTH_SHORT).show();

        Pedido carrito = new Pedido();
        carrito.setProducto(nombreProducto.getText().toString());
    //    carrito.setProducto(precioProducto.getText().toString());
        /*
        carrito.setPrecio(precio);
        carrito.setCantidad(cantidad);
        */
        dbHelper.agregarAlCarrito(carrito);

        String json = new Gson().toJson(carrito);
        Log.e("Pedido enviado", json);

     //   llenarPedido(nombreProducto.getText().toString(),precioProducto.getText().toString());
        llenarPedido(nombreProducto.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_REGISTRAR_PEDIDO, json);
        setResult(RESULT_OK, intent);
        finish();
    }




    public void verpedidoBebidas (View view){

        String nombrePedido = nombreProducto.getText().toString();
        Log.e("Mis datos", nombrePedido );

        Toast.makeText(mContext, "Pedido incorrecto", Toast.LENGTH_SHORT)
                .show();
        /*
        Intent intent9 = new Intent (this,VerPedido.class);
        startActivity(intent9);*/

        if (validarPedido(nombrePedido)){
            Intent intent3 = new Intent(this, VerPedido.class);
            intent3.putExtra(Constants.KEY_NOMBRE_PEDIDO, nombrePedido);
            startActivity(intent3);
        } else {
            Toast.makeText(mContext, "Pedido incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    private void llenarPedido (String nombrePedido){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constants.PREF_PEDIDO, nombrePedido);
       // editor.putString(Constants.PREF_PRECIO, precioBebida);
        editor.apply();
    }


    private boolean validarPedido(String nombrePedido){
        if (nombrePedido == null ){
            return false;
        }
        return true;
    }



}
