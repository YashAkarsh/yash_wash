package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class SwitchClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure<? super E>[] iClosures;
    private final Closure<? super E> iDefault;
    private final Predicate<? super E>[] iPredicates;

    private SwitchClosure(boolean z7, Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this.iPredicates = z7 ? FunctorUtils.copy(predicateArr) : predicateArr;
        this.iClosures = z7 ? FunctorUtils.copy(closureArr) : closureArr;
        this.iDefault = closure == null ? NOPClosure.nopClosure() : closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length != closureArr.length) {
            throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return closure == 0 ? NOPClosure.nopClosure() : closure;
        }
        return new SwitchClosure(predicateArr, closureArr, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e8) {
        int i7 = 0;
        while (true) {
            Predicate<? super E>[] predicateArr = this.iPredicates;
            if (i7 >= predicateArr.length) {
                this.iDefault.execute(e8);
                return;
            } else {
                if (predicateArr[i7].evaluate(e8)) {
                    this.iClosures[i7].execute(e8);
                    return;
                }
                i7++;
            }
        }
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }

    public Closure<? super E> getDefaultClosure() {
        return this.iDefault;
    }

    public Predicate<? super E>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public SwitchClosure(Predicate<? super E>[] predicateArr, Closure<? super E>[] closureArr, Closure<? super E> closure) {
        this(true, predicateArr, closureArr, closure);
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> map) {
        if (map != null) {
            Closure<E> closureRemove = map.remove(null);
            int size = map.size();
            if (size == 0) {
                return closureRemove == null ? NOPClosure.nopClosure() : closureRemove;
            }
            Closure[] closureArr = new Closure[size];
            Predicate[] predicateArr = new Predicate[size];
            int i7 = 0;
            for (Map.Entry<Predicate<E>, Closure<E>> entry : map.entrySet()) {
                predicateArr[i7] = entry.getKey();
                closureArr[i7] = entry.getValue();
                i7++;
            }
            return new SwitchClosure(false, predicateArr, closureArr, closureRemove);
        }
        throw new NullPointerException("The predicate and closure map must not be null");
    }
}
