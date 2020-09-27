package org.alee.reflex;

import org.alee.reflex.annotation.MethodParams;
import org.alee.reflex.annotation.MethodReflexParams;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexMethod<RESULT> extends BaseMethod {

    ReflexMethod(Class<?> cls, Field field) throws NoSuchMethodException {
        super(cls, field);
    }

    @Override
    protected Method handleWithParams(Class<?> cls, Field field) throws NoSuchMethodException {
        Class<?>[] types = field.getAnnotation(MethodParams.class).value();
        for (int i = 0; i < types.length; i++) {
            Class<?> clazz = types[i];
            if (clazz.getClassLoader() == getClass().getClassLoader()) {
                try {
                    Class.forName(clazz.getName());
                    Class<?> realClass = (Class<?>) clazz.getField("TYPE").get(null);
                    types[i] = realClass;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return cls.getDeclaredMethod(getRealMethodName(field), types);
    }

    @Override
    protected Method handleWithReflexParams(Class<?> cls, Field field) throws NoSuchMethodException {
        String[] typeNames = field.getAnnotation(MethodReflexParams.class).value();
        Class<?>[] types = new Class<?>[typeNames.length];
        for (int i = 0; i < typeNames.length; i++) {
            Class<?> type = getProtoType(typeNames[i]);
            if (type == null) {
                try {
                    type = Class.forName(typeNames[i]);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            types[i] = type;
        }
        return cls.getDeclaredMethod(getRealMethodName(field), types);
    }

    @Override
    protected Method handleWithNoParams(Class<?> cls, Field field) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(getRealMethodName(field))) {
                if (0 == method.getParameterTypes().length) {
                    return method;
                }
            }
        }
        return null;
    }


    public RESULT call(Object receiver) {
        return this.call(receiver, (Object[]) null);
    }


    @SuppressWarnings("unchecked")
    public RESULT call(Object receiver, Object... args) {
        try {
            return (RESULT) mMethod.invoke(receiver, args);
        } catch (InvocationTargetException e) {
            if (null != e.getCause()) {
                e.getCause().printStackTrace();
            } else {
                e.printStackTrace();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public RESULT callWithException(Object receiver, Object... args) throws Throwable {
        try {
            return (RESULT) mMethod.invoke(receiver, args);
        } catch (InvocationTargetException e) {
            if (null == e.getCause()) {
                throw e;
            }
            throw e.getCause();
        }
    }

    public Class<?>[] paramList() {
        return mMethod.getParameterTypes();
    }
}
