/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "equipaments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipaments.findAll", query = "SELECT e FROM Equipaments e")
    , @NamedQuery(name = "Equipaments.findByIdEquipaments", query = "SELECT e FROM Equipaments e WHERE e.idEquipaments = :idEquipaments")
    , @NamedQuery(name = "Equipaments.findByEquipamentsName", query = "SELECT e FROM Equipaments e WHERE e.equipamentsName = :equipamentsName")})
public class Equipaments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipaments")
    private Integer idEquipaments;
    @Basic(optional = false)
    @Column(name = "EquipamentsName")
    private String equipamentsName;
    @JoinColumn(name = "EquipamentsType", referencedColumnName = "idType")
    @ManyToOne(optional = false)
    private Type equipamentsType;
    @OneToMany(mappedBy = "idEquipament")
    private Collection<Eventequipament> eventequipamentCollection;

    public Equipaments() {
    }

    public Equipaments(Integer idEquipaments) {
        this.idEquipaments = idEquipaments;
    }

    public Equipaments(Integer idEquipaments, String equipamentsName) {
        this.idEquipaments = idEquipaments;
        this.equipamentsName = equipamentsName;
    }

    public Integer getIdEquipaments() {
        return idEquipaments;
    }

    public void setIdEquipaments(Integer idEquipaments) {
        this.idEquipaments = idEquipaments;
    }

    public String getEquipamentsName() {
        return equipamentsName;
    }

    public void setEquipamentsName(String equipamentsName) {
        this.equipamentsName = equipamentsName;
    }

    public Type getEquipamentsType() {
        return equipamentsType;
    }

    public void setEquipamentsType(Type equipamentsType) {
        this.equipamentsType = equipamentsType;
    }

    @XmlTransient
    public Collection<Eventequipament> getEventequipamentCollection() {
        return eventequipamentCollection;
    }

    public void setEventequipamentCollection(Collection<Eventequipament> eventequipamentCollection) {
        this.eventequipamentCollection = eventequipamentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipaments != null ? idEquipaments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipaments)) {
            return false;
        }
        Equipaments other = (Equipaments) object;
        if ((this.idEquipaments == null && other.idEquipaments != null) || (this.idEquipaments != null && !this.idEquipaments.equals(other.idEquipaments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Equipaments[ idEquipaments=" + idEquipaments + " ]";
    }
    
}
