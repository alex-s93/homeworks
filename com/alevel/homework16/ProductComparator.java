package com.alevel.homework16;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product productLeft, Product productRight) {
        CategoryComparator categoryComparator = new CategoryComparator();

        int result = categoryComparator.compare(productLeft.getCategory(), productRight.getCategory());
        if (result == 0) {
            result = productLeft.getPrice().intValue() - productRight.getPrice().intValue();
        }
        return result;
    }
}
