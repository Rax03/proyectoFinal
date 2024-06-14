package org.example.View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;
import org.example.Model.Enums.Tipo;
import org.example.Model.dao.PokedexDAO;
import org.example.Model.dao.PokemonDAO;

import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class insertar_pokemon extends Controller implements Initializable {
    @FXML
    private ComboBox<Tipo> boxTipo1;
    @FXML
    private ComboBox<Tipo> boxTipo2;
    @FXML
    private TextField textID;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField texSexo;
    @FXML
    private TextField textPeso;
    @FXML
    private TextField textAltura;
    @FXML
    private ComboBox<Pokedex> boxPokedex;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxTipo1.setItems(FXCollections.observableArrayList(Tipo.values()));
        boxTipo2.setItems((FXCollections.observableArrayList(Tipo.values())));

        textID.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textID.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        textPeso.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textPeso.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        textPeso.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textAltura.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        boxPokedex.setItems(FXCollections.observableArrayList(PokedexDAO.build().findAll()));
    }


    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @FXML
    public void guardarpokemon(Event event) throws IOException {
/*
        Pokemon pokemon = new Pokemon(Integer.parseInt(textID.getText()), textNombre.getText(), texSexo.getText(),
                boxTipo1.getValue(), boxTipo2.getValue(), Float.valueOf(textPeso.getText()),
                Float.valueOf(textPeso.getText()), boxPokedex.getValue(PokedexDAO.build().findById().getNumero()));

 */
        Pokemon pokemon = new Pokemon();
        pokemon.setId(Integer.parseInt(textID.getText()));
        pokemon.setNombre(textNombre.getText());
        pokemon.setSexo(texSexo.getText());
        pokemon.setTipo1(boxTipo1.getValue());
        pokemon.setTipo2(boxTipo2.getValue());
        pokemon.setPeso(Float.valueOf(textPeso.getText()));
        pokemon.setAltura(Float.valueOf(textAltura.getText()));
        PokemonDAO.build().save(pokemon);
    }
}

