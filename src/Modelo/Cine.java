package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Cine implements Serializable{
    private List<Cliente> clientes = new ArrayList<>();
    private List<Sala> salas = new ArrayList<>();
    private List<Entrada> entradas = new ArrayList<>();
    
    public void inicializarSalas(){
        if(salas.isEmpty()){
            salas.add(new Sala(1, "Star Wars",5,6));
            salas.add(new Sala(2, "Oppenheimer",5,6));
            salas.add(new Sala(3, "Frozen",5,6));
        }
    }
    
    public boolean registrarCliente(String nombre, String email, String pw){
        if(buscarCliente(email)!= null)return false;
        clientes.add(new Cliente(nombre,email,pw));
        return true;
    }
    
    public Cliente login (String email, String pw){
        Cliente c = buscarCliente(email);
        return (c!= null && c.validarPassword(pw)) ? c : null;
    }
    
    private Cliente buscarCliente(String email){
        return clientes.stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }
    
    public boolean comprarEntrada(Cliente cliente, Sala sala, int fila, int col){
        Butaca b = sala.getButaca(fila, col);
        if(b.isOcupada()){
            return false;
        }else{
            b.setOcupada(true);
            entradas.add(new Entrada(cliente,b,sala));
            return true;
        }

    }
    
    public List<Sala> getSalas(){ return salas;}
    public List<Entrada> getEntradas(){ return entradas;}
    
}
