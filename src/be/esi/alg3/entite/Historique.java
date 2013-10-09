/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author G35099
 */
@Entity
@Table(name = "HISTORIQUE")
@NamedQueries({
    @NamedQuery(name = "Historique.findAll", query = "SELECT h FROM Historique h")})
public class Historique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HID")
    private Long hid;
    @Basic(optional = false)
    @Column(name = "DATEEMPRUNT")
    @Temporal(TemporalType.DATE)
    private Date dateemprunt;
    @Basic(optional = false)
    @Column(name = "DATERETOUR")
    @Temporal(TemporalType.DATE)
    private Date dateretour;
    @JoinColumn(name = "LIVRE", referencedColumnName = "LIVID")
    @ManyToOne(optional = false)
    private Livre livre;
    @JoinColumn(name = "LECTEUR", referencedColumnName = "LECID")
    @ManyToOne
    private Lecteur lecteur;

    public Historique() {
    }

    public Historique(Long hid) {
        this.hid = hid;
    }

    public Historique(Long hid, Date dateemprunt, Date dateretour) {
        this.hid = hid;
        this.dateemprunt = dateemprunt;
        this.dateretour = dateretour;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public Date getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(Date dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hid != null ? hid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historique)) {
            return false;
        }
        Historique other = (Historique) object;
        if ((this.hid == null && other.hid != null) || (this.hid != null && !this.hid.equals(other.hid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Historique[ hid=" + hid + " ]";
    }
    
}
