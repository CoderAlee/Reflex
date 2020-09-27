package org.alee.reflex;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
abstract class BaseField {

    protected Field mField;

    BaseField(Class<?> cls, Field field) throws NoSuchFieldException {
        mField = cls.getDeclaredField(field.getName());
        mField.setAccessible(true);
    }


}
