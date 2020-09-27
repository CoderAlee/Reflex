package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexLong extends BaseField {


    ReflexLong(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public long get(Object object) {
        try {
            return mField.getLong(object);
        } catch (Exception ignore) {
            return 0L;
        }
    }

    public void set(Object obj, long value) {
        try {
            mField.setLong(obj, value);
        } catch (Exception ignore) {
        }
    }
}
