package VistaCine;

import Modelo.Cine;
import Persistencia.PersistenciaCine;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegistroView extends VBox {

    public RegistroView(cineefx.CineeFx app, Cine cine) {
        Label titulo = new Label("Registro de Cliente");

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        TextField email = new TextField();
        email.setPromptText("Email");

        PasswordField pw = new PasswordField();  // ✅ CONTRASEÑA
        pw.setPromptText("Contraseña");

        Label mensaje = new Label();

        Button btnRegistrar = new Button("Registrar");

        btnRegistrar.setOnAction(e -> {
            String nom = nombre.getText();
            String mail = email.getText();
            String clave = pw.getText(); // ✅ obtener contraseña

            if (nom.isEmpty() || mail.isEmpty() || clave.isEmpty()) {
                mensaje.setText("❗ Completá todos los campos");
                return;
            }

            boolean ok = cine.registrarCliente(nom, mail, clave);
            if (ok) {
                PersistenciaCine.guardar(cine);
                mensaje.setText("✅ Registro exitoso");
                app.mostrarLogin();
            } else {
                mensaje.setText("⚠️ El email ya está registrado");
            }
        });

        setSpacing(10);
        getChildren().addAll(titulo, nombre, email, pw, btnRegistrar, mensaje);
    }
}
