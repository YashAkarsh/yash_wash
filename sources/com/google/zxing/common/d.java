package com.google.zxing.common;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, CharEncoding.ISO_8859_1),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, CharEncoding.UTF_16BE, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, CharEncoding.US_ASCII),
    Big5(28),
    GB18030(29, l.f23594c, "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private static final Map<Integer, d> D = new HashMap();
    private static final Map<String, d> E = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f23556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f23557b;

    static {
        for (d dVar : values()) {
            for (int i7 : dVar.f23556a) {
                D.put(Integer.valueOf(i7), dVar);
            }
            E.put(dVar.name(), dVar);
            for (String str : dVar.f23557b) {
                E.put(str, dVar);
            }
        }
    }

    d(int i7) {
        this(new int[]{i7}, new String[0]);
    }

    public static d a(String str) {
        return E.get(str);
    }

    public static d b(int i7) throws com.google.zxing.h {
        if (i7 < 0 || i7 >= 900) {
            throw com.google.zxing.h.a();
        }
        return D.get(Integer.valueOf(i7));
    }

    public int c() {
        return this.f23556a[0];
    }

    d(int i7, String... strArr) {
        this.f23556a = new int[]{i7};
        this.f23557b = strArr;
    }

    d(int[] iArr, String... strArr) {
        this.f23556a = iArr;
        this.f23557b = strArr;
    }
}
