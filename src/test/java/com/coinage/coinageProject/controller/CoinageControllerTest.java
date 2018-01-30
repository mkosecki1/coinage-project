package com.coinage.coinageProject.controller;

import com.coinage.coinageProject.serwice.CoinageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class CoinageControllerTest {

    @Mock
    private CoinageService coinageService;

    @InjectMocks
    private CoinageController coinageController;

    @Test
    public void calculateValue() throws Exception {
        //Given
        Mockito.when(coinageService.calculateCurrency("Euro",10.0)).thenReturn(15.0);

        //When
        ResponseEntity<Double> calcVal = coinageController.calculateValue("Euro",10.0);

        //Then
        Assert.assertEquals( 15.0, calcVal.getBody().doubleValue(),0.01);

    }

}