package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f40048b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Throwable> f40049a;

    public e(List<Throwable> list) {
        this.f40049a = list;
    }

    public List<Throwable> a() {
        return this.f40049a;
    }

    public e(Throwable th) {
        this((List<Throwable>) Arrays.asList(th));
    }

    public e(String str) {
        this(new Exception(str));
    }
}
