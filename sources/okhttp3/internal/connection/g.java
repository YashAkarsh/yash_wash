package okhttp3.internal.connection;

import java.net.Proxy;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f37829a;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        f37829a = iArr;
        iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        iArr[Proxy.Type.HTTP.ordinal()] = 2;
    }
}
