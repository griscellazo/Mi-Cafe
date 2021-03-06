package bo.Androides.MiCafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<EntidadesLista> listItems;

    public Adapter(Context context, ArrayList<EntidadesLista> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EntidadesLista Item = (EntidadesLista) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.custom_layout, null);

        return convertView;
    }
}
