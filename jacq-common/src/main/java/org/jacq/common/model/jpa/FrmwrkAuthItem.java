/*
 * Copyright 2016 wkoller.
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
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wkoller
 */
@Entity
@Table(name = "frmwrk_AuthItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrmwrkAuthItem.findAll", query = "SELECT f FROM FrmwrkAuthItem f")
    , @NamedQuery(name = "FrmwrkAuthItem.findByName", query = "SELECT f FROM FrmwrkAuthItem f WHERE f.name = :name")
    , @NamedQuery(name = "FrmwrkAuthItem.findByType", query = "SELECT f FROM FrmwrkAuthItem f WHERE f.type = :type")})
public class FrmwrkAuthItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "bizrule")
    private String bizrule;
    @Lob
    @Size(max = 65535)
    @Column(name = "data")
    private String data;
    @JoinTable(name = "frmwrk_AuthItemChild", joinColumns = {
        @JoinColumn(name = "parent", referencedColumnName = "name")}, inverseJoinColumns = {
        @JoinColumn(name = "child", referencedColumnName = "name")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<FrmwrkAuthItem> frmwrkAuthItemCollection;
    @ManyToMany(mappedBy = "frmwrkAuthItemCollection", fetch = FetchType.LAZY)
    private Collection<FrmwrkAuthItem> frmwrkAuthItemCollection1;
    @OneToMany(mappedBy = "authItemname", fetch = FetchType.LAZY)
    private Collection<FrmwrkaccessClassification> frmwrkaccessClassificationCollection;
    @OneToMany(mappedBy = "authItemname", fetch = FetchType.LAZY)
    private Collection<FrmwrkaccessOrganisation> frmwrkaccessOrganisationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frmwrkAuthItem", fetch = FetchType.LAZY)
    private Collection<FrmwrkAuthAssignment> frmwrkAuthAssignmentCollection;
    @OneToMany(mappedBy = "authItemname", fetch = FetchType.LAZY)
    private Collection<FrmwrkaccessBotanicalObject> frmwrkaccessBotanicalObjectCollection;

    public FrmwrkAuthItem() {
    }

    public FrmwrkAuthItem(String name) {
        this.name = name;
    }

    public FrmwrkAuthItem(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBizrule() {
        return bizrule;
    }

    public void setBizrule(String bizrule) {
        this.bizrule = bizrule;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @XmlTransient
    public Collection<FrmwrkAuthItem> getFrmwrkAuthItemCollection() {
        return frmwrkAuthItemCollection;
    }

    public void setFrmwrkAuthItemCollection(Collection<FrmwrkAuthItem> frmwrkAuthItemCollection) {
        this.frmwrkAuthItemCollection = frmwrkAuthItemCollection;
    }

    @XmlTransient
    public Collection<FrmwrkAuthItem> getFrmwrkAuthItemCollection1() {
        return frmwrkAuthItemCollection1;
    }

    public void setFrmwrkAuthItemCollection1(Collection<FrmwrkAuthItem> frmwrkAuthItemCollection1) {
        this.frmwrkAuthItemCollection1 = frmwrkAuthItemCollection1;
    }

    @XmlTransient
    public Collection<FrmwrkaccessClassification> getFrmwrkaccessClassificationCollection() {
        return frmwrkaccessClassificationCollection;
    }

    public void setFrmwrkaccessClassificationCollection(Collection<FrmwrkaccessClassification> frmwrkaccessClassificationCollection) {
        this.frmwrkaccessClassificationCollection = frmwrkaccessClassificationCollection;
    }

    @XmlTransient
    public Collection<FrmwrkaccessOrganisation> getFrmwrkaccessOrganisationCollection() {
        return frmwrkaccessOrganisationCollection;
    }

    public void setFrmwrkaccessOrganisationCollection(Collection<FrmwrkaccessOrganisation> frmwrkaccessOrganisationCollection) {
        this.frmwrkaccessOrganisationCollection = frmwrkaccessOrganisationCollection;
    }

    @XmlTransient
    public Collection<FrmwrkAuthAssignment> getFrmwrkAuthAssignmentCollection() {
        return frmwrkAuthAssignmentCollection;
    }

    public void setFrmwrkAuthAssignmentCollection(Collection<FrmwrkAuthAssignment> frmwrkAuthAssignmentCollection) {
        this.frmwrkAuthAssignmentCollection = frmwrkAuthAssignmentCollection;
    }

    @XmlTransient
    public Collection<FrmwrkaccessBotanicalObject> getFrmwrkaccessBotanicalObjectCollection() {
        return frmwrkaccessBotanicalObjectCollection;
    }

    public void setFrmwrkaccessBotanicalObjectCollection(Collection<FrmwrkaccessBotanicalObject> frmwrkaccessBotanicalObjectCollection) {
        this.frmwrkaccessBotanicalObjectCollection = frmwrkaccessBotanicalObjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrmwrkAuthItem)) {
            return false;
        }
        FrmwrkAuthItem other = (FrmwrkAuthItem) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jacq.common.model.jpa.FrmwrkAuthItem[ name=" + name + " ]";
    }

}
