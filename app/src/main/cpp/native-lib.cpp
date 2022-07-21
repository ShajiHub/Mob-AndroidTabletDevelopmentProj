#include <jni.h>
#include <string>
using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_shajitha_recipeapp_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    string hello = "Food App";
    return env->NewStringUTF(hello.c_str());
}
float BMI = 0;
extern "C"
JNIEXPORT jstring JNICALL
Java_com_shajitha_recipeapp_dietPlan_calcBMI(JNIEnv *env, jobject , jfloat h, jfloat w) {
    // TODO: implement calcBMI()
    //Bodyweight in kilograms divided by height in meters squared
    //BMI = x KG / (y M * y M)
    //Example: BMI = 70 / (1.75 * 1.75) = 22.86

     float height = h / 100;
     BMI = w / (height * height);

    string userBMI = "Your BMI: " + to_string(BMI);
    return  env->NewStringUTF(userBMI.c_str());
}