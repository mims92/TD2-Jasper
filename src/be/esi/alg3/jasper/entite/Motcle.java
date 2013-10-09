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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author G35099
 */
@Entity
@Table(name = "MOTCLE")
@NamedQueries({
    @NamedQuery(name = "Motcle.findAll", query = "SELECT m FROM Motcle m")})
public class Motcle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MCID")
    private Long mcid;
    @Basic(optional = false)
    @Column(name = "MOT")
    private String mot;
    @ManyToMany(mappedBy = "motcleCollection")
    private Collection<Edition> editionCollection;

    public Motcle() {
    }

    public Motcle(Long mcid) {
        this.mcid = mcid;
    }

    public Motcle(Long mcid, String mot) {
        this.mcid = mcid;
        this.mot = mot;
    }

    public Long getMcid() {
        return mcid;
    }

    public void setMcid(Long mcid) {
        this.mcid = mcid;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
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
        hash += (mcid != null ? mcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motcle)) {
            return false;
        }
        Motcle other = (Motcle) object;
        return Objects.equals(this.mcid, other.mcid);
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Motcle[ mcid=" + mcid + " ]";
    }
    
}
