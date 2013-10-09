package be.esi.alg2.ebiblio.exception;

/**
 * Exception lanc&eacute;e lorsqu'une méthode de la logique métier rencontre un problème
 */
public class EbiblioBusinessException extends EbiblioException {

    /**
     * Construit une instance de <code>EbiblioBusinessException</code> sans message.
     */
    public EbiblioBusinessException() {
    }

    /**
     * Construit une instance de <code>EbiblioBusinessException</code> avec message.
     * @param msg le message.
     */
    public EbiblioBusinessException(String msg) {
        super(msg);
    }
}
