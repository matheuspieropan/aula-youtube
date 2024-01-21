package factory;

import java.util.HashMap;
import java.util.Map;

public class DiaSemanaFactory {

    private static final Map<Integer, DiaDaSemana> diaDaSemanaMap = new HashMap<>();

    public static DiaDaSemana obterDiaSemana(int numeroDiaSemana) {
        diaDaSemanaMap.put(1, new Domingo());
        diaDaSemanaMap.put(2, new SegundaFeira());
        diaDaSemanaMap.put(3, new TerceiaFeira());

        return diaDaSemanaMap.get(numeroDiaSemana);
    }
}