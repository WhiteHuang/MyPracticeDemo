#include <jni.h>
#include <string>
#include <android/log.h>
// 这是标准的OpenSL ES库
#include <SLES/OpenSLES.h>
// 这里是针对安卓的扩展，如果要垮平台则需要注意
#include <SLES/OpenSLES_Android.h>

#include <iostream>

#define TAG "native_lib"

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__);
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROE,TAG,__VA_ARGS__);
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__);

extern "C" JNIEXPORT jstring JNICALL
Java_com_hjj_jni_load_JniLoader_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
/**
 * jni 基本类型展示
 */
extern "C" JNIEXPORT void JNICALL
Java_com_hjj_jni_load_JniLoader_test(JNIEnv *env, jobject instance,
                                     jboolean jboolean1,
                                     jbyte jbyte1,
                                     jchar jchar1,
                                     jshort jshort1,
                                     jlong jlong1,
                                     jfloat jfloat1,
                                     jdouble jdouble1,
                                     jstring name_,
                                     jint age,
                                     jintArray i_,
                                     jobjectArray strs,
                                     jobject person,
                                     jbooleanArray bArray_) {
    //1. 接收 Java 传递过来的 boolean 值
    unsigned char b_boolean = jboolean1;
    LOGD("boolean-> %d", b_boolean);

    //2. 接收 Java 传递过来的 boolean 值
    char c_byte = jbyte1;
    LOGD("jbyte-> %d", c_byte);

    //3. 接收 Java 传递过来的 char 值
    unsigned short c_char = jchar1;
    LOGD("char-> %d", c_char);

    //4. 接收 Java 传递过来的 short 值
    short s_short = jshort1;
    LOGD("short-> %d", s_short);

    //5. 接收 Java 传递过来的 long 值
    long l_long = jlong1;
    LOGD("long-> %d", l_long);

    //6. 接收 Java 传递过来的 float 值
    float f_float = jfloat1;
    LOGD("float-> %f", f_float);

    //7. 接收 Java 传递过来的 double 值
    double d_double = jdouble1;
    LOGD("double-> %f", d_double);

    //8. 接收 Java 传递过来的 String 值
    const char *name_string = env->GetStringUTFChars(name_, 0);
    LOGD("string-> %s", name_string);

    //9. 接收 Java 传递过来的 int 值
    int age_java = age;
    LOGD("int:%d", age_java);


    //10. 打印 Java 传递过来的 int []
    jint *intArray = env->GetIntArrayElements(i_, NULL);
    //拿到数组长度
    jsize intArraySize = env->GetArrayLength(i_);
    for (int i = 0; i < intArraySize; ++i) {
        LOGD("intArray->%d：", intArray[i]);
    }
    //释放数组
    env->ReleaseIntArrayElements(i_, intArray, 0);

//11. 打印 Java 传递过来的 String[]
    jsize stringArrayLength = env->GetArrayLength(strs);
    for (int i = 0; i < stringArrayLength; ++i) {
        jobject jobject1 = env->GetObjectArrayElement(strs, i);
        //强转 JNI String
        jstring stringArrayData = static_cast<jstring >(jobject1);

        //转 C  String
        const char *itemStr = env->GetStringUTFChars(stringArrayData, NULL);
        LOGD("String[%d]: %s", i, itemStr);
        //回收 String[]
        env->ReleaseStringUTFChars(stringArrayData, itemStr);
    }

    //12. 打印 Java 传递过来的 Object 对象
    //12.1 获取字节码
    const char *person_class_str = "com/hjj/jni/data/TestData";
    //12.2 转 jni jclass
    jclass person_class = env->FindClass(person_class_str);

    //12.3 拿到方法签名 javap -a
    const char *sig = "()Ljava/lang/String;";
    jmethodID jmethodID1 = env->GetMethodID(person_class, "getName", sig);

    jobject obj_string = env->CallObjectMethod(person, jmethodID1);
    jstring perStr = static_cast<jstring >(obj_string);
    const char *itemStr2 = env->GetStringUTFChars(perStr, NULL);
    LOGD("Person: %s", itemStr2);
    env->DeleteLocalRef(person_class); // 回收
    env->DeleteLocalRef(person); // 回收

//13. 打印 Java 传递过来的 booleanArray
    jsize booArrayLength = env->GetArrayLength(bArray_);
    jboolean *bArray = env->GetBooleanArrayElements(bArray_, NULL);
    for (int i = 0; i < booArrayLength; ++i) {
        bool b = bArray[i];
        jboolean b2 = bArray[i];
        LOGD("boolean:%d", b)
        LOGD("jboolean:%d", b2)
    }
    //回收
    env->ReleaseBooleanArrayElements(bArray_, bArray, 0);
}

/**
 * jni获取类对象
 */
extern "C" JNIEXPORT jobject JNICALL
Java_com_hjj_jni_load_JniLoader_getTestData(JNIEnv *env,
                                            jobject /* this */) {
    //1. 拿到 Java 类的全路径
    const char *person_java = "com/hjj/jni/data/TestData";
    const char *method="<init>";//构造方法标识

    //2. 找到需要处理的 Java 对象 class
    jclass j_person_class = env->FindClass(person_java);

    //3. 拿到空参构造方法
    jmethodID person_constructor = env->GetMethodID(j_person_class, method, "()V");

    //4. 创建对象
    jobject person_obj = env->NewObject(j_person_class, person_constructor);

    //5. 拿到 setName 方法的签名，并拿到对应的 setName 方法
    const char *nameSig = "(Ljava/lang/String;)V";
    jmethodID nameMethodId = env->GetMethodID(j_person_class, "setName", nameSig);

    //6. 拿到 setAge 方法的签名，并拿到 setAge 方法
    const char *ageSig = "(I)V";
    jmethodID ageMethodId = env->GetMethodID(j_person_class, "setAge", ageSig);

    //7. 正在调用 Java 对象函数
    const char *name = "甚平";
    jstring newStringName = env->NewStringUTF(name);
    env->CallVoidMethod(person_obj, nameMethodId, newStringName);
    env->CallVoidMethod(person_obj, ageMethodId, 28);

    const char *sig = "()Ljava/lang/String;";
    jmethodID jtoString = env->GetMethodID(j_person_class, "toString", sig);
    jobject obj_string = env->CallObjectMethod(person_obj, jtoString);
    jstring perStr = static_cast<jstring >(obj_string);
    const char *itemStr2 = env->GetStringUTFChars(perStr, NULL);
    LOGD("Person: %s", itemStr2);

    return person_obj;
}

/**
 * 对应java类的全路径名，.用/代替
 */
const char *classPathName = "com/hjj/jni/load/JniLoader";

extern "C"  //支持 C 语言
JNIEXPORT void JNICALL //告诉虚拟机，这是jni函数
native_dynamicRegister(JNIEnv *env, jobject instance, jstring name) {
    const char *j_name = env->GetStringUTFChars(name, NULL);
    LOGD("动态注册: %s", j_name)
    //释放
    env->ReleaseStringUTFChars(name, j_name);
}

extern "C"  //支持 C 语言
JNIEXPORT void JNICALL //告诉虚拟机，这是jni函数
native_dynamicRegister2(JNIEnv *env, jobject instance, jstring name) {
    const char *j_name = env->GetStringUTFChars(name, NULL);
    LOGD("动态注册: %s", j_name)

    jclass clazz = env->GetObjectClass(instance);//拿到当前类的class
    jmethodID mid =env->GetMethodID(clazz, "testException", "()V");//执行 Java 测试抛出异常的代码
    env->CallVoidMethod(instance, mid); // 执行会抛出一个异常
    jthrowable exc = env->ExceptionOccurred(); // 检测是否发生异常
    if (exc) {//如果发生异常
        env->ExceptionDescribe(); // 打印异常信息
        env->ExceptionClear(); // 清除掉发生的异常
        jclass newExcCls = env->FindClass("java/lang/IllegalArgumentException");
        env->ThrowNew(newExcCls, "JNI 中发生了一个异常信息"); // 返回一个新的异常到 Java
    }
    //释放
    env->ReleaseStringUTFChars(name, j_name);
}

/* 源码结构体
 * typedef struct {
    const char* name;
    const char* signature;
    void*       fnPtr;
    } JNINativeMethod;
 */
static const JNINativeMethod jniNativeMethod[] = {
        {"dynamicRegister", "(Ljava/lang/String;)V", (void *) (native_dynamicRegister)},
        {"dynamicRegister2", "(Ljava/lang/String;)V", (void *) (native_dynamicRegister2)}
};

/**
 * 该函数定义在jni.h头文件中，System.loadLibrary()时会调用JNI_OnLoad()函数
 */
JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *javaVm, void *pVoid) {
    //通过虚拟机 创建全新的 evn
    JNIEnv *jniEnv = nullptr;
    jint result = javaVm->GetEnv(reinterpret_cast<void **>(&jniEnv), JNI_VERSION_1_6);
    if (result != JNI_OK) {
        return JNI_ERR; // 主动报错
    }
    jclass mainActivityClass = jniEnv->FindClass(classPathName);
    jniEnv->RegisterNatives(mainActivityClass, jniNativeMethod,
                            sizeof(jniNativeMethod) / sizeof(JNINativeMethod));//动态注册的数量

    return JNI_VERSION_1_6;
}
