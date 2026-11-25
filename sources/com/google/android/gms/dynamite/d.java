package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;
import c.o0;
import c.z;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    @z("DynamiteLoaderV2ClassLoader.class")
    private static volatile ClassLoader f16060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @z("DynamiteLoaderV2ClassLoader.class")
    private static volatile Thread f16061b;

    @o0
    public static synchronized ClassLoader a() {
        if (f16060a == null) {
            f16060a = b();
        }
        return f16060a;
    }

    @o0
    private static synchronized ClassLoader b() {
        ClassLoader contextClassLoader = null;
        if (f16061b == null) {
            f16061b = c();
            if (f16061b == null) {
                return null;
            }
        }
        synchronized (f16061b) {
            try {
                contextClassLoader = f16061b.getContextClassLoader();
            } catch (SecurityException e8) {
                String strValueOf = String.valueOf(e8.getMessage());
                Log.w("DynamiteLoaderV2CL", strValueOf.length() != 0 ? "Failed to get thread context classloader ".concat(strValueOf) : new String("Failed to get thread context classloader "));
            }
        }
        return contextClassLoader;
    }

    @o0
    private static synchronized Thread c() {
        SecurityException e8;
        Thread cVar;
        Thread thread;
        ThreadGroup threadGroup;
        ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (threadGroup2 == null) {
            return null;
        }
        synchronized (Void.class) {
            try {
                int iActiveGroupCount = threadGroup2.activeGroupCount();
                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                threadGroup2.enumerate(threadGroupArr);
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i8 >= iActiveGroupCount) {
                        threadGroup = null;
                        break;
                    }
                    threadGroup = threadGroupArr[i8];
                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                        break;
                    }
                    i8++;
                }
                if (threadGroup == null) {
                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                }
                int iActiveCount = threadGroup.activeCount();
                Thread[] threadArr = new Thread[iActiveCount];
                threadGroup.enumerate(threadArr);
                while (true) {
                    if (i7 >= iActiveCount) {
                        thread = null;
                        break;
                    }
                    thread = threadArr[i7];
                    if ("GmsDynamite".equals(thread.getName())) {
                        break;
                    }
                    i7++;
                }
                if (thread == null) {
                    try {
                        cVar = new c(threadGroup, "GmsDynamite");
                        try {
                            cVar.setContextClassLoader(null);
                            cVar.start();
                        } catch (SecurityException e9) {
                            e8 = e9;
                            String strValueOf = String.valueOf(e8.getMessage());
                            Log.w("DynamiteLoaderV2CL", strValueOf.length() != 0 ? "Failed to enumerate thread/threadgroup ".concat(strValueOf) : new String("Failed to enumerate thread/threadgroup "));
                        }
                    } catch (SecurityException e10) {
                        e8 = e10;
                        cVar = thread;
                    }
                    thread = cVar;
                }
            } catch (SecurityException e11) {
                e8 = e11;
                cVar = null;
            }
        }
        return thread;
    }
}
