/**
 * 
 */
package com.ext.apiservice.configutation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 */
@PropertySource("classpath:config.properties")
@Component
@ConfigurationProperties("config")
public class ConfigProperties {

	private String sessionKeyApiUrl;

	/**
	 * @return the sessionKeyApiUrl
	 */
	public String getSessionKeyApiUrl() {
		return sessionKeyApiUrl;
	}

	/**
	 * @param sessionKeyApiUrl the sessionKeyApiUrl to set
	 */
	public void setSessionKeyApiUrl(String sessionKeyApiUrl) {
		this.sessionKeyApiUrl = sessionKeyApiUrl;
	}

}
