package ca.ghandalf.web.analytic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

@ActiveProfiles(TestAnalyticProviderStage.env)
@SpringBootTest(classes = { AnalyticProvider.class })
@ContextConfiguration
@EnableConfigurationProperties
public class TestAnalyticProviderStage extends AbstractTestNGSpringContextTests {
	
	public static final String env = "stage";
	
	@Autowired
	private AnalyticProvider provider;
	
	@BeforeClass
	public void setUp() {
		Assert.assertNotNull(provider);
	}
	
	@Test
	public void loadGoogeAnalyticIdValue() {
		String expected = "UA-" + env + "-x";
		String actual = provider.getGoogleAnalyticId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExist-" + env + "-x";
		actual = provider.getGoogleAnalyticId();
		Assert.assertNotEquals(expected, actual);
	}
	
	@Test
	public void loadGoogleTagManagementId() {
		String expected = "TM-" + env + "-x";
		String actual = provider.getGoogleTagManagementId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExists-" + env + "-x";
		actual = provider.getGoogleTagManagementId();
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void loadPardotTrackingActiveId() {
		String expected = "PA-" + env + "-x";
		String actual = provider.getPardotTrackingActiveId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExists-" + env + "-x";
		actual = provider.getPardotTrackingActiveId();
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void loadPardotTrackingCodeId() {
		String expected = "PC-" + env + "-x";
		String actual = provider.getPardotTrackingCodeId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExists-" + env + "-x";
		actual = provider.getPardotTrackingCodeId();
		Assert.assertNotEquals(expected, actual);
	}
}
