package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(23)
class m {

    public interface a extends k.a {
        void e(Uri uri, Bundle bundle);
    }

    static class b<T extends a> extends k.b<T> {
        public b(T t7) {
            super(t7);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((a) this.f529a).e(uri, bundle);
        }
    }

    private m() {
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }
}
