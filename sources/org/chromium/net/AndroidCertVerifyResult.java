package org.chromium.net;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net::android")
public class AndroidCertVerifyResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f38986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<X509Certificate> f38987c;

    public AndroidCertVerifyResult(int i7, boolean z7, List<X509Certificate> list) {
        this.f38985a = i7;
        this.f38986b = z7;
        this.f38987c = new ArrayList(list);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] bArr = new byte[this.f38987c.size()][];
        for (int i7 = 0; i7 < this.f38987c.size(); i7++) {
            try {
                bArr[i7] = this.f38987c.get(i7).getEncoded();
            } catch (CertificateEncodingException unused) {
                return new byte[0][];
            }
        }
        return bArr;
    }

    @CalledByNative
    public int getStatus() {
        return this.f38985a;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.f38986b;
    }

    public AndroidCertVerifyResult(int i7) {
        this.f38985a = i7;
        this.f38986b = false;
        this.f38987c = Collections.emptyList();
    }
}
