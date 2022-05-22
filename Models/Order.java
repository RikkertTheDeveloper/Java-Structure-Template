package Models;

import java.util.ArrayList;

/**
    * De 'Order' klasse kan gebruikt worden om een lijst van producten bij te kunnen houden,
    * Deze order kan worden gewist en kan worden opgeslagen naar de database.
*/
public class Order {
    public ArrayList<Product> productList;
    public int id;

    /**
        * Constructor van de 'Order' klasse.
    */
    public Order() {
        this.productList = new ArrayList<Product>();
        id = 1234;
    }

    /**
        * Deze functie kan gebruikt worden om alle producten van de order te formatteren samen met de totaalprijs.
        * @return String - Een string die gebruikt kan worden voor een overzicht.
    */
    public String format(User selectedUser) {
        String finalString = "";
        finalString = String.format("%s%s%s%s", finalString, selectedUser.name + "\n", selectedUser.adress + "\n", selectedUser.phone + "\n \n");


        for (Product product : this.productList) {
            finalString = String.format("%s%s", finalString, product.format());
        }

        finalString = String.format("%s%s", finalString, "\nTotaalbedrag:    " + this.totaal());
        finalString = String.format("%s%s", finalString, "\nOrdernummer " + Integer.toString(this.id));
        return finalString;
    }

    /**
        * Deze functie voegt een 'Product' klasse toe aan de order.
        * @param productArgument - Het product dat toegevoegd moet worden.
        * @see Order
    */
    public void Add(Product productArgument) {
        this.productList.add(productArgument);
    }

    /**
        * Deze functie telt alle productprijzen bij elkaar op en zorgt ervoor dat deze goed op de uiteindelijke order komen te staan.
        * @return String - Een tekst met het eindbedrag.
        * @see Order
    */
    public String totaal() {
        Double totaalBedrag = 0.00;

        for (Product product : this.productList) {
            totaalBedrag += product.price;
        }

        return String.format("%.2f", totaalBedrag);
    }

    /**
        * Deze functie schoont de order op.
    */
    public void Clear() {
        this.productList.clear();
    }
}
