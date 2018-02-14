package com.coinage.project.serwice;

import com.coinage.project.APIException;
import com.coinage.project.domain.Coinage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CoinageService {

    private ApiNBPService apiNBPService;

    public double calculateCurrency(String currency, double quantity) {
        log.info("Calculate currency  - currency {}, quantity {}", currency, quantity);
        List<Coinage> rates = apiNBPService.getRatesFromNBP();

        Double currencyMid = rates.stream()
                .filter(rate -> rate.getCode().equals(currency))
                .map(Coinage::getMid)
                .findFirst()
                .orElseThrow(APIException::new);

        Double resould = quantity / currencyMid;

        return resould;

    }
}
