import java.util.Random;

public class Cerveja extends Bebida {

    @Override
    protected boolean possuiIngredientesParaBebida() {
        System.out.println("Indo no banco de dados e validando se possui ingredientes para cerveja...");
        return new Random().nextBoolean();
    }

    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando ingredientes para a cerveja...");
    }

    @Override
    protected void fazerBebida() {
        System.out.println("Fazendo cerveja...");
    }
}