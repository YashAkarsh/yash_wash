package com.google.common.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f19851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f19852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f19853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f19854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f19855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ y[] f19856f;

    static enum a extends y {
        a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // com.google.common.cache.y
        boolean a() {
            return false;
        }
    }

    static {
        a aVar = new a("EXPLICIT", 0);
        f19851a = aVar;
        y yVar = new y("REPLACED", 1) { // from class: com.google.common.cache.y.b
            {
                a aVar2 = null;
            }

            @Override // com.google.common.cache.y
            boolean a() {
                return false;
            }
        };
        f19852b = yVar;
        y yVar2 = new y("COLLECTED", 2) { // from class: com.google.common.cache.y.c
            {
                a aVar2 = null;
            }

            @Override // com.google.common.cache.y
            boolean a() {
                return true;
            }
        };
        f19853c = yVar2;
        y yVar3 = new y("EXPIRED", 3) { // from class: com.google.common.cache.y.d
            {
                a aVar2 = null;
            }

            @Override // com.google.common.cache.y
            boolean a() {
                return true;
            }
        };
        f19854d = yVar3;
        y yVar4 = new y("SIZE", 4) { // from class: com.google.common.cache.y.e
            {
                a aVar2 = null;
            }

            @Override // com.google.common.cache.y
            boolean a() {
                return true;
            }
        };
        f19855e = yVar4;
        f19856f = new y[]{aVar, yVar, yVar2, yVar3, yVar4};
    }

    private y(String str, int i7) {
        super(str, i7);
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f19856f.clone();
    }

    abstract boolean a();

    /* synthetic */ y(String str, int i7, a aVar) {
        this(str, i7);
    }
}
