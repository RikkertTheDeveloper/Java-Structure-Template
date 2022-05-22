## Query.Java
### Documentatie door [Rick Arendsen](https://github.com/RikkertTheDeveloper)
<br>

<kbd style='background:rgba(255,0,0,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Deze documentatie is alleen bedoeld voor de Query.java klasse geschreven door Rick Arendsen</span></kbd>

## SELECT Statement
<kbd style='background:rgba(0,0,250,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Een Select statement zal een **RESULTSET** teruggeven als een argument.</span></kbd>

Voor een **SELECT** statement kunnen we simpelweg gebruik maken van een **SELECT * FROM ... WHERE '...' = '...'** query.
deze query geeft dan een [ResultSet](https://www.javatpoint.com/ResultSet-interface) terug. Hier kan dan doorheen gekeken worden door middel van een [ForEach Loop](https://stackoverflow.com/a/46308383)

```java
    String formattedQuery ="SELECT * FROM `Tabel Hier`"
    Query initalQuery = new Query(formattedQuery);
    ResultSet queryResults = Query.get();
```

## UPDATE Statement
<kbd style='background:rgba(0,0,250,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Een Update statement zal een **BOOLEAN** teruggeven als een argument.</span></kbd>

Voor een **UPDATE** statement kunnen we gebruik maken van een **"UPDATE ... SET key = value WHERE key = value**.
Deze query geeft dan een **Boolean** terug. dit kan simpelweg vergeleken worden als:
```java
    // Zet de query op.
    String formattedQuery = "UPDATE `Tabel Naam` SET Sleutel = 'Waarde' WHERE 'Sleutel1' = 'Sleutel2'";
    Query initalQuery = new Query(formattedQuery);

    // Voer de query uit en vergelijk het resultaat.
    boolean initialQueryResult = initalQuery.exucute();
    boolean querySucceeded = (initalQueryResult != false);
```

## INSERT Statement
<kbd style='background:rgba(0,0,250,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Een insert statement zal een **BOOLEAN** teruggeven als een argument.</span></kbd>

```java
    // Zet de query op.
    String formattedQuery =  "INSERT INTO `Tabel Naam` (id, gebruikersnaam) VALUES (NULL, 'Rick Arendsen')"
    Query initalQuery = new Query(formattedQuery);

    // Voer de query uit en vergelijk het resultaat.
    boolean initialQueryResult = initalQuery.exucute();
    boolean querySucceeded = (initalQueryResult != false);
```

## DELETE Statement
<kbd style='background:rgba(0,0,250,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Een Delete statement zal een **BOOLEAN** teruggeven als een argument.</span></kbd><br>
Voor een **DELETE** statement kunnen we gebruik maken van een **DELETE FROM `Tabel Naam` WHERE ```'Key' = 'Value'```**

```java
    // Zet de query op.
    String formattedQuery =  "DELETE FROM `Tabel Naam` WHERE 'key' = 'value'"
    Query initalQuery = new Query(formattedQuery);

    // Voer de query uit en vergelijk het resultaat.
    boolean initialQueryResult = initalQuery.exucute();
    boolean querySucceeded = (initalQueryResult != false);
```

## Voor extra informatie, raadpleeg de volgende bronnen:
<kbd style='background:rgba(255,255,0,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Deze bronnen worden intern gebruikt door Query.java.</span></kbd>
<br><br>
[Java Database Driver](https://www.javatpoint.com/jdbc-driver)