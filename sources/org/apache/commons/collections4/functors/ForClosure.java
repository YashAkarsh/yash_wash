package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;

/* JADX INFO: loaded from: classes3.dex */
public class ForClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final int iCount;

    public ForClosure(int i7, Closure<? super E> closure) {
        this.iCount = i7;
        this.iClosure = closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> forClosure(int i7, Closure<? super E> closure) {
        if (i7 <= 0 || closure == 0) {
            return NOPClosure.nopClosure();
        }
        return i7 == 1 ? closure : new ForClosure(i7, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e8) {
        for (int i7 = 0; i7 < this.iCount; i7++) {
            this.iClosure.execute(e8);
        }
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
