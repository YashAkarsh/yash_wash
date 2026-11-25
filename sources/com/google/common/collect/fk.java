package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class fk extends td<Object> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final fk f20273c = new fk();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20274d = 0;

    private fk() {
    }

    private Object readResolve() {
        return f20273c;
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
