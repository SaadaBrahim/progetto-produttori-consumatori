/**
 * Avvia l'esempio di produttore/consumatore con un buffer condiviso.
 */
public class Main {
    public static void main(String[] args) {
        Buffer bufferCondiviso = new Buffer(); // risorsa condivisa

        Produttore p = new Produttore(bufferCondiviso);
        Consumatore c = new Consumatore(bufferCondiviso);

        System.out.println("--- Avvio del sistema Produttore/Consumatore ---");
        p.start();
        c.start();
    }
}
