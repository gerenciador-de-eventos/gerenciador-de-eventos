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
@Table(name = "campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campus.findAll", query = "SELECT c FROM Campus c")
    , @NamedQuery(name = "Campus.findByIdCampus", query = "SELECT c FROM Campus c WHERE c.idCampus = :idCampus")
    , @NamedQuery(name = "Campus.findByCampusName", query = "SELECT c FROM Campus c WHERE c.campusName = :campusName")
    , @NamedQuery(name = "Campus.findByCampusCity", query = "SELECT c FROM Campus c WHERE c.campusCity = :campusCity")
    , @NamedQuery(name = "Campus.findByCampusFantasyName", query = "SELECT c FROM Campus c WHERE c.campusFantasyName = :campusFantasyName")})
public class Campus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCampus")
    private Integer idCampus;
    @Basic(optional = false)
    @Column(name = "CampusName")
    private String campusName;
    @Basic(optional = false)
    @Column(name = "CampusCity")
    private String campusCity;
    @Basic(optional = false)
    @Column(name = "CampusFantasyName")
    private String campusFantasyName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campusidCampus")
    private Collection<Event> eventCollection;

    public Campus() {
    }

    public Campus(Integer idCampus) {
        this.idCampus = idCampus;
    }

    public Campus(Integer idCampus, String campusName, String campusCity, String campusFantasyName) {
        this.idCampus = idCampus;
        this.campusName = campusName;
        this.campusCity = campusCity;
        this.campusFantasyName = campusFantasyName;
    }

    public Integer getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(Integer idCampus) {
        this.idCampus = idCampus;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusCity() {
        return campusCity;
    }

    public void setCampusCity(String campusCity) {
        this.campusCity = campusCity;
    }

    public String getCampusFantasyName() {
        return campusFantasyName;
    }

    public void setCampusFantasyName(String campusFantasyName) {
        this.campusFantasyName = campusFantasyName;
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
        hash += (idCampus != null ? idCampus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campus)) {
            return false;
        }
        Campus other = (Campus) object;
        if ((this.idCampus == null && other.idCampus != null) || (this.idCampus != null && !this.idCampus.equals(other.idCampus))) {
            return false;
        }
        return true;
    }

   @Override
    public String toString() {
        //return "model.Campus[ idCampus=" + idCampus + " ]";
        return getCampusName();
    }
    
}
