package be.esi.alg3.jasper.sel;

import be.esi.alg3.jasper.entite.Typelecteur;

/**
 * Classe d'instanciation de critères de sélection de lecteurs
 * Le critère complet correspond au ET logique de toutes les valeurs significatives données, le SelDto peut aussi porter un critère d'ordre demandé.
 *
 * <ul>Critères de sélection:
 * <li>id : valeur de la clé du lecteur.  Ce critère est déterminant</li>
 * <li>debnom : début du nom</li>
 * <li>prénom : prénom</li>
 * <li>eMail : eMail complet</li>
 * <li>type : id du type de lecteur cherché</li>
 * </ul>
 * <br/>
 *
 *
 *
 */
public class LecteurSel {

    private String debNom, prenom, eMail, type;
    private int id;
    private int order=NOORDER;
    public static final int NOORDER=0,ORDERBYNOM=1;

    public LecteurSel(){
    }

    public LecteurSel(int id){
        this.id=id;
    }

    public LecteurSel(String debNom, String prenom, String eMail, String type) {
        this.debNom = debNom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.type = type;
    }

    public LecteurSel(String debNom, String prenom, String eMail, Typelecteur type) {
        this.debNom = debNom;
        this.prenom = prenom;
        this.eMail = eMail;
        this.type = type.getTpid();
    }

    public String getDebNom() {
        return debNom;
    }

    public void setDebNom(String debNom) {
        this.debNom = debNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        String res = "Critère de recherche de Lecteur:";
        if (id > 0) {
            res = res + " id = " + getId();
        } else {
            if (getDebNom() != null) {
                res = res + " nom commençant par " + getDebNom();
            }
            if (getPrenom() != null) {
                res = res + " prénom égal à " + getPrenom();
            }
            if (geteMail() != null) {
                res = res + " eMail contenant " + geteMail();
            }
            if (getType() != null) {
                res = res + " de type " + getType();
            }
        }
        if (order==ORDERBYNOM){
            res=res+"\n Demande de tri sur le nom!";
        }
        return res;

    }

}
