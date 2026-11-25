package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.base.e f19441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f19443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19444d;

    static class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.e f19445a;

        /* JADX INFO: renamed from: com.google.common.base.k0$a$a, reason: collision with other inner class name */
        class C0226a extends g {
            C0226a(k0 k0Var, CharSequence charSequence) {
                super(k0Var, charSequence);
            }

            @Override // com.google.common.base.k0.g
            int e(int i7) {
                return i7 + 1;
            }

            @Override // com.google.common.base.k0.g
            int f(int i7) {
                return a.this.f19445a.o(this.f19459c, i7);
            }
        }

        a(com.google.common.base.e eVar) {
            this.f19445a = eVar;
        }

        @Override // com.google.common.base.k0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(k0 k0Var, CharSequence charSequence) {
            return new C0226a(k0Var, charSequence);
        }
    }

    static class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19447a;

        class a extends g {
            a(k0 k0Var, CharSequence charSequence) {
                super(k0Var, charSequence);
            }

            @Override // com.google.common.base.k0.g
            public int e(int i7) {
                return i7 + b.this.f19447a.length();
            }

            @Override // com.google.common.base.k0.g
            public int f(int i7) {
                int length = b.this.f19447a.length();
                int length2 = this.f19459c.length() - length;
                while (i7 <= length2) {
                    for (int i8 = 0; i8 < length; i8++) {
                        if (this.f19459c.charAt(i8 + i7) != b.this.f19447a.charAt(i8)) {
                            i7++;
                        }
                    }
                    return i7;
                }
                return -1;
            }
        }

        b(String str) {
            this.f19447a = str;
        }

        @Override // com.google.common.base.k0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(k0 k0Var, CharSequence charSequence) {
            return new a(k0Var, charSequence);
        }
    }

    static class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.h f19449a;

        class a extends g {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.google.common.base.g f19450h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k0 k0Var, CharSequence charSequence, com.google.common.base.g gVar) {
                super(k0Var, charSequence);
                this.f19450h = gVar;
            }

            @Override // com.google.common.base.k0.g
            public int e(int i7) {
                return this.f19450h.a();
            }

            @Override // com.google.common.base.k0.g
            public int f(int i7) {
                if (this.f19450h.c(i7)) {
                    return this.f19450h.f();
                }
                return -1;
            }
        }

        c(com.google.common.base.h hVar) {
            this.f19449a = hVar;
        }

        @Override // com.google.common.base.k0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(k0 k0Var, CharSequence charSequence) {
            return new a(k0Var, charSequence, this.f19449a.d(charSequence));
        }
    }

    static class d implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19452a;

        class a extends g {
            a(k0 k0Var, CharSequence charSequence) {
                super(k0Var, charSequence);
            }

            @Override // com.google.common.base.k0.g
            public int e(int i7) {
                return i7;
            }

            @Override // com.google.common.base.k0.g
            public int f(int i7) {
                int i8 = i7 + d.this.f19452a;
                if (i8 < this.f19459c.length()) {
                    return i8;
                }
                return -1;
            }
        }

        d(int i7) {
            this.f19452a = i7;
        }

        @Override // com.google.common.base.k0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(k0 k0Var, CharSequence charSequence) {
            return new a(k0Var, charSequence);
        }
    }

    class e implements Iterable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f19454a;

        e(CharSequence charSequence) {
            this.f19454a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return k0.this.p(this.f19454a);
        }

        public String toString() {
            w wVarP = w.p(", ");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            StringBuilder sbF = wVarP.f(sb, this);
            sbF.append(']');
            return sbF.toString();
        }
    }

    @s1.a
    public static final class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f19456c = "Chunk [%s] is not a valid entry";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k0 f19457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k0 f19458b;

        /* synthetic */ f(k0 k0Var, k0 k0Var2, a aVar) {
            this(k0Var, k0Var2);
        }

        public Map<String, String> a(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f19457a.n(charSequence)) {
                Iterator itP = this.f19458b.p(str);
                e0.u(itP.hasNext(), f19456c, str);
                String str2 = (String) itP.next();
                e0.u(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                e0.u(itP.hasNext(), f19456c, str);
                linkedHashMap.put(str2, (String) itP.next());
                e0.u(!itP.hasNext(), f19456c, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        private f(k0 k0Var, k0 k0Var2) {
            this.f19457a = k0Var;
            this.f19458b = (k0) e0.E(k0Var2);
        }
    }

    private static abstract class g extends com.google.common.base.b<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f19459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.google.common.base.e f19460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f19461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f19462f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f19463g;

        protected g(k0 k0Var, CharSequence charSequence) {
            this.f19460d = k0Var.f19441a;
            this.f19461e = k0Var.f19442b;
            this.f19463g = k0Var.f19444d;
            this.f19459c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int i7 = this.f19462f;
            while (true) {
                int i8 = this.f19462f;
                if (i8 == -1) {
                    return b();
                }
                int iF = f(i8);
                if (iF == -1) {
                    iF = this.f19459c.length();
                    this.f19462f = -1;
                } else {
                    this.f19462f = e(iF);
                }
                int i9 = this.f19462f;
                if (i9 == i7) {
                    int i10 = i9 + 1;
                    this.f19462f = i10;
                    if (i10 > this.f19459c.length()) {
                        this.f19462f = -1;
                    }
                } else {
                    while (i7 < iF && this.f19460d.B(this.f19459c.charAt(i7))) {
                        i7++;
                    }
                    while (iF > i7 && this.f19460d.B(this.f19459c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.f19461e || i7 != iF) {
                        int i11 = this.f19463g;
                        if (i11 == 1) {
                            iF = this.f19459c.length();
                            this.f19462f = -1;
                            while (iF > i7 && this.f19460d.B(this.f19459c.charAt(iF - 1))) {
                                iF--;
                            }
                        } else {
                            this.f19463g = i11 - 1;
                        }
                        return this.f19459c.subSequence(i7, iF).toString();
                    }
                    i7 = this.f19462f;
                }
            }
        }

        abstract int e(int i7);

        abstract int f(int i7);
    }

    private interface h {
        Iterator<String> a(k0 k0Var, CharSequence charSequence);
    }

    private k0(h hVar) {
        this(hVar, false, com.google.common.base.e.G(), Integer.MAX_VALUE);
    }

    public static k0 e(int i7) {
        e0.e(i7 > 0, "The length may not be less than 1");
        return new k0(new d(i7));
    }

    public static k0 h(char c8) {
        return i(com.google.common.base.e.q(c8));
    }

    public static k0 i(com.google.common.base.e eVar) {
        e0.E(eVar);
        return new k0(new a(eVar));
    }

    private static k0 j(com.google.common.base.h hVar) {
        e0.u(!hVar.d("").d(), "The pattern may not match the empty string: %s", hVar);
        return new k0(new c(hVar));
    }

    public static k0 k(String str) {
        e0.e(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? h(str.charAt(0)) : new k0(new b(str));
    }

    @s1.c
    public static k0 l(Pattern pattern) {
        return j(new v(pattern));
    }

    @s1.c
    public static k0 m(String str) {
        return j(d0.a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> p(CharSequence charSequence) {
        return this.f19443c.a(this, charSequence);
    }

    public k0 f(int i7) {
        e0.k(i7 > 0, "must be greater than zero: %s", i7);
        return new k0(this.f19443c, this.f19442b, this.f19441a, i7);
    }

    public k0 g() {
        return new k0(this.f19443c, true, this.f19441a, this.f19444d);
    }

    public Iterable<String> n(CharSequence charSequence) {
        e0.E(charSequence);
        return new e(charSequence);
    }

    @s1.a
    public List<String> o(CharSequence charSequence) {
        e0.E(charSequence);
        Iterator<String> itP = p(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itP.hasNext()) {
            arrayList.add(itP.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public k0 q() {
        return r(com.google.common.base.e.X());
    }

    public k0 r(com.google.common.base.e eVar) {
        e0.E(eVar);
        return new k0(this.f19443c, this.f19442b, eVar, this.f19444d);
    }

    @s1.a
    public f s(char c8) {
        return t(h(c8));
    }

    @s1.a
    public f t(k0 k0Var) {
        return new f(this, k0Var, null);
    }

    @s1.a
    public f u(String str) {
        return t(k(str));
    }

    private k0(h hVar, boolean z7, com.google.common.base.e eVar, int i7) {
        this.f19443c = hVar;
        this.f19442b = z7;
        this.f19441a = eVar;
        this.f19444d = i7;
    }
}
