package com.zy.mpdemo.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ZY
 * @create 2022/1/1 17:43
 */
@Configuration
@MapperScan(value = "com.zy.mpdemo.mapper")
public class MpConfig {
    /**
     * 乐观锁插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector iSqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * SQL 执行性能分析插件
     * 开发环境使用，线上不推荐。
     * 三种环境：
     * dev:开发环境
     * test:测试环境
     * prod:生产环境
     */
    @Bean
    @Profile(value = {"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor result = new PerformanceInterceptor();
        // 单位 ms，超过些设置的 SQL 不执行。
        result.setMaxTime(200);
        // 设置 SQL 格式化。
        result.setFormat(true);
        return result;
    }
}
