/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.encrypt.checker.config;

import org.apache.shardingsphere.encrypt.config.EncryptRuleConfiguration;
import org.apache.shardingsphere.infra.config.rule.checker.DatabaseRuleConfigurationEmptyChecker;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EncryptRuleConfigurationEmptyCheckerTest {
    
    private EncryptRuleConfigurationEmptyChecker checker;
    
    @BeforeEach
    void setUp() {
        checker = (EncryptRuleConfigurationEmptyChecker) TypedSPILoader.getService(DatabaseRuleConfigurationEmptyChecker.class, EncryptRuleConfiguration.class);
    }
    
    @Test
    void assertIsEmpty() {
        assertTrue(checker.isEmpty(new EncryptRuleConfiguration(Collections.emptyList(), Collections.emptyMap())));
    }
}
