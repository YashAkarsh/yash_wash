package com.bumptech.glide.signature;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class d implements w0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14908b;

    public d(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f14908b = str;
    }

    @Override // w0.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f14908b.getBytes("UTF-8"));
    }

    @Override // w0.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f14908b.equals(((d) obj).f14908b);
    }

    @Override // w0.c
    public int hashCode() {
        return this.f14908b.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.f14908b + "'}";
    }
}
