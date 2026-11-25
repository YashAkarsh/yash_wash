package com.haier.library.a;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final MessageDigest f26295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Mac f26296c;

    private q(b0 b0Var, String str) {
        super(b0Var);
        try {
            this.f26295b = MessageDigest.getInstance(str);
            this.f26296c = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static q c(b0 b0Var) {
        return new q(b0Var, "MD5");
    }

    public static q e(b0 b0Var, j jVar) {
        return new q(b0Var, jVar, "HmacSHA1");
    }

    public static q f(b0 b0Var) {
        return new q(b0Var, "SHA-1");
    }

    public static q g(b0 b0Var, j jVar) {
        return new q(b0Var, jVar, "HmacSHA256");
    }

    public static q r(b0 b0Var) {
        return new q(b0Var, "SHA-256");
    }

    public static q s(b0 b0Var, j jVar) {
        return new q(b0Var, jVar, "HmacSHA512");
    }

    public static q u(b0 b0Var) {
        return new q(b0Var, "SHA-512");
    }

    @Override // com.haier.library.a.l, com.haier.library.a.b0
    public void I1(g gVar, long j7) throws IOException {
        c.d(gVar.f26255b, 0L, j7);
        y yVar = gVar.f26254a;
        long j8 = 0;
        while (j8 < j7) {
            int iMin = (int) Math.min(j7 - j8, yVar.f26333c - yVar.f26332b);
            MessageDigest messageDigest = this.f26295b;
            if (messageDigest != null) {
                messageDigest.update(yVar.f26331a, yVar.f26332b, iMin);
            } else {
                this.f26296c.update(yVar.f26331a, yVar.f26332b, iMin);
            }
            j8 += (long) iMin;
            yVar = yVar.f26336f;
        }
        super.I1(gVar, j7);
    }

    public final j q() {
        MessageDigest messageDigest = this.f26295b;
        return j.m(messageDigest != null ? messageDigest.digest() : this.f26296c.doFinal());
    }

    private q(b0 b0Var, j jVar, String str) {
        super(b0Var);
        try {
            Mac mac = Mac.getInstance(str);
            this.f26296c = mac;
            mac.init(new SecretKeySpec(jVar.a0(), str));
            this.f26295b = null;
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
