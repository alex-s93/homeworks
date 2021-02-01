package com.alevel.homework15.page41;

public class Packer {

    public static void main(String[] args) {
        String a = "a";
        Object b = 10;

        Packer packer = new Packer();
        Box<Food> goodsBox = new Box<>();
        Box<Food> foodBox = new Box<>();
        Box<Bakery> bakeryBox = new Box<>();
        Box<Cake> cakeBox = new Box<>();
        Box<Pie> pieBox = new Box<>();
        Box<Tart> tartBox = new Box<>();

        packer.repackage(foodBox, cakeBox);
//        packer.repackage(a, b);
//        packer.repackage(bakeryBox, goodsBox);
//        packer.repackage(bakeryBox, foodBox);

    }

    public <T> void repackage(Box<? super T> to, Box<? extends T> from) {
        to.put(from.get());
    }
}

class Box<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}

class Goods {
}

class Food extends Goods {
}

class Bakery extends Food {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}
