package t5;

import a7.d;
import a7.e;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.x;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40386a = new a();

    private a() {
    }

    @Override // java.net.ProxySelector
    public void connectFailed(@e URI uri, @e SocketAddress socketAddress, @e IOException iOException) {
    }

    @Override // java.net.ProxySelector
    @d
    public List<Proxy> select(@e URI uri) {
        if (uri != null) {
            return x.l(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
