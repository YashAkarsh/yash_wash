package com.google.gson.internal.reflect;

import com.google.gson.internal.e;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f23240a;

    static {
        f23240a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return f23240a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
