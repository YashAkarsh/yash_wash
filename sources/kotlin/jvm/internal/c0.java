package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.7")
public class c0 extends g0 implements Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Class f34841j;

    public c0(Class cls) {
        super(1);
        this.f34841j = cls;
    }

    @Override // kotlin.jvm.internal.g0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return this.f34841j.equals(((c0) obj).f34841j);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g0
    public int hashCode() {
        return this.f34841j.hashCode();
    }

    @Override // kotlin.jvm.internal.g0
    public String toString() {
        return "fun interface " + this.f34841j.getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.g0, kotlin.jvm.internal.q
    /* JADX INFO: renamed from: y0 */
    public kotlin.reflect.i w0() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
