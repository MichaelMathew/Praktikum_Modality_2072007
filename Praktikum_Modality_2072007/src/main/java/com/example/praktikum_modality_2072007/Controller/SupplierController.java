package com.example.praktikum_modality_2072007.Controller;

import com.example.praktikum_modality_2072007.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SupplierController {
    public MenuItem CloseId;
    public TextField IdSupplier;
    public TextField NameSupplierId;
    public TextField AlamatSupplierId;
    public TableView<Supplier> tableSupplier;
    public TableColumn<String,Supplier> ColID;
    public TableColumn<String,Supplier> ColNama;
    public TableColumn<String,Supplier> ColAlamat;
    public Button btnSave;
    public Button btnReset;
    public Button btnUpdate;

    private String returnID;
    private String returnNama;
    private String returnAlamat;
    private int index;



    private ObservableList<Supplier> oList;

    public void initialize() {
        oList = FXCollections.observableArrayList();
        tableSupplier.setItems(oList);
        ColID.setCellValueFactory(new PropertyValueFactory<>("idSupplier"));
        ColNama.setCellValueFactory(new PropertyValueFactory<>("NamaSupplier"));
        ColAlamat.setCellValueFactory(new PropertyValueFactory<>("Alamat"));
    }
    public void Closed(ActionEvent actionEvent) {
        setReturnID(IdSupplier.getText());
        setReturnNama(NameSupplierId.getText());
        setReturnAlamat(AlamatSupplierId.getText());
        setoList(oList);
        IdSupplier.getScene().getWindow().hide();
    }

    public void SaveSupplier(ActionEvent actionEvent) {
        oList.add(new Supplier(IdSupplier.getText(),NameSupplierId.getText(),AlamatSupplierId.getText()));
        ResetSupplier();
    }

    public void ResetSupplier() {
        IdSupplier.clear();
        NameSupplierId.clear();
        AlamatSupplierId.clear();
    }

    public void UpdateSupplier(ActionEvent actionEvent) {
        oList.set(index,new Supplier(IdSupplier.getText(),NameSupplierId.getText(),AlamatSupplierId.getText()));
        ResetSupplier();
    }

    public void Selected(MouseEvent mouseEvent) {
        if (!tableSupplier.getSelectionModel().getSelectedCells().isEmpty()){
            btnSave.setDisable(true);
            btnReset.setDisable(false);
            btnUpdate.setDisable(false);
            index = tableSupplier.getSelectionModel().getSelectedIndex();
        }
        IdSupplier.setText(tableSupplier.getSelectionModel().getSelectedItem().getIdSupplier());
        NameSupplierId.setText(tableSupplier.getSelectionModel().getSelectedItem().getNamaSupplier());
        AlamatSupplierId.setText(tableSupplier.getSelectionModel().getSelectedItem().getAlamat());
    }

    public void Selected2(MouseEvent mouseEvent) {
        btnSave.setDisable(false);
        btnReset.setDisable(false);
        btnUpdate.setDisable(false);
    }

    public String getReturnID() {
        return returnID;
    }

    public void setReturnID(String returnID) {
        this.returnID = returnID;
    }

    public String getReturnNama() {
        return returnNama;
    }

    public void setReturnNama(String returnNama) {
        this.returnNama = returnNama;
    }

    public String getReturnAlamat() {
        return returnAlamat;
    }

    public void setReturnAlamat(String returnAlamat) {
        this.returnAlamat = returnAlamat;
    }

    public ObservableList<Supplier> getoList() {
        return oList;
    }

    public void setoList(ObservableList<Supplier> oList) {
        this.oList = oList;
    }


}
