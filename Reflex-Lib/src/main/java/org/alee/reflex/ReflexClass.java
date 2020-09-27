package org.alee.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexClass {

    private static HashMap<Class<?>, Constructor<?>> REFLEX_TYPES = new HashMap<>();

    static {
        try {
            REFLEX_TYPES.put(ReflexObject.class, ReflexObject.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexByte.class, ReflexByte.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexShort.class, ReflexShort.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexInt.class, ReflexInt.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexLong.class, ReflexLong.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexFloat.class, ReflexFloat.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexDouble.class, ReflexDouble.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexBoolean.class, ReflexBoolean.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexChar.class, ReflexChar.class.getDeclaredConstructor(Class.class, Field.class));

            REFLEX_TYPES.put(ReflexStaticObject.class, ReflexStaticObject.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticByte.class, ReflexStaticByte.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticShort.class, ReflexStaticShort.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticInt.class, ReflexStaticInt.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticLong.class, ReflexStaticLong.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticFloat.class, ReflexStaticFloat.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticDouble.class, ReflexStaticDouble.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticBoolean.class, ReflexStaticBoolean.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticChar.class, ReflexStaticChar.class.getDeclaredConstructor(Class.class, Field.class));


            REFLEX_TYPES.put(ReflexMethod.class, ReflexMethod.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexStaticMethod.class, ReflexStaticMethod.class.getDeclaredConstructor(Class.class, Field.class));
            REFLEX_TYPES.put(ReflexConstructor.class, ReflexConstructor.class.getDeclaredConstructor(Class.class, Field.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ReflexClass() {
        throw new RuntimeException("No instance!");
    }

    public static Class<?> load(Class<?> mappingClass, String realClassName) {
        try {
            Class realClass = Class.forName(realClassName);
            if (null == realClass) {
                realClass = mappingClass.getClassLoader().loadClass(realClassName);
            }
            return load(mappingClass, realClass);
        } catch (Exception ignore) {
            return null;
        }
    }


    public static Class<?> load(Class<?> mappingClass, Class<?> realClass) {
        Field[] fields = mappingClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (Modifier.isStatic(field.getModifiers())) {
                    Constructor<?> constructor = REFLEX_TYPES.get(field.getType());
                    if (null == constructor) {
                        continue;
                    }
                    field.set(null, constructor.newInstance(realClass, field));
                }
            } catch (Exception ignore) {
            }
        }
        return realClass;
    }
}
