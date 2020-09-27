package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticByte extends BaseStaticField {

    ReflexStaticByte(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public byte get() {
        try {
            return mField.getByte(null);
        } catch (Exception ignore) {
            return (byte) 0;
        }
    }

    public void set(byte value) {
        try {
            mField.setByte(null, value);
        } catch (Exception ignore) {
        }
    }
}
