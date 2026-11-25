package com.alibaba.android.arouter.core;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class c extends Instrumentation {
    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String[] stringArrayExtra;
        Class<?> clsLoadClass = classLoader.loadClass(str);
        Object objNewInstance = clsLoadClass.newInstance();
        if (com.alibaba.android.arouter.launcher.a.e() && (stringArrayExtra = intent.getStringArrayExtra(com.alibaba.android.arouter.launcher.a.f12461b)) != null && stringArrayExtra.length > 0) {
            for (String str2 : stringArrayExtra) {
                Object obj = intent.getExtras().get(com.alibaba.android.arouter.utils.f.b(str2));
                if (obj != null) {
                    try {
                        Field declaredField = clsLoadClass.getDeclaredField(com.alibaba.android.arouter.utils.f.b(str2));
                        declaredField.setAccessible(true);
                        declaredField.set(objNewInstance, obj);
                    } catch (Exception e8) {
                        com.alibaba.android.arouter.launcher.a.f12464e.error("ARouter::", "Inject values for activity error! [" + e8.getMessage() + "]");
                    }
                }
            }
        }
        return (Activity) objNewInstance;
    }
}
