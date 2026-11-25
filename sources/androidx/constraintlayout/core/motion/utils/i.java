package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i {

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f2858d = 999;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f2859a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.constraintlayout.core.motion.a[] f2860b = new androidx.constraintlayout.core.motion.a[101];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2861c;

        public a() {
            b();
        }

        public void a(int i7, androidx.constraintlayout.core.motion.a aVar) {
            if (this.f2860b[i7] != null) {
                e(i7);
            }
            this.f2860b[i7] = aVar;
            int[] iArr = this.f2859a;
            int i8 = this.f2861c;
            this.f2861c = i8 + 1;
            iArr[i8] = i7;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f2859a, f2858d);
            Arrays.fill(this.f2860b, (Object) null);
            this.f2861c = 0;
        }

        public void c() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.f2859a, this.f2861c)));
            System.out.print("K: [");
            int i7 = 0;
            while (i7 < this.f2861c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i7 == 0 ? "" : ", ");
                sb.append(g(i7));
                printStream.print(sb.toString());
                i7++;
            }
            System.out.println("]");
        }

        public int d(int i7) {
            return this.f2859a[i7];
        }

        public void e(int i7) {
            this.f2860b[i7] = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = this.f2861c;
                if (i8 >= i10) {
                    this.f2861c = i10 - 1;
                    return;
                }
                int[] iArr = this.f2859a;
                if (i7 == iArr[i8]) {
                    iArr[i8] = f2858d;
                    i9++;
                }
                if (i8 != i9) {
                    iArr[i8] = iArr[i9];
                }
                i9++;
                i8++;
            }
        }

        public int f() {
            return this.f2861c;
        }

        public androidx.constraintlayout.core.motion.a g(int i7) {
            return this.f2860b[this.f2859a[i7]];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f2862d = 999;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f2863a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.constraintlayout.core.motion.b[] f2864b = new androidx.constraintlayout.core.motion.b[101];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2865c;

        public b() {
            b();
        }

        public void a(int i7, androidx.constraintlayout.core.motion.b bVar) {
            if (this.f2864b[i7] != null) {
                e(i7);
            }
            this.f2864b[i7] = bVar;
            int[] iArr = this.f2863a;
            int i8 = this.f2865c;
            this.f2865c = i8 + 1;
            iArr[i8] = i7;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f2863a, f2862d);
            Arrays.fill(this.f2864b, (Object) null);
            this.f2865c = 0;
        }

        public void c() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.f2863a, this.f2865c)));
            System.out.print("K: [");
            int i7 = 0;
            while (i7 < this.f2865c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i7 == 0 ? "" : ", ");
                sb.append(g(i7));
                printStream.print(sb.toString());
                i7++;
            }
            System.out.println("]");
        }

        public int d(int i7) {
            return this.f2863a[i7];
        }

        public void e(int i7) {
            this.f2864b[i7] = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = this.f2865c;
                if (i8 >= i10) {
                    this.f2865c = i10 - 1;
                    return;
                }
                int[] iArr = this.f2863a;
                if (i7 == iArr[i8]) {
                    iArr[i8] = f2862d;
                    i9++;
                }
                if (i8 != i9) {
                    iArr[i8] = iArr[i9];
                }
                i9++;
                i8++;
            }
        }

        public int f() {
            return this.f2865c;
        }

        public androidx.constraintlayout.core.motion.b g(int i7) {
            return this.f2864b[this.f2863a[i7]];
        }
    }

    static class c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f2866d = 999;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f2867a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float[][] f2868b = new float[101][];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2869c;

        public c() {
            b();
        }

        public void a(int i7, float[] fArr) {
            if (this.f2868b[i7] != null) {
                e(i7);
            }
            this.f2868b[i7] = fArr;
            int[] iArr = this.f2867a;
            int i8 = this.f2869c;
            this.f2869c = i8 + 1;
            iArr[i8] = i7;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f2867a, f2866d);
            Arrays.fill(this.f2868b, (Object) null);
            this.f2869c = 0;
        }

        public void c() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.f2867a, this.f2869c)));
            System.out.print("K: [");
            int i7 = 0;
            while (i7 < this.f2869c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i7 == 0 ? "" : ", ");
                sb.append(Arrays.toString(g(i7)));
                printStream.print(sb.toString());
                i7++;
            }
            System.out.println("]");
        }

        public int d(int i7) {
            return this.f2867a[i7];
        }

        public void e(int i7) {
            this.f2868b[i7] = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = this.f2869c;
                if (i8 >= i10) {
                    this.f2869c = i10 - 1;
                    return;
                }
                int[] iArr = this.f2867a;
                if (i7 == iArr[i8]) {
                    iArr[i8] = f2866d;
                    i9++;
                }
                if (i8 != i9) {
                    iArr[i8] = iArr[i9];
                }
                i9++;
                i8++;
            }
        }

        public int f() {
            return this.f2869c;
        }

        public float[] g(int i7) {
            return this.f2868b[this.f2867a[i7]];
        }
    }
}
