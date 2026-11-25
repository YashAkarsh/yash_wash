package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f23737c;

    static {
        h hVar = new h();
        f23737c = hVar;
        hVar.setStackTrace(q.f24120b);
    }

    private h() {
    }

    public static h a() {
        return q.f24119a ? new h() : f23737c;
    }

    public static h b(Throwable th) {
        return q.f24119a ? new h(th) : f23737c;
    }

    private h(Throwable th) {
        super(th);
    }
}
