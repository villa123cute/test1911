package com.tedu.duanzu.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="dz.page")
public class PageProperties {
	private Integer pageSize=3;
}
