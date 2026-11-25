package com.alibaba.fastjson.asm;

import androidx.constraintlayout.core.motion.utils.w;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f12646e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?>[] f12648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected g f12649c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f12650d;

    static class a extends HashMap<String, String> {
        a() {
            put("int", "I");
            put(w.b.f3031f, "Z");
            put("byte", "B");
            put("char", "C");
            put("short", "S");
            put(w.b.f3028c, "F");
            put("long", "J");
            put("double", "D");
        }
    }

    public l(String str, Class<?>[] clsArr) {
        this.f12647a = str;
        this.f12648b = clsArr;
    }

    private boolean a(k kVar, String str) {
        String strC = kVar.c();
        String str2 = "";
        while (strC.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            str2 = str2 + "[";
            strC = strC.substring(0, strC.length() - 2);
        }
        if (!str2.equals("")) {
            Map<String, String> map = f12646e;
            if (map.containsKey(strC)) {
                strC = str2 + map.get(strC);
            } else {
                strC = str2 + "L" + strC + com.alipay.sdk.util.j.f13806b;
            }
        }
        return strC.equals(str);
    }

    public String[] b() {
        g gVar = this.f12649c;
        return (gVar == null || !gVar.f12589e) ? new String[0] : gVar.a().split(",");
    }

    public boolean c() {
        return this.f12650d;
    }

    public boolean d() {
        return this.f12649c != null;
    }

    public void e(String str) {
        if ("Lcom/alibaba/fastjson/annotation/JSONType;".equals(str)) {
            this.f12650d = true;
        }
    }

    protected g f(int i7, String str, String str2) {
        if (this.f12649c != null || !str.equals(this.f12647a)) {
            return null;
        }
        k[] kVarArrA = k.a(str2);
        int i8 = 0;
        for (k kVar : kVarArrA) {
            String strC = kVar.c();
            if (strC.equals("long") || strC.equals("double")) {
                i8++;
            }
        }
        if (kVarArrA.length != this.f12648b.length) {
            return null;
        }
        for (int i9 = 0; i9 < kVarArrA.length; i9++) {
            if (!a(kVarArrA[i9], this.f12648b[i9].getName())) {
                return null;
            }
        }
        g gVar = new g(!Modifier.isStatic(i7) ? 1 : 0, kVarArrA.length + i8);
        this.f12649c = gVar;
        return gVar;
    }
}
