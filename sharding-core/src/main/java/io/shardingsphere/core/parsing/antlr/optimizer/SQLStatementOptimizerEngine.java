/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.optimizer;

import io.shardingsphere.shaded.com.google.common.base.Optional;
import io.shardingsphere.core.metadata.table.ShardingTableMetaData;
import io.shardingsphere.core.parsing.antlr.rule.registry.statement.SQLStatementRule;
import io.shardingsphere.core.parsing.parser.sql.SQLStatement;
import lombok.RequiredArgsConstructor;

/**
 * SQL statement optimizer engine.
 * 
 * @author zhangliang
 */
@RequiredArgsConstructor
public final class SQLStatementOptimizerEngine {
    
    private final ShardingTableMetaData shardingTableMetaData;
    
    /**
     * Optimize SQL statement.
     *
     * @param rule SQL statement rule
     * @param sqlStatement SQL statement
     */
    public void optimize(final SQLStatementRule rule, final SQLStatement sqlStatement) {
        Optional<SQLStatementOptimizer> optimizer = rule.getOptimizer();
        if (optimizer.isPresent()) {
            optimizer.get().optimize(sqlStatement, shardingTableMetaData);
        }
    }
}
