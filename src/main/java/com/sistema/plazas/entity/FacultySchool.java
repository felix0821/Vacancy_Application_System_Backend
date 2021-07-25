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
@Table(name = "faculty_school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacultySchool.findAll", query = "SELECT f FROM FacultySchool f"),
    @NamedQuery(name = "FacultySchool.findByIdfacultyschool", query = "SELECT f FROM FacultySchool f WHERE f.idfacultyschool = :idfacultyschool"),
    @NamedQuery(name = "FacultySchool.findByName", query = "SELECT f FROM FacultySchool f WHERE f.name = :name"),
    @NamedQuery(name = "FacultySchool.findByUrlImage", query = "SELECT f FROM FacultySchool f WHERE f.urlImage = :urlImage")})
public class FacultySchool implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_faculty_school")
    private Long idfacultyschool;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "url_image")
    private String urlImage;
    @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty")
    @ManyToOne(optional = false)
    private Faculty idFaculty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfacultyschool")
    private Collection<Workplace> workplaceCollection;

    public FacultySchool() {
    }

    public FacultySchool(Long idfacultyschool) {
        this.idfacultyschool = idfacultyschool;
    }

    public FacultySchool(Long idfacultyschool, String name) {
        this.idfacultyschool = idfacultyschool;
        this.name = name;
    }

    public Long getIdfacultyschool() {
        return idfacultyschool;
    }

    public void setIdfacultyschool(Long idfacultyschool) {
        this.idfacultyschool = idfacultyschool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Faculty getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Faculty idFaculty) {
        this.idFaculty = idFaculty;
    }

    @XmlTransient
    public Collection<Workplace> getWorkplaceCollection() {
        return workplaceCollection;
    }

    public void setWorkplaceCollection(Collection<Workplace> workplaceCollection) {
        this.workplaceCollection = workplaceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacultyschool != null ? idfacultyschool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacultySchool)) {
            return false;
        }
        FacultySchool other = (FacultySchool) object;
        if ((this.idfacultyschool == null && other.idfacultyschool != null) || (this.idfacultyschool != null && !this.idfacultyschool.equals(other.idfacultyschool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.FacultySchool[ idfacultyschool=" + idfacultyschool + " ]";
    }
    
}
