package com.haier.globalwasher.view.custom_view.xlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class XListViewHeader extends LinearLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f26006n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f26007o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f26008p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f26009q = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f26010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f26011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationDrawable f26012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f26013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bitmap f26014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f26015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f26016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f26017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f26018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f26019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Animation f26020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Animation f26021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f26022m;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XListViewHeader.this.f26012c.start();
        }
    }

    public XListViewHeader(Context context) {
        super(context);
        this.f26019j = 0;
        this.f26022m = 180;
        b(context);
    }

    private void b(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.xlistview_header, (ViewGroup) null);
        this.f26010a = linearLayout;
        addView(linearLayout, layoutParams);
        setGravity(80);
        this.f26011b = (ImageView) findViewById(R.id.xlistview_header_arrow);
        this.f26016g = (TextView) findViewById(R.id.xlistview_header_last_time);
        this.f26015f = (TextView) findViewById(R.id.xlistview_header_time);
        this.f26017h = (TextView) findViewById(R.id.xlistview_header_hint_textview);
        this.f26018i = (TextView) findViewById(R.id.xlistview_header_load);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f26020k = rotateAnimation;
        rotateAnimation.setDuration(180L);
        this.f26020k.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f26021l = rotateAnimation2;
        rotateAnimation2.setDuration(180L);
        this.f26021l.setFillAfter(true);
        ImageView imageView = (ImageView) findViewById(R.id.loadboyIv);
        this.f26013d = imageView;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.frame_loadboy);
            this.f26012c = (AnimationDrawable) this.f26013d.getBackground();
        }
    }

    protected void c() {
        if (this.f26014e.isRecycled()) {
            return;
        }
        this.f26014e.recycle();
    }

    public int getState() {
        return this.f26019j;
    }

    public int getVisiableHeight() {
        return this.f26010a.getHeight();
    }

    public void setState(int i7) {
        if (i7 == this.f26019j) {
            return;
        }
        if (i7 == 2) {
            this.f26011b.clearAnimation();
            this.f26013d.setVisibility(0);
            this.f26018i.setVisibility(0);
        } else {
            this.f26013d.setVisibility(4);
            this.f26018i.setVisibility(4);
        }
        if (i7 == 0) {
            if (this.f26019j == 1) {
                this.f26011b.startAnimation(this.f26021l);
            }
            if (this.f26019j == 2) {
                this.f26011b.clearAnimation();
            }
            this.f26017h.setText(R.string.xlistview_header_hint_normal);
            this.f26017h.setVisibility(0);
            this.f26015f.setVisibility(0);
            this.f26016g.setVisibility(0);
        } else if (i7 != 1) {
            if (i7 == 2) {
                this.f26013d.post(new a());
                this.f26017h.setVisibility(4);
                this.f26015f.setVisibility(4);
                this.f26016g.setVisibility(4);
            }
        } else if (this.f26019j != 1) {
            this.f26011b.clearAnimation();
            this.f26011b.startAnimation(this.f26020k);
            this.f26017h.setText(R.string.xlistview_header_anim_normal);
            this.f26017h.setVisibility(0);
            this.f26015f.setVisibility(0);
            this.f26016g.setVisibility(0);
        }
        this.f26019j = i7;
    }

    public void setVisiableHeight(int i7) {
        if (i7 < 0) {
            i7 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26010a.getLayoutParams();
        layoutParams.height = i7;
        this.f26010a.setLayoutParams(layoutParams);
    }

    public XListViewHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26019j = 0;
        this.f26022m = 180;
        b(context);
    }
}
