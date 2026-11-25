package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public k0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(@a7.d String message) {
        super(message);
        kotlin.jvm.internal.l0.p(message, "message");
    }

    public /* synthetic */ k0(String str, int i7, kotlin.jvm.internal.w wVar) {
        this((i7 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
