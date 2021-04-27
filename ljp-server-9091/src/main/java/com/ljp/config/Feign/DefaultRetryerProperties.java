package com.ljp.config.Feign;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("feign.client.retryer.default")
@ConditionalOnProperty(prefix = "feign.client.retryer.default", value = "enable", havingValue = "true", matchIfMissing = false)
public class DefaultRetryerProperties {

	private int maxAttempts;
	private long period;
	private long maxPeriod;
	private boolean enable;

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public long getMaxPeriod() {
		return maxPeriod;
	}

	public void setMaxPeriod(long maxPeriod) {
		this.maxPeriod = maxPeriod;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

//	@Bean
//	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//	public Retryer defaultRetryer() {
//		return new Retryer.Default(period, maxPeriod, maxAttempts);
//	}

}
