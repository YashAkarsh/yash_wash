package com.google.zxing.qrcode.decoder;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f24130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f24131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f24132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f24133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f24134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f24135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f24136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f24137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ c[] f24138i;

    static enum a extends c {
        a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // com.google.zxing.qrcode.decoder.c
        boolean a(int i7, int i8) {
            return ((i7 + i8) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f24130a = aVar;
        c cVar = new c("DATA_MASK_001", 1) { // from class: com.google.zxing.qrcode.decoder.c.b
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return (i7 & 1) == 0;
            }
        };
        f24131b = cVar;
        c cVar2 = new c("DATA_MASK_010", 2) { // from class: com.google.zxing.qrcode.decoder.c.c
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return i8 % 3 == 0;
            }
        };
        f24132c = cVar2;
        c cVar3 = new c("DATA_MASK_011", 3) { // from class: com.google.zxing.qrcode.decoder.c.d
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return (i7 + i8) % 3 == 0;
            }
        };
        f24133d = cVar3;
        c cVar4 = new c("DATA_MASK_100", 4) { // from class: com.google.zxing.qrcode.decoder.c.e
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return (((i7 / 2) + (i8 / 3)) & 1) == 0;
            }
        };
        f24134e = cVar4;
        c cVar5 = new c("DATA_MASK_101", 5) { // from class: com.google.zxing.qrcode.decoder.c.f
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return (i7 * i8) % 6 == 0;
            }
        };
        f24135f = cVar5;
        c cVar6 = new c("DATA_MASK_110", 6) { // from class: com.google.zxing.qrcode.decoder.c.g
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return (i7 * i8) % 6 < 3;
            }
        };
        f24136g = cVar6;
        c cVar7 = new c("DATA_MASK_111", 7) { // from class: com.google.zxing.qrcode.decoder.c.h
            {
                a aVar2 = null;
            }

            @Override // com.google.zxing.qrcode.decoder.c
            boolean a(int i7, int i8) {
                return (((i7 + i8) + ((i7 * i8) % 3)) & 1) == 0;
            }
        };
        f24137h = cVar7;
        f24138i = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
    }

    private c(String str, int i7) {
        super(str, i7);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f24138i.clone();
    }

    abstract boolean a(int i7, int i8);

    final void b(com.google.zxing.common.b bVar, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            for (int i9 = 0; i9 < i7; i9++) {
                if (a(i8, i9)) {
                    bVar.i(i9, i8);
                }
            }
        }
    }

    /* synthetic */ c(String str, int i7, a aVar) {
        this(str, i7);
    }
}
