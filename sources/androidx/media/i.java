package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import c.t0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(26)
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8666a = "MBSCompatApi26";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Field f8667b;

    static class a extends f.a {
        a(Context context, c cVar) {
            super(context, cVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.b(bundle);
            ((c) this.f8664a).g(str, new b(result), bundle);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f8668a;

        b(MediaBrowserService.Result result) {
            this.f8668a = result;
        }

        public void a() {
            this.f8668a.detach();
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

        public void c(List<Parcel> list, int i7) {
            try {
                i.f8667b.setInt(this.f8668a, i7);
            } catch (IllegalAccessException e8) {
                Log.w(i.f8666a, e8);
            }
            this.f8668a.sendResult(b(list));
        }
    }

    public interface c extends f.b {
        void g(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f8667b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e8) {
            Log.w(f8666a, e8);
        }
    }

    private i() {
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }

    public static Bundle b(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    public static void c(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }
}
