package bo.Androides.MiCafe.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Pedido;
import bo.Androides.MiCafe.model.User;

    public class DatabaseHelper {
        private SQLiteDatabase mDatabase;

        public DatabaseHelper(Context context) {
            Database instancia = new Database(context);
            this.mDatabase = instancia.getWritableDatabase();
        }

        public void insert(User user) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("usuario", user.getNombreUsuario());
            contentValues.put("password", user.getPassword());
            contentValues.put("email", user.getEmail());
            contentValues.put("codigoUpb", user.getCodigoUpb());
            this.mDatabase.insert("usuarios",
                    null,
                    contentValues);
            this.mDatabase.close();
        }

        public boolean login(String usuario, String password) {
            String[] params = new String[2];
            params[0] = usuario;
            params[1] = password;

            Cursor cursor = this.mDatabase.rawQuery("SELECT email FROM usuarios" + " WHERE usuario=? AND password=?", params);


            if (cursor.moveToFirst()) {
                Log.d("email", "" + cursor.getInt(0));
                return true;
            } else {
                return false;
            }
        }

        public void agregarAlCarrito(Pedido pedido){
            ContentValues contentValues = new ContentValues();
            contentValues.put("producto", pedido.getProducto());
            contentValues.put("precio", pedido.getPrecio());
            contentValues.put("cantidad", pedido.getCantidad());
            this.mDatabase.insert("pedidos",
                    null,
                    contentValues);
            this.mDatabase.close();
        }





        /*public boolean pedidoLogin(String nombrePedido) {
            String[] params = new String[1];
            params[0] = nombrePedido;


            Cursor cursor = this.mDatabase.rawQuery("SELECT id, producto, precio, cantidad FROM pedidos", null);
            if (cursor.moveToFirst()) {
                Log.d("NombrePedido", "" + cursor.getInt(0));
                return true;
            } else {
                return false;
            }
        }*/








        public List<Pedido> getPedidos(){
            List<Pedido> pedidos = new ArrayList<>();

            Cursor cursor = this.mDatabase.rawQuery("SELECT id, producto, precio, cantidad FROM pedidos", null);
            if(cursor.moveToFirst()){
                do{
                    int id = cursor.getInt(0);
                    String producto = cursor.getString(1);
                    double precio = cursor.getDouble(2);
                    int cantidad = cursor.getInt(3);

                    Pedido pedido = new Pedido();
                    pedido.setId(id);
                    pedido.setProducto(producto);
                    pedido.setPrecio(precio);
                    pedido.setCantidad(cantidad);

                    pedidos.add(pedido);
                }while (cursor.moveToNext());
            }

            return pedidos;
        }

        public double getTotal(){
            double total =0;

            Cursor cursor = this.mDatabase.rawQuery("SELECT precio, cantidad FROM pedidos", null);
            if(cursor.moveToFirst()){
                do{
                    int cantidad = cursor.getInt(0);
                    double precio = cursor.getDouble(1);

                    total += (cantidad*precio);
                }while (cursor.moveToNext());
            }
            return total;
        }

        public void limpiarCarrito(){
            this.mDatabase.delete("pedidos","",null);
            this.mDatabase.close();
        }
    }

