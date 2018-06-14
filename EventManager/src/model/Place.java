/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAGNO
 */
@Entity
@Table(name = "place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
    , @NamedQuery(name = "Place.findByIdPlace", query = "SELECT p FROM Place p WHERE p.idPlace = :idPlace")
    , @NamedQuery(name = "Place.findByPlaceName", query = "SELECT p FROM Place p WHERE p.placeName = :placeName")
    , @NamedQuery(name = "Place.findByPlaceCampus", query = "SELECT p FROM Place p WHERE p.placeCampus = :placeCampus")})
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlace")
    private Integer idPlace;
    @Basic(optional = false)
    @Column(name = "PlaceName")
    private String placeName;
    @Basic(optional = false)
    @Column(name = "PlaceCampus")
    private String placeCampus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classidClass")
    private Collection<Event> eventCollection;

    public Place() {
    }

    public Place(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public Place(Integer idPlace, String placeName, String placeCampus) {
        this.idPlace = idPlace;
        this.placeName = placeName;
        this.placeCampus = placeCampus;
    }

    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceCampus() {
        return placeCampus;
    }

    public void setPlaceCampus(String placeCampus) {
        this.placeCampus = placeCampus;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlace != null ? idPlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.idPlace == null && other.idPlace != null) || (this.idPlace != null && !this.idPlace.equals(other.idPlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Place[ idPlace=" + idPlace + " ]";
    }
    
}
