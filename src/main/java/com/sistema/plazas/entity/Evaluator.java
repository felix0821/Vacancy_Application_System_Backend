/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "evaluator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluator.findAll", query = "SELECT e FROM Evaluator e"),
    @NamedQuery(name = "Evaluator.findByIdTypeEvaluation", query = "SELECT e FROM Evaluator e WHERE e.evaluatorPK.idTypeEvaluation = :idTypeEvaluation"),
    @NamedQuery(name = "Evaluator.findByIdEvaluator", query = "SELECT e FROM Evaluator e WHERE e.evaluatorPK.idEvaluator = :idEvaluator")})
public class Evaluator implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluatorPK evaluatorPK;
    @JoinTable(name = "masterclass_evaluator", joinColumns = {
        @JoinColumn(name = "id_evaluator", referencedColumnName = "id_evaluator"),
        @JoinColumn(name = "id_type_evaluation", referencedColumnName = "id_type_evaluation")}, inverseJoinColumns = {
        @JoinColumn(name = "id_master_class", referencedColumnName = "id_master_class")})
    @ManyToMany
    private Collection<MasterClass> masterClassCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluator")
    private Collection<EvaluationSheet> evaluationSheetCollection;
    @JoinColumn(name = "id_type_evaluation", referencedColumnName = "id_type_evaluation", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TypeEvaluation typeEvaluation;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;

    public Evaluator() {
    }

    public Evaluator(EvaluatorPK evaluatorPK) {
        this.evaluatorPK = evaluatorPK;
    }

    public Evaluator(long idTypeEvaluation, long idEvaluator) {
        this.evaluatorPK = new EvaluatorPK(idTypeEvaluation, idEvaluator);
    }

    public EvaluatorPK getEvaluatorPK() {
        return evaluatorPK;
    }

    public void setEvaluatorPK(EvaluatorPK evaluatorPK) {
        this.evaluatorPK = evaluatorPK;
    }

    @XmlTransient
    public Collection<MasterClass> getMasterClassCollection() {
        return masterClassCollection;
    }

    public void setMasterClassCollection(Collection<MasterClass> masterClassCollection) {
        this.masterClassCollection = masterClassCollection;
    }

    @XmlTransient
    public Collection<EvaluationSheet> getEvaluationSheetCollection() {
        return evaluationSheetCollection;
    }

    public void setEvaluationSheetCollection(Collection<EvaluationSheet> evaluationSheetCollection) {
        this.evaluationSheetCollection = evaluationSheetCollection;
    }

    public TypeEvaluation getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluatorPK != null ? evaluatorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluator)) {
            return false;
        }
        Evaluator other = (Evaluator) object;
        if ((this.evaluatorPK == null && other.evaluatorPK != null) || (this.evaluatorPK != null && !this.evaluatorPK.equals(other.evaluatorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.Evaluator[ evaluatorPK=" + evaluatorPK + " ]";
    }
    
}
