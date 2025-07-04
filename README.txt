Ho optato per la strategia SINGLE_TABLE, avendo le calssi figlie di Catalogo pochi elementi non in comune,
con le altre strategie la tabella Magazine avrebbe avuto un solo elemento (periodicità), ciò oltre ad influire
sul efficenza dell'applicazione causa a mio parere una maggiore difficoltà nella lettura dei dati.
Ci ritroviamo così con tre tabelle, Catalogo, Utenti e Prestiti, quest'ultima è in relazione idirezionale con id del Catalago,
essendo possibile avere in prestito un singolo oggetto alla volta e così facendo abbiamo inoltre la possibilita di
visualizzare il prestito dal oggetto del catalogo. Inoltre è anche in relazione One-to-Many con id Utente, così da
peremttere ai singoli utenti di avere più prestiti ma ogni prestito di avere un univoco utente, non essendo possibile
prestare un singolo oggetto a due utenti contemporaneamente.