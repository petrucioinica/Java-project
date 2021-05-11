# PLATFORMA FOOD DELIVERY
  Proiectul simuleaza (rudimentar) o platforma de food delivery.
  Clasele au fost gandite pentru a acomoda o structura similara cu a bazei de date ce poate fi gasita aici: https://dbdiagram.io/d/60524956ecb54e10c33bee7f .
 ### Utilizare
  Pentru a vedea featurile proiectului trebuie rulata functia main din src/app/Main.
  Pentru alegerea optiunilor se va folosi input de la tastatura. Urmariti mesajele afisate.
 ### Implementare
  Pentru implementarea proiectului am creat  pachete pentru useri, comenzi si meniuri pentru restaurante, cat si pachetul services care contine urmatoarele:
    * AuditService - folosit pentru cerinta de audit
    * CsvReadingService - cu ajutorul acestui serviciu aplicatia isi incarca datele deja existente in fisierele .csv
    * CsvWritingService - cu ajutorul acestui serviciu se scriu date in fisierele .csv pe masura ce sunt prelucrate
    * MenusService - gestioneaza manipularea obiectelor de tip Menu si Item
    * OrdersService - gestioneaza manipularea obiectelor de tip Order
    * ShoppingCartService - gestioneaza manipularea obiectelor de tip ShoppingCart si Payload
    * UsersService - gestioneaza manipularea obiectelor din packageul User
In folderul de baza se gasesc fisiere .csv ce corespund userilor (client, driver, restaurant), orderelor, shopping carturilor, payloadurilor, meniurilor si itemelor.
  ###Idee de test run
  Recomand incercarea creeari unor noi useri si efectuarea unui order cu userii noi, apoi verificarea in fisierele .csv corespunzatoare, eventual restartarea programului pentru a verifica daca s-au pastrat consistent obiectele.
  

