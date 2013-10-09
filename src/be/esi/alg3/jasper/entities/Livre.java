/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.jasper.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author G35099
 */
@Entity
@Table(name = "LIVRE")
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l")})
public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LIVID")
    private Long livid;
    @Column(name = "DATEACQUISITION")
    @Temporal(TemporalType.DATE)
    private Date dateacquisition;
    @Column(name = "EMPDEPUIS")
    @Temporal(TemporalType.DATE)
    private Date empdepuis;
    @Column(name = "NBRAPPELS")
    private Short nbrappels;
    @Column(name = "RETOURPREVU")
    @Temporal(TemporalType.DATE)
    private Date retourprevu;
    @Basic(optional = false)
    @Column(name = "PERDU")
    private char perdu;
    @Basic(optional = false)
    @Column(name = "EMPRUNTABLE")
    private char empruntable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livre")
    private Collection<Historique> historiqueCollection;
    @JoinColumn(name = "LECTEUR", referencedColumnName = "LECID")
    @ManyToOne
    private Lecteur lecteur;
    @JoinColumn(name = "EDITION", referencedColumnName = "EDID")
    @ManyToOne(optional = false)
    private Edition edition;

    public Livre() {
    }

    public Livre(Long livid) {
        this.livid = livid;
    }

    public Livre(Long livid, char perdu, char empruntable) {
        this.livid = livid;
        this.perdu = perdu;
        this.empruntable = empruntable;
    }

    public Long getLivid() {
        return livid;
    }

    public void setLivid(Long livid) {
        this.livid = livid;
    }

    public Date getDateacquisition() {
        return dateacquisition;
    }

    public void setDateacquisition(Date dateacquisition) {
        this.dateacquisition = dateacquisition;
    }

    public Date getEmpdepuis() {
        return empdepuis;
    }

    public void setEmpdepuis(Date empdepuis) {
        this.empdepuis = empdepuis;
    }

    public Short getNbrappels() {
        return nbrappels;
    }

    public void setNbrappels(Short nbrappels) {
        this.nbrappels = nbrappels;
    }

    public Date getRetourprevu() {
        return retourprevu;
    }

    public void setRetourprevu(Date retourprevu) {
        this.retourprevu = retourprevu;
    }

    public char getPerdu() {
        return perdu;
    }

    public void setPerdu(char perdu) {
        this.perdu = perdu;
    }

    public char getEmpruntable() {
        return empruntable;
    }

    public void setEmpruntable(char empruntable) {
        this.empruntable = empruntable;
    }

    public Collection<Historique> getHistoriqueCollection() {
        return historiqueCollection;
    }

    public void setHistoriqueCollection(Collection<Historique> historiqueCollection) {
        this.historiqueCollection = historiqueCollection;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (livid != null ? livid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        return Objects.equals(this.livid, other.livid);
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Livre[ livid=" + livid + " ]";
    }
    
}
