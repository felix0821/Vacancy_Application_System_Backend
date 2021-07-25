/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "exposition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exposition.findAll", query = "SELECT e FROM Exposition e"),
    @NamedQuery(name = "Exposition.findByIdMasterClass", query = "SELECT e FROM Exposition e WHERE e.expositionPK.idMasterClass = :idMasterClass"),
    @NamedQuery(name = "Exposition.findByTimeExposition", query = "SELECT e FROM Exposition e WHERE e.timeExposition = :timeExposition"),
    @NamedQuery(name = "Exposition.findByIdPostulant", query = "SELECT e FROM Exposition e WHERE e.expositionPK.idPostulant = :idPostulant"),
    @NamedQuery(name = "Exposition.findByDisplayOrder", query = "SELECT e FROM Exposition e WHERE e.displayOrder = :displayOrder"),
    @NamedQuery(name = "Exposition.findByExposeTopic", query = "SELECT e FROM Exposition e WHERE e.exposeTopic = :exposeTopic")})
public class Exposition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExpositionPK expositionPK;
    @Basic(optional = false)
    @Column(name = "time_exposition")
    private double timeExposition;
    @Basic(optional = false)
    @Column(name = "display_order")
    private int displayOrder;
    @Basic(optional = false)
    @Column(name = "expose_topic")
    private int exposeTopic;
    @JoinColumn(name = "id_master_class", referencedColumnName = "id_master_class", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MasterClass masterClass;
    @JoinColumn(name = "id_postulant", referencedColumnName = "id_postulant", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Postulant postulant;

    public Exposition() {
    }

    public Exposition(ExpositionPK expositionPK) {
        this.expositionPK = expositionPK;
    }

    public Exposition(ExpositionPK expositionPK, double timeExposition, int displayOrder, int exposeTopic) {
        this.expositionPK = expositionPK;
        this.timeExposition = timeExposition;
        this.displayOrder = displayOrder;
        this.exposeTopic = exposeTopic;
    }

    public Exposition(long idMasterClass, long idPostulant) {
        this.expositionPK = new ExpositionPK(idMasterClass, idPostulant);
    }

    public ExpositionPK getExpositionPK() {
        return expositionPK;
    }

    public void setExpositionPK(ExpositionPK expositionPK) {
        this.expositionPK = expositionPK;
    }

    public double getTimeExposition() {
        return timeExposition;
    }

    public void setTimeExposition(double timeExposition) {
        this.timeExposition = timeExposition;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getExposeTopic() {
        return exposeTopic;
    }

    public void setExposeTopic(int exposeTopic) {
        this.exposeTopic = exposeTopic;
    }

    public MasterClass getMasterClass() {
        return masterClass;
    }

    public void setMasterClass(MasterClass masterClass) {
        this.masterClass = masterClass;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expositionPK != null ? expositionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exposition)) {
            return false;
        }
        Exposition other = (Exposition) object;
        if ((this.expositionPK == null && other.expositionPK != null) || (this.expositionPK != null && !this.expositionPK.equals(other.expositionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.Exposition[ expositionPK=" + expositionPK + " ]";
    }
    
}
