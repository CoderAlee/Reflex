package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticShort extends BaseStaticField {


    ReflexStaticShort(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public short get() {
        try {
            return mField.getShort(null);
        } catch (Exception ignore) {
            return (short) 0;
        }
    }

    public void set(short value) {
        try {
            mField.setShort(null, value);
        } catch (Exception ignore) {
        }
    }
}
