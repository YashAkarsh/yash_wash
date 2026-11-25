package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public enum k1 {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;

    public static final k1[] F;
    public static final int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13132a = 1 << ordinal();

    static {
        k1 k1Var = WriteMapNullValue;
        k1 k1Var2 = WriteNullListAsEmpty;
        k1 k1Var3 = WriteNullStringAsEmpty;
        k1 k1Var4 = WriteNullNumberAsZero;
        k1 k1Var5 = WriteNullBooleanAsFalse;
        F = new k1[0];
        G = k1Var.b() | k1Var5.b() | k1Var2.b() | k1Var4.b() | k1Var3.b();
    }

    k1() {
    }

    public static int a(int i7, k1 k1Var, boolean z7) {
        return z7 ? i7 | k1Var.f13132a : i7 & (~k1Var.f13132a);
    }

    public static boolean c(int i7, int i8, k1 k1Var) {
        int i9 = k1Var.f13132a;
        return ((i7 & i9) == 0 && (i8 & i9) == 0) ? false : true;
    }

    public static boolean d(int i7, k1 k1Var) {
        return (i7 & k1Var.f13132a) != 0;
    }

    public static int e(k1[] k1VarArr) {
        if (k1VarArr == null) {
            return 0;
        }
        int i7 = 0;
        for (k1 k1Var : k1VarArr) {
            i7 |= k1Var.f13132a;
        }
        return i7;
    }

    public final int b() {
        return this.f13132a;
    }
}
