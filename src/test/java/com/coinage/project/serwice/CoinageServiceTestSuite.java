package com.coinage.project.serwice;

import com.coinage.project.domain.Coinage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CoinageServiceTestSuite {

    @Mock
    private ApiNBPService apiNBPService;

    @InjectMocks
    private CoinageService coinageService;

    @Test
    public void calculateCurrency() throws Exception {
        //Given
        String currency = "USD";
        double quantity = 10.00;
        List<Coinage> coinages = new ArrayList<>();
        Coinage coinage1 = new Coinage("dolar", "USD",1.00);
        Coinage coinage2 = new Coinage("euro", "EUR",1.00);
        coinages.add(coinage1);
        coinages.add(coinage2);
        Mockito.when(apiNBPService.getRatesFromNBP()).thenReturn(coinages);

        //When
        double calculator = coinageService.calculateCurrency(currency,quantity);

        //Then
        Assert.assertEquals(calculator,10.00,0.01);
    }

}