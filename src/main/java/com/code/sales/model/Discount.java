package com.code.sales.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for Discount which holds discounted items and payable items
 */
@Data
@AllArgsConstructor
public class Discount {
    private List<Integer> discountedItems;
    private List<Integer> payableItems;
}
