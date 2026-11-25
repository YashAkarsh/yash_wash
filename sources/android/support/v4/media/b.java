package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(23)
class b {

    interface a {
        void a(@m0 String str);

        void b(Parcel parcel);
    }

    /* JADX INFO: renamed from: android.support.v4.media.b$b, reason: collision with other inner class name */
    static class C0009b<T extends a> extends MediaBrowser.ItemCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f262a;

        public C0009b(T t7) {
            this.f262a = t7;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(@m0 String str) {
            this.f262a.a(str);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.f262a.b(null);
                return;
            }
            Parcel parcelObtain = Parcel.obtain();
            mediaItem.writeToParcel(parcelObtain, 0);
            this.f262a.b(parcelObtain);
        }
    }

    private b() {
    }

    public static Object a(a aVar) {
        return new C0009b(aVar);
    }

    public static void b(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }
}
