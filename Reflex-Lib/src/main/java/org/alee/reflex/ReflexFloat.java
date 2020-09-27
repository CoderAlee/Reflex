package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexFloat extends BaseField {


    ReflexFloat(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public float get(Object object) {
        try {
            return mField.getFloat(object);
        } catch (Exception ignore) {
            return 0F;
        }
    }

    public void set(Object obj, float value) {
        try {
            mField.setFloat(obj, value);
        } catch (Exception ignore) {
        }
    }
}
