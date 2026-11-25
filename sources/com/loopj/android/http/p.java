package com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: classes2.dex */
class p implements HttpEntity {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f32575j = "SimpleMultipartEntity";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f32576k = "application/octet-stream";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte[] f32577l = "\r\n".getBytes();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f32578m = "Content-Transfer-Encoding: binary\r\n".getBytes();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final char[] f32579n = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f32581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f32582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32583d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<a> f32584e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteArrayOutputStream f32585f = new ByteArrayOutputStream();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private m f32586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32588i;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f32589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f32590b;

        public a(String str, File file, String str2) {
            this.f32590b = a(str, file.getName(), str2);
            this.f32589a = file;
        }

        private byte[] a(String str, String str2, String str3) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(p.this.f32581b);
                byteArrayOutputStream.write(p.this.m(str, str2));
                byteArrayOutputStream.write(p.this.n(str3));
                byteArrayOutputStream.write(p.f32578m);
                byteArrayOutputStream.write(p.f32577l);
            } catch (IOException e8) {
                Log.e(p.f32575j, "createHeader ByteArrayOutputStream exception", e8);
            }
            return byteArrayOutputStream.toByteArray();
        }

        public long b() {
            return ((long) this.f32590b.length) + this.f32589a.length();
        }

        public void c(OutputStream outputStream) throws IOException {
            outputStream.write(this.f32590b);
            p.this.p(this.f32590b.length);
            FileInputStream fileInputStream = new FileInputStream(this.f32589a);
            byte[] bArr = new byte[4096];
            while (true) {
                int i7 = fileInputStream.read(bArr);
                if (i7 == -1) {
                    outputStream.write(p.f32577l);
                    p.this.p(p.f32577l.length);
                    outputStream.flush();
                    try {
                        fileInputStream.close();
                        return;
                    } catch (IOException e8) {
                        Log.w(p.f32575j, "Cannot close input stream", e8);
                        return;
                    }
                }
                outputStream.write(bArr, 0, i7);
                p.this.p(i7);
            }
        }
    }

    public p(m mVar) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i7 = 0; i7 < 30; i7++) {
            char[] cArr = f32579n;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f32580a = sb.toString();
        this.f32581b = ("--" + this.f32580a + "\r\n").getBytes();
        this.f32582c = ("--" + this.f32580a + "--\r\n").getBytes();
        this.f32586g = mVar;
    }

    private byte[] l(String str) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] m(String str, String str2) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] n(String str) {
        return ("Content-Type: " + str + "\r\n").getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i7) {
        int i8 = this.f32587h + i7;
        this.f32587h = i8;
        this.f32586g.i(i8, this.f32588i);
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws UnsupportedOperationException, IOException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public void g(String str, File file) {
        h(str, file, null);
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws UnsupportedOperationException, IOException {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        long size = this.f32585f.size();
        Iterator<a> it = this.f32584e.iterator();
        while (it.hasNext()) {
            long jB = it.next().b();
            if (jB < 0) {
                return -1L;
            }
            size += jB;
        }
        return size + ((long) this.f32582c.length);
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.f32580a);
    }

    public void h(String str, File file, String str2) {
        if (str2 == null) {
            str2 = f32576k;
        }
        this.f32584e.add(new a(str, file, str2));
    }

    public void i(String str, String str2) {
        k(str, str2, "text/plain; charset=UTF-8");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.f32583d;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public void j(String str, String str2, InputStream inputStream, String str3) throws IOException {
        if (str3 == null) {
            str3 = f32576k;
        }
        this.f32585f.write(this.f32581b);
        this.f32585f.write(m(str, str2));
        this.f32585f.write(n(str3));
        this.f32585f.write(f32578m);
        this.f32585f.write(f32577l);
        byte[] bArr = new byte[4096];
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                this.f32585f.write(f32577l);
                this.f32585f.flush();
                try {
                    inputStream.close();
                    return;
                } catch (IOException e8) {
                    Log.w(f32575j, "Cannot close input stream", e8);
                    return;
                }
            }
            this.f32585f.write(bArr, 0, i7);
        }
    }

    public void k(String str, String str2, String str3) {
        try {
            this.f32585f.write(this.f32581b);
            this.f32585f.write(l(str));
            this.f32585f.write(n(str3));
            ByteArrayOutputStream byteArrayOutputStream = this.f32585f;
            byte[] bArr = f32577l;
            byteArrayOutputStream.write(bArr);
            this.f32585f.write(str2.getBytes());
            this.f32585f.write(bArr);
        } catch (IOException e8) {
            Log.e(f32575j, "addPart ByteArrayOutputStream exception", e8);
        }
    }

    public void o(boolean z7) {
        this.f32583d = z7;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.f32587h = 0;
        this.f32588i = (int) getContentLength();
        this.f32585f.writeTo(outputStream);
        p(this.f32585f.size());
        Iterator<a> it = this.f32584e.iterator();
        while (it.hasNext()) {
            it.next().c(outputStream);
        }
        outputStream.write(this.f32582c);
        p(this.f32582c.length);
    }
}
