package kotlin;

/* JADX INFO: loaded from: classes2.dex */
class y0 extends x0 {
    @kotlin.internal.f
    private static final void c(boolean z7) {
        if (!z7) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @kotlin.internal.f
    private static final void d(boolean z7, i5.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.l0.p(lazyMessage, "lazyMessage");
        if (!z7) {
            throw new IllegalStateException(lazyMessage.invoke().toString());
        }
    }

    @kotlin.internal.f
    private static final <T> T e(T t7) {
        if (t7 != null) {
            return t7;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @kotlin.internal.f
    private static final <T> T f(T t7, i5.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.l0.p(lazyMessage, "lazyMessage");
        if (t7 != null) {
            return t7;
        }
        throw new IllegalStateException(lazyMessage.invoke().toString());
    }

    @kotlin.internal.f
    private static final Void g(Object message) {
        kotlin.jvm.internal.l0.p(message, "message");
        throw new IllegalStateException(message.toString());
    }

    @kotlin.internal.f
    private static final void h(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @kotlin.internal.f
    private static final void i(boolean z7, i5.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.l0.p(lazyMessage, "lazyMessage");
        if (!z7) {
            throw new IllegalArgumentException(lazyMessage.invoke().toString());
        }
    }

    @kotlin.internal.f
    private static final <T> T j(T t7) {
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @kotlin.internal.f
    private static final <T> T k(T t7, i5.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.l0.p(lazyMessage, "lazyMessage");
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException(lazyMessage.invoke().toString());
    }
}
