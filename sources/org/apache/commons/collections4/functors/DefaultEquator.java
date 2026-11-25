package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultEquator<T> implements Equator<T>, Serializable {
    public static final int HASHCODE_NULL = -1;
    public static final DefaultEquator INSTANCE = new DefaultEquator();
    private static final long serialVersionUID = 825802648423525485L;

    private DefaultEquator() {
    }

    public static <T> DefaultEquator<T> defaultEquator() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Equator
    public boolean equate(T t7, T t8) {
        return t7 == t8 || (t7 != null && t7.equals(t8));
    }

    @Override // org.apache.commons.collections4.Equator
    public int hash(T t7) {
        if (t7 == null) {
            return -1;
        }
        return t7.hashCode();
    }
}
