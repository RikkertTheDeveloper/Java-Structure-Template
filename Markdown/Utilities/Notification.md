## Notifications
### Documentatie door [Rick Arendsen](https://github.com/RikkertTheDeveloper)

<br>

<kbd style='background:rgba(0,0,250,.5); font-weight: 900'>Attentie: <span style='font-weight: 300'>Het word aangeraden om deze klasse alleen te gebruiken voor simpele operaties en de native ''Alert' klasse te gebruiken voor complexe notificaties. <br><br> Notification.java is simpelweg een manier om simpele notificaties makkelijker te maken.</span></kbd>

<br>

## Implementatie
Om een niewe notificatie aan te maken, doe bijvoorbeeld:
```java
    Notifcation OrderSent = new Notification("Gelukt!", "Uw order is vertuurd!", Enum.AlertType.Success);

    OrderSent.Display()
```