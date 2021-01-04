package javaExample;

import javaExample.entities.computer.Laptop;

public class Main {
    public static void main(String args[]) {
        Laptop laptop = new Laptop();
        laptop.playMusic();
        laptop.getCompassDirection();
        laptop.getCoordinates();
        laptop.compute();
    }
}
