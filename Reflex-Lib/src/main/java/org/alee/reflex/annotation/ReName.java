package org.alee.reflex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/27
 * @description: xxxx
 *
 *********************************************************/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReName {
    /**
     * 真正的名字
     *
     * @return 结果
     */
    String realName();
}
