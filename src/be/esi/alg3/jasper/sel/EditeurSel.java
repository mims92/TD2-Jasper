/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.jasper.sel;

/**
 * Classe d'instanciation de critères de sélection d'éditeur.
 * <ul>Critères de sélection:
 * <li>id : identifiant</li>
 * <li>libelle : libellé de l'éditeur</li>
 * </ul>
 * <br/>
 * 
 * @author Florian Desneux
 */
public class EditeurSel {
    
    private int id;
    private String libelle;
    
    public EditeurSel(int id) {
        this.id = id;
    }
    
    public EditeurSel(String libelle) {
        this.libelle = libelle;
    }
    
    public EditeurSel(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    public int getId() {
        return id;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
