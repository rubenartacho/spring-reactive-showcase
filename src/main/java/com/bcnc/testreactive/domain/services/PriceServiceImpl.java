package com.bcnc.testreactive.domain.services;

import com.bcnc.testreactive.domain.entities.Price;
import com.bcnc.testreactive.domain.utils.ComputeActualPriceFactory;
import com.bcnc.testreactive.ports.outbound.PriceRepositoryAdapter;
import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * This is the standard implementation  for PriceService
 */
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceRepositoryAdapter priceRepositoryAdapter;

    @Autowired
    ComputeActualPriceFactory computeActualPriceFactory;

    //Injecting a property so the algorithm  can be changed if needed
    @Value("${actual.price.algorithm:computeActualPriceByPriority}")
    private String computeActualPriceAlgorithm;


    @Override
    public Mono<Price> getActualPriceForDate(OffsetDateTime applicationDate, long productId, long brandId) {

        return priceRepositoryAdapter.getPricesForDate(applicationDate,productId,brandId)
                .collectList()
                .map(computeActualPriceFactory
                        .getComputeActualPriceStrategy(computeActualPriceAlgorithm)::getActualPriceFromList);
    }
}
