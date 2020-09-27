package org.alee.reflex.exception;

import java.lang.reflect.Field;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public class NotStaticException extends RuntimeException {

    public NotStaticException(Class cls, Field field) {
        super("[ " + field.getName() + " ] in" + cls.getName() + " Is not declared as Static!");
    }
}
