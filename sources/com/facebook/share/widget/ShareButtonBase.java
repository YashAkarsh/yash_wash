package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareButtonBase extends FacebookButtonBase {
    private boolean enabledExplicitlySet;
    private int requestCode;
    private ShareContent shareContent;

    protected ShareButtonBase(Context context, AttributeSet attributeSet, int i7, String str, String str2) {
        super(context, attributeSet, i7, 0, str, str2);
        this.requestCode = 0;
        this.enabledExplicitlySet = false;
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }

    private void internalSetEnabled(boolean z7) {
        setEnabled(z7);
        this.enabledExplicitlySet = false;
    }

    protected boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    @Override // com.facebook.FacebookButtonBase
    protected void configureButton(Context context, AttributeSet attributeSet, int i7, int i8) {
        super.configureButton(context, attributeSet, i7, i8);
        setInternalOnClickListener(getShareOnClickListener());
    }

    protected abstract FacebookDialogBase<ShareContent, Sharer.Result> getDialog();

    @Override // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    protected View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() { // from class: com.facebook.share.widget.ShareButtonBase.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareButtonBase.this.callExternalOnClickListener(view);
                ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
            }
        };
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, facebookCallback);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.enabledExplicitlySet = true;
    }

    protected void setRequestCode(int i7) {
        if (!FacebookSdk.isFacebookRequestCode(i7)) {
            this.requestCode = i7;
            return;
        }
        throw new IllegalArgumentException("Request code " + i7 + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void setShareContent(ShareContent shareContent) {
        this.shareContent = shareContent;
        if (this.enabledExplicitlySet) {
            return;
        }
        internalSetEnabled(canShare());
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback, int i7) {
        setRequestCode(i7);
        registerCallback(callbackManager, facebookCallback);
    }
}
