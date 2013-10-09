package be.esi.alg3.jasper.sel;


import be.esi.alg2.ebiblio.exception.EbiblioDbException;
import be.esi.alg3.jasper.entities.Auteur;
import be.esi.alg3.jasper.entities.Editeur;
import java.util.Collection;

/**
 * Classe d'instanciation de critères de sélection de lecteurs.
 *
 * Le critère complet correspond au ET logique de toutes les valeurs significatives données,
 * le SelDto peut aussi porter un critère d'ordre demandé.
 *
 * <ul>Critères de sélection:
 * <li>isbn13 : valeur de l'isbn13.  Ce critère est déterminant</li>
 * <li>id : valeur de la clé de l'édition.  Ce critère est déterminant</li>
 * <li>mots : ensemble de mots caractérisant l'édition</li>
 * <li>editeur : dto persistant de l'éditeur de l'édition</li>
 * <li>auteur : dto persistant d'un auteur de l'édition</li>
 * <li>titre : chaîne reprise dans le titre de l'édition cherchée</li>
 * <li>collection : libellé de la collection dont doit relever l'édition cherchée</li>
 * </ul>
 * <br/>
 *
 *
 *
 */
public class EditionSel {

    private String isbn13, titre, collection;
    private int id, annee;

    private Editeur editeur;
    private Auteur auteur;

    private Collection<String> mots;

    private int order = NOORDER;
    /**
     * Aucun ordre particulier
     */
    public static final int NOORDER = 0;
    /**
     * Ordonné suivant le titre
     */
    public static final int ORDERBYTITRE = 1;
    /**
     * Ordonné suivant le libellé de l'éditeur
     */
    public static final int  ORDERBYEDITEUR = 2;
    /**
     * Ordonné suivant l'isbn13
     */
    public static final int  ORDERBYISBN13 = 3;




    public EditionSel() {
    }

    public EditionSel(int id) {
        this.id = id;
    }

    public EditionSel(String titre, Editeur editeur, String collection, Auteur auteur) {
        this.titre = titre;
        this.collection = collection;
        setEditeur(editeur);
        setAuteur(auteur);
    }

    public EditionSel(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getAnnee() {
        return annee;
    }
    
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String col) {
        this.collection = col;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * retourne le critère d'ordre demandé
     */
    public int getOrder() {
        return order;
    }

    /**
     * positionne le critère d'ordre demandé
     */
    public void setOrder(int order) {
        this.order = order;
    }

     public Auteur getAuteur() {
        return auteur;
    }

    public final void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
    
    public final void setAuteur(String nom) throws EbiblioDbException {
        this.auteur = new Auteur(0L, nom);
    }

    public Editeur getEditeur(){
        return editeur;
    }


    public final void setEditeur(Editeur editeur){
        this.editeur=editeur;
    }

    public Collection<String> getMots() {
        return mots;
    }

    public void setMots(Collection<String> mots) {
        this.mots = mots;
    }

    @Override
    public String toString() {
        String res = "Critère de recherche d'Edition:";
        if (id > 0) {
            res = res + " id = " + getId();
        } else {
            if (getIsbn13() != null) {
                res = res + " isbn13 égal à " + getIsbn13();
            } else {
                if (getTitre() != null) {
                    res = res + " titre contenant " + getTitre();
                }
                if (getCollection() != null) {
                    res = res + " collection  " + getCollection();
                }
                if (getAuteur() != null) {
                    res = res + " auteur  " + getAuteur().getNom();
                }
            }
        }
        switch (order) {
            case ORDERBYTITRE: {
                res = res + "\n Demande de tri sur le titre!";
                break;
            }
            case ORDERBYEDITEUR: {
                res = res + "\n Demande de tri sur le nom de l'éditeur!";
                break;
            }
            case ORDERBYISBN13: {
                res = res + "\n Demande de tri sur l'isbn13!";
                break;
            }
        }
        return res;

    }

}
