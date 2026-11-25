package com.bumptech.glide.signature;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class c implements w0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f14906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14907d;

    public c(String str, long j7, int i7) {
        this.f14905b = str;
        this.f14906c = j7;
        this.f14907d = i7;
    }

    @Override // w0.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f14906c).putInt(this.f14907d).array());
        messageDigest.update(this.f14905b.getBytes("UTF-8"));
    }

    @Override // w0.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f14906c != cVar.f14906c || this.f14907d != cVar.f14907d) {
            return false;
        }
        String str = this.f14905b;
        String str2 = cVar.f14905b;
        return str == null ? str2 == null : str.equals(str2);
    }

    @Override // w0.c
    public int hashCode() {
        String str = this.f14905b;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j7 = this.f14906c;
        return (((iHashCode * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f14907d;
    }
}
