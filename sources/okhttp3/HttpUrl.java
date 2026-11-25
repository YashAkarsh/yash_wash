package okhttp3;

import a7.e;
import b1.d;
import com.alibaba.fastjson.asm.j;
import com.facebook.share.internal.ShareConstants;
import h5.h;
import h5.l;
import j0.c;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.b1;
import kotlin.collections.n1;
import kotlin.collections.y;
import kotlin.collections.z;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.ranges.i;
import kotlin.ranges.q;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.h0;
import kotlin.text.o;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.m;
import okio.r0;

/* JADX INFO: loaded from: classes3.dex */
@i0(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007¢\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007¢\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007¢\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010¨\u0006K"}, d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", c.f34242f, "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", d.f11283b, "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", ShareConstants.MEDIA_URI, "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HttpUrl {

    @a7.d
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    @a7.d
    public static final String FRAGMENT_ENCODE_SET = "";

    @a7.d
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    @a7.d
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @a7.d
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @a7.d
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @a7.d
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @a7.d
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @a7.d
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @a7.d
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @a7.d
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @e
    private final String fragment;

    @a7.d
    private final String host;
    private final boolean isHttps;

    @a7.d
    private final String password;

    @a7.d
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;

    @a7.d
    private final String scheme;
    private final String url;

    @a7.d
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    @i0(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J0\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010%\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u0010\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0010\u0010)\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0004J\u0018\u0010,\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u0018\u00100\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u0018\u00101\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u000e\u00102\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0004J\u0010\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u00105\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0004J\u000f\u00108\u001a\u00020\u0000H\u0000¢\u0006\u0004\b6\u00107J\u0006\u0010:\u001a\u000209J\b\u0010;\u001a\u00020\u0004H\u0016J!\u0010?\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b=\u0010>R$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010\u0018\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010@\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR\"\u0010\u001a\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010@\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010@\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\"\u0010\u001c\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040P8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010Q\u001a\u0004\bR\u0010SR,\u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bT\u0010Q\u001a\u0004\bU\u0010S\"\u0004\bV\u0010WR$\u00105\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010@\u001a\u0004\bX\u0010B\"\u0004\bY\u0010D¨\u0006]"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "", "effectivePort", "", "pathSegments", "", "alreadyEncoded", "addPathSegments", "canonicalName", "Lkotlin/l2;", "removeAllCanonicalQueryParameters", "input", "startPos", "limit", "resolvePath", "pos", "addTrailingSlash", "push", "isDot", "isDotDot", "pop", "scheme", "username", "encodedUsername", "password", "encodedPassword", c.f34242f, "port", "pathSegment", "addPathSegment", "encodedPathSegment", "addEncodedPathSegment", "encodedPathSegments", "addEncodedPathSegments", "index", "setPathSegment", "setEncodedPathSegment", "removePathSegment", "encodedPath", d.f11283b, "encodedQuery", "name", "value", "addQueryParameter", "encodedName", "encodedValue", "addEncodedQueryParameter", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "fragment", "encodedFragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "toString", "base", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "Ljava/lang/String;", "getScheme$okhttp", "()Ljava/lang/String;", "setScheme$okhttp", "(Ljava/lang/String;)V", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "getHost$okhttp", "setHost$okhttp", "I", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "", "Ljava/util/List;", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        public static final Companion Companion = new Companion(null);

        @a7.d
        public static final String INVALID_HOST = "Invalid URL host";

        @e
        private String encodedFragment;

        @a7.d
        private final List<String> encodedPathSegments;

        @e
        private List<String> encodedQueryNamesAndValues;

        @e
        private String host;

        @e
        private String scheme;

        @a7.d
        private String encodedUsername = "";

        @a7.d
        private String encodedPassword = "";
        private int port = -1;

        @i0(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i7, int i8) {
                try {
                    int i9 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i7, i8, "", false, false, false, false, null, 248, null));
                    if (1 <= i9 && 65535 >= i9) {
                        return i9;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i7, int i8) {
                while (i7 < i8) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt == ':') {
                        return i7;
                    }
                    if (cCharAt == '[') {
                        do {
                            i7++;
                            if (i7 >= i8) {
                                break;
                            }
                        } while (str.charAt(i7) != ']');
                    }
                    i7++;
                }
                return i8;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i7, int i8) {
                if (i8 - i7 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i7);
                if ((l0.t(cCharAt, 97) < 0 || l0.t(cCharAt, 122) > 0) && (l0.t(cCharAt, 65) < 0 || l0.t(cCharAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i7++;
                    if (i7 >= i8) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i7);
                    if ('a' > cCharAt2 || 'z' < cCharAt2) {
                        if ('A' > cCharAt2 || 'Z' < cCharAt2) {
                            if ('0' > cCharAt2 || '9' < cCharAt2) {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i7;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i7, int i8) {
                int i9 = 0;
                while (i7 < i8) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i9++;
                    i7++;
                }
                return i9;
            }

            public /* synthetic */ Companion(w wVar) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i7 = this.port;
            if (i7 != -1) {
                return i7;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            l0.m(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return l0.g(str, com.alibaba.android.arouter.utils.b.f12515h) || b0.K1(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return l0.g(str, "..") || b0.K1(str, "%2e.", true) || b0.K1(str, ".%2e", true) || b0.K1(str, "%2e%2e", true);
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void push(String str, int i7, int i8, boolean z7, boolean z8) {
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i7, i8, HttpUrl.PATH_SEGMENT_ENCODE_SET, z8, false, false, false, null, 240, null);
            if (isDot(strCanonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$okhttp$default);
            }
            if (z7) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            l0.m(list);
            i iVarE1 = q.e1(q.W(list.size() - 2, 0), 2);
            int iG = iVarE1.g();
            int iH = iVarE1.h();
            int iJ = iVarE1.j();
            if (iJ >= 0) {
                if (iG > iH) {
                    return;
                }
            } else if (iG < iH) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                l0.m(list2);
                if (l0.g(str, list2.get(iG))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    l0.m(list3);
                    list3.remove(iG + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    l0.m(list4);
                    list4.remove(iG);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    l0.m(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (iG == iH) {
                    return;
                } else {
                    iG += iJ;
                }
            }
        }

        private final void resolvePath(String str, int i7, int i8) {
            if (i7 == i8) {
                return;
            }
            char cCharAt = str.charAt(i7);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i7++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i9 = i7;
                if (i9 >= i8) {
                    return;
                }
                i7 = okhttp3.internal.d.q(str, "/\\", i9, i8);
                boolean z7 = i7 < i8;
                push(str, i9, i7, z7, true);
                if (z7) {
                    i7++;
                }
            }
        }

        @a7.d
        public final Builder addEncodedPathSegment(@a7.d String encodedPathSegment) {
            l0.p(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @a7.d
        public final Builder addEncodedPathSegments(@a7.d String encodedPathSegments) {
            l0.p(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        @a7.d
        public final Builder addEncodedQueryParameter(@a7.d String encodedName, @e String str) {
            l0.p(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            l0.m(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            l0.m(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null) : null);
            return this;
        }

        @a7.d
        public final Builder addPathSegment(@a7.d String pathSegment) {
            l0.p(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @a7.d
        public final Builder addPathSegments(@a7.d String pathSegments) {
            l0.p(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        @a7.d
        public final Builder addQueryParameter(@a7.d String name, @e String str) {
            l0.p(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            l0.m(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            l0.m(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        @a7.d
        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(z.Z(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                arrayList = new ArrayList(z.Z(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null) : null, toString());
        }

        @a7.d
        public final Builder encodedFragment(@e String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        @a7.d
        public final Builder encodedPassword(@a7.d String encodedPassword) {
            l0.p(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @a7.d
        public final Builder encodedPath(@a7.d String encodedPath) {
            l0.p(encodedPath, "encodedPath");
            if (b0.u2(encodedPath, "/", false, 2, null)) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001d  */
        @a7.d
        public final Builder encodedQuery(@e String str) {
            List<String> queryNamesAndValues$okhttp;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                } else {
                    queryNamesAndValues$okhttp = null;
                }
            } else {
                queryNamesAndValues$okhttp = null;
            }
            this.encodedQueryNamesAndValues = queryNamesAndValues$okhttp;
            return this;
        }

        @a7.d
        public final Builder encodedUsername(@a7.d String encodedUsername) {
            l0.p(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @a7.d
        public final Builder fragment(@e String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, j.f12602a0, null) : null;
            return this;
        }

        @e
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @a7.d
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @a7.d
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @e
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @a7.d
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @e
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @e
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @a7.d
        public final Builder host(@a7.d String host) {
            l0.p(host, "host");
            String strE = okhttp3.internal.a.e(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (strE != null) {
                this.host = strE;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        @a7.d
        public final Builder parse$okhttp(@e HttpUrl httpUrl, @a7.d String input) {
            int iQ;
            int i7;
            int i8;
            boolean z7;
            String str;
            int i9;
            boolean z8;
            boolean z9;
            l0.p(input, "input");
            int iD = okhttp3.internal.d.D(input, 0, 0, 3, null);
            int iF = okhttp3.internal.d.F(input, iD, 0, 2, null);
            Companion companion = Companion;
            int iSchemeDelimiterOffset = companion.schemeDelimiterOffset(input, iD, iF);
            String str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            boolean z10 = true;
            byte b8 = -1;
            if (iSchemeDelimiterOffset != -1) {
                if (b0.r2(input, "https:", iD, true)) {
                    this.scheme = j0.b.f34226a;
                    iD += 6;
                } else {
                    if (!b0.r2(input, "http:", iD, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iSchemeDelimiterOffset);
                        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = com.haier.uhome.usdk.base.a.av;
                    iD += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = companion.slashCount(input, iD, iF);
            byte b9 = r0.f38528a;
            byte b10 = 35;
            if (iSlashCount >= 2 || httpUrl == null || (!l0.g(httpUrl.scheme(), this.scheme))) {
                int i10 = iD + iSlashCount;
                boolean z11 = false;
                boolean z12 = false;
                while (true) {
                    iQ = okhttp3.internal.d.q(input, "@/\\?#", i10, iF);
                    byte bCharAt = iQ != iF ? input.charAt(iQ) : b8;
                    if (bCharAt == b8 || bCharAt == b10 || bCharAt == 47 || bCharAt == 92 || bCharAt == b9) {
                        break;
                    }
                    if (bCharAt != 64) {
                        z7 = z10;
                        str = str2;
                        iF = iF;
                    } else {
                        if (z11) {
                            z7 = z10;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            str = str2;
                            i9 = iQ;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, i10, iQ, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                            z8 = z12;
                        } else {
                            int iP = okhttp3.internal.d.p(input, ':', i10, iQ);
                            Companion companion2 = HttpUrl.Companion;
                            z7 = z10;
                            String str3 = str2;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i10, iP, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z12) {
                                strCanonicalize$okhttp$default = this.encodedUsername + "%40" + strCanonicalize$okhttp$default;
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iP != iQ) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, iP + 1, iQ, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z9 = z7;
                            } else {
                                z9 = z11;
                            }
                            z11 = z9;
                            str = str3;
                            z8 = z7;
                            i9 = iQ;
                        }
                        i10 = i9 + 1;
                        z12 = z8;
                    }
                    str2 = str;
                    z10 = z7;
                    iF = iF;
                    b10 = 35;
                    b9 = r0.f38528a;
                    b8 = -1;
                }
                boolean z13 = z10;
                String str4 = str2;
                i7 = iF;
                Companion companion3 = Companion;
                int iPortColonOffset = companion3.portColonOffset(input, i10, iQ);
                int i11 = iPortColonOffset + 1;
                if (i11 < iQ) {
                    i8 = i10;
                    this.host = okhttp3.internal.a.e(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, i10, iPortColonOffset, false, 4, null));
                    int port = companion3.parsePort(input, i11, iQ);
                    this.port = port;
                    if (!(port != -1 ? z13 : false)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i11, iQ);
                        l0.o(strSubstring2, str4);
                        sb3.append(strSubstring2);
                        sb3.append(h0.f35376b);
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    i8 = i10;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = okhttp3.internal.a.e(Companion.percentDecode$okhttp$default(companion4, input, i8, iPortColonOffset, false, 4, null));
                    String str5 = this.scheme;
                    l0.m(str5);
                    this.port = companion4.defaultPort(str5);
                }
                if (!(this.host != null ? z13 : false)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i8, iPortColonOffset);
                    l0.o(strSubstring3, str4);
                    sb4.append(strSubstring3);
                    sb4.append(h0.f35376b);
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iD = iQ;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iD == iF || input.charAt(iD) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i7 = iF;
            }
            int i12 = i7;
            int iQ2 = okhttp3.internal.d.q(input, "?#", iD, i12);
            resolvePath(input, iD, iQ2);
            if (iQ2 < i12 && input.charAt(iQ2) == '?') {
                int iP2 = okhttp3.internal.d.p(input, '#', iQ2, i12);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, iQ2 + 1, iP2, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                iQ2 = iP2;
            }
            if (iQ2 < i12 && input.charAt(iQ2) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, iQ2 + 1, i12, "", true, false, false, true, null, j.R, null);
            }
            return this;
        }

        @a7.d
        public final Builder password(@a7.d String password) {
            l0.p(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @a7.d
        public final Builder port(int i7) {
            if (1 <= i7 && 65535 >= i7) {
                this.port = i7;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i7).toString());
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001d  */
        @a7.d
        public final Builder query(@e String str) {
            List<String> queryNamesAndValues$okhttp;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                } else {
                    queryNamesAndValues$okhttp = null;
                }
            } else {
                queryNamesAndValues$okhttp = null;
            }
            this.encodedQueryNamesAndValues = queryNamesAndValues$okhttp;
            return this;
        }

        @a7.d
        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new o("[\"<>^`{|}]").n(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i7 = 0; i7 < size; i7++) {
                List<String> list = this.encodedPathSegments;
                list.set(i7, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i7), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    String str2 = list2.get(i8);
                    list2.set(i8, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null;
            return this;
        }

        @a7.d
        public final Builder removeAllEncodedQueryParameters(@a7.d String encodedName) {
            l0.p(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        @a7.d
        public final Builder removeAllQueryParameters(@a7.d String name) {
            l0.p(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        @a7.d
        public final Builder removePathSegment(int i7) {
            this.encodedPathSegments.remove(i7);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        @a7.d
        public final Builder scheme(@a7.d String scheme) {
            l0.p(scheme, "scheme");
            if (b0.K1(scheme, com.haier.uhome.usdk.base.a.av, true)) {
                this.scheme = com.haier.uhome.usdk.base.a.av;
            } else {
                if (!b0.K1(scheme, j0.b.f34226a, true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
                this.scheme = j0.b.f34226a;
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(@e String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@a7.d String str) {
            l0.p(str, "<set-?>");
            this.encodedPassword = str;
        }

        @a7.d
        public final Builder setEncodedPathSegment(int i7, @a7.d String encodedPathSegment) {
            l0.p(encodedPathSegment, "encodedPathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i7, strCanonicalize$okhttp$default);
            if ((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@e List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @a7.d
        public final Builder setEncodedQueryParameter(@a7.d String encodedName, @e String str) {
            l0.p(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(@a7.d String str) {
            l0.p(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@e String str) {
            this.host = str;
        }

        @a7.d
        public final Builder setPathSegment(int i7, @a7.d String pathSegment) {
            l0.p(pathSegment, "pathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if ((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true) {
                this.encodedPathSegments.set(i7, strCanonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i7) {
            this.port = i7;
        }

        @a7.d
        public final Builder setQueryParameter(@a7.d String name, @e String str) {
            l0.p(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(@e String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0035  */
        /* JADX WARN: Code duplicated, block: B:20:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x0046  */
        /* JADX WARN: Code duplicated, block: B:38:0x0093  */
        @a7.d
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            } else {
                if (this.encodedPassword.length() > 0) {
                    sb.append(this.encodedUsername);
                    if (this.encodedPassword.length() > 0) {
                        sb.append(':');
                        sb.append(this.encodedPassword);
                    }
                    sb.append('@');
                }
            }
            String str2 = this.host;
            if (str2 != null) {
                l0.m(str2);
                if (c0.U2(str2, ':', false, 2, null)) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 != null) {
                    Companion companion = HttpUrl.Companion;
                    l0.m(str3);
                    if (iEffectivePort != companion.defaultPort(str3)) {
                        sb.append(':');
                        sb.append(iEffectivePort);
                    }
                } else {
                    sb.append(':');
                    sb.append(iEffectivePort);
                }
            }
            Companion companion2 = HttpUrl.Companion;
            companion2.toPathString$okhttp(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                l0.m(list);
                companion2.toQueryString$okhttp(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            String string = sb.toString();
            l0.o(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        @a7.d
        public final Builder username(@a7.d String username) {
            l0.p(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z7) {
            int i7 = 0;
            do {
                int iQ = okhttp3.internal.d.q(str, "/\\", i7, str.length());
                push(str, i7, iQ, iQ < str.length(), z7);
                i7 = iQ + 1;
            } while (i7 <= str.length());
            return this;
        }
    }

    @i0(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0019\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bG\u0010HJ,\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\f\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002JV\u0010\u0014\u001a\u00020\n*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0007J%\u0010\u001d\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00030\u00172\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00172\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019H\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ\u001b\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 *\u00020\u0003H\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010'\u001a\u00020$*\u00020\u0003H\u0007¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u0004\u0018\u00010$*\u00020\u0003H\u0007¢\u0006\u0004\b(\u0010&J\u0015\u0010)\u001a\u0004\u0018\u00010$*\u00020*H\u0007¢\u0006\u0004\b%\u0010+J\u0015\u0010)\u001a\u0004\u0018\u00010$*\u00020,H\u0007¢\u0006\u0004\b%\u0010-J\u0017\u0010%\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0003H\u0007¢\u0006\u0004\b/\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020\u0003H\u0007¢\u0006\u0004\b0\u0010&J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020*H\u0007¢\u0006\u0004\b/\u0010+J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u00020,H\u0007¢\u0006\u0004\b/\u0010-J1\u00104\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b2\u00103Jc\u00107\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b5\u00106R\u0014\u00108\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u00109R\u0014\u0010@\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b@\u00109R\u0014\u0010A\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u00109R\u0014\u0010B\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u00109R\u0014\u0010C\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u00109R\u0014\u0010D\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bD\u00109R\u0014\u0010E\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bE\u00109R\u0014\u0010F\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\bF\u00109¨\u0006I"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "Lokio/m;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "Lkotlin/l2;", "writePercentDecoded", "isPercentEncoded", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "writeCanonicalized", "scheme", "defaultPort", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", "", "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/HttpUrl;", "Ljava/net/URI;", "(Ljava/net/URI;)Lokhttp3/HttpUrl;", "url", "-deprecated_get", "-deprecated_parse", ShareConstants.MEDIA_URI, "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "percentDecode", "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset, int i9, Object obj) {
            return companion.canonicalize$okhttp(str, (i9 & 1) != 0 ? 0 : i7, (i9 & 2) != 0 ? str.length() : i8, str2, (i9 & 8) != 0 ? false : z7, (i9 & 16) != 0 ? false : z8, (i9 & 32) != 0 ? false : z9, (i9 & 64) != 0 ? false : z10, (i9 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i7, int i8) {
            int i9 = i7 + 2;
            return i9 < i8 && str.charAt(i7) == '%' && okhttp3.internal.d.N(str.charAt(i7 + 1)) != -1 && okhttp3.internal.d.N(str.charAt(i9)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i7, int i8, boolean z7, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                i7 = 0;
            }
            if ((i9 & 2) != 0) {
                i8 = str.length();
            }
            if ((i9 & 4) != 0) {
                z7 = false;
            }
            return companion.percentDecode$okhttp(str, i7, i8, z7);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0065  */
        /* JADX WARN: Code duplicated, block: B:41:0x006a  */
        /* JADX WARN: Code duplicated, block: B:44:0x0071  */
        /* JADX WARN: Code duplicated, block: B:50:0x008a  */
        /* JADX WARN: Code duplicated, block: B:53:0x0093 A[LOOP:1: B:51:0x008d->B:53:0x0093, LOOP_END] */
        private final void writeCanonicalized(m mVar, String str, int i7, int i8, String str2, boolean z7, boolean z8, boolean z9, boolean z10, Charset charset) {
            int iCharCount = i7;
            m mVar2 = null;
            while (iCharCount < i8) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z7 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z9) {
                        mVar.q0(z7 ? "+" : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z10) || c0.U2(str2, (char) iCodePointAt, false, 2, null))) {
                        if (mVar2 == null) {
                            mVar2 = new m();
                        }
                        if (charset != null || l0.g(charset, StandardCharsets.UTF_8)) {
                            mVar2.x(iCodePointAt);
                        } else {
                            mVar2.D1(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!mVar2.N()) {
                            int i9 = mVar2.readByte() & 255;
                            mVar.writeByte(37);
                            mVar.writeByte(HttpUrl.HEX_DIGITS[(i9 >> 4) & 15]);
                            mVar.writeByte(HttpUrl.HEX_DIGITS[i9 & 15]);
                        }
                    } else {
                        if (iCodePointAt == 37) {
                            if (z7) {
                                if (z8) {
                                    if (!isPercentEncoded(str, iCharCount, i8)) {
                                    }
                                }
                            }
                            if (mVar2 == null) {
                                mVar2 = new m();
                            }
                            if (charset != null) {
                                mVar2.x(iCodePointAt);
                            } else {
                                mVar2.x(iCodePointAt);
                            }
                            while (!mVar2.N()) {
                                int i10 = mVar2.readByte() & 255;
                                mVar.writeByte(37);
                                mVar.writeByte(HttpUrl.HEX_DIGITS[(i10 >> 4) & 15]);
                                mVar.writeByte(HttpUrl.HEX_DIGITS[i10 & 15]);
                            }
                        }
                        mVar.x(iCodePointAt);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void writePercentDecoded(m mVar, String str, int i7, int i8, boolean z7) {
            int i9;
            while (i7 < i8) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(i7);
                if (iCodePointAt == 37 && (i9 = i7 + 2) < i8) {
                    int iN = okhttp3.internal.d.N(str.charAt(i7 + 1));
                    int iN2 = okhttp3.internal.d.N(str.charAt(i9));
                    if (iN == -1 || iN2 == -1) {
                        mVar.x(iCodePointAt);
                        i7 += Character.charCount(iCodePointAt);
                    } else {
                        mVar.writeByte((iN << 4) + iN2);
                        i7 = Character.charCount(iCodePointAt) + i9;
                    }
                } else if (iCodePointAt == 43 && z7) {
                    mVar.writeByte(32);
                    i7++;
                } else {
                    mVar.x(iCodePointAt);
                    i7 += Character.charCount(iCodePointAt);
                }
            }
        }

        @a7.d
        @k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @h(name = "-deprecated_get")
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m72deprecated_get(@a7.d String url) {
            l0.p(url, "url");
            return get(url);
        }

        @k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @e
        @h(name = "-deprecated_parse")
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m75deprecated_parse(@a7.d String url) {
            l0.p(url, "url");
            return parse(url);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003e  */
        @a7.d
        public final String canonicalize$okhttp(@a7.d String canonicalize, int i7, int i8, @a7.d String encodeSet, boolean z7, boolean z8, boolean z9, boolean z10, @e Charset charset) {
            l0.p(canonicalize, "$this$canonicalize");
            l0.p(encodeSet, "encodeSet");
            int iCharCount = i7;
            while (true) {
                if (iCharCount >= i8) {
                    String strSubstring = canonicalize.substring(i7, i8);
                    l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return strSubstring;
                }
                int iCodePointAt = canonicalize.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z10) || c0.U2(encodeSet, (char) iCodePointAt, false, 2, null))) {
                    break;
                }
                if (iCodePointAt == 37) {
                    if (!z7) {
                        break;
                    }
                    if (z8) {
                        if (isPercentEncoded(canonicalize, iCharCount, i8)) {
                        }
                    }
                    if (iCodePointAt == 43) {
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                } else if (iCodePointAt == 43 || !z9) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
                m mVar = new m();
                mVar.B0(canonicalize, i7, iCharCount);
                writeCanonicalized(mVar, canonicalize, iCharCount, i8, encodeSet, z7, z8, z9, z10, charset);
                return mVar.m1();
            }
            m mVar2 = new m();
            mVar2.B0(canonicalize, i7, iCharCount);
            writeCanonicalized(mVar2, canonicalize, iCharCount, i8, encodeSet, z7, z8, z9, z10, charset);
            return mVar2.m1();
        }

        @l
        public final int defaultPort(@a7.d String scheme) {
            l0.p(scheme, "scheme");
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && scheme.equals(j0.b.f34226a)) {
                    return 443;
                }
            } else if (scheme.equals(com.haier.uhome.usdk.base.a.av)) {
                return 80;
            }
            return -1;
        }

        @a7.d
        @h(name = "get")
        @l
        public final HttpUrl get(@a7.d String toHttpUrl) {
            l0.p(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        @e
        @h(name = "parse")
        @l
        public final HttpUrl parse(@a7.d String toHttpUrlOrNull) {
            l0.p(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @a7.d
        public final String percentDecode$okhttp(@a7.d String percentDecode, int i7, int i8, boolean z7) {
            l0.p(percentDecode, "$this$percentDecode");
            for (int i9 = i7; i9 < i8; i9++) {
                char cCharAt = percentDecode.charAt(i9);
                if (cCharAt == '%' || (cCharAt == '+' && z7)) {
                    m mVar = new m();
                    mVar.B0(percentDecode, i7, i9);
                    writePercentDecoded(mVar, percentDecode, i9, i8, z7);
                    return mVar.m1();
                }
            }
            String strSubstring = percentDecode.substring(i7, i8);
            l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void toPathString$okhttp(@a7.d List<String> toPathString, @a7.d StringBuilder out) {
            l0.p(toPathString, "$this$toPathString");
            l0.p(out, "out");
            int size = toPathString.size();
            for (int i7 = 0; i7 < size; i7++) {
                out.append('/');
                out.append(toPathString.get(i7));
            }
        }

        @a7.d
        public final List<String> toQueryNamesAndValues$okhttp(@a7.d String toQueryNamesAndValues) {
            l0.p(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            while (i7 <= toQueryNamesAndValues.length()) {
                int iQ3 = c0.q3(toQueryNamesAndValues, h0.f35378d, i7, false, 4, null);
                if (iQ3 == -1) {
                    iQ3 = toQueryNamesAndValues.length();
                }
                int i8 = iQ3;
                int iQ4 = c0.q3(toQueryNamesAndValues, '=', i7, false, 4, null);
                if (iQ4 == -1 || iQ4 > i8) {
                    String strSubstring = toQueryNamesAndValues.substring(i7, i8);
                    l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = toQueryNamesAndValues.substring(i7, iQ4);
                    l0.o(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = toQueryNamesAndValues.substring(iQ4 + 1, i8);
                    l0.o(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i7 = i8 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(@a7.d List<String> toQueryString, @a7.d StringBuilder out) {
            l0.p(toQueryString, "$this$toQueryString");
            l0.p(out, "out");
            i iVarE1 = q.e1(q.z1(0, toQueryString.size()), 2);
            int iG = iVarE1.g();
            int iH = iVarE1.h();
            int iJ = iVarE1.j();
            if (iJ >= 0) {
                if (iG > iH) {
                    return;
                }
            } else if (iG < iH) {
                return;
            }
            while (true) {
                String str = toQueryString.get(iG);
                String str2 = toQueryString.get(iG + 1);
                if (iG > 0) {
                    out.append(h0.f35378d);
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (iG == iH) {
                    return;
                } else {
                    iG += iJ;
                }
            }
        }

        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @e
        @h(name = "-deprecated_get")
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m74deprecated_get(@a7.d URL url) {
            l0.p(url, "url");
            return get(url);
        }

        @e
        @h(name = "get")
        @l
        public final HttpUrl get(@a7.d URL toHttpUrlOrNull) {
            l0.p(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String string = toHttpUrlOrNull.toString();
            l0.o(string, "toString()");
            return parse(string);
        }

        @k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @e
        @h(name = "-deprecated_get")
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m73deprecated_get(@a7.d URI uri) {
            l0.p(uri, "uri");
            return get(uri);
        }

        @e
        @h(name = "get")
        @l
        public final HttpUrl get(@a7.d URI toHttpUrlOrNull) {
            l0.p(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String string = toHttpUrlOrNull.toString();
            l0.o(string, "toString()");
            return parse(string);
        }
    }

    public HttpUrl(@a7.d String scheme, @a7.d String username, @a7.d String password, @a7.d String host, int i7, @a7.d List<String> pathSegments, @e List<String> list, @e String str, @a7.d String url) {
        l0.p(scheme, "scheme");
        l0.p(username, "username");
        l0.p(password, "password");
        l0.p(host, "host");
        l0.p(pathSegments, "pathSegments");
        l0.p(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i7;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = l0.g(scheme, j0.b.f34226a);
    }

    @l
    public static final int defaultPort(@a7.d String str) {
        return Companion.defaultPort(str);
    }

    @a7.d
    @h(name = "get")
    @l
    public static final HttpUrl get(@a7.d String str) {
        return Companion.get(str);
    }

    @e
    @h(name = "parse")
    @l
    public static final HttpUrl parse(@a7.d String str) {
        return Companion.parse(str);
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "encodedFragment", imports = {}))
    @e
    @h(name = "-deprecated_encodedFragment")
    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m53deprecated_encodedFragment() {
        return encodedFragment();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "encodedPassword", imports = {}))
    @h(name = "-deprecated_encodedPassword")
    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m54deprecated_encodedPassword() {
        return encodedPassword();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "encodedPath", imports = {}))
    @h(name = "-deprecated_encodedPath")
    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m55deprecated_encodedPath() {
        return encodedPath();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "encodedPathSegments", imports = {}))
    @h(name = "-deprecated_encodedPathSegments")
    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m56deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "encodedQuery", imports = {}))
    @e
    @h(name = "-deprecated_encodedQuery")
    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m57deprecated_encodedQuery() {
        return encodedQuery();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "encodedUsername", imports = {}))
    @h(name = "-deprecated_encodedUsername")
    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m58deprecated_encodedUsername() {
        return encodedUsername();
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "fragment", imports = {}))
    @e
    @h(name = "-deprecated_fragment")
    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m59deprecated_fragment() {
        return this.fragment;
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = c.f34242f, imports = {}))
    @h(name = "-deprecated_host")
    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m60deprecated_host() {
        return this.host;
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "password", imports = {}))
    @h(name = "-deprecated_password")
    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m61deprecated_password() {
        return this.password;
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "pathSegments", imports = {}))
    @h(name = "-deprecated_pathSegments")
    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m62deprecated_pathSegments() {
        return this.pathSegments;
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "pathSize", imports = {}))
    @h(name = "-deprecated_pathSize")
    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m63deprecated_pathSize() {
        return pathSize();
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "port", imports = {}))
    @h(name = "-deprecated_port")
    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m64deprecated_port() {
        return this.port;
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = d.f11283b, imports = {}))
    @e
    @h(name = "-deprecated_query")
    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m65deprecated_query() {
        return query();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "queryParameterNames", imports = {}))
    @h(name = "-deprecated_queryParameterNames")
    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m66deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "querySize", imports = {}))
    @h(name = "-deprecated_querySize")
    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m67deprecated_querySize() {
        return querySize();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "scheme", imports = {}))
    @h(name = "-deprecated_scheme")
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m68deprecated_scheme() {
        return this.scheme;
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to toUri()", replaceWith = @b1(expression = "toUri()", imports = {}))
    @h(name = "-deprecated_uri")
    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m69deprecated_uri() {
        return uri();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to toUrl()", replaceWith = @b1(expression = "toUrl()", imports = {}))
    @h(name = "-deprecated_url")
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m70deprecated_url() {
        return url();
    }

    @a7.d
    @k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "username", imports = {}))
    @h(name = "-deprecated_username")
    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m71deprecated_username() {
        return this.username;
    }

    @e
    @h(name = "encodedFragment")
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int iQ3 = c0.q3(this.url, '#', 0, false, 6, null) + 1;
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iQ3);
        l0.o(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @a7.d
    @h(name = "encodedPassword")
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int iQ3 = c0.q3(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1;
        int iQ4 = c0.q3(this.url, '@', 0, false, 6, null);
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iQ3, iQ4);
        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @a7.d
    @h(name = "encodedPath")
    public final String encodedPath() {
        int iQ3 = c0.q3(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int iQ = okhttp3.internal.d.q(str, "?#", iQ3, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iQ3, iQ);
        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @a7.d
    @h(name = "encodedPathSegments")
    public final List<String> encodedPathSegments() {
        int iQ3 = c0.q3(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int iQ = okhttp3.internal.d.q(str, "?#", iQ3, str.length());
        ArrayList arrayList = new ArrayList();
        while (iQ3 < iQ) {
            int i7 = iQ3 + 1;
            int iP = okhttp3.internal.d.p(this.url, '/', i7, iQ);
            String str2 = this.url;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i7, iP);
            l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iQ3 = iP;
        }
        return arrayList;
    }

    @e
    @h(name = "encodedQuery")
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iQ3 = c0.q3(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        int iP = okhttp3.internal.d.p(str, '#', iQ3, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iQ3, iP);
        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @a7.d
    @h(name = "encodedUsername")
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iQ = okhttp3.internal.d.q(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iQ);
        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(@e Object obj) {
        return (obj instanceof HttpUrl) && l0.g(((HttpUrl) obj).url, this.url);
    }

    @e
    @h(name = "fragment")
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @a7.d
    @h(name = c.f34242f)
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @a7.d
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    @a7.d
    @h(name = "password")
    public final String password() {
        return this.password;
    }

    @a7.d
    @h(name = "pathSegments")
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @h(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @h(name = "port")
    public final int port() {
        return this.port;
    }

    @e
    @h(name = d.f11283b)
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    @e
    public final String queryParameter(@a7.d String name) {
        l0.p(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        i iVarE1 = q.e1(q.z1(0, list.size()), 2);
        int iG = iVarE1.g();
        int iH = iVarE1.h();
        int iJ = iVarE1.j();
        if (iJ < 0 ? iG >= iH : iG <= iH) {
            while (!l0.g(name, this.queryNamesAndValues.get(iG))) {
                if (iG != iH) {
                    iG += iJ;
                }
            }
            return this.queryNamesAndValues.get(iG + 1);
        }
        return null;
    }

    @a7.d
    public final String queryParameterName(int i7) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i7 * 2);
        l0.m(str);
        return str;
    }

    @a7.d
    @h(name = "queryParameterNames")
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return n1.k();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        i iVarE1 = q.e1(q.z1(0, this.queryNamesAndValues.size()), 2);
        int iG = iVarE1.g();
        int iH = iVarE1.h();
        int iJ = iVarE1.j();
        if (iJ < 0 ? iG >= iH : iG <= iH) {
            while (true) {
                String str = this.queryNamesAndValues.get(iG);
                l0.m(str);
                linkedHashSet.add(str);
                if (iG == iH) {
                    break;
                }
                iG += iJ;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        l0.o(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    @e
    public final String queryParameterValue(int i7) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i7 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @a7.d
    public final List<String> queryParameterValues(@a7.d String name) {
        l0.p(name, "name");
        if (this.queryNamesAndValues == null) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList();
        i iVarE1 = q.e1(q.z1(0, this.queryNamesAndValues.size()), 2);
        int iG = iVarE1.g();
        int iH = iVarE1.h();
        int iJ = iVarE1.j();
        if (iJ < 0 ? iG >= iH : iG <= iH) {
            while (true) {
                if (l0.g(name, this.queryNamesAndValues.get(iG))) {
                    arrayList.add(this.queryNamesAndValues.get(iG + 1));
                }
                if (iG == iH) {
                    break;
                }
                iG += iJ;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        l0.o(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    @h(name = "querySize")
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @a7.d
    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        l0.m(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    @e
    public final HttpUrl resolve(@a7.d String link) {
        l0.p(link, "link");
        Builder builderNewBuilder = newBuilder(link);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    @a7.d
    @h(name = "scheme")
    public final String scheme() {
        return this.scheme;
    }

    @a7.d
    public String toString() {
        return this.url;
    }

    @e
    public final String topPrivateDomain() {
        if (okhttp3.internal.d.h(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.f38290j.c().e(this.host);
    }

    @a7.d
    @h(name = ShareConstants.MEDIA_URI)
    public final URI uri() {
        String string = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e8) {
            try {
                URI uriCreate = URI.create(new o("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").n(string, ""));
                l0.o(uriCreate, "try {\n        val stripp…e) // Unexpected!\n      }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e8);
            }
        }
    }

    @a7.d
    @h(name = "url")
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e8) {
            throw new RuntimeException(e8);
        }
    }

    @a7.d
    @h(name = "username")
    public final String username() {
        return this.username;
    }

    @e
    @h(name = "get")
    @l
    public static final HttpUrl get(@a7.d URI uri) {
        return Companion.get(uri);
    }

    @e
    @h(name = "get")
    @l
    public static final HttpUrl get(@a7.d URL url) {
        return Companion.get(url);
    }

    @e
    public final Builder newBuilder(@a7.d String link) {
        l0.p(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
