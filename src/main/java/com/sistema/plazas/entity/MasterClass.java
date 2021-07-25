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
import javax.persistence.ManyToMany;
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
@Table(name = "master_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasterClass.findAll", query = "SELECT m FROM MasterClass m"),
    @NamedQuery(name = "MasterClass.findByIdMasterClass", query = "SELECT m FROM MasterClass m WHERE m.idMasterClass = :idMasterClass"),
    @NamedQuery(name = "MasterClass.findByStartTime", query = "SELECT m FROM MasterClass m WHERE m.startTime = :startTime"),
    @NamedQuery(name = "MasterClass.findBySite", query = "SELECT m FROM MasterClass m WHERE m.site = :site"),
    @NamedQuery(name = "MasterClass.findByDuration", query = "SELECT m FROM MasterClass m WHERE m.duration = :duration")})
public class MasterClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_master_class")
    private Long idMasterClass;
    @Column(name = "start_time")
    @Temporal(TemporalType.DATE)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "site")
    private String site;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duration")
    private Double duration;
    @ManyToMany(mappedBy = "masterClassCollection")
    private Collection<Evaluator> evaluatorCollection;
    @JoinColumn(name = "id_competition_workplace", referencedColumnName = "id_competition_workplace")
    @ManyToOne(optional = false)
    private CompetitionWorkplace idCompetitionWorkplace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterClass")
    private Collection<Exposition> expositionCollection;

    public MasterClass() {
    }

    public MasterClass(Long idMasterClass) {
        this.idMasterClass = idMasterClass;
    }

    public MasterClass(Long idMasterClass, String site) {
        this.idMasterClass = idMasterClass;
        this.site = site;
    }

    public Long getIdMasterClass() {
        return idMasterClass;
    }

    public void setIdMasterClass(Long idMasterClass) {
        this.idMasterClass = idMasterClass;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @XmlTransient
    public Collection<Evaluator> getEvaluatorCollection() {
        return evaluatorCollection;
    }

    public void setEvaluatorCollection(Collection<Evaluator> evaluatorCollection) {
        this.evaluatorCollection = evaluatorCollection;
    }

    public CompetitionWorkplace getIdCompetitionWorkplace() {
        return idCompetitionWorkplace;
    }

    public void setIdCompetitionWorkplace(CompetitionWorkplace idCompetitionWorkplace) {
        this.idCompetitionWorkplace = idCompetitionWorkplace;
    }

    @XmlTransient
    public Collection<Exposition> getExpositionCollection() {
        return expositionCollection;
    }

    public void setExpositionCollection(Collection<Exposition> expositionCollection) {
        this.expositionCollection = expositionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMasterClass != null ? idMasterClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterClass)) {
            return false;
        }
        MasterClass other = (MasterClass) object;
        if ((this.idMasterClass == null && other.idMasterClass != null) || (this.idMasterClass != null && !this.idMasterClass.equals(other.idMasterClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.MasterClass[ idMasterClass=" + idMasterClass + " ]";
    }
    
}
