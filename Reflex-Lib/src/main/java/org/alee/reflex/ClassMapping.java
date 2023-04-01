package org.alee.reflex;

import org.alee.reflex.annotation.MethodParams;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2023/4/1
 * @description: xxxx
 *
 *********************************************************/
class ClassMapping {
    @MethodParams(value = {String.class, Class[].class})
    public static ReflexMethod<Method> getDeclaredMethod;
    @MethodParams(value = {Class[].class})
    public static ReflexMethod<Method[]> getDeclaredMethods;
    @MethodParams(value = {String.class})
    public static ReflexMethod<Field> getDeclaredField;

    static {
        ReflexClass.load(ClassMapping.class, Class.class);
    }
}
