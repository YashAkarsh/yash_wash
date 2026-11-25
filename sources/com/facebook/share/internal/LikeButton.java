package com.facebook.share.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.common.R;
import com.facebook.internal.AnalyticsEvents;
import e.a;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LikeButton extends FacebookButtonBase {
    @Deprecated
    public LikeButton(Context context, boolean z7) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LIKE_BUTTON_CREATE, AnalyticsEvents.EVENT_LIKE_BUTTON_DID_TAP);
        setSelected(z7);
    }

    private void updateForLikeStatus() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(R.string.com_facebook_like_button_liked));
        } else {
            setCompoundDrawablesWithIntrinsicBounds(a.b(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
        }
    }

    @Override // com.facebook.FacebookButtonBase
    protected void configureButton(Context context, AttributeSet attributeSet, int i7, int i8) {
        super.configureButton(context, attributeSet, i7, i8);
        updateForLikeStatus();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultRequestCode() {
        return 0;
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return R.style.com_facebook_button_like;
    }

    @Override // android.widget.TextView, android.view.View
    @Deprecated
    public void setSelected(boolean z7) {
        super.setSelected(z7);
        updateForLikeStatus();
    }
}
