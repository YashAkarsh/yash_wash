package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f6280a = new e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n0 f6281b = new e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n0 f6282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n0 f6283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n0 f6284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n0 f6285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f6286g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f6287h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f6288i = 2;

    private static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final a f6289b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6290a;

        private a(boolean z7) {
            this.f6290a = z7;
        }

        @Override // androidx.core.text.o0.c
        public int a(CharSequence charSequence, int i7, int i8) {
            int i9 = i8 + i7;
            boolean z7 = false;
            while (i7 < i9) {
                int iA = o0.a(Character.getDirectionality(charSequence.charAt(i7)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                    } else if (!this.f6290a) {
                        return 1;
                    }
                    i7++;
                    z7 = z7;
                } else if (this.f6290a) {
                    return 0;
                }
                z7 = true;
                i7++;
                z7 = z7;
            }
            if (z7) {
                return this.f6290a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f6291a = new b();

        private b() {
        }

        @Override // androidx.core.text.o0.c
        public int a(CharSequence charSequence, int i7, int i8) {
            int i9 = i8 + i7;
            int iB = 2;
            while (i7 < i9 && iB == 2) {
                iB = o0.b(Character.getDirectionality(charSequence.charAt(i7)));
                i7++;
            }
            return iB;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i7, int i8);
    }

    private static abstract class d implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f6292a;

        d(c cVar) {
            this.f6292a = cVar;
        }

        private boolean d(CharSequence charSequence, int i7, int i8) {
            int iA = this.f6292a.a(charSequence, i7, i8);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return c();
            }
            return false;
        }

        @Override // androidx.core.text.n0
        public boolean a(char[] cArr, int i7, int i8) {
            return b(CharBuffer.wrap(cArr), i7, i8);
        }

        @Override // androidx.core.text.n0
        public boolean b(CharSequence charSequence, int i7, int i8) {
            if (charSequence == null || i7 < 0 || i8 < 0 || charSequence.length() - i8 < i7) {
                throw new IllegalArgumentException();
            }
            return this.f6292a == null ? c() : d(charSequence, i7, i8);
        }

        protected abstract boolean c();
    }

    private static class e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6293b;

        e(c cVar, boolean z7) {
            super(cVar);
            this.f6293b = z7;
        }

        @Override // androidx.core.text.o0.d
        protected boolean c() {
            return this.f6293b;
        }
    }

    private static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final f f6294b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.text.o0.d
        protected boolean c() {
            return p0.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f6291a;
        f6282c = new e(bVar, false);
        f6283d = new e(bVar, true);
        f6284e = new e(a.f6289b, false);
        f6285f = f.f6294b;
    }

    private o0() {
    }

    static int a(int i7) {
        if (i7 != 0) {
            return (i7 == 1 || i7 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i7) {
        if (i7 != 0) {
            if (i7 == 1 || i7 == 2) {
                return 0;
            }
            switch (i7) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
