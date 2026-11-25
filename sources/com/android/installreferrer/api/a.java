package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;
import c.f1;
import c.m0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f13927a;

        @f1
        public a a() {
            Context context = this.f13927a;
            if (context != null) {
                return new com.android.installreferrer.api.b(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        private b(Context context) {
            this.f13927a = context;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f13928l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f13929m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f13930n = 1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f13931o = 2;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f13932p = 3;
    }

    @f1
    public static b d(@m0 Context context) {
        return new b(context);
    }

    @f1
    public abstract void a();

    @f1
    public abstract d b() throws RemoteException;

    @f1
    public abstract boolean c();

    @f1
    public abstract void e(@m0 com.android.installreferrer.api.c cVar);
}
