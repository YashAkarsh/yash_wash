package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;

/* JADX INFO: loaded from: classes2.dex */
final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Matcher f35404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final CharSequence f35405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final k f35406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private List<String> f35407d;

    public static final class a extends kotlin.collections.c<String> {
        a() {
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return n.this.f().groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String get(int i7) {
            String strGroup = n.this.f().group(i7);
            return strGroup == null ? "" : strGroup;
        }

        public /* bridge */ int f(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int g(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            return -1;
        }
    }

    public static final class b extends kotlin.collections.a<j> implements l {

        static final class a extends n0 implements i5.l<Integer, j> {
            a() {
                super(1);
            }

            @a7.e
            public final j b(int i7) {
                return b.this.get(i7);
            }

            @Override // i5.l
            public /* bridge */ /* synthetic */ j z(Integer num) {
                return b(num.intValue());
            }
        }

        b() {
        }

        @Override // kotlin.collections.a
        public int a() {
            return n.this.f().groupCount() + 1;
        }

        public /* bridge */ boolean b(j jVar) {
            return super.contains(jVar);
        }

        @Override // kotlin.text.l
        @a7.e
        public j c(@a7.d String name) {
            l0.p(name, "name");
            return kotlin.internal.m.f34747a.c(n.this.f(), name);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof j) {
                return b((j) obj);
            }
            return false;
        }

        @Override // kotlin.text.k
        @a7.e
        public j get(int i7) {
            kotlin.ranges.k kVarJ = p.j(n.this.f(), i7);
            if (kVarJ.d().intValue() < 0) {
                return null;
            }
            String strGroup = n.this.f().group(i7);
            l0.o(strGroup, "matchResult.group(index)");
            return new j(strGroup, kVarJ);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @a7.d
        public Iterator<j> iterator() {
            return kotlin.sequences.u.k1(kotlin.collections.g0.v1(kotlin.collections.y.G(this)), new a()).iterator();
        }
    }

    public n(@a7.d Matcher matcher, @a7.d CharSequence input) {
        l0.p(matcher, "matcher");
        l0.p(input, "input");
        this.f35404a = matcher;
        this.f35405b = input;
        this.f35406c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult f() {
        return this.f35404a;
    }

    @Override // kotlin.text.m
    @a7.d
    public m.b a() {
        return m.a.a(this);
    }

    @Override // kotlin.text.m
    @a7.d
    public List<String> b() {
        if (this.f35407d == null) {
            this.f35407d = new a();
        }
        List<String> list = this.f35407d;
        l0.m(list);
        return list;
    }

    @Override // kotlin.text.m
    @a7.d
    public k c() {
        return this.f35406c;
    }

    @Override // kotlin.text.m
    @a7.d
    public kotlin.ranges.k d() {
        return p.i(f());
    }

    @Override // kotlin.text.m
    @a7.d
    public String getValue() {
        String strGroup = f().group();
        l0.o(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.m
    @a7.e
    public m next() {
        int iEnd = f().end() + (f().end() == f().start() ? 1 : 0);
        if (iEnd > this.f35405b.length()) {
            return null;
        }
        Matcher matcher = this.f35404a.pattern().matcher(this.f35405b);
        l0.o(matcher, "matcher.pattern().matcher(input)");
        return p.f(matcher, iEnd, this.f35405b);
    }
}
