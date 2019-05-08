package bo.Androides.MiCafe.model;

import com.google.gson.annotations.Expose;

public class User {

    @Expose
    private String nombreUsuario;

    @Expose
    private String password;

    @Expose
    private int edad;

    @Expose
    private String email;

    @Expose
    private int codigoUpb;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigoUpb() {
        return codigoUpb;
    }

    public void setCodigoUpb(int codigoUpb) {
        this.codigoUpb = codigoUpb;
    }
}
