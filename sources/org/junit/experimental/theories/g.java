package org.junit.experimental.theories;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    static class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39795b;

        a(Object obj, String str) {
            this.f39794a = obj;
            this.f39795b = str;
        }

        @Override // org.junit.experimental.theories.g
        public String b() {
            String str;
            Object obj = this.f39794a;
            if (obj == null) {
                str = "null";
            } else {
                try {
                    str = String.format("\"%s\"", obj);
                } catch (Throwable th) {
                    str = String.format("[toString() threw %s: %s]", th.getClass().getSimpleName(), th.getMessage());
                }
            }
            return String.format("%s <from %s>", str, this.f39795b);
        }

        @Override // org.junit.experimental.theories.g
        public Object c() {
            return this.f39794a;
        }

        public String toString() {
            return String.format("[%s]", this.f39794a);
        }
    }

    public static class b extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f39796a = 1;

        public b() {
        }

        public b(Throwable th) {
            super(th);
        }
    }

    public static g a(String str, Object obj) {
        return new a(obj, str);
    }

    public abstract String b() throws b;

    public abstract Object c() throws b;
}
