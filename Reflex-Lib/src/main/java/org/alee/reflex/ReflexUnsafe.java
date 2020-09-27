package org.alee.reflex;

import org.alee.reflex.annotation.MethodParams;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/31
 * @description: xxxx
 *
 *********************************************************/
public class ReflexUnsafe {

    private static final String UNSAFE_CLASS_NAME = "sun.misc.Unsafe";
    static ReflexStaticObject<Object> theUnsafe;
    @MethodParams({Class.class})
    static ReflexMethod<Object> allocateInstance;
    private static Object mUnsafe;

    static {
        ReflexClass.load(ReflexUnsafe.class, UNSAFE_CLASS_NAME);
    }

    private ReflexUnsafe() {
        throw new RuntimeException("No instance!");
    }

    public static <T> T newInstance(String className) throws Throwable {
        return newInstance((Class<T>) Class.forName(className));
    }

    public static <T> T newInstance(Class<T> cla) throws Throwable {
        mUnsafe = theUnsafe.get();
        return (T) allocateInstance.call(mUnsafe, cla);
    }

}
