package bo.Androides.MiCafe;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActLista extends AppCompatActivity{
    ListView listView;

    String [] items = {"Comidas", "Bebidas", "Snacks y Dulces"};

    Integer [] logo = {R.drawable.food, R.drawable.beer, R.drawable.circle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_productos);


        CustomAdapter adapter = new CustomAdapter(MainActLista.this, items,logo);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActLista.this, itemValue, Toast.LENGTH_LONG).show();

            }
        });

    }

}

class CustomAdapter extends ArrayAdapter<String>{
    private final Context context;
    private final String[] items;
    private final Integer[] logo;

    public CustomAdapter(Context context, String[] items, Integer[] logo){
        super(context, R.layout.menu_productos, items);
        this.context= context;
        this.items = items;
        this.logo = logo;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView= inflater.inflate(R.layout.menu_productos, null, true);

        TextView title = (TextView) rowView.findViewById(R.id.text);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);

        title.setText(items[position]);
        image.setImageResource(logo[position]);
        return rowView;
    }


}