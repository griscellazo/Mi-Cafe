package bo.Androides.MiCafe;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Producto;

public class AdaptadorPlatos extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    List<Producto> items = new ArrayList<>();

    public AdaptadorPlatos (Context contexto, List<Producto> productos){
        this.contexto = contexto;
        this.items = productos;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_elemento_lista_platos, null);

            viewHolder.nombre = (TextView) convertView.findViewById(R.id.NombreDePlato);
            viewHolder.imagen = (ImageView) convertView.findViewById(R.id.imagen3);
            viewHolder.precioPlatos = (TextView) convertView.findViewById(R.id.precioPlatos);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Producto producto = this.items.get(i);
        viewHolder.nombre.setText(producto.getNombre());
        viewHolder.imagen.setImageResource(producto.getImagen());
        viewHolder.precioPlatos.setText("Precio: "+ String.valueOf(producto.getPrecio()) + " Bs.");
        return convertView;
    }

    class ViewHolder {
        TextView nombre;
        ImageView imagen;
        TextView precioPlatos;
    }

    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Producto getItem(int position) {
        return this.items.get(position);
    }
    @Override
    public long getItemId(int position) {
        return this.items.get(position).getId();
    }

}