package com.staryea.ruler;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * Created by tangdy on 2019/1/3.
 * 自定义当前负载规则，使每个服务执行5次后，换成其他服务继续执行5次
 */
public class Random_Self extends AbstractLoadBalancerRule {

    private int total = 0;
    private int index_current = 0;

    Random rand = new Random();

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List upList = lb.getReachableServers();
                List allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                if (total <= 5) {
                    server = (Server) upList.get(index_current);
                    total++;
                } else {
                    total = 0;
                    index_current++;
                    if (index_current >= upList.size()) {
                        index_current = 0;
                    }
//                    server = (Server) upList.get(index_current);

                }

//                int index = this.rand.nextInt(serverCount);
//                server = (Server)upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}