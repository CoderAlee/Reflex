package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticLong extends BaseStaticField {


    ReflexStaticLong(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public long get() {
        try {
            return mField.getLong(null);
        } catch (Exception ignore) {
            return 0L;
        }
    }

    public void set(long value) {
        try {
            mField.setLong(null, value);
        } catch (Exception ignore) {
        }
    }
}
