import java.util.Random;

public class Cafe extends Bebida {

    @Override
    protected boolean possuiIngredientesParaBebida() {
        System.out.println("Indo no banco de dados e validando se possui ingredientes para café...");
        return new Random().nextBoolean();
    }

    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando ingredientes para o café...");
    }

    @Override
    protected void fazerBebida() {
        System.out.println("Fazendo café...");
    }
}