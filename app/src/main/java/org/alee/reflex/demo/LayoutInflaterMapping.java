package org.alee.reflex.demo;

import android.view.LayoutInflater;

import org.alee.reflex.ReflexBoolean;
import org.alee.reflex.ReflexClass;
import org.alee.reflex.ReflexObject;
import org.alee.reflex.annotation.ReflexMeta;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2023/4/1
 * @description: xxxx
 *
 *********************************************************/
class LayoutInflaterMapping {
    @ReflexMeta
    public static ReflexBoolean mFactorySet;
    @ReflexMeta
    public static ReflexObject<LayoutInflater.Factory> mFactory;

    static {
        ReflexClass.load(LayoutInflaterMapping.class, LayoutInflater.class);
    }
}
