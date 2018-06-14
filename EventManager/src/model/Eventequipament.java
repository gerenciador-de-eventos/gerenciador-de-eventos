/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MAGNO
 */
@Entity
@Table(name = "eventequipament")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventequipament.findAll", query = "SELECT e FROM Eventequipament e")
    , @NamedQuery(name = "Eventequipament.findByIdEventEquipament", query = "SELECT e FROM Eventequipament e WHERE e.idEventEquipament = :idEventEquipament")})
public class Eventequipament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEventEquipament")
    private Integer idEventEquipament;
    @JoinColumn(name = "idEquipament", referencedColumnName = "idEquipaments")
    @ManyToOne
    private Equipaments idEquipament;
    @JoinColumn(name = "idEvent", referencedColumnName = "idEvent")
    @ManyToOne
    private Event idEvent;

    public Eventequipament() {
    }

    public Eventequipament(Integer idEventEquipament) {
        this.idEventEquipament = idEventEquipament;
    }

    public Integer getIdEventEquipament() {
        return idEventEquipament;
    }

    public void setIdEventEquipament(Integer idEventEquipament) {
        this.idEventEquipament = idEventEquipament;
    }

    public Equipaments getIdEquipament() {
        return idEquipament;
    }

    public void setIdEquipament(Equipaments idEquipament) {
        this.idEquipament = idEquipament;
    }

    public Event getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Event idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventEquipament != null ? idEventEquipament.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventequipament)) {
            return false;
        }
        Eventequipament other = (Eventequipament) object;
        if ((this.idEventEquipament == null && other.idEventEquipament != null) || (this.idEventEquipament != null && !this.idEventEquipament.equals(other.idEventEquipament))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Eventequipament[ idEventEquipament=" + idEventEquipament + " ]";
    }
    
}
