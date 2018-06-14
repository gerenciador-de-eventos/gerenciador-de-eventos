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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAGNO
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson")
    , @NamedQuery(name = "Person.findByPersonName", query = "SELECT p FROM Person p WHERE p.personName = :personName")
    , @NamedQuery(name = "Person.findByPersonRG", query = "SELECT p FROM Person p WHERE p.personRG = :personRG")
    , @NamedQuery(name = "Person.findByPersonCPF", query = "SELECT p FROM Person p WHERE p.personCPF = :personCPF")
    , @NamedQuery(name = "Person.findByPersonDateBorn", query = "SELECT p FROM Person p WHERE p.personDateBorn = :personDateBorn")
    , @NamedQuery(name = "Person.findByPersonPrivileges", query = "SELECT p FROM Person p WHERE p.personPrivileges = :personPrivileges")
    , @NamedQuery(name = "Person.findByPersonHourWork", query = "SELECT p FROM Person p WHERE p.personHourWork = :personHourWork")
    , @NamedQuery(name = "Person.findByPersonEmail", query = "SELECT p FROM Person p WHERE p.personEmail = :personEmail")
    , @NamedQuery(name = "Person.findByPersonPassword", query = "SELECT p FROM Person p WHERE p.personPassword = :personPassword")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerson")
    private Integer idPerson;
    @Column(name = "PersonName")
    private String personName;
    @Column(name = "PersonRG")
    private String personRG;
    @Column(name = "PersonCPF")
    private String personCPF;
    @Column(name = "PersonDateBorn")
    @Temporal(TemporalType.DATE)
    private Date personDateBorn;
    @Column(name = "PersonPrivileges")
    private Boolean personPrivileges;
    @Column(name = "PersonHourWork")
    private String personHourWork;
    @Basic(optional = false)
    @Column(name = "PersonEmail")
    private String personEmail;
    @Basic(optional = false)
    @Column(name = "PersonPassword")
    private String personPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personidPerson")
    private Collection<Event> eventCollection;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String personEmail, String personPassword) {
        this.idPerson = idPerson;
        this.personEmail = personEmail;
        this.personPassword = personPassword;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonRG() {
        return personRG;
    }

    public void setPersonRG(String personRG) {
        this.personRG = personRG;
    }

    public String getPersonCPF() {
        return personCPF;
    }

    public void setPersonCPF(String personCPF) {
        this.personCPF = personCPF;
    }

    public Date getPersonDateBorn() {
        return personDateBorn;
    }

    public void setPersonDateBorn(Date personDateBorn) {
        this.personDateBorn = personDateBorn;
    }

    public Boolean getPersonPrivileges() {
        return personPrivileges;
    }

    public void setPersonPrivileges(Boolean personPrivileges) {
        this.personPrivileges = personPrivileges;
    }

    public String getPersonHourWork() {
        return personHourWork;
    }

    public void setPersonHourWork(String personHourWork) {
        this.personHourWork = personHourWork;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
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
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Person[ idPerson=" + idPerson + " ]";
    }
    
}
