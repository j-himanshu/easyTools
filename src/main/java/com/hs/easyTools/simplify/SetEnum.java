package com.hs.easyTools.simplify;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface SetEnum {
    String [] enums() default {};
}
