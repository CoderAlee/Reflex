package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexChar extends BaseField {


    ReflexChar(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public char get(Object object) {
        try {
            return mField.getChar(object);
        } catch (Exception ignore) {
            return '\0';
        }
    }

    public void set(Object obj, char value) {
        try {
            mField.setChar(obj, value);
        } catch (Exception ignore) {
        }
    }
}
