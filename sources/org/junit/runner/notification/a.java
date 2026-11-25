package org.junit.runner.notification;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f39995c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.junit.runner.c f39996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f39997b;

    public a(org.junit.runner.c cVar, Throwable th) {
        this.f39997b = th;
        this.f39996a = cVar;
    }

    public org.junit.runner.c a() {
        return this.f39996a;
    }

    public Throwable b() {
        return this.f39997b;
    }

    public String c() {
        return b().getMessage();
    }

    public String d() {
        return this.f39996a.o();
    }

    public String e() {
        StringWriter stringWriter = new StringWriter();
        b().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public String toString() {
        return d() + ": " + this.f39997b.getMessage();
    }
}
