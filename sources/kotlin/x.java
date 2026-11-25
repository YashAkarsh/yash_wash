package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class x<T> implements d0<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f35495a;

    public x(T t7) {
        this.f35495a = t7;
    }

    @Override // kotlin.d0
    public boolean a() {
        return true;
    }

    @Override // kotlin.d0
    public T getValue() {
        return this.f35495a;
    }

    @a7.d
    public String toString() {
        return String.valueOf(getValue());
    }
}
