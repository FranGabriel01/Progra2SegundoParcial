
package VistaCine;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import Modelo.*;
import Persistencia.PersistenciaCine;
import cineefx.CineeFx;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SeleccionButacaView extends VBox{
    
    public SeleccionButacaView(CineeFx app, Cine cine, Cliente cliente, Sala sala){
        Label titulo = new Label("Butacas - Sala " + sala.getNumero() + " (" + sala.getPelicula() + ")");
        GridPane grilla = new GridPane();
        grilla.setHgap(5);
        grilla.setVgap(5);
        grilla.setAlignment(Pos.CENTER);
        
        
        Butaca[][] butacas = sala.getButacas();
        
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                Butaca b = butacas[i][j];
                Button btn = new Button((i+1) + "-" + (j+1));
                btn.setMinSize(50, 30);
                
                if (b.isOcupada()){
                    btn.setStyle("-fx-background-color: red;");
                    btn.setDisable(true);
                }else{
                    btn.setStyle("-fx-background-color: lightgreen;");
                }
                
                int fila = i, col = j;
                btn.setOnAction(e->{
                    boolean ok = cine.comprarEntrada(cliente, sala, fila, col);
                    if(ok){
                        PersistenciaCine.guardar(cine);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("compra exitosa: Fila " + (fila + 1) + ", Columna "+ (col+1));
                        alert.showAndWait();
                        app.mostrarSeleccionButaca(cliente, sala);
                        
                    }
                });
                
                grilla.add(btn, i, i);
            }
        }
        
        Button volver = new Button("<- Vb oler");
        volver.setOnAction(e -> app.mostrarSeleccionSala(cliente));
        
        setSpacing(10);
        setAlignment(Pos.CENTER);
        getChildren().addAll(titulo,grilla,volver);
    }
}
