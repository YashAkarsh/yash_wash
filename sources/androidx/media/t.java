package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.core.util.r;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(28)
class t extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    MediaSessionManager f8681h;

    t(Context context) {
        super(context);
        this.f8681h = (MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // androidx.media.k, androidx.media.u, androidx.media.j.a
    public boolean a(j.c cVar) {
        if (cVar instanceof a) {
            return this.f8681h.isTrustedForMediaControl(((a) cVar).f8682a);
        }
        return false;
    }

    static final class a implements j.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f8682a;

        a(String str, int i7, int i8) {
            s.a();
            this.f8682a = q.a(str, i7, i8);
        }

        @Override // androidx.media.j.c
        public String J() {
            return this.f8682a.getPackageName();
        }

        @Override // androidx.media.j.c
        public int a() {
            return this.f8682a.getUid();
        }

        @Override // androidx.media.j.c
        public int b() {
            return this.f8682a.getPid();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.f8682a.equals(((a) obj).f8682a);
            }
            return false;
        }

        public int hashCode() {
            return r.b(this.f8682a);
        }

        a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f8682a = remoteUserInfo;
        }
    }
}
