package com.ljp.test;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ApolloTest {

	@Test
	public void testOne() {
		Config config = ConfigService.getAppConfig();
		Integer timeSpent = config.getIntProperty("time.spent", 100);
		System.out.println("timeSpent = " + timeSpent);
	}

	@Test
	public void testTwo() {
		Config config = ConfigService.getAppConfig();
		config.addChangeListener(configChangeEvent -> Optional.ofNullable(configChangeEvent.changedKeys()).ifPresent(changedKeys -> {
			for (String changedKey : changedKeys) {
				System.out.println("changedKey = " + changedKey);
				ConfigChange configChange = configChangeEvent.getChange(changedKey);
				System.out.printf("Found change - propertyName(key): %s, oldValue: %s, newValue: %s, changeType: %s !!!%n", configChange.getPropertyName(), configChange.getOldValue(), configChange.getNewValue(), configChange.getChangeType());
			}
		}));
	}

}
