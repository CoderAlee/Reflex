package org.alee.reflex;

import org.alee.reflex.exception.NotStaticException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
abstract class BaseStaticField extends BaseField {

    BaseStaticField(Class<?> cls, Field field) throws NoSuchFieldException {
        super(cls, field);
        checkIsStatic(cls, mField);
    }

    protected void checkIsStatic(Class<?> cls, Field field) {
        if (!Modifier.isStatic(field.getModifiers())) {
            throw new NotStaticException(cls, field);
        }
    }
}
