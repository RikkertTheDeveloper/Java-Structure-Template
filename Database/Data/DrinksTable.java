package Database.Data;

import Database.Classes.Query;
import Interfaces.Table;

public class DrinksTable implements Table {

    public void Create() {
        Query creationQuery = new Query("""
            CREATE `drinks`(
                `uuid` varchar(40) DEFAULT NULL,
                `product_name` varchar(40) DEFAULT NULL,
            )
        """);

        creationQuery.Exucute();
    }

    public void Drop() {
        Query dropQuery = new Query("Drop `drinks`");
        dropQuery.Exucute();
    }
}
