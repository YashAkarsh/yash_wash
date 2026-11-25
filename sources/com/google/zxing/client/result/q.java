package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f23495a;

    protected q(r rVar) {
        this.f23495a = rVar;
    }

    public static void c(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void d(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                c(str, sb);
            }
        }
    }

    public abstract String a();

    public final r b() {
        return this.f23495a;
    }

    public final String toString() {
        return a();
    }
}
