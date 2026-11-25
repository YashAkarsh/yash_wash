package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.r;
import androidx.media.MediaBrowserServiceCompat;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f75b = "MediaBrowserCompat";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final boolean f76c = Log.isLoggable(f75b, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f77d = "android.media.browse.extra.PAGE";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f78e = "android.media.browse.extra.PAGE_SIZE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f79f = "android.media.browse.extra.MEDIA_ID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f80g = "android.media.browse.extra.DOWNLOAD_PROGRESS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f81h = "android.support.v4.media.action.DOWNLOAD";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f82i = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f83a;

    private static class CustomActionResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f84d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f85e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c f86f;

        CustomActionResultReceiver(String str, Bundle bundle, c cVar, Handler handler) {
            super(handler);
            this.f84d = str;
            this.f85e = bundle;
            this.f86f = cVar;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i7, Bundle bundle) {
            if (this.f86f == null) {
                return;
            }
            MediaSessionCompat.b(bundle);
            if (i7 == -1) {
                this.f86f.a(this.f84d, this.f85e, bundle);
                return;
            }
            if (i7 == 0) {
                this.f86f.c(this.f84d, this.f85e, bundle);
                return;
            }
            if (i7 == 1) {
                this.f86f.b(this.f84d, this.f85e, bundle);
                return;
            }
            Log.w(MediaBrowserCompat.f75b, "Unknown result code: " + i7 + " (extras=" + this.f85e + ", resultData=" + bundle + ")");
        }
    }

    private static class ItemReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f87d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d f88e;

        ItemReceiver(String str, d dVar, Handler handler) {
            super(handler);
            this.f87d = str;
            this.f88e = dVar;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i7, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            if (i7 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.f8507j)) {
                this.f88e.a(this.f87d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.f8507j);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f88e.b((MediaItem) parcelable);
            } else {
                this.f88e.a(this.f87d);
            }
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f93d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f94e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final k f95f;

        SearchResultReceiver(String str, Bundle bundle, k kVar, Handler handler) {
            super(handler);
            this.f93d = str;
            this.f94e = bundle;
            this.f95f = kVar;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i7, Bundle bundle) {
            ArrayList arrayList;
            MediaSessionCompat.b(bundle);
            if (i7 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.f8508k)) {
                this.f95f.a(this.f93d, this.f94e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.f8508k);
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            } else {
                arrayList = null;
            }
            this.f95f.b(this.f93d, this.f94e, arrayList);
        }
    }

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f96a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<Messenger> f97b;

        a(j jVar) {
            this.f96a = new WeakReference<>(jVar);
        }

        void a(Messenger messenger) {
            this.f97b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.f97b;
            if (weakReference == null || weakReference.get() == null || this.f96a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.b(data);
            j jVar = this.f96a.get();
            Messenger messenger = this.f97b.get();
            try {
                int i7 = message.what;
                if (i7 == 1) {
                    Bundle bundle = data.getBundle(androidx.media.c.f8646k);
                    MediaSessionCompat.b(bundle);
                    jVar.i(messenger, data.getString(androidx.media.c.f8639d), (MediaSessionCompat.Token) data.getParcelable(androidx.media.c.f8641f), bundle);
                } else if (i7 == 2) {
                    jVar.o(messenger);
                } else if (i7 != 3) {
                    Log.w(MediaBrowserCompat.f75b, "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(androidx.media.c.f8642g);
                    MediaSessionCompat.b(bundle2);
                    Bundle bundle3 = data.getBundle(androidx.media.c.f8643h);
                    MediaSessionCompat.b(bundle3);
                    jVar.k(messenger, data.getString(androidx.media.c.f8639d), data.getParcelableArrayList(androidx.media.c.f8640e), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e(MediaBrowserCompat.f75b, "Could not unparcel the data.");
                if (message.what == 1) {
                    jVar.o(messenger);
                }
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f98a = android.support.v4.media.a.c(new C0006b());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f99b;

        interface a {
            void b();

            void e();

            void g();
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        private class C0006b implements android.support.v4.media.a.InterfaceC0008a {
            C0006b() {
            }

            @Override // android.support.v4.media.a.InterfaceC0008a
            public void b() {
                a aVar = b.this.f99b;
                if (aVar != null) {
                    aVar.b();
                }
                b.this.c();
            }

            @Override // android.support.v4.media.a.InterfaceC0008a
            public void e() {
                a aVar = b.this.f99b;
                if (aVar != null) {
                    aVar.e();
                }
                b.this.a();
            }

            @Override // android.support.v4.media.a.InterfaceC0008a
            public void g() {
                a aVar = b.this.f99b;
                if (aVar != null) {
                    aVar.g();
                }
                b.this.b();
            }
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        void d(a aVar) {
            this.f99b = aVar;
        }
    }

    public static abstract class c {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f101a = android.support.v4.media.b.a(new a());

        private class a implements android.support.v4.media.b.a {
            a() {
            }

            @Override // android.support.v4.media.b.a
            public void a(@m0 String str) {
                d.this.a(str);
            }

            @Override // android.support.v4.media.b.a
            public void b(Parcel parcel) {
                if (parcel == null) {
                    d.this.b(null);
                    return;
                }
                parcel.setDataPosition(0);
                MediaItem mediaItemCreateFromParcel = MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                d.this.b(mediaItemCreateFromParcel);
            }
        }

        public void a(@m0 String str) {
        }

        public void b(MediaItem mediaItem) {
        }
    }

    interface e {
        boolean a();

        @m0
        MediaSessionCompat.Token c();

        @m0
        String d();

        void f();

        @o0
        Bundle getExtras();

        void h(@m0 String str, Bundle bundle, @o0 c cVar);

        ComponentName j();

        void l(@m0 String str, @m0 d dVar);

        void m();

        void n(@m0 String str, @o0 Bundle bundle, @m0 n nVar);

        void p(@m0 String str, n nVar);

        void q(@m0 String str, Bundle bundle, @m0 k kVar);

        @o0
        Bundle r();
    }

    @t0(21)
    static class f implements e, j, b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Bundle f105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final a f106d = new a(this);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final androidx.collection.a<String, m> f107e = new androidx.collection.a<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected l f109g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected Messenger f110h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private MediaSessionCompat.Token f111i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Bundle f112j;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f113a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f114b;

            a(d dVar, String str) {
                this.f113a = dVar;
                this.f114b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f113a.a(this.f114b);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f116a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f117b;

            b(d dVar, String str) {
                this.f116a = dVar;
                this.f117b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f116a.a(this.f117b);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f119a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f120b;

            c(d dVar, String str) {
                this.f119a = dVar;
                this.f120b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f119a.a(this.f120b);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f122a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f123b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f124c;

            d(k kVar, String str, Bundle bundle) {
                this.f122a = kVar;
                this.f123b = str;
                this.f124c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f122a.a(this.f123b, this.f124c);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f126a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f127b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f128c;

            e(k kVar, String str, Bundle bundle) {
                this.f126a = kVar;
                this.f127b = str;
                this.f128c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f126a.a(this.f127b, this.f128c);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$f$f, reason: collision with other inner class name */
        class RunnableC0007f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f130a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f131b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f132c;

            RunnableC0007f(c cVar, String str, Bundle bundle) {
                this.f130a = cVar;
                this.f131b = str;
                this.f132c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f130a.a(this.f131b, this.f132c, null);
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f134a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f135b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f136c;

            g(c cVar, String str, Bundle bundle) {
                this.f134a = cVar;
                this.f135b = str;
                this.f136c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f134a.a(this.f135b, this.f136c, null);
            }
        }

        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.f103a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f105c = bundle2;
            bundle2.putInt(androidx.media.c.f8651p, 1);
            bVar.d(this);
            this.f104b = android.support.v4.media.a.b(context, componentName, bVar.f98a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public boolean a() {
            return android.support.v4.media.a.j(this.f104b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void b() {
            this.f109g = null;
            this.f110h = null;
            this.f111i = null;
            this.f106d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @m0
        public MediaSessionCompat.Token c() {
            if (this.f111i == null) {
                this.f111i = MediaSessionCompat.Token.b(android.support.v4.media.a.i(this.f104b));
            }
            return this.f111i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @m0
        public String d() {
            return android.support.v4.media.a.g(this.f104b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void e() {
            Bundle bundleF = android.support.v4.media.a.f(this.f104b);
            if (bundleF == null) {
                return;
            }
            this.f108f = bundleF.getInt(androidx.media.c.f8652q, 0);
            IBinder iBinderA = r.a(bundleF, androidx.media.c.f8653r);
            if (iBinderA != null) {
                this.f109g = new l(iBinderA, this.f105c);
                Messenger messenger = new Messenger(this.f106d);
                this.f110h = messenger;
                this.f106d.a(messenger);
                try {
                    this.f109g.e(this.f103a, this.f110h);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.f75b, "Remote error registering client messenger.");
                }
            }
            android.support.v4.media.session.b bVarI0 = android.support.v4.media.session.b.a.i0(r.a(bundleF, androidx.media.c.f8654s));
            if (bVarI0 != null) {
                this.f111i = MediaSessionCompat.Token.d(android.support.v4.media.a.i(this.f104b), bVarI0);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void f() {
            Messenger messenger;
            l lVar = this.f109g;
            if (lVar != null && (messenger = this.f110h) != null) {
                try {
                    lVar.j(messenger);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.f75b, "Remote error unregistering client messenger.");
                }
            }
            android.support.v4.media.a.e(this.f104b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void g() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @o0
        public Bundle getExtras() {
            return android.support.v4.media.a.f(this.f104b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h(@m0 String str, Bundle bundle, @o0 c cVar) {
            if (!a()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            if (this.f109g == null) {
                Log.i(MediaBrowserCompat.f75b, "The connected service doesn't support sendCustomAction.");
                if (cVar != null) {
                    this.f106d.post(new RunnableC0007f(cVar, str, bundle));
                }
            }
            try {
                this.f109g.h(str, bundle, new CustomActionResultReceiver(str, bundle, cVar, this.f106d), this.f110h);
            } catch (RemoteException e8) {
                Log.i(MediaBrowserCompat.f75b, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e8);
                if (cVar != null) {
                    this.f106d.post(new g(cVar, str, bundle));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void i(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public ComponentName j() {
            return android.support.v4.media.a.h(this.f104b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void k(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f110h != messenger) {
                return;
            }
            m mVar = this.f107e.get(str);
            if (mVar == null) {
                if (MediaBrowserCompat.f76c) {
                    Log.d(MediaBrowserCompat.f75b, "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            n nVarA = mVar.a(bundle);
            if (nVarA != null) {
                if (bundle == null) {
                    if (list == null) {
                        nVarA.c(str);
                        return;
                    }
                    this.f112j = bundle2;
                    nVarA.a(str, list);
                    this.f112j = null;
                    return;
                }
                if (list == null) {
                    nVarA.d(str, bundle);
                    return;
                }
                this.f112j = bundle2;
                nVarA.b(str, list, bundle);
                this.f112j = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void l(@m0 String str, @m0 d dVar) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (dVar == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!android.support.v4.media.a.j(this.f104b)) {
                Log.i(MediaBrowserCompat.f75b, "Not connected, unable to retrieve the MediaItem.");
                this.f106d.post(new a(dVar, str));
                return;
            }
            if (this.f109g == null) {
                this.f106d.post(new b(dVar, str));
                return;
            }
            try {
                this.f109g.d(str, new ItemReceiver(str, dVar, this.f106d), this.f110h);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.f75b, "Remote error getting media item: " + str);
                this.f106d.post(new c(dVar, str));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void m() {
            android.support.v4.media.a.a(this.f104b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void n(@m0 String str, Bundle bundle, @m0 n nVar) {
            m mVar = this.f107e.get(str);
            if (mVar == null) {
                mVar = new m();
                this.f107e.put(str, mVar);
            }
            nVar.e(mVar);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            mVar.e(bundle2, nVar);
            l lVar = this.f109g;
            if (lVar == null) {
                android.support.v4.media.a.k(this.f104b, str, nVar.f183a);
                return;
            }
            try {
                lVar.a(str, nVar.f184b, bundle2, this.f110h);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.f75b, "Remote error subscribing media item: " + str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void o(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void p(@m0 String str, n nVar) {
            m mVar = this.f107e.get(str);
            if (mVar == null) {
                return;
            }
            l lVar = this.f109g;
            if (lVar != null) {
                try {
                    if (nVar == null) {
                        lVar.f(str, null, this.f110h);
                    } else {
                        List<n> listB = mVar.b();
                        List<Bundle> listC = mVar.c();
                        for (int size = listB.size() - 1; size >= 0; size--) {
                            if (listB.get(size) == nVar) {
                                this.f109g.f(str, nVar.f184b, this.f110h);
                                listB.remove(size);
                                listC.remove(size);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.f75b, "removeSubscription failed with RemoteException parentId=" + str);
                }
            } else if (nVar == null) {
                android.support.v4.media.a.l(this.f104b, str);
            } else {
                List<n> listB2 = mVar.b();
                List<Bundle> listC2 = mVar.c();
                for (int size2 = listB2.size() - 1; size2 >= 0; size2--) {
                    if (listB2.get(size2) == nVar) {
                        listB2.remove(size2);
                        listC2.remove(size2);
                    }
                }
                if (listB2.size() == 0) {
                    android.support.v4.media.a.l(this.f104b, str);
                }
            }
            if (mVar.d() || nVar == null) {
                this.f107e.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void q(@m0 String str, Bundle bundle, @m0 k kVar) {
            if (!a()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.f109g == null) {
                Log.i(MediaBrowserCompat.f75b, "The connected service doesn't support search.");
                this.f106d.post(new d(kVar, str, bundle));
                return;
            }
            try {
                this.f109g.g(str, bundle, new SearchResultReceiver(str, bundle, kVar, this.f106d), this.f110h);
            } catch (RemoteException e8) {
                Log.i(MediaBrowserCompat.f75b, "Remote error searching items with query: " + str, e8);
                this.f106d.post(new e(kVar, str, bundle));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public Bundle r() {
            return this.f112j;
        }
    }

    @t0(23)
    static class g extends f {
        g(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f, android.support.v4.media.MediaBrowserCompat.e
        public void l(@m0 String str, @m0 d dVar) {
            if (this.f109g == null) {
                android.support.v4.media.b.b(this.f104b, str, dVar.f101a);
            } else {
                super.l(str, dVar);
            }
        }
    }

    @t0(26)
    static class h extends g {
        h(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f, android.support.v4.media.MediaBrowserCompat.e
        public void n(@m0 String str, @o0 Bundle bundle, @m0 n nVar) {
            if (this.f109g != null && this.f108f >= 2) {
                super.n(str, bundle, nVar);
            } else if (bundle == null) {
                android.support.v4.media.a.k(this.f104b, str, nVar.f183a);
            } else {
                android.support.v4.media.e.b(this.f104b, str, bundle, nVar.f183a);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f, android.support.v4.media.MediaBrowserCompat.e
        public void p(@m0 String str, n nVar) {
            if (this.f109g != null && this.f108f >= 2) {
                super.p(str, nVar);
            } else if (nVar == null) {
                android.support.v4.media.a.l(this.f104b, str);
            } else {
                android.support.v4.media.e.c(this.f104b, str, nVar.f183a);
            }
        }
    }

    static class i implements e, j {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final int f138o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final int f139p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final int f140q = 2;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final int f141r = 3;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final int f142s = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ComponentName f144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final b f145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Bundle f146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final a f147e = new a(this);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final androidx.collection.a<String, m> f148f = new androidx.collection.a<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f149g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        g f150h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        l f151i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Messenger f152j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f153k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private MediaSessionCompat.Token f154l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Bundle f155m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Bundle f156n;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zBindService;
                i iVar = i.this;
                if (iVar.f149g == 0) {
                    return;
                }
                iVar.f149g = 2;
                if (MediaBrowserCompat.f76c && iVar.f150h != null) {
                    throw new RuntimeException("mServiceConnection should be null. Instead it is " + i.this.f150h);
                }
                if (iVar.f151i != null) {
                    throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + i.this.f151i);
                }
                if (iVar.f152j != null) {
                    throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + i.this.f152j);
                }
                Intent intent = new Intent(MediaBrowserServiceCompat.f8506i);
                intent.setComponent(i.this.f144b);
                i iVar2 = i.this;
                iVar2.f150h = iVar2.new g();
                try {
                    i iVar3 = i.this;
                    zBindService = iVar3.f143a.bindService(intent, iVar3.f150h, 1);
                } catch (Exception unused) {
                    Log.e(MediaBrowserCompat.f75b, "Failed binding to service " + i.this.f144b);
                    zBindService = false;
                }
                if (!zBindService) {
                    i.this.e();
                    i.this.f145c.b();
                }
                if (MediaBrowserCompat.f76c) {
                    Log.d(MediaBrowserCompat.f75b, "connect...");
                    i.this.b();
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                Messenger messenger = iVar.f152j;
                if (messenger != null) {
                    try {
                        iVar.f151i.c(messenger);
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserCompat.f75b, "RemoteException during connect for " + i.this.f144b);
                    }
                }
                i iVar2 = i.this;
                int i7 = iVar2.f149g;
                iVar2.e();
                if (i7 != 0) {
                    i.this.f149g = i7;
                }
                if (MediaBrowserCompat.f76c) {
                    Log.d(MediaBrowserCompat.f75b, "disconnect...");
                    i.this.b();
                }
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f159a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f160b;

            c(d dVar, String str) {
                this.f159a = dVar;
                this.f160b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f159a.a(this.f160b);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f162a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f163b;

            d(d dVar, String str) {
                this.f162a = dVar;
                this.f163b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f162a.a(this.f163b);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f165a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f166b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f167c;

            e(k kVar, String str, Bundle bundle) {
                this.f165a = kVar;
                this.f166b = str;
                this.f167c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f165a.a(this.f166b, this.f167c);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f169a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f170b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f171c;

            f(c cVar, String str, Bundle bundle) {
                this.f169a = cVar;
                this.f170b = str;
                this.f171c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f169a.a(this.f170b, this.f171c, null);
            }
        }

        private class g implements ServiceConnection {

            class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ ComponentName f174a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ IBinder f175b;

                a(ComponentName componentName, IBinder iBinder) {
                    this.f174a = componentName;
                    this.f175b = iBinder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z7 = MediaBrowserCompat.f76c;
                    if (z7) {
                        Log.d(MediaBrowserCompat.f75b, "MediaServiceConnection.onServiceConnected name=" + this.f174a + " binder=" + this.f175b);
                        i.this.b();
                    }
                    if (g.this.a("onServiceConnected")) {
                        i iVar = i.this;
                        iVar.f151i = new l(this.f175b, iVar.f146d);
                        i.this.f152j = new Messenger(i.this.f147e);
                        i iVar2 = i.this;
                        iVar2.f147e.a(iVar2.f152j);
                        i.this.f149g = 2;
                        if (z7) {
                            try {
                                Log.d(MediaBrowserCompat.f75b, "ServiceCallbacks.onConnect...");
                                i.this.b();
                            } catch (RemoteException unused) {
                                Log.w(MediaBrowserCompat.f75b, "RemoteException during connect for " + i.this.f144b);
                                if (MediaBrowserCompat.f76c) {
                                    Log.d(MediaBrowserCompat.f75b, "ServiceCallbacks.onConnect...");
                                    i.this.b();
                                    return;
                                }
                                return;
                            }
                        }
                        i iVar3 = i.this;
                        iVar3.f151i.b(iVar3.f143a, iVar3.f152j);
                    }
                }
            }

            class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ ComponentName f177a;

                b(ComponentName componentName) {
                    this.f177a = componentName;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserCompat.f76c) {
                        Log.d(MediaBrowserCompat.f75b, "MediaServiceConnection.onServiceDisconnected name=" + this.f177a + " this=" + this + " mServiceConnection=" + i.this.f150h);
                        i.this.b();
                    }
                    if (g.this.a("onServiceDisconnected")) {
                        i iVar = i.this;
                        iVar.f151i = null;
                        iVar.f152j = null;
                        iVar.f147e.a(null);
                        i iVar2 = i.this;
                        iVar2.f149g = 4;
                        iVar2.f145c.c();
                    }
                }
            }

            g() {
            }

            private void b(Runnable runnable) {
                if (Thread.currentThread() == i.this.f147e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    i.this.f147e.post(runnable);
                }
            }

            boolean a(String str) {
                int i7;
                i iVar = i.this;
                if (iVar.f150h == this && (i7 = iVar.f149g) != 0 && i7 != 1) {
                    return true;
                }
                int i8 = iVar.f149g;
                if (i8 == 0 || i8 == 1) {
                    return false;
                }
                Log.i(MediaBrowserCompat.f75b, str + " for " + i.this.f144b + " with mServiceConnection=" + i.this.f150h + " this=" + this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                b(new a(componentName, iBinder));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                b(new b(componentName));
            }
        }

        public i(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (bVar == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.f143a = context;
            this.f144b = componentName;
            this.f145c = bVar;
            this.f146d = bundle == null ? null : new Bundle(bundle);
        }

        private static String g(int i7) {
            if (i7 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i7 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i7 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i7 == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i7 == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i7;
        }

        private boolean s(Messenger messenger, String str) {
            int i7;
            if (this.f152j == messenger && (i7 = this.f149g) != 0 && i7 != 1) {
                return true;
            }
            int i8 = this.f149g;
            if (i8 == 0 || i8 == 1) {
                return false;
            }
            Log.i(MediaBrowserCompat.f75b, str + " for " + this.f144b + " with mCallbacksMessenger=" + this.f152j + " this=" + this);
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public boolean a() {
            return this.f149g == 3;
        }

        void b() {
            Log.d(MediaBrowserCompat.f75b, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.f75b, "  mServiceComponent=" + this.f144b);
            Log.d(MediaBrowserCompat.f75b, "  mCallback=" + this.f145c);
            Log.d(MediaBrowserCompat.f75b, "  mRootHints=" + this.f146d);
            Log.d(MediaBrowserCompat.f75b, "  mState=" + g(this.f149g));
            Log.d(MediaBrowserCompat.f75b, "  mServiceConnection=" + this.f150h);
            Log.d(MediaBrowserCompat.f75b, "  mServiceBinderWrapper=" + this.f151i);
            Log.d(MediaBrowserCompat.f75b, "  mCallbacksMessenger=" + this.f152j);
            Log.d(MediaBrowserCompat.f75b, "  mRootId=" + this.f153k);
            Log.d(MediaBrowserCompat.f75b, "  mMediaSessionToken=" + this.f154l);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @m0
        public MediaSessionCompat.Token c() {
            if (a()) {
                return this.f154l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f149g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @m0
        public String d() {
            if (a()) {
                return this.f153k;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + g(this.f149g) + ")");
        }

        void e() {
            g gVar = this.f150h;
            if (gVar != null) {
                this.f143a.unbindService(gVar);
            }
            this.f149g = 1;
            this.f150h = null;
            this.f151i = null;
            this.f152j = null;
            this.f147e.a(null);
            this.f153k = null;
            this.f154l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void f() {
            this.f149g = 0;
            this.f147e.post(new b());
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @o0
        public Bundle getExtras() {
            if (a()) {
                return this.f155m;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + g(this.f149g) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h(@m0 String str, Bundle bundle, @o0 c cVar) {
            if (!a()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            try {
                this.f151i.h(str, bundle, new CustomActionResultReceiver(str, bundle, cVar, this.f147e), this.f152j);
            } catch (RemoteException e8) {
                Log.i(MediaBrowserCompat.f75b, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e8);
                if (cVar != null) {
                    this.f147e.post(new f(cVar, str, bundle));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void i(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (s(messenger, "onConnect")) {
                if (this.f149g != 2) {
                    Log.w(MediaBrowserCompat.f75b, "onConnect from service while mState=" + g(this.f149g) + "... ignoring");
                    return;
                }
                this.f153k = str;
                this.f154l = token;
                this.f155m = bundle;
                this.f149g = 3;
                if (MediaBrowserCompat.f76c) {
                    Log.d(MediaBrowserCompat.f75b, "ServiceCallbacks.onConnect...");
                    b();
                }
                this.f145c.a();
                try {
                    for (Map.Entry<String, m> entry : this.f148f.entrySet()) {
                        String key = entry.getKey();
                        m value = entry.getValue();
                        List<n> listB = value.b();
                        List<Bundle> listC = value.c();
                        for (int i7 = 0; i7 < listB.size(); i7++) {
                            this.f151i.a(key, listB.get(i7).f184b, listC.get(i7), this.f152j);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.f75b, "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @m0
        public ComponentName j() {
            if (a()) {
                return this.f144b;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f149g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void k(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (s(messenger, "onLoadChildren")) {
                boolean z7 = MediaBrowserCompat.f76c;
                if (z7) {
                    Log.d(MediaBrowserCompat.f75b, "onLoadChildren for " + this.f144b + " id=" + str);
                }
                m mVar = this.f148f.get(str);
                if (mVar == null) {
                    if (z7) {
                        Log.d(MediaBrowserCompat.f75b, "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                n nVarA = mVar.a(bundle);
                if (nVarA != null) {
                    if (bundle == null) {
                        if (list == null) {
                            nVarA.c(str);
                            return;
                        }
                        this.f156n = bundle2;
                        nVarA.a(str, list);
                        this.f156n = null;
                        return;
                    }
                    if (list == null) {
                        nVarA.d(str, bundle);
                        return;
                    }
                    this.f156n = bundle2;
                    nVarA.b(str, list, bundle);
                    this.f156n = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void l(@m0 String str, @m0 d dVar) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (dVar == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!a()) {
                Log.i(MediaBrowserCompat.f75b, "Not connected, unable to retrieve the MediaItem.");
                this.f147e.post(new c(dVar, str));
                return;
            }
            try {
                this.f151i.d(str, new ItemReceiver(str, dVar, this.f147e), this.f152j);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.f75b, "Remote error getting media item: " + str);
                this.f147e.post(new d(dVar, str));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void m() {
            int i7 = this.f149g;
            if (i7 == 0 || i7 == 1) {
                this.f149g = 2;
                this.f147e.post(new a());
            } else {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + g(this.f149g) + ")");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void n(@m0 String str, Bundle bundle, @m0 n nVar) {
            m mVar = this.f148f.get(str);
            if (mVar == null) {
                mVar = new m();
                this.f148f.put(str, mVar);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            mVar.e(bundle2, nVar);
            if (a()) {
                try {
                    this.f151i.a(str, nVar.f184b, bundle2, this.f152j);
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.f75b, "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void o(Messenger messenger) {
            Log.e(MediaBrowserCompat.f75b, "onConnectFailed for " + this.f144b);
            if (s(messenger, "onConnectFailed")) {
                if (this.f149g == 2) {
                    e();
                    this.f145c.b();
                    return;
                }
                Log.w(MediaBrowserCompat.f75b, "onConnect from service while mState=" + g(this.f149g) + "... ignoring");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void p(@m0 String str, n nVar) {
            m mVar = this.f148f.get(str);
            if (mVar == null) {
                return;
            }
            try {
                if (nVar != null) {
                    List<n> listB = mVar.b();
                    List<Bundle> listC = mVar.c();
                    for (int size = listB.size() - 1; size >= 0; size--) {
                        if (listB.get(size) == nVar) {
                            if (a()) {
                                this.f151i.f(str, nVar.f184b, this.f152j);
                            }
                            listB.remove(size);
                            listC.remove(size);
                        }
                    }
                } else if (a()) {
                    this.f151i.f(str, null, this.f152j);
                }
            } catch (RemoteException unused) {
                Log.d(MediaBrowserCompat.f75b, "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (mVar.d() || nVar == null) {
                this.f148f.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void q(@m0 String str, Bundle bundle, @m0 k kVar) {
            if (!a()) {
                throw new IllegalStateException("search() called while not connected (state=" + g(this.f149g) + ")");
            }
            try {
                this.f151i.g(str, bundle, new SearchResultReceiver(str, bundle, kVar, this.f147e), this.f152j);
            } catch (RemoteException e8) {
                Log.i(MediaBrowserCompat.f75b, "Remote error searching items with query: " + str, e8);
                this.f147e.post(new e(kVar, str, bundle));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public Bundle r() {
            return this.f156n;
        }
    }

    interface j {
        void i(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void k(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void o(Messenger messenger);
    }

    public static abstract class k {
        public void a(@m0 String str, Bundle bundle) {
        }

        public void b(@m0 String str, Bundle bundle, @m0 List<MediaItem> list) {
        }
    }

    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f180b;

        public l(IBinder iBinder, Bundle bundle) {
            this.f179a = new Messenger(iBinder);
            this.f180b = bundle;
        }

        private void i(int i7, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i7;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f179a.send(messageObtain);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(androidx.media.c.f8639d, str);
            r.b(bundle2, androidx.media.c.f8636a, iBinder);
            bundle2.putBundle(androidx.media.c.f8642g, bundle);
            i(3, bundle2, messenger);
        }

        void b(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(androidx.media.c.f8644i, context.getPackageName());
            bundle.putBundle(androidx.media.c.f8646k, this.f180b);
            i(1, bundle, messenger);
        }

        void c(Messenger messenger) throws RemoteException {
            i(2, null, messenger);
        }

        void d(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(androidx.media.c.f8639d, str);
            bundle.putParcelable(androidx.media.c.f8645j, resultReceiver);
            i(5, bundle, messenger);
        }

        void e(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(androidx.media.c.f8644i, context.getPackageName());
            bundle.putBundle(androidx.media.c.f8646k, this.f180b);
            i(6, bundle, messenger);
        }

        void f(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(androidx.media.c.f8639d, str);
            r.b(bundle, androidx.media.c.f8636a, iBinder);
            i(4, bundle, messenger);
        }

        void g(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(androidx.media.c.f8648m, str);
            bundle2.putBundle(androidx.media.c.f8647l, bundle);
            bundle2.putParcelable(androidx.media.c.f8645j, resultReceiver);
            i(8, bundle2, messenger);
        }

        void h(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(androidx.media.c.f8649n, str);
            bundle2.putBundle(androidx.media.c.f8650o, bundle);
            bundle2.putParcelable(androidx.media.c.f8645j, resultReceiver);
            i(9, bundle2, messenger);
        }

        void j(Messenger messenger) throws RemoteException {
            i(7, null, messenger);
        }
    }

    private static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<n> f181a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Bundle> f182b = new ArrayList();

        public n a(Bundle bundle) {
            for (int i7 = 0; i7 < this.f182b.size(); i7++) {
                if (androidx.media.b.a(this.f182b.get(i7), bundle)) {
                    return this.f181a.get(i7);
                }
            }
            return null;
        }

        public List<n> b() {
            return this.f181a;
        }

        public List<Bundle> c() {
            return this.f182b;
        }

        public boolean d() {
            return this.f181a.isEmpty();
        }

        public void e(Bundle bundle, n nVar) {
            for (int i7 = 0; i7 < this.f182b.size(); i7++) {
                if (androidx.media.b.a(this.f182b.get(i7), bundle)) {
                    this.f181a.set(i7, nVar);
                    return;
                }
            }
            this.f181a.add(nVar);
            this.f182b.add(bundle);
        }
    }

    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f184b = new Binder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        WeakReference<m> f185c;

        private class a implements android.support.v4.media.a.d {
            a() {
            }

            @Override // android.support.v4.media.a.d
            public void a(@m0 String str) {
                n.this.c(str);
            }

            @Override // android.support.v4.media.a.d
            public void d(@m0 String str, List<?> list) {
                WeakReference<m> weakReference = n.this.f185c;
                m mVar = weakReference == null ? null : weakReference.get();
                if (mVar == null) {
                    n.this.a(str, MediaItem.b(list));
                    return;
                }
                List<MediaItem> listB = MediaItem.b(list);
                List<n> listB2 = mVar.b();
                List<Bundle> listC = mVar.c();
                for (int i7 = 0; i7 < listB2.size(); i7++) {
                    Bundle bundle = listC.get(i7);
                    if (bundle == null) {
                        n.this.a(str, listB);
                    } else {
                        n.this.b(str, e(listB, bundle), bundle);
                    }
                }
            }

            List<MediaItem> e(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i7 = bundle.getInt(MediaBrowserCompat.f77d, -1);
                int i8 = bundle.getInt(MediaBrowserCompat.f78e, -1);
                if (i7 == -1 && i8 == -1) {
                    return list;
                }
                int i9 = i8 * i7;
                int size = i9 + i8;
                if (i7 < 0 || i8 < 1 || i9 >= list.size()) {
                    return Collections.emptyList();
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i9, size);
            }
        }

        private class b extends a implements android.support.v4.media.e.a {
            b() {
                super();
            }

            @Override // android.support.v4.media.e.a
            public void b(@m0 String str, @m0 Bundle bundle) {
                n.this.d(str, bundle);
            }

            @Override // android.support.v4.media.e.a
            public void c(@m0 String str, List<?> list, @m0 Bundle bundle) {
                n.this.b(str, MediaItem.b(list), bundle);
            }
        }

        public n() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f183a = android.support.v4.media.e.a(new b());
            } else {
                this.f183a = android.support.v4.media.a.d(new a());
            }
        }

        public void a(@m0 String str, @m0 List<MediaItem> list) {
        }

        public void b(@m0 String str, @m0 List<MediaItem> list, @m0 Bundle bundle) {
        }

        public void c(@m0 String str) {
        }

        public void d(@m0 String str, @m0 Bundle bundle) {
        }

        void e(m mVar) {
            this.f185c = new WeakReference<>(mVar);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f83a = new h(context, componentName, bVar, bundle);
        } else {
            this.f83a = new g(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        this.f83a.m();
    }

    public void b() {
        this.f83a.f();
    }

    @o0
    public Bundle c() {
        return this.f83a.getExtras();
    }

    public void d(@m0 String str, @m0 d dVar) {
        this.f83a.l(str, dVar);
    }

    @o0
    @x0({x0.a.LIBRARY})
    public Bundle e() {
        return this.f83a.r();
    }

    @m0
    public String f() {
        return this.f83a.d();
    }

    @m0
    public ComponentName g() {
        return this.f83a.j();
    }

    @m0
    public MediaSessionCompat.Token h() {
        return this.f83a.c();
    }

    public boolean i() {
        return this.f83a.a();
    }

    public void j(@m0 String str, Bundle bundle, @m0 k kVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.f83a.q(str, bundle, kVar);
    }

    public void k(@m0 String str, Bundle bundle, @o0 c cVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.f83a.h(str, bundle, cVar);
    }

    public void l(@m0 String str, @m0 Bundle bundle, @m0 n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        }
        this.f83a.n(str, bundle, nVar);
    }

    public void m(@m0 String str, @m0 n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.f83a.n(str, null, nVar);
    }

    public void n(@m0 String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.f83a.p(str, null);
    }

    public void o(@m0 String str, @m0 n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.f83a.p(str, nVar);
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f89c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f90d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f91a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaDescriptionCompat f92b;

        static class a implements Parcelable.Creator<MediaItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i7) {
                return new MediaItem[i7];
            }
        }

        @x0({x0.a.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface b {
        }

        public MediaItem(@m0 MediaDescriptionCompat mediaDescriptionCompat, int i7) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.h())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f91a = i7;
            this.f92b = mediaDescriptionCompat;
        }

        public static MediaItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.a(android.support.v4.media.a.c.a(obj)), android.support.v4.media.a.c.b(obj));
        }

        public static List<MediaItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        @m0
        public MediaDescriptionCompat d() {
            return this.f92b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.f91a;
        }

        @o0
        public String f() {
            return this.f92b.h();
        }

        public boolean g() {
            return (this.f91a & 1) != 0;
        }

        public boolean h() {
            return (this.f91a & 2) != 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f91a + ", mDescription=" + this.f92b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f91a);
            this.f92b.writeToParcel(parcel, i7);
        }

        MediaItem(Parcel parcel) {
            this.f91a = parcel.readInt();
            this.f92b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
