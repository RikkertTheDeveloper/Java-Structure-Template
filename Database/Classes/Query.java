package Database.Classes;

import java.sql.ResultSet;

/**
    * De query klasse word gebruikt om makkelijk in een regel belangrijke informatie op te kunnen halen vanaf
    * de database zonder extra steppen ertussen.
*/
public class Query {
    public String queryCommand;

    public Query(String queryCommand) {
        this.queryCommand = queryCommand;
    }

    /**
        * Deze functie maakt een QueryConnection en zorgt ervoord at hiervan de resultaten teruggegeven worden.
        * @return ResultSet een 'ResultSet' met data.
        * @see QueryConnection
        * @see ResultSet
    */
    public ResultSet get() {
        QueryConnection newConnection = new QueryConnection();
        ResultSet queryResult = newConnection.get(this.queryCommand);
        newConnection.close();

        return queryResult;
    }

    /**
        * Deze functie maakt een QueryConnection en zorgt ervoor dat het commando uitgevoerd word.
        * @see QueryConnection
    */
    public void Exucute() {
        QueryConnection newConnection = new QueryConnection();
        newConnection.exucute(this.queryCommand);
        newConnection.close();
    }
}
