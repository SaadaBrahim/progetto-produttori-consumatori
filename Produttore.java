/**
 * Thread produttore che genera numeri interi e li inserisce nel buffer.
 */
public class Produttore extends Thread {
    private final Buffer buffer;

    public Produttore(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                buffer.produci(i++); // invia un valore al buffer
                Thread.sleep(500); // pausa breve tra le produzioni
            }
        } catch (InterruptedException e) {
            System.out.println("Produttore interrotto.");
        }
    }
}
