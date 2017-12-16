package com.example.kotlinexample

import com.example.kotlinexample.domain.Domains
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan(basePackageClasses = [Domains::class])
class PersistenceConfig {
}