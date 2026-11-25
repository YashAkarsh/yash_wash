package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;

/* JADX INFO: loaded from: classes3.dex */
public class ConstantFactory<T> implements Factory<T>, Serializable {
    public static final Factory NULL_INSTANCE = new ConstantFactory(null);
    private static final long serialVersionUID = -3520677225766901240L;
    private final T iConstant;

    public ConstantFactory(T t7) {
        this.iConstant = t7;
    }

    public static <T> Factory<T> constantFactory(T t7) {
        return t7 == null ? NULL_INSTANCE : new ConstantFactory(t7);
    }

    @Override // org.apache.commons.collections4.Factory
    public T create() {
        return this.iConstant;
    }

    public T getConstant() {
        return this.iConstant;
    }
}
