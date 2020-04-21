package com.shard.ing.shard;

import com.shard.ing.util.HashUtil;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;

public class DataSourceAlg implements PreciseShardingAlgorithm<String> {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceAlg.class);

    @Override
    public String doSharding(Collection<String> names, PreciseShardingValue<String> value) {
        int hash = HashUtil.rsHash(String.valueOf(value.getValue()));
        String dataName = "ds_" + ((hash % 2) + 1) ;
        LOG.debug("分库算法信息：{},{},{}",names,value,dataName);
        return dataName ;
    }
}
