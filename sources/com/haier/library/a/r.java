package com.haier.library.a;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MessageDigest f26297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Mac f26298c;

    private r(c0 c0Var, String str) {
        super(c0Var);
        try {
            this.f26297b = MessageDigest.getInstance(str);
            this.f26298c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static r c(c0 c0Var) {
        return new r(c0Var, "MD5");
    }

    public static r e(c0 c0Var, j jVar) {
        return new r(c0Var, jVar, "HmacSHA1");
    }

    public static r f(c0 c0Var) {
        return new r(c0Var, "SHA-1");
    }

    public static r g(c0 c0Var, j jVar) {
        return new r(c0Var, jVar, "HmacSHA256");
    }

    public static r r(c0 c0Var) {
        return new r(c0Var, "SHA-256");
    }

    @Override // com.haier.library.a.m, com.haier.library.a.c0
    public long P0(g gVar, long j7) throws IOException {
        long jP0 = super.P0(gVar, j7);
        if (jP0 != -1) {
            long j8 = gVar.f26255b;
            long j9 = j8 - jP0;
            y yVar = gVar.f26254a;
            while (j8 > j9) {
                yVar = yVar.f26337g;
                j8 -= (long) (yVar.f26333c - yVar.f26332b);
            }
            while (j8 < gVar.f26255b) {
                int i7 = (int) ((((long) yVar.f26332b) + j9) - j8);
                MessageDigest messageDigest = this.f26297b;
                if (messageDigest != null) {
                    messageDigest.update(yVar.f26331a, i7, yVar.f26333c - i7);
                } else {
                    this.f26298c.update(yVar.f26331a, i7, yVar.f26333c - i7);
                }
                j9 = ((long) (yVar.f26333c - yVar.f26332b)) + j8;
                yVar = yVar.f26336f;
                j8 = j9;
            }
        }
        return jP0;
    }

    public final j q() {
        MessageDigest messageDigest = this.f26297b;
        return j.m(messageDigest != null ? messageDigest.digest() : this.f26298c.doFinal());
    }

    private r(c0 c0Var, j jVar, String str) {
        super(c0Var);
        try {
            Mac mac = Mac.getInstance(str);
            this.f26298c = mac;
            mac.init(new SecretKeySpec(jVar.a0(), str));
            this.f26297b = null;
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
