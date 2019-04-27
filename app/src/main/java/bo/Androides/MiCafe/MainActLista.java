package bo.Androides.MiCafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActLista extends AppCompatActivity{
    ListView listView;

    String [] items = {"Comidas", "Bebidas", "Snacks y Dulces"};

    Integer [] logo = {R.drawable.food, R.drawable.beer, R.drawable.circle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_productos);

    }

}