
package VistaCine;

import javafx.scene.layout.VBox;
import Modelo.*;
import cineefx.CineeFx;
import javafx.scene.control.*;

public class SeleccionSalaView extends VBox{
    
    public SeleccionSalaView(CineeFx app,Cine cine,Cliente cliente){
        Label titulo = new Label("Seleccione una sala");
        
        ListView<Sala> listaSalas = new ListView<>();
        listaSalas.getItems().addAll(cine.getSalas());
        
        Button btnContinuar = new Button("Ver Butacas");
        
        btnContinuar.setOnAction(e ->{
            Sala seleccionada = listaSalas.getSelectionModel().getSelectedItem();
            if(seleccionada != null){
                app.mostrarSeleccionButaca(cliente, seleccionada);
            }
        });
        
        setSpacing(10);
        getChildren().addAll(titulo,listaSalas,btnContinuar);
    }
}

