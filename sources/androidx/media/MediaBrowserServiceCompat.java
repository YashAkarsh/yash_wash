package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
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
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.r;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f8503f = "MBServiceCompat";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final boolean f8504g = Log.isLoggable(f8503f, 3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f8505h = 1.0E-5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8506i = "android.media.browse.MediaBrowserService";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f8507j = "media_item";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final String f8508k = "search_results";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f8509l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f8510m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f8511n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final int f8512o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final int f8513p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public static final int f8514q = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f8515a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    f f8517c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    MediaSessionCompat.Token f8519e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final androidx.collection.a<IBinder, f> f8516b = new androidx.collection.a<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final q f8518d = new q();

    class a extends m<List<MediaBrowserCompat.MediaItem>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f8520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f8521h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Bundle f8522i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Bundle f8523j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f8520g = fVar;
            this.f8521h = str;
            this.f8522i = bundle;
            this.f8523j = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f8516b.get(this.f8520g.f8542f.asBinder()) != this.f8520g) {
                if (MediaBrowserServiceCompat.f8504g) {
                    Log.d(MediaBrowserServiceCompat.f8503f, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f8520g.f8537a + " id=" + this.f8521h);
                    return;
                }
                return;
            }
            if ((c() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.f8522i);
            }
            try {
                this.f8520g.f8542f.a(this.f8521h, list, this.f8522i, this.f8523j);
            } catch (RemoteException unused) {
                Log.w(MediaBrowserServiceCompat.f8503f, "Calling onLoadChildren() failed for id=" + this.f8521h + " package=" + this.f8520g.f8537a);
            }
        }
    }

    class b extends m<MediaBrowserCompat.MediaItem> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f8525g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f8525g = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(MediaBrowserCompat.MediaItem mediaItem) {
            if ((c() & 2) != 0) {
                this.f8525g.b(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaBrowserServiceCompat.f8507j, mediaItem);
            this.f8525g.b(0, bundle);
        }
    }

    class c extends m<List<MediaBrowserCompat.MediaItem>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f8527g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f8527g = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(List<MediaBrowserCompat.MediaItem> list) {
            if ((c() & 4) != 0 || list == null) {
                this.f8527g.b(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(MediaBrowserServiceCompat.f8508k, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f8527g.b(0, bundle);
        }
    }

    class d extends m<Bundle> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f8529g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f8529g = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        void e(Bundle bundle) {
            this.f8529g.b(-1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.m
        void f(Bundle bundle) {
            this.f8529g.b(1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(Bundle bundle) {
            this.f8529g.b(0, bundle);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f8531c = "android.service.media.extra.RECENT";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f8532d = "android.service.media.extra.OFFLINE";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f8533e = "android.service.media.extra.SUGGESTED";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public static final String f8534f = "android.service.media.extra.SUGGESTION_KEYWORDS";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f8536b;

        public e(@m0 String str, @o0 Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.f8535a = str;
            this.f8536b = bundle;
        }

        public Bundle a() {
            return this.f8536b;
        }

        public String b() {
            return this.f8535a;
        }
    }

    private class f implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.media.j.b f8540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f8541e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final o f8542f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap<String, List<androidx.core.util.s<IBinder, Bundle>>> f8543g = new HashMap<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e f8544h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.f8516b.remove(fVar.f8542f.asBinder());
            }
        }

        f(String str, int i7, int i8, Bundle bundle, o oVar) {
            this.f8537a = str;
            this.f8538b = i7;
            this.f8539c = i8;
            this.f8540d = new androidx.media.j.b(str, i7, i8);
            this.f8541e = bundle;
            this.f8542f = oVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f8518d.post(new a());
        }
    }

    interface g {
        Bundle b();

        void c(androidx.media.j.b bVar, String str, Bundle bundle);

        androidx.media.j.b e();

        IBinder f(Intent intent);

        void i(String str, Bundle bundle);

        void j();

        void k(MediaSessionCompat.Token token);
    }

    @t0(21)
    class h implements g, androidx.media.e.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<Bundle> f8547a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f8548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Messenger f8549c;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionCompat.Token f8551a;

            a(MediaSessionCompat.Token token) {
                this.f8551a = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!h.this.f8547a.isEmpty()) {
                    android.support.v4.media.session.b bVarE = this.f8551a.e();
                    if (bVarE != null) {
                        Iterator<Bundle> it = h.this.f8547a.iterator();
                        while (it.hasNext()) {
                            r.b(it.next(), androidx.media.c.f8654s, bVarE.asBinder());
                        }
                    }
                    h.this.f8547a.clear();
                }
                androidx.media.e.e(h.this.f8548b, this.f8551a.g());
            }
        }

        class b extends m<List<MediaBrowserCompat.MediaItem>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ androidx.media.e.c f8553g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Object obj, androidx.media.e.c cVar) {
                super(obj);
                this.f8553g = cVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.m
            public void b() {
                this.f8553g.a();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.m
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public void g(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f8553g.c(arrayList);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8555a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f8556b;

            c(String str, Bundle bundle) {
                this.f8555a = str;
                this.f8556b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.f8516b.keySet().iterator();
                while (it.hasNext()) {
                    h.this.n(MediaBrowserServiceCompat.this.f8516b.get(it.next()), this.f8555a, this.f8556b);
                }
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.media.j.b f8558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8559b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f8560c;

            d(androidx.media.j.b bVar, String str, Bundle bundle) {
                this.f8558a = bVar;
                this.f8559b = str;
                this.f8560c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i7 = 0; i7 < MediaBrowserServiceCompat.this.f8516b.size(); i7++) {
                    f fVarO = MediaBrowserServiceCompat.this.f8516b.o(i7);
                    if (fVarO.f8540d.equals(this.f8558a)) {
                        h.this.n(fVarO, this.f8559b, this.f8560c);
                    }
                }
            }
        }

        h() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public Bundle b() {
            if (this.f8549c == null) {
                return null;
            }
            f fVar = MediaBrowserServiceCompat.this.f8517c;
            if (fVar == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (fVar.f8541e == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f8517c.f8541e);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void c(androidx.media.j.b bVar, String str, Bundle bundle) {
            l(bVar, str, bundle);
        }

        @Override // androidx.media.e.d
        public void d(String str, androidx.media.e.c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.m(str, new b(str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public androidx.media.j.b e() {
            f fVar = MediaBrowserServiceCompat.this.f8517c;
            if (fVar != null) {
                return fVar.f8540d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder f(Intent intent) {
            return androidx.media.e.c(this.f8548b, intent);
        }

        @Override // androidx.media.e.d
        public androidx.media.e.a h(String str, int i7, Bundle bundle) {
            Bundle bundleA;
            if (bundle == null || bundle.getInt(androidx.media.c.f8651p, 0) == 0) {
                bundleA = null;
            } else {
                bundle.remove(androidx.media.c.f8651p);
                this.f8549c = new Messenger(MediaBrowserServiceCompat.this.f8518d);
                bundleA = new Bundle();
                bundleA.putInt(androidx.media.c.f8652q, 2);
                r.b(bundleA, androidx.media.c.f8653r, this.f8549c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f8519e;
                if (token != null) {
                    android.support.v4.media.session.b bVarE = token.e();
                    r.b(bundleA, androidx.media.c.f8654s, bVarE == null ? null : bVarE.asBinder());
                } else {
                    this.f8547a.add(bundleA);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f8517c = mediaBrowserServiceCompat.new f(str, -1, i7, bundle, null);
            e eVarL = MediaBrowserServiceCompat.this.l(str, i7, bundle);
            MediaBrowserServiceCompat.this.f8517c = null;
            if (eVarL == null) {
                return null;
            }
            if (bundleA == null) {
                bundleA = eVarL.a();
            } else if (eVarL.a() != null) {
                bundleA.putAll(eVarL.a());
            }
            return new androidx.media.e.a(eVarL.b(), bundleA);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void i(String str, Bundle bundle) {
            o(str, bundle);
            m(str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void j() {
            Object objA = androidx.media.e.a(MediaBrowserServiceCompat.this, this);
            this.f8548b = objA;
            androidx.media.e.d(objA);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void k(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f8518d.a(new a(token));
        }

        void l(androidx.media.j.b bVar, String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f8518d.post(new d(bVar, str, bundle));
        }

        void m(String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f8518d.post(new c(str, bundle));
        }

        void n(f fVar, String str, Bundle bundle) {
            List<androidx.core.util.s<IBinder, Bundle>> list = fVar.f8543g.get(str);
            if (list != null) {
                for (androidx.core.util.s<IBinder, Bundle> sVar : list) {
                    if (androidx.media.b.b(bundle, sVar.f6388b)) {
                        MediaBrowserServiceCompat.this.t(str, fVar, sVar.f6388b, bundle);
                    }
                }
            }
        }

        void o(String str, Bundle bundle) {
            androidx.media.e.b(this.f8548b, str);
        }
    }

    @t0(23)
    class i extends h implements androidx.media.f.b {

        class a extends m<MediaBrowserCompat.MediaItem> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ androidx.media.e.c f8563g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, androidx.media.e.c cVar) {
                super(obj);
                this.f8563g = cVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.m
            public void b() {
                this.f8563g.a();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.m
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public void g(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f8563g.c(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.f8563g.c(parcelObtain);
            }
        }

        i() {
            super();
        }

        @Override // androidx.media.f.b
        public void a(String str, androidx.media.e.c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.o(str, new a(str, cVar));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void j() {
            Object objA = androidx.media.f.a(MediaBrowserServiceCompat.this, this);
            this.f8548b = objA;
            androidx.media.e.d(objA);
        }
    }

    @t0(26)
    class j extends i implements androidx.media.i.c {

        class a extends m<List<MediaBrowserCompat.MediaItem>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ androidx.media.i.b f8566g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, androidx.media.i.b bVar) {
                super(obj);
                this.f8566g = bVar;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.m
            public void b() {
                this.f8566g.a();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.m
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public void g(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f8566g.c(arrayList, c());
            }
        }

        j() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public Bundle b() {
            f fVar = MediaBrowserServiceCompat.this.f8517c;
            if (fVar == null) {
                return androidx.media.i.b(this.f8548b);
            }
            if (fVar.f8541e == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f8517c.f8541e);
        }

        @Override // androidx.media.i.c
        public void g(String str, androidx.media.i.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.n(str, new a(str, bVar), bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.i, androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public void j() {
            Object objA = androidx.media.i.a(MediaBrowserServiceCompat.this, this);
            this.f8548b = objA;
            androidx.media.e.d(objA);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h
        void o(String str, Bundle bundle) {
            if (bundle != null) {
                androidx.media.i.c(this.f8548b, str, bundle);
            } else {
                super.o(str, bundle);
            }
        }
    }

    @t0(28)
    class k extends j {
        k() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.h, androidx.media.MediaBrowserServiceCompat.g
        public androidx.media.j.b e() {
            f fVar = MediaBrowserServiceCompat.this.f8517c;
            return fVar != null ? fVar.f8540d : new androidx.media.j.b(((MediaBrowserService) this.f8548b).getCurrentBrowserInfo());
        }
    }

    class l implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f8569a;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionCompat.Token f8571a;

            a(MediaSessionCompat.Token token) {
                this.f8571a = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<f> it = MediaBrowserServiceCompat.this.f8516b.values().iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    try {
                        next.f8542f.c(next.f8544h.b(), this.f8571a, next.f8544h.a());
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.f8503f, "Connection for " + next.f8537a + " is no longer valid.");
                        it.remove();
                    }
                }
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8573a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f8574b;

            b(String str, Bundle bundle) {
                this.f8573a = str;
                this.f8574b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.f8516b.keySet().iterator();
                while (it.hasNext()) {
                    l.this.a(MediaBrowserServiceCompat.this.f8516b.get(it.next()), this.f8573a, this.f8574b);
                }
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.media.j.b f8576a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8577b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f8578c;

            c(androidx.media.j.b bVar, String str, Bundle bundle) {
                this.f8576a = bVar;
                this.f8577b = str;
                this.f8578c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i7 = 0; i7 < MediaBrowserServiceCompat.this.f8516b.size(); i7++) {
                    f fVarO = MediaBrowserServiceCompat.this.f8516b.o(i7);
                    if (fVarO.f8540d.equals(this.f8576a)) {
                        l.this.a(fVarO, this.f8577b, this.f8578c);
                        return;
                    }
                }
            }
        }

        l() {
        }

        void a(f fVar, String str, Bundle bundle) {
            List<androidx.core.util.s<IBinder, Bundle>> list = fVar.f8543g.get(str);
            if (list != null) {
                for (androidx.core.util.s<IBinder, Bundle> sVar : list) {
                    if (androidx.media.b.b(bundle, sVar.f6388b)) {
                        MediaBrowserServiceCompat.this.t(str, fVar, sVar.f6388b, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public Bundle b() {
            f fVar = MediaBrowserServiceCompat.this.f8517c;
            if (fVar == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (fVar.f8541e == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f8517c.f8541e);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void c(@m0 androidx.media.j.b bVar, @m0 String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f8518d.post(new c(bVar, str, bundle));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public androidx.media.j.b e() {
            f fVar = MediaBrowserServiceCompat.this.f8517c;
            if (fVar != null) {
                return fVar.f8540d;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder f(Intent intent) {
            if (MediaBrowserServiceCompat.f8506i.equals(intent.getAction())) {
                return this.f8569a.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void i(@m0 String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.f8518d.post(new b(str, bundle));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void j() {
            this.f8569a = new Messenger(MediaBrowserServiceCompat.this.f8518d);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void k(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f8518d.post(new a(token));
        }
    }

    public static class m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f8580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f8582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f8583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f8584e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8585f;

        m(Object obj) {
            this.f8580a = obj;
        }

        private void a(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.f80g)) {
                float f8 = bundle.getFloat(MediaBrowserCompat.f80g);
                if (f8 < -1.0E-5f || f8 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void b() {
            if (this.f8581b) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.f8580a);
            }
            if (this.f8582c) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.f8580a);
            }
            if (!this.f8584e) {
                this.f8581b = true;
                return;
            }
            throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.f8580a);
        }

        int c() {
            return this.f8585f;
        }

        boolean d() {
            return this.f8581b || this.f8582c || this.f8584e;
        }

        void e(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f8580a);
        }

        void f(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.f8580a);
        }

        void g(T t7) {
        }

        public void h(Bundle bundle) {
            if (!this.f8582c && !this.f8584e) {
                this.f8584e = true;
                e(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f8580a);
            }
        }

        public void i(Bundle bundle) {
            if (this.f8582c || this.f8584e) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.f8580a);
            }
            a(bundle);
            this.f8583d = true;
            f(bundle);
        }

        public void j(T t7) {
            if (!this.f8582c && !this.f8584e) {
                this.f8582c = true;
                g(t7);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f8580a);
            }
        }

        void k(int i7) {
            this.f8585f = i7;
        }
    }

    private class n {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8587a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8588b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f8589c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f8590d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f8591e;

            a(o oVar, String str, int i7, int i8, Bundle bundle) {
                this.f8587a = oVar;
                this.f8588b = str;
                this.f8589c = i7;
                this.f8590d = i8;
                this.f8591e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f8587a.asBinder();
                MediaBrowserServiceCompat.this.f8516b.remove(iBinderAsBinder);
                f fVar = MediaBrowserServiceCompat.this.new f(this.f8588b, this.f8589c, this.f8590d, this.f8591e, this.f8587a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f8517c = fVar;
                e eVarL = mediaBrowserServiceCompat.l(this.f8588b, this.f8590d, this.f8591e);
                fVar.f8544h = eVarL;
                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.f8517c = null;
                if (eVarL != null) {
                    try {
                        mediaBrowserServiceCompat2.f8516b.put(iBinderAsBinder, fVar);
                        iBinderAsBinder.linkToDeath(fVar, 0);
                        if (MediaBrowserServiceCompat.this.f8519e != null) {
                            this.f8587a.c(fVar.f8544h.b(), MediaBrowserServiceCompat.this.f8519e, fVar.f8544h.a());
                            return;
                        }
                        return;
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.f8503f, "Calling onConnect() failed. Dropping client. pkg=" + this.f8588b);
                        MediaBrowserServiceCompat.this.f8516b.remove(iBinderAsBinder);
                        return;
                    }
                }
                Log.i(MediaBrowserServiceCompat.f8503f, "No root for client " + this.f8588b + " from service " + getClass().getName());
                try {
                    this.f8587a.b();
                } catch (RemoteException unused2) {
                    Log.w(MediaBrowserServiceCompat.f8503f, "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f8588b);
                }
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8593a;

            b(o oVar) {
                this.f8593a = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVarRemove = MediaBrowserServiceCompat.this.f8516b.remove(this.f8593a.asBinder());
                if (fVarRemove != null) {
                    fVarRemove.f8542f.asBinder().unlinkToDeath(fVarRemove, 0);
                }
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8595a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8596b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ IBinder f8597c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f8598d;

            c(o oVar, String str, IBinder iBinder, Bundle bundle) {
                this.f8595a = oVar;
                this.f8596b = str;
                this.f8597c = iBinder;
                this.f8598d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f8516b.get(this.f8595a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.a(this.f8596b, fVar, this.f8597c, this.f8598d);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f8503f, "addSubscription for callback that isn't registered id=" + this.f8596b);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8600a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8601b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ IBinder f8602c;

            d(o oVar, String str, IBinder iBinder) {
                this.f8600a = oVar;
                this.f8601b = str;
                this.f8602c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f8516b.get(this.f8600a.asBinder());
                if (fVar == null) {
                    Log.w(MediaBrowserServiceCompat.f8503f, "removeSubscription for callback that isn't registered id=" + this.f8601b);
                    return;
                }
                if (MediaBrowserServiceCompat.this.w(this.f8601b, fVar, this.f8602c)) {
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f8503f, "removeSubscription called for " + this.f8601b + " which is not subscribed");
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8604a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8605b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f8606c;

            e(o oVar, String str, ResultReceiver resultReceiver) {
                this.f8604a = oVar;
                this.f8605b = str;
                this.f8606c = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f8516b.get(this.f8604a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.u(this.f8605b, fVar, this.f8606c);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f8503f, "getMediaItem for callback that isn't registered id=" + this.f8605b);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8608a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8609b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f8610c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f8611d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f8612e;

            f(o oVar, String str, int i7, int i8, Bundle bundle) {
                this.f8608a = oVar;
                this.f8609b = str;
                this.f8610c = i7;
                this.f8611d = i8;
                this.f8612e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f8608a.asBinder();
                MediaBrowserServiceCompat.this.f8516b.remove(iBinderAsBinder);
                f fVar = MediaBrowserServiceCompat.this.new f(this.f8609b, this.f8610c, this.f8611d, this.f8612e, this.f8608a);
                MediaBrowserServiceCompat.this.f8516b.put(iBinderAsBinder, fVar);
                try {
                    iBinderAsBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.f8503f, "IBinder is already dead.");
                }
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8614a;

            g(o oVar) {
                this.f8614a = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f8614a.asBinder();
                f fVarRemove = MediaBrowserServiceCompat.this.f8516b.remove(iBinderAsBinder);
                if (fVarRemove != null) {
                    iBinderAsBinder.unlinkToDeath(fVarRemove, 0);
                }
            }
        }

        class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8616a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8617b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f8618c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f8619d;

            h(o oVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f8616a = oVar;
                this.f8617b = str;
                this.f8618c = bundle;
                this.f8619d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f8516b.get(this.f8616a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.v(this.f8617b, this.f8618c, fVar, this.f8619d);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f8503f, "search for callback that isn't registered query=" + this.f8617b);
            }
        }

        class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f8621a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8622b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f8623c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ResultReceiver f8624d;

            i(o oVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f8621a = oVar;
                this.f8622b = str;
                this.f8623c = bundle;
                this.f8624d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f8516b.get(this.f8621a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.s(this.f8622b, this.f8623c, fVar, this.f8624d);
                    return;
                }
                Log.w(MediaBrowserServiceCompat.f8503f, "sendCustomAction for callback that isn't registered action=" + this.f8622b + ", extras=" + this.f8623c);
            }
        }

        n() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, o oVar) {
            MediaBrowserServiceCompat.this.f8518d.a(new c(oVar, str, iBinder, bundle));
        }

        public void b(String str, int i7, int i8, Bundle bundle, o oVar) {
            if (MediaBrowserServiceCompat.this.g(str, i8)) {
                MediaBrowserServiceCompat.this.f8518d.a(new a(oVar, str, i7, i8, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i8 + " package=" + str);
        }

        public void c(o oVar) {
            MediaBrowserServiceCompat.this.f8518d.a(new b(oVar));
        }

        public void d(String str, ResultReceiver resultReceiver, o oVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f8518d.a(new e(oVar, str, resultReceiver));
        }

        public void e(o oVar, String str, int i7, int i8, Bundle bundle) {
            MediaBrowserServiceCompat.this.f8518d.a(new f(oVar, str, i7, i8, bundle));
        }

        public void f(String str, IBinder iBinder, o oVar) {
            MediaBrowserServiceCompat.this.f8518d.a(new d(oVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, o oVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f8518d.a(new h(oVar, str, bundle, resultReceiver));
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, o oVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.f8518d.a(new i(oVar, str, bundle, resultReceiver));
        }

        public void i(o oVar) {
            MediaBrowserServiceCompat.this.f8518d.a(new g(oVar));
        }
    }

    private interface o {
        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();

        void b() throws RemoteException;

        void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;
    }

    private static class p implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Messenger f8626a;

        p(Messenger messenger) {
            this.f8626a = messenger;
        }

        private void d(int i7, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i7;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f8626a.send(messageObtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString(androidx.media.c.f8639d, str);
            bundle3.putBundle(androidx.media.c.f8642g, bundle);
            bundle3.putBundle(androidx.media.c.f8643h, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(androidx.media.c.f8640e, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public IBinder asBinder() {
            return this.f8626a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public void b() throws RemoteException {
            d(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.o
        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(androidx.media.c.f8652q, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(androidx.media.c.f8639d, str);
            bundle2.putParcelable(androidx.media.c.f8641f, token);
            bundle2.putBundle(androidx.media.c.f8646k, bundle);
            d(1, bundle2);
        }
    }

    private final class q extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f8627a;

        q() {
            this.f8627a = MediaBrowserServiceCompat.this.new n();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(androidx.media.c.f8646k);
                    MediaSessionCompat.b(bundle);
                    this.f8627a.b(data.getString(androidx.media.c.f8644i), data.getInt(androidx.media.c.f8638c), data.getInt(androidx.media.c.f8637b), bundle, new p(message.replyTo));
                    break;
                case 2:
                    this.f8627a.c(new p(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle(androidx.media.c.f8642g);
                    MediaSessionCompat.b(bundle2);
                    this.f8627a.a(data.getString(androidx.media.c.f8639d), r.a(data, androidx.media.c.f8636a), bundle2, new p(message.replyTo));
                    break;
                case 4:
                    this.f8627a.f(data.getString(androidx.media.c.f8639d), r.a(data, androidx.media.c.f8636a), new p(message.replyTo));
                    break;
                case 5:
                    this.f8627a.d(data.getString(androidx.media.c.f8639d), (ResultReceiver) data.getParcelable(androidx.media.c.f8645j), new p(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle(androidx.media.c.f8646k);
                    MediaSessionCompat.b(bundle3);
                    this.f8627a.e(new p(message.replyTo), data.getString(androidx.media.c.f8644i), data.getInt(androidx.media.c.f8638c), data.getInt(androidx.media.c.f8637b), bundle3);
                    break;
                case 7:
                    this.f8627a.i(new p(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle(androidx.media.c.f8647l);
                    MediaSessionCompat.b(bundle4);
                    this.f8627a.g(data.getString(androidx.media.c.f8648m), bundle4, (ResultReceiver) data.getParcelable(androidx.media.c.f8645j), new p(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle(androidx.media.c.f8650o);
                    MediaSessionCompat.b(bundle5);
                    this.f8627a.h(data.getString(androidx.media.c.f8649n), bundle5, (ResultReceiver) data.getParcelable(androidx.media.c.f8645j), new p(message.replyTo));
                    break;
                default:
                    Log.w(MediaBrowserServiceCompat.f8503f, "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j7) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(androidx.media.c.f8637b, Binder.getCallingUid());
            data.putInt(androidx.media.c.f8638c, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j7);
        }
    }

    void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.s<IBinder, Bundle>> arrayList = fVar.f8543g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (androidx.core.util.s<IBinder, Bundle> sVar : arrayList) {
            if (iBinder == sVar.f6387a && androidx.media.b.a(bundle, sVar.f6388b)) {
                return;
            }
        }
        arrayList.add(new androidx.core.util.s<>(iBinder, bundle));
        fVar.f8543g.put(str, arrayList);
        t(str, fVar, bundle, null);
        this.f8517c = fVar;
        q(str, bundle);
        this.f8517c = null;
    }

    List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    @x0({x0.a.LIBRARY})
    public void c(Context context) {
        attachBaseContext(context);
    }

    public final Bundle d() {
        return this.f8515a.b();
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @m0
    public final androidx.media.j.b e() {
        return this.f8515a.e();
    }

    @o0
    public MediaSessionCompat.Token f() {
        return this.f8519e;
    }

    boolean g(String str, int i7) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i7)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void h(@m0 androidx.media.j.b bVar, @m0 String str, @m0 Bundle bundle) {
        if (bVar == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.f8515a.c(bVar, str, bundle);
    }

    public void i(@m0 String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.f8515a.i(str, null);
    }

    public void j(@m0 String str, @m0 Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.f8515a.i(str, bundle);
    }

    public void k(@m0 String str, Bundle bundle, @m0 m<Bundle> mVar) {
        mVar.h(null);
    }

    @o0
    public abstract e l(@m0 String str, int i7, @o0 Bundle bundle);

    public abstract void m(@m0 String str, @m0 m<List<MediaBrowserCompat.MediaItem>> mVar);

    public void n(@m0 String str, @m0 m<List<MediaBrowserCompat.MediaItem>> mVar, @m0 Bundle bundle) {
        mVar.k(1);
        m(str, mVar);
    }

    public void o(String str, @m0 m<MediaBrowserCompat.MediaItem> mVar) {
        mVar.k(2);
        mVar.j(null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f8515a.f(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            this.f8515a = new k();
        } else if (i7 >= 26) {
            this.f8515a = new j();
        } else {
            this.f8515a = new i();
        }
        this.f8515a.j();
    }

    public void p(@m0 String str, Bundle bundle, @m0 m<List<MediaBrowserCompat.MediaItem>> mVar) {
        mVar.k(4);
        mVar.j(null);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void q(String str, Bundle bundle) {
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void r(String str) {
    }

    void s(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f8517c = fVar;
        k(str, bundle, dVar);
        this.f8517c = null;
        if (dVar.d()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void t(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f8517c = fVar;
        if (bundle == null) {
            m(str, aVar);
        } else {
            n(str, aVar, bundle);
        }
        this.f8517c = null;
        if (aVar.d()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f8537a + " id=" + str);
    }

    void u(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f8517c = fVar;
        o(str, bVar);
        this.f8517c = null;
        if (bVar.d()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void v(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f8517c = fVar;
        p(str, bundle, cVar);
        this.f8517c = null;
        if (cVar.d()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    boolean w(String str, f fVar, IBinder iBinder) {
        boolean z7 = false;
        try {
            if (iBinder == null) {
                boolean z8 = fVar.f8543g.remove(str) != null;
                this.f8517c = fVar;
                r(str);
                this.f8517c = null;
                return z8;
            }
            List<androidx.core.util.s<IBinder, Bundle>> list = fVar.f8543g.get(str);
            if (list != null) {
                Iterator<androidx.core.util.s<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().f6387a) {
                        it.remove();
                        z7 = true;
                    }
                }
                if (list.size() == 0) {
                    fVar.f8543g.remove(str);
                }
            }
            this.f8517c = fVar;
            r(str);
            this.f8517c = null;
            return z7;
        } catch (Throwable th) {
            this.f8517c = fVar;
            r(str);
            this.f8517c = null;
            throw th;
        }
    }

    public void x(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.f8519e != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.f8519e = token;
        this.f8515a.k(token);
    }
}
