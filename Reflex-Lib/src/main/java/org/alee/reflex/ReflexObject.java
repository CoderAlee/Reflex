package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/

public final class ReflexObject<T> extends BaseField {


    ReflexObject(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    @SuppressWarnings("unchecked")
    public T get(Object object) {
        try {
            return (T) mField.get(object);
        } catch (Exception ignore) {
            return null;
        }
    }

    public void set(Object obj, T value) {
        try {
            mField.set(obj, value);
        } catch (Exception ignore) {
        }
    }

    public Class<?> getType() {
        return mField.getType();
    }
}
