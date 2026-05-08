/**
 * Thread consumatore che preleva valori dal buffer condiviso.
 */
public class Consumatore extends Thread {
    private final Buffer buffer;

    public Consumatore(Buffer b) {
        this.buffer = b;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consuma(); // prende un valore dal buffer
                Thread.sleep(1500); // pausa più lunga per simulare il consumo
            }
        } catch (InterruptedException e) {
            System.out.println("Consumatore interrotto.");
        }
    }
}
