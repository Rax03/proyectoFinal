package org.example.View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.dao.PokedexDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class insertar_pokedex extends Controller implements Initializable {

    @FXML
    TextField textnumero;
    @FXML
    TextField textDescripcion;
    @FXML
    TextField textHabitad;
    @FXML
    TextField texEstadisticas;
    @FXML
    TextField textMovimientos;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textnumero.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textnumero.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }
    @FXML
    public void guardarPokedex(Event event) throws Exception {
        Pokedex pokedex = new Pokedex();

        if (!textnumero.getText().isEmpty()) {
            try {
                pokedex.setNumero(Integer.parseInt(textnumero.getText()));
            } catch (NumberFormatException e) {
                System.err.println("El ID proporcionado no es un número válido.");
            }
        }
            pokedex.setNumero(Integer.parseInt(textnumero.getText()));
            pokedex.setDescripcion(textDescripcion.getText());
            pokedex.setHabitad(textHabitad.getText());
            pokedex.setEstadisticas(texEstadisticas.getText());
            pokedex.setMovimientos(textMovimientos.getText());
            PokedexDAO.build().save(pokedex);
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

