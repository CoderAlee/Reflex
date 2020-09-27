package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexDouble extends BaseField {


    ReflexDouble(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public double get(Object object) {
        try {
            return mField.getDouble(object);
        } catch (Exception ignore) {
            return 0.0D;
        }
    }

    public void set(Object obj, double value) {
        try {
            mField.setDouble(obj, value);
        } catch (Exception ignore) {
        }
    }
}
