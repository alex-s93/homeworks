package com.alevel.homework20.task4;

import com.alevel.homework20.annotations.Service;
import com.alevel.homework20.annotations.Value;

@Service
public class ServiceClass1 {
    @Value(value = "Service Class 1 name")
    private String name;
    public ServiceClass1() {
        System.out.println("ServiceClass1.ServiceClass1");
    }
}
