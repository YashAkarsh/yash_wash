package okhttp3.internal.http;

import java.net.Proxy;
import kotlin.jvm.internal.l0;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f37892a = new i();

    private i() {
    }

    private final boolean b(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    @a7.d
    public final String a(@a7.d Request request, @a7.d Proxy.Type proxyType) {
        l0.p(request, "request");
        l0.p(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        i iVar = f37892a;
        if (iVar.b(request, proxyType)) {
            sb.append(request.url());
        } else {
            sb.append(iVar.c(request.url()));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @a7.d
    public final String c(@a7.d HttpUrl url) {
        l0.p(url, "url");
        String strEncodedPath = url.encodedPath();
        String strEncodedQuery = url.encodedQuery();
        if (strEncodedQuery == null) {
            return strEncodedPath;
        }
        return strEncodedPath + '?' + strEncodedQuery;
    }
}
