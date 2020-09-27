package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticInt extends BaseStaticField {


    ReflexStaticInt(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public int get() {
        try {
            return mField.getInt(null);
        } catch (Exception ignore) {
            return 0;
        }
    }

    public void set(int value) {
        try {
            mField.setInt(null, value);
        } catch (Exception ignore) {
        }
    }
}
