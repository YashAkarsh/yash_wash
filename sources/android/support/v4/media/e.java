package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import c.m0;
import c.t0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(26)
class e {

    interface a extends android.support.v4.media.a.d {
        void b(@m0 String str, @m0 Bundle bundle);

        void c(@m0 String str, List<?> list, @m0 Bundle bundle);
    }

    static class b<T extends a> extends android.support.v4.media.a.e<T> {
        b(T t7) {
            super(t7);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@m0 String str, List<MediaBrowser.MediaItem> list, @m0 Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((a) this.f261a).c(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@m0 String str, @m0 Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((a) this.f261a).b(str, bundle);
        }
    }

    private e() {
    }

    static Object a(a aVar) {
        return new b(aVar);
    }

    public static void b(Object obj, String str, Bundle bundle, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, bundle, (MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void c(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).unsubscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }
}
