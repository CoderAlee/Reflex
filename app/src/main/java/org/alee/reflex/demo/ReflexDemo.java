package org.alee.reflex.demo;

import android.util.Log;

/**********************************************************
 *
 * @author: MY.Liu
 * @date: 2020/7/24
 * @description: 用于被反射调用
 *
 *********************************************************/
public class ReflexDemo {

    private static final String TAG = "Reflex";
    private int mId = 0xff;

    private void doSomething() {
        printLog(TAG, "I will do something!");
    }

    private static void printLog(String tag, String message) {
        Log.i(tag, message);
    }

    private Boolean doSomething(String something) {
        printLog(TAG, something);
        return true;
    }

    private class InternalClassDemo {

        private InternalClassDemo() {
            throw new RuntimeException("Object creation prohibited!");
        }

        public ReflexDemo getReflexDemo() {
            return new ReflexDemo();
        }


        private void printLog(String tag, String message) {
            ReflexDemo.printLog(tag, message);
        }
    }
}
