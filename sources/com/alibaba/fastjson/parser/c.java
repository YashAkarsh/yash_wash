package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch,
    SupportAutoType,
    NonStringKeyAsString,
    CustomMapDeserializer;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12829a = 1 << ordinal();

    c() {
    }

    public static int a(int i7, c cVar, boolean z7) {
        return z7 ? i7 | cVar.f12829a : i7 & (~cVar.f12829a);
    }

    public static boolean c(int i7, c cVar) {
        return (i7 & cVar.f12829a) != 0;
    }

    public static int d(c[] cVarArr) {
        if (cVarArr == null) {
            return 0;
        }
        int i7 = 0;
        for (c cVar : cVarArr) {
            i7 |= cVar.f12829a;
        }
        return i7;
    }

    public final int b() {
        return this.f12829a;
    }
}
