package com.atln.springcloud.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class IdGeneratorSnowFlake {
    private long workId;
    private long dataCenterId=1;

    private Snowflake snowflake = IdUtil.createSnowflake(workId, dataCenterId);


    @PostConstruct
    public void init() {
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("-----------workId:" + workId);
            System.out.println("=================:"+workId);
        } catch (Exception e) {
            workId = NetUtil.getLocalhostStr().hashCode();
            e.printStackTrace();
            log.info("-------当前机器码：workID:{}", workId);
        }

    }

    public synchronized long snowFlakeId() {
        long id = snowflake.nextId();
        return id;
    }

    public synchronized long snowflakeId(long workId,long dataCenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workId, dataCenterId);
        return snowflake.nextId();
    }


    public static void main(String[] args) {
        IdGeneratorSnowFlake idGeneratorSnowFlake=new IdGeneratorSnowFlake();
        long l = idGeneratorSnowFlake.snowFlakeId();
        System.out.println("-------------->id:"+l);
        System.out.println("------------"+(l+"").length());
    }
}