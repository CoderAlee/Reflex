package org.alee.reflex;

import org.alee.reflex.annotation.MethodParams;
import org.alee.reflex.annotation.MethodReflexParams;
import org.alee.reflex.annotation.ReName;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
abstract class BaseMethod {

    protected Method mMethod;

    BaseMethod(Class<?> cls, Field field) throws NoSuchMethodException {
        if (field.isAnnotationPresent(MethodParams.class)) {
            mMethod = handleWithParams(cls, field);
        } else if (field.isAnnotationPresent(MethodReflexParams.class)) {
            mMethod = handleWithReflexParams(cls, field);
        } else {
            mMethod = handleWithNoParams(cls, field);
        }
        if (null == mMethod) {
            throw new NoSuchMethodException("Not find [" + field.getName() + "] function in [" + cls.getName() + "]");
        }
        mMethod.setAccessible(true);
    }

    /**
     * 处理带有参数的函数
     *
     * @param cls   类
     * @param field 要反射的映射字段
     * @return {@link Method}
     * @throws NoSuchMethodException {@link NoSuchMethodException}
     */
    protected abstract Method handleWithParams(Class<?> cls, Field field) throws NoSuchMethodException;

    /**
     * 处理带有反射参数的函数
     *
     * @param cls   类
     * @param field 要反射的映射字段
     * @return {@link Method}
     * @throws NoSuchMethodException {@link NoSuchMethodException}
     */
    protected abstract Method handleWithReflexParams(Class<?> cls, Field field) throws NoSuchMethodException;

    /**
     * 处理不带参数的函数
     *
     * @param cls   类
     * @param field 要反射的映射字段
     * @return {@link Method}
     */
    protected abstract Method handleWithNoParams(Class<?> cls, Field field);

    /**
     * 获取原始类型
     *
     * @param typeName 类型名称
     * @return Class
     */
    protected Class<?> getProtoType(String typeName) {
        if (typeName.equals(int.class.getSimpleName())) {
            return Integer.TYPE;
        }
        if (typeName.equals(long.class.getSimpleName())) {
            return Long.TYPE;
        }
        if (typeName.equals(boolean.class.getSimpleName())) {
            return Boolean.TYPE;
        }
        if (typeName.equals(byte.class.getSimpleName())) {
            return Byte.TYPE;
        }
        if (typeName.equals(short.class.getSimpleName())) {
            return Short.TYPE;
        }
        if (typeName.equals(char.class.getSimpleName())) {
            return Character.TYPE;
        }
        if (typeName.equals(float.class.getSimpleName())) {
            return Float.TYPE;
        }
        if (typeName.equals(double.class.getSimpleName())) {
            return Double.TYPE;
        }
        if (typeName.equals(void.class.getSimpleName())) {
            return Void.TYPE;
        }
        return null;
    }

    protected String getRealMethodName(Field field) {
        ReName rename = field.getAnnotation(ReName.class);
        return null == rename ? field.getName() : 0 >= rename.realName().length() ? field.getName() : rename.realName();

    }
}
