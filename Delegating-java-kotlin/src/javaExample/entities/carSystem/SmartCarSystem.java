package javaExample.entities.carSystem;

import javaExample.functionalities.soundModule.SoundModule;
import javaExample.functionalities.soundModule.SoundModuleImpl;

public class SmartCarSystem extends CarSystem implements SoundModule {
    SoundModule soundModuleDelegate = new SoundModuleImpl();

    public void playMusic() {
        soundModuleDelegate.playMusic();
    }
}
