package Database.Data;

import Database.Classes.Query;
import Interfaces.Table;

public class DrinksTable implements Table {

    public void Create() {
        this.DropIfExists();

        try {
            Query creationQuery = new Query("""
                CREATE TABLE drinks (
                    `uuid` varchar(40) DEFAULT NULL,
                    `product_name` varchar(40) DEFAULT NULL
                );
            """);
            creationQuery.exucute();
        } catch (Exception e) {
            System.out.println("Iets ging fout terwijl we de 'drinks' tabel probeerde te maken.");
        }
    }

    public void Drop() {
        try {
            Query dropQuery = new Query("Drop `drinks`");
            dropQuery.exucute();
        } catch (Exception e) {
            System.out.println("Iets ging fout terwijl we de 'drinks' tabel probeerde te verwijderen.");
        }
    }

    public void DropIfExists() {
        try {
            Query dropQuery = new Query("DROP TABLE IF EXISTS `drinks`;");
            dropQuery.exucute();
        } catch (Exception e) {
            System.out.println("Iets ging fout terwijl we de 'drinks' tabel probeerde te verwijderen.");
        }
    }
}
