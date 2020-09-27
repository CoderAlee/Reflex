package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticDouble extends BaseStaticField {

    ReflexStaticDouble(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public double get() {
        try {
            return mField.getDouble(null);
        } catch (Exception ignore) {
            return 0.0D;
        }
    }

    public void set(double value) {
        try {
            mField.setDouble(null, value);
        } catch (Exception ignore) {
        }
    }
}
