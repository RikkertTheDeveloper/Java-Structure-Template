package Utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Notification {
    private String Title, Description;
    private AlertType Type;

    /**
        * Deze functie maakt een nieuwe notificatie aan.
        * @param Title - Wat de titel van de notificatie.
        * @param Description - Wat is de beschrijving van de notificatie?
        * @param Type - Wat is de type van de notifiatie?
        * @see Alert
    */
    public Notification(String Title, String Description, AlertType Type) {
        this.Title = Title;
        this.Description = Description;
        this.Type = Type;
    }

    /**
        * Deze functie laat de notificatie op het scherm zien.
    */
    public void Display() {
        Alert newNotification = new Alert(Type);
        newNotification.setHeaderText(this.Title);
        newNotification.setContentText(this.Description);
        newNotification.show();
    }
}
