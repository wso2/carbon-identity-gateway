/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.gateway.dao;

import org.wso2.carbon.identity.gateway.api.context.GatewayMessageContext;

/**
 * CacheBackedGatewaySessionDAO is the proxy level for GatewaySession persistent.
 */
public class CacheBackedGatewaySessionDAO extends GatewayContextDAO {

    private static GatewayContextDAO instance = new CacheBackedGatewaySessionDAO();
    private GatewayContextDAO asyncSessionDAO = AsyncGatewayContextDAO.getInstance();

    private CacheBackedGatewaySessionDAO() {

    }

    public static GatewayContextDAO getInstance() {
        return instance;
    }

    @Override
    public GatewayMessageContext get(String key) {
        return asyncSessionDAO.get(key);
    }

    @Override
    public void put(String key, GatewayMessageContext context) {
        asyncSessionDAO.put(key, context);
    }

    @Override
    public void remove(String key) {
        asyncSessionDAO.remove(key);
    }
}
