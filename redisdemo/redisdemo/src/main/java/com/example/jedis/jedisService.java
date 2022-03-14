package com.example.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

public class jedisService {

    public boolean setnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            if (jedis == null) {
                return false;
            }
            return jedis.setnx(key, val).equals(1);
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    public int delnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            if (jedis == null) {
                return 0;
            }

            //if redis.call('get','orderkey')=='1111' then return redis.call('del','orderkey') else return 0 end
            StringBuilder sbScript = new StringBuilder();
            sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").
                    append(" then ").
                    append("    return redis.call('del','").append(key).append("')").
                    append(" else ").
                    append("    return 0").
                    append(" end");

            return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

}
