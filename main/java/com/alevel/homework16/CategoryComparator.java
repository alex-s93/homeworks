package com.alevel.homework16;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category> {

    @Override
    public int compare(Category categoryLeft, Category categoryRight) {
        return (int) (categoryLeft.getCategoryId() - categoryRight.getCategoryId());
    }
}
