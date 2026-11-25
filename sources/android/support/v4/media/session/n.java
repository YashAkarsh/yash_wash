package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import c.t0;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
@t0(24)
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f530a = "MediaSessionCompatApi24";

    public interface a extends m.a {
        void a(String str, Bundle bundle);

        void b();

        void c(Uri uri, Bundle bundle);

        void d(String str, Bundle bundle);
    }

    static class b<T extends a> extends m.b<T> {
        public b(T t7) {
            super(t7);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((a) this.f529a).b();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((a) this.f529a).a(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((a) this.f529a).d(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((a) this.f529a).c(uri, bundle);
        }
    }

    private n() {
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    public static String b(Object obj) {
        MediaSession mediaSession = (MediaSession) obj;
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", new Class[0]).invoke(mediaSession, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
            Log.e(f530a, "Cannot execute MediaSession.getCallingPackage()", e8);
            return null;
        }
    }
}
