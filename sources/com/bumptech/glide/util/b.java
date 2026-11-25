package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14915c = "ContentLengthStream";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14916d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f14917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14918b;

    b(InputStream inputStream, long j7) {
        super(inputStream);
        this.f14917a = j7;
    }

    private int b(int i7) throws IOException {
        if (i7 >= 0) {
            this.f14918b += i7;
        } else if (this.f14917a - ((long) this.f14918b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f14917a + ", but read: " + this.f14918b);
        }
        return i7;
    }

    public static InputStream c(InputStream inputStream, long j7) {
        return new b(inputStream, j7);
    }

    public static InputStream e(InputStream inputStream, String str) {
        return c(inputStream, f(str));
    }

    private static int f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e8) {
                if (Log.isLoggable(f14915c, 3)) {
                    Log.d(f14915c, "failed to parse content length header: " + str, e8);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f14917a - ((long) this.f14918b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        return b(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i7, int i8) throws IOException {
        return b(super.read(bArr, i7, i8));
    }
}
