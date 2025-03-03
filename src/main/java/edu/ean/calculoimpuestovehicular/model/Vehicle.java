/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ean.calculoimpuestovehicular.model;

import java.time.Year;
import java.util.Objects;

/**
 *
 * @author Paula, Estefania, Hermann
 */
public class Vehicle {
    private double valuation;
    private int year;
    private String brand;
    private String model;
    private int cylinderCapacity;
    private VehicleUseType useType;

    public Vehicle(double valuation, int year, String model, String brand, int cylinderCapacity, VehicleUseType useType) {
        this.valuation = valuation;
        this.year = year;
        this.model = model;
        this.cylinderCapacity = cylinderCapacity;
        this.useType = useType;
        this.brand = brand;
    }
    
    private static int getYearFromUserInput(String yearString) throws ParseVehicleException {
        ParseVehicleException yearException = new ParseVehicleException("Ingrese un número de año válido");
        try {
            int currentYear = Year.now().getValue();
            int year = Integer.parseInt(yearString);
            
            if (year <= 0) {
                throw yearException;
            } else if (year > currentYear +1) {
                throw yearException;
            }
            
            return year;
        } catch(NumberFormatException e) {
            throw yearException;
        }
    }
    
    private static double getValuationFromUserInput(String valuationString) throws ParseVehicleException {
        ParseVehicleException valuationException = new ParseVehicleException("Ingrese un valor avalúo válido");
        
        try {
            double valuation = Double.parseDouble(valuationString);
            
            if (valuation <= 0) {
                throw valuationException;
            }
            
            return valuation;
        } catch(NumberFormatException e) {
            throw valuationException;
        }
    }
    
    private static VehicleUseType getUseTypeFromUserInput(String useTypeString) throws ParseVehicleException {
        VehicleUseType type = VehicleUseType.parseUseType(useTypeString);
        if (type == null) {
            throw new ParseVehicleException("Seleccione el tipo de uso del vehiculo");
        }
        
        return type;
    }
    
    private static String getStringFromUserInput(String userInput, String errorMessage) throws ParseVehicleException {
        String validatedString = Objects.requireNonNullElse(userInput, "").trim();
        if (userInput.isEmpty()) { 
            throw new ParseVehicleException(errorMessage);
        }
        return validatedString;
    }
    
    private static int getCapacityFromUserInput(String cylinderCapacityString) throws ParseVehicleException {
        ParseVehicleException exception = new ParseVehicleException("Ingrese el cicilndraje");
        try {
            int capacity = Integer.parseInt(cylinderCapacityString);
            if (capacity <= 200) {
                throw exception;
            }
            return capacity;
        } catch (NumberFormatException e) {
            throw exception;
        }
    }
    
    public static Vehicle getVehicleFromUserInput(String valuationString, String yearString, String modelString, String brandString, String cylinderCapacityString, String useTypeString) throws ParseVehicleException {
        brandString = getStringFromUserInput(brandString, "Ingrese una marca valida");
        modelString = getStringFromUserInput(modelString, "Ingrese un modelo de vehiculo valido");
        int year = getYearFromUserInput(yearString);
        int capacity = getCapacityFromUserInput(cylinderCapacityString);
        double valuation = getValuationFromUserInput(valuationString);
        VehicleUseType type = getUseTypeFromUserInput(useTypeString);
        
        return new Vehicle(valuation, year, modelString, brandString, capacity, type);
    }
    
    public double getValuation() {
        return valuation;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public VehicleUseType getUseType() {
        return useType;
    }

    public void setUseType(VehicleUseType useType) {
        this.useType = useType;
    }
    
    public boolean isPublic() {
        return useType == VehicleUseType.PUBLIC;
    }
}
