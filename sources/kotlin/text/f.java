package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.l0;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final f f35352a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final Charset f35353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final Charset f35354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final Charset f35355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final Charset f35356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final Charset f35357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final Charset f35358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.e
    private static Charset f35359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.e
    private static Charset f35360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a7.e
    private static Charset f35361j;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        l0.o(charsetForName, "forName(\"UTF-8\")");
        f35353b = charsetForName;
        Charset charsetForName2 = Charset.forName(CharEncoding.UTF_16);
        l0.o(charsetForName2, "forName(\"UTF-16\")");
        f35354c = charsetForName2;
        Charset charsetForName3 = Charset.forName(CharEncoding.UTF_16BE);
        l0.o(charsetForName3, "forName(\"UTF-16BE\")");
        f35355d = charsetForName3;
        Charset charsetForName4 = Charset.forName(CharEncoding.UTF_16LE);
        l0.o(charsetForName4, "forName(\"UTF-16LE\")");
        f35356e = charsetForName4;
        Charset charsetForName5 = Charset.forName(CharEncoding.US_ASCII);
        l0.o(charsetForName5, "forName(\"US-ASCII\")");
        f35357f = charsetForName5;
        Charset charsetForName6 = Charset.forName(CharEncoding.ISO_8859_1);
        l0.o(charsetForName6, "forName(\"ISO-8859-1\")");
        f35358g = charsetForName6;
    }

    private f() {
    }

    @a7.d
    @h5.h(name = "UTF32")
    public final Charset a() {
        Charset charset = f35359h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32");
        l0.o(charsetForName, "forName(\"UTF-32\")");
        f35359h = charsetForName;
        return charsetForName;
    }

    @a7.d
    @h5.h(name = "UTF32_BE")
    public final Charset b() {
        Charset charset = f35361j;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        l0.o(charsetForName, "forName(\"UTF-32BE\")");
        f35361j = charsetForName;
        return charsetForName;
    }

    @a7.d
    @h5.h(name = "UTF32_LE")
    public final Charset c() {
        Charset charset = f35360i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        l0.o(charsetForName, "forName(\"UTF-32LE\")");
        f35360i = charsetForName;
        return charsetForName;
    }
}
