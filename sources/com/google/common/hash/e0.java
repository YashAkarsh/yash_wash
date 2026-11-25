package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
final class e0 extends com.google.common.hash.c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageDigest f21747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21750d;

    private static final class b extends com.google.common.hash.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MessageDigest f21751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f21752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f21753d;

        private void u() {
            com.google.common.base.e0.h0(!this.f21753d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.u
        public r o() {
            u();
            this.f21753d = true;
            return this.f21752c == this.f21751b.getDigestLength() ? r.h(this.f21751b.digest()) : r.h(Arrays.copyOf(this.f21751b.digest(), this.f21752c));
        }

        @Override // com.google.common.hash.a
        protected void q(byte b8) {
            u();
            this.f21751b.update(b8);
        }

        @Override // com.google.common.hash.a
        protected void r(ByteBuffer byteBuffer) {
            u();
            this.f21751b.update(byteBuffer);
        }

        @Override // com.google.common.hash.a
        protected void t(byte[] bArr, int i7, int i8) {
            u();
            this.f21751b.update(bArr, i7, i8);
        }

        private b(MessageDigest messageDigest, int i7) {
            this.f21751b = messageDigest;
            this.f21752c = i7;
        }
    }

    private static final class c implements Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f21754d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f21756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21757c;

        private Object readResolve() {
            return new e0(this.f21755a, this.f21756b, this.f21757c);
        }

        private c(String str, int i7, String str2) {
            this.f21755a = str;
            this.f21756b = i7;
            this.f21757c = str2;
        }
    }

    e0(String str, String str2) {
        MessageDigest messageDigestL = l(str);
        this.f21747a = messageDigestL;
        this.f21748b = messageDigestL.getDigestLength();
        this.f21750d = (String) com.google.common.base.e0.E(str2);
        this.f21749c = m(messageDigestL);
    }

    private static MessageDigest l(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e8) {
            throw new AssertionError(e8);
        }
    }

    private static boolean m(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.s
    public u b() {
        if (this.f21749c) {
            try {
                return new b((MessageDigest) this.f21747a.clone(), this.f21748b);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(l(this.f21747a.getAlgorithm()), this.f21748b);
    }

    @Override // com.google.common.hash.s
    public int h() {
        return this.f21748b * 8;
    }

    public String toString() {
        return this.f21750d;
    }

    Object writeReplace() {
        return new c(this.f21747a.getAlgorithm(), this.f21748b, this.f21750d);
    }

    e0(String str, int i7, String str2) {
        this.f21750d = (String) com.google.common.base.e0.E(str2);
        MessageDigest messageDigestL = l(str);
        this.f21747a = messageDigestL;
        int digestLength = messageDigestL.getDigestLength();
        com.google.common.base.e0.m(i7 >= 4 && i7 <= digestLength, "bytes (%s) must be >= 4 and < %s", i7, digestLength);
        this.f21748b = i7;
        this.f21749c = m(messageDigestL);
    }
}
