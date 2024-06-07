import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtuaisThreads {

    private static final int numeroProcessos = 30000;

    public static void main(String[] args) {
        invocarThreads(Executors.newCachedThreadPool());
        System.gc();
        invocarThreads(Executors.newVirtualThreadPerTaskExecutor());
    }

    private static void invocarThreads(ExecutorService executorService) {
        long inicio = System.currentTimeMillis();

        try (ExecutorService ex = executorService) {
            ex.invokeAll(Collections.nCopies(numeroProcessos, VirtuaisThreads::meuCallable));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long segundos = Duration.ofMillis(System.currentTimeMillis() - inicio).getSeconds();
        System.out.printf("Finalizou em %d segundos", segundos);
    }

    public static String meuCallable() {
        try {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}