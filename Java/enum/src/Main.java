package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double valor = 0;
        System.out.print("Digite o código da transportadora: ");

        int codigo = new Scanner(System.in).nextInt();
        if (codigo == TransportadoraEnum.CAMILO_DOS_SANTROS.getCodigo()) {
            valor = Double.parseDouble("100.00");
        } else if (codigo == TransportadoraEnum.MERCADO_ENVIO.getCodigo()) {
            valor = Double.parseDouble("200.00");
        } else if (codigo == TransportadoraEnum.JAD_LOG.getCodigo()) {
            valor = Double.parseDouble("300.00");
        }
        System.out.printf("Valor do frete é de: ".concat(Double.toString(valor)));
    }
}