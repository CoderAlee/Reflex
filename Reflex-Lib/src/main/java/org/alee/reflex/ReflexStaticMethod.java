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
public final class ReflexStaticMethod<RESULT> extends BaseMethod {

    ReflexStaticMethod(Class<?> cls, Field field) throws NoSuchMethodException {
        super(cls, field);
    }

    @Override
    protected Method handleWithParams(Class<?> cls, Field field, boolean meta) throws NoSuchMethodException {
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
        if (meta) {
            return ClassMapping.getDeclaredMethod.call(cls, getRealMethodName(field), types);
        } else {
            return cls.getDeclaredMethod(getRealMethodName(field), types);
        }
    }

    @Override
    protected Method handleWithReflexParams(Class<?> cls, Field field, boolean meta) throws NoSuchMethodException {
        boolean arrayset = false;
        String[] typeNames = field.getAnnotation(MethodReflexParams.class).value();
        Class<?>[] types = new Class<?>[typeNames.length];
        Class<?>[] types2 = new Class<?>[typeNames.length];
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
            if ("java.util.HashSet".equals(typeNames[i])) {
                arrayset = true;
                Class<?> type2 = type;
                try {
                    type2 = Class.forName("android.util.ArraySet");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (type2 != null) {
                    types2[i] = type2;
                } else {
                    types2[i] = type;
                }
            } else {
                types2[i] = type;
            }
        }
        try {
            if (meta) {
                return ClassMapping.getDeclaredMethod.call(cls, getRealMethodName(field), types);
            } else {
                return cls.getDeclaredMethod(getRealMethodName(field), types);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (arrayset) {
                if (meta)
                    return ClassMapping.getDeclaredMethod.call(cls, getRealMethodName(field), types2);
                else
                    return cls.getDeclaredMethod(getRealMethodName(field), types2);
            }
        }
        return null;
    }

    @Override
    protected Method handleWithNoParams(Class<?> cls, Field field, boolean meta) {
        Method[] methods;
        if (meta) {
            methods = ClassMapping.getDeclaredMethods.call(cls);
        } else {
            methods = cls.getDeclaredMethods();
        }
        for (Method method : methods) {
            if (method.getName().equals(getRealMethodName(field))) {
                if (0 == method.getParameterTypes().length) {
                    return method;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public RESULT call(Object... params) {
        RESULT obj = null;
        try {
            obj = (RESULT) mMethod.invoke(null, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    public RESULT callWithException(Object... params) throws Throwable {
        try {
            return (RESULT) mMethod.invoke(null, params);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) {
                throw e.getCause();
            }
            throw e;
        }
    }
}
