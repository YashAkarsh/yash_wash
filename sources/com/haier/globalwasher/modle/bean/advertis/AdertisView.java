package com.haier.globalwasher.modle.bean.advertis;

import android.view.View;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes2.dex */
public class AdertisView {
    View mediaView;
    RadioButton navigation;

    public AdertisView(View view, RadioButton radioButton) {
        this.mediaView = view;
        this.navigation = radioButton;
    }

    public View getMediaView() {
        return this.mediaView;
    }

    public RadioButton getNavigation() {
        return this.navigation;
    }

    public void setMediaView(View view) {
        this.mediaView = view;
    }

    public void setNavigation(RadioButton radioButton) {
        this.navigation = radioButton;
    }
}
