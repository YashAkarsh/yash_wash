package com.haier.library.json.serializer;

/* JADX INFO: loaded from: classes2.dex */
public enum a0 {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
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
    NotWriteDefaultValue;


    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a0[] f26809y = new a0[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26811a = 1 << ordinal();

    a0() {
    }

    public static int a(a0[] a0VarArr) {
        if (a0VarArr == null) {
            return 0;
        }
        int i7 = 0;
        for (a0 a0Var : a0VarArr) {
            i7 |= a0Var.f26811a;
        }
        return i7;
    }
}
