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
public class QualificationPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1004397728967900048L;
	@Basic(optional = false)
    @Column(name = "id_evaluation_sheet")
    private long idEvaluationSheet;
    @Basic(optional = false)
    @Column(name = "id_qualification_criteria")
    private long idQualificationCriteria;

    public QualificationPK() {
    }

    public QualificationPK(long idEvaluationSheet, long idQualificationCriteria) {
        this.idEvaluationSheet = idEvaluationSheet;
        this.idQualificationCriteria = idQualificationCriteria;
    }

    public long getIdEvaluationSheet() {
        return idEvaluationSheet;
    }

    public void setIdEvaluationSheet(long idEvaluationSheet) {
        this.idEvaluationSheet = idEvaluationSheet;
    }

    public long getIdQualificationCriteria() {
        return idQualificationCriteria;
    }

    public void setIdQualificationCriteria(long idQualificationCriteria) {
        this.idQualificationCriteria = idQualificationCriteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvaluationSheet;
        hash += (int) idQualificationCriteria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QualificationPK)) {
            return false;
        }
        QualificationPK other = (QualificationPK) object;
        if (this.idEvaluationSheet != other.idEvaluationSheet) {
            return false;
        }
        if (this.idQualificationCriteria != other.idQualificationCriteria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.QualificationPK[ idEvaluationSheet=" + idEvaluationSheet + ", idQualificationCriteria=" + idQualificationCriteria + " ]";
    }
    
}
