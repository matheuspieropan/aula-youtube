public class TempoCores {

    private int tempoCorVerde;

    private int tempoCorAmarelho;

    private int tempoCorVermelho;

    public int getTempoCorVerde() {
        return tempoCorVerde;
    }

    public int getTempoCorAmarelho() {
        return tempoCorAmarelho;
    }

    public int getTempoCorVermelho() {
        return tempoCorVermelho;
    }

    private TempoCores() {
    }

    private TempoCores(int tempoCorVerde, int tempoCorAmarelho, int tempoCorVermelho) {
        this.tempoCorVerde = tempoCorVerde;
        this.tempoCorAmarelho = tempoCorAmarelho;
        this.tempoCorVermelho = tempoCorVermelho;
    }

    public static class builder {

        private int corVerde;

        private int corAmarelho;

        private int corVermelho;

        public builder verde(int tempoCorVerde) {
            corVerde = tempoCorVerde;
            return this;
        }

        public builder vermelho(int tempoCorVermelho) {
            corVermelho = tempoCorVermelho;
            return this;
        }

        public builder amarelo(int tempoCorAmarelo) {
            corAmarelho = tempoCorAmarelo;
            return this;
        }

        public TempoCores build() {
            return new TempoCores(corVerde, corAmarelho, corVermelho);
        }
    }
}