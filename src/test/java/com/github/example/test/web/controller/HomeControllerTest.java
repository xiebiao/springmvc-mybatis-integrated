package com.github.example.test.web.controller;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author xiebiao
 * @date 12/18/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations =
    {
        "classpath:spring/spring-config.xml"
    })
public class HomeControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getHomeMessages() throws Exception {
        this.mockMvc.perform(
            get("/messages.json")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
            // .accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.name").value("xiebiao"));
        //    .andExpect(jsonPath("$.name").value("Lee"));
    }

    @Test
    public void getHomeIndex() throws Exception {
        this.mockMvc.perform(
            get("/index")
                // .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
            .andExpect(status().isOk())
            .andExpect(content().contentType("text/html;charset=UTF-8"))
            .andExpect(content().string(new ContainsString()));
        //    .andExpect(jsonPath("$.name").value("Lee"));
    }

    /**
     * Check content
     */
    static class ContainsString extends BaseMatcher<String> {
        @Override public boolean matches(Object o) {
            String content = (String) o;
            if (content.contains("This is home index")) {
                return true;
            }
            return false;
        }

        @Override public void describeTo(Description description) {
            //Todo
        }
    }
}
