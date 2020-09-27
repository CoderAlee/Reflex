package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexByte extends BaseField {


    ReflexByte(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public byte get(Object object) {
        try {
            return mField.getByte(object);
        } catch (Exception ignore) {
            return (byte) 0;
        }
    }

    public void set(Object obj, byte value) {
        try {
            mField.setByte(obj, value);
        } catch (Exception ignore) {
        }
    }
}
