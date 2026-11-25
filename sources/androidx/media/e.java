package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import c.t0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class e {

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f8662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f8663b;

        a(String str, Bundle bundle) {
            this.f8662a = str;
            this.f8663b = bundle;
        }
    }

    static class b extends MediaBrowserService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f8664a;

        b(Context context, d dVar) {
            attachBaseContext(context);
            this.f8664a = dVar;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i7, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            a aVarH = this.f8664a.h(str, i7, bundle == null ? null : new Bundle(bundle));
            if (aVarH == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(aVarH.f8662a, aVarH.f8663b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f8664a.d(str, new c<>(result));
        }
    }

    static class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f8665a;

        c(MediaBrowserService.Result result) {
            this.f8665a = result;
        }

        public void a() {
            this.f8665a.detach();
        }

        List<MediaBrowser.MediaItem> b(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void c(T t7) {
            if (t7 instanceof List) {
                this.f8665a.sendResult(b((List) t7));
                return;
            }
            if (!(t7 instanceof Parcel)) {
                this.f8665a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) t7;
            parcel.setDataPosition(0);
            this.f8665a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    public interface d {
        void d(String str, c<List<Parcel>> cVar);

        a h(String str, int i7, Bundle bundle);
    }

    private e() {
    }

    public static Object a(Context context, d dVar) {
        return new b(context, dVar);
    }

    public static void b(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    public static IBinder c(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void d(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static void e(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }
}
