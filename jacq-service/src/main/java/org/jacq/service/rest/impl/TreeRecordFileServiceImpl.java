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
package org.jacq.service.rest.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.jacq.common.model.TreeRecordFileResult;
import org.jacq.common.rest.TreeRecordFileService;
import org.jacq.service.manager.TreeRecordFileManager;

/**
 *
 * @author fhafner
 */
public class TreeRecordFileServiceImpl implements TreeRecordFileService {

    @Inject
    protected TreeRecordFileManager treeRecordFileManager;

    /**
     * @see TreeRecordFileService#search()
     */
    @Override
    public List<TreeRecordFileResult> search(Long treeRecordFileId, Date year, String name, String documentNumber, Integer offset, Integer limit) {
        return treeRecordFileManager.search(treeRecordFileId, year, name, documentNumber, offset, limit);
    }

    @Override
    public int searchCount(Long treeRecordFileId, Date year, String name, String documentNumber) {
        return treeRecordFileManager.searchCount(treeRecordFileId, year, name, documentNumber);
    }

    @Override
    public TreeRecordFileResult save(TreeRecordFileResult treeRecordFileResult) {
        return treeRecordFileManager.save(treeRecordFileResult);
    }

    @Override
    public Response uploadFile(InputStream is, FormDataContentDisposition formData) {
        return treeRecordFileManager.uploadFile(is, formData)
    }
}
