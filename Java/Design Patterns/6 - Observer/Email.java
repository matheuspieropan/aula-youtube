public class Email implements Observer {

    @Override
    public void notificar(StatusPedido status) {
        System.out.println("Enviando e-mail.... STATUS:" + status.name());
    }
}