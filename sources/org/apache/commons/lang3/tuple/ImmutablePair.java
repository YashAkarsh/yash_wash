package org.apache.commons.lang3.tuple;

/* JADX INFO: loaded from: classes3.dex */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    public ImmutablePair(L l7, R r7) {
        this.left = l7;
        this.right = r7;
    }

    public static <L, R> ImmutablePair<L, R> of(L l7, R r7) {
        return new ImmutablePair<>(l7, r7);
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r7) {
        throw new UnsupportedOperationException();
    }
}
