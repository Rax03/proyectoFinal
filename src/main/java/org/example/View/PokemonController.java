package org.example.View;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.App;
import org.example.Model.Enums.Tipo;
import org.example.Model.dao.PokemonDAO;
import org.example.Model.Entidades.Pokemon;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class PokemonController extends Controller implements Initializable {
    @FXML
    private TableView<Pokemon> tableView;

    @FXML
    private TextField textID;


    @FXML
    private TableColumn<Pokemon, String> columnId;
    @FXML
    private TableColumn<Pokemon, String> columnName;
    @FXML
    private TableColumn<Pokemon, String> columnSexo;
    @FXML
    private TableColumn<Pokemon, String> columnTipo1;
    @FXML
    private TableColumn<Pokemon, String> columnTipo2;
    @FXML
    private TableColumn<Pokemon, String> columnPeso;
    @FXML
    private TableColumn<Pokemon, String> columnAltura;
    @FXML
    private TableColumn<Pokemon, String> columnId_Pokeded;

    private ObservableList<Pokemon> pokemons;
    private PokemonController controller;


    @Override
    public void onOpen(Object input) {

        List<Pokemon> pokemons = PokemonDAO.build().findAll();
        System.out.println(pokemons);
        this.pokemons = FXCollections.observableArrayList(pokemons);
        tableView.setItems(this.pokemons);
    }

    @FXML
    public void escenaVolver(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.MAIN, null);
    }

    @FXML

    public void escena_idpokedex(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.POKEDEX, null);
    }


    @FXML
    private void agregaPokemon(ActionEvent actionEvent) throws IOException {
        App.currentController.openModal(Scenes.insertar_pokemon, "animal de feria", this, null);
    }


    @Override
    public void onClose(Object output) {
    }

    public void guardarpokemon(Pokemon pokemon) {
        PokemonDAO.build().save(pokemon);
        this.pokemons.add(pokemon);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setEditable(true);
        columnId.setCellValueFactory(pokemon -> new SimpleStringProperty(String.valueOf(pokemon.getValue().getId())));
        columnName.setCellValueFactory(pokemon -> new SimpleStringProperty(pokemon.getValue().getNombre()));
        columnSexo.setCellValueFactory(pokemon -> new SimpleStringProperty(pokemon.getValue().getSexo()));
        columnSexo.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTipo1.setCellValueFactory(pokemon -> new SimpleStringProperty(String.valueOf(pokemon.getValue().getTipo1())));
        columnTipo1.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTipo2.setCellValueFactory(pokemon -> new SimpleStringProperty(String.valueOf(pokemon.getValue().getTipo2())));
        columnTipo2.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPeso.setCellValueFactory(pokemon -> new SimpleStringProperty(String.valueOf(pokemon.getValue().getPeso())));
        columnPeso.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAltura.setCellValueFactory(pokemon -> new SimpleStringProperty(String.valueOf(pokemon.getValue().getAltura())));
        columnAltura.setCellFactory(TextFieldTableCell.forTableColumn());
        columnId_Pokeded.setCellValueFactory(pokemon -> new SimpleStringProperty(String.valueOf(pokemon.getValue().getPokedex().getNumero())));
        columnSexo.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }

            if (event.getNewValue().length() <= 60) {
                Pokemon pokemon = event.getRowValue();
                pokemon.setSexo(event.getNewValue());
                PokemonDAO.build().save(pokemon);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }
        });
        columnTipo1.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }

            if (event.getNewValue().length() <= 60) {
                Pokemon pokemon = event.getRowValue();
                pokemon.setTipo1(Tipo.valueOf(event.getNewValue()));
                PokemonDAO.build().save(pokemon);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }

        });
        columnTipo2.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }

            if (event.getNewValue().length() <= 60) {
                Pokemon pokemon = event.getRowValue();
                pokemon.setTipo2(Tipo.valueOf(event.getNewValue()));
                PokemonDAO.build().save(pokemon);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }

        });
        columnPeso.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }

            if (event.getNewValue().length() <= 60) {
                Pokemon pokemon = event.getRowValue();
                pokemon.setPeso(Float.valueOf(event.getNewValue()));
                PokemonDAO.build().save(pokemon);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }

        });

        columnAltura.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }

            if (event.getNewValue().length() <= 60) {
                Pokemon pokemon = event.getRowValue();
                pokemon.setAltura(Float.valueOf(event.getNewValue()));
                PokemonDAO.build().save(pokemon);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }

        });


    }

    @FXML
    public void eliminarPokemon(ActionEvent actionEvent) throws IOException {
        PokemonDAO.build().delete(tableView.getSelectionModel().getSelectedItem());
        this.pokemons.remove(tableView.getSelectionModel().getSelectedItem());


    }
}

