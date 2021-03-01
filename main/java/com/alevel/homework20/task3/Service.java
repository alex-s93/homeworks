package com.alevel.homework20.task3;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Service {
    String value() default "annotation present";
}
