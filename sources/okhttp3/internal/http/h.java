package okhttp3.internal.http;

import kotlin.jvm.internal.l0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.o;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f37889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f37890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f37891c;

    public h(@a7.e String str, long j7, @a7.d o source) {
        l0.p(source, "source");
        this.f37889a = str;
        this.f37890b = j7;
        this.f37891c = source;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f37890b;
    }

    @Override // okhttp3.ResponseBody
    @a7.e
    public MediaType contentType() {
        String str = this.f37889a;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    @a7.d
    public o source() {
        return this.f37891c;
    }
}
