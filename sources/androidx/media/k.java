package androidx.media;

import android.content.Context;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class k extends u {
    k(Context context) {
        super(context);
        this.f8688a = context;
    }

    private boolean e(@m0 j.c cVar) {
        return d().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", cVar.b(), cVar.a()) == 0;
    }

    @Override // androidx.media.u, androidx.media.j.a
    public boolean a(@m0 j.c cVar) {
        return e(cVar) || super.a(cVar);
    }
}
