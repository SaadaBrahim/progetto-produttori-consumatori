import java.util.LinkedList;
import java.util.Queue;

/**
 * Buffer condiviso per il produttore e il consumatore.
 * Tiene una coda limitata di interi e gestisce la sincronizzazione.
 */
public class Buffer {
    private final int CAPACITA = 5;
    private final Queue<Integer> coda = new LinkedList<>();

    /**
     * Aggiunge un valore al buffer quando c'è spazio.
     * Se il buffer è pieno, il thread produttore attende.
     */
    public synchronized void produci(int valore) throws InterruptedException {
        while (coda.size() == CAPACITA) {
            System.out.println("[BUFFER PIENO] Il produttore attende...");
            wait(); // rilascia il lock e attende notify
        }
        coda.add(valore);
        System.out.println("PRODOTTO: " + valore + " | Size: " + coda.size());
        notifyAll(); // sveglia i thread in attesa
    }

    /**
     * Preleva un valore dal buffer quando disponibile.
     * Se il buffer è vuoto, il thread consumatore attende.
     */
    public synchronized int consuma() throws InterruptedException {
        while (coda.isEmpty()) {
            System.out.println("[BUFFER VUOTO] Il consumatore attende...");
            wait(); // rilascia il lock e attende notify
        }
        int valore = coda.poll();
        System.out.println("CONSUMATO: " + valore + " | Size: " + coda.size());
        notifyAll(); // sveglia i thread in attesa
        return valore;
    }
}