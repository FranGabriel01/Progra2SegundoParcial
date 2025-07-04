
package Modelo;

import java.io.Serializable;


public class Entrada implements Serializable{
    private Cliente cliente;
    private Butaca butaca;
    private Sala sala;

    public Entrada(Cliente cliente, Butaca butaca, Sala sala) {
        this.cliente = cliente;
        this.butaca = butaca;
        this.sala = sala;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Override
    public String toString(){
        return cliente.getNombre() + " compro" + butaca + " en sala " + sala.getNumero();
    }
}
