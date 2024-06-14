package org.example.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.example.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class descripcionPokemonController extends Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void onOpen(Object input)  {

    }

    @Override
    public void onClose(Object output) {

    }

    @FXML
    public void escenaVolver(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.POKEMON, null);
    }


}

