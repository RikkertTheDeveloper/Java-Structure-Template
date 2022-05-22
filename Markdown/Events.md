## Het 'Event' paradigme
### Documentatie door [Rick Arendsen](https://github.com/RikkertTheDeveloper)
<br>

<kbd style='background:rgba(255,100,100,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Voor meer informatie bezoek mijn publieke JavaUtils repository voor meer tools zoals dit.</span></kbd>

## Wat zijn events?
Een <kbd>Event</kbd> is een speciale klasse die logica bevat om de code in controllers korter en concreter te maken.

**Een voorbeeld event:**
```java
    // Maak een nieuwe event aan genaamd 'SubmitOrder' en bind hier een boolean aan vast genaamd 'OrderSubmitted':
    OrderSubmitEvent SubmitOrder = new OrderSubmitEvent();
    boolean OrderSubmitted = SubmitOrder.fire(OrderInformation)

    // 'OrderSubmitted' is een boolean die een returntype is van 'OrderSubmittedEvent.fire().
    if(OrderSubmitted) {
        // De event is gelukt.
    } else {
        // Er is een fout opgetreden.
    }
```

<br>

## Waarom zou ik events gebruiken in mijn applicatie?
Door events samen te gebruiken met de <kbd>Query.java</kbd> kunnen veel regels bespaard worden en is het makkelijker om dingen te veranderen in de applicatie.

<br>

**Neem bijvoorbeeld dit voorbeeld van een simpele input controller:**

### Zonder Events & Query.java
- Lees de input uit vanaf de GUI
- Maak DaL object aan
- Open de connectie met de database
- Maak een nieuwe 'statement' aan
- Cast de return types naar een variabel
- Voeg foutafhandling toe door deze apart hieronder te zetten

### Met Events & Query.java
- Lees de input uit van de GUI
- Voer de event uit die bij deze interactie hoort en voeg een callback toe aan **Event.Error** om foutafhandling toe te voegen.