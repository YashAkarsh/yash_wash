package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1007a;

    private a(Context context) {
        this.f1007a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f1007a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f1007a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f1007a.getResources().getConfiguration();
        int i7 = configuration.screenWidthDp;
        int i8 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i7 > 600) {
            return 5;
        }
        if (i7 > 960 && i8 > 720) {
            return 5;
        }
        if (i7 > 720 && i8 > 960) {
            return 5;
        }
        if (i7 >= 500) {
            return 4;
        }
        if (i7 > 640 && i8 > 480) {
            return 4;
        }
        if (i7 <= 480 || i8 <= 640) {
            return i7 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f1007a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.f1007a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f1007a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f1007a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean h() {
        return true;
    }
}
