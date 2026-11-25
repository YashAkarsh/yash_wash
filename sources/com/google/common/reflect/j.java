package com.google.common.reflect;

import com.google.common.base.e0;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class j<T> extends i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TypeVariable<?> f22453a;

    protected j() {
        Type typeA = a();
        e0.u(typeA instanceof TypeVariable, "%s should be a type variable.", typeA);
        this.f22453a = (TypeVariable) typeA;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f22453a.equals(((j) obj).f22453a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f22453a.hashCode();
    }

    public String toString() {
        return this.f22453a.toString();
    }
}
