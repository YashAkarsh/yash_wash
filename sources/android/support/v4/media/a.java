package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import c.m0;
import c.t0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f259a = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    /* JADX INFO: renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    interface InterfaceC0008a {
        void b();

        void e();

        void g();
    }

    static class b<T extends InterfaceC0008a> extends MediaBrowser.ConnectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f260a;

        public b(T t7) {
            this.f260a = t7;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f260a.e();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f260a.g();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f260a.b();
        }
    }

    static class c {
        private c() {
        }

        public static Object a(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }

        public static int b(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }
    }

    interface d {
        void a(@m0 String str);

        void d(@m0 String str, List<?> list);
    }

    static class e<T extends d> extends MediaBrowser.SubscriptionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f261a;

        public e(T t7) {
            this.f261a = t7;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@m0 String str, List<MediaBrowser.MediaItem> list) {
            this.f261a.d(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@m0 String str) {
            this.f261a.a(str);
        }
    }

    private a() {
    }

    public static void a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static Object b(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static Object c(InterfaceC0008a interfaceC0008a) {
        return new b(interfaceC0008a);
    }

    public static Object d(d dVar) {
        return new e(dVar);
    }

    public static void e(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle f(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static String g(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    public static ComponentName h(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    public static Object i(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    public static boolean j(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    public static void k(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }

    public static void l(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }
}
