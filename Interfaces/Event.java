package Interfaces;

public interface Event {

    /**
        * Deze functie voert het event uit.
        * @return Object - Het resultaat van het event.
    */
    public Object Exucute();

    /**
        * Dit event geeft het resultaat van het event terug.
        * @return Object - Het resultaat van het event.
    */
    public Object GetResult();
}
