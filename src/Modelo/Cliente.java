
package Modelo;

import java.io.Serializable;


public class Cliente implements Serializable{
    private String nombre;
    private String email;
    private String password;

    public Cliente(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email.toLowerCase();
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
    public boolean validarPassword(String pw){
        return this.password.equals(pw);
    }
    
}
