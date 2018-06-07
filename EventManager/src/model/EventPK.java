/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MAGNO
 */
@Embeddable
public class EventPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idEvent")
    private int idEvent;
    @Basic(optional = false)
    @Column(name = "Person_idPerson")
    private int personidPerson;
    @Basic(optional = false)
    @Column(name = "Campus_idCampus")
    private int campusidCampus;

    public EventPK() {
    }

    public EventPK(int idEvent, int personidPerson, int campusidCampus) {
        this.idEvent = idEvent;
        this.personidPerson = personidPerson;
        this.campusidCampus = campusidCampus;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getPersonidPerson() {
        return personidPerson;
    }

    public void setPersonidPerson(int personidPerson) {
        this.personidPerson = personidPerson;
    }

    public int getCampusidCampus() {
        return campusidCampus;
    }

    public void setCampusidCampus(int campusidCampus) {
        this.campusidCampus = campusidCampus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvent;
        hash += (int) personidPerson;
        hash += (int) campusidCampus;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
        if (this.idEvent != other.idEvent) {
            return false;
        }
        if (this.personidPerson != other.personidPerson) {
            return false;
        }
        if (this.campusidCampus != other.campusidCampus) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EventPK[ idEvent=" + idEvent + ", personidPerson=" + personidPerson + ", campusidCampus=" + campusidCampus + " ]";
    }
    
}
