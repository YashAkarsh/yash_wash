package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DragAndDropPermissions f6590a;

    @c.t0(24)
    static class a {
        private a() {
        }

        @c.t
        static void a(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        @c.t
        static DragAndDropPermissions b(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    private i0(DragAndDropPermissions dragAndDropPermissions) {
        this.f6590a = dragAndDropPermissions;
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public static i0 b(@c.m0 Activity activity, @c.m0 DragEvent dragEvent) {
        DragAndDropPermissions dragAndDropPermissionsB;
        if (Build.VERSION.SDK_INT < 24 || (dragAndDropPermissionsB = a.b(activity, dragEvent)) == null) {
            return null;
        }
        return new i0(dragAndDropPermissionsB);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(this.f6590a);
        }
    }
}
