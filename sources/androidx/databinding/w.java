package androidx.databinding;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface w<T> extends List<T> {

    public static abstract class a<T extends w> {
        public abstract void a(T t7);

        public abstract void f(T t7, int i7, int i8);

        public abstract void g(T t7, int i7, int i8);

        public abstract void h(T t7, int i7, int i8, int i9);

        public abstract void i(T t7, int i7, int i8);
    }

    void q(a<? extends w<T>> aVar);

    void r0(a<? extends w<T>> aVar);
}
