package com.alevel.homework15.page41;

import org.w3c.dom.ls.LSOutput;

public class Packer {

    public static void main(String[] args) {
        String a = "a";
        Integer b = 10;
        Packer packer = new Packer();
        Box<Food> goodsBox = new Box<>();
        Box<Food> foodBox = new Box<>();
        Box<Bakery> bakeryBox = new Box<>();
        Box<Cake> cakeBox = new Box<>();
        Box<Pie> pieBox = new Box<>();
        Box<Tart> tartBox = new Box<>();
        packer.repackage(foodBox, cakeBox);
//        packer.repackage(cakeBox, foodBox);
//        packer.repackage(bakeryBox, goodsBox);
    }

    public void repackage(Box<? super Bakery> to, Box<? extends Food> from) {
        Box<? super Bakery> temp = to;
        to.put(from);
        from.put((Box<? extends Food>) temp);
    }

}

class Box<T> {

    private T item;

    public void put(Box<? extends Food> item) {
        this.item = (T) item;
    }

    public T get() {
        return this.item;
    }
}

class Goods {
}

class Food extends Goods{
}

class Bakery extends Food{
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}
