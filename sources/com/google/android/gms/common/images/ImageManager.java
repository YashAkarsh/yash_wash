package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import c.m0;
import c.o0;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.base.j;
import com.google.android.gms.internal.base.o;
import com.google.android.gms.internal.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class ImageManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f15584h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static HashSet<Uri> f15585i = new HashSet<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ImageManager f15586j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f15588b = new p(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f15589c = o.a().a(4, 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j f15590d = new j();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<h, ImageReceiver> f15591e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Uri, ImageReceiver> f15592f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Uri, Long> f15593g = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @KeepName
    final class ImageReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f15594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<h> f15595b;

        ImageReceiver(Uri uri) {
            super(new p(Looper.getMainLooper()));
            this.f15594a = uri;
            this.f15595b = new ArrayList<>();
        }

        public final void b(h hVar) {
            com.google.android.gms.common.internal.d.a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f15595b.add(hVar);
        }

        public final void d(h hVar) {
            com.google.android.gms.common.internal.d.a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f15595b.remove(hVar);
        }

        public final void e() {
            Intent intent = new Intent(com.google.android.gms.common.internal.g.f15735c);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(com.google.android.gms.common.internal.g.f15736d, this.f15594a);
            intent.putExtra(com.google.android.gms.common.internal.g.f15737e, this);
            intent.putExtra(com.google.android.gms.common.internal.g.f15738f, 3);
            ImageManager.this.f15587a.sendBroadcast(intent);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i7, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager imageManager = ImageManager.this;
            imageManager.f15589c.execute(new b(imageManager, this.f15594a, parcelFileDescriptor));
        }
    }

    public interface a {
        void a(@m0 Uri uri, @o0 Drawable drawable, boolean z7);
    }

    private ImageManager(Context context, boolean z7) {
        this.f15587a = context.getApplicationContext();
    }

    @m0
    public static ImageManager a(@m0 Context context) {
        if (f15586j == null) {
            f15586j = new ImageManager(context, false);
        }
        return f15586j;
    }

    public void b(@m0 ImageView imageView, int i7) {
        p(new f(imageView, i7));
    }

    public void c(@m0 ImageView imageView, @m0 Uri uri) {
        p(new f(imageView, uri));
    }

    public void d(@m0 ImageView imageView, @m0 Uri uri, int i7) {
        f fVar = new f(imageView, uri);
        fVar.f15616b = i7;
        p(fVar);
    }

    public void e(@m0 a aVar, @m0 Uri uri) {
        p(new g(aVar, uri));
    }

    public void f(@m0 a aVar, @m0 Uri uri, int i7) {
        g gVar = new g(aVar, uri);
        gVar.f15616b = i7;
        p(gVar);
    }

    public final void p(h hVar) {
        com.google.android.gms.common.internal.d.a("ImageManager.loadImage() must be called in the main thread");
        new c(this, hVar).run();
    }
}
