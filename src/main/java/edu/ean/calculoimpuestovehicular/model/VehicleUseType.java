/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.ean.calculoimpuestovehicular.model;

/**
 *
 * @author Paula, Estefania, Hermann
 */
public enum VehicleUseType {
    PERSONAL,
    PUBLIC;
    
    public static VehicleUseType parseUseType(String s) {
        if (s.equalsIgnoreCase("particular")) {
            return VehicleUseType.PERSONAL;
        } else {
            return VehicleUseType.PUBLIC;
        }
    }
}
