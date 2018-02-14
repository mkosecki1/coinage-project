package com.coinage.project.serwice;

import com.coinage.project.domain.Coinage;
import com.coinage.project.structure.OuterObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiNBPServiceTest {

    @Autowired
    private ApiNBPService apiNBPService;

    @MockBean
    private RestTemplate restTemplate;

    @Test(expected = NullPointerException.class)
    public void getRatesFromNBP() throws Exception {
        //Given
        OuterObj[] outerObjs = new OuterObj[0];
        when(restTemplate.getForEntity(anyString(),eq(OuterObj[].class))).thenReturn(ResponseEntity.ok(null));

        //When
        List<Coinage> result = apiNBPService.getRatesFromNBP();

        //Then
        //exception is thrown
    }

}