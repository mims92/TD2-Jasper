package be.esi.alg2.ebiblio.exception;

/**
 * Exception lanc&eacute;e par une m&eacute;thode d'une 'Facade'
 */
public class EbiblioException extends Exception {

    /**
     * Construit une instance de <code>EbiblioException</code> sans message
     */
    public EbiblioException() {
    }

    /**
     * Construit une instance de <code>EbiblioException</code> avec message.
     * @param msg le message.
     */
    public EbiblioException(String msg) {
        super(msg);
    }
}
