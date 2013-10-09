package be.esi.alg3.jasper.sel;

import be.esi.alg3.jasper.entities.Edition;
import be.esi.alg3.jasper.entities.Lecteur;



/**
 * Classe d'instanciation de critères de sélection de commentaire.
 * @author g36548
 */
public class CommentaireSel {
    private Lecteur lecteur;
    private Edition edition;
    private int note;
    private String libelle;

    public CommentaireSel(Lecteur lecteur, Edition edition, int note, String libelle) {
        this.note = note;
        this.libelle = libelle;
        
        setEdition(edition);
        setLecteur(lecteur);
    }
    
    public CommentaireSel(Edition edition){
        setEdition(edition);
    }
    
    public CommentaireSel(Lecteur lecteur){
        setLecteur(lecteur);
    }
    
    public CommentaireSel(Lecteur lecteur, Edition edition){
        setEdition(edition);
        setLecteur(lecteur);
    }

    private final void setEdition(Edition edition) {
        this.edition = edition;
    }
    
    private final void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }
    
    public Lecteur getLecteur() {
        return lecteur;
    }

    public Edition getEdition() {
        return edition;
    }
    
    public int getNote() {
        return note;
    }
    
    public String getLibelle() {
        return libelle;
    }
}
