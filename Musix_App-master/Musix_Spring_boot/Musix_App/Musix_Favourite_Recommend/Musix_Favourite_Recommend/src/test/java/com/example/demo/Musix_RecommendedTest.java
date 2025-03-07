package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Favourite;
import com.example.demo.model.Recommend;
import com.example.demo.repository.FavouriteRepository;
import com.example.demo.repository.RecommendRepository;

@SpringBootTest
class Musix_RecommendedTest {
	
	@Autowired
	private RecommendRepository recommendrepo;
	
	
	
	@Test
	void contextLoads() {
		 
	}
	

		@Test
	    public void testMockCreationrecommend(){
	        assertNotNull(recommendrepo);
	        
	    }
	
	// Test Cases Recommendations
	
	@Test
	@Rollback(false)
	public void testCreateRecommend() {
		int count=(int)recommendrepo.count();
	    Recommend savedrecommend= recommendrepo.save(new Recommend(count+1,"rishav@gmail.com","738732","Track 2","Artist 2", "Album 2","this is url","genre"));
	     
	    assertEquals(count+1,(int)recommendrepo.count());
	}
	
	@Test
	@Rollback(false)
	public void testListRecommended() {
	    List<Recommend> Recommended = (List<Recommend>) recommendrepo.findAll();
	    assertThat(Recommended).size().isGreaterThan(0);
	}
	
}

