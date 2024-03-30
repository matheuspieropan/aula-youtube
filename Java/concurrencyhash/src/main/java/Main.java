import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    static ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>() {{
        put("estados", Arrays.asList("SP", "MG", "RJ"));
        put("mg", Arrays.asList("Juiz de Fora", "Belo horizonte", "Contagem"));
    }};

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String chave = teclado.next();
        System.out.println(hashMap.get(chave));
    }
}