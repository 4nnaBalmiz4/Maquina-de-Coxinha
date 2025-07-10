package com.mycompany;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AnnaLauraBalmizaSoar
 */
public class Coxinha {
    private int estoque;
    public Coxinha(){
        estoque = 0;
    }

    public int getEstoque(){
         return estoque;
    }
    
    public void setEstoque(int estoque){
          this.estoque = estoque;
    }
    
    public void abastecer(int qtd){
        if(qtd <= 0){
            System.out.println("Valor inválido");
        }else{
        estoque += qtd;
        }
    }
    
    public void venderCoxinha(){
        estoque --;
    }
    
    public void venderCoxinha(int qtd){
        if(qtd <= estoque){
            estoque = estoque - qtd;
        }
    }
    
    public void zerarMaquina(){
        estoque = 0;
    }
}
