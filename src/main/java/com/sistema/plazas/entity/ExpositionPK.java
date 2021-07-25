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
public class ExpositionPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 405104172268686414L;
	@Basic(optional = false)
    @Column(name = "id_master_class")
    private long idMasterClass;
    @Basic(optional = false)
    @Column(name = "id_postulant")
    private long idPostulant;

    public ExpositionPK() {
    }

    public ExpositionPK(long idMasterClass, long idPostulant) {
        this.idMasterClass = idMasterClass;
        this.idPostulant = idPostulant;
    }

    public long getIdMasterClass() {
        return idMasterClass;
    }

    public void setIdMasterClass(long idMasterClass) {
        this.idMasterClass = idMasterClass;
    }

    public long getIdPostulant() {
        return idPostulant;
    }

    public void setIdPostulant(long idPostulant) {
        this.idPostulant = idPostulant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMasterClass;
        hash += (int) idPostulant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpositionPK)) {
            return false;
        }
        ExpositionPK other = (ExpositionPK) object;
        if (this.idMasterClass != other.idMasterClass) {
            return false;
        }
        if (this.idPostulant != other.idPostulant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.ExpositionPK[ idMasterClass=" + idMasterClass + ", idPostulant=" + idPostulant + " ]";
    }
    
}
