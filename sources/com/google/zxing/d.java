package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f23619c;

    static {
        d dVar = new d();
        f23619c = dVar;
        dVar.setStackTrace(q.f24120b);
    }

    private d() {
    }

    public static d a() {
        return q.f24119a ? new d() : f23619c;
    }

    public static d b(Throwable th) {
        return q.f24119a ? new d(th) : f23619c;
    }

    private d(Throwable th) {
        super(th);
    }
}
