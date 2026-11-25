package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public interface m {

    public static final class a {
        public static boolean a(@a7.d m mVar, @a7.d SSLSocketFactory sslSocketFactory) {
            l0.p(sslSocketFactory, "sslSocketFactory");
            return false;
        }

        @a7.e
        public static X509TrustManager b(@a7.d m mVar, @a7.d SSLSocketFactory sslSocketFactory) {
            l0.p(sslSocketFactory, "sslSocketFactory");
            return null;
        }
    }

    boolean a(@a7.d SSLSocket sSLSocket);

    boolean b();

    @a7.e
    String c(@a7.d SSLSocket sSLSocket);

    @a7.e
    X509TrustManager d(@a7.d SSLSocketFactory sSLSocketFactory);

    boolean e(@a7.d SSLSocketFactory sSLSocketFactory);

    void f(@a7.d SSLSocket sSLSocket, @a7.e String str, @a7.d List<? extends Protocol> list);
}
