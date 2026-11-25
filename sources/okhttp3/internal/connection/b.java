package okhttp3.internal.connection;

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
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l0;
import okhttp3.ConnectionSpec;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f37748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ConnectionSpec> f37750d;

    public b(@a7.d List<ConnectionSpec> connectionSpecs) {
        l0.p(connectionSpecs, "connectionSpecs");
        this.f37750d = connectionSpecs;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int size = this.f37750d.size();
        for (int i7 = this.f37747a; i7 < size; i7++) {
            if (this.f37750d.get(i7).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public final ConnectionSpec a(@a7.d SSLSocket sslSocket) throws IOException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        l0.p(sslSocket, "sslSocket");
        int i7 = this.f37747a;
        int size = this.f37750d.size();
        while (true) {
            if (i7 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f37750d.get(i7);
            if (connectionSpec.isCompatible(sslSocket)) {
                this.f37747a = i7 + 1;
                break;
            }
            i7++;
        }
        if (connectionSpec != null) {
            this.f37748b = c(sslSocket);
            connectionSpec.apply$okhttp(sslSocket, this.f37749c);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f37749c);
        sb.append(',');
        sb.append(" modes=");
        sb.append(this.f37750d);
        sb.append(',');
        sb.append(" supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        l0.m(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        l0.o(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean b(@a7.d IOException e8) {
        l0.p(e8, "e");
        this.f37749c = true;
        return (!this.f37748b || (e8 instanceof ProtocolException) || (e8 instanceof InterruptedIOException) || ((e8 instanceof SSLHandshakeException) && (e8.getCause() instanceof CertificateException)) || (e8 instanceof SSLPeerUnverifiedException) || !(e8 instanceof SSLException)) ? false : true;
    }
}
