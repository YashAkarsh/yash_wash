package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(23)
class f {

    static class a extends e.b {
        a(Context context, b bVar) {
            super(context, bVar);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((b) this.f8664a).a(str, new e.c<>(result));
        }
    }

    public interface b extends e.d {
        void a(String str, e.c<Parcel> cVar);
    }

    private f() {
    }

    public static Object a(Context context, b bVar) {
        return new a(context, bVar);
    }
}
