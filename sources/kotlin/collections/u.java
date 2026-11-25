package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u implements Iterator<Character>, j5.a {
    @a7.d
    public final Character a() {
        return Character.valueOf(b());
    }

    public abstract char b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
