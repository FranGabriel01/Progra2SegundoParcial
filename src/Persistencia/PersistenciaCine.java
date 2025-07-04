
package Persistencia;

import Modelo.Cine;
import java.io.*;


public class PersistenciaCine {
    private static final String ARCHIVO = "cine.ser";
    
    public static void guardar(Cine cine){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))){
            oos.writeObject(cine);
        }catch (IOException e){
            System.out.println("Error al guardar: " +e.getMessage());
        }
    }
    
    public static Cine cargar(){
        File file = new File(ARCHIVO);
        if(!file.exists()) return new Cine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (Cine) ois.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Error al cargar: " + e.getMessage());
            return new Cine();
        }
    }
}
