# progetto-produttori-consumatori
## farm di buffer

Analisi Tecnica: 
Prevenzione del Deadlock nel Modello Produttore-ConsumatoreIl deadlock (o stallo) 
è una condizione in cui un gruppo di thread è bloccato perché ogni thread attende una risorsa posseduta da un altro thread del gruppo. 

In un sistema Produttore-Consumatore mal progettato, il rischio è che il Produttore aspetti che il buffer si svuoti e il Consumatore aspetti che il buffer si riempia, rimanendo entrambi fermi all'infinito.

Questa applicazione previene il deadlock attraverso tre pilastri 
fondamentali:
1. Rilascio del Monitor con wait()A differenza di un semplice ciclo di attesa (busy waiting), il metodo wait() in Java fa due cose contemporaneamente:Sospende l'esecuzione del thread attuale.Rilascia il lock (il monitor) sull'oggetto Buffer.Questo passaggio è cruciale: se il Produttore trovasse il buffer pieno e non rilasciasse il lock, il Consumatore non potrebbe mai entrare nel metodo consuma() per svuotarlo, creando appunto un deadlock.
2. Comunicazione tramite notifyAll()Per evitare che un thread rimanga "addormentato" anche quando la condizione di blocco è passata, usiamo notifyAll():Ogni volta che il Produttore aggiunge un elemento, invia un segnale.Ogni volta che il Consumatore rimuove un elemento, invia un segnale.L'uso di notifyAll() rispetto a notify() è una scelta di sicurezza: assicura che tutti i thread in attesa vengano svegliati, evitando che un segnale importante vada perso tra più produttori o più consumatori.
3. Controllo Condizionale con whileIl codice utilizza while invece di if per testare la condizione di attesa (es: while(buffer.pieno)):Questo previene il fenomeno del "risveglio spurio".Al risveglio, il thread è obbligato a ricontrollare se la risorsa è effettivamente disponibile prima di procedere, garantendo che l'accesso avvenga solo in condizioni di sicurezza totale.