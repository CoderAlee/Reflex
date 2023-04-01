package org.alee.reflex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2023/4/1
 * @description: xxxx
 *
 *********************************************************/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReflexMeta {}
