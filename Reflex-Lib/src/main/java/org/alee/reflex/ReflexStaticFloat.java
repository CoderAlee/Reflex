package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticFloat extends BaseStaticField {

    ReflexStaticFloat(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public float get() {
        try {
            return mField.getFloat(null);
        } catch (Exception ignore) {
            return 0F;
        }
    }

    public void set(float value) {
        try {
            mField.setFloat(null, value);
        } catch (Exception ignore) {
        }
    }
}
