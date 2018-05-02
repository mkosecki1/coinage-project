package com.coinage.project.domain;

import com.coinage.project.serwice.ApiNBPService;
import com.coinage.project.serwice.CoinageService;
import com.coinage.project.structure.OuterObj;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CoinageTestSuite {

    @Autowired
    private ApiNBPService apiNBPService;

    @Autowired
    private CoinageService coinageService;

    @Test
    public void coinageTest() throws Exception {
        //Given
        //When
        Coinage coinage = new Coinage("dolar kanadyjski","CAD",2.6626);
        OuterObj outerObj = new OuterObj();
        outerObj.getRates().add(coinage);

        //Then
        Assert.assertNotNull(outerObj);
        Assert.assertEquals(coinage.getCurrency(),"dolar kanadyjski");
        Assert.assertEquals(coinage.getCode(),"CAD");
        Assert.assertEquals(java.util.Optional.ofNullable(coinage.getMid()),java.util.Optional.of(2.6626));
    }

}