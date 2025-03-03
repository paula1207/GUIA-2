/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.ean.calculoimpuestovehicular;

import edu.ean.calculoimpuestovehicular.controller.CalculatorController;
import edu.ean.calculoimpuestovehicular.view.CalculatorView;
import edu.ean.calculoimpuestovehicular.view.CalculatorViewInterface;

/**
 *
 * @author Paula, Estefania, Hermann
 */
public class VehicleTaxCalculatorApp {

    public static void main(String[] args) {
        CalculatorViewInterface calculatorView = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculatorView);
        
        controller.showView();
    }
}
