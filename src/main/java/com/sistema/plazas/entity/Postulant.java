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
@Table(name = "postulant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulant.findAll", query = "SELECT p FROM Postulant p"),
    @NamedQuery(name = "Postulant.findByRegistrationDate", query = "SELECT p FROM Postulant p WHERE p.registrationDate = :registrationDate"),
    @NamedQuery(name = "Postulant.findByFinalNote", query = "SELECT p FROM Postulant p WHERE p.finalNote = :finalNote"),
    @NamedQuery(name = "Postulant.findByUrlCurriculum", query = "SELECT p FROM Postulant p WHERE p.urlCurriculum = :urlCurriculum"),
    @NamedQuery(name = "Postulant.findByNumberTopics", query = "SELECT p FROM Postulant p WHERE p.numberTopics = :numberTopics"),
    @NamedQuery(name = "Postulant.findByState", query = "SELECT p FROM Postulant p WHERE p.state = :state"),
    @NamedQuery(name = "Postulant.findByStatusPostulant", query = "SELECT p FROM Postulant p WHERE p.statusPostulant = :statusPostulant"),
    @NamedQuery(name = "Postulant.findByIdPostulant", query = "SELECT p FROM Postulant p WHERE p.idPostulant = :idPostulant")})
public class Postulant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "final_note")
    private Double finalNote;
    @Basic(optional = false)
    @Column(name = "url_curriculum")
    private String urlCurriculum;
    @Basic(optional = false)
    @Column(name = "number_topics")
    private int numberTopics;
    @Basic(optional = false)
    @Column(name = "state")
    private Character state;
    @Basic(optional = false)
    @Column(name = "status_postulant")
    private String statusPostulant;
    @Id
    @Basic(optional = false)
    @Column(name = "id_postulant")
    private Long idPostulant;
    @JoinColumn(name = "id_competition_workplace", referencedColumnName = "id_competition_workplace")
    @ManyToOne(optional = false)
    private CompetitionWorkplace idCompetitionWorkplace;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postulant")
    private Collection<Exposition> expositionCollection;
    @OneToMany(mappedBy = "idPostulant")
    private Collection<EvaluationSheet> evaluationSheetCollection;

    public Postulant() {
    }

    public Postulant(Long idPostulant) {
        this.idPostulant = idPostulant;
    }

    public Postulant(Long idPostulant, Date registrationDate, String urlCurriculum, int numberTopics, Character state, String statusPostulant) {
        this.idPostulant = idPostulant;
        this.registrationDate = registrationDate;
        this.urlCurriculum = urlCurriculum;
        this.numberTopics = numberTopics;
        this.state = state;
        this.statusPostulant = statusPostulant;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(Double finalNote) {
        this.finalNote = finalNote;
    }

    public String getUrlCurriculum() {
        return urlCurriculum;
    }

    public void setUrlCurriculum(String urlCurriculum) {
        this.urlCurriculum = urlCurriculum;
    }

    public int getNumberTopics() {
        return numberTopics;
    }

    public void setNumberTopics(int numberTopics) {
        this.numberTopics = numberTopics;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public String getStatusPostulant() {
        return statusPostulant;
    }

    public void setStatusPostulant(String statusPostulant) {
        this.statusPostulant = statusPostulant;
    }

    public Long getIdPostulant() {
        return idPostulant;
    }

    public void setIdPostulant(Long idPostulant) {
        this.idPostulant = idPostulant;
    }

    public CompetitionWorkplace getIdCompetitionWorkplace() {
        return idCompetitionWorkplace;
    }

    public void setIdCompetitionWorkplace(CompetitionWorkplace idCompetitionWorkplace) {
        this.idCompetitionWorkplace = idCompetitionWorkplace;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Collection<Exposition> getExpositionCollection() {
        return expositionCollection;
    }

    public void setExpositionCollection(Collection<Exposition> expositionCollection) {
        this.expositionCollection = expositionCollection;
    }

    @XmlTransient
    public Collection<EvaluationSheet> getEvaluationSheetCollection() {
        return evaluationSheetCollection;
    }

    public void setEvaluationSheetCollection(Collection<EvaluationSheet> evaluationSheetCollection) {
        this.evaluationSheetCollection = evaluationSheetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostulant != null ? idPostulant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulant)) {
            return false;
        }
        Postulant other = (Postulant) object;
        if ((this.idPostulant == null && other.idPostulant != null) || (this.idPostulant != null && !this.idPostulant.equals(other.idPostulant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacancies_application_system.Postulant[ idPostulant=" + idPostulant + " ]";
    }
    
}
