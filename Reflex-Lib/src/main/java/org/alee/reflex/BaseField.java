package org.alee.reflex;

import org.alee.reflex.annotation.ReflexMeta;

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
        if (field.isAnnotationPresent(ReflexMeta.class)) {
            mField = ClassMapping.getDeclaredField.call(cls, field.getName());
        } else {
            mField = cls.getDeclaredField(field.getName());
        }
        assert mField != null;
        mField.setAccessible(true);
    }


}
