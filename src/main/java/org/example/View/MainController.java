package org.example.View;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.example.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class MainController extends Controller implements Initializable {


    @Override
    public void onOpen(Object input) {


    }


    @Override
    public void onClose(Object output) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    public void escenaPokedex(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.POKEDEX, null);
    }
@FXML
    public void escenaPokemon(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.POKEMON,null);

    }

    @FXML

    public void escenacerrar(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.MAIN, null);
        System.exit(0);

    }
}
