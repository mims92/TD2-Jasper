package be.esi.alg3.jasper.sel;

import be.esi.alg3.jasper.entities.Edition;
import be.esi.alg3.jasper.entities.Lecteur;



/**
 * Classe d'instanciation de critères de sélection de livres
 * Le critère complet correspond au ET logique de toutes les valeurs significatives données.
 *
 * <ul>Critères de sélection:
 * <li>id : valeur de la clé du livre.  Ce critère est déterminant</li>
 * <li>edition : dto persistant de l'édition des livre cherchés</li>
 * <li>lecteur : dto persistant du lecteur ayant les livres en emprunt</li>
 * </ul>
 * <br/>
 * */
public class LivreSel {

    private Edition edition;
    private  Lecteur lecteur;
    private int livId;

    public LivreSel(int livId){
        this.livId=livId;
    }

    public LivreSel(Lecteur lecteur){
        setLecteur(lecteur);
    }

    public LivreSel(Edition edition){
        setEdition(edition);
    }

    public Edition getEdition() {
        return edition;
    }

     public final void setEdition(Edition edition){
        this.edition=edition;

    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public final void setLecteur(Lecteur lecteur){
        this.lecteur=lecteur;
    }

    public int getLivId() {
        return livId;
    }

    @Override
    public String toString(){

        String ret = "Critère de recherche de Livre:";
        if(getLivId()!=0) ret=ret+"   livId = "+getLivId();
        else if(getEdition()!=null) ret=ret+"   edition "+getEdition().getIsbn13();
        else if(getLecteur()!=null) ret=ret+"    emprunté par "+getLecteur().getNom();
        return ret;

    }

}
