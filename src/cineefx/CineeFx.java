package cineefx;

import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Sala;
import Persistencia.PersistenciaCine;
import VistaCine.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CineeFx extends Application {

    private Stage stage;
    private Cine cine;

    @Override
    public void start(Stage stage) {
        this.stage = stage; // ← corregido
        this.cine = PersistenciaCine.cargar();
        cine.inicializarSalas();
        mostrarLogin();
        stage.setTitle("Sist. Cine");
        stage.show();
    }

    public void mostrarLogin() {
        Scene scene = new Scene(new LoginView(this, cine), 300, 250); // ← corregido
        stage.setScene(scene);
    }

    public void mostrarRegistro() {
        Scene scene = new Scene(new RegistroView(this, cine), 300, 300);
        stage.setScene(scene);
    }

    public void mostrarSeleccionSala(Cliente cliente) {
        Scene scene = new Scene(new SeleccionSalaView(this, cine, cliente), 400, 300);
        stage.setScene(scene);
    }

    public void mostrarSeleccionButaca(Cliente cliente, Sala sala) {
        Scene scene = new Scene(new SeleccionButacaView(this, cine, cliente, sala), 400, 350); // ← corregido
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
