package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final void a(int i7) {
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Expected positive parallelism level, but got ", Integer.valueOf(i7)).toString());
        }
    }
}
