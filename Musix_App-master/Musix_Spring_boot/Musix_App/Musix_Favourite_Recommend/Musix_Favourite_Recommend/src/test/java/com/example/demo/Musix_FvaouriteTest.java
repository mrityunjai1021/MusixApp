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
import com.example.demo.repository.FavouriteRepository;

@SpringBootTest
public class Musix_FvaouriteTest {

	
	@Autowired
	private FavouriteRepository favouriterepo;
	
	
	@Test
	void contextLoads() {
		 
	}
	
	// Test Cases Favourites
	
		@Test
		@Rollback(false)
		public void testCreateFavourite() {
			int count=(int)favouriterepo.count();
		    Favourite savedFavourite= favouriterepo.save(new Favourite(count+1,"ak@gmail.com","12345678","Track 1","Artist 1", "Album 1","this is url","genre",false));
		     
		    assertEquals(count+1,(int)favouriterepo.count());
		}
		
		@Test
		@Rollback(false)
		public void testListFavourited() {
		    List<Favourite> Favourited = (List<Favourite>) favouriterepo.findAll();
		    assertThat(Favourited).size().isGreaterThan(0);
		}
		
	
		@Test
	    public void testMockCreationFav(){
	        assertNotNull(favouriterepo);
	        
	    }
}
