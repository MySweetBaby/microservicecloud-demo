package com.staryea.service;

import com.staryea.mapper.IDept;
import com.staryea.entities.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tangdy on 2018/12/26.
 */
@Service
//@CacheConfig(cacheNames = "emp") //添加此注解后，可以指定对应的缓存的名字 和缓存管理器，和指定的key生成策略，在下面的注解引用中就不用再重复定义
public class DeptService implements IDeptService {

    private Logger log = LoggerFactory.getLogger(DeptService.class);

    @Autowired
    private IDept iDept;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串类型

    @Autowired
    RedisTemplate redisTemplate; //操作k-v都是对象类型

    public List<Dept> getAll() {
        return iDept.getAll();
    }

    /**
     *  @Cacheable：使用此注解开始缓存
     *  Cacheable属性：
     *      cacheNames/value 指定缓存组件的名字
     *      key 将返回的数据以定义的key缓存在指定名字的组件中（Cache），如果不指定key 默认使用传入的参数来作为key，
     *      同时key也可以使用spEL表达式来获取key 例如：获取参数：#（参数名） #id #root.method.name 等
     *      keyGenerator key生成策略 可以自定义 此项和key只能定义一个，不能同时定义
     *      cacheManager 缓存管理器 cacheResolver 缓存解析器
     *      condition 指定符合的条件才进行缓存  ep：condition="#id>0 and #root.methodName eq 'aaa'"
     *      unless 否定缓存，当unless=true时，不缓存 ep:unless="#result==null" 可以通过#result获取方法返回的结果
     *      sync 异步模式，默认false 默认是在方法执行完之后同步，开始异步后，不支持unless
     *
     *  @CachePut:既调用方法，又更新缓存数据
     *   同步更新缓存 value 指定缓存的名称 但是需要注意，要保证缓存的key的生成策略是一样的，否则无法完成更新，同时也要将更新后的值返回
     *
     *   @CacheEvict:调用删除方法，删除缓存
     *      value 指定缓存的名称  key 通过指定的key 删除指定的缓存
     *      AllEntries = true 删除所有缓存数据，默认false
     *      beforeInvocation = false 表示在方法执行之后清空缓存，默认false，如果方法执行出现异常，不会清楚缓存
     *
     *  @Caching：定义复杂的缓存规则
     * @param id
     * @return
     */
    @Cacheable(value = "dept",keyGenerator = "myKeyGenerator")
    public Dept findById(Integer id) {
        log.debug("查询ID = "+id+"的部门！");
        return iDept.findById(id);
    }

    public boolean addDept(Dept dept) {
        int result =iDept.addDept(dept);
        return result==1?true:false;
    }

}