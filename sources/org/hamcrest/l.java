package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    public static <T> void a(T t7, k<? super T> kVar) {
        b("", t7, kVar);
    }

    public static <T> void b(String str, T t7, k<? super T> kVar) {
        if (kVar.c(t7)) {
            return;
        }
        n nVar = new n();
        nVar.d(str).d("\nExpected: ").b(kVar).d("\n     but: ");
        kVar.a(t7, nVar);
        throw new AssertionError(nVar.toString());
    }

    public static void c(String str, boolean z7) {
        if (!z7) {
            throw new AssertionError(str);
        }
    }
}
