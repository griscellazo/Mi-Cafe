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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.db.DatabaseHelper;
import bo.Androides.MiCafe.model.Pedido;

public class VerPedido extends AppCompatActivity {

    private Context context;
    private DatabaseHelper dbHelper;
    private List<Pedido> items = new ArrayList<>();

    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido);
        this.context = this;
        dbHelper = new DatabaseHelper(this.context);
        items = dbHelper.getPedidos();
        double total = getTotal();


        Toast.makeText(this, "FUNCIONA! y el total es:"+total, Toast.LENGTH_SHORT).show();

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

    private double getTotal(){
        double total = 0;
        for (Pedido pedido : items){
            total += (pedido.getPrecio() * pedido.getCantidad());
        }
        return total;
    }
}
