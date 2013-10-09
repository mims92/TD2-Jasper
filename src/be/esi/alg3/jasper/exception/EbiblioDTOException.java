package be.esi.alg2.ebiblio.exception;

/**
 * Exception lanc&eacute;e par la manipulation des dto
 */
public class EbiblioDTOException extends EbiblioException {

    /**
     * Construit une instance de <code>EbiblioDTOException</code> sans message.
     */
    public EbiblioDTOException() {
    }

    /**
     * Construit une instance de <code>EbiblioDTOException</code> avec message.
     * @param msg le message.
     */
    public EbiblioDTOException(String msg) {
        super(msg);
    }
}
