package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexStaticChar extends BaseStaticField {

    ReflexStaticChar(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public char get() {
        try {
            return mField.getChar(null);
        } catch (Exception ignore) {
            return '\0';
        }
    }

    public void set(char value) {
        try {
            mField.setChar(null, value);
        } catch (Exception ignore) {
        }
    }
}
