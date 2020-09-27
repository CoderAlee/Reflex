package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticBoolean extends BaseStaticField {

    ReflexStaticBoolean(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public boolean get() {
        try {
            return mField.getBoolean(null);
        } catch (Exception ignore) {
            return false;
        }
    }

    public void set(boolean value) {
        try {
            mField.setBoolean(null, value);
        } catch (Exception ignore) {
        }
    }
}
