package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
class m {
    @a7.d
    public static final <T> T[] a(@a7.d T[] reference, int i7) {
        kotlin.jvm.internal.l0.p(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i7);
        kotlin.jvm.internal.l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "contentDeepHashCode")
    @kotlin.a1
    public static final <T> int b(@a7.e T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    @kotlin.g1(version = "1.3")
    public static final void c(int i7, int i8) {
        if (i7 <= i8) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i7 + ") is greater than size (" + i8 + ").");
    }

    public static final /* synthetic */ <T> T[] d(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        kotlin.jvm.internal.l0.y(0, "T?");
        return (T[]) new Object[0];
    }

    @kotlin.internal.f
    private static final String e(byte[] bArr, Charset charset) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(charset, "charset");
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] f(Collection<? extends T> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.y(0, "T?");
        T[] tArr = (T[]) collection.toArray(new Object[0]);
        kotlin.jvm.internal.l0.n(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return tArr;
    }
}
