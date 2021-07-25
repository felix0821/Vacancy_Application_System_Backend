/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.plazas.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "workplace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workplace.findAll", query = "SELECT w FROM Workplace w"),
    @NamedQuery(name = "Workplace.findByIdWorkplace", query = "SELECT w FROM Workplace w WHERE w.idWorkplace = :idWorkplace"),
    @NamedQuery(name = "Workplace.findByName", query = "SELECT w FROM Workplace w WHERE w.name = :name"),
    @NamedQuery(name = "Workplace.findByCount", query = "SELECT w FROM Workplace w WHERE w.count = :count")})
public class Workplace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_workplace")
    private Long idWorkplace;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "count")
    private int count;
    @OneToMany(mappedBy = "idWorkplace")
    private Collection<CompetitionWorkplace> competitionWorkplaceCollection;
    @JoinColumn(name = "Id_faculty_school", referencedColumnName = "Id_faculty_school")
    @ManyToOne(optional = false)
    private FacultySchool idfacultyschool;

    public Workplace() {
    }

    public Workplace(Long idWorkplace) {
        this.idWorkplace = idWorkplace;
    }

    public Workplace(Long idWorkplace, String name, int count) {
        this.idWorkplace = idWorkplace;
        this.name = name;
        this.count = count;
    }

    public Long getIdWorkplace() {
        return idWorkplace;
    }

    public void setIdWorkplace(Long idWorkplace) {
        this.idWorkplace = idWorkplace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlTransient
    public Collection<CompetitionWorkplace> getCompetitionWorkplaceCollection() {
        return competitionWorkplaceCollection;
    }

    public void setCompetitionWorkplaceCollection(Collection<CompetitionWorkplace> competitionWorkplaceCollection) {
        this.competitionWorkplaceCollection = competitionWorkplaceCollection;
    }

    public FacultySchool getIdfacultyschool() {
        return idfacultyschool;
    }

    public void setIdfacultyschool(FacultySchool idfacultyschool) {
        this.idfacultyschool = idfacultyschool;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWorkplace != null ? idWorkplace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workplace)) {
            return false;
        }
        Workplace other = (Workplace) object;
        if ((this.idWorkplace == null && other.idWorkplace != null) || (this.idWorkplace != null && !this.idWorkplace.equals(other.idWorkplace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.Workplace[ idWorkplace=" + idWorkplace + " ]";
    }
    
}
