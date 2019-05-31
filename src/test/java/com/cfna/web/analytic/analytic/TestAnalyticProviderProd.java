package ca.ghandalf.web.analytic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ca.ghandalf.web.analytic.AnalyticProvider;

@RunWith(SpringRunner.class)
@ActiveProfiles(TestAnalyticProviderProd.env)
@SpringBootTest(classes = { AnalyticProvider.class })
@ContextConfiguration
@EnableConfigurationProperties
public class TestAnalyticProviderProd {
	
	public static final String env = "prod";
	
	@Autowired
	private AnalyticProvider provider;
	
	@Before
	public void setUp() {
		Assert.assertNotNull(provider);
	}
	
	@Test
	public void loadGoogeAnalyticIdValue() {
		String expected = AnalyticProvider.GOOGLE_ANALYTIC_ID;
		String actual = provider.getGoogleAnalyticId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExist-" + env + "-x";
		actual = provider.getGoogleAnalyticId();
		Assert.assertNotEquals(expected, actual);
	}
	
	@Test
	public void loadGoogleTagManagementId() {
		String expected = AnalyticProvider.GOOGLE_TAG_MANAGEMENT_ID;
		String actual = provider.getGoogleTagManagementId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExists-" + env + "-x";
		actual = provider.getGoogleTagManagementId();
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void loadPardotTrackingActiveId() {
		String expected = "75442";
		String actual = provider.getPardotTrackingActiveId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExists-" + env + "-x";
		actual = provider.getPardotTrackingActiveId();
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void loadPardotTrackingCodeId() {
		String expected = "1854";
		String actual = provider.getPardotTrackingCodeId();
		Assert.assertEquals(expected, actual);
		
		expected = "NotExists-" + env + "-x";
		actual = provider.getPardotTrackingCodeId();
		Assert.assertNotEquals(expected, actual);
	}
}
