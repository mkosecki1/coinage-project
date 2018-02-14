package com.coinage.project.controller;

import com.coinage.project.serwice.CoinageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CoinageController.class)

public class CoinageControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoinageService coinageService;

    @Test
    public void testCoinageController() throws Exception{
        //Given
        Mockito.when(coinageService.calculateCurrency("USD",1.00)).thenReturn(3.3375);
        //When
        mockMvc.perform(get("/v1/abc").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].currency",is("USD")))
                .andExpect(jsonPath("$[0].quantity",is(1.00)));
                //.andExpect(jsonPath("$",is(3.3375)));
    }
}
