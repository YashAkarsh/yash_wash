package com.nostra13.universalimageloader.utils;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32921a = "_";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f32922b = "x";

    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.substring(0, str.lastIndexOf(e.f32921a)).compareTo(str2.substring(0, str2.lastIndexOf(e.f32921a)));
        }
    }

    private e() {
    }

    public static Comparator<String> a() {
        return new a();
    }

    public static List<String> b(String str, com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<Bitmap> c(String str, com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(cVar.get(str2));
            }
        }
        return arrayList;
    }

    public static String d(String str, com.nostra13.universalimageloader.core.assist.e eVar) {
        return str + f32921a + eVar.b() + f32922b + eVar.a();
    }

    public static void e(String str, com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cVar.remove((String) it.next());
        }
    }
}
