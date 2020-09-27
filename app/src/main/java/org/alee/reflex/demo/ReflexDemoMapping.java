package org.alee.reflex.demo;

import org.alee.reflex.ReflexClass;
import org.alee.reflex.ReflexInt;
import org.alee.reflex.ReflexMethod;
import org.alee.reflex.ReflexStaticMethod;
import org.alee.reflex.ReflexStaticObject;
import org.alee.reflex.annotation.MethodParams;
import org.alee.reflex.annotation.MethodReflexParams;
import org.alee.reflex.annotation.ReName;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: MainActivity映射类
 *
 *********************************************************/
class ReflexDemoMapping {
    public static ReflexInt mId;
    public static ReflexStaticObject<String> TAG;
    @ReName(realName = "doSomething")
    @MethodReflexParams(value = {"java.lang.String"})
    public static ReflexMethod<Boolean> doSomething2;
    public static ReflexMethod<Void> doSomething;
    @MethodParams(value = {String.class, String.class})
    public static ReflexStaticMethod<Void> printLog;


    static {
        ReflexClass.load(ReflexDemoMapping.class, ReflexDemo.class);
    }
}
