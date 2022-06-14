package org.ldh.redis.conf;

import redis.clients.jedis.Jedis;

public class jedisService {

    public boolean setnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = RedisConfig.getJedis();
            if (jedis == null) {
                return false;
            }
            Long setnxRet = jedis.setnx(key, val);
            return setnxRet > 0;
        } catch (Exception ex) {
            if (jedis != null) {
                jedis.close();
            }
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
            jedis = RedisConfig.getJedis();
            if (jedis == null) {
                return 0;
            }
            //jedis.del(key);
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
