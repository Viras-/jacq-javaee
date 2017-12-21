/*
 * Copyright 2017 wkoller.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jacq.common.model.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wkoller
 */
@Entity
@Table(name = "tbl_separation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSeparation.findAll", query = "SELECT t FROM TblSeparation t")
    , @NamedQuery(name = "TblSeparation.findById", query = "SELECT t FROM TblSeparation t WHERE t.id = :id")
    , @NamedQuery(name = "TblSeparation.findByDate", query = "SELECT t FROM TblSeparation t WHERE t.date = :date")})
public class TblSeparation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Size(max = 65535)
    @Column(name = "annotation")
    private String annotation;
    @JoinColumn(name = "botanical_object_id", referencedColumnName = "id")
    @ManyToOne
    private TblBotanicalObject botanicalObjectId;
    @JoinColumn(name = "derivative_vegetative_id", referencedColumnName = "derivative_vegetative_id")
    @ManyToOne
    private TblDerivativeVegetative derivativeVegetativeId;
    @JoinColumn(name = "separation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TblSeparationType separationTypeId;

    public TblSeparation() {
    }

    public TblSeparation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public TblBotanicalObject getBotanicalObjectId() {
        return botanicalObjectId;
    }

    public void setBotanicalObjectId(TblBotanicalObject botanicalObjectId) {
        this.botanicalObjectId = botanicalObjectId;
    }

    public TblDerivativeVegetative getDerivativeVegetativeId() {
        return derivativeVegetativeId;
    }

    public void setDerivativeVegetativeId(TblDerivativeVegetative derivativeVegetativeId) {
        this.derivativeVegetativeId = derivativeVegetativeId;
    }

    public TblSeparationType getSeparationTypeId() {
        return separationTypeId;
    }

    public void setSeparationTypeId(TblSeparationType separationTypeId) {
        this.separationTypeId = separationTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSeparation)) {
            return false;
        }
        TblSeparation other = (TblSeparation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jacq.common.model.jpa.TblSeparation[ id=" + id + " ]";
    }

}
