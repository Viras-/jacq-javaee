/*
 * Copyright 2017 fhafner.
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
package org.jacq.common.model.rest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.jacq.common.model.jpa.TblOrganisation;

/**
 * Wrapper model which represents a single result after a search Used to
 * minimize the transfered data and only return the relevant information
 *
 * @author fhafner
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganisationResult {

    protected Long organisationId;
    protected String description;
    protected String department;
    protected boolean greenhouse;
    protected String ipenCode;
    protected String parentOrganisationDescription;
    protected Long parentOrganisationId;
    protected OrganisationResult parentOrganisationResult;
    protected String gardener;
    protected Long gardenerId;
    protected boolean indexSeminumStart;
    protected boolean accessionStart;
    private String address;
    private String city;
    private String postcode;
    private String country;
    private String phone;
    private String email;

    public OrganisationResult(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(boolean greenhouse) {
        this.greenhouse = greenhouse;
    }

    public String getIpenCode() {
        return ipenCode;
    }

    public void setIpenCode(String ipenCode) {
        this.ipenCode = ipenCode;
    }

    public String getGardener() {
        return gardener;
    }

    public void setGardener(String gardener) {
        this.gardener = gardener;

    }

    public Long getGardenerId() {
        return gardenerId;
    }

    public void setGardenerId(Long gardenerId) {
        this.gardenerId = gardenerId;
    }

    public String getParentOrganisationDescription() {
        return parentOrganisationDescription;
    }

    public void setParentOrganisationDescription(String parentOrganisationDescription) {
        this.parentOrganisationDescription = parentOrganisationDescription;
    }

    public Long getParentOrganisationId() {
        return parentOrganisationId;
    }

    public void setParentOrganisationId(Long parentOrganisationId) {
        this.parentOrganisationId = parentOrganisationId;
    }

    public boolean isIndexSeminumStart() {
        return indexSeminumStart;
    }

    public void setIndexSeminumStart(boolean indexSeminumStart) {
        this.indexSeminumStart = indexSeminumStart;
    }

    public boolean isAccessionStart() {
        return accessionStart;
    }

    public void setAccessionStart(boolean accessionStart) {
        this.accessionStart = accessionStart;
    }

    public OrganisationResult getParentOrganisationResult() {
        return parentOrganisationResult;
    }

    public void setParentOrganisationResult(OrganisationResult parentOrganisationResult) {
        this.parentOrganisationResult = parentOrganisationResult;
    }

    public OrganisationResult() {
    }

    public OrganisationResult(TblOrganisation organisation) {
        this.organisationId = organisation.getId();
        this.description = organisation.getDescription();
        this.department = organisation.getDepartment();
        this.greenhouse = organisation.getGreenhouse();
        this.ipenCode = organisation.getIpenCode();
        this.parentOrganisationDescription = (organisation.getParentOrganisationId() != null) ? organisation.getParentOrganisationId().getDescription() : "";
        this.parentOrganisationId = (organisation.getParentOrganisationId() != null) ? organisation.getParentOrganisationId().getId() : null;
        this.gardener = (organisation.getGardenerId() != null) ? organisation.getGardenerId().getUsername() : "";
        this.gardenerId = (organisation.getGardenerId() != null) ? organisation.getGardenerId().getId() : null;
        this.indexSeminumStart = organisation.getIndexSeminumStart();
        this.accessionStart = organisation.getAccessionStart();
        this.parentOrganisationResult = (organisation.getParentOrganisationId() != null) ? new OrganisationResult(organisation.getParentOrganisationId()) : null;
        this.address = organisation.getAddress();
        this.city = organisation.getCity();
        this.postcode = organisation.getPostcode();
        this.country = organisation.getCountry();
        this.phone = organisation.getPhone();
        this.email = organisation.getEmail();
    }

    /**
     * Helper function for converting a list of Organisation entries to
     * organisation results
     *
     * @param organisationList
     * @return
     */
    public static List<OrganisationResult> fromList(List<TblOrganisation> organisationList) {
        List<OrganisationResult> organisationResult = new ArrayList<>();

        if (organisationList != null) {
            for (TblOrganisation organisation : organisationList) {
                organisationResult.add(new OrganisationResult(organisation));
            }
        }

        return organisationResult;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
