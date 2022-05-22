package Database.Helpers;

import java.sql.ResultSet;
import java.util.List;

import Database.Classes.DataManager;
import Interfaces.Manager;

/**
    * Dit is een interface die omgaat met de 'Order' klasse.
    * @see Database.Classes.DataManager
    * @see Interfaces.Manager
    * @see Models.Order
    * @implNote - Zorg ervoor dat deze klasse beter gebruik maakt van de order klasse.
*/
public class OrderDataManager extends DataManager implements Manager {

    public Boolean Create(List<Object> Data) {
        return true;
    }

    public ResultSet Get(byte[] uuid) {
        return null;
    }

    public Boolean Update(byte[] uuid, List<Object> Data) {
        return true;
    }

    public Boolean Delete(byte[] uuid) {
        return true;
    }
}
