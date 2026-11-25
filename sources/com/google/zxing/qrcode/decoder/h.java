package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
public enum h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f24165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24166b;

    h(int[] iArr, int i7) {
        this.f24165a = iArr;
        this.f24166b = i7;
    }

    public static h a(int i7) {
        if (i7 == 0) {
            return TERMINATOR;
        }
        if (i7 == 1) {
            return NUMERIC;
        }
        if (i7 == 2) {
            return ALPHANUMERIC;
        }
        if (i7 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i7 == 4) {
            return BYTE;
        }
        if (i7 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i7 == 7) {
            return ECI;
        }
        if (i7 == 8) {
            return KANJI;
        }
        if (i7 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i7 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.f24166b;
    }

    public int c(j jVar) {
        char c8;
        int iJ = jVar.j();
        if (iJ <= 9) {
            c8 = 0;
        } else {
            c8 = iJ <= 26 ? (char) 1 : (char) 2;
        }
        return this.f24165a[c8];
    }
}
