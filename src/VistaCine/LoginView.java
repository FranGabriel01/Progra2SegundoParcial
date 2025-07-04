
package VistaCine;

import javafx.scene.layout.VBox;
import Modelo.*;
import Persistencia.PersistenciaCine;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView extends VBox{
    
    public LoginView(cineefx.CineeFx app, Cine cine){
        Label lblTitulo = new Label("Iniciar sesion");
        TextField email = new TextField();
        email.setPromptText("email");
        
        PasswordField pw = new PasswordField();
        pw.setPromptText("Contrasena");
        
        Label mensaje = new Label();
        
        Button btnLogin = new Button("Ingresar");
        Button btnRegistro = new Button("Registrarse");
        
        btnLogin.setOnAction(e ->{
            Cliente cliente = cine.login(email.getText(), pw.getText());
            if(cliente != null){
                mensaje.setText("Bienvenido, " + cliente.getNombre());
                PersistenciaCine.guardar(cine);
                app.mostrarSeleccionSala(cliente);
            }else{
                mensaje.setText("Usuario o contrasenia incorrecta");
            }
        });
        
        btnRegistro.setOnAction(e -> app.mostrarRegistro());
        
        setSpacing(10);
        getChildren().addAll(lblTitulo,email,pw,btnLogin,btnRegistro,mensaje);
    }
}
