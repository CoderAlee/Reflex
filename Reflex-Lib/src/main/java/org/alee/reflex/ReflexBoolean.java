package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: Boolean 类型的反射实现
 *
 *********************************************************/
public final class ReflexBoolean extends BaseField {

    ReflexBoolean(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public boolean get(Object object) {
        try {
            return mField.getBoolean(object);
        } catch (Exception ignore) {
            return false;
        }
    }

    public void set(Object obj, boolean value) {
        try {
            mField.setBoolean(obj, value);
        } catch (Exception ignore) {
        }
    }
}
