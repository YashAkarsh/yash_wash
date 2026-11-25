package okio;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "-Platform")
public final class i {
    @a7.d
    public static final byte[] a(@a7.d String asUtf8ToByteArray) {
        kotlin.jvm.internal.l0.p(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(kotlin.text.f.f35353b);
        kotlin.jvm.internal.l0.o(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final <R> R b(@a7.d Object lock, @a7.d i5.a<? extends R> block) {
        R rInvoke;
        kotlin.jvm.internal.l0.p(lock, "lock");
        kotlin.jvm.internal.l0.p(block, "block");
        synchronized (lock) {
            try {
                rInvoke = block.invoke();
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                kotlin.jvm.internal.i0.c(1);
            }
        }
        return rInvoke;
    }

    @a7.d
    public static final String c(@a7.d byte[] toUtf8String) {
        kotlin.jvm.internal.l0.p(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, kotlin.text.f.f35353b);
    }
}
