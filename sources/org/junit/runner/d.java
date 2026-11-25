package org.junit.runner;

/* JADX INFO: loaded from: classes3.dex */
class d {
    d() {
    }

    public static org.junit.runner.manipulation.a a(Class<? extends e> cls, f fVar) throws e.a {
        return c(cls).a(fVar);
    }

    public static org.junit.runner.manipulation.a b(String str, f fVar) throws e.a {
        return d(str).a(fVar);
    }

    static e c(Class<? extends e> cls) throws e.a {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e8) {
            throw new e.a(e8);
        }
    }

    static e d(String str) throws e.a {
        try {
            return c(org.junit.internal.c.a(str).asSubclass(e.class));
        } catch (Exception e8) {
            throw new e.a(e8);
        }
    }

    public static org.junit.runner.manipulation.a e(i iVar, String str) throws e.a {
        c cVarB = iVar.h().b();
        String[] strArrSplit = str.contains("=") ? str.split("=", 2) : new String[]{str, ""};
        return b(strArrSplit[0], new f(cVarB, strArrSplit[1]));
    }
}
