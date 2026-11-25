package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
class l implements w0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.c f14424c;

    public l(String str, w0.c cVar) {
        this.f14423b = str;
        this.f14424c = cVar;
    }

    @Override // w0.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f14423b.getBytes("UTF-8"));
        this.f14424c.a(messageDigest);
    }

    @Override // w0.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f14423b.equals(lVar.f14423b) && this.f14424c.equals(lVar.f14424c);
    }

    @Override // w0.c
    public int hashCode() {
        return (this.f14423b.hashCode() * 31) + this.f14424c.hashCode();
    }
}
