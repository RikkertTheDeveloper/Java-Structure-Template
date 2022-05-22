package Database.Classes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/**
    * Deze 'DataManager' klasse is verantwoordelijk voor utilty functies te geven
    * Voor andere managers om te gebruiken.
    * @see UUID
*/
public class DataManager {

    /**
        * Deze functie geeft een UUID terug als een String
        * @return String - De gegenereerde UUID.
    */
    public String GenerateStringUUID() {
        return UUID.randomUUID().toString();
    }

    /**
        * Deze fucntie geeft een binare variant terug van een UUID.
        * @return byte[] - Een binare variant van de UUID.
    */
    public byte[] GenerateBinaryUUID() {
        UUID uuid = UUID.randomUUID();
        byte[] uuidBytes = new byte[16];

        // Zet de UUID over naar een binair formaat.
        ByteBuffer.wrap(uuidBytes)
        .order(ByteOrder.BIG_ENDIAN)
        .putLong(uuid.getMostSignificantBits())
        .putLong(uuid.getLeastSignificantBits());

        return uuidBytes;
    }
}
