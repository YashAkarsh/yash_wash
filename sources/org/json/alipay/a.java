package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f39756a;

    public a() {
        this.f39756a = new ArrayList();
    }

    public final int a() {
        return this.f39756a.size();
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }

    public a(Object obj) throws JSONException {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i7 = 0; i7 < length; i7++) {
            this.f39756a.add(Array.get(obj, i7));
        }
    }

    public final Object a(int i7) throws JSONException {
        Object obj = (i7 < 0 || i7 >= this.f39756a.size()) ? null : this.f39756a.get(i7);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i7 + "] not found.");
    }

    public a(String str) {
        this(new c(str));
    }

    private String a(String str) {
        int size = this.f39756a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f39756a.get(i7)));
        }
        return stringBuffer.toString();
    }

    public a(Collection collection) {
        this.f39756a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) throws JSONException {
        char c8;
        ArrayList arrayList;
        Object objD;
        this();
        char c9 = cVar.c();
        if (c9 == '[') {
            c8 = ']';
        } else {
            if (c9 != '(') {
                throw cVar.a("A JSONArray text must start with '['");
            }
            c8 = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c10 = cVar.c();
            cVar.a();
            if (c10 == ',') {
                arrayList = this.f39756a;
                objD = null;
            } else {
                arrayList = this.f39756a;
                objD = cVar.d();
            }
            arrayList.add(objD);
            char c11 = cVar.c();
            if (c11 != ')') {
                if (c11 != ',' && c11 != ';') {
                    if (c11 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c8 == c11) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c8) + "'");
        } while (cVar.c() != ']');
    }
}
