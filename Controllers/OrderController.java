package Controllers;

import Models.Order;
import Models.Product;
import Models.User;
import Views.OrderView;

/**
    * De 'OrderController' klasse is verantwoordelijk voor alle client-interacties af te handlen.
    * @see OrderView
    * @see Order
*/
public class OrderController {
    private static OrderView currentView;
    private static Order currentOrder;

    /**
        * Constructor voor de 'OrderController' klasse.
        * @param selectedView - De view die gebruikt word voor de controller.
        * @see OrderView
    */
    public OrderController(OrderView selectedView) {
        currentView = selectedView;
        currentOrder = new Order();
    }

    /**
        * Deze methode kan aangeroepen worden om een nieuw item toe te voegen aan de order.
        * @see OrderView
        * @see Product
    */
    public void Add() {
        Product currentProduct = currentView.GetCurrentProduct();

        // Bekijk of de input die binnen komt klopt.
        if(currentView.ValidateProductInput()) {
            if(currentProduct != null) {

                // Voeg een nieuw product toe aan de lijst, en re-format daarna het overzicht.
                currentOrder.Add(currentProduct);
                currentView.SetSummaryText(currentOrder.format(this.getUser()));
            } else {
                currentView.SendInvalidProductWarning();
            }
        } else {
            currentView.SendInvalidUserWarning();
        }
    }

    /**
        * Deze methode kan aangeroepen worden om de huidige order schoon te maken.
        * @see Order
    */
    public void New() {
        currentOrder.Clear();
        currentView.ClearInputs();
        currentView.ClearSummary();
    }

    /**
        * Deze methode kan gebruikt worden om een order toe te voegen aan de database.
        * @see Database.Classes.Query
        * @see Order
        * @implNote - Zorg ervoor dat deze klasse verbinding kan maken met de database.
    */
    public void Send() {
        if(currentView.ValidateUserInput()) {
            if(currentOrder.productList.size() != 0) {
                User orderUser = this.getUser();

                // Zorg dat de huidige order schoongemaak word en alles weer netjes op zijn plek komt.
                currentOrder.Clear();
                currentView.SetSummaryText(currentOrder.format(orderUser));
                currentView.ClearInputs();

                currentView.SendOrderNotification(orderUser);
            } else {
                currentView.SendInvalidOrderWarning();
            }
        } else {
            currentView.SendInvalidUserWarning();
        }
    }

    /**
        * Deze functie haalt een gebruiker object op op basis van de input.
        * @return User - Een gebruikersobject.
    */
    public User getUser() {
        return new User(currentView.GetName(), currentView.GetAdress(), currentView.GetPhone());
    }
}
