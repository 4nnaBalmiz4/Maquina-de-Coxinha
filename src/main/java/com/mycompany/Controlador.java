package com.mycompany;


import com.mycompany.Coxinha;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AnnaLauraBalmizaSoar
 */
public class Controlador {
    @FXML
    private TextField campoEstoque;
    
    @FXML
    private TextField quantidadeAbastecer;
    
    @FXML
    private TextField quantidadeVender;
    
    private Coxinha coxinha; 
    
    @FXML
    private void initialize(){
        coxinha = new Coxinha(); 
        campoEstoque.setText(String.valueOf(coxinha.getEstoque()));
    }
    
    @FXML
    private void abastecer(){
        int qtd = Integer.valueOf(quantidadeAbastecer.getText());
        if(qtd <= 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Valor iválido para inserir");
            alert.show();
            return; 
        }
        coxinha.abastecer(qtd);
        campoEstoque.setText(String.valueOf(coxinha.getEstoque()));
        quantidadeAbastecer.setText(" ");
    }
    
    @FXML
    private void vender1(){
        if(coxinha.getEstoque() == 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Não há coxinhas para vender");
            alert.show();
            return;
        }
        coxinha.venderCoxinha();
        campoEstoque.setText(String.valueOf(coxinha.getEstoque()));   
}
    
    @FXML
    private void vender(){
        int qtd = Integer.valueOf(quantidadeVender.getText());
        if(coxinha.getEstoque() == 0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Não há coxinhas para vender");
            alert.show();
            return; 
        }else if(qtd > coxinha.getEstoque()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Não há coxinhas suficentes, no momento temos apenas: "+coxinha.getEstoque());
            alert.show();
            return; 
        }
        
        coxinha.venderCoxinha(qtd);
        campoEstoque.setText(String.valueOf(coxinha.getEstoque()));
        quantidadeVender.setText(" ");
    }
    
    @FXML
    private void zerarMaquina(){
        coxinha.zerarMaquina();
        campoEstoque.setText(String.valueOf(coxinha.getEstoque()));
    }
}
