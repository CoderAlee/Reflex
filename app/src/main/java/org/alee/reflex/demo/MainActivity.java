package org.alee.reflex.demo;

import android.graphics.drawable.Drawable;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.alee.reflex.ReflexUnsafe;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: xxxx
 *
 *********************************************************/
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Reflex";
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        try {
            Object internalClassDemo = ReflexUnsafe.newInstance("org.alee.reflex.demo.ReflexDemo$InternalClassDemo");
            InternalClassDemoMapping.printLog.call(internalClassDemo, TAG, "I am an internal class of ReflexDemo I called the ReflexDemo.printLog function");
            ReflexDemo reflexDemo = InternalClassDemoMapping.getReflexDemo.call(internalClassDemo);
            Log.i(TAG, "ReflexDemo:" + reflexDemo);
            ReflexDemoMapping.mId.set(reflexDemo, 99999);
            ReflexDemoMapping.doSomething.call(reflexDemo);
            ReflexDemoMapping.printLog.call(ReflexDemoMapping.TAG.get(), "Id is :" + ReflexDemoMapping.mId.get(reflexDemo));
            Log.i(TAG, ReflexDemoMapping.doSomething2.call(reflexDemo, "Hi i will do Other") + "");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        KeyboardView view = new KeyboardView(this, null);
        try {
            // 测试反射被UnsupportedAppUsage 标记的属性
            Drawable drawable = KeyboardViewMapping.mKeyBackground.get(view);
            Log.i(TAG, "drawable:" + drawable);
            boolean isKeyboardChanged = KeyboardViewMapping.mKeyboardChanged.get(view);
            Log.i(TAG, "isKeyboardChanged:" + isKeyboardChanged);
            boolean isFactorySet = LayoutInflaterMapping.mFactorySet.get(getLayoutInflater());
            Log.i(TAG, "isFactorySet:" + isFactorySet);
            LayoutInflater.Factory factory = LayoutInflaterMapping.mFactory.get(getLayoutInflater());
            Log.i(TAG, "factory:" + factory);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void getView() {
        mTextView = findViewById(R.id.tv);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View v) {

            }
        });
        //        mTextView.setText("mValue = " + mValue + "\r\n" + "sIsChanged = " + sIsChanged);
    }
}
