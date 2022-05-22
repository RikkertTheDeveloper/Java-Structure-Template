package Database.Classes;
import java.sql.ResultSet;

/**
    * De connectie klasse zorgt ervoor dat er een verbinding gemaakt kan worden met de database,
    * En deze ook makkelijk verbroken kan worden.
*/
public class QueryConnection {
    Database currentDatabase;

    public QueryConnection() {
        this.currentDatabase = new Database();
    }

    /**
        * Deze functie voert een query uit door met een 'Database' klasse te verbinden en ervoor te zorgen
        * dat deze database klasse een query op keuze uitvoert en de resultaten teruggeeft.
        * @param query De query die uitgevoerd moet worden.
        * @return Een 'ResultSet' object met alle data.
        * @see Database
        * @see ResultSet
    */
    public ResultSet get(String query) {
        currentDatabase.connect();
        ResultSet datbaseResults = currentDatabase.get(query);
        currentDatabase.disconnect();

        return datbaseResults;
    }

    public void exucute(String query) {
        currentDatabase.connect();
        currentDatabase.get(query);
        currentDatabase.disconnect();
    }

    /**
        * Deze functie sluit de verbinding tussen de QueryConnection klasse en 'Database' klasse af.
    */
    public void close() {
        this.currentDatabase.disconnect();
    }
}
