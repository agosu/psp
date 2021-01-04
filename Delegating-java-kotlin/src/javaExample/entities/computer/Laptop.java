package javaExample.entities.computer;

import javaExample.functionalities.navigationModule.NavigationModule;
import javaExample.functionalities.navigationModule.NavigationModuleImpl;
import javaExample.functionalities.soundModule.SoundModule;
import javaExample.functionalities.soundModule.SoundModuleImpl;

public class Laptop extends Computer implements NavigationModule, SoundModule {
    NavigationModule navigationModuleDelegate = new NavigationModuleImpl();
    SoundModule soundModuleDelegate = new SoundModuleImpl();

    public void getCoordinates() {
        navigationModuleDelegate.getCoordinates();
    }

    public void getCompassDirection() {
        navigationModuleDelegate.getCompassDirection();
    }

    public void playMusic() {
        soundModuleDelegate.playMusic();
    }
}
