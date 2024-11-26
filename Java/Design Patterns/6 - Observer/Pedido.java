import java.util.List;

public class Pedido {

    private final List<Observer> observadores;

    public Pedido(List<Observer> observadores) {
        this.observadores = observadores;
    }

    private void notificaObservadores(StatusPedido status) {
        observadores.forEach(observer -> observer.notificar(status));
    }

    public void mudancaStatus(StatusPedido status) {
        System.out.println("--- MUDANÇA DE STATUS ---");
        notificaObservadores(status);
    }
}