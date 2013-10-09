/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.entite;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "EDITEUR")
@NamedQueries({
    @NamedQuery(name = "Editeur.findAll", query = "SELECT e FROM Editeur e")})
public class Editeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EDID")
    private Long edid;
    @Basic(optional = false)
    @Column(name = "EDLIBELLE")
    private String edlibelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editeur")
    private Collection<Edition> editionCollection;

    public Editeur() {
    }

    public Editeur(Long edid) {
        this.edid = edid;
    }

    public Editeur(Long edid, String edlibelle) {
        this.edid = edid;
        this.edlibelle = edlibelle;
    }

    public Long getEdid() {
        return edid;
    }

    public void setEdid(Long edid) {
        this.edid = edid;
    }

    public String getEdlibelle() {
        return edlibelle;
    }

    public void setEdlibelle(String edlibelle) {
        this.edlibelle = edlibelle;
    }

    public Collection<Edition> getEditionCollection() {
        return editionCollection;
    }

    public void setEditionCollection(Collection<Edition> editionCollection) {
        this.editionCollection = editionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edid != null ? edid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editeur)) {
            return false;
        }
        Editeur other = (Editeur) object;
        if ((this.edid == null && other.edid != null) || (this.edid != null && !this.edid.equals(other.edid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Editeur[ edid=" + edid + " ]";
    }
    
}
