package com.alevel.homework20.task4;

import com.alevel.homework20.annotations.Init;

public class NonServiceClass3 {
    public NonServiceClass3() {
        System.out.println("NonServiceClass3.NonServiceClass3");
    }

    @Init
    public void printClass(Object object) {
        System.out.println(object.toString());
    }
}
