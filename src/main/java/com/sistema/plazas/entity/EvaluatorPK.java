/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Felix
 */
@Embeddable
public class EvaluatorPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4989314667904636131L;
	@Basic(optional = false)
    @Column(name = "id_type_evaluation")
    private long idTypeEvaluation;
    @Basic(optional = false)
    @Column(name = "id_evaluator")
    private long idEvaluator;

    public EvaluatorPK() {
    }

    public EvaluatorPK(long idTypeEvaluation, long idEvaluator) {
        this.idTypeEvaluation = idTypeEvaluation;
        this.idEvaluator = idEvaluator;
    }

    public long getIdTypeEvaluation() {
        return idTypeEvaluation;
    }

    public void setIdTypeEvaluation(long idTypeEvaluation) {
        this.idTypeEvaluation = idTypeEvaluation;
    }

    public long getIdEvaluator() {
        return idEvaluator;
    }

    public void setIdEvaluator(long idEvaluator) {
        this.idEvaluator = idEvaluator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTypeEvaluation;
        hash += (int) idEvaluator;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluatorPK)) {
            return false;
        }
        EvaluatorPK other = (EvaluatorPK) object;
        if (this.idTypeEvaluation != other.idTypeEvaluation) {
            return false;
        }
        if (this.idEvaluator != other.idEvaluator) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.EvaluatorPK[ idTypeEvaluation=" + idTypeEvaluation + ", idEvaluator=" + idEvaluator + " ]";
    }
    
}
