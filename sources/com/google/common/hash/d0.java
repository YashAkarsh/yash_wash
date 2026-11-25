package com.google.common.hash;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
@u1.j
final class d0 extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mac f21738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Key f21739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f21742e;

    private static final class b extends com.google.common.hash.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Mac f21743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f21744c;

        private void u() {
            com.google.common.base.e0.h0(!this.f21744c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.u
        public r o() {
            u();
            this.f21744c = true;
            return r.h(this.f21743b.doFinal());
        }

        @Override // com.google.common.hash.a
        protected void q(byte b8) {
            u();
            this.f21743b.update(b8);
        }

        @Override // com.google.common.hash.a
        protected void r(ByteBuffer byteBuffer) {
            u();
            com.google.common.base.e0.E(byteBuffer);
            this.f21743b.update(byteBuffer);
        }

        @Override // com.google.common.hash.a
        protected void s(byte[] bArr) {
            u();
            this.f21743b.update(bArr);
        }

        @Override // com.google.common.hash.a
        protected void t(byte[] bArr, int i7, int i8) {
            u();
            this.f21743b.update(bArr, i7, i8);
        }

        private b(Mac mac) {
            this.f21743b = mac;
        }
    }

    d0(String str, Key key, String str2) {
        Mac macL = l(str, key);
        this.f21738a = macL;
        this.f21739b = (Key) com.google.common.base.e0.E(key);
        this.f21740c = (String) com.google.common.base.e0.E(str2);
        this.f21741d = macL.getMacLength() * 8;
        this.f21742e = m(macL);
    }

    private static Mac l(String str, Key key) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        } catch (NoSuchAlgorithmException e9) {
            throw new IllegalStateException(e9);
        }
    }

    private static boolean m(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.s
    public u b() {
        if (this.f21742e) {
            try {
                return new b((Mac) this.f21738a.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(l(this.f21738a.getAlgorithm(), this.f21739b));
    }

    @Override // com.google.common.hash.s
    public int h() {
        return this.f21741d;
    }

    public String toString() {
        return this.f21740c;
    }
}
