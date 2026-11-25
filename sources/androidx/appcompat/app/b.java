package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f798a = "ActionBarDrawerToggleHC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f799b = {R.attr.homeAsUpIndicator};

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f802c;

        a(Activity activity) {
            try {
                this.f800a = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f801b = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View viewFindViewById = activity.findViewById(R.id.home);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.f802c = (ImageView) childAt;
                }
            }
        }
    }

    private b() {
    }

    public static Drawable a(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(f799b);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public static a b(a aVar, Activity activity, int i7) {
        if (aVar == null) {
            aVar = new a(activity);
        }
        if (aVar.f800a != null) {
            try {
                aVar.f801b.invoke(activity.getActionBar(), Integer.valueOf(i7));
            } catch (Exception e8) {
                Log.w(f798a, "Couldn't set content description via JB-MR2 API", e8);
            }
        }
        return aVar;
    }

    public static a c(Activity activity, Drawable drawable, int i7) {
        a aVar = new a(activity);
        if (aVar.f800a != null) {
            try {
                android.app.ActionBar actionBar = activity.getActionBar();
                aVar.f800a.invoke(actionBar, drawable);
                aVar.f801b.invoke(actionBar, Integer.valueOf(i7));
            } catch (Exception e8) {
                Log.w(f798a, "Couldn't set home-as-up indicator via JB-MR2 API", e8);
            }
        } else {
            ImageView imageView = aVar.f802c;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            } else {
                Log.w(f798a, "Couldn't set home-as-up indicator");
            }
        }
        return aVar;
    }
}
