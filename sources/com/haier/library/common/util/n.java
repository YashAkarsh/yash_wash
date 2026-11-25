package com.haier.library.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n<S, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f26602b = "set";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Method> f26603a = new HashMap<>();

    public n(Class<T> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Target class should not be null");
        }
        Field[] declaredFields = cls.getDeclaredFields();
        for (Method method : cls.getMethods()) {
            for (Field field : declaredFields) {
                if (method.getName().equalsIgnoreCase(f26602b + field.getName())) {
                    this.f26603a.put(field.getName(), method);
                }
            }
        }
    }

    private static Object a(Field field, Object obj) {
        if (field == null) {
            throw new IllegalArgumentException("field to be get shouldn't be null");
        }
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (IllegalAccessException e8) {
            e3.a.v("Get field value error", e8);
            return null;
        }
    }

    public static void c(Object obj, Object obj2, String... strArr) {
        if (obj == null || obj2 == null) {
            throw new IllegalArgumentException("Source bean or target bean shouldn't be null");
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] declaredFields2 = obj2.getClass().getDeclaredFields();
        int iMin = Math.min(declaredFields.length, declaredFields2.length);
        HashMap map = new HashMap(declaredFields.length);
        for (Field field : declaredFields) {
            Object objA = a(field, obj);
            if (objA != null) {
                map.put(field.getName(), objA);
            }
        }
        List arrayList = (strArr == null || strArr.length <= 0) ? new ArrayList() : Arrays.asList(strArr);
        for (int i7 = 0; i7 < iMin; i7++) {
            Field field2 = declaredFields2[i7];
            String name = field2.getName();
            if (!arrayList.contains(name)) {
                e(field2, obj2, map.get(name));
            }
        }
    }

    private static void e(Field field, Object obj, Object obj2) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            field.set(obj, obj2);
        } catch (Exception e8) {
            e3.a.v("Set field value", e8);
        }
    }

    public void b(S s7, T t7, p... pVarArr) {
        Object objTransform;
        if (s7 == null || t7 == null) {
            throw new IllegalArgumentException("Source bean or target bean shouldn't be null");
        }
        Field[] declaredFields = s7.getClass().getDeclaredFields();
        Field[] declaredFields2 = t7.getClass().getDeclaredFields();
        int iMin = Math.min(declaredFields.length, declaredFields2.length);
        int i7 = 0;
        for (int i8 = 0; i8 < iMin; i8++) {
            if (declaredFields[i8].getType() == declaredFields2[i8].getType()) {
                objTransform = a(declaredFields[i8], s7);
            } else {
                if (pVarArr == null || i7 >= pVarArr.length) {
                    throw new IllegalArgumentException("Converter is null or not enough");
                }
                objTransform = pVarArr[i7].transform(a(declaredFields[i8], s7));
                i7++;
            }
            d(declaredFields2[i8], t7, objTransform);
        }
    }

    public void d(Field field, Object obj, Object obj2) {
        if (field == null) {
            throw new IllegalArgumentException("field to be set shouldn't be null");
        }
        if (obj2 == null) {
            return;
        }
        Method method = this.f26603a.get(field.getName());
        try {
            if (method == null) {
                field.setAccessible(true);
                field.set(obj, obj2);
            } else {
                method.invoke(obj, obj2);
            }
        } catch (Exception e8) {
            e3.a.v("setValue get Excp %s", e8);
        }
    }
}
