package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements com.google.gson.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f22955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f22956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f22957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f22958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f22959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f22960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ d[] f22961g;

    final enum a extends d {
        a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // com.google.gson.e
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f22955a = aVar;
        d dVar = new d("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.d.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.e
            public String a(Field field) {
                return d.c(field.getName());
            }
        };
        f22956b = dVar;
        d dVar2 = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.d.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.e
            public String a(Field field) {
                return d.c(d.b(field.getName(), " "));
            }
        };
        f22957c = dVar2;
        d dVar3 = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.d.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.e
            public String a(Field field) {
                return d.b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        f22958d = dVar3;
        d dVar4 = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: com.google.gson.d.e
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.e
            public String a(Field field) {
                return d.b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        f22959e = dVar4;
        d dVar5 = new d("LOWER_CASE_WITH_DOTS", 5) { // from class: com.google.gson.d.f
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.e
            public String a(Field field) {
                return d.b(field.getName(), com.alibaba.android.arouter.utils.b.f12515h).toLowerCase(Locale.ENGLISH);
            }
        };
        f22960f = dVar5;
        f22961g = new d[]{aVar, dVar, dVar2, dVar3, dVar4, dVar5};
    }

    private d(String str, int i7) {
        super(str, i7);
    }

    static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length() - 1;
        int i7 = 0;
        while (!Character.isLetter(str.charAt(i7)) && i7 < length) {
            i7++;
        }
        char cCharAt = str.charAt(i7);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i7 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i7) + upperCase + str.substring(i7 + 1);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f22961g.clone();
    }

    /* synthetic */ d(String str, int i7, a aVar) {
        this(str, i7);
    }
}
