package bo.Androides.MiCafe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.db.DatabaseHelper;
import bo.Androides.MiCafe.model.Pedido;
import bo.Androides.MiCafe.model.Producto;

public class VerPedido extends AppCompatActivity {

    private Context context;
    private DatabaseHelper dbHelper;
    private List<Pedido> items = new ArrayList<>();
    private String nombreProducto;

    ListView lista;

    List<Producto> verpedido = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido);
        this.context = this;
        dbHelper = new DatabaseHelper(this.context);
        items = dbHelper.getPedidos();
        double total = getTotal();

        lista = (ListView) findViewById(R.id.ListaVerPedido);



        Toast.makeText(this, "FUNCIONA! y el total es:" + total, Toast.LENGTH_SHORT).show();



    }

    private double getTotal(){
        double total = 0;
        for (Pedido pedido : items){
            total += (pedido.getPrecio() * pedido.getCantidad());
        }
        return total;
    }

    /*public void pedidoRealizado (View view){
        Intent intent = new Intent(this, Dese);
        startActivity(intent);*/
}



}
