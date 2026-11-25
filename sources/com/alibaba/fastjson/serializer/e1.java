package com.alibaba.fastjson.serializer;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f13025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13028d;

    public e1(e1 e1Var, Object obj, Object obj2, int i7, int i8) {
        this.f13025a = e1Var;
        this.f13026b = obj;
        this.f13027c = obj2;
        this.f13028d = i7;
    }

    public Object a() {
        return this.f13027c;
    }

    public Object b() {
        return this.f13026b;
    }

    public e1 c() {
        return this.f13025a;
    }

    public String d() {
        return toString();
    }

    protected void e(StringBuilder sb) {
        e1 e1Var = this.f13025a;
        if (e1Var == null) {
            sb.append('$');
            return;
        }
        e1Var.e(sb);
        Object obj = this.f13027c;
        if (obj == null) {
            sb.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb.append('[');
            sb.append(((Integer) this.f13027c).intValue());
            sb.append(']');
            return;
        }
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        String string = this.f13027c.toString();
        boolean z7 = false;
        for (int i7 = 0; i7 < string.length(); i7++) {
            char cCharAt = string.charAt(i7);
            if (cCharAt == '.' || cCharAt == '@' || cCharAt == '(' || cCharAt == '\\') {
                z7 = true;
            }
        }
        if (!z7) {
            sb.append(string);
            return;
        }
        for (int i8 = 0; i8 < string.length(); i8++) {
            char cCharAt2 = string.charAt(i8);
            if (cCharAt2 == '.' || cCharAt2 == '@' || cCharAt2 == '(') {
                sb.append('\\');
                sb.append('\\');
            } else if (cCharAt2 == '\\') {
                sb.append('\\');
                sb.append('\\');
                sb.append('\\');
            }
            sb.append(cCharAt2);
        }
    }

    public String toString() {
        if (this.f13025a == null) {
            return "$";
        }
        StringBuilder sb = new StringBuilder();
        e(sb);
        return sb.toString();
    }
}
