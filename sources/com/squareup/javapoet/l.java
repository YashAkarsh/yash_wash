package com.squareup.javapoet;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.lang.model.SourceVersion;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f33358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Object, String> f33359b;

    public l() {
        this(new LinkedHashSet(), new LinkedHashMap());
    }

    public static String j(String str) {
        StringBuilder sb = new StringBuilder();
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCharCount == 0 && !Character.isJavaIdentifierStart(iCodePointAt) && Character.isJavaIdentifierPart(iCodePointAt)) {
                sb.append("_");
            }
            sb.appendCodePoint(Character.isJavaIdentifierPart(iCodePointAt) ? iCodePointAt : 95);
            iCharCount += Character.charCount(iCodePointAt);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public l clone() {
        return new l(new LinkedHashSet(this.f33358a), new LinkedHashMap(this.f33359b));
    }

    public String g(Object obj) {
        String str = this.f33359b.get(obj);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown tag: " + obj);
    }

    public String h(String str) {
        return i(str, UUID.randomUUID().toString());
    }

    public String i(String str, Object obj) {
        r.c(str, "suggestion", new Object[0]);
        r.c(obj, ViewHierarchyConstants.TAG_KEY, new Object[0]);
        String strJ = j(str);
        while (true) {
            if (!SourceVersion.isKeyword(strJ) && this.f33358a.add(strJ)) {
                break;
            }
            strJ = strJ + "_";
        }
        String strPut = this.f33359b.put(obj, strJ);
        if (strPut == null) {
            return strJ;
        }
        this.f33359b.put(obj, strPut);
        throw new IllegalArgumentException("tag " + obj + " cannot be used for both '" + strPut + "' and '" + strJ + "'");
    }

    private l(LinkedHashSet<String> linkedHashSet, LinkedHashMap<Object, String> linkedHashMap) {
        this.f33358a = linkedHashSet;
        this.f33359b = linkedHashMap;
    }
}
