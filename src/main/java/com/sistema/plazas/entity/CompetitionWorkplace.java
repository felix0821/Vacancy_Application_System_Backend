/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "competition_workplace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetitionWorkplace.findAll", query = "SELECT c FROM CompetitionWorkplace c"),
    @NamedQuery(name = "CompetitionWorkplace.findByIdCompetitionWorkplace", query = "SELECT c FROM CompetitionWorkplace c WHERE c.idCompetitionWorkplace = :idCompetitionWorkplace"),
    @NamedQuery(name = "CompetitionWorkplace.findByName", query = "SELECT c FROM CompetitionWorkplace c WHERE c.name = :name"),
    @NamedQuery(name = "CompetitionWorkplace.findByOpeningDate", query = "SELECT c FROM CompetitionWorkplace c WHERE c.openingDate = :openingDate"),
    @NamedQuery(name = "CompetitionWorkplace.findByDeadline", query = "SELECT c FROM CompetitionWorkplace c WHERE c.deadline = :deadline"),
    @NamedQuery(name = "CompetitionWorkplace.findByDescription", query = "SELECT c FROM CompetitionWorkplace c WHERE c.description = :description"),
    @NamedQuery(name = "CompetitionWorkplace.findByEvaluationDate", query = "SELECT c FROM CompetitionWorkplace c WHERE c.evaluationDate = :evaluationDate"),
    @NamedQuery(name = "CompetitionWorkplace.findByState", query = "SELECT c FROM CompetitionWorkplace c WHERE c.state = :state")})
public class CompetitionWorkplace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_competition_workplace")
    private Long idCompetitionWorkplace;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "openingDate")
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @Basic(optional = false)
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "evaluationDate")
    @Temporal(TemporalType.DATE)
    private Date evaluationDate;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetitionWorkplace")
    private Collection<Postulant> postulantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetitionWorkplace")
    private Collection<MasterClass> masterClassCollection;
    @JoinColumn(name = "id_workplace", referencedColumnName = "id_workplace")
    @ManyToOne
    private Workplace idWorkplace;

    public CompetitionWorkplace() {
    }

    public CompetitionWorkplace(Long idCompetitionWorkplace) {
        this.idCompetitionWorkplace = idCompetitionWorkplace;
    }

    public CompetitionWorkplace(Long idCompetitionWorkplace, String name, Date openingDate, Date deadline, String description, Date evaluationDate, Character state) {
        this.idCompetitionWorkplace = idCompetitionWorkplace;
        this.name = name;
        this.openingDate = openingDate;
        this.deadline = deadline;
        this.description = description;
        this.evaluationDate = evaluationDate;
        this.state = state;
    }

    public Long getIdCompetitionWorkplace() {
        return idCompetitionWorkplace;
    }

    public void setIdCompetitionWorkplace(Long idCompetitionWorkplace) {
        this.idCompetitionWorkplace = idCompetitionWorkplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Postulant> getPostulantCollection() {
        return postulantCollection;
    }

    public void setPostulantCollection(Collection<Postulant> postulantCollection) {
        this.postulantCollection = postulantCollection;
    }

    @XmlTransient
    public Collection<MasterClass> getMasterClassCollection() {
        return masterClassCollection;
    }

    public void setMasterClassCollection(Collection<MasterClass> masterClassCollection) {
        this.masterClassCollection = masterClassCollection;
    }

    public Workplace getIdWorkplace() {
        return idWorkplace;
    }

    public void setIdWorkplace(Workplace idWorkplace) {
        this.idWorkplace = idWorkplace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetitionWorkplace != null ? idCompetitionWorkplace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetitionWorkplace)) {
            return false;
        }
        CompetitionWorkplace other = (CompetitionWorkplace) object;
        if ((this.idCompetitionWorkplace == null && other.idCompetitionWorkplace != null) || (this.idCompetitionWorkplace != null && !this.idCompetitionWorkplace.equals(other.idCompetitionWorkplace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.CompetitionWorkplace[ idCompetitionWorkplace=" + idCompetitionWorkplace + " ]";
    }
    
}
