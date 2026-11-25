package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f8848j = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f8849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, c> f8850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Pattern f8851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f8855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Pattern f8856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f8857i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f8859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f8860c;

        a() {
        }

        @m0
        public static a b(@m0 String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            a aVar = new a();
            aVar.e(str);
            return aVar;
        }

        @m0
        public static a c(@m0 String str) {
            a aVar = new a();
            aVar.f(str);
            return aVar;
        }

        @m0
        public static a d(@m0 String str) {
            a aVar = new a();
            aVar.g(str);
            return aVar;
        }

        @m0
        public i a() {
            return new i(this.f8858a, this.f8859b, this.f8860c);
        }

        @m0
        public a e(@m0 String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.f8859b = str;
            return this;
        }

        @m0
        public a f(@m0 String str) {
            this.f8860c = str;
            return this;
        }

        @m0
        public a g(@m0 String str) {
            this.f8858a = str;
            return this;
        }
    }

    private static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f8862b;

        b(@m0 String str) {
            String[] strArrSplit = str.split("/", -1);
            this.f8861a = strArrSplit[0];
            this.f8862b = strArrSplit[1];
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@m0 b bVar) {
            int i7 = this.f8861a.equals(bVar.f8861a) ? 2 : 0;
            return this.f8862b.equals(bVar.f8862b) ? i7 + 1 : i7;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<String> f8864b = new ArrayList<>();

        c() {
        }

        void a(String str) {
            this.f8864b.add(str);
        }

        String b(int i7) {
            return this.f8864b.get(i7);
        }

        String c() {
            return this.f8863a;
        }

        void d(String str) {
            this.f8863a = str;
        }

        public int e() {
            return this.f8864b.size();
        }
    }

    i(@o0 String str, @o0 String str2, @o0 String str3) {
        this.f8849a = new ArrayList<>();
        this.f8850b = new HashMap();
        this.f8851c = null;
        int i7 = 0;
        this.f8852d = false;
        this.f8853e = false;
        this.f8856h = null;
        this.f8854f = str;
        this.f8855g = str2;
        this.f8857i = str3;
        if (str != null) {
            Uri uri = Uri.parse(str);
            this.f8853e = uri.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!f8848j.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern patternCompile = Pattern.compile("\\{(.+?)\\}");
            if (this.f8853e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, patternCompile);
                }
                this.f8852d = false;
                for (String str4 : uri.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = uri.getQueryParameter(str4);
                    Matcher matcher2 = patternCompile.matcher(queryParameter);
                    c cVar = new c();
                    int iEnd = i7;
                    while (matcher2.find()) {
                        cVar.a(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(iEnd, matcher2.start())));
                        sb2.append("(.+?)?");
                        iEnd = matcher2.end();
                    }
                    if (iEnd < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(iEnd)));
                    }
                    cVar.d(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.f8850b.put(str4, cVar);
                    i7 = 0;
                }
            } else {
                this.f8852d = a(str, sb, patternCompile);
            }
            this.f8851c = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
            }
            b bVar = new b(str3);
            this.f8856h = Pattern.compile(("^(" + bVar.f8861a + "|[*]+)/(" + bVar.f8862b + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
        }
    }

    private boolean a(@m0 String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z7 = !str.contains(".*");
        int iEnd = 0;
        while (matcher.find()) {
            this.f8849a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(iEnd, matcher.start())));
            sb.append("(.+?)");
            iEnd = matcher.end();
            z7 = false;
        }
        if (iEnd < str.length()) {
            sb.append(Pattern.quote(str.substring(iEnd)));
        }
        sb.append("($|(\\?(.)*))");
        return z7;
    }

    private boolean h(String str) {
        boolean z7 = str == null;
        String str2 = this.f8855g;
        if (z7 == (str2 != null)) {
            return false;
        }
        return str == null || str2.equals(str);
    }

    private boolean i(String str) {
        if ((str == null) == (this.f8857i != null)) {
            return false;
        }
        return str == null || this.f8856h.matcher(str).matches();
    }

    private boolean j(Uri uri) {
        boolean z7 = uri == null;
        Pattern pattern = this.f8851c;
        if (z7 == (pattern != null)) {
            return false;
        }
        return uri == null || pattern.matcher(uri.toString()).matches();
    }

    private boolean m(Bundle bundle, String str, String str2, f fVar) {
        if (fVar == null) {
            bundle.putString(str, str2);
            return false;
        }
        try {
            fVar.b().g(bundle, str, str2);
            return false;
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    @o0
    public String b() {
        return this.f8855g;
    }

    @o0
    Bundle c(@m0 Uri uri, @m0 Map<String, f> map) {
        Matcher matcher;
        Matcher matcher2 = this.f8851c.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f8849a.size();
        int i7 = 0;
        while (i7 < size) {
            String str = this.f8849a.get(i7);
            i7++;
            if (m(bundle, str, Uri.decode(matcher2.group(i7)), map.get(str))) {
                return null;
            }
        }
        if (this.f8853e) {
            for (String str2 : this.f8850b.keySet()) {
                c cVar = this.f8850b.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(cVar.c()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i8 = 0; i8 < cVar.e(); i8++) {
                    String strDecode = matcher != null ? Uri.decode(matcher.group(i8 + 1)) : null;
                    String strB = cVar.b(i8);
                    f fVar = map.get(strB);
                    if (fVar != null && (strDecode == null || strDecode.replaceAll("[{}]", "").equals(strB))) {
                        if (fVar.a() != null) {
                            strDecode = fVar.a().toString();
                        } else if (fVar.d()) {
                            strDecode = null;
                        }
                    }
                    if (m(bundle, strB, strDecode, fVar)) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }

    @o0
    public String d() {
        return this.f8857i;
    }

    int e(@m0 String str) {
        if (this.f8857i == null || !this.f8856h.matcher(str).matches()) {
            return -1;
        }
        return new b(this.f8857i).compareTo(new b(str));
    }

    @o0
    public String f() {
        return this.f8854f;
    }

    boolean g() {
        return this.f8852d;
    }

    boolean k(@m0 Uri uri) {
        return l(new k(uri, null, null));
    }

    boolean l(@m0 k kVar) {
        if (j(kVar.c()) && h(kVar.a())) {
            return i(kVar.b());
        }
        return false;
    }

    i(@m0 String str) {
        this(str, null, null);
    }
}
