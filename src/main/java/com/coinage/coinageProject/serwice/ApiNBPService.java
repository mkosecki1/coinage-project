package com.coinage.coinageProject.serwice;

import com.coinage.coinageProject.domain.Coinage;
import com.coinage.coinageProject.structure.OuterObj;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ApiNBPService {

    private final static RestTemplate REST_TEMPLATE = new RestTemplate();
    private final static String API_URL = "http://api.nbp.pl/api/exchangerates/tables/A";


    public List<Coinage> getRatesFromNBP() {
        log.info("Getting data from API");

        ResponseEntity<OuterObj[]> responseEntity = REST_TEMPLATE.getForEntity(API_URL, OuterObj[].class);

        OuterObj[] outerObjs = responseEntity.getBody();

        return outerObjs[0].getRates();
    }


}
