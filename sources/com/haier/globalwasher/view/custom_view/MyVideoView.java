package com.haier.globalwasher.view.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

/* JADX INFO: loaded from: classes2.dex */
public class MyVideoView extends VideoView {
    public MyVideoView(Context context) {
        this(context, null);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        setMeasuredDimension(View.getDefaultSize(0, i7), View.getDefaultSize(0, i8));
    }

    public MyVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyVideoView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
    }
}
