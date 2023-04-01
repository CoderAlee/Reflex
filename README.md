# Reflex
一款声明式反射框架：用类定义的方式，直截了当的定义出来反射哪个类、哪个成员对象、哪个函数。只关注定义，不关注实现细节与赋值过程。

![build](https://img.shields.io/badge/build-passing-green.svg)
![](https://img.shields.io/badge/minSDK-21+-orange.svg)
[![](https://jitpack.io/v/CoderAlee/Reflex.svg)](https://jitpack.io/#CoderAlee/Reflex)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0)

---

## 使用

1. 在工程的`build.gradle`文件中添加:

```gradle
    allprojects {
    	maven { url 'https://jitpack.io' }
    }
```

2. 在项目`app`的`build.gradle`文件中添加:

``` gradle

dependencies {
     implementation 'org.alee.component.tools:reflex:Tag'
    ...
}
```

