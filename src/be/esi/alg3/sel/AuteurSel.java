package be.esi.alg3.sel;

/**
 * Classe d'instanciation de critères de sélection d'auteurs
 *
 * Le critère complet correspond au ET logique de toutes les valeurs significatives données,
 * le SelDto peut aussi porter un critère d'ordre demandé.
 *
 * <ul>Critères de sélection:
 * <li>debnom : début du nom</li>
 * <li>id : valeur de la clé de l'auteur.  Ce critère est déterminant</li>
 * </ul>
 * <br/>
 *
 *
 *
 */
public class AuteurSel {
    private String nom;
    private int id;

    public AuteurSel(int id){
        this.id=id;
    }

    public AuteurSel(String nom){
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }
}
