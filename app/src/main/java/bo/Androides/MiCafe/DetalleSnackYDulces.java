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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import bo.Androides.MiCafe.db.DatabaseHelper;
import bo.Androides.MiCafe.model.Pedido;

public class DetalleSnackYDulces extends AppCompatActivity {

    private Spinner opciones;
    private Context mContext;
    private DatabaseHelper dbHelper;
    private TextView  nombreProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_snack_ydulces);
        this.mContext = this;
        dbHelper = new DatabaseHelper(this.mContext);

        nombreProducto = findViewById(R.id.titulodescripcionSnack);

        opciones = (Spinner) findViewById(R.id.elegirSnack);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        TextView nombre = (TextView) findViewById(R.id.titulodescripcionSnack);
        TextView detalles = (TextView) findViewById(R.id.descripcionSnack);
        TextView precio = (TextView) findViewById(R.id.precioSnack);
        ImageView imagen = (ImageView) findViewById(R.id.imagenSnack);

        Intent intent = getIntent();
        Bundle b = ((Intent) intent).getExtras();

        if (b != null) {

           nombre.setText(b.getString("TITULO"));
            detalles.setText(b.getString("DETALLE"));
            precio.setText(b.getString("PRECIO"));
            imagen.setImageResource(b.getInt("IMG"));
        }
    }

    public void verPedidoSnack (View v){

            String nombrePedido = nombreProducto.getText().toString();
            Log.e("Mis datos", nombrePedido );


            if (validarPedido(nombrePedido)){
                Intent intent3 = new Intent(this, VerPedido.class);
                //    intent3.putExtra(Constants.KEY_NOMBRE_PEDIDO, nombrePedido);
                startActivity(intent3);
                //   startActivityForResult(intent3, Constants.CODIGO_TRANSACCION_PRODUCTO);
            } else {
                Toast.makeText(mContext, "Pedido incorrecto", Toast.LENGTH_SHORT).show();
            }
    }

    public void anadidoSnack (View view){
            Toast.makeText(this, "Añadido a su lista de pedidos", Toast.LENGTH_SHORT).show();

            Pedido carrito = new Pedido();
            carrito.setProducto(nombreProducto.getText().toString());
            //    carrito.setProducto(precioProducto.getText().toString());
        /*
        carrito.setPrecio(precio);
        carrito.setCantidad(cantidad);
        */
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            dbHelper.agregarAlCarrito(carrito);

            String json = new Gson().toJson(carrito);
            Log.e("Pedido enviado", json);

            //    llenarPedido(nombreProducto.getText().toString(),precioProducto.getText().toString());
            llenarPedido(nombreProducto.getText().toString());

            Intent intent = new Intent();
            intent.putExtra(Constants.KEY_REGISTRAR_PEDIDO, json);
            setResult(RESULT_OK, intent);
            finish();

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
