package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.l0;
import kotlin.p;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private IOException f37838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final IOException f37839b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@a7.d IOException firstConnectException) {
        super(firstConnectException);
        l0.p(firstConnectException, "firstConnectException");
        this.f37839b = firstConnectException;
        this.f37838a = firstConnectException;
    }

    public final void a(@a7.d IOException e8) {
        l0.p(e8, "e");
        p.a(this.f37839b, e8);
        this.f37838a = e8;
    }

    @a7.d
    public final IOException b() {
        return this.f37839b;
    }

    @a7.d
    public final IOException c() {
        return this.f37838a;
    }
}
