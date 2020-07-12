package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    /**
     * 这个类不要放在componmentScanner的扫描器下面，主要是用来配置Ribbon的负载算法的
     * @return
     */
    @Bean
    public IRule myRule(){

        return new RandomRule();
    }


}
