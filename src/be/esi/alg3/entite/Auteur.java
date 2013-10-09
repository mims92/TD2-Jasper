/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg3.entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author G35099
 */
@Entity
@Table(name = "AUTEUR")
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a")})
public class Auteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AUTID")
    private Long autid;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @JoinTable(name = "AECRIT", joinColumns = {
        @JoinColumn(name = "AUTEUR", referencedColumnName = "AUTID")}, inverseJoinColumns = {
        @JoinColumn(name = "EDITION", referencedColumnName = "EDID")})
    @ManyToMany
    private Collection<Edition> editionCollection;

    public Auteur() {
    }

    public Auteur(Long autid) {
        this.autid = autid;
    }

    public Auteur(Long autid, String nom) {
        this.autid = autid;
        this.nom = nom;
    }

    public Long getAutid() {
        return autid;
    }

    public void setAutid(Long autid) {
        this.autid = autid;
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

    public Collection<Edition> getEditionCollection() {
        return editionCollection;
    }

    public void setEditionCollection(Collection<Edition> editionCollection) {
        this.editionCollection = editionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autid != null ? autid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.autid == null && other.autid != null) || (this.autid != null && !this.autid.equals(other.autid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Auteur[ autid=" + autid + " ]";
    }
    
}
