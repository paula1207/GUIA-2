/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ean.calculoimpuestovehicular.controller;

import edu.ean.calculoimpuestovehicular.model.TaxCalculationException;
import edu.ean.calculoimpuestovehicular.model.ParseVehicleException;
import edu.ean.calculoimpuestovehicular.model.TaxCalculator;
import edu.ean.calculoimpuestovehicular.model.Vehicle;
import edu.ean.calculoimpuestovehicular.view.HomeListener;
import edu.ean.calculoimpuestovehicular.view.CalculatorViewInterface;

/**
 *
 * @author Paula, Estefania, Hermann
 */
public class CalculatorController implements HomeListener {

    CalculatorViewInterface homeView;

    public CalculatorController(CalculatorViewInterface view) {
        homeView = view;
    }

    public void showView() {
        homeView.setListener(this);
        homeView.showView();
    }
    
    @Override
    public void calculateAction() {
        Vehicle v;
        try {
            v = Vehicle.getVehicleFromUserInput(homeView.getValuation(),
                    homeView.getYear(),
                    homeView.getModel(),
                    homeView.getBrand(),
                    homeView.getCapacity(),
                    homeView.getUseType());

            TaxCalculator taxCalculator = new TaxCalculator();
            String taxesResult = taxCalculator.calculateTaxes(v);
            homeView.setTaxesResults(taxesResult);
        } catch (ParseVehicleException | TaxCalculationException e) {
            homeView.showError(e.getLocalizedMessage());
        }
    }

}
