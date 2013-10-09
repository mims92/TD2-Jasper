package be.esi.alg2.ebiblio.exception;

/**
 * Exception lanc&eacute;e par les acc&eacute;s db
 */
public class EbiblioDbException extends EbiblioException {

    /**
     * Construit une instance de <code>EbiblioDbException</code> sans message.
     */
    public EbiblioDbException() {
    }

    /**
     * Construit une instance de <code>EbiblioDbException</code> avec message.
     * @param msg le message.
     */
    public EbiblioDbException(String msg) {
        super(msg);
    }
}
