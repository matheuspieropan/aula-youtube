public class Desafio {

    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        TempoCores cores = new TempoCores.builder()
                .verde(1000)
                .amarelo(500)
                .vermelho(2000)
                .build();

        System.out.println("INICIANDO....");
        semaforo.inicia(cores);
        pausa(2500);

        System.out.println("PAUSANDO....");
        pausa(1500);
        semaforo.stop();

        pausa(3000);
        System.out.println("RETOMANDO....");
        semaforo.reinicia();
    }

    private static void pausa(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}