package com.alevel.homework16;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ProductApplication {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();

        Category cityBags = new Category("City", (long) (categories.size() + 1));
        categories.add(cityBags);

        Category cyclingBags = new Category("Cycling", (long) (categories.size() + 1));
        categories.add(cyclingBags);

        Category laptopBags = new Category("Laptop", (long) (categories.size() + 1));
        categories.add(laptopBags);

        Category campingBags = new Category("Camping", (long) (categories.size() + 1));
        categories.add(campingBags);

        List<Product> products = new ArrayList<>();

        Product cityBagUrbanStyle = new Product("City bag urban style", BigDecimal.valueOf(1975.50), cityBags);
        Product cityBagPinkFlowers = new Product("City bag pink flowers", BigDecimal.valueOf(1531.10), cityBags);
        Product cityBagEgyptsSands = new Product("City bag Egypt's sands", BigDecimal.valueOf(2100), cityBags);
        Product cyclingBagHighway = new Product("Cycling bag highway", BigDecimal.valueOf(892.66), cyclingBags);
        Product cyclingBagCountryRoad = new Product("Cycling bag country road", BigDecimal.valueOf(1253.34), cyclingBags);
        Product cyclingBagCityTraffic = new Product("Cycling bag city traffic", BigDecimal.valueOf(1975.50), cyclingBags);
        Product laptopBagMacBookPro = new Product("Laptop bag MacBook pro", BigDecimal.valueOf(1235.15), laptopBags);
        Product laptopBagLenovoThinkPad = new Product("Laptop bag Lenovo thinkpad", BigDecimal.valueOf(899.99), laptopBags);
        Product laptopBagAsusSilence = new Product("Laptop bag Asus silence", BigDecimal.valueOf(18273.23), laptopBags);
        Product campingBagBigMountain = new Product("Camping bag big mountain", BigDecimal.valueOf(5278.98), campingBags);
        Product campingBagFastRiver = new Product("Camping bag fast river", BigDecimal.valueOf(10000.01), campingBags);
        Product campingBagColdNorth = new Product("Camping bag cold north", BigDecimal.valueOf(7283.92), campingBags);

        products.add(campingBagFastRiver);
        products.add(laptopBagLenovoThinkPad);
        products.add(cyclingBagHighway);
        products.add(campingBagBigMountain);
        products.add(cityBagPinkFlowers);
        products.add(cyclingBagCountryRoad);
        products.add(laptopBagMacBookPro);
        products.add(cyclingBagCityTraffic);
        products.add(laptopBagAsusSilence);
        products.add(cityBagUrbanStyle);
        products.add(campingBagColdNorth);
        products.add(cityBagEgyptsSands);

        System.out.println("Before sorting:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("____________________");

//        bubbleSort(products);

//        System.out.println("After sorting:");
//        for (Product product : products) {
//            System.out.println(product);
//        }

// We can use TreeSet collection with comparator instead of usual sorting loop

        ProductComparator comparator = new ProductComparator();
        TreeSet<Product> sortedProducts = new TreeSet<>(comparator);
        sortedProducts.addAll(products);

        System.out.println("After changing the collection type:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    static void bubbleSort(List<Product> products) {
        ProductComparator comparator = new ProductComparator();
        int n = products.size();
        Product temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (comparator.compare(products.get(j - 1), products.get(j)) > 0) {
                    //swap elements
                    temp = products.get(j - 1);
                    products.set(j - 1, products.get(j));
                    products.set(j, temp);
                }

            }
        }
    }
}
