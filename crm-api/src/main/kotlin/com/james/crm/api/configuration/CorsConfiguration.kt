/*
 * @Author: james.aworo
 * @Date: 11/29/23
 *
 * @Project: agent-crm
 */

package com.james.crm.api.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class CorsConfiguration : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:4200")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(false)
            .maxAge(3600)
    }

    override fun addFormatters(registry: FormatterRegistry) {
    }
}
