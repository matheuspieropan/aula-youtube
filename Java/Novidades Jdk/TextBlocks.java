public class TextBlocks {

    public static void main(String[] args) {
        System.out.println(antes());
        System.out.println(depois());
    }

    private static String antes() {
        return "{\n" +
                "    \"nome\": \"Pedro\",\n" +
                "    \"email\": \"pedro@dev.com\",\n" +
                "    \"senha\": \"qualquercoisa\"\n" +
                "}";
    }

    private static String depois() {
        return """
                {
                    "nome": "Pedro",
                    "email": "pedro@dev.com",
                    "senha": "qualquercoisa"
                }
                """;
    }
}