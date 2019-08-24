package com.hs.easyTools.datatype;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

public class EnumUtil<T extends Enum> {

    private static final RuntimeException UNSUPPORTED_ENUM = new RuntimeException("Enum is not supported");

    static final Map<Class, Map<String, Enum>> enumStore = new HashMap<>();

    private final Class<T> className;

    public EnumUtil(Class<T> className) {
        this.className = className;
        initialize(className);
    }

    static void initialize(Class className) {
        try {

            @SuppressWarnings({"unchecked"})
            Method valuesMethod = className.getMethod("values");

            Enum[] enumVals = (Enum[]) valuesMethod.invoke(null);

            enumStore.put(
                    className,
                    stream(enumVals)
                            .reduce(
                                    new HashMap<>(),
                                    (HashMap<String, Enum> acc, Enum e) -> {
                                        acc.put(e.name(), e);
                                        acc.put(e.toString(), e);
                                        return acc;
                                    },
                                    (a1, a2) -> {
                                        a1.putAll(a2);
                                        return a1;
                                    }
                            )
            );
        } catch (Exception e) {
            throw UNSUPPORTED_ENUM;
        }
    }

    public static Enum getValue(Class className, String str) {

        if (!enumStore.containsKey(className)) {
            initialize(className);
        }

        return enumStore.get(className).get(str);
    }

    public T getValue(String str) {
        @SuppressWarnings({"unchecked"})
        T e = (T) getValue(className, str);
        return e;
    }
}
