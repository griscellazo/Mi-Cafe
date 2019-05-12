package bo.Androides.MiCafe.model;

import com.google.gson.annotations.Expose;

public class Producto {

    @Expose
    private int id;

    @Expose
    private String nombre;

    @Expose
    private String detalle;

    @Expose
    private double precio;

    @Expose
    private int imagen;


    public Producto(int id, String nombre, String detalle, double precio, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.imagen = imagen;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
