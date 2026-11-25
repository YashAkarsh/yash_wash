package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f24119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final StackTraceElement[] f24120b;

    static {
        f24119a = System.getProperty("surefire.test.class.path") != null;
        f24120b = new StackTraceElement[0];
    }

    q() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    q(Throwable th) {
        super(th);
    }
}
