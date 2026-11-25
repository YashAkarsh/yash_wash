package com.google.common.net;

import com.google.common.base.a0;
import com.google.common.base.e0;
import com.google.common.base.s;
import com.google.common.base.w;
import com.google.common.base.x;
import com.google.common.base.y;
import com.google.common.collect.cd;
import com.google.common.collect.ck;
import com.google.common.collect.p8;
import com.google.common.collect.q7;
import com.google.common.collect.tc;
import com.google.common.collect.u8;
import com.google.common.collect.wb;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.h0;
import org.apache.http.entity.mime.MIME;
import u1.j;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@j
@s1.b
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f22228g = "charset";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f22249n = "image";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f22252o = "text";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f22254p = "video";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q7<String, String> f22278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @v1.b
    private String f22279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @v1.b
    private int f22280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @v1.b
    private a0<Charset> f22281f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final q7<String, String> f22231h = q7.n0("charset", com.google.common.base.c.g(com.google.common.base.f.f19383c.name()));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final com.google.common.base.e f22234i = com.google.common.base.e.f().b(com.google.common.base.e.v().negate()).b(com.google.common.base.e.s(' ')).b(com.google.common.base.e.H("()<>@,;:\\\"/[]?="));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final com.google.common.base.e f22237j = com.google.common.base.e.f().b(com.google.common.base.e.H("\"\\\r"));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final com.google.common.base.e f22240k = com.google.common.base.e.d(" \t\r\n");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Map<f, f> f22258r = wb.i0();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f22256q = "*";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f f22260s = j(f22256q, f22256q);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final f f22262t = j("text", f22256q);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final f f22264u = j("image", f22256q);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f22246m = "audio";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f f22266v = j(f22246m, f22256q);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f f22268w = j("video", f22256q);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f22243l = "application";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f22270x = j(f22243l, f22256q);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f f22272y = k("text", "cache-manifest");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f f22274z = k("text", "css");
    public static final f A = k("text", "csv");
    public static final f B = k("text", "html");
    public static final f C = k("text", "calendar");
    public static final f D = k("text", "plain");
    public static final f E = k("text", "javascript");
    public static final f F = k("text", "tab-separated-values");
    public static final f G = k("text", "vcard");
    public static final f H = k("text", "vnd.wap.wml");
    public static final f I = k("text", "xml");

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final f f22215J = k("text", "vtt");
    public static final f K = j("image", "bmp");
    public static final f L = j("image", "x-canon-crw");
    public static final f M = j("image", "gif");
    public static final f N = j("image", "vnd.microsoft.icon");
    public static final f O = j("image", "jpeg");
    public static final f P = j("image", "png");
    public static final f Q = j("image", "vnd.adobe.photoshop");
    public static final f R = k("image", "svg+xml");
    public static final f S = j("image", "tiff");
    public static final f T = j("image", "webp");
    public static final f U = j(f22246m, "mp4");
    public static final f V = j(f22246m, "mpeg");
    public static final f W = j(f22246m, "ogg");
    public static final f X = j(f22246m, "webm");
    public static final f Y = j(f22246m, "l16");
    public static final f Z = j(f22246m, "l24");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final f f22216a0 = j(f22246m, "basic");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final f f22218b0 = j(f22246m, "aac");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final f f22220c0 = j(f22246m, "vorbis");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final f f22222d0 = j(f22246m, "x-ms-wma");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final f f22224e0 = j(f22246m, "x-ms-wax");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final f f22226f0 = j(f22246m, "vnd.rn-realaudio");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final f f22229g0 = j(f22246m, "vnd.wave");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final f f22232h0 = j("video", "mp4");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final f f22235i0 = j("video", "mpeg");

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final f f22238j0 = j("video", "ogg");

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final f f22241k0 = j("video", "quicktime");

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final f f22244l0 = j("video", "webm");

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final f f22247m0 = j("video", "x-ms-wmv");

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final f f22250n0 = j("video", "x-flv");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final f f22253o0 = j("video", "3gpp");

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final f f22255p0 = j("video", "3gpp2");

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final f f22257q0 = k(f22243l, "xml");

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final f f22259r0 = k(f22243l, "atom+xml");

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final f f22261s0 = j(f22243l, "x-bzip2");

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final f f22263t0 = k(f22243l, "dart");

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final f f22265u0 = j(f22243l, "vnd.apple.pkpass");

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final f f22267v0 = j(f22243l, "vnd.ms-fontobject");

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final f f22269w0 = j(f22243l, "epub+zip");

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final f f22271x0 = j(f22243l, "x-www-form-urlencoded");

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final f f22273y0 = j(f22243l, "pkcs12");

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final f f22275z0 = j(f22243l, MIME.ENC_BINARY);
    public static final f A0 = j(f22243l, "x-gzip");
    public static final f B0 = j(f22243l, "hal+json");
    public static final f C0 = k(f22243l, "javascript");
    public static final f D0 = k(f22243l, "json");
    public static final f E0 = k(f22243l, "manifest+json");
    public static final f F0 = j(f22243l, "vnd.google-earth.kml+xml");
    public static final f G0 = j(f22243l, "vnd.google-earth.kmz");
    public static final f H0 = j(f22243l, "mbox");
    public static final f I0 = j(f22243l, "x-apple-aspen-config");
    public static final f J0 = j(f22243l, "vnd.ms-excel");
    public static final f K0 = j(f22243l, "vnd.ms-powerpoint");
    public static final f L0 = j(f22243l, "msword");
    public static final f M0 = j(f22243l, "wasm");
    public static final f N0 = j(f22243l, "x-nacl");
    public static final f O0 = j(f22243l, "x-pnacl");
    public static final f P0 = j(f22243l, "octet-stream");
    public static final f Q0 = j(f22243l, "ogg");
    public static final f R0 = j(f22243l, "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final f S0 = j(f22243l, "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final f T0 = j(f22243l, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final f U0 = j(f22243l, "vnd.oasis.opendocument.graphics");
    public static final f V0 = j(f22243l, "vnd.oasis.opendocument.presentation");
    public static final f W0 = j(f22243l, "vnd.oasis.opendocument.spreadsheet");
    public static final f X0 = j(f22243l, "vnd.oasis.opendocument.text");
    public static final f Y0 = j(f22243l, "pdf");
    public static final f Z0 = j(f22243l, "postscript");

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final f f22217a1 = j(f22243l, "protobuf");

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final f f22219b1 = k(f22243l, "rdf+xml");

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final f f22221c1 = k(f22243l, "rtf");

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final f f22223d1 = j(f22243l, "font-sfnt");

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final f f22225e1 = j(f22243l, "x-shockwave-flash");

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final f f22227f1 = j(f22243l, "vnd.sketchup.skp");

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final f f22230g1 = k(f22243l, "soap+xml");

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final f f22233h1 = j(f22243l, "x-tar");

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final f f22236i1 = j(f22243l, "font-woff");

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final f f22239j1 = j(f22243l, "font-woff2");

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final f f22242k1 = k(f22243l, "xhtml+xml");

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final f f22245l1 = k(f22243l, "xrd+xml");

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final f f22248m1 = j(f22243l, "zip");

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private static final w.d f22251n1 = w.p("; ").u("=");

    class a implements s<Collection<String>, p8<String>> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p8<String> apply(Collection<String> collection) {
            return p8.t(collection);
        }
    }

    class b implements s<String, String> {
        b() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return f.f22234i.C(str) ? str : f.o(str);
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f22284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f22285b = 0;

        c(String str) {
            this.f22284a = str;
        }

        char a(char c8) {
            e0.g0(e());
            e0.g0(f() == c8);
            this.f22285b++;
            return c8;
        }

        char b(com.google.common.base.e eVar) {
            e0.g0(e());
            char cF = f();
            e0.g0(eVar.B(cF));
            this.f22285b++;
            return cF;
        }

        String c(com.google.common.base.e eVar) {
            int i7 = this.f22285b;
            String strD = d(eVar);
            e0.g0(this.f22285b != i7);
            return strD;
        }

        String d(com.google.common.base.e eVar) {
            e0.g0(e());
            int i7 = this.f22285b;
            this.f22285b = eVar.negate().o(this.f22284a, i7);
            return e() ? this.f22284a.substring(i7, this.f22285b) : this.f22284a.substring(i7);
        }

        boolean e() {
            int i7 = this.f22285b;
            return i7 >= 0 && i7 < this.f22284a.length();
        }

        char f() {
            e0.g0(e());
            return this.f22284a.charAt(this.f22285b);
        }
    }

    private f(String str, String str2, q7<String, String> q7Var) {
        this.f22276a = str;
        this.f22277b = str2;
        this.f22278c = q7Var;
    }

    private static f c(f fVar) {
        f22258r.put(fVar, fVar);
        return fVar;
    }

    private String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22276a);
        sb.append('/');
        sb.append(this.f22277b);
        if (!this.f22278c.isEmpty()) {
            sb.append("; ");
            f22251n1.d(sb, cd.O(this.f22278c, new b()).y());
        }
        return sb.toString();
    }

    public static f f(String str, String str2) {
        f fVarG = g(str, str2, q7.m0());
        fVarG.f22281f = a0.a();
        return fVarG;
    }

    private static f g(String str, String str2, tc<String, String> tcVar) {
        e0.E(str);
        e0.E(str2);
        e0.E(tcVar);
        String strS = s(str);
        String strS2 = s(str2);
        e0.e(!f22256q.equals(strS) || f22256q.equals(strS2), "A wildcard type cannot be used with a non-wildcard subtype");
        q7.a aVarB0 = q7.b0();
        for (Map.Entry<String, String> entry : tcVar.y()) {
            String strS3 = s(entry.getKey());
            aVarB0.f(strS3, r(strS3, entry.getValue()));
        }
        f fVar = new f(strS, strS2, aVarB0.a());
        return (f) x.a(f22258r.get(fVar), fVar);
    }

    static f h(String str) {
        return f(f22243l, str);
    }

    static f i(String str) {
        return f(f22246m, str);
    }

    private static f j(String str, String str2) {
        f fVarC = c(new f(str, str2, q7.m0()));
        fVarC.f22281f = a0.a();
        return fVarC;
    }

    private static f k(String str, String str2) {
        f fVarC = c(new f(str, str2, f22231h));
        fVarC.f22281f = a0.g(com.google.common.base.f.f19383c);
        return fVarC;
    }

    static f l(String str) {
        return f("image", str);
    }

    static f m(String str) {
        return f("text", str);
    }

    static f n(String str) {
        return f("video", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String o(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append(h0.f35376b);
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '\r' || cCharAt == '\\' || cCharAt == '\"') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        sb.append(h0.f35376b);
        return sb.toString();
    }

    private static String r(String str, String str2) {
        return "charset".equals(str) ? com.google.common.base.c.g(str2) : str2;
    }

    private static String s(String str) {
        e0.d(f22234i.C(str));
        return com.google.common.base.c.g(str);
    }

    private Map<String, p8<String>> u() {
        return wb.N0(this.f22278c.asMap(), new a());
    }

    public static f v(String str) {
        String strC;
        e0.E(str);
        c cVar = new c(str);
        try {
            com.google.common.base.e eVar = f22234i;
            String strC2 = cVar.c(eVar);
            cVar.a('/');
            String strC3 = cVar.c(eVar);
            q7.a aVarB0 = q7.b0();
            while (cVar.e()) {
                com.google.common.base.e eVar2 = f22240k;
                cVar.d(eVar2);
                cVar.a(';');
                cVar.d(eVar2);
                com.google.common.base.e eVar3 = f22234i;
                String strC4 = cVar.c(eVar3);
                cVar.a('=');
                if ('\"' == cVar.f()) {
                    cVar.a(h0.f35376b);
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != cVar.f()) {
                        if ('\\' == cVar.f()) {
                            cVar.a('\\');
                            sb.append(cVar.b(com.google.common.base.e.f()));
                        } else {
                            sb.append(cVar.c(f22237j));
                        }
                    }
                    strC = sb.toString();
                    cVar.a(h0.f35376b);
                } else {
                    strC = cVar.c(eVar3);
                }
                aVarB0.f(strC4, strC);
            }
            return g(strC2, strC3, aVarB0.a());
        } catch (IllegalStateException e8) {
            throw new IllegalArgumentException("Could not parse '" + str + "'", e8);
        }
    }

    public f A(tc<String, String> tcVar) {
        return g(this.f22276a, this.f22277b, tcVar);
    }

    public f B(String str, Iterable<String> iterable) {
        e0.E(str);
        e0.E(iterable);
        String strS = s(str);
        q7.a aVarB0 = q7.b0();
        ck<Map.Entry<String, String>> it = this.f22278c.y().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!strS.equals(key)) {
                aVarB0.f(key, next.getValue());
            }
        }
        Iterator<String> it2 = iterable.iterator();
        while (it2.hasNext()) {
            aVarB0.f(strS, r(strS, it2.next()));
        }
        f fVar = new f(this.f22276a, this.f22277b, aVarB0.a());
        if (!strS.equals("charset")) {
            fVar.f22281f = this.f22281f;
        }
        return (f) x.a(f22258r.get(fVar), fVar);
    }

    public f C() {
        return this.f22278c.isEmpty() ? this : f(this.f22276a, this.f22277b);
    }

    public a0<Charset> d() {
        a0<Charset> a0VarA = this.f22281f;
        if (a0VarA == null) {
            a0VarA = a0.a();
            ck<String> it = this.f22278c.get("charset").iterator();
            String str = null;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    a0VarA = a0.g(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    throw new IllegalStateException("Multiple charset values defined: " + str + ", " + next);
                }
            }
            this.f22281f = a0VarA;
        }
        return a0VarA;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f22276a.equals(fVar.f22276a) && this.f22277b.equals(fVar.f22277b) && u().equals(fVar.u());
    }

    public int hashCode() {
        int i7 = this.f22280e;
        if (i7 != 0) {
            return i7;
        }
        int iB = y.b(this.f22276a, this.f22277b, u());
        this.f22280e = iB;
        return iB;
    }

    public boolean p() {
        return f22256q.equals(this.f22276a) || f22256q.equals(this.f22277b);
    }

    public boolean q(f fVar) {
        return (fVar.f22276a.equals(f22256q) || fVar.f22276a.equals(this.f22276a)) && (fVar.f22277b.equals(f22256q) || fVar.f22277b.equals(this.f22277b)) && this.f22278c.y().containsAll(fVar.f22278c.y());
    }

    public q7<String, String> t() {
        return this.f22278c;
    }

    public String toString() {
        String str = this.f22279d;
        if (str != null) {
            return str;
        }
        String strE = e();
        this.f22279d = strE;
        return strE;
    }

    public String w() {
        return this.f22277b;
    }

    public String x() {
        return this.f22276a;
    }

    public f y(Charset charset) {
        e0.E(charset);
        f fVarZ = z("charset", charset.name());
        fVarZ.f22281f = a0.g(charset);
        return fVarZ;
    }

    public f z(String str, String str2) {
        return B(str, u8.B(str2));
    }
}
