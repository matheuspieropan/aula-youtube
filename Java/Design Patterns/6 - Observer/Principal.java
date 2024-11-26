import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Email email = new Email();
        WhatsApp whatsApp = new WhatsApp();

        List<Observer> observadores = Arrays.asList(email, whatsApp);
        Pedido pedido = new Pedido(observadores);

        pedido.mudancaStatus(StatusPedido.PENDENTE_PAGAMENTO);

        Thread.sleep(1500);

        pedido.mudancaStatus(StatusPedido.PAGAMENTO_APROVADO);

        Thread.sleep(2500);
        pedido.mudancaStatus(StatusPedido.EM_TRANSPORTE);

        Thread.sleep(3500);
        pedido.mudancaStatus(StatusPedido.ENTREGUE);
    }
}