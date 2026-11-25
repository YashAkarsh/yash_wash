package com.haier.globalwasher.view.custom_view.xlist;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.n;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class XListViewFooter extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25995g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25996h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25997i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25998j = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f26000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f26001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f26002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AnimationDrawable f26003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    LinearLayout f26004f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XListViewFooter.this.f26003e.start();
        }
    }

    public XListViewFooter(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        this.f25999a = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.xlistview_footer, (ViewGroup) null);
        addView(linearLayout);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f26004f = (LinearLayout) linearLayout.findViewById(R.id.lly_parent);
        this.f26000b = linearLayout.findViewById(R.id.xlistview_footer_content);
        this.f26001c = (ImageView) linearLayout.findViewById(R.id.xlistview_footer_progressbar);
        this.f26002d = (TextView) linearLayout.findViewById(R.id.xlistview_footer_hint_textview);
        this.f26001c.setBackgroundResource(R.drawable.frame_loadboy);
        this.f26003e = (AnimationDrawable) this.f26001c.getBackground();
    }

    public void a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26000b.getLayoutParams();
        layoutParams.height = 0;
        this.f26000b.setLayoutParams(layoutParams);
    }

    public void c() {
        this.f26002d.setVisibility(8);
        this.f26001c.setVisibility(0);
    }

    public void d() {
        this.f26002d.setVisibility(0);
        this.f26001c.setVisibility(8);
    }

    public void e() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26000b.getLayoutParams();
        layoutParams.height = -2;
        this.f26000b.setLayoutParams(layoutParams);
    }

    public int getBottomMargin() {
        return ((LinearLayout.LayoutParams) this.f26000b.getLayoutParams()).bottomMargin;
    }

    public void setBottomMargin(int i7) {
        if (i7 < 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f26000b.getLayoutParams();
        layoutParams.bottomMargin = i7;
        this.f26000b.setLayoutParams(layoutParams);
    }

    public void setFootScroolBackground(@n int i7) {
        this.f26000b.setBackgroundColor(getResources().getColor(i7, null));
    }

    public void setState(int i7) {
        this.f26002d.setVisibility(4);
        this.f26001c.setVisibility(4);
        this.f26002d.setVisibility(4);
        if (i7 == 1) {
            this.f26002d.setVisibility(0);
            this.f26002d.setText(R.string.xlistview_footer_anim_normal);
            if (this.f26003e != null) {
                this.f26001c.post(new a());
                return;
            }
            return;
        }
        if (i7 == 2) {
            this.f26001c.setVisibility(0);
        } else if (i7 == 3) {
            this.f26002d.setVisibility(0);
            this.f26002d.setText(R.string.xlistview_footer_hint_nodata);
        } else {
            this.f26002d.setVisibility(8);
            this.f26002d.setText(R.string.xlistview_footer_hint_normal);
        }
    }

    public XListViewFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
