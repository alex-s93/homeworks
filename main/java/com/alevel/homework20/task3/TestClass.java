package com.alevel.homework20.task3;

@Service
public class TestClass {
    public TestClass() {
        if(TestClass.class.isAnnotationPresent(Service.class)) {
            Service annotation = TestClass.class.getAnnotation(Service.class);
            System.out.println(annotation.value() + " for class " + this.getClass().getName());
        }
    }
}
