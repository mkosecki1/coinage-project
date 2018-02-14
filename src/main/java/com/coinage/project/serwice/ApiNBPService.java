package com.coinage.project.serwice;

import com.coinage.project.domain.Coinage;
import com.coinage.project.structure.OuterObj;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ApiNBPService {

    private final static String API_URL = "http://api.nbp.pl/api/exchangerates/tables/A";

    private RestTemplate restTemplate;

    public List<Coinage> getRatesFromNBP() {
        log.info("Getting data from API");

        ResponseEntity<OuterObj[]> responseEntity = restTemplate.getForEntity(API_URL, OuterObj[].class);

        OuterObj[] outerObjs = responseEntity.getBody();

        return outerObjs[0].getRates();
    }


}
