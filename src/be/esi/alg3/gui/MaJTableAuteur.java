/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be.esi.alg3.gui;
 
import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;

/**
 *
 * @author Florian
 */
public class MaJTableAuteur extends MaJTable<AuteurDto> {

    public MaJTableAuteur() throws MaJTableInitialisationException {
    }

    public MaJTableAuteur(Collection<AuteurDto> data) throws MaJTableInitialisationException {
        this();
        setData(data);
    }

    @Override
    protected void setTitres() {
        String[] t = {"id", "Nom"};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", "getAuteur"};
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {0, 0};
        largeurs = t;
    }

}
