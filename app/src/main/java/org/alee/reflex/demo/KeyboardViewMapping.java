package org.alee.reflex.demo;

import android.graphics.drawable.Drawable;
import android.inputmethodservice.KeyboardView;

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
public final class KeyboardViewMapping {
    @ReflexMeta
    public static ReflexObject<Drawable> mKeyBackground;
    @ReflexMeta
    public static ReflexBoolean mKeyboardChanged;

    static {
        ReflexClass.load(KeyboardViewMapping.class, KeyboardView.class);
    }
}
