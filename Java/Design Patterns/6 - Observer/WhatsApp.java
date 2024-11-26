public class WhatsApp implements Observer{

    @Override
    public void notificar(StatusPedido status) {
        System.out.println("Enviando WhatsApp.... STATUS:" + status.name());
    }
}