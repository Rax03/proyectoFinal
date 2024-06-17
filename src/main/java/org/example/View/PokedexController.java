package org.example.View;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.App;
import org.example.Model.Entidades.Pokedex;
import org.example.Model.Entidades.Pokemon;
import org.example.Model.dao.PokedexDAO;
import org.example.Model.dao.PokemonDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PokedexController extends  Controller implements Initializable {

    @FXML
    private TableView<Pokedex> tableView;


    @FXML
    private TableColumn<Pokedex, String> columnNUmero;
    @FXML
    private TableColumn<Pokedex, String> columnDescripcion;
    @FXML
    private TableColumn<Pokedex, String> columnHabitad;
    @FXML
    private TableColumn<Pokedex, String> columnEstadisticas;
    @FXML
    private TableColumn<Pokedex, String> columnMovimiento;

    private ObservableList<Pokedex> pokedexes;

    @Override
    public void onOpen(Object input) throws IOException {
        List<Pokedex> pokedexes = PokedexDAO.build().findAll();
        System.out.println(pokedexes);
        this.pokedexes = FXCollections.observableArrayList(pokedexes);
        tableView.setItems(this.pokedexes);

    }



    @Override
    public void onClose(Object output) {


    }

    public void guardarPokedex(Pokedex pokedex) {
        PokedexDAO.build().save(pokedex);
        this.pokedexes.add(pokedex);
    }

    @FXML
    public void escenaVolver(ActionEvent actionEvent) throws IOException {
        App.currentController.changeScene(Scenes.MAIN, null);
    }


    @FXML
    private void agregaPokedex() throws IOException {
        App.currentController.openModal(Scenes.insertar_pokedex,"Agregando una Pokedex...",this,null);
    }

    @FXML
    public void eliminarPokedex(ActionEvent event) throws IOException, SQLException {
        PokedexDAO.build().delete(tableView.getSelectionModel().getSelectedItem());
        this.pokedexes.remove(tableView.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setEditable(true);
        columnNUmero.setCellValueFactory(pokedex -> new SimpleStringProperty(String.valueOf(pokedex.getValue().getNumero())));
        columnDescripcion.setCellValueFactory(pokedex -> new SimpleStringProperty(pokedex.getValue().getDescripcion()));
        columnDescripcion.setCellFactory(TextFieldTableCell.forTableColumn());
        columnHabitad.setCellValueFactory(pokedex -> new SimpleStringProperty(pokedex.getValue().getHabitad()));
        columnHabitad.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEstadisticas.setCellValueFactory(pokedex -> new SimpleStringProperty(pokedex.getValue().getEstadisticas()));
        columnEstadisticas.setCellFactory(TextFieldTableCell.forTableColumn());
        columnMovimiento.setCellValueFactory(pokedex -> new SimpleStringProperty(pokedex.getValue().getMovimientos()));
        columnMovimiento.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDescripcion.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }
            if (event.getNewValue().length() <= 60) {
                Pokedex pokedex = event.getRowValue();
                pokedex.setDescripcion(event.getNewValue());
                PokedexDAO.build().save(pokedex);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }
        });
        columnHabitad.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }


            if (event.getNewValue().length() <= 60) {
                Pokedex pokedex = event.getRowValue();
                pokedex.setHabitad(event.getNewValue());
                PokedexDAO.build().save(pokedex);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }
        });

        columnEstadisticas.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }


            if (event.getNewValue().length() <= 60) {
                Pokedex pokedex = event.getRowValue();
                pokedex.setEstadisticas(event.getNewValue());
                PokedexDAO.build().save(pokedex);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }
        });

        columnMovimiento.setOnEditCommit(event -> {
            if (event.getNewValue() == event.getOldValue()) {
                return;
            }


            if (event.getNewValue().length() <= 60) {
                Pokedex pokedex = event.getRowValue();
                pokedex.setMovimientos(event.getNewValue());
                PokedexDAO.build().save(pokedex);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Te has pasado!!!!!");
                alert.show();
            }
        });


    }
}
