/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAGNO
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByIdEvent", query = "SELECT e FROM Event e WHERE e.eventPK.idEvent = :idEvent")
    , @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Event.findByEventDate", query = "SELECT e FROM Event e WHERE e.eventDate = :eventDate")
    , @NamedQuery(name = "Event.findByEventClass", query = "SELECT e FROM Event e WHERE e.eventClass = :eventClass")
    , @NamedQuery(name = "Event.findByEventCampus", query = "SELECT e FROM Event e WHERE e.eventCampus = :eventCampus")
    , @NamedQuery(name = "Event.findByEventResponsible", query = "SELECT e FROM Event e WHERE e.eventResponsible = :eventResponsible")
    , @NamedQuery(name = "Event.findByEventTrainee", query = "SELECT e FROM Event e WHERE e.eventTrainee = :eventTrainee")
    , @NamedQuery(name = "Event.findByEventHour", query = "SELECT e FROM Event e WHERE e.eventHour = :eventHour")
    , @NamedQuery(name = "Event.findByPersonidPerson", query = "SELECT e FROM Event e WHERE e.eventPK.personidPerson = :personidPerson")
    , @NamedQuery(name = "Event.findByCampusidCampus", query = "SELECT e FROM Event e WHERE e.eventPK.campusidCampus = :campusidCampus")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventPK eventPK;
    @Basic(optional = false)
    @Column(name = "EventName")
    private String eventName;
    @Basic(optional = false)
    @Column(name = "EventDate")
    @Temporal(TemporalType.DATE)
    private Date eventDate;
    @Basic(optional = false)
    @Column(name = "EventClass")
    private String eventClass;
    @Basic(optional = false)
    @Column(name = "EventCampus")
    private String eventCampus;
    @Basic(optional = false)
    @Column(name = "EventResponsible")
    private String eventResponsible;
    @Column(name = "EventTrainee")
    private String eventTrainee;
    @Basic(optional = false)
    @Column(name = "EventHour")
    private String eventHour;
    @OneToMany(mappedBy = "idEvent")
    private Collection<Eventequipament> eventequipamentCollection;
    @JoinColumn(name = "Campus_idCampus", referencedColumnName = "idCampus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campus campus;
    @JoinColumn(name = "Class_idClass", referencedColumnName = "idPlace")
    @ManyToOne(optional = false)
    private Place classidClass;
    @JoinColumn(name = "Person_idPerson", referencedColumnName = "idPerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public Event() {
    }

    public Event(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Event(EventPK eventPK, String eventName, Date eventDate, String eventClass, String eventCampus, String eventResponsible, String eventHour) {
        this.eventPK = eventPK;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventClass = eventClass;
        this.eventCampus = eventCampus;
        this.eventResponsible = eventResponsible;
        this.eventHour = eventHour;
    }

    public Event(int idEvent, int personidPerson, int campusidCampus) {
        this.eventPK = new EventPK(idEvent, personidPerson, campusidCampus);
    }

    public EventPK getEventPK() {
        return eventPK;
    }

    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventClass() {
        return eventClass;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass;
    }

    public String getEventCampus() {
        return eventCampus;
    }

    public void setEventCampus(String eventCampus) {
        this.eventCampus = eventCampus;
    }

    public String getEventResponsible() {
        return eventResponsible;
    }

    public void setEventResponsible(String eventResponsible) {
        this.eventResponsible = eventResponsible;
    }

    public String getEventTrainee() {
        return eventTrainee;
    }

    public void setEventTrainee(String eventTrainee) {
        this.eventTrainee = eventTrainee;
    }

    public String getEventHour() {
        return eventHour;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    @XmlTransient
    public Collection<Eventequipament> getEventequipamentCollection() {
        return eventequipamentCollection;
    }

    public void setEventequipamentCollection(Collection<Eventequipament> eventequipamentCollection) {
        this.eventequipamentCollection = eventequipamentCollection;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Place getClassidClass() {
        return classidClass;
    }

    public void setClassidClass(Place classidClass) {
        this.classidClass = classidClass;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventPK != null ? eventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventPK == null && other.eventPK != null) || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Event[ eventPK=" + eventPK + " ]";
    }
    
}
