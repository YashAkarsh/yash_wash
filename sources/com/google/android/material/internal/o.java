package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import c.b0;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class o {
    private o() {
    }

    @o0
    public static ActionMenuItemView a(@m0 Toolbar toolbar, @b0 int i7) {
        ActionMenuView actionMenuViewB = b(toolbar);
        if (actionMenuViewB == null) {
            return null;
        }
        for (int i8 = 0; i8 < actionMenuViewB.getChildCount(); i8++) {
            View childAt = actionMenuViewB.getChildAt(i8);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i7) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    @o0
    public static ActionMenuView b(@m0 Toolbar toolbar) {
        for (int i7 = 0; i7 < toolbar.getChildCount(); i7++) {
            View childAt = toolbar.getChildAt(i7);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    @o0
    public static ImageButton c(@m0 Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i7 = 0; i7 < toolbar.getChildCount(); i7++) {
            View childAt = toolbar.getChildAt(i7);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    @o0
    public static View d(@m0 Toolbar toolbar) {
        ActionMenuView actionMenuViewB = b(toolbar);
        if (actionMenuViewB == null || actionMenuViewB.getChildCount() <= 1) {
            return null;
        }
        return actionMenuViewB.getChildAt(0);
    }

    @o0
    public static TextView e(@m0 Toolbar toolbar) {
        return f(toolbar, toolbar.getSubtitle());
    }

    @o0
    private static TextView f(@m0 Toolbar toolbar, CharSequence charSequence) {
        for (int i7 = 0; i7 < toolbar.getChildCount(); i7++) {
            View childAt = toolbar.getChildAt(i7);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    @o0
    public static TextView g(@m0 Toolbar toolbar) {
        return f(toolbar, toolbar.getTitle());
    }
}
