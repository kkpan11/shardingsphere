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

package org.apache.shardingsphere.data.pipeline.common.sqlbuilder.fixture;

import org.apache.shardingsphere.data.pipeline.api.ingest.record.Column;
import org.apache.shardingsphere.data.pipeline.api.ingest.record.DataRecord;
import org.apache.shardingsphere.data.pipeline.spi.sqlbuilder.DialectPipelineSQLBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class FixturePipelineSQLBuilder implements DialectPipelineSQLBuilder {
    
    @Override
    public List<Column> extractUpdatedColumns(final DataRecord dataRecord) {
        return Collections.emptyList();
    }
    
    @Override
    public String buildCheckEmptySQL(final String schemaName, final String tableName) {
        return null;
    }
    
    @Override
    public Optional<String> buildEstimatedCountSQL(final String schemaName, final String tableName) {
        return Optional.empty();
    }
    
    @Override
    public Optional<String> buildCRC32SQL(final String schemaName, final String tableName, final String column) {
        return Optional.of(String.format("SELECT CRC32(%s) FROM %s", column, tableName));
    }
    
    @Override
    public String getDatabaseType() {
        return "FIXTURE";
    }
}
