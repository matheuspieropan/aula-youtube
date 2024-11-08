public class Semaforo {

    enum CorEnum {
        VERDE,
        AMARELO,
        VERMELHO
    }

    private boolean deveContinuar = true;

    private TempoCores tempoCores;

    private CorEnum corAtual = CorEnum.VERDE;

    public void inicia(TempoCores cores) {
        this.tempoCores = cores;
        Thread thread = new Thread(this::printarCor);
        thread.start();
    }

    public void stop() {
        deveContinuar = false;
    }

    public void reinicia() {
        deveContinuar = true;
        inicia(tempoCores);
    }

    public void printarCor() {
        while (deveContinuar) {
            switch (corAtual) {
                case VERDE -> {
                    printa(CorEnum.VERDE, tempoCores.getTempoCorVerde());
                    corAtual = CorEnum.AMARELO;
                }
                case AMARELO -> {
                    printa(CorEnum.AMARELO, tempoCores.getTempoCorAmarelho());
                    corAtual = CorEnum.VERMELHO;
                }
                case VERMELHO -> {
                    printa(CorEnum.VERMELHO, tempoCores.getTempoCorVermelho());
                    corAtual = CorEnum.VERDE;
                }
            }
        }
    }

    private void printa(CorEnum cor, int tempo) {
        System.out.println(cor.name());
        pausa(tempo);
    }

    private void pausa(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}