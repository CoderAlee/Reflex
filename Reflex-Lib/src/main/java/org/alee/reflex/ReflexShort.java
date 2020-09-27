package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexShort extends BaseField {


    ReflexShort(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public short get(Object object) {
        try {
            return mField.getShort(object);
        } catch (Exception ignore) {
            return (short) 0;
        }
    }

    public void set(Object obj, short value) {
        try {
            mField.setShort(obj, value);
        } catch (Exception ignore) {
        }
    }
}
