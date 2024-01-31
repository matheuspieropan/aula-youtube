package src;

public enum TransportadoraEnum {

    CAMILO_DOS_SANTROS(10),

    MERCADO_ENVIO(20),

    JAD_LOG(30);

    private int codigo;

    TransportadoraEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}