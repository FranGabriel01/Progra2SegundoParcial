
package Modelo;

import java.io.Serializable;


public class Sala implements Serializable{
    private int numero;
    private String pelicula;
    private Butaca[][] butacas;
    
    public Sala(int numero, String pelicula, int filas, int columnas){
        this.numero = numero;
        this.pelicula = pelicula;
        butacas = new Butaca [filas][columnas];
        for (int i = 0; i< filas; i++){
            for(int j = 0; j< columnas; j++){
                butacas[i][j] = new Butaca(i,j);
            }
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public void setButacas(Butaca[][] butacas) {
        this.butacas = butacas;
    }

    public Butaca getButaca(int fila, int col) {
        return butacas[fila][col];
    }
    
    @Override
    public String toString(){
        return "Sala " + numero + ": " + pelicula;
    }
    
}
