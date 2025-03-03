/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ean.calculoimpuestovehicular.view;

/**
 *
 * @author Paula, Estefania, Hermann
 */
public interface CalculatorViewInterface {

    String getBrand();

    String getCapacity();

    String getModel();

    String getUseType();

    String getValuation();

    String getYear();

    void setListener(HomeListener homeListener);

    void setTaxesResults(String results);

    void showError(String message);
    
    void showView();
    
}
