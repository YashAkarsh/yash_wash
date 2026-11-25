package com.haier.globalwasher.view.custom_view.seekbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ThumbView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RangeSeekBar f25898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f25903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f25906i;

    public interface a {
        void a(int i7);

        void b(int i7);
    }

    public ThumbView(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f25905h;
    }

    public int getCenterX() {
        return this.f25904g;
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        this.f25903f = new Rect(i7, i8, i9, i10);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        this.f25900c = getMeasuredWidth();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f25899b = (int) motionEvent.getX();
            this.f25905h = false;
        } else if (action == 1) {
            this.f25905h = false;
            this.f25898a.invalidate();
        } else if (action == 2) {
            int x7 = (int) motionEvent.getX();
            Rect rect = this.f25903f;
            int i7 = rect.left + x7;
            int i8 = this.f25899b;
            int i9 = (rect.right + x7) - i8;
            this.f25905h = true;
            setCenterX(((i7 - i8) + i9) / 2);
        }
        return true;
    }

    public void setCenterX(int i7) {
        float f8;
        double d8;
        double d9;
        float f9;
        float f10;
        float f11;
        float f12;
        int i8 = this.f25900c;
        int i9 = i7 - (i8 / 2);
        int i10 = (i8 / 2) + i7;
        int i11 = this.f25901d;
        if (i7 < i11) {
            i9 = i11 - (i8 / 2);
            i10 = (i8 / 2) + i11;
        }
        int i12 = this.f25902e;
        if (i7 > i12) {
            i9 = i12 - (i8 / 2);
            i10 = i12 + (i8 / 2);
        }
        float f13 = i12 / 12.0f;
        int i13 = (int) (i9 / f13);
        if (i13 > 11) {
            i13 = 0;
        }
        int i14 = 1;
        int i15 = i13 + 1;
        if (i15 > 1) {
            i14 = 12;
            if (i15 < 12) {
                i14 = i15;
            }
        }
        int i16 = (int) (i14 * f13);
        int i17 = i16 - (i8 / 2);
        int i18 = i16 + (i8 / 2);
        this.f25904g = i17;
        switch (i14) {
            case 1:
                i17 -= 6;
                i18 -= 6;
                break;
            case 2:
                i17 -= 8;
                i18 -= 8;
                break;
            case 3:
                i17 -= 12;
                i18 -= 12;
                break;
            case 4:
            case 5:
                float f14 = f13 / 3.0f;
                i17 = ((int) (i17 - f14)) + 11;
                i18 = ((int) (i18 - f14)) + 11;
                break;
            case 6:
                float f15 = f13 / 3.0f;
                i17 = ((int) (i17 - f15)) + 9;
                i18 = ((int) (i18 - f15)) + 9;
                break;
            case 7:
                f8 = f13 / 3.0f;
                d8 = i17 - f8;
                d9 = 5.5d;
                i17 = (int) (d8 + d9);
                i18 = (int) (((double) (i18 - f8)) + d9);
                break;
            case 8:
                float f16 = f13 / 3.0f;
                i17 = (int) ((i17 - f16) + 1.0f);
                f9 = (i18 - f16) + 1.0f;
                i18 = (int) f9;
                break;
            case 9:
                f8 = f13 / 2.0f;
                d8 = i17 - f8;
                d9 = 9.5d;
                i17 = (int) (d8 + d9);
                i18 = (int) (((double) (i18 - f8)) + d9);
                break;
            case 10:
                f10 = f13 / 2.0f;
                f11 = i17 - f10;
                f12 = 6.0f;
                i17 = (int) (f11 + f12);
                i18 = (int) ((i18 - f10) + f12);
                break;
            case 11:
                f10 = f13 / 2.0f;
                f11 = i17 - f10;
                f12 = 4.0f;
                i17 = (int) (f11 + f12);
                i18 = (int) ((i18 - f10) + f12);
                break;
            case 12:
                float f17 = f13 / 2.0f;
                i17 = (int) (i17 - f17);
                f9 = i18 - f17;
                i18 = (int) f9;
                break;
        }
        Rect rect = this.f25903f;
        if (i17 == rect.left && i18 == rect.right) {
            return;
        }
        rect.union(i17, rect.top, i18, rect.bottom);
        Rect rect2 = this.f25903f;
        layout(i17, rect2.top, i18, rect2.bottom);
        this.f25898a.invalidate();
        a aVar = this.f25906i;
        if (aVar != null) {
            aVar.b(i14);
            a aVar2 = this.f25906i;
            int i19 = this.f25901d;
            aVar2.a(((((i9 + i10) / 2) - i19) * 120) / (this.f25902e - i19));
        }
    }

    public void setLimit(int i7, int i8) {
        this.f25901d = i7;
        this.f25902e = i8;
    }

    public void setOnThumbListener(a aVar) {
        this.f25906i = aVar;
    }

    public void setRangeSeekBar(RangeSeekBar rangeSeekBar) {
        this.f25898a = rangeSeekBar;
    }

    public ThumbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThumbView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25899b = 0;
        this.f25901d = 0;
        this.f25902e = Integer.MAX_VALUE;
    }

    public void setCenterX(int i7, int i8) {
        float f8;
        double d8;
        double d9;
        float f9;
        float f10;
        float f11;
        float f12;
        int i9 = this.f25900c;
        int i10 = i7 - (i9 / 2);
        int i11 = (i9 / 2) + i7;
        int i12 = this.f25901d;
        if (i7 < i12) {
            i10 = i12 - (i9 / 2);
            i11 = (i9 / 2) + i12;
        }
        int i13 = this.f25902e;
        if (i7 > i13) {
            i10 = i13 - (i9 / 2);
            i11 = i13 + (i9 / 2);
        }
        float f13 = i13 / 12.0f;
        int i14 = (int) (i10 / f13);
        if (i14 > 11) {
            i14 = 0;
        }
        int i15 = i14 + 1;
        if (i15 <= 1) {
            i15 = 1;
        } else if (i15 >= 12) {
            i15 = 12;
        }
        if (i8 == 1) {
            i8 = i15;
        }
        int i16 = (int) (i8 * f13);
        int i17 = i16 - (i9 / 2);
        int i18 = i16 + (i9 / 2);
        this.f25904g = i17;
        switch (i8) {
            case 1:
                i17 -= 6;
                i18 -= 6;
                break;
            case 2:
                i17 -= 8;
                i18 -= 8;
                break;
            case 3:
                i17 -= 12;
                i18 -= 12;
                break;
            case 4:
            case 5:
                float f14 = f13 / 3.0f;
                i17 = ((int) (i17 - f14)) + 11;
                i18 = ((int) (i18 - f14)) + 11;
                break;
            case 6:
                float f15 = f13 / 3.0f;
                i17 = ((int) (i17 - f15)) + 9;
                i18 = ((int) (i18 - f15)) + 9;
                break;
            case 7:
                f8 = f13 / 3.0f;
                d8 = i17 - f8;
                d9 = 5.5d;
                i17 = (int) (d8 + d9);
                i18 = (int) (((double) (i18 - f8)) + d9);
                break;
            case 8:
                float f16 = f13 / 3.0f;
                i17 = (int) ((i17 - f16) + 1.0f);
                f9 = (i18 - f16) + 1.0f;
                i18 = (int) f9;
                break;
            case 9:
                f8 = f13 / 2.0f;
                d8 = i17 - f8;
                d9 = 9.5d;
                i17 = (int) (d8 + d9);
                i18 = (int) (((double) (i18 - f8)) + d9);
                break;
            case 10:
                f10 = f13 / 2.0f;
                f11 = i17 - f10;
                f12 = 6.0f;
                i17 = (int) (f11 + f12);
                i18 = (int) ((i18 - f10) + f12);
                break;
            case 11:
                f10 = f13 / 2.0f;
                f11 = i17 - f10;
                f12 = 4.0f;
                i17 = (int) (f11 + f12);
                i18 = (int) ((i18 - f10) + f12);
                break;
            case 12:
                float f17 = f13 / 2.0f;
                i17 = (int) (i17 - f17);
                f9 = i18 - f17;
                i18 = (int) f9;
                break;
        }
        Rect rect = this.f25903f;
        if (i17 == rect.left && i18 == rect.right) {
            return;
        }
        rect.union(i17, rect.top, i18, rect.bottom);
        Rect rect2 = this.f25903f;
        layout(i17, rect2.top, i18, rect2.bottom);
        this.f25898a.invalidate();
        a aVar = this.f25906i;
        if (aVar != null) {
            aVar.b(i8);
            int i19 = this.f25902e;
            int i20 = this.f25901d;
            if (i19 - i20 == 0) {
                this.f25906i.a(0);
            } else {
                this.f25906i.a(((((i10 + i11) / 2) - i20) * 120) / (i19 - i20));
            }
        }
    }
}
