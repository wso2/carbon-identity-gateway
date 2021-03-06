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
package org.wso2.carbon.identity.gateway.authentication.authenticator;

import org.wso2.carbon.identity.gateway.authentication.response.AuthenticationResponse;
import org.wso2.carbon.identity.gateway.context.AuthenticationContext;
import org.wso2.carbon.identity.gateway.exception.AuthenticationHandlerException;

/**
 * Super interface for all the authenticators by providing generic APIs.
 */
public interface ApplicationAuthenticator {

    String getDisplayKey();

    String getName();

    /**
     * process is the one we called in authenticator to do the authentication process.
     *
     * @param authenticationContext Authentication Context
     * @return Authentication response
     * @throws AuthenticationHandlerException AuthenticationHandlerException
     */
    public AuthenticationResponse process(AuthenticationContext authenticationContext)
            throws AuthenticationHandlerException;

    /**
     * Authenticator wise, it should be able to enable/disable retry.
     *
     * @param authenticationContext Authentication Context
     * @return Whether retrying is enabled or not for this authenticator
     */
    public default boolean isRetryEnable(AuthenticationContext authenticationContext) {
        return false;
    }
}
