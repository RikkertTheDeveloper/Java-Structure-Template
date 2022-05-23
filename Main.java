import Database.Data.DrinksTable;
import Views.OrderView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
    * Deze klasse word gebruikt om de applicatie zelf op te zetten.
*/
public class Main extends Application {
    @Override

    /**
        * De start methode word gebruikt om alle interfaces benodigd op te starten.
        * Daarnaast zorgt deze methode ervoor dat alle dependendies die globaal zijn hier opgestart worden.
    */
    public void start(Stage primaryStage) {
        try {
            System.out.println("Booting application.");

            // Zet een nieuw 'OrderView' object op en render deze.
            OrderView currentOrderView = new OrderView(primaryStage);
            currentOrderView.Render();
            currentOrderView.SetupCallbacks();

            DrinksTable tableCreation = new DrinksTable();
            tableCreation.Create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
        * Deze functie start de complete applicatie op.
        * @param args CLI Argumenten
    */
    public static void main(String[] args) {
        launch(args);
    }
}