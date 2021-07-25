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
import javax.persistence.JoinColumns;
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
@Table(name = "evaluation_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluationSheet.findAll", query = "SELECT e FROM EvaluationSheet e"),
    @NamedQuery(name = "EvaluationSheet.findByObservation", query = "SELECT e FROM EvaluationSheet e WHERE e.observation = :observation"),
    @NamedQuery(name = "EvaluationSheet.findByQualificationDate", query = "SELECT e FROM EvaluationSheet e WHERE e.qualificationDate = :qualificationDate"),
    @NamedQuery(name = "EvaluationSheet.findByIdEvaluationSheet", query = "SELECT e FROM EvaluationSheet e WHERE e.idEvaluationSheet = :idEvaluationSheet"),
    @NamedQuery(name = "EvaluationSheet.findByEvaluationNote", query = "SELECT e FROM EvaluationSheet e WHERE e.evaluationNote = :evaluationNote"),
    @NamedQuery(name = "EvaluationSheet.findByState", query = "SELECT e FROM EvaluationSheet e WHERE e.state = :state")})
public class EvaluationSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "observation")
    private String observation;
    @Basic(optional = false)
    @Column(name = "qualification_date")
    @Temporal(TemporalType.DATE)
    private Date qualificationDate;
    @Id
    @Basic(optional = false)
    @Column(name = "id_evaluation_sheet")
    private Long idEvaluationSheet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "evaluation_note")
    private Double evaluationNote;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationSheet")
    private Collection<Qualification> qualificationCollection;
    @JoinColumns({
        @JoinColumn(name = "id_evaluator", referencedColumnName = "id_evaluator"),
        @JoinColumn(name = "id_type_evaluation", referencedColumnName = "id_type_evaluation")})
    @ManyToOne(optional = false)
    private Evaluator evaluator;
    @JoinColumn(name = "id_postulant", referencedColumnName = "id_postulant")
    @ManyToOne
    private Postulant idPostulant;

    public EvaluationSheet() {
    }

    public EvaluationSheet(Long idEvaluationSheet) {
        this.idEvaluationSheet = idEvaluationSheet;
    }

    public EvaluationSheet(Long idEvaluationSheet, Date qualificationDate, Character state) {
        this.idEvaluationSheet = idEvaluationSheet;
        this.qualificationDate = qualificationDate;
        this.state = state;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getQualificationDate() {
        return qualificationDate;
    }

    public void setQualificationDate(Date qualificationDate) {
        this.qualificationDate = qualificationDate;
    }

    public Long getIdEvaluationSheet() {
        return idEvaluationSheet;
    }

    public void setIdEvaluationSheet(Long idEvaluationSheet) {
        this.idEvaluationSheet = idEvaluationSheet;
    }

    public Double getEvaluationNote() {
        return evaluationNote;
    }

    public void setEvaluationNote(Double evaluationNote) {
        this.evaluationNote = evaluationNote;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Qualification> getQualificationCollection() {
        return qualificationCollection;
    }

    public void setQualificationCollection(Collection<Qualification> qualificationCollection) {
        this.qualificationCollection = qualificationCollection;
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public Postulant getIdPostulant() {
        return idPostulant;
    }

    public void setIdPostulant(Postulant idPostulant) {
        this.idPostulant = idPostulant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluationSheet != null ? idEvaluationSheet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationSheet)) {
            return false;
        }
        EvaluationSheet other = (EvaluationSheet) object;
        if ((this.idEvaluationSheet == null && other.idEvaluationSheet != null) || (this.idEvaluationSheet != null && !this.idEvaluationSheet.equals(other.idEvaluationSheet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.EvaluationSheet[ idEvaluationSheet=" + idEvaluationSheet + " ]";
    }
    
}
