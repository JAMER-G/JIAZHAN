package com.zhiyou.redis;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
//缓存配置类
@Configuration		//说明这个类是一个配置文件
@EnableCaching		//开启缓存功能功能
public class RedisCache extends CachingConfigurerSupport{
	@Autowired
	private volatile JedisConnectionFactory jedisConnectionFactory;
	@Autowired
	private volatile RedisTemplate<String, String> redisTemplate;
	@Autowired
	private volatile RedisCacheManager redisCacheManager;
	
	
	
	public RedisCache(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
			RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}



	public JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}

	@Override
	public KeyGenerator keyGenerator() {
			
		return new KeyGenerator() {
			public Object generate(Object target, Method method, Object... params) {
				String name = method.getName();	
				return name+"jiazhan";
			}
		};
	}


	
}
