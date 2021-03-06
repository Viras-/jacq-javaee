/*
 * Copyright 2018 wkoller.
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
import org.jacq.common.model.jpa.TblAcquisitionSource;

/**
 *
 * @author wkoller
 */
public class AcquisitionSourceResult {

    private Long acquisitionSourceId;
    private String name;

    public AcquisitionSourceResult() {
    }

    public AcquisitionSourceResult(Long acquisitionSourceId) {
        this.acquisitionSourceId = acquisitionSourceId;
    }

    public AcquisitionSourceResult(String name) {
        this.name = name;
    }

    public AcquisitionSourceResult(TblAcquisitionSource tblAcquisitionSource) {
        if (tblAcquisitionSource != null) {
            this.acquisitionSourceId = tblAcquisitionSource.getAcquisitionSourceId();
            this.name = tblAcquisitionSource.getName();
        }
    }

    public Long getAcquisitionSourceId() {
        return acquisitionSourceId;
    }

    public void setAcquisitionSourceId(Long acquisitionSourceId) {
        this.acquisitionSourceId = acquisitionSourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Helper function for converting a list of TblAcquisitionSource entries to AcquistionSourceResult
     *
     * @param tblAcquisitionSourceList
     * @return
     */
    public static List<AcquisitionSourceResult> fromList(List<TblAcquisitionSource> tblAcquisitionSourceList) {
        List<AcquisitionSourceResult> acquistionSourceResults = new ArrayList<>();

        if (tblAcquisitionSourceList != null) {
            for (TblAcquisitionSource tblAcquisitionSource : tblAcquisitionSourceList) {
                acquistionSourceResults.add(new AcquisitionSourceResult(tblAcquisitionSource));
            }
        }

        return acquistionSourceResults;
    }
}
