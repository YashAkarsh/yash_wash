package com.google.common.escape;

import com.google.common.base.e0;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[][] f21519b = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[][] f21520a;

    private b(char[][] cArr) {
        this.f21520a = cArr;
    }

    public static b a(Map<Character, String> map) {
        return new b(b(map));
    }

    @s1.d
    static char[][] b(Map<Character, String> map) {
        e0.E(map);
        if (map.isEmpty()) {
            return f21519b;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            char cCharValue = it.next().charValue();
            cArr[cCharValue] = map.get(Character.valueOf(cCharValue)).toCharArray();
        }
        return cArr;
    }

    char[][] c() {
        return this.f21520a;
    }
}
