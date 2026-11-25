package com.google.common.base;

import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
@s1.b
public abstract class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f19327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f19328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f19329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f19330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f19331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ d[] f19332h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.base.e f19333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19334b;

    static enum a extends d {
        a(String str, int i7, com.google.common.base.e eVar, String str2) {
            super(str, i7, eVar, str2, null);
        }

        @Override // com.google.common.base.d
        String b(d dVar, String str) {
            if (dVar == d.f19328d) {
                return str.replace('-', '_');
            }
            return dVar == d.f19331g ? com.google.common.base.c.j(str.replace('-', '_')) : super.b(dVar, str);
        }

        @Override // com.google.common.base.d
        String f(String str) {
            return com.google.common.base.c.g(str);
        }
    }

    private static final class f extends i<String, String> implements Serializable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f19335e = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f19336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d f19337d;

        f(d dVar, d dVar2) {
            this.f19336c = (d) e0.E(dVar);
            this.f19337d = (d) e0.E(dVar2);
        }

        @Override // com.google.common.base.i, com.google.common.base.s
        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f19336c.equals(fVar.f19336c) && this.f19337d.equals(fVar.f19337d);
        }

        public int hashCode() {
            return this.f19336c.hashCode() ^ this.f19337d.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(String str) {
            return this.f19337d.g(this.f19336c, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public String h(String str) {
            return this.f19336c.g(this.f19337d, str);
        }

        public String toString() {
            return this.f19336c + ".converterTo(" + this.f19337d + ")";
        }
    }

    static {
        a aVar = new a("LOWER_HYPHEN", 0, com.google.common.base.e.q('-'), "-");
        f19327c = aVar;
        String str = "_";
        d dVar = new d("LOWER_UNDERSCORE", 1, com.google.common.base.e.q('_'), str) { // from class: com.google.common.base.d.b
            {
                a aVar2 = null;
            }

            @Override // com.google.common.base.d
            String b(d dVar2, String str2) {
                if (dVar2 == d.f19327c) {
                    return str2.replace('_', '-');
                }
                return dVar2 == d.f19331g ? com.google.common.base.c.j(str2) : super.b(dVar2, str2);
            }

            @Override // com.google.common.base.d
            String f(String str2) {
                return com.google.common.base.c.g(str2);
            }
        };
        f19328d = dVar;
        String str2 = "";
        d dVar2 = new d("LOWER_CAMEL", 2, com.google.common.base.e.m('A', 'Z'), str2) { // from class: com.google.common.base.d.c
            {
                a aVar2 = null;
            }

            @Override // com.google.common.base.d
            String f(String str3) {
                return d.d(str3);
            }
        };
        f19329e = dVar2;
        d dVar3 = new d("UPPER_CAMEL", 3, com.google.common.base.e.m('A', 'Z'), str2) { // from class: com.google.common.base.d.d
            {
                a aVar2 = null;
            }

            @Override // com.google.common.base.d
            String f(String str3) {
                return d.d(str3);
            }
        };
        f19330f = dVar3;
        d dVar4 = new d("UPPER_UNDERSCORE", 4, com.google.common.base.e.q('_'), str) { // from class: com.google.common.base.d.e
            {
                a aVar2 = null;
            }

            @Override // com.google.common.base.d
            String b(d dVar5, String str3) {
                if (dVar5 == d.f19327c) {
                    return com.google.common.base.c.g(str3.replace('_', '-'));
                }
                return dVar5 == d.f19328d ? com.google.common.base.c.g(str3) : super.b(dVar5, str3);
            }

            @Override // com.google.common.base.d
            String f(String str3) {
                return com.google.common.base.c.j(str3);
            }
        };
        f19331g = dVar4;
        f19332h = new d[]{aVar, dVar, dVar2, dVar3, dVar4};
    }

    /* synthetic */ d(String str, int i7, com.google.common.base.e eVar, String str2, a aVar) {
        this(str, i7, eVar, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return com.google.common.base.c.h(str.charAt(0)) + com.google.common.base.c.g(str.substring(1));
    }

    private String e(String str) {
        return this == f19329e ? com.google.common.base.c.g(str) : f(str);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f19332h.clone();
    }

    String b(d dVar, String str) {
        StringBuilder sb = null;
        int length = 0;
        int iO = -1;
        while (true) {
            iO = this.f19333a.o(str, iO + 1);
            if (iO == -1) {
                break;
            }
            if (length == 0) {
                sb = new StringBuilder(str.length() + (this.f19334b.length() * 4));
                sb.append(dVar.e(str.substring(length, iO)));
            } else {
                sb.append(dVar.f(str.substring(length, iO)));
            }
            sb.append(dVar.f19334b);
            length = this.f19334b.length() + iO;
        }
        if (length == 0) {
            return dVar.e(str);
        }
        sb.append(dVar.f(str.substring(length)));
        return sb.toString();
    }

    public i<String, String> c(d dVar) {
        return new f(this, dVar);
    }

    abstract String f(String str);

    public final String g(d dVar, String str) {
        e0.E(dVar);
        e0.E(str);
        return dVar == this ? str : b(dVar, str);
    }

    private d(String str, int i7, com.google.common.base.e eVar, String str2) {
        super(str, i7);
        this.f19333a = eVar;
        this.f19334b = str2;
    }
}
