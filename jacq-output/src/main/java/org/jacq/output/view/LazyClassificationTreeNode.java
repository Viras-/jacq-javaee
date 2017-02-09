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
package org.jacq.output.view;

import java.util.List;
import org.jacq.common.model.ClassificationSourceType;
import org.jacq.common.model.jpa.ViewClassificationResult;
import org.jacq.common.rest.ClassificationService;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author wkoller
 */
public class LazyClassificationTreeNode extends DefaultTreeNode {

    protected ClassificationService classificationService;

    protected boolean bChildrenFetched = false;

    public LazyClassificationTreeNode(ClassificationService classificationService) {
        super(null);

        this.classificationService = classificationService;
    }

    public LazyClassificationTreeNode(ClassificationService classificationService, ViewClassificationResult data) {
        super(data, null);

        this.classificationService = classificationService;
    }

    @Override
    public boolean isLeaf() {
        fetchChildren();

        return super.isLeaf(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChildCount() {
        fetchChildren();

        return super.getChildCount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TreeNode> getChildren() {
        fetchChildren();

        return super.getChildren(); //To change body of generated methods, choose Tools | Templates.
    }

    protected void fetchChildren() {
        if (!this.bChildrenFetched) {
            this.bChildrenFetched = true;

            if (this.getData() == null) {
                List<ViewClassificationResult> classificationResults = this.classificationService.getAccepted(ClassificationSourceType.CITATION, 10400);

                for (ViewClassificationResult classificationResult : classificationResults) {
                    super.getChildren().add(new LazyClassificationTreeNode(this.classificationService, classificationResult));
                }
            }
        }
    }

}
