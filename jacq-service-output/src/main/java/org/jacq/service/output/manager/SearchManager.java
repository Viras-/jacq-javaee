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
package org.jacq.service.output.manager;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jacq.common.manager.BaseDerivativeManager;

/**
 *
 * @author wkoller
 */
@ManagedBean
public class SearchManager extends BaseDerivativeManager {

    @PersistenceContext
    protected EntityManager em;

    @Inject
    protected ApplicationManager applicationManager;

    /**
     * Initialize bean and make sure abstract base class has entity manager
     */
    @PostConstruct
    public void init() {
        super.setEntityManager(em);
        super.setBaseApplicationManager(applicationManager);
    }

}
