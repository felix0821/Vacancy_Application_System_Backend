/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felix
 */
@Entity
@Table(name = "type_evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeEvaluation.findAll", query = "SELECT t FROM TypeEvaluation t"),
    @NamedQuery(name = "TypeEvaluation.findByIdTypeEvaluation", query = "SELECT t FROM TypeEvaluation t WHERE t.idTypeEvaluation = :idTypeEvaluation"),
    @NamedQuery(name = "TypeEvaluation.findByName", query = "SELECT t FROM TypeEvaluation t WHERE t.name = :name"),
    @NamedQuery(name = "TypeEvaluation.findByState", query = "SELECT t FROM TypeEvaluation t WHERE t.state = :state")})
public class TypeEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_type_evaluation")
    private Long idTypeEvaluation;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "state")
    private Character state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeEvaluation")
    private Collection<QualificationCriteria> qualificationCriteriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeEvaluation")
    private Collection<Evaluator> evaluatorCollection;

    public TypeEvaluation() {
    }

    public TypeEvaluation(Long idTypeEvaluation) {
        this.idTypeEvaluation = idTypeEvaluation;
    }

    public TypeEvaluation(Long idTypeEvaluation, String name) {
        this.idTypeEvaluation = idTypeEvaluation;
        this.name = name;
    }

    public Long getIdTypeEvaluation() {
        return idTypeEvaluation;
    }

    public void setIdTypeEvaluation(Long idTypeEvaluation) {
        this.idTypeEvaluation = idTypeEvaluation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<QualificationCriteria> getQualificationCriteriaCollection() {
        return qualificationCriteriaCollection;
    }

    public void setQualificationCriteriaCollection(Collection<QualificationCriteria> qualificationCriteriaCollection) {
        this.qualificationCriteriaCollection = qualificationCriteriaCollection;
    }

    @XmlTransient
    public Collection<Evaluator> getEvaluatorCollection() {
        return evaluatorCollection;
    }

    public void setEvaluatorCollection(Collection<Evaluator> evaluatorCollection) {
        this.evaluatorCollection = evaluatorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeEvaluation != null ? idTypeEvaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeEvaluation)) {
            return false;
        }
        TypeEvaluation other = (TypeEvaluation) object;
        if ((this.idTypeEvaluation == null && other.idTypeEvaluation != null) || (this.idTypeEvaluation != null && !this.idTypeEvaluation.equals(other.idTypeEvaluation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.TypeEvaluation[ idTypeEvaluation=" + idTypeEvaluation + " ]";
    }
    
}
