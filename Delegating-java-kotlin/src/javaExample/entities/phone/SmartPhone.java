package javaExample.entities.phone;

import javaExample.functionalities.climateModule.ClimateModule;
import javaExample.functionalities.climateModule.ClimateModuleImpl;
import javaExample.functionalities.navigationModule.NavigationModuleImpl;
import javaExample.functionalities.navigationModule.NavigationModule;

public class SmartPhone extends Phone implements NavigationModule, ClimateModule {
    NavigationModule navigationModuleDelegate = new NavigationModuleImpl();
    ClimateModule climateModuleDelegate = new ClimateModuleImpl();

    public void getCoordinates() {
        navigationModuleDelegate.getCoordinates();
    }

    public void getCompassDirection() {
        navigationModuleDelegate.getCompassDirection();
    }

    public void measureTemperature() {
        climateModuleDelegate.measureTemperature();
    }
}
