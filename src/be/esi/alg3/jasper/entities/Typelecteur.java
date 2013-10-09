/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.jasper.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author G35099
 */
@Entity
@Table(name = "TYPELECTEUR")
@NamedQueries({
    @NamedQuery(name = "Typelecteur.findAll", query = "SELECT t FROM Typelecteur t")})
public class Typelecteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TPID")
    private String tpid;
    @Basic(optional = false)
    @Column(name = "TPLIBELLE")
    private String tplibelle;
    @Basic(optional = false)
    @Column(name = "DELAIMAX")
    private short delaimax;
    @Basic(optional = false)
    @Column(name = "NBEMPRUNTSMAX")
    private short nbempruntsmax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typelecteur")
    private Collection<Lecteur> lecteurCollection;

    public Typelecteur() {
    }

    public Typelecteur(String tpid) {
        this.tpid = tpid;
    }

    public Typelecteur(String tpid, String tplibelle, short delaimax, short nbempruntsmax) {
        this.tpid = tpid;
        this.tplibelle = tplibelle;
        this.delaimax = delaimax;
        this.nbempruntsmax = nbempruntsmax;
    }

    public String getTpid() {
        return tpid;
    }

    public void setTpid(String tpid) {
        this.tpid = tpid;
    }

    public String getTplibelle() {
        return tplibelle;
    }

    public void setTplibelle(String tplibelle) {
        this.tplibelle = tplibelle;
    }

    public short getDelaimax() {
        return delaimax;
    }

    public void setDelaimax(short delaimax) {
        this.delaimax = delaimax;
    }

    public short getNbempruntsmax() {
        return nbempruntsmax;
    }

    public void setNbempruntsmax(short nbempruntsmax) {
        this.nbempruntsmax = nbempruntsmax;
    }

    public Collection<Lecteur> getLecteurCollection() {
        return lecteurCollection;
    }

    public void setLecteurCollection(Collection<Lecteur> lecteurCollection) {
        this.lecteurCollection = lecteurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpid != null ? tpid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typelecteur)) {
            return false;
        }
        Typelecteur other = (Typelecteur) object;
        return Objects.equals(this.tpid, other.tpid);
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Typelecteur[ tpid=" + tpid + " ]";
    }
    
}
