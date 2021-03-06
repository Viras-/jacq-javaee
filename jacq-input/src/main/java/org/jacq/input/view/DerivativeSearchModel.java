/*
 * Copyright 2018 fhafner.
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
package org.jacq.input.view;

import java.io.Serializable;
import org.jacq.common.model.rest.CultivarResult;
import org.jacq.common.model.rest.LocationResult;
import org.jacq.common.model.rest.OrganisationResult;
import org.jacq.common.model.rest.ScientificNameResult;

/**
 *
 * @author fhafner
 */
public class DerivativeSearchModel implements Serializable {

    /**
     * Search criteria
     */
    protected String placeNumber;
    protected String accessionNumber;
    protected int separated = 0;
    protected int indexSeminum = 0;
    protected Long scientificNameId = null;
    protected Long organisationId = null;
    protected Long id = null;
    protected String type;
    protected Boolean separatedFilter;
    protected Boolean hierarchic;
    protected Boolean indexSeminumFilter;
    protected Boolean exhibitionFilter;
    protected Boolean workingFilter;
    protected OrganisationResult selectedOrganisation;
    protected ScientificNameResult selectedScientificName;
    protected CultivarResult selectedCultivar;
    protected int callFlag; // Flag 0 User Organisation gets added in Search and 1 not
    protected LocationResult gatheringLocation;
    protected Long exhibition;
    protected Long working;
    protected Boolean classification;

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public int getSeparated() {
        return separated;
    }

    public void setSeparated(int separated) {
        this.separated = separated;
    }

    public Long getScientificNameId() {
        return scientificNameId;
    }

    public void setScientificNameId(Long scientificNameId) {
        this.scientificNameId = scientificNameId;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSeparatedFilter() {
        return separatedFilter;
    }

    public void setSeparatedFilter(Boolean separatedFilter) {
        this.separatedFilter = separatedFilter;
    }

    public OrganisationResult getSelectedOrganisation() {
        return selectedOrganisation;
    }

    public void setSelectedOrganisation(OrganisationResult selectedOrganisation) {
        this.callFlag = 1;
        this.selectedOrganisation = selectedOrganisation;

        if (selectedOrganisation != null) {
            this.organisationId = selectedOrganisation.getOrganisationId();
        } else {
            this.organisationId = null;
        }
    }

    public ScientificNameResult getSelectedScientificName() {
        return selectedScientificName;
    }

    public void setSelectedScientificName(ScientificNameResult selectedScientificName) {
        this.selectedScientificName = selectedScientificName;

        if (selectedScientificName != null) {
            this.scientificNameId = selectedScientificName.getScientificNameId();
        } else {
            this.scientificNameId = null;
        }
    }

    public Boolean getHierarchic() {
        return hierarchic;
    }

    public void setHierarchic(Boolean hierarchic) {
        this.hierarchic = hierarchic;
    }

    public int getCallFlag() {
        return callFlag;
    }

    public int getIndexSeminum() {
        return indexSeminum;
    }

    public void setIndexSeminum(int indexSeminum) {
        this.indexSeminum = indexSeminum;
    }

    public Boolean getIndexSeminumFilter() {
        return indexSeminumFilter;
    }

    public void setIndexSeminumFilter(Boolean indexSeminumFilter) {
        this.indexSeminumFilter = indexSeminumFilter;
    }

    public LocationResult getGatheringLocation() {
        return gatheringLocation;
    }

    public void setGatheringLocation(LocationResult gatheringLocation) {
        this.gatheringLocation = gatheringLocation;
    }

    public String getGatheringLocationName() {
        if (this.gatheringLocation != null) {
            return this.gatheringLocation.getLocation();
        }

        return null;
    }

    public Boolean getExhibitionFilter() {
        return exhibitionFilter;
    }

    public void setExhibitionFilter(Boolean exhibitionFilter) {
        this.exhibitionFilter = exhibitionFilter;
    }

    public Boolean getWorkingFilter() {
        return workingFilter;
    }

    public void setWorkingFilter(Boolean workingFilter) {
        this.workingFilter = workingFilter;
    }

    public Long getExhibition() {
        return exhibition;
    }

    public void setExhibition(Long exhibition) {
        this.exhibition = exhibition;
    }

    public Long getWorking() {
        return working;
    }

    public void setWorking(Long working) {
        this.working = working;
    }

    public Boolean getClassification() {
        return classification;
    }

    public void setClassification(Boolean classification) {
        this.classification = classification;
    }

    public CultivarResult getSelectedCultivar() {
        return selectedCultivar;
    }

    public void setSelectedCultivar(CultivarResult selectedCultivar) {
        this.selectedCultivar = selectedCultivar;
    }

}
