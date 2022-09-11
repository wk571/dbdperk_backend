package com.dbd.jedis;

import com.dbd.jedis.entity.CommentPackage;
import com.dbd.jedis.entity.Data;
import com.dbd.model.vo.CommentVO;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class RedisDao {
    private final JedisPool jedisPool;
    private RuntimeSchema<CommentPackage> commentPackageRuntimeSchema =
            RuntimeSchema.createFrom(CommentPackage.class);
    private RuntimeSchema<Data> dataRuntimeSchema = RuntimeSchema.createFrom(Data.class);

    public RedisDao(){
        this("127.0.0.1",6379);
    }

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Map<String,Object> sacredPlace(){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String key = "sacredPlace";
            byte[] bytes = jedis.get(key.getBytes());
            if(bytes != null){
                Data data = dataRuntimeSchema.newMessage();
                ProtostuffIOUtil.mergeFrom(bytes,data,dataRuntimeSchema);
                return data.getInfo();
            }
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public List<CommentVO> getSurvivorPerkComment(String topicId){
        String key = "survivorComment";
        return getPerkComment(topicId,key);
    }


    public void addSurvivorPerkComment(String topicId, List<CommentVO> list){
        String key = "survivorComment";
        addPerkComment(topicId,list,key);
    }

    public List<CommentVO> getKillerPerkComment(String topicId){
        String key = "killerComment";
        return getPerkComment(topicId,key);
    }

    public void addKillerPerkComment(String topicId, List<CommentVO> list){
        String key = "killerComment";
        addPerkComment(topicId,list,key);
    }

    public List<CommentVO> getPerkComment(String topicId,String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            byte[] bytes = jedis.hget(key.getBytes(),topicId.getBytes());
            if(bytes != null) {
                CommentPackage commentPackage = commentPackageRuntimeSchema.newMessage();
                ProtostuffIOUtil.mergeFrom(bytes,commentPackage,commentPackageRuntimeSchema);
                return  commentPackage.getInfo();
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public void addPerkComment(String topicId, List<CommentVO> list,String key){
        Jedis jedis = null;
        CommentPackage commentPackage = new CommentPackage(list);
        try{
            jedis = jedisPool.getResource();
            byte[] bytes = ProtostuffIOUtil.toByteArray(commentPackage, commentPackageRuntimeSchema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//            Integer timeout = 60 * 60;
            long lnum = jedis.hset(key.getBytes(),topicId.getBytes(),bytes);
            System.out.println(lnum);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
