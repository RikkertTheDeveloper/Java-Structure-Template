package Models;

public class Product {
   public String name;
   public Double price;

   /**
        * Product constructor
        * @param String name - Wat is de naam van het product?
        * @param Double price - Wat is de prijs van het product?
   */
   public Product(String name, double price) {
        this.name = name;
        this.price = price;
   }

   /**
        * Deze functie formatteert alle data van het product in een string.
        * @return String - Een string met de informatie over het product, inclusief line-break.
   */
   public String format() {
       return String.format("%s %s \n", this.name, Double.toString(this.price));
   }
}
