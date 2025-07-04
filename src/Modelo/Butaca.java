
package Modelo;

import java.io.Serializable;


public class Butaca implements Serializable {
    private int fila;
    private int columna;
    private boolean ocupada;

    public Butaca(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupada = false;
    }

    public int getFila() {
        return fila;
    }
    
    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public void setColumna (int columna){
        this.columna = columna;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    

    
    @Override
    public String toString(){
        return "Butaca " + fila + columna + (ocupada ? "ocupada" : "Libre");
    }
    
}
