package Views;

import java.util.ArrayList;

import javax.swing.JComboBox;

import Controllers.OrderController;
import Interfaces.View;
import Models.Product;
import Models.User;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
    * Deze klasse word gebruikt om de view te laten zien waar de gebruiker dingen kan bestellen.
*/
public class OrderView implements View {

    // Zet de UI elementen in de klasse die we zullen gebruiken.
    private OrderController orderController = new OrderController(this);

    public static Label naamLabel, adresLabel, mobielLabel, pizzaLabel;
    public static Button addKnop, verzendKnop, nieuwKnop;
    public static TextField naamInput, adresInput, mobielInput, productInput;
    public static TextArea orderSummary;
    public static Stage viewStage;
    public static JComboBox<String> productSelectie;
    public static ArrayList<Product> productList;

   public OrderView(Stage stageArgument) {
        viewStage = stageArgument;

        productList = new ArrayList<Product>();
        productList.add(new Product("Pizza Margherita", 8.50));
        productList.add(new Product("Pizza Pepperoni", 9.50));
        productList.add(new Product("Pizza Giros", 12.99));
        productList.add(new Product("Pizza Courgette", 11.79));
        productList.add(new Product("Pizza BBQ Pulled Beef", 15.77));
   }

   /**
        * Deze functie zorgt ervoor dat alle componenten van de scene gerenderd worden.
        * @see OrderView
   */
   public void Render() {
       System.out.println("OrderView.Render() | Rendering OrderView.java");
       Pane viewPane = new Pane();
       Scene viewScene = new Scene(viewPane);

       // Zet de stage van de view op en zorg ervoor dat de stage goed word gezet.
       viewStage.setTitle("Pizza bezorging app.");
       viewStage.setScene(viewScene);
       viewStage.show();

       // Voeg de UI elementen toe aan de scene:
       // Element: "Labels and Previews"
       naamLabel = new Label();
       naamLabel.setText("Naam");
       naamLabel.relocate(15, 27.5);

       adresLabel = new Label();
       adresLabel.setText("Adres");
       adresLabel.relocate(15, 52.5);

       mobielLabel = new Label();
       mobielLabel.setText("Mobiel");
       mobielLabel.relocate(15, 77.5);

       pizzaLabel = new Label();
       pizzaLabel.setText("Pizza");
       pizzaLabel.relocate(15, 102.5);

       // Element: "Buttons"
       addKnop = new Button();
       addKnop.setText("Voeg Toe");
       addKnop.relocate(55, 135);

       verzendKnop = new Button();
       verzendKnop.setText("Verzend Bestelling");
       verzendKnop.relocate(55, 165);

       nieuwKnop = new Button();
       nieuwKnop.setText("Nieuwe Bestelling");
       nieuwKnop.relocate(55, 300);

       // Element: "Inputs"
       naamInput = new TextField();
       naamInput.setPromptText("Naam");
       naamInput.relocate(55, 25);

       adresInput = new TextField();
       adresInput.setPromptText("Adres");
       adresInput.relocate(55, 50);

       mobielInput = new TextField();
       mobielInput.setPromptText("Mobiel Nummer");
       mobielInput.relocate(55, 75);

       productInput = new TextField();
       productInput.setPromptText("Product");
       productInput.relocate(55, 102.5);

       // Element: "Displays & Summaries"
       orderSummary = new TextArea();
       orderSummary.setEditable(false);
       orderSummary.relocate(225, 25);
       orderSummary.setMaxWidth(200);
       orderSummary.setMinHeight(300);

       // Voeg de nieuwe elementen die we gemaakt hebben toe aan de UI.
       viewPane.getChildren().addAll(naamLabel, adresLabel, mobielLabel, pizzaLabel, orderSummary);
       viewPane.getChildren().addAll(addKnop, verzendKnop, nieuwKnop);
       viewPane.getChildren().addAll(naamInput, adresInput, mobielInput, productInput);
   }

   /**
        * Deze functie sluit de view.
   */
   public void Close() {
       viewStage.close();
   }

   /**
        * Deze functie voegt alle callbacks aan de knoppen toe door middel van de OrderController.
        * @see OrderController
        * @implNote - Voeg Database 'Query' klasse later aan de Controller toe.
   */
   public void SetupCallbacks() {
        nieuwKnop.setOnAction(event -> orderController.New());
        verzendKnop.setOnAction(event -> orderController.Send());
        addKnop.setOnAction(event -> orderController.Add());
   }

   /**
        * Deze functie haalt een product op uit de lijst van producten.
        * @return Product | Null - Geeft een product als er iets gevonden word, anders Null.
        * @see Product
   */
   public Product GetCurrentProduct() {
       if(ValidateProductInput()) {
            int currentIndex = Integer.parseInt(productInput.getText());

            // Bekijk of de index opgehaald kan worden, anders return 'null'.
            try {
                return productList.get(currentIndex);
            } catch (Exception e) {
                return null;
            }
       } else {
           return null;
       }
   }

   /**
        * Deze functie zet de tekst van het Order Overzicht
        * @param String Message - Welk bericht moet er komen te staan?
  */
   public void SetSummaryText(String Message) {
        orderSummary.setText(Message);
   }

   /**
        * Deze functie maakt alle inputs van de display schoon.
   */
   public void ClearInputs() {
       naamInput.setText("");
       adresInput.setText("");
       mobielInput.setText("");
       productInput.setText("");
   }

   /**
        * Deze functie maakt de 'orderSummary' TextArea weer schoon.
   */
   public void ClearSummary() {
       orderSummary.setText("");
   }

   /**
        * Deze functie haalt de 'naamInput' tekst op.
        * @return String
   */
   public String GetName() {
       return naamInput.getText();
   }

    /**
        * Deze functie haalt de 'adresInput' tekst op.
        * @return String
   */
   public String GetAdress() {
       return adresInput.getText();
   }

   /**
        * Deze functie haalt de 'mobielInput' tekst op.
        * @return String
   */
   public String GetPhone() {
       return mobielInput.getText();
   }

   /**
        * Deze functie geeft een boolean terug op basis van de input van de 'productInput' TextField
        * @return Boolean - Is het veld 'productInput' ingevuld?
   */
   public Boolean ValidateProductInput() {
        return productInput.getText() != "";
   }

   /**
        * Deze functie valideerd of de index die gegeven is voor een product ook klopt.
        * @param Int currentIndex - Index van het product.
        * @return Boolean - Bestaat die product in de product-lijst?
   */
   public Boolean validateProductIndex(int currentIndex) {
        Product productIndex = productList.get(currentIndex);
        return productIndex != null;
   }

   /**
        * Deze functie valideerd of de gebruikersinformatie die in de inputs staat correct is.
        * @return Boolean - Staat alle gebruikersinformatie er correct in?
   */
   public Boolean ValidateUserInput() {
        return naamInput.getText() != "" && adresInput.getText() != "" && mobielInput.getText() != "";
   }

   /**
       * Deze functie laat een melding zien over ongeldige gebruikersinformatie.
       * @see User
       * @see Alert
   */
   public void SendInvalidUserWarning() {
       Alert newAlert = new Alert(AlertType.WARNING);
       newAlert.setTitle("Ongeldig Gebruikersinformatie");
       newAlert.setHeaderText("Ongeldige Gebruikersinformatie!");
       newAlert.setContentText("Voer alstublieft geldige gebruikersinformatie in!");
       newAlert.show();
   }

   /**
       * Deze functie laat een melding zien over ongeldige besellingsinformatie.
       * @see Models.Order
       * @see Alert
   */
   public void SendInvalidOrderWarning() {
       Alert newAlert = new Alert(AlertType.WARNING);
       newAlert.setTitle("Ongeldig Order");
       newAlert.setHeaderText("Ongeldige Order!");
       newAlert.setContentText("U kan geen order sturen zonder items!");
       newAlert.show();
   }

   /**
       * Deze functie laat een melding zien over ongeldige productinformatie.
       * @see Models.Product
       * @see Alert
   */
   public void SendInvalidProductWarning() {
       Alert newAlert = new Alert(AlertType.ERROR);
       newAlert.setTitle("Ongeldig Product");
       newAlert.setHeaderText("Ongeldig Product!");
       newAlert.setContentText("Voer alstublieft een product in die geldige informatie bevat!");
       newAlert.show();
   }

   /**
      * Deze functie stuurt een notificatie om aan de gebruiker te laten weten dat hun bestelling onderweg is.
      * @param User orderUser - Welke user is het voor bedoeld?
      * @see Models.User
      * @see Models.Order
      * @see Alert
   */
   public void SendOrderNotification(User orderUser) {
     Alert newAlert = new Alert(AlertType.INFORMATION);
     newAlert.setTitle("Order ingediend.");
     newAlert.setHeaderText("Order ingediend.");
     newAlert.setContentText(String.format("Bedankt %s!\n\nWe komen zo snel mogelijk richting %s.\nAls er problemen met uw bestelling zijn zullen we u proberen te bereiken op %s.", orderUser.name, orderUser.adress, orderUser.phone));
     newAlert.show();
   }
}