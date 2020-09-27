package org.alee.reflex.demo;

import org.alee.reflex.ReflexClass;
import org.alee.reflex.ReflexMethod;
import org.alee.reflex.annotation.MethodParams;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/31
 * @description: xxxx
 *
 *********************************************************/
class InternalClassDemoMapping {

    public static ReflexMethod<ReflexDemo> getReflexDemo;
    @MethodParams(value = {String.class, String.class})
    public static ReflexMethod<Void> printLog;

    static {
        ReflexClass.load(InternalClassDemoMapping.class, "org.alee.reflex.demo.ReflexDemo$InternalClassDemo");
    }
}
