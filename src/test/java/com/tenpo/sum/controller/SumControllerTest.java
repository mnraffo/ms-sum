package com.tenpo.sum.controller;

import com.redis.testcontainers.RedisContainer;
import com.tenpo.sum.client.fee.FeeClient;
import com.tenpo.sum.dto.Fee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SumControllerTest {

	@Container
	private static final PostgreSQLContainer<?> POSTGRES_CONTAINER =
			new PostgreSQLContainer<>(DockerImageName.parse("postgres:14-alpine"))
					.withExposedPorts(5432)
					.withDatabaseName("postgres")
					.withUsername("postgres")
					.withPassword("postgres");

	@Container
	private static final RedisContainer REDIS_CONTAINER =
			new RedisContainer(DockerImageName.parse("redis:6-alpine"))
					.withExposedPorts(6379);

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private FeeClient feeClient;

	@DynamicPropertySource
	private static void registerContainersProperties(DynamicPropertyRegistry registry) {
		POSTGRES_CONTAINER.start();
		REDIS_CONTAINER.start();

		registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);

		registry.add("spring.redis.host", REDIS_CONTAINER::getHost);
		registry.add("spring.redis.port", () -> REDIS_CONTAINER.getMappedPort(6379).toString());
	}

	@Test
	void givenResult_whenGetResult_thenStatus200() {
		given(feeClient.getFee()).willReturn(new Fee(10.00));

		assertThat(restTemplate.getForObject("http://localhost:" + port + "/ms-sum/sum?first=5&second=5",
				String.class)).contains("11.0");
	}

	@Test
	void givenResult_whenGetResultFor4Times_thenStatus429() {
		given(feeClient.getFee()).willReturn(new Fee(10.00));

		restTemplate.getForObject("http://localhost:" + port + "/ms-sum/sum?first=5&second=5",
				String.class);
		restTemplate.getForObject("http://localhost:" + port + "/ms-sum/sum?first=5&second=5",
				String.class);

		String result = restTemplate.getForObject("http://localhost:" + port + "/ms-sum/sum?first=5&second=5",
				String.class);

		assertThat(result).contains("429");
	}
}
