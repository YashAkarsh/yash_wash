package kotlin;

/* JADX INFO: loaded from: classes2.dex */
class i1 {
    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final Void a() {
        throw new k0(null, 1, 0 == true ? 1 : 0);
    }

    @kotlin.internal.f
    private static final Void b(String reason) {
        kotlin.jvm.internal.l0.p(reason, "reason");
        throw new k0("An operation is not implemented: " + reason);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> T c(T t7, i5.l<? super T, l2> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        block.z(t7);
        return t7;
    }

    @kotlin.internal.f
    private static final <T> T d(T t7, i5.l<? super T, l2> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        block.z(t7);
        return t7;
    }

    @kotlin.internal.f
    private static final <T, R> R e(T t7, i5.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        return block.z(t7);
    }

    @kotlin.internal.f
    private static final void f(int i7, i5.l<? super Integer, l2> action) {
        kotlin.jvm.internal.l0.p(action, "action");
        for (int i8 = 0; i8 < i7; i8++) {
            action.z(Integer.valueOf(i8));
        }
    }

    @kotlin.internal.f
    private static final <R> R g(i5.a<? extends R> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        return block.invoke();
    }

    @kotlin.internal.f
    private static final <T, R> R h(T t7, i5.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        return block.z(t7);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> T i(T t7, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (predicate.z(t7).booleanValue()) {
            return t7;
        }
        return null;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> T j(T t7, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (predicate.z(t7).booleanValue()) {
            return null;
        }
        return t7;
    }

    @kotlin.internal.f
    private static final <T, R> R k(T t7, i5.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        return block.z(t7);
    }
}
