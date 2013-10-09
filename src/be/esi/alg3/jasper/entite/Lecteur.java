/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.jasper.entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author G35099
 */
@Entity
@Table(name = "LECTEUR")
@NamedQueries({
    @NamedQuery(name = "Lecteur.findAll", query = "SELECT l FROM Lecteur l")})
public class Lecteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LECID")
    private Long lecid;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "lecteur")
    private Collection<Historique> historiqueCollection;
    @JoinColumn(name = "TYPELECTEUR", referencedColumnName = "TPID")
    @ManyToOne(optional = false)
    private Typelecteur typelecteur;
    @OneToMany(mappedBy = "lecteur")
    private Collection<Livre> livreCollection;

    public Lecteur() {
    }

    public Lecteur(Long lecid) {
        this.lecid = lecid;
    }

    public Lecteur(Long lecid, String nom) {
        this.lecid = lecid;
        this.nom = nom;
    }

    public Long getLecid() {
        return lecid;
    }

    public void setLecid(Long lecid) {
        this.lecid = lecid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Historique> getHistoriqueCollection() {
        return historiqueCollection;
    }

    public void setHistoriqueCollection(Collection<Historique> historiqueCollection) {
        this.historiqueCollection = historiqueCollection;
    }

    public Typelecteur getTypelecteur() {
        return typelecteur;
    }

    public void setTypelecteur(Typelecteur typelecteur) {
        this.typelecteur = typelecteur;
    }

    public Collection<Livre> getLivreCollection() {
        return livreCollection;
    }

    public void setLivreCollection(Collection<Livre> livreCollection) {
        this.livreCollection = livreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecid != null ? lecid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecteur)) {
            return false;
        }
        Lecteur other = (Lecteur) object;
        return Objects.equals(this.lecid, other.lecid);
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Lecteur[ lecid=" + lecid + " ]";
    }
    
}
