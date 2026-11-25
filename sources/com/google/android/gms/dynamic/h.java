package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import c.m0;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f16022b;

    @c1.a
    public static class a extends Exception {
        @c1.a
        public a(@m0 String str) {
            super(str);
        }

        @c1.a
        public a(@m0 String str, @m0 Throwable th) {
            super(str, th);
        }
    }

    @c1.a
    protected h(@m0 String str) {
        this.f16021a = str;
    }

    @c1.a
    @m0
    protected abstract T a(@m0 IBinder iBinder);

    @c1.a
    @m0
    protected final T b(@m0 Context context) throws a {
        if (this.f16022b == null) {
            u.k(context);
            Context contextI = com.google.android.gms.common.l.i(context);
            if (contextI == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.f16022b = a((IBinder) contextI.getClassLoader().loadClass(this.f16021a).newInstance());
            } catch (ClassNotFoundException e8) {
                throw new a("Could not load creator class.", e8);
            } catch (IllegalAccessException e9) {
                throw new a("Could not access creator.", e9);
            } catch (InstantiationException e10) {
                throw new a("Could not instantiate creator.", e10);
            }
        }
        return this.f16022b;
    }
}
