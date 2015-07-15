/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacq.common.model.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wkoller
 */
@Entity
@Table(name = "tbl_tree_record_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTreeRecordFile.findAll", query = "SELECT t FROM TblTreeRecordFile t"),
    @NamedQuery(name = "TblTreeRecordFile.findById", query = "SELECT t FROM TblTreeRecordFile t WHERE t.id = :id"),
    @NamedQuery(name = "TblTreeRecordFile.findByYear", query = "SELECT t FROM TblTreeRecordFile t WHERE t.year = :year"),
    @NamedQuery(name = "TblTreeRecordFile.findByName", query = "SELECT t FROM TblTreeRecordFile t WHERE t.name = :name"),
    @NamedQuery(name = "TblTreeRecordFile.findByDocumentNumber", query = "SELECT t FROM TblTreeRecordFile t WHERE t.documentNumber = :documentNumber")})
public class TblTreeRecordFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "document_number")
    private String documentNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treeRecordFileId")
    private Collection<TblTreeRecordFilePage> tblTreeRecordFilePageCollection;

    public TblTreeRecordFile() {
    }

    public TblTreeRecordFile(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @XmlTransient
    public Collection<TblTreeRecordFilePage> getTblTreeRecordFilePageCollection() {
        return tblTreeRecordFilePageCollection;
    }

    public void setTblTreeRecordFilePageCollection(Collection<TblTreeRecordFilePage> tblTreeRecordFilePageCollection) {
        this.tblTreeRecordFilePageCollection = tblTreeRecordFilePageCollection;
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
        if (!(object instanceof TblTreeRecordFile)) {
            return false;
        }
        TblTreeRecordFile other = (TblTreeRecordFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jacq.common.model.jpa.TblTreeRecordFile[ id=" + id + " ]";
    }

}
