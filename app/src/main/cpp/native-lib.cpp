#include <jni.h>
#include <string>

#include <iostream>
#include <ctime>

extern "C"
jstring
Java_com_puisormobile_androidndk_MainActivity_stringFromJNI(JNIEnv* env, jobject) {
    std::string hello = "<font color='#FF0000'>Android</font> loves <font color='#0000FF'>C++</font>";
    return env->NewStringUTF(hello.c_str());
}

time_t _tm =time(NULL );
struct tm * curtime = localtime ( &_tm );

extern "C"
jstring
Java_com_puisormobile_androidndk_MainActivity_stringCopyright(JNIEnv* env, jobject) {
 std::string cr = asctime(curtime);
  return env->NewStringUTF(cr.c_str());
}


