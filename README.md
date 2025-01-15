#  Applicazione Fullstack ecommerce Sprong boot React (primo progetto di fine formazioen)

 Screenshot Home![Screenshot 2025-01-15 022732](https://github.com/user-attachments/assets/9124987a-5f2a-4af1-8a20-940479cb15db)
>

## Descrizione del Progetto
 Questa applicazione fornisce funzionalità per la gestione degli utenti, delle categorie di prodotti e degli articoli. È stata sviluppata utilizzando tecnologie moderne sia per il backend che per il frontend.

- **Backend**: Sviluppato in Java con Spring Boot, utilizza PostgreSQL come database relazionale e AWS S3 per lo storage dei file.
- **Frontend**: Sviluppato con React, disponibile in una repository separata.
- *L'applicazione è stata progettata come progetto di fine formazione java backend di Digitazon tech school per gestire una piattaforma di e-commerce.
- Il fontend è stato progettato grazie alle conoscenze aquisite all'università
 e alla formazione che ho fatta nella stessa scuola.
 
## Concetti Fondamentali Utilizzati
Questo progetto utilizza diversi concetti fondamentali della programmazione e dello sviluppo software:

1. **Programmazione Orientata agli Oggetti (OOP)**: Il backend è progettato utilizzando principi OOP come incapsulamento, ereditarietà e polimorfismo.
2. **Pattern Architetturali**:
   - **MVC (Model-View-Controller)**: Utilizzato per organizzare il codice in modo modulare e scalabile.
   - **Repository Pattern**: Per separare la logica di accesso ai dati dalla logica aziendale.
3. **Gestione delle Eccezioni**: Personalizzazione delle eccezioni per migliorare la comprensibilità degli errori.
4. **Sicurezza**: Implementata con Spring Security per garantire l'autenticazione e l'autorizzazione degli utenti.
5. **API RESTful**: Il backend espone endpoint chiari per interagire con il sistema.
6. **Cloud Computing**: AWS S3 è utilizzato per gestire il caricamento e la memorizzazione delle immagini dei prodotti, garantendo affidabilità e scalabilità.

## Dettagli sullo Sviluppo

- **Frontend con React**: Sviluppato con Visual Studio Code (VS Code) per sfruttare la sua flessibilità nello sviluppo frontend.
- **Backend con Eclipse**: Sviluppato con Eclipse IDE per acquisire familiarità con strumenti professionali utilizzati in progetti complessi.
- **Abitudine al Lavoro in Team**: La separazione tra frontend e backend consente un approccio modulare e simula un ambiente di lavoro reale in team e per applicazioni complessi.

## Perché ho usato Amazon Web Services (AWS)?
AWS è una soluzione di cloud computing leader nel settore e offre numerosi vantaggi nello sviluppo di applicazioni complessi:

1. **Scalabilità**: Permette di gestire grandi quantità di dati senza problemi di prestazioni.
2. **Affidabilità**: Garantisce la disponibilità dei dati in qualsiasi momento.
3. **Sicurezza**: Offre strumenti avanzati per proteggere i dati caricati (i dati del cliente per esempio).
4. **Integrazione Semplice**: AWS S3 si integra facilmente con il backend, rendendo il caricamento e il recupero delle immagini efficienti.

AWS è particolarmente importante per applicazioni complesse, poiché RIDUCE IL CARICO SUL SERVER PRINCIPALE e migliora l'esperienza dell'utente.

## Endpoint Principali del Backend

### Utenti
1. **Registrazione Utente**
   - **Endpoint**: `POST /auth/register`
   - **Descrizione**: Consente agli utenti di registrarsi.
   - **Parametri Richiesti**: `name`, `email`, `password`, `phoneNumber`.
   - **Autorizzazione**: Nessuna.

  Screenshot Registrazione
![registrazione](https://github.com/user-attachments/assets/3a783c9a-d88e-4c2f-b098-2874127dd915)



2. **Login Utente**
   - **Endpoint**: `POST /auth/login`
   - **Descrizione**: Consente agli utenti di effettuare il login.
   - **Parametri Richiesti**: `email`, `password`.
   - **Autorizzazione**: Nessuna.

  Screenshot Login
   ![login_backend](https://github.com/user-attachments/assets/820fd057-3464-42e8-a557-ecd5e2e85090)



### Articoli
6. **Creazione Articolo**
   - **Endpoint**: `POST /product/create`
   - **Descrizione**: Permette agli amministratori di aggiungere un nuovo articolo.
   - **Parametri Richiesti**: `name`, `description`, `price`, `categoryId`.
   - **Autorizzazione**: Per creare un articolo serve l'autorizzazione `ADMIN`; in questo caso genera un messagio di errore perche è stato dimenticato il campo categoria.E uguale per altri endpoind,
   - nel caso in cui non viene rispettato una condizione genera un eccezione (messagio di errore).

   Screenshot Creazione Articolo
   ![creare un articolo](https://github.com/user-attachments/assets/1dff1b11-959d-454d-9201-b22b0948beba)




   Quando tutto viene rispettato

   Screenshot Creazione Articolo senza messagio di errore
   ![image](https://github.com/user-attachments/assets/fc6c5af7-5df3-4c22-a2ae-d9cf9ab308c4)





8. **Aggiornamento Articolo**
   - **Endpoint**: `PUT /product/update
   - **Descrizione**: Aggiorna un articolo esistente.
   - **Parametri Richiesti**: `name`, `productId`, `price`.
   - **Autorizzazione**: `ADMIN`.

   Screenshot Aggiornamento Articolo
   ![image](https://github.com/user-attachments/assets/4689d06c-b29f-4cf5-9495-27f58447adc3)





10. **Lista degli Articoli**
   - **Endpoint**: `GET /product/get-all
   - **Descrizione**: Recupera l'elenco di tutti gli articoli dal cloud di AWS in modo efficienti.
   - **Autorizzazione**: Nessuna. 


    Screenshot Lista Articoli
   ![image](https://github.com/user-attachments/assets/c2ba9fa7-eb78-4a3d-93e4-732a36ef2a2c)




   ### Categorie
3. **Creazione Categoria**
   - **Endpoint**: `POST /category/create`
   - **Descrizione**: Permette agli amministratori di creare una nuova categoria.
   - **Parametri Richiesti**: `name`.
   - **Autorizzazione**: `ADMIN`.

   

4. **Aggiornamento Categoria**
   - **Endpoint**: `PUT /category/update/{categoryId}`
   - **Descrizione**: Permette agli amministratori di aggiornare una categoria esistente.
   - **Parametri Richiesti**: `name`.
   - **Autorizzazione**: `ADMIN`.

   

5. **Lista delle Categorie**
   - **Endpoint**: `GET /category/get-all`
   - **Descrizione**: Recupera l'elenco di tutte le categorie.
   - **Autorizzazione**: Nessuna.

### Configurazione di AWS S3
L'integrazione con AWS S3 è configurata nel backend per gestire il caricamento delle immagini dei prodotti. Ogni file è memorizzato in un bucket specifico, garantendo un accesso rapido e sicuro.

## Conclusione
Questo progetto rappresenta un esempio completo di applicazione fullstack moderna, con un'architettura ben progettata e una forte enfasi sulla scalabilità e la sicurezza. 
 Esplorare entrambe le repository per comprendere meglio come frontend e backend interagiscono per fornire una soluzione efficace.

