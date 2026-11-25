package okhttp3;

import a7.d;
import h5.i;
import h5.l;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lokhttp3/Credentials;", "", "()V", "basic", "", "username", "password", "charset", "Ljava/nio/charset/Charset;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @d
    @i
    @l
    public static final String basic(@d String str, @d String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset ISO_8859_1, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            l0.o(ISO_8859_1, "ISO_8859_1");
        }
        return basic(str, str2, ISO_8859_1);
    }

    @d
    @i
    @l
    public static final String basic(@d String username, @d String password, @d Charset charset) {
        l0.p(username, "username");
        l0.p(password, "password");
        l0.p(charset, "charset");
        return "Basic " + p.f38508f.j(username + ':' + password, charset).d();
    }
}
