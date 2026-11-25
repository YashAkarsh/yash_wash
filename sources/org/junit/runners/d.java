package org.junit.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.internal.h;

/* JADX INFO: loaded from: classes3.dex */
public enum d {
    NAME_ASCENDING(h.f39843b),
    JVM(null),
    DEFAULT(h.f39842a);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator<Method> f40025a;

    d(Comparator comparator) {
        this.f40025a = comparator;
    }

    public Comparator<Method> a() {
        return this.f40025a;
    }
}
