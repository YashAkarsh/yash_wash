package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f39727a = new a();

    public static final class a implements g {
        @Override // org.hamcrest.g
        public g a(String str, String str2, String str3, Iterable<? extends m> iterable) {
            return this;
        }

        @Override // org.hamcrest.g
        public g b(m mVar) {
            return this;
        }

        @Override // org.hamcrest.g
        public <T> g c(String str, String str2, String str3, T... tArr) {
            return this;
        }

        @Override // org.hamcrest.g
        public g d(String str) {
            return this;
        }

        @Override // org.hamcrest.g
        public g e(Object obj) {
            return this;
        }

        @Override // org.hamcrest.g
        public <T> g f(String str, String str2, String str3, Iterable<T> iterable) {
            return this;
        }

        public String toString() {
            return "";
        }
    }

    g a(String str, String str2, String str3, Iterable<? extends m> iterable);

    g b(m mVar);

    <T> g c(String str, String str2, String str3, T... tArr);

    g d(String str);

    g e(Object obj);

    <T> g f(String str, String str2, String str3, Iterable<T> iterable);
}
