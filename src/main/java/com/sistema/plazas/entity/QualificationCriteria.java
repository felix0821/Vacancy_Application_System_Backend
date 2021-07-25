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
 * @author Felix
 */
@Entity
@Table(name = "qualification_criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QualificationCriteria.findAll", query = "SELECT q FROM QualificationCriteria q"),
    @NamedQuery(name = "QualificationCriteria.findByIdQualificationCriteria", query = "SELECT q FROM QualificationCriteria q WHERE q.idQualificationCriteria = :idQualificationCriteria"),
    @NamedQuery(name = "QualificationCriteria.findByName", query = "SELECT q FROM QualificationCriteria q WHERE q.name = :name"),
    @NamedQuery(name = "QualificationCriteria.findByState", query = "SELECT q FROM QualificationCriteria q WHERE q.state = :state")})
public class QualificationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_qualification_criteria")
    private Long idQualificationCriteria;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationCriteria")
    private Collection<Qualification> qualificationCollection;
    @JoinColumn(name = "id_type_evaluation", referencedColumnName = "id_type_evaluation")
    @ManyToOne(optional = false)
    private TypeEvaluation idTypeEvaluation;

    public QualificationCriteria() {
    }

    public QualificationCriteria(Long idQualificationCriteria) {
        this.idQualificationCriteria = idQualificationCriteria;
    }

    public QualificationCriteria(Long idQualificationCriteria, String name, Character state) {
        this.idQualificationCriteria = idQualificationCriteria;
        this.name = name;
        this.state = state;
    }

    public Long getIdQualificationCriteria() {
        return idQualificationCriteria;
    }

    public void setIdQualificationCriteria(Long idQualificationCriteria) {
        this.idQualificationCriteria = idQualificationCriteria;
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
    public Collection<Qualification> getQualificationCollection() {
        return qualificationCollection;
    }

    public void setQualificationCollection(Collection<Qualification> qualificationCollection) {
        this.qualificationCollection = qualificationCollection;
    }

    public TypeEvaluation getIdTypeEvaluation() {
        return idTypeEvaluation;
    }

    public void setIdTypeEvaluation(TypeEvaluation idTypeEvaluation) {
        this.idTypeEvaluation = idTypeEvaluation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQualificationCriteria != null ? idQualificationCriteria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QualificationCriteria)) {
            return false;
        }
        QualificationCriteria other = (QualificationCriteria) object;
        if ((this.idQualificationCriteria == null && other.idQualificationCriteria != null) || (this.idQualificationCriteria != null && !this.idQualificationCriteria.equals(other.idQualificationCriteria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.QualificationCriteria[ idQualificationCriteria=" + idQualificationCriteria + " ]";
    }
    
}
