package com.haier.library.okhttp;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f27683a = new a();

    static class a implements n {
        a() {
        }

        @Override // com.haier.library.okhttp.n
        public f a(@Nullable h hVar, com.haier.library.okhttp.a aVar) {
            return null;
        }
    }

    public abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f27684a;

        public static void h() {
            new l0();
        }

        public abstract int a(com.haier.library.okhttp.a.C0352a c0352a);

        public abstract com.haier.library.okhttp.b.d.c b(w wVar, com.haier.library.okhttp.c cVar, com.haier.library.okhttp.b.d.g gVar, h hVar);

        public abstract com.haier.library.okhttp.b.d.d c(w wVar);

        public abstract com.haier.library.okhttp.b.d.g d(q qVar);

        public abstract q e(l0 l0Var, f fVar);

        @Nullable
        public abstract IOException f(q qVar, @Nullable IOException iOException);

        public abstract Socket g(w wVar, com.haier.library.okhttp.c cVar, com.haier.library.okhttp.b.d.g gVar);

        public abstract void i(x xVar, SSLSocket sSLSocket, boolean z7);

        public abstract void j(g0.a aVar, String str);

        public abstract void k(g0.a aVar, String str, String str2);

        public abstract void l(l0.b bVar, com.haier.library.okhttp.b.b.f fVar);

        public abstract boolean m(com.haier.library.okhttp.c cVar, com.haier.library.okhttp.c cVar2);

        public abstract boolean n(w wVar, com.haier.library.okhttp.b.d.c cVar);

        public abstract boolean o(IllegalArgumentException illegalArgumentException);

        public abstract void p(w wVar, com.haier.library.okhttp.b.d.c cVar);
    }

    public abstract class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final String f27685a;

        public c(String str, Object... objArr) {
            this.f27685a = d.j(str, objArr);
        }

        protected abstract void k();

        @Override // java.lang.Runnable
        public final void run() {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName(this.f27685a);
            try {
                k();
            } finally {
                Thread.currentThread().setName(name);
            }
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f27686a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final com.haier.library.okhttp.b f27688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f27689d;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final Method f27703r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final Pattern f27704s;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f27687b = new String[0];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.haier.library.a.j f27690e = com.haier.library.a.j.H("efbbbf");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final com.haier.library.a.j f27691f = com.haier.library.a.j.H("feff");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final com.haier.library.a.j f27692g = com.haier.library.a.j.H("fffe");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final com.haier.library.a.j f27693h = com.haier.library.a.j.H("0000ffff");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final com.haier.library.a.j f27694i = com.haier.library.a.j.H("ffff0000");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Charset f27695j = Charset.forName("UTF-8");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Charset f27696k = Charset.forName(CharEncoding.ISO_8859_1);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final Charset f27697l = Charset.forName(CharEncoding.UTF_16BE);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final Charset f27698m = Charset.forName(CharEncoding.UTF_16LE);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final Charset f27699n = Charset.forName("UTF-32BE");

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final Charset f27700o = Charset.forName("UTF-32LE");

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final TimeZone f27701p = TimeZone.getTimeZone("GMT");

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Comparator<String> f27702q = new a();

        static class a implements Comparator<String> {
            a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        }

        static class b implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f27705a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f27706b;

            b(String str, boolean z7) {
                this.f27705a = str;
                this.f27706b = z7;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, this.f27705a);
                thread.setDaemon(this.f27706b);
                return thread;
            }
        }

        final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final FileChannel f27707a;

            c(FileChannel fileChannel) {
                this.f27707a = fileChannel;
            }

            public void a(long j7, com.haier.library.a.g gVar, long j8) throws IOException {
                if (j8 < 0 || j8 > gVar.Y0()) {
                    throw new IndexOutOfBoundsException();
                }
                while (j8 > 0) {
                    long jTransferFrom = this.f27707a.transferFrom(gVar, j7, j8);
                    j7 += jTransferFrom;
                    j8 -= jTransferFrom;
                }
            }

            public void b(long j7, com.haier.library.a.g gVar, long j8) throws IOException {
                if (j8 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                while (j8 > 0) {
                    long jTransferTo = this.f27707a.transferTo(j7, j8, gVar);
                    j7 += jTransferTo;
                    j8 -= jTransferTo;
                }
            }
        }

        /* JADX INFO: renamed from: com.haier.library.okhttp.n$d$d, reason: collision with other inner class name */
        final class C0362d {

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private static final int f27708k = 1;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private static final int f27709l = 2;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            static final com.haier.library.a.j f27710m = com.haier.library.a.j.i("OkHttp cache v1\n");

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            static final com.haier.library.a.j f27711n = com.haier.library.a.j.i("OkHttp DIRTY :(\n");

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private static final long f27712o = 32;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            RandomAccessFile f27713a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Thread f27714b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            com.haier.library.a.c0 f27715c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            long f27717e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            boolean f27718f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final com.haier.library.a.j f27719g;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final long f27721i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f27722j;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final com.haier.library.a.g f27716d = new com.haier.library.a.g();

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final com.haier.library.a.g f27720h = new com.haier.library.a.g();

            /* JADX INFO: renamed from: com.haier.library.okhttp.n$d$d$a */
            class a implements com.haier.library.a.c0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final com.haier.library.a.d0 f27723a = new com.haier.library.a.d0();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private c f27724b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private long f27725c;

                a() {
                    this.f27724b = new c(C0362d.this.f27713a.getChannel());
                }

                @Override // com.haier.library.a.c0
                public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
                    long j8;
                    char c8;
                    C0362d c0362d;
                    if (this.f27724b == null) {
                        throw new IllegalStateException("closed");
                    }
                    synchronized (C0362d.this) {
                        while (true) {
                            long j9 = this.f27725c;
                            C0362d c0362d2 = C0362d.this;
                            j8 = c0362d2.f27717e;
                            if (j9 != j8) {
                                long jY0 = j8 - c0362d2.f27720h.Y0();
                                long j10 = this.f27725c;
                                if (j10 < jY0) {
                                    c8 = 2;
                                    break;
                                }
                                long jMin = Math.min(j7, j8 - j10);
                                C0362d.this.f27720h.h0(gVar, this.f27725c - jY0, jMin);
                                this.f27725c += jMin;
                                return jMin;
                            }
                            if (!c0362d2.f27718f) {
                                if (c0362d2.f27714b == null) {
                                    c0362d2.f27714b = Thread.currentThread();
                                    c8 = 1;
                                    break;
                                }
                                this.f27723a.c(c0362d2);
                            } else {
                                return -1L;
                            }
                        }
                        if (c8 == 2) {
                            long jMin2 = Math.min(j7, j8 - this.f27725c);
                            this.f27724b.b(this.f27725c + 32, gVar, jMin2);
                            this.f27725c += jMin2;
                            return jMin2;
                        }
                        try {
                            C0362d c0362d3 = C0362d.this;
                            long jP0 = c0362d3.f27715c.P0(c0362d3.f27716d, c0362d3.f27721i);
                            if (jP0 == -1) {
                                C0362d.this.c(j8);
                                synchronized (C0362d.this) {
                                    C0362d c0362d4 = C0362d.this;
                                    c0362d4.f27714b = null;
                                    c0362d4.notifyAll();
                                }
                                return -1L;
                            }
                            long jMin3 = Math.min(jP0, j7);
                            C0362d.this.f27716d.h0(gVar, 0L, jMin3);
                            this.f27725c += jMin3;
                            this.f27724b.a(j8 + 32, C0362d.this.f27716d.clone(), jP0);
                            synchronized (C0362d.this) {
                                C0362d c0362d5 = C0362d.this;
                                c0362d5.f27720h.I1(c0362d5.f27716d, jP0);
                                long jY1 = C0362d.this.f27720h.Y0();
                                C0362d c0362d6 = C0362d.this;
                                if (jY1 > c0362d6.f27721i) {
                                    com.haier.library.a.g gVar2 = c0362d6.f27720h;
                                    gVar2.j0(gVar2.Y0() - C0362d.this.f27721i);
                                }
                                c0362d = C0362d.this;
                                c0362d.f27717e += jP0;
                            }
                            synchronized (c0362d) {
                                C0362d c0362d7 = C0362d.this;
                                c0362d7.f27714b = null;
                                c0362d7.notifyAll();
                            }
                            return jMin3;
                        } catch (Throwable th) {
                            synchronized (C0362d.this) {
                                C0362d c0362d8 = C0362d.this;
                                c0362d8.f27714b = null;
                                c0362d8.notifyAll();
                                throw th;
                            }
                        }
                    }
                }

                @Override // com.haier.library.a.c0
                public com.haier.library.a.d0 a() {
                    return this.f27723a;
                }

                @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (this.f27724b == null) {
                        return;
                    }
                    RandomAccessFile randomAccessFile = null;
                    this.f27724b = null;
                    synchronized (C0362d.this) {
                        C0362d c0362d = C0362d.this;
                        int i7 = c0362d.f27722j - 1;
                        c0362d.f27722j = i7;
                        if (i7 == 0) {
                            RandomAccessFile randomAccessFile2 = c0362d.f27713a;
                            c0362d.f27713a = null;
                            randomAccessFile = randomAccessFile2;
                        }
                    }
                    if (randomAccessFile != null) {
                        d.s(randomAccessFile);
                    }
                }
            }

            private C0362d(RandomAccessFile randomAccessFile, com.haier.library.a.c0 c0Var, long j7, com.haier.library.a.j jVar, long j8) {
                this.f27713a = randomAccessFile;
                this.f27715c = c0Var;
                this.f27718f = c0Var == null;
                this.f27717e = j7;
                this.f27719g = jVar;
                this.f27721i = j8;
            }

            public static C0362d a(File file) throws IOException {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                c cVar = new c(randomAccessFile.getChannel());
                com.haier.library.a.g gVar = new com.haier.library.a.g();
                cVar.b(0L, gVar, 32L);
                com.haier.library.a.j jVar = f27710m;
                if (!gVar.t1(jVar.Z()).equals(jVar)) {
                    throw new IOException("unreadable cache file");
                }
                long jM = gVar.m();
                long jM2 = gVar.m();
                com.haier.library.a.g gVar2 = new com.haier.library.a.g();
                cVar.b(jM + 32, gVar2, jM2);
                return new C0362d(randomAccessFile, null, jM, gVar2.s(), 0L);
            }

            public static C0362d b(File file, com.haier.library.a.c0 c0Var, com.haier.library.a.j jVar, long j7) throws IOException {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                C0362d c0362d = new C0362d(randomAccessFile, c0Var, 0L, jVar, j7);
                randomAccessFile.setLength(0L);
                c0362d.d(f27711n, -1L, -1L);
                return c0362d;
            }

            private void d(com.haier.library.a.j jVar, long j7, long j8) throws IOException {
                com.haier.library.a.g gVar = new com.haier.library.a.g();
                gVar.B(jVar);
                gVar.d0(j7);
                gVar.d0(j8);
                if (gVar.Y0() != 32) {
                    throw new IllegalArgumentException();
                }
                new c(this.f27713a.getChannel()).a(0L, gVar, 32L);
            }

            private void g(long j7) throws IOException {
                com.haier.library.a.g gVar = new com.haier.library.a.g();
                gVar.B(this.f27719g);
                new c(this.f27713a.getChannel()).a(32 + j7, gVar, this.f27719g.Z());
            }

            void c(long j7) throws IOException {
                g(j7);
                this.f27713a.getChannel().force(false);
                d(f27710m, j7, this.f27719g.Z());
                this.f27713a.getChannel().force(false);
                synchronized (this) {
                    this.f27718f = true;
                }
                d.s(this.f27715c);
                this.f27715c = null;
            }

            boolean e() {
                return this.f27713a == null;
            }

            public com.haier.library.a.j f() {
                return this.f27719g;
            }

            public com.haier.library.a.c0 h() {
                synchronized (this) {
                    if (this.f27713a == null) {
                        return null;
                    }
                    this.f27722j++;
                    return new a();
                }
            }
        }

        static {
            byte[] bArr = new byte[0];
            f27686a = bArr;
            Method declaredMethod = null;
            f27688c = com.haier.library.okhttp.b.H(null, bArr);
            f27689d = g.d(null, bArr);
            try {
                declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
            } catch (Exception unused) {
            }
            f27703r = declaredMethod;
            f27704s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        }

        private d() {
        }

        public static String[] A(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public static String[] B(String[] strArr, String str) {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = str;
            return strArr2;
        }

        public static int C(String str) {
            int length = str.length();
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = str.charAt(i7);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    return i7;
                }
            }
            return -1;
        }

        public static int D(String str, int i7, int i8) {
            for (int i9 = i8 - 1; i9 >= i7; i9--) {
                char cCharAt = str.charAt(i9);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i9 + 1;
                }
            }
            return i7;
        }

        public static g0 E(List<com.haier.library.okhttp.b.g.c> list) {
            g0.a aVar = new g0.a();
            for (com.haier.library.okhttp.b.g.c cVar : list) {
                b.f27684a.k(aVar, cVar.f27152a.o(), cVar.f27153b.o());
            }
            return aVar.e();
        }

        public static boolean F(com.haier.library.a.c0 c0Var, int i7, TimeUnit timeUnit) throws IOException {
            long jNanoTime = System.nanoTime();
            long jG = c0Var.a().e() ? c0Var.a().g() - jNanoTime : Long.MAX_VALUE;
            c0Var.a().a(Math.min(jG, timeUnit.toNanos(i7)) + jNanoTime);
            try {
                com.haier.library.a.g gVar = new com.haier.library.a.g();
                while (c0Var.P0(gVar, PlaybackStateCompat.f450z) != -1) {
                    gVar.h2();
                }
                if (jG == Long.MAX_VALUE) {
                    c0Var.a().i();
                    return true;
                }
                c0Var.a().a(jNanoTime + jG);
                return true;
            } catch (InterruptedIOException unused) {
                if (jG == Long.MAX_VALUE) {
                    c0Var.a().i();
                    return false;
                }
                c0Var.a().a(jNanoTime + jG);
                return false;
            } catch (Throwable th) {
                if (jG == Long.MAX_VALUE) {
                    c0Var.a().i();
                } else {
                    c0Var.a().a(jNanoTime + jG);
                }
                throw th;
            }
        }

        public static boolean G(Comparator<String> comparator, String[] strArr, String[] strArr2) {
            if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static String H(String str, int i7, int i8) {
            int iB = b(str, i7, i8);
            return str.substring(iB, D(str, iB, i8));
        }

        public static boolean I(String str) {
            return f27704s.matcher(str).matches();
        }

        /* JADX WARN: Code duplicated, block: B:31:0x004f  */
        /* JADX WARN: Code duplicated, block: B:34:0x005a A[LOOP:1: B:30:0x004d->B:34:0x005a, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:59:0x0060 A[EDGE_INSN: B:59:0x0060->B:35:0x0060 BREAK  A[LOOP:1: B:30:0x004d->B:34:0x005a], SYNTHETIC] */
        @Nullable
        private static InetAddress J(String str, int i7, int i8) {
            int i9;
            int i10;
            int iA;
            byte[] bArr = new byte[16];
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            while (i7 < i8) {
                if (i11 == 16) {
                    return null;
                }
                int i14 = i7 + 2;
                if (i14 <= i8 && str.regionMatches(i7, "::", 0, 2)) {
                    if (i12 != -1) {
                        return null;
                    }
                    i11 += 2;
                    i12 = i11;
                    if (i14 == i8) {
                        break;
                    }
                    i13 = i14;
                    i9 = 0;
                    i7 = i13;
                    while (i7 < i8) {
                        iA = a(str.charAt(i7));
                        if (iA == -1) {
                            break;
                            break;
                        }
                        i9 = (i9 << 4) + iA;
                        i7++;
                    }
                    i10 = i7 - i13;
                    if (i10 != 0) {
                    }
                    return null;
                }
                if (i11 != 0) {
                    if (!str.regionMatches(i7, ":", 0, 1)) {
                        if (!str.regionMatches(i7, com.alibaba.android.arouter.utils.b.f12515h, 0, 1) || !z(str, i13, i8, bArr, i11 - 2)) {
                            return null;
                        }
                        i11 += 2;
                        break;
                    }
                    i7++;
                }
                i13 = i7;
                i9 = 0;
                i7 = i13;
                while (i7 < i8) {
                    iA = a(str.charAt(i7));
                    if (iA == -1) {
                        break;
                    }
                    i9 = (i9 << 4) + iA;
                    i7++;
                }
                i10 = i7 - i13;
                if (i10 != 0 || i10 > 4) {
                    return null;
                }
                int i15 = i11 + 1;
                bArr[i11] = (byte) ((i9 >>> 8) & 255);
                i11 = i15 + 1;
                bArr[i15] = (byte) (i9 & 255);
            }
            if (i11 != 16) {
                if (i12 == -1) {
                    return null;
                }
                int i16 = i11 - i12;
                System.arraycopy(bArr, i12, bArr, 16 - i16, i16);
                Arrays.fill(bArr, i12, (16 - i11) + i12, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        private static boolean K(String str) {
            for (int i7 = 0; i7 < str.length(); i7++) {
                char cCharAt = str.charAt(i7);
                if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        public static int a(char c8) {
            if (c8 >= '0' && c8 <= '9') {
                return c8 - '0';
            }
            char c9 = 'a';
            if (c8 < 'a' || c8 > 'f') {
                c9 = 'A';
                if (c8 < 'A' || c8 > 'F') {
                    return -1;
                }
            }
            return (c8 - c9) + 10;
        }

        public static int b(String str, int i7, int i8) {
            while (i7 < i8) {
                char cCharAt = str.charAt(i7);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i7;
                }
                i7++;
            }
            return i8;
        }

        public static int c(String str, int i7, int i8, char c8) {
            while (i7 < i8) {
                if (str.charAt(i7) == c8) {
                    return i7;
                }
                i7++;
            }
            return i8;
        }

        public static int d(String str, int i7, int i8, String str2) {
            while (i7 < i8) {
                if (str2.indexOf(str.charAt(i7)) != -1) {
                    return i7;
                }
                i7++;
            }
            return i8;
        }

        public static int e(String str, long j7, TimeUnit timeUnit) {
            if (j7 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j7);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j7 <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public static int f(Comparator<String> comparator, String[] strArr, String str) {
            int length = strArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (comparator.compare(strArr[i7], str) == 0) {
                    return i7;
                }
            }
            return -1;
        }

        public static AssertionError g(String str, Exception exc) {
            AssertionError assertionError = new AssertionError(str);
            try {
                assertionError.initCause(exc);
            } catch (IllegalStateException unused) {
            }
            return assertionError;
        }

        public static String h(h0 h0Var, boolean z7) {
            String strF;
            if (h0Var.F().contains(":")) {
                strF = "[" + h0Var.F() + "]";
            } else {
                strF = h0Var.F();
            }
            if (!z7 && h0Var.G() == h0.a(h0Var.t())) {
                return strF;
            }
            return strF + ":" + h0Var.G();
        }

        public static String i(String str) {
            if (!str.contains(":")) {
                try {
                    String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                    if (lowerCase.isEmpty() || K(lowerCase)) {
                        return null;
                    }
                    return lowerCase;
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            InetAddress inetAddressJ = (str.startsWith("[") && str.endsWith("]")) ? J(str, 1, str.length() - 1) : J(str, 0, str.length());
            if (inetAddressJ == null) {
                return null;
            }
            byte[] address = inetAddressJ.getAddress();
            if (address.length == 16) {
                return k(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }

        public static String j(String str, Object... objArr) {
            return String.format(Locale.US, str, objArr);
        }

        private static String k(byte[] bArr) {
            int i7 = -1;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i9 < bArr.length) {
                int i11 = i9;
                while (i11 < 16 && bArr[i11] == 0 && bArr[i11 + 1] == 0) {
                    i11 += 2;
                }
                int i12 = i11 - i9;
                if (i12 > i10 && i12 >= 4) {
                    i7 = i9;
                    i10 = i12;
                }
                i9 = i11 + 2;
            }
            com.haier.library.a.g gVar = new com.haier.library.a.g();
            while (i8 < bArr.length) {
                if (i8 == i7) {
                    gVar.y1(58);
                    i8 += i10;
                    if (i8 == 16) {
                        gVar.y1(58);
                    }
                } else {
                    if (i8 > 0) {
                        gVar.y1(58);
                    }
                    gVar.P1(((bArr[i8] & 255) << 8) | (bArr[i8 + 1] & 255));
                    i8 += 2;
                }
            }
            return gVar.T();
        }

        public static Charset l(com.haier.library.a.i iVar, Charset charset) throws IOException {
            com.haier.library.a.j jVar = f27690e;
            if (iVar.A(0L, jVar)) {
                iVar.j0(jVar.Z());
                return f27695j;
            }
            com.haier.library.a.j jVar2 = f27691f;
            if (iVar.A(0L, jVar2)) {
                iVar.j0(jVar2.Z());
                return f27697l;
            }
            com.haier.library.a.j jVar3 = f27692g;
            if (iVar.A(0L, jVar3)) {
                iVar.j0(jVar3.Z());
                return f27698m;
            }
            com.haier.library.a.j jVar4 = f27693h;
            if (iVar.A(0L, jVar4)) {
                iVar.j0(jVar4.Z());
                return f27699n;
            }
            com.haier.library.a.j jVar5 = f27694i;
            if (!iVar.A(0L, jVar5)) {
                return charset;
            }
            iVar.j0(jVar5.Z());
            return f27700o;
        }

        public static <T> List<T> m(List<T> list) {
            return Collections.unmodifiableList(new ArrayList(list));
        }

        public static <T> List<T> n(T... tArr) {
            return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
        }

        public static <K, V> Map<K, V> o(Map<K, V> map) {
            return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
        }

        public static ThreadFactory p(String str, boolean z7) {
            return new b(str, z7);
        }

        public static X509TrustManager q() {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        return (X509TrustManager) trustManager;
                    }
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e8) {
                throw g("No System TLS", e8);
            }
        }

        public static void r(long j7, long j8, long j9) {
            if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        public static void s(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (RuntimeException e8) {
                    throw e8;
                } catch (Exception unused) {
                }
            }
        }

        public static void t(Throwable th, Throwable th2) {
            Method method = f27703r;
            if (method != null) {
                try {
                    method.invoke(th, th2);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
        }

        public static void u(ServerSocket serverSocket) {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (RuntimeException e8) {
                    throw e8;
                } catch (Exception unused) {
                }
            }
        }

        public static void v(Socket socket) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (AssertionError e8) {
                    if (!x(e8)) {
                        throw e8;
                    }
                } catch (RuntimeException e9) {
                    throw e9;
                } catch (Exception unused) {
                }
            }
        }

        public static boolean w(com.haier.library.a.c0 c0Var, int i7, TimeUnit timeUnit) {
            try {
                return F(c0Var, i7, timeUnit);
            } catch (IOException unused) {
                return false;
            }
        }

        public static boolean x(AssertionError assertionError) {
            return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
        }

        public static boolean y(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }

        private static boolean z(String str, int i7, int i8, byte[] bArr, int i9) {
            int i10 = i9;
            while (i7 < i8) {
                if (i10 == bArr.length) {
                    return false;
                }
                if (i10 != i9) {
                    if (str.charAt(i7) != '.') {
                        return false;
                    }
                    i7++;
                }
                int i11 = i7;
                int i12 = 0;
                while (i11 < i8) {
                    char cCharAt = str.charAt(i11);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i12 == 0 && i7 != i11) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                        return false;
                    }
                    i11++;
                }
                if (i11 - i7 == 0) {
                    return false;
                }
                bArr[i10] = (byte) i12;
                i10++;
                i7 = i11;
            }
            return i10 == i9 + 4;
        }
    }

    @Nullable
    f a(@Nullable h hVar, com.haier.library.okhttp.a aVar) throws IOException;
}
