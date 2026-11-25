package com.google.android.gms.dynamic;

import android.os.IBinder;
import c.m0;
import com.google.android.gms.common.internal.u;
import g1.y;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@y
public final class f<T> extends d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f16020a;

    private f(T t7) {
        this.f16020a = t7;
    }

    @c1.a
    @m0
    public static <T> T y0(@m0 d dVar) {
        if (dVar instanceof f) {
            return ((f) dVar).f16020a;
        }
        IBinder iBinderAsBinder = dVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i7 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i7++;
                field = field2;
            }
        }
        if (i7 != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        u.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e8) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e8);
        } catch (NullPointerException e9) {
            throw new IllegalArgumentException("Binder object is null.", e9);
        }
    }

    @c1.a
    @m0
    public static <T> d z3(@m0 T t7) {
        return new f(t7);
    }
}
