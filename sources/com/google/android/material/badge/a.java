package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import c.b0;
import c.g1;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.o;

/* JADX INFO: loaded from: classes.dex */
@b
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f17037a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17038b = "BadgeUtils";

    /* JADX INFO: renamed from: com.google.android.material.badge.a$a, reason: collision with other inner class name */
    static class RunnableC0189a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Toolbar f17039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f17041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f17042d;

        RunnableC0189a(Toolbar toolbar, int i7, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.f17039a = toolbar;
            this.f17040b = i7;
            this.f17041c = badgeDrawable;
            this.f17042d = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView actionMenuItemViewA = o.a(this.f17039a, this.f17040b);
            if (actionMenuItemViewA != null) {
                a.k(this.f17041c, this.f17039a.getResources());
                a.b(this.f17041c, actionMenuItemViewA, this.f17042d);
            }
        }
    }

    private a() {
    }

    public static void a(@m0 BadgeDrawable badgeDrawable, @m0 View view) {
        b(badgeDrawable, view, null);
    }

    public static void b(@m0 BadgeDrawable badgeDrawable, @m0 View view, @o0 FrameLayout frameLayout) {
        j(badgeDrawable, view, frameLayout);
        if (badgeDrawable.p() != null) {
            badgeDrawable.p().setForeground(badgeDrawable);
        } else {
            if (f17037a) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void c(@m0 BadgeDrawable badgeDrawable, @m0 Toolbar toolbar, @b0 int i7) {
        d(badgeDrawable, toolbar, i7, null);
    }

    public static void d(@m0 BadgeDrawable badgeDrawable, @m0 Toolbar toolbar, @b0 int i7, @o0 FrameLayout frameLayout) {
        toolbar.post(new RunnableC0189a(toolbar, i7, badgeDrawable, frameLayout));
    }

    @m0
    public static SparseArray<BadgeDrawable> e(Context context, @m0 ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i7 = 0; i7 < parcelableSparseArray.size(); i7++) {
            int iKeyAt = parcelableSparseArray.keyAt(i7);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i7);
            if (savedState == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(iKeyAt, BadgeDrawable.g(context, savedState));
        }
        return sparseArray;
    }

    @m0
    public static ParcelableSparseArray f(@m0 SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i7 = 0; i7 < sparseArray.size(); i7++) {
            int iKeyAt = sparseArray.keyAt(i7);
            BadgeDrawable badgeDrawableValueAt = sparseArray.valueAt(i7);
            if (badgeDrawableValueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            parcelableSparseArray.put(iKeyAt, badgeDrawableValueAt.t());
        }
        return parcelableSparseArray;
    }

    public static void g(@o0 BadgeDrawable badgeDrawable, @m0 View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (f17037a || badgeDrawable.p() != null) {
            badgeDrawable.p().setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void h(@o0 BadgeDrawable badgeDrawable, @m0 Toolbar toolbar, @b0 int i7) {
        if (badgeDrawable == null) {
            return;
        }
        ActionMenuItemView actionMenuItemViewA = o.a(toolbar, i7);
        if (actionMenuItemViewA != null) {
            i(badgeDrawable);
            g(badgeDrawable, actionMenuItemViewA);
        } else {
            Log.w(f17038b, "Trying to remove badge from a null menuItemView: " + i7);
        }
    }

    @g1
    static void i(BadgeDrawable badgeDrawable) {
        badgeDrawable.z(0);
        badgeDrawable.A(0);
    }

    public static void j(@m0 BadgeDrawable badgeDrawable, @m0 View view, @o0 FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.S(view, frameLayout);
    }

    @g1
    static void k(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.z(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.A(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void l(@m0 Rect rect, float f8, float f9, float f10, float f11) {
        rect.set((int) (f8 - f10), (int) (f9 - f11), (int) (f8 + f10), (int) (f9 + f11));
    }
}
