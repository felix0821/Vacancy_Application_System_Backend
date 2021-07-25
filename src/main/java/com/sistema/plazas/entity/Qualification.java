/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q"),
    @NamedQuery(name = "Qualification.findByNote", query = "SELECT q FROM Qualification q WHERE q.note = :note"),
    @NamedQuery(name = "Qualification.findByIdEvaluationSheet", query = "SELECT q FROM Qualification q WHERE q.qualificationPK.idEvaluationSheet = :idEvaluationSheet"),
    @NamedQuery(name = "Qualification.findByIdQualificationCriteria", query = "SELECT q FROM Qualification q WHERE q.qualificationPK.idQualificationCriteria = :idQualificationCriteria")})
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QualificationPK qualificationPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Note")
    private Double note;
    @JoinColumn(name = "id_evaluation_sheet", referencedColumnName = "id_evaluation_sheet", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EvaluationSheet evaluationSheet;
    @JoinColumn(name = "id_qualification_criteria", referencedColumnName = "id_qualification_criteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private QualificationCriteria qualificationCriteria;

    public Qualification() {
    }

    public Qualification(QualificationPK qualificationPK) {
        this.qualificationPK = qualificationPK;
    }

    public Qualification(long idEvaluationSheet, long idQualificationCriteria) {
        this.qualificationPK = new QualificationPK(idEvaluationSheet, idQualificationCriteria);
    }

    public QualificationPK getQualificationPK() {
        return qualificationPK;
    }

    public void setQualificationPK(QualificationPK qualificationPK) {
        this.qualificationPK = qualificationPK;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public EvaluationSheet getEvaluationSheet() {
        return evaluationSheet;
    }

    public void setEvaluationSheet(EvaluationSheet evaluationSheet) {
        this.evaluationSheet = evaluationSheet;
    }

    public QualificationCriteria getQualificationCriteria() {
        return qualificationCriteria;
    }

    public void setQualificationCriteria(QualificationCriteria qualificationCriteria) {
        this.qualificationCriteria = qualificationCriteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qualificationPK != null ? qualificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.qualificationPK == null && other.qualificationPK != null) || (this.qualificationPK != null && !this.qualificationPK.equals(other.qualificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.Qualification[ qualificationPK=" + qualificationPK + " ]";
    }
    
}
