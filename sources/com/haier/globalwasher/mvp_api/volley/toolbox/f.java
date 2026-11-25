package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.os.SystemClock;
import com.haier.globalwasher.mvp_api.volley.v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.haier.globalwasher.mvp_api.volley.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24972e = 5242880;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f24973f = 0.9f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f24974g = 538247942;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f24975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f24976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f24977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24978d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f24983e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f24984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f24985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Map<String, String> f24986h;

        private a() {
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (f.j(inputStream) != f.f24974g) {
                throw new IOException();
            }
            aVar.f24980b = f.l(inputStream);
            String strL = f.l(inputStream);
            aVar.f24981c = strL;
            if (strL.equals("")) {
                aVar.f24981c = null;
            }
            aVar.f24982d = f.k(inputStream);
            aVar.f24983e = f.k(inputStream);
            aVar.f24984f = f.k(inputStream);
            aVar.f24985g = f.k(inputStream);
            aVar.f24986h = f.m(inputStream);
            return aVar;
        }

        public com.haier.globalwasher.mvp_api.volley.b.a b(byte[] bArr) {
            com.haier.globalwasher.mvp_api.volley.b.a aVar = new com.haier.globalwasher.mvp_api.volley.b.a();
            aVar.f24806a = bArr;
            aVar.f24807b = this.f24981c;
            aVar.f24808c = this.f24982d;
            aVar.f24809d = this.f24983e;
            aVar.f24810e = this.f24984f;
            aVar.f24811f = this.f24985g;
            aVar.f24812g = this.f24986h;
            return aVar;
        }

        public boolean c(OutputStream outputStream) {
            try {
                f.p(outputStream, f.f24974g);
                f.r(outputStream, this.f24980b);
                String str = this.f24981c;
                if (str == null) {
                    str = "";
                }
                f.r(outputStream, str);
                f.q(outputStream, this.f24982d);
                f.q(outputStream, this.f24983e);
                f.q(outputStream, this.f24984f);
                f.q(outputStream, this.f24985g);
                f.s(this.f24986h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e8) {
                v.b("%s", e8.toString());
                return false;
            }
        }

        public a(String str, com.haier.globalwasher.mvp_api.volley.b.a aVar) {
            this.f24980b = str;
            this.f24979a = aVar.f24806a.length;
            this.f24981c = aVar.f24807b;
            this.f24982d = aVar.f24808c;
            this.f24983e = aVar.f24809d;
            this.f24984f = aVar.f24810e;
            this.f24985g = aVar.f24811f;
            this.f24986h = aVar.f24812g;
        }
    }

    private static class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24987a;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i7 = super.read();
            if (i7 != -1) {
                this.f24987a++;
            }
            return i7;
        }

        private b(InputStream inputStream) {
            super(inputStream);
            this.f24987a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = super.read(bArr, i7, i8);
            if (i9 != -1) {
                this.f24987a += i9;
            }
            return i9;
        }
    }

    public f(File file, int i7) {
        this.f24975a = new LinkedHashMap(16, 0.75f, true);
        this.f24976b = 0L;
        this.f24977c = file;
        this.f24978d = i7;
    }

    private String f(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void g(int i7) {
        long j7 = i7;
        if (this.f24976b + j7 < this.f24978d) {
            return;
        }
        if (v.f25046b) {
            v.f("Pruning old cache entries.", new Object[0]);
        }
        long j8 = this.f24976b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f24975a.entrySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (e(value.f24980b).delete()) {
                this.f24976b -= value.f24979a;
            } else {
                String str = value.f24980b;
                v.b("Could not delete cache entry for key=%s, filename=%s", str, f(str));
            }
            it.remove();
            i8++;
            if (this.f24976b + j7 < this.f24978d * f24973f) {
                break;
            } else {
                j7 = j7;
            }
        }
        if (v.f25046b) {
            v.f("pruned %d files, %d bytes, %d ms", Integer.valueOf(i8), Long.valueOf(this.f24976b - j8), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    private void h(String str, a aVar) {
        if (this.f24975a.containsKey(str)) {
            this.f24976b += aVar.f24979a - this.f24975a.get(str).f24979a;
        } else {
            this.f24976b += aVar.f24979a;
        }
        this.f24975a.put(str, aVar);
    }

    private static int i(InputStream inputStream) throws IOException {
        int i7 = inputStream.read();
        if (i7 != -1) {
            return i7;
        }
        throw new EOFException();
    }

    static int j(InputStream inputStream) throws IOException {
        return (i(inputStream) << 24) | (i(inputStream) << 0) | 0 | (i(inputStream) << 8) | (i(inputStream) << 16);
    }

    static long k(InputStream inputStream) throws IOException {
        return ((((long) i(inputStream)) & 255) << 0) | 0 | ((((long) i(inputStream)) & 255) << 8) | ((((long) i(inputStream)) & 255) << 16) | ((((long) i(inputStream)) & 255) << 24) | ((((long) i(inputStream)) & 255) << 32) | ((((long) i(inputStream)) & 255) << 40) | ((((long) i(inputStream)) & 255) << 48) | ((255 & ((long) i(inputStream))) << 56);
    }

    static String l(InputStream inputStream) throws IOException {
        return new String(o(inputStream, (int) k(inputStream)), "UTF-8");
    }

    static Map<String, String> m(InputStream inputStream) throws IOException {
        int iJ = j(inputStream);
        Map<String, String> mapEmptyMap = iJ == 0 ? Collections.emptyMap() : new HashMap<>(iJ);
        for (int i7 = 0; i7 < iJ; i7++) {
            mapEmptyMap.put(l(inputStream).intern(), l(inputStream).intern());
        }
        return mapEmptyMap;
    }

    private void n(String str) {
        a aVar = this.f24975a.get(str);
        if (aVar != null) {
            this.f24976b -= aVar.f24979a;
            this.f24975a.remove(str);
        }
    }

    private static byte[] o(InputStream inputStream, int i7) throws IOException {
        byte[] bArr = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            int i9 = inputStream.read(bArr, i8, i7 - i8);
            if (i9 == -1) {
                break;
            }
            i8 += i9;
        }
        if (i8 == i7) {
            return bArr;
        }
        throw new IOException("Expected " + i7 + " bytes, read " + i8 + " bytes");
    }

    static void p(OutputStream outputStream, int i7) throws IOException {
        outputStream.write((i7 >> 0) & 255);
        outputStream.write((i7 >> 8) & 255);
        outputStream.write((i7 >> 16) & 255);
        outputStream.write((i7 >> 24) & 255);
    }

    static void q(OutputStream outputStream, long j7) throws IOException {
        outputStream.write((byte) (j7 >>> 0));
        outputStream.write((byte) (j7 >>> 8));
        outputStream.write((byte) (j7 >>> 16));
        outputStream.write((byte) (j7 >>> 24));
        outputStream.write((byte) (j7 >>> 32));
        outputStream.write((byte) (j7 >>> 40));
        outputStream.write((byte) (j7 >>> 48));
        outputStream.write((byte) (j7 >>> 56));
    }

    static void r(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        q(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static void s(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            p(outputStream, 0);
            return;
        }
        p(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            r(outputStream, entry.getKey());
            r(outputStream, entry.getValue());
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.b
    public synchronized void a() {
        if (!this.f24977c.exists()) {
            if (!this.f24977c.mkdirs()) {
                v.c("Unable to create cache dir %s", this.f24977c.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.f24977c.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        a aVarA = a.a(bufferedInputStream2);
                        aVarA.f24979a = file.length();
                        h(aVarA.f24980b, aVarA);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        bufferedInputStream = bufferedInputStream2;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.b
    public synchronized void b(String str, com.haier.globalwasher.mvp_api.volley.b.a aVar) {
        g(aVar.f24806a.length);
        File fileE = e(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileE));
            a aVar2 = new a(str, aVar);
            if (!aVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                v.b("Failed to write header for %s", fileE.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.f24806a);
            bufferedOutputStream.close();
            h(str, aVar2);
        } catch (IOException unused) {
            if (fileE.delete()) {
                return;
            }
            v.b("Could not clean up file %s", fileE.getAbsolutePath());
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.haier.globalwasher.mvp_api.volley.b
    public synchronized com.haier.globalwasher.mvp_api.volley.b.a c(String str) {
        b bVar;
        a aVar = this.f24975a.get(str);
        InputStream inputStream = null;
        Object[] objArr = 0;
        if (aVar == null) {
            return null;
        }
        File fileE = e(str);
        try {
            try {
                bVar = new b(new BufferedInputStream(new FileInputStream(fileE)));
                try {
                    a.a(bVar);
                    com.haier.globalwasher.mvp_api.volley.b.a aVarB = aVar.b(o(bVar, (int) (fileE.length() - ((long) bVar.f24987a))));
                    try {
                        bVar.close();
                        return aVarB;
                    } catch (IOException unused) {
                        return null;
                    }
                } catch (IOException e8) {
                    e = e8;
                    v.b("%s: %s", fileE.getAbsolutePath(), e.toString());
                    remove(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                    return null;
                } catch (NegativeArraySizeException e9) {
                    e = e9;
                    v.b("%s: %s", fileE.getAbsolutePath(), e.toString());
                    remove(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException unused3) {
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                        return null;
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            bVar = null;
        } catch (NegativeArraySizeException e11) {
            e = e11;
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.b
    public synchronized void clear() {
        File[] fileArrListFiles = this.f24977c.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        this.f24975a.clear();
        this.f24976b = 0L;
        v.b("Cache cleared.", new Object[0]);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.b
    public synchronized void d(String str, boolean z7) {
        com.haier.globalwasher.mvp_api.volley.b.a aVarC = c(str);
        if (aVarC != null) {
            aVarC.f24811f = 0L;
            if (z7) {
                aVarC.f24810e = 0L;
            }
            b(str, aVarC);
        }
    }

    public File e(String str) {
        return new File(this.f24977c, f(str));
    }

    @Override // com.haier.globalwasher.mvp_api.volley.b
    public synchronized void remove(String str) {
        boolean zDelete = e(str).delete();
        n(str);
        if (!zDelete) {
            v.b("Could not delete cache entry for key=%s, filename=%s", str, f(str));
        }
    }

    public f(File file) {
        this(file, f24972e);
    }
}
