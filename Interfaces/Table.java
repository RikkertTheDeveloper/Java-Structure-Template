package Interfaces;

/**
    * Table interface,
    * Deze interface is verandwoordelijk voor het maken van een tabel in een modulaire manier.
*/
public interface Table {
    /**
        * Deze functie maakt de tabel aan.
        * @see Database.Classes.Query
        * @see https://dev.mysql.com/doc/refman/8.0/en/creating-tables.html
    */
    public void Create();

    /**
        * Deze functie haalt de tabel uit de database.
        * @see Database.Classes.Query
        * @see https://dev.mysql.com/doc/refman/8.0/en/drop-table.html
    */
    public void Drop();

    /**
        * Laat de tabel verwijderd worden al deze al bestaat.
    */
    public void DropIfExists();
}
