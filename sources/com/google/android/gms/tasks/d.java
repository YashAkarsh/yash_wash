package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
public final class d extends IllegalStateException {
    private d(String str, @c.o0 Throwable th) {
        super(str, th);
    }

    @c.m0
    public static IllegalStateException a(@c.m0 m<?> mVar) {
        String strConcat;
        if (!mVar.u()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excQ = mVar.q();
        if (excQ != null) {
            strConcat = "failure";
        } else if (mVar.v()) {
            strConcat = "result ".concat(String.valueOf(mVar.r()));
        } else {
            strConcat = mVar.t() ? "cancellation" : "unknown issue";
        }
        return new d(strConcat.length() != 0 ? "Complete with: ".concat(strConcat) : new String("Complete with: "), excQ);
    }
}
