package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class m2 {

    @s1.d
    static final class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Logger f22858b = Logger.getLogger(a.class.getName());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runtime f22859a;

        a(Runtime runtime) {
            this.f22859a = runtime;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                f22858b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } catch (Throwable th2) {
                try {
                    System.err.println(th.getMessage());
                    System.err.println(th2.getMessage());
                } finally {
                    this.f22859a.exit(1);
                }
            }
        }
    }

    private m2() {
    }

    public static Thread.UncaughtExceptionHandler a() {
        return new a(Runtime.getRuntime());
    }
}
