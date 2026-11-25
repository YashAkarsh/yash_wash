package com.haier.library.okhttp.b.d;

import com.haier.library.okhttp.n;
import com.haier.library.okhttp.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<x> f27006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27007b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27009d;

    public b(List<x> list) {
        this.f27006a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i7 = this.f27007b; i7 < this.f27006a.size(); i7++) {
            if (this.f27006a.get(i7).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public x a(SSLSocket sSLSocket) throws IOException {
        x xVar;
        int i7 = this.f27007b;
        int size = this.f27006a.size();
        while (true) {
            if (i7 >= size) {
                xVar = null;
                break;
            }
            xVar = this.f27006a.get(i7);
            if (xVar.c(sSLSocket)) {
                this.f27007b = i7 + 1;
                break;
            }
            i7++;
        }
        if (xVar != null) {
            this.f27008c = c(sSLSocket);
            n.b.f27684a.i(xVar, sSLSocket, this.f27009d);
            return xVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f27009d + ", modes=" + this.f27006a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f27009d = true;
        if (!this.f27008c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z7 = iOException instanceof SSLHandshakeException;
        if ((z7 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z7 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
