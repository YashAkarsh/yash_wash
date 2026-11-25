package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class b {
    private b() {
    }

    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            return bundle2.getInt(MediaBrowserCompat.f77d, -1) == -1 && bundle2.getInt(MediaBrowserCompat.f78e, -1) == -1;
        }
        if (bundle2 == null) {
            return bundle.getInt(MediaBrowserCompat.f77d, -1) == -1 && bundle.getInt(MediaBrowserCompat.f78e, -1) == -1;
        }
        return bundle.getInt(MediaBrowserCompat.f77d, -1) == bundle2.getInt(MediaBrowserCompat.f77d, -1) && bundle.getInt(MediaBrowserCompat.f78e, -1) == bundle2.getInt(MediaBrowserCompat.f78e, -1);
    }

    public static boolean b(Bundle bundle, Bundle bundle2) {
        int i7;
        int i8;
        int i9;
        int i10 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.f77d, -1);
        int i11 = bundle2 == null ? -1 : bundle2.getInt(MediaBrowserCompat.f77d, -1);
        int i12 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.f78e, -1);
        int i13 = bundle2 == null ? -1 : bundle2.getInt(MediaBrowserCompat.f78e, -1);
        int i14 = Integer.MAX_VALUE;
        if (i10 == -1 || i12 == -1) {
            i7 = Integer.MAX_VALUE;
            i8 = 0;
        } else {
            i8 = i10 * i12;
            i7 = (i12 + i8) - 1;
        }
        if (i11 == -1 || i13 == -1) {
            i9 = 0;
        } else {
            i9 = i11 * i13;
            i14 = (i13 + i9) - 1;
        }
        return i7 >= i9 && i14 >= i8;
    }
}
