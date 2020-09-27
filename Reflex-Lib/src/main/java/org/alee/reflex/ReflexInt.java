package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public final class ReflexInt extends BaseField {


    ReflexInt(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
    }

    public int get(Object object) {
        try {
            return mField.getInt(object);
        } catch (Exception ignore) {
            return 0;
        }
    }

    public void set(Object obj, int intValue) {
        try {
            mField.setInt(obj, intValue);
        } catch (Exception ignore) {
        }
    }
}
