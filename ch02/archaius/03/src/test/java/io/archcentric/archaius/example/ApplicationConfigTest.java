package io.archcentric.archaius.example;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ApplicationConfigTest {
	private ApplicationConfig appConfig = new ApplicationConfig();

	@Test
	public void shouldRetrieveThePropertyByKey() {
		String property = appConfig.getStringProperty("hello.message", "default message");

		assertThat(property, is("Hello Archaius!"));
	}

	@Test
	public void shouldRetrieveDefaultValueWhenKeyIsNotPresent() {
		String property = appConfig.getStringProperty("some.key", "default message");

		assertThat(property, is("default message"));
	}

	@Test
	public void shouldReadCascadeConfigurationFiles() {
		String property = appConfig.getStringProperty("cascade.property", "not found");

		assertThat(property, is("cascade value"));
	}
}
