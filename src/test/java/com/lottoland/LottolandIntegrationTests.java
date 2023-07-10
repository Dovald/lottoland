package com.lottoland;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.lottoland.dto.ErrorDTO;
import com.lottoland.dto.GlobalStatsJankenDTO;
import com.lottoland.dto.JankenDTO;
import com.lottoland.dto.StatsJankenDTO;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class LottolandIntegrationTests {

	@Autowired
    private WebTestClient webTestClient;
	
	@Test
    public void test1() {
        
        webTestClient.get().uri("/lottoland/stats/janken")
        .exchange()
        .expectStatus().isOk()
        .expectBody(GlobalStatsJankenDTO.class)
        .value(response -> {
        	assertTrue(response.getTotalRounds().toString().equals("0"));
        });
    }

    @Test
    public void test2() {
        
        webTestClient.post().uri("/lottoland/janken/1234")
        .exchange()
        .expectStatus().isOk()
        .expectBody(JankenDTO.class)
        .value(response -> {
        	assertTrue(response.getPlayer2().equals("Rock"));
        });
    }
    
    @Test
    public void test3() {
        
        webTestClient.post().uri("/lottoland/janken/1234(")
        .exchange()
        .expectStatus().is4xxClientError()
        .expectBody(ErrorDTO.class)
        .value(response -> {
        	assertTrue(response.getErrorMessage().equals("Invalid sessionID supplied"));
        });
    }
    
    @Test
    public void test4() {
        
        webTestClient.post().uri("/lottoland/janken/reset/1234")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class)
        .value(response -> {
        	assertTrue(response.equals("OK"));
        });
    }
    
    @Test
    public void test5() {
        
        webTestClient.post().uri("/lottoland/janken/reset/1234(")
        .exchange()
        .expectStatus().is4xxClientError()
        .expectBody(ErrorDTO.class)
        .value(response -> {
        	assertTrue(response.getErrorMessage().equals("Invalid sessionID supplied"));
        });
    }
    
    @Test
    public void test6() {
        
        webTestClient.get().uri("/lottoland/stats/janken/1234")
        .exchange()
        .expectStatus().isOk()
        .expectBody(StatsJankenDTO.class)
        .value(response -> {
        	assertTrue(response.getRounds().isEmpty());
        });
    }
    
    @Test
    public void test7() {
        
        webTestClient.get().uri("/lottoland/stats/janken/1234(")
        .exchange()
        .expectStatus().is4xxClientError()
        .expectBody(ErrorDTO.class)
        .value(response -> {
        	assertTrue(response.getErrorMessage().equals("Invalid sessionID supplied"));
        });
    }
}
