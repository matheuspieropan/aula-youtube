package src.main.java;

public class Galinha implements ISom, IBotarOvo {

    @Override
    public void emitirSom() {
        System.out.println("Cocoricóooo");
    }

    @Override
    public void botarOvo() {
        System.out.println("Galinha botando ovo....");
    }
}