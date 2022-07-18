package com.example.praktikum_modality_2072007.Controller;

import com.example.praktikum_modality_2072007.ProductApplication;
import com.example.praktikum_modality_2072007.model.Barang;
import com.example.praktikum_modality_2072007.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BarangController {
    public MenuItem ShowSupplierId;
    public MenuItem CloseId;
    public TextField txtID;
    public TextField NamaId;
    public ComboBox<String> SupplierId;
    public TableView<Barang> tableBarang;
    public TableColumn<String,Barang> ColID;
    public TableColumn<String,Barang> ColNama;
    public TableColumn<String,Barang> ColSupplier;
    public Button btnSave;
    public Button btnReset;
    public Button btnUpdate;
    private ObservableList<Barang> oList;
    private ObservableList<Supplier> SList;
    private ObservableList<String> SuppList;
    private Stage stage;
    private int index;

    public void initialize() throws IOException {
        stage = new Stage();

        oList = FXCollections.observableArrayList();

        tableBarang.setItems(oList);
        ColID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        ColSupplier.setCellValueFactory(new PropertyValueFactory<>("Supplier"));

        stage.initModality(Modality.WINDOW_MODAL);
    }

    public void ShowSupplierManagement(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(ProductApplication.class.getResource("Supplier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        SupplierController sController = fxmlLoader.getController();

        stage.setTitle("Supplier Management");
        stage.setScene(scene);
        stage.showAndWait();
        SuppList = FXCollections.observableArrayList();
        SList = sController.getoList();
        for(Supplier supp : SList){
            SuppList.add(supp.getNamaSupplier());
        }
        SupplierId.setItems(SuppList);
        SupplierId.getSelectionModel().select(0);
    }

    public void Closed(ActionEvent actionEvent) {
        txtID.getScene().getWindow().hide();
    }
    public void SaveBarang(ActionEvent actionEvent) {
        oList.add(new Barang(txtID.getText(),NamaId.getText(),SupplierId.getValue()));
        ResetBarang();
    }

    public void ResetBarang() {
        txtID.clear();
        NamaId.clear();
        SupplierId.getSelectionModel().select(0);
    }

    public void UpdateBarang(ActionEvent actionEvent) {
        oList.set(index,new Barang(txtID.getText(),NamaId.getText(),SupplierId.getValue()));
        ResetBarang();
    }

    public void Selected(MouseEvent mouseEvent) {
        if (!tableBarang.getSelectionModel().getSelectedCells().isEmpty()){
            btnSave.setDisable(true);
            btnReset.setDisable(false);
            btnUpdate.setDisable(false);
            index = tableBarang.getSelectionModel().getSelectedIndex();
        }
        txtID.setText(tableBarang.getSelectionModel().getSelectedItem().getId());
        NamaId.setText(tableBarang.getSelectionModel().getSelectedItem().getNama());
        SupplierId.setValue(tableBarang.getSelectionModel().getSelectedItem().getSupplier());
    }


    public void Selected2(MouseEvent mouseEvent) {
        btnSave.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(false);
    }
}