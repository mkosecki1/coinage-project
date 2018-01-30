package com.coinage.coinageProject.serwice;

import com.coinage.coinageProject.APIException;
import com.coinage.coinageProject.domain.Coinage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoinageService {

    private ApiNBPService apiNBPService;
    public double calculateCurrency(String currency, double quantity) {

        List<Coinage> rates = apiNBPService.getRatesFromNBP();

        Double currencyMid = rates.stream()
                .filter(rate -> rate.getCode().equals(currency))
                .map(rate->rate.getMid())
                .findFirst()
                .orElseThrow(() -> new APIException());
        Double resoult = quantity/currencyMid;
        return resoult;

    }
}
