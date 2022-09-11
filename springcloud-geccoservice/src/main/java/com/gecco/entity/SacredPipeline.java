package com.gecco.entity;

import com.dbd.jedis.entity.Data;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.gecco.exec.Sacred;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@PipelineName(value="sacredPipeline")
public class SacredPipeline implements Pipeline<Sacred> {


    public static List<String> sacredPerks;

    public void process(Sacred sacred) {
        sacredPerks = sacred.getScaredPerks();
        setSacredPlace();
    }

    public static List<String> getSacredPerks() {
        return sacredPerks;
    }



    JedisPool jedisPool = new JedisPool("127.0.0.1");

    private RuntimeSchema<Data> mapRuntimeSchema = RuntimeSchema.createFrom(Data.class);

    public String setSacredPlace(){
        Jedis jedis = null;

        Map<String,Object> map = new HashMap<>();
        map.put("data",sacredPerks);
        Data data = new Data(map);
        try{
            jedis = jedisPool.getResource();
            String key = "sacredPlace";
            byte[] bytes = ProtostuffIOUtil.toByteArray(data, mapRuntimeSchema,
                    LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            String result = jedis.set(key.getBytes(),bytes);
            return result;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    @Test
    public void testJedis(){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
//            jedis.set("omg","this");
            String key = "sacredPlace";
            byte[] bytes = jedis.get(key.getBytes());
            if (bytes != null) {
                Data data = mapRuntimeSchema.newMessage();
                ProtostuffIOUtil.mergeFrom(bytes, data, mapRuntimeSchema);
                System.out.println(data.getInfo());
            }
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        System.out.println(jedis.get("sacredPlace"));
    }
}
