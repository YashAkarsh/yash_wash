package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class NativeOnCompleteListener implements f<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16776a;

    @c1.a
    public NativeOnCompleteListener(long j7) {
        this.f16776a = j7;
    }

    @c1.a
    public static void b(@c.m0 m<Object> mVar, long j7) {
        mVar.e(new NativeOnCompleteListener(j7));
    }

    @Override // com.google.android.gms.tasks.f
    @c1.a
    public void a(@c.m0 m<Object> mVar) {
        Object objR;
        String message;
        Exception excQ;
        if (mVar.v()) {
            objR = mVar.r();
            message = null;
        } else if (mVar.t() || (excQ = mVar.q()) == null) {
            objR = null;
            message = null;
        } else {
            message = excQ.getMessage();
            objR = null;
        }
        nativeOnComplete(this.f16776a, objR, mVar.v(), mVar.t(), message);
    }

    @c1.a
    public native void nativeOnComplete(long j7, @c.o0 Object obj, boolean z7, boolean z8, @c.o0 String str);
}
