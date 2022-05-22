package Models;

public class User {
    public String name, adress, phone;

    /**
        * De constructor van de 'User' klasse.
        * @param String name - Wat is de naam van de user?
        * @param String adress - Was is het adres van de user?
        * @param String phone - Was is het telefoonnummber van de user?
    */
    public User(String name, String adress, String phone) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }
}
