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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "EDITION")
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM Edition e")})
public class Edition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EDID")
    private Long edid;
    @Basic(optional = false)
    @Column(name = "ISBN13")
    private String isbn13;
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "TITRE")
    private String titre;
    @Column(name = "FORMAT")
    private String format;
    @Column(name = "COLLECTION")
    private String collection;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "ANNEEPARUTION")
    private Short anneeparution;
    @ManyToMany(mappedBy = "editionCollection")
    private Collection<Auteur> auteurCollection;
    @JoinTable(name = "ACLE", joinColumns = {
        @JoinColumn(name = "EDITION", referencedColumnName = "EDID")}, inverseJoinColumns = {
        @JoinColumn(name = "MOT", referencedColumnName = "MCID")})
    @ManyToMany
    private Collection<Motcle> motcleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edition")
    private Collection<Livre> livreCollection;
    @JoinColumn(name = "EDITEUR", referencedColumnName = "EDID")
    @ManyToOne(optional = false)
    private Editeur editeur;

    public Edition() {
    }

    public Edition(Long edid) {
        this.edid = edid;
    }

    public Edition(Long edid, String isbn13, String isbn, String titre) {
        this.edid = edid;
        this.isbn13 = isbn13;
        this.isbn = isbn;
        this.titre = titre;
    }

    public Long getEdid() {
        return edid;
    }

    public void setEdid(Long edid) {
        this.edid = edid;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Short getAnneeparution() {
        return anneeparution;
    }

    public void setAnneeparution(Short anneeparution) {
        this.anneeparution = anneeparution;
    }

    public Collection<Auteur> getAuteurCollection() {
        return auteurCollection;
    }

    public void setAuteurCollection(Collection<Auteur> auteurCollection) {
        this.auteurCollection = auteurCollection;
    }

    public Collection<Motcle> getMotcleCollection() {
        return motcleCollection;
    }

    public void setMotcleCollection(Collection<Motcle> motcleCollection) {
        this.motcleCollection = motcleCollection;
    }

    public Collection<Livre> getLivreCollection() {
        return livreCollection;
    }

    public void setLivreCollection(Collection<Livre> livreCollection) {
        this.livreCollection = livreCollection;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
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
        if (!(object instanceof Edition)) {
            return false;
        }
        Edition other = (Edition) object;
        if ((this.edid == null && other.edid != null) || (this.edid != null && !this.edid.equals(other.edid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.esi.alg3.entite.Edition[ edid=" + edid + " ]";
    }
    
}
