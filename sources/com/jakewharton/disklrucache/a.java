package com.jakewharton.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final String f32223o = "journal";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final String f32224p = "journal.tmp";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final String f32225q = "journal.bkp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final String f32226r = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final String f32227s = "1";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final long f32228t = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f32230v = "CLEAN";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f32231w = "DIRTY";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f32232x = "REMOVE";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f32233y = "READ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f32235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f32236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f32237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f32238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f32240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f32241g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Writer f32243i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f32245k;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final Pattern f32229u = Pattern.compile("[a-z0-9_-]{1,64}");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final OutputStream f32234z = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f32242h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f32244j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f32246l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f32247m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Callable<Void> f32248n = new CallableC0386a();

    /* JADX INFO: renamed from: com.jakewharton.disklrucache.a$a, reason: collision with other inner class name */
    class CallableC0386a implements Callable<Void> {
        CallableC0386a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f32243i == null) {
                    return null;
                }
                a.this.Q0();
                if (a.this.o0()) {
                    a.this.x0();
                    a.this.f32245k = 0;
                }
                return null;
            }
        }
    }

    static class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i7) throws IOException {
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f32250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f32251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f32252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f32253d;

        /* JADX INFO: renamed from: com.jakewharton.disklrucache.a$c$a, reason: collision with other inner class name */
        private class C0387a extends FilterOutputStream {
            /* synthetic */ C0387a(c cVar, OutputStream outputStream, CallableC0386a callableC0386a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f32252c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f32252c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i7) {
                try {
                    ((FilterOutputStream) this).out.write(i7);
                } catch (IOException unused) {
                    c.this.f32252c = true;
                }
            }

            private C0387a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i7, int i8) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i7, i8);
                } catch (IOException unused) {
                    c.this.f32252c = true;
                }
            }
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0386a callableC0386a) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.E(this, false);
        }

        public void b() {
            if (this.f32253d) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void f() throws IOException {
            if (this.f32252c) {
                a.this.E(this, false);
                a.this.G0(this.f32250a.f32256a);
            } else {
                a.this.E(this, true);
            }
            this.f32253d = true;
        }

        public String g(int i7) throws IOException {
            InputStream inputStreamH = h(i7);
            if (inputStreamH != null) {
                return a.l0(inputStreamH);
            }
            return null;
        }

        public InputStream h(int i7) throws IOException {
            synchronized (a.this) {
                if (this.f32250a.f32259d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f32250a.f32258c) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f32250a.j(i7));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public OutputStream i(int i7) throws IOException {
            FileOutputStream fileOutputStream;
            C0387a c0387a;
            synchronized (a.this) {
                if (this.f32250a.f32259d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f32250a.f32258c) {
                    this.f32251b[i7] = true;
                }
                File fileK = this.f32250a.k(i7);
                try {
                    fileOutputStream = new FileOutputStream(fileK);
                } catch (FileNotFoundException unused) {
                    a.this.f32235a.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileK);
                    } catch (FileNotFoundException unused2) {
                        return a.f32234z;
                    }
                }
                c0387a = new C0387a(this, fileOutputStream, null);
            }
            return c0387a;
        }

        public void j(int i7, String str) throws Throwable {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(i(i7), com.jakewharton.disklrucache.c.f32276b);
                try {
                    outputStreamWriter2.write(str);
                    com.jakewharton.disklrucache.c.a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.jakewharton.disklrucache.c.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private c(d dVar) {
            this.f32250a = dVar;
            this.f32251b = dVar.f32258c ? null : new boolean[a.this.f32241g];
        }
    }

    private final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f32257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f32258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f32259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f32260e;

        /* synthetic */ d(a aVar, String str, CallableC0386a callableC0386a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f32241g) {
                throw m(strArr);
            }
            for (int i7 = 0; i7 < strArr.length; i7++) {
                try {
                    this.f32257b[i7] = Long.parseLong(strArr[i7]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i7) {
            return new File(a.this.f32235a, this.f32256a + com.alibaba.android.arouter.utils.b.f12515h + i7);
        }

        public File k(int i7) {
            return new File(a.this.f32235a, this.f32256a + com.alibaba.android.arouter.utils.b.f12515h + i7 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j7 : this.f32257b) {
                sb.append(' ');
                sb.append(j7);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f32256a = str;
            this.f32257b = new long[a.this.f32241g];
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f32263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InputStream[] f32264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f32265d;

        /* synthetic */ e(a aVar, String str, long j7, InputStream[] inputStreamArr, long[] jArr, CallableC0386a callableC0386a) {
            this(str, j7, inputStreamArr, jArr);
        }

        public c b() throws IOException {
            return a.this.K(this.f32262a, this.f32263b);
        }

        public InputStream c(int i7) {
            return this.f32264c[i7];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f32264c) {
                com.jakewharton.disklrucache.c.a(inputStream);
            }
        }

        public long e(int i7) {
            return this.f32265d[i7];
        }

        public String getString(int i7) throws IOException {
            return a.l0(c(i7));
        }

        private e(String str, long j7, InputStream[] inputStreamArr, long[] jArr) {
            this.f32262a = str;
            this.f32263b = j7;
            this.f32264c = inputStreamArr;
            this.f32265d = jArr;
        }
    }

    private a(File file, int i7, int i8, long j7) {
        this.f32235a = file;
        this.f32239e = i7;
        this.f32236b = new File(file, f32223o);
        this.f32237c = new File(file, f32224p);
        this.f32238d = new File(file, f32225q);
        this.f32241g = i8;
        this.f32240f = j7;
    }

    private void C() {
        if (this.f32243i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void E(c cVar, boolean z7) throws IOException {
        d dVar = cVar.f32250a;
        if (dVar.f32259d != cVar) {
            throw new IllegalStateException();
        }
        if (z7 && !dVar.f32258c) {
            for (int i7 = 0; i7 < this.f32241g; i7++) {
                if (!cVar.f32251b[i7]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i7);
                }
                if (!dVar.k(i7).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i8 = 0; i8 < this.f32241g; i8++) {
            File fileK = dVar.k(i8);
            if (!z7) {
                G(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i8);
                fileK.renameTo(fileJ);
                long j7 = dVar.f32257b[i8];
                long length = fileJ.length();
                dVar.f32257b[i8] = length;
                this.f32242h = (this.f32242h - j7) + length;
            }
        }
        this.f32245k++;
        dVar.f32259d = null;
        if (dVar.f32258c || z7) {
            dVar.f32258c = true;
            this.f32243i.write("CLEAN " + dVar.f32256a + dVar.l() + '\n');
            if (z7) {
                long j8 = this.f32246l;
                this.f32246l = 1 + j8;
                dVar.f32260e = j8;
            }
        } else {
            this.f32244j.remove(dVar.f32256a);
            this.f32243i.write("REMOVE " + dVar.f32256a + '\n');
        }
        this.f32243i.flush();
        if (this.f32242h > this.f32240f || o0()) {
            this.f32247m.submit(this.f32248n);
        }
    }

    private static void G(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void I0(File file, File file2, boolean z7) throws IOException {
        if (z7) {
            G(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c K(String str, long j7) throws IOException {
        C();
        T0(str);
        d dVar = this.f32244j.get(str);
        CallableC0386a callableC0386a = null;
        if (j7 != -1 && (dVar == null || dVar.f32260e != j7)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0386a);
            this.f32244j.put(str, dVar);
        } else if (dVar.f32259d != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0386a);
        dVar.f32259d = cVar;
        this.f32243i.write("DIRTY " + str + '\n');
        this.f32243i.flush();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() throws IOException {
        while (this.f32242h > this.f32240f) {
            G0(this.f32244j.entrySet().iterator().next().getKey());
        }
    }

    private void T0(String str) {
        if (f32229u.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l0(InputStream inputStream) throws IOException {
        return com.jakewharton.disklrucache.c.c(new InputStreamReader(inputStream, com.jakewharton.disklrucache.c.f32276b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o0() {
        int i7 = this.f32245k;
        return i7 >= 2000 && i7 >= this.f32244j.size();
    }

    public static a p0(File file, int i7, int i8, long j7) throws IOException {
        if (j7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i8 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, f32225q);
        if (file2.exists()) {
            File file3 = new File(file, f32223o);
            if (file3.exists()) {
                file2.delete();
            } else {
                I0(file2, file3, false);
            }
        }
        a aVar = new a(file, i7, i8, j7);
        if (aVar.f32236b.exists()) {
            try {
                aVar.s0();
                aVar.r0();
                aVar.f32243i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.f32236b, true), com.jakewharton.disklrucache.c.f32275a));
                return aVar;
            } catch (IOException e8) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e8.getMessage() + ", removing");
                aVar.F();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i7, i8, j7);
        aVar2.x0();
        return aVar2;
    }

    private void r0() throws IOException {
        G(this.f32237c);
        Iterator<d> it = this.f32244j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i7 = 0;
            if (next.f32259d == null) {
                while (i7 < this.f32241g) {
                    this.f32242h += next.f32257b[i7];
                    i7++;
                }
            } else {
                next.f32259d = null;
                while (i7 < this.f32241g) {
                    G(next.j(i7));
                    G(next.k(i7));
                    i7++;
                }
                it.remove();
            }
        }
    }

    private void s0() throws IOException {
        com.jakewharton.disklrucache.b bVar = new com.jakewharton.disklrucache.b(new FileInputStream(this.f32236b), com.jakewharton.disklrucache.c.f32275a);
        try {
            String strQ = bVar.q();
            String strQ2 = bVar.q();
            String strQ3 = bVar.q();
            String strQ4 = bVar.q();
            String strQ5 = bVar.q();
            if (!f32226r.equals(strQ) || !"1".equals(strQ2) || !Integer.toString(this.f32239e).equals(strQ3) || !Integer.toString(this.f32241g).equals(strQ4) || !"".equals(strQ5)) {
                throw new IOException("unexpected journal header: [" + strQ + ", " + strQ2 + ", " + strQ4 + ", " + strQ5 + "]");
            }
            int i7 = 0;
            while (true) {
                try {
                    v0(bVar.q());
                    i7++;
                } catch (EOFException unused) {
                    this.f32245k = i7 - this.f32244j.size();
                    com.jakewharton.disklrucache.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.jakewharton.disklrucache.c.a(bVar);
            throw th;
        }
    }

    private void v0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i7 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i7);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i7);
            if (iIndexOf == 6 && str.startsWith(f32232x)) {
                this.f32244j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i7, iIndexOf2);
        }
        d dVar = this.f32244j.get(strSubstring);
        CallableC0386a callableC0386a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0386a);
            this.f32244j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(f32230v)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f32258c = true;
            dVar.f32259d = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(f32231w)) {
            dVar.f32259d = new c(this, dVar, callableC0386a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(f32233y)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x0() throws IOException {
        Writer writer = this.f32243i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32237c), com.jakewharton.disklrucache.c.f32275a));
        try {
            bufferedWriter.write(f32226r);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f32239e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f32241g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f32244j.values()) {
                if (dVar.f32259d != null) {
                    bufferedWriter.write("DIRTY " + dVar.f32256a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f32256a + dVar.l() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f32236b.exists()) {
                I0(this.f32236b, this.f32238d, true);
            }
            I0(this.f32237c, this.f32236b, false);
            this.f32238d.delete();
            this.f32243i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32236b, true), com.jakewharton.disklrucache.c.f32275a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public void F() throws IOException {
        close();
        com.jakewharton.disklrucache.c.b(this.f32235a);
    }

    public synchronized boolean G0(String str) throws IOException {
        C();
        T0(str);
        d dVar = this.f32244j.get(str);
        if (dVar != null && dVar.f32259d == null) {
            for (int i7 = 0; i7 < this.f32241g; i7++) {
                File fileJ = dVar.j(i7);
                if (fileJ.exists() && !fileJ.delete()) {
                    throw new IOException("failed to delete " + fileJ);
                }
                this.f32242h -= dVar.f32257b[i7];
                dVar.f32257b[i7] = 0;
            }
            this.f32245k++;
            this.f32243i.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f32244j.remove(str);
            if (o0()) {
                this.f32247m.submit(this.f32248n);
            }
            return true;
        }
        return false;
    }

    public c H(String str) throws IOException {
        return K(str, -1L);
    }

    public synchronized void J0(long j7) {
        this.f32240f = j7;
        this.f32247m.submit(this.f32248n);
    }

    public synchronized long L0() {
        return this.f32242h;
    }

    public synchronized e Q(String str) throws IOException {
        InputStream inputStream;
        C();
        T0(str);
        d dVar = this.f32244j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f32258c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f32241g];
        for (int i7 = 0; i7 < this.f32241g; i7++) {
            try {
                inputStreamArr[i7] = new FileInputStream(dVar.j(i7));
            } catch (FileNotFoundException unused) {
                for (int i8 = 0; i8 < this.f32241g && (inputStream = inputStreamArr[i8]) != null; i8++) {
                    com.jakewharton.disklrucache.c.a(inputStream);
                }
                return null;
            }
        }
        this.f32245k++;
        this.f32243i.append((CharSequence) ("READ " + str + '\n'));
        if (o0()) {
            this.f32247m.submit(this.f32248n);
        }
        return new e(this, str, dVar.f32260e, inputStreamArr, dVar.f32257b, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f32243i == null) {
            return;
        }
        for (d dVar : new ArrayList(this.f32244j.values())) {
            if (dVar.f32259d != null) {
                dVar.f32259d.a();
            }
        }
        Q0();
        this.f32243i.close();
        this.f32243i = null;
    }

    public synchronized void flush() throws IOException {
        C();
        Q0();
        this.f32243i.flush();
    }

    public File g0() {
        return this.f32235a;
    }

    public synchronized long h0() {
        return this.f32240f;
    }

    public synchronized boolean isClosed() {
        return this.f32243i == null;
    }
}
