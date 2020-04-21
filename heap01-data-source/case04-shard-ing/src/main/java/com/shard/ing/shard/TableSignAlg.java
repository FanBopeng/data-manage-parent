package com.shard.ing.shard;

import com.shard.ing.util.HashUtil;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class TableSignAlg implements PreciseShardingAlgorithm<String> {

    private static Logger LOG = LoggerFactory.getLogger(TableSignAlg.class);

    @Override
    public String doSharding(Collection<String> names, PreciseShardingValue<String> value) {
        int hash = HashUtil.rsHash(String.valueOf(value.getValue()));
        String tableName = "user_info_" + (hash % 3) ;
        LOG.debug("分表算法信息：{},{},{}",names,value,tableName);
        return tableName ;
    }

}
