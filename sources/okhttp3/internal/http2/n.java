package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final b f38216a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@a7.d b errorCode) {
        super("stream was reset: " + errorCode);
        l0.p(errorCode, "errorCode");
        this.f38216a = errorCode;
    }
}
