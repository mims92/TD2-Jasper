package be.esi.alg3.gui;

import be.esi.alg2.gui.outils.JDRechGenerique;

import flo.utils.panel.MsgOutil;
import java.util.Collection;
import be.esi.alg3.sel.AuteurSel;


/**
 * Fenêtre permettant de rechercher et de visualiser les arbres persistés recherchés.
 * @author Florian Desneux
 */
public class JDCodeBarre extends JDRechGenerique<ArbreSel, ArbreDto>{
    
    /**
     * Construit une Dialog de recherche et d'affiche d'arbre dto.
     * @param parent La Frame parente.
     * @param modal Modalité de la Dialog.
     * @param titre Le titre de la Dialog.
     * @param rech Le panel de recherche d'un arbre.
     * @param table La table permettant de voir les objets persistés recherchés.
     */
    public JDCodeBarre(java.awt.Frame parent, boolean modal, String titre, JPRechAuteur rech, MaJTableAuteur<AuteurDto> table) {
        //super(parent, modal, titre, rech, table);
        
        setTitle("Rechercher auteur");
    }
    
    @Override
    protected Collection<AuteurDto> recherche(AuteurSel s) {
        try {
            return ArbreBinaireFacade.getNomArbres(s);
        } catch(Exception e) {
            MsgOutil.showErreur("Erreur DB", e.getMessage());
            return null;
        }
    }

    /*public static void main(String[] args) throws MaJTableInitialisationException{
        new JDRechercheArbre(null, true, "Sélection d'arbres", new JPRechercheArbre(), new MaJTableArbre()).setVisible(true);
    }*/
}
