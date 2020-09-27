package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticObject<T> extends BaseStaticField {


    ReflexStaticObject(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    @SuppressWarnings("unchecked")
    public T get() {
        try {
            return (T) mField.get(null);
        } catch (Exception ignore) {
            return null;
        }
    }

    public void set(T value) {
        try {
            mField.set(null, value);
        } catch (Exception ignore) {
        }
    }

    public Class<?> getType() {
        return mField.getType();
    }
}
