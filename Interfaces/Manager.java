package Interfaces;

import java.sql.ResultSet;
import java.util.List;

/**
    * De manager interface die word toegepast op alle 'DataManager' klasses
    * Voor meer informatie:
    * @see Markdown.Interfaces.md
*/
public interface Manager {
    /**
        * De create-functie van een manager, hier word data gepasseerd en word er automatisch een UUID opgehaald.
        * @param List<Object> Data - Een datalijst met elk soort data.
        * @return Boolean - De de operatie gelukt?
        * @see Query
        * @see DatabaseConnection
    */
    public Boolean Create(List<Object> Data);

    /**
        * Hier word een record uit te database opgehaald.
        * @param uuid - Wat is het ID van wat we proberen op te halen?
        * @return ResultSet - Alle data die terugkomt.
        * @see ResultSet
    */
    public ResultSet Get(byte[] uuid);

    /**
        * Deze functie kan bepaalde data updaten.
        * @param uuid - Wat is de UUID van de data die we proberen op te halen?
        * @param List<Object> - Een datalijst met alle variablen voor het checken.
        * @return Boolean - Is de operatie gelukt?
        * @see Query
    */
    public Boolean Update(byte[] uuid, List<Object> Data);

    /**
        * Deze operatie zorgt ervoor dat data verwijderd kan worden.
        * @param byte[] UUID - Wat is de UUID?
        * @return Boolean - Is de operatie geslaagd?
    */
    public Boolean Delete(byte[] uuid);
}