/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_zinnia_Trainer */

#ifndef _Included_org_zinnia_Trainer
#define _Included_org_zinnia_Trainer
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_zinnia_Trainer
 * Method:    nativeNew
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_zinnia_Trainer_nativeNew
  (JNIEnv *, jobject);

/*
 * Class:     org_zinnia_Trainer
 * Method:    nativeDelete
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_org_zinnia_Trainer_nativeDelete
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_zinnia_Trainer
 * Method:    add
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_org_zinnia_Trainer_add
  (JNIEnv *, jobject, jlong, jlong);

/*
 * Class:     org_zinnia_Trainer
 * Method:    clear
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_zinnia_Trainer_clear
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_zinnia_Trainer
 * Method:    train
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_org_zinnia_Trainer_train
  (JNIEnv *, jobject, jlong, jstring);

#ifdef __cplusplus
}
#endif
#endif
