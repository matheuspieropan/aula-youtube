public class SwitchExpressions {

    public static void main(String[] args) {
        System.out.println(antes(DiaSemanaEnum.SEGUNDA));
        System.out.println(depois(DiaSemanaEnum.SEGUNDA));
    }

    private static String antes(DiaSemanaEnum dia) {
        String frase = "";
        switch (dia) {
            case SEGUNDA:
                frase = "Dia da semana!";
                break;
            case TERCA:
                frase = "Dia da semana!";
                break;
            case QUARTA:
                frase = "Dia da semana!";
                break;
            case QUINTA:
                frase = "Dia da semana!";
                break;
            case SEXTA:
                frase = "Dia da semana!";
                break;
            case SABADO:
                frase = "Final de semana!";
                break;
            case DOMINGO:
                frase = "Final de semana!";
                break;
        }
        return frase;
    }

    private static String depois(DiaSemanaEnum dia) {
        return switch (dia) {
            case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> "Dia da semana!";
            case SABADO, DOMINGO -> "Final de semana!";
        };
    }

    public enum DiaSemanaEnum {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }
}