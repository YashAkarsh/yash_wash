package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
final class n0 extends k {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Socket f38505n;

    public n0(@a7.d Socket socket) {
        kotlin.jvm.internal.l0.p(socket, "socket");
        this.f38505n = socket;
    }

    @Override // okio.k
    protected void B() {
        try {
            this.f38505n.close();
        } catch (AssertionError e8) {
            if (!a0.e(e8)) {
                throw e8;
            }
            b0.f38421a.log(Level.WARNING, "Failed to close timed out socket " + this.f38505n, (Throwable) e8);
        } catch (Exception e9) {
            b0.f38421a.log(Level.WARNING, "Failed to close timed out socket " + this.f38505n, (Throwable) e9);
        }
    }

    @Override // okio.k
    @a7.d
    protected IOException x(@a7.e IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.f13674p);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
