package org.alee.reflex;

import org.alee.reflex.annotation.MethodParams;
import org.alee.reflex.annotation.MethodReflexParams;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexConstructor<T> {

    private Constructor<?> mConstructor;

    ReflexConstructor(Class<?> cls, Field field) throws NoSuchMethodException {
        if (field.isAnnotationPresent(MethodParams.class)) {
            mConstructor = handleWithParams(cls, field.getAnnotation(MethodParams.class));
        } else if (field.isAnnotationPresent(MethodReflexParams.class)) {
            mConstructor = handleWithReflexParams(cls, field.getAnnotation(MethodReflexParams.class));
        } else {
            mConstructor = handleWithNoParams(cls);
        }
        if (null == mConstructor) {
            throw new NoSuchMethodException("Not find Constructor function in [" + cls.getName() + "]");
        }
        if (!mConstructor.isAccessible()) {
            mConstructor.setAccessible(true);
        }
    }

    /**
     * 处理带有参数的构造函数
     *
     * @param cls    类
     * @param params 参数
     * @return {@link Constructor}
     * @throws NoSuchMethodException {@link NoSuchMethodException}
     */
    protected Constructor<?> handleWithParams(Class<?> cls, MethodParams params) throws NoSuchMethodException {
        return cls.getDeclaredConstructor(params.value());
    }

    /**
     * 处理带有反射参数的构造函数
     *
     * @param cls    类
     * @param params 参数
     * @return {@link Constructor}
     * @throws NoSuchMethodException {@link NoSuchMethodException}
     */
    protected Constructor<?> handleWithReflexParams(Class<?> cls, MethodReflexParams params) throws NoSuchMethodException {
        String[] values = params.value();
        Class[] parameterTypes = new Class[values.length];
        int N = 0;
        while (N < values.length) {
            try {
                parameterTypes[N] = Class.forName(values[N]);
                N++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cls.getDeclaredConstructor(parameterTypes);
    }

    /**
     * 处理不带参数的构造函数
     *
     * @param cls 类
     * @return {@link Constructor}
     * @throws NoSuchMethodException {@link NoSuchMethodException}
     */
    protected Constructor<?> handleWithNoParams(Class<?> cls) throws NoSuchMethodException {
        return cls.getDeclaredConstructor();
    }

    @SuppressWarnings("unchecked")
    public T newInstance() {
        try {
            return (T) mConstructor.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public T newInstance(Object... params) {
        try {
            return (T) mConstructor.newInstance(params);
        } catch (Exception e) {
            return null;
        }
    }
}
