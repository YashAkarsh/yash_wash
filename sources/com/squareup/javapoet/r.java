package com.squareup.javapoet;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Modifier f33438a;

    static {
        Modifier modifierValueOf;
        try {
            modifierValueOf = Modifier.valueOf(MessengerShareContentUtility.PREVIEW_DEFAULT);
        } catch (IllegalArgumentException unused) {
            modifierValueOf = null;
        }
        f33438a = modifierValueOf;
    }

    private r() {
    }

    static String a(char c8) {
        if (c8 == '\f') {
            return "\\f";
        }
        if (c8 == '\r') {
            return "\\r";
        }
        if (c8 == '\"') {
            return "\"";
        }
        if (c8 == '\'') {
            return "\\'";
        }
        if (c8 == '\\') {
            return "\\\\";
        }
        switch (c8) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            default:
                return Character.isISOControl(c8) ? String.format("\\u%04x", Integer.valueOf(c8)) : Character.toString(c8);
        }
    }

    static void b(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    static <T> T c(T t7, String str, Object... objArr) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    static void d(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    static boolean e(Collection<Modifier> collection) {
        Modifier modifier = f33438a;
        return modifier != null && collection.contains(modifier);
    }

    static <T> List<T> f(Collection<T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    static <K, V> Map<K, V> g(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    static <K, V> Map<K, List<V>> h(Map<K, List<V>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), f(entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    static <T> Set<T> i(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }

    static String j(String str, List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i7 = 1; i7 < list.size(); i7++) {
            sb.append(str);
            sb.append(list.get(i7));
        }
        return sb.toString();
    }

    static void k(Set<Modifier> set, Modifier... modifierArr) {
        int i7 = 0;
        for (Modifier modifier : modifierArr) {
            if ((modifier != null || f33438a != null) && set.contains(modifier)) {
                i7++;
            }
        }
        b(i7 == 1, "modifiers %s must contain one of %s", set, Arrays.toString(modifierArr));
    }

    static String l(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append(h0.f35376b);
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '\'') {
                sb.append("'");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(a(cCharAt));
                if (cCharAt == '\n' && i7 + 1 < str.length()) {
                    sb.append("\"\n");
                    sb.append(str2);
                    sb.append(str2);
                    sb.append("+ \"");
                }
            }
        }
        sb.append(h0.f35376b);
        return sb.toString();
    }

    static <T> Set<T> m(Set<T> set, Set<T> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }
}
