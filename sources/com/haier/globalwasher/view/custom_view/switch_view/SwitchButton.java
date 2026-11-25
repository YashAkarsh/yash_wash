package com.haier.globalwasher.view.custom_view.switch_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import c.n;
import c.o0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.utils.n0;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchButton extends View {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f25907z = "SwitchButton";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f25911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f25912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f25913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f25914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f25917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f25918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f25919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f25920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f25921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    RectF f25922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f25923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f25924q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f25925r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f25926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f25927t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f25928u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f25929v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private d f25930w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private c f25931x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    b f25932y;

    class a implements d {
        a() {
        }

        @Override // com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.d
        public void a(SwitchButton switchButton, boolean z7) {
            if (SwitchButton.this.f25914g != null) {
                SwitchButton.this.f25914g.a(switchButton, z7);
            }
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            SwitchButton.this.invalidate();
        }
    }

    private class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f25935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f25936b;

        public c(boolean z7) {
            this.f25935a = z7;
        }

        public boolean a() {
            return this.f25936b;
        }

        public void b(boolean z7) {
            this.f25936b = z7;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:14|(1:16)(1:17)|18|32|19|23|(3:28|(1:9)|(2:12|34)(1:31))(3:25|(1:9)|(2:12|34)(1:31))|10|(2:12|34)(1:31)) */
        /* JADX WARN: Code duplicated, block: B:12:0x0028  */
        /* JADX WARN: Code duplicated, block: B:31:0x0075 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0063 -> B:10:0x0025). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0072 -> B:10:0x0025). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0023 -> B:11:0x0026). Please report as a decompilation issue!!! */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                boolean r0 = r5.f25935a
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L15
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.b(r0)
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.c(r3)
                if (r0 >= r3) goto L25
                goto L23
            L15:
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.b(r0)
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.d(r3)
                if (r0 <= r3) goto L25
            L23:
                r0 = r2
                goto L26
            L25:
                r0 = r1
            L26:
                if (r0 == 0) goto L75
                boolean r0 = r5.f25936b
                if (r0 != 0) goto L75
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                boolean r3 = r5.f25935a
                if (r3 == 0) goto L39
                int r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.b(r0)
                int r3 = r3 + 2
                goto L3f
            L39:
                int r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.b(r0)
                int r3 = r3 + (-2)
            L3f:
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.e(r0, r3)
                r3 = 10
                java.lang.Thread.sleep(r3)     // Catch: java.lang.InterruptedException -> L4f
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this     // Catch: java.lang.InterruptedException -> L4f
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton$b r0 = r0.f25932y     // Catch: java.lang.InterruptedException -> L4f
                r0.sendEmptyMessage(r2)     // Catch: java.lang.InterruptedException -> L4f
                goto L53
            L4f:
                r0 = move-exception
                r0.printStackTrace()
            L53:
                boolean r0 = r5.f25935a
                if (r0 == 0) goto L66
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.b(r0)
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.c(r3)
                if (r0 >= r3) goto L25
                goto L23
            L66:
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r0 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.b(r0)
                com.haier.globalwasher.view.custom_view.switch_view.SwitchButton r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.this
                int r3 = com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.d(r3)
                if (r0 <= r3) goto L25
                goto L23
            L75:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.haier.globalwasher.view.custom_view.switch_view.SwitchButton.c.run():void");
        }
    }

    public interface d {
        void a(SwitchButton switchButton, boolean z7);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    private void f() {
        this.f25912e.setColor(this.f25913f ? this.f25908a : this.f25909b);
    }

    private void i(boolean z7, boolean z8) {
        if (z8 && this.f25914g != null) {
            this.f25930w.a(this, z7);
        }
        this.f25913f = z7;
    }

    public boolean g() {
        return this.f25913f;
    }

    public void h(boolean z7) {
        c cVar = this.f25931x;
        if (cVar != null) {
            cVar.b(true);
        }
        f();
        c cVar2 = new c(z7);
        this.f25931x = cVar2;
        cVar2.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.f25922o, n0.e(this.f25923p), n0.e(this.f25923p), this.f25912e);
        canvas.drawCircle(this.f25920m, this.f25917j / 2, this.f25918k, this.f25911d);
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        setMeasuredDimension(this.f25916i, this.f25917j);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int x7 = (int) motionEvent.getX();
        motionEvent.getY();
        this.f25929v = x7 >= this.f25916i / 2;
        this.f25925r = getRight() - getLeft();
        this.f25926s = getBottom() - getTop();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f25924q = false;
            i(this.f25913f, false);
        } else if (action == 1) {
            this.f25924q = true;
            setChecked(!this.f25913f);
        } else if (action == 2) {
            h(this.f25929v);
        }
        return true;
    }

    public void setChecked(boolean z7) {
        if (z7 != this.f25913f) {
            i(z7, this.f25924q);
        }
        h(z7);
    }

    public void setCloseBackground(@n int i7) {
        this.f25909b = getResources().getColor(i7);
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f25914g = dVar;
    }

    @Override // android.view.View
    public final void setOnClickListener(@o0 View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setOpenBackground(@n int i7) {
        this.f25908a = getResources().getColor(i7);
    }

    @Override // android.view.View
    public void setSelected(boolean z7) {
        throw new l2.a("不可调用此方法");
    }

    public SwitchButton(Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25913f = false;
        this.f25915h = n0.e(1.0f);
        this.f25916i = n0.e(27.0f);
        int iE = n0.e(16.0f);
        this.f25917j = iE;
        int i7 = this.f25915h;
        int i8 = (iE / 2) - i7;
        this.f25918k = i8;
        int i9 = i8 + i7;
        this.f25919l = i9;
        this.f25920m = i9;
        this.f25921n = this.f25916i - i9;
        this.f25923p = 10;
        this.f25924q = false;
        this.f25930w = new a();
        this.f25932y = new b();
        this.f25908a = getResources().getColor(R.color.switth_open_background);
        this.f25909b = getResources().getColor(R.color.switth_close_background);
        this.f25910c = -1;
        Paint paint = new Paint();
        this.f25911d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f25911d.setColor(this.f25910c);
        this.f25911d.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f25912e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f25912e.setColor(this.f25913f ? this.f25908a : this.f25909b);
        this.f25912e.setAntiAlias(true);
        this.f25922o = new RectF(0.0f, 0.0f, this.f25916i, this.f25917j);
        this.f25927t = getX();
        this.f25928u = getY();
        this.f25925r = getRight() - getLeft();
        this.f25926s = getBottom() - getTop();
    }
}
