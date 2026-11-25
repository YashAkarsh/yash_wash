package u5;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.internal.platform.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40417a = new a(null);

    public static final class a {
        private a() {
        }

        @a7.d
        public final c a(@a7.d X509TrustManager trustManager) {
            l0.p(trustManager, "trustManager");
            return k.f38284e.g().d(trustManager);
        }

        @a7.d
        public final c b(@a7.d X509Certificate... caCerts) {
            l0.p(caCerts, "caCerts");
            return new u5.a(new b((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    @a7.d
    public abstract List<Certificate> a(@a7.d List<? extends Certificate> list, @a7.d String str) throws SSLPeerUnverifiedException;
}
