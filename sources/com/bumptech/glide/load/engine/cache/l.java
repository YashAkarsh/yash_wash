package com.bumptech.glide.load.engine.cache;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.f<w0.c, String> f14343a = new com.bumptech.glide.util.f<>(1000);

    l() {
    }

    public String a(w0.c cVar) {
        String strK;
        synchronized (this.f14343a) {
            strK = this.f14343a.k(cVar);
        }
        if (strK == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                cVar.a(messageDigest);
                strK = com.bumptech.glide.util.i.o(messageDigest.digest());
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            } catch (NoSuchAlgorithmException e9) {
                e9.printStackTrace();
            }
            synchronized (this.f14343a) {
                this.f14343a.n(cVar, strK);
            }
        }
        return strK;
    }
}
