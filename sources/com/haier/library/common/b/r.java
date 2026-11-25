package com.haier.library.common.b;

/* JADX INFO: loaded from: classes2.dex */
public enum r {
    STATE_DISABLED(1),
    STATE_ENABLED(3),
    STATE_UNKNOWN(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f26457a;

    r(int... iArr) {
        this.f26457a = iArr;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    /* JADX WARN: Code duplicated, block: B:18:? A[RETURN, SYNTHETIC] */
    public static r a(int i7) {
        for (r rVar : values()) {
            for (int i8 : rVar.f26457a) {
                if (i7 == i8) {
                    if (rVar == null) {
                        return STATE_UNKNOWN;
                    }
                    return rVar;
                }
            }
        }
        rVar = null;
        if (rVar == null) {
            return STATE_UNKNOWN;
        }
        return rVar;
    }
}
