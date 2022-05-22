package Database.Classes;
import java.sql.*;

/**
    * De database klasse word gebruikt om modulair en makkelijk database-verbinden op 
    * te kunnen stellen.
*/
public class Database {

    // Defineer de constanten die we gebruiken voor de database connectie.
    public String host = "localhost";
    public String database = "fietsenwinkel";
    public String user = "root";
    public String password = "";
    public Connection currentConnection;

    public Database() {}

    /**
        * De 'connect' functie verbind met de SQL database driver en haalt de huidige database op
        * Die geselecteerd is.
    */
    public void connect() {
        try {
            this.currentConnection =  DriverManager.getConnection("jdbc:mysql://" +host+ "/" +database+ "?user=" +user+ "&password=" +password);
            System.out.println("Verbonden met database.");
            System.out.println(this.currentConnection);
        } catch (SQLException ex) {
            System.out.println("Er kon geen verbinding worden gemaakt met de database.");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
        * Deze methode wordt gebruikt om gegevens op te halen vanuit de database.
        * @param sql De SELECT query die uitgevoerd moet worden.
        * @return Een 'ResultSet' object met alle data erin.
    */
    public ResultSet get(String sql)
    {
        try {
            Statement stmt = this.currentConnection.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            System.out.println("Query uitgevoerd");
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return null;
    }

    /**
        * De 'disconnect' functie haalt de huidige this.currentConnection weg.
    */
    public void disconnect() {
        try {
            this.currentConnection.close();
            this.currentConnection = null;
        } catch (Exception e) {
            System.out.println("Error whilst closing database: " + e.getMessage());
        }
    }

    /**
        * Deze functie haalt de huidige connectie van de database op.
        * @return Connection De huidige connectie.
    */
    public Connection getConnection() {
        return this.currentConnection;
    }
}
