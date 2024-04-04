package com.code.sales.service;

import com.code.sales.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Sales Service, responsible for handling and processing Sales requests
 *
 * @author hvemuri
 */
public interface ISalesService {

    Discount calculateDiscount(List<Integer> productPrices);

    Discount calculateDiscountOfferRule2(List<Integer> productPrices);

    Discount calculateDiscountOfferRule3(List<Integer> productPrices);

}
