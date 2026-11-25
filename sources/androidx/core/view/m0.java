package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6685a;

    interface a {
        boolean a(MotionEvent motionEvent);

        void b(GestureDetector.OnDoubleTapListener onDoubleTapListener);

        void c(boolean z7);

        boolean d();
    }

    static class b implements a {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final int f6686v = ViewConfiguration.getTapTimeout();

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private static final int f6687w = ViewConfiguration.getDoubleTapTimeout();

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final int f6688x = 1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final int f6689y = 2;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int f6690z = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Handler f6695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final GestureDetector.OnGestureListener f6696f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f6697g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f6698h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f6699i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f6700j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f6701k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f6702l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        MotionEvent f6703m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private MotionEvent f6704n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f6705o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private float f6706p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f6707q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private float f6708r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private float f6709s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f6710t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private VelocityTracker f6711u;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f6695e = new a(handler);
            } else {
                this.f6695e = new a();
            }
            this.f6696f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                b((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            h(context);
        }

        private void e() {
            this.f6695e.removeMessages(1);
            this.f6695e.removeMessages(2);
            this.f6695e.removeMessages(3);
            this.f6711u.recycle();
            this.f6711u = null;
            this.f6705o = false;
            this.f6698h = false;
            this.f6701k = false;
            this.f6702l = false;
            this.f6699i = false;
            if (this.f6700j) {
                this.f6700j = false;
            }
        }

        private void f() {
            this.f6695e.removeMessages(1);
            this.f6695e.removeMessages(2);
            this.f6695e.removeMessages(3);
            this.f6705o = false;
            this.f6701k = false;
            this.f6702l = false;
            this.f6699i = false;
            if (this.f6700j) {
                this.f6700j = false;
            }
        }

        private void h(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f6696f == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.f6710t = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f6693c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f6694d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f6691a = scaledTouchSlop * scaledTouchSlop;
            this.f6692b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean i(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f6702l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f6687w) {
                return false;
            }
            int x7 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y7 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x7 * x7) + (y7 * y7) < this.f6692b;
        }

        @Override // androidx.core.view.m0.a
        public boolean a(MotionEvent motionEvent) {
            boolean zOnDoubleTap;
            MotionEvent motionEvent2;
            boolean zOnFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.f6711u == null) {
                this.f6711u = VelocityTracker.obtain();
            }
            this.f6711u.addMovement(motionEvent);
            int i7 = action & 255;
            boolean z7 = i7 == 6;
            int actionIndex = z7 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float x7 = 0.0f;
            float y7 = 0.0f;
            for (int i8 = 0; i8 < pointerCount; i8++) {
                if (actionIndex != i8) {
                    x7 += motionEvent.getX(i8);
                    y7 += motionEvent.getY(i8);
                }
            }
            float f8 = z7 ? pointerCount - 1 : pointerCount;
            float f9 = x7 / f8;
            float f10 = y7 / f8;
            if (i7 == 0) {
                if (this.f6697g == null) {
                    zOnDoubleTap = false;
                } else {
                    boolean zHasMessages = this.f6695e.hasMessages(3);
                    if (zHasMessages) {
                        this.f6695e.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.f6703m;
                    if (motionEvent3 == null || (motionEvent2 = this.f6704n) == null || !zHasMessages || !i(motionEvent3, motionEvent2, motionEvent)) {
                        this.f6695e.sendEmptyMessageDelayed(3, f6687w);
                        zOnDoubleTap = false;
                    } else {
                        this.f6705o = true;
                        zOnDoubleTap = this.f6697g.onDoubleTap(this.f6703m) | false | this.f6697g.onDoubleTapEvent(motionEvent);
                    }
                }
                this.f6706p = f9;
                this.f6708r = f9;
                this.f6707q = f10;
                this.f6709s = f10;
                MotionEvent motionEvent4 = this.f6703m;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.f6703m = MotionEvent.obtain(motionEvent);
                this.f6701k = true;
                this.f6702l = true;
                this.f6698h = true;
                this.f6700j = false;
                this.f6699i = false;
                if (this.f6710t) {
                    this.f6695e.removeMessages(2);
                    this.f6695e.sendEmptyMessageAtTime(2, this.f6703m.getDownTime() + ((long) f6686v) + ((long) ViewConfiguration.getLongPressTimeout()));
                }
                this.f6695e.sendEmptyMessageAtTime(1, this.f6703m.getDownTime() + ((long) f6686v));
                return zOnDoubleTap | this.f6696f.onDown(motionEvent);
            }
            if (i7 == 1) {
                this.f6698h = false;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                if (this.f6705o) {
                    zOnFling = this.f6697g.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.f6700j) {
                        this.f6695e.removeMessages(3);
                        this.f6700j = false;
                    } else if (this.f6701k) {
                        boolean zOnSingleTapUp = this.f6696f.onSingleTapUp(motionEvent);
                        if (this.f6699i && (onDoubleTapListener = this.f6697g) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        zOnFling = zOnSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.f6711u;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.f6694d);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.f6693c || Math.abs(xVelocity) > this.f6693c) {
                            zOnFling = this.f6696f.onFling(this.f6703m, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    zOnFling = false;
                }
                MotionEvent motionEvent5 = this.f6704n;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.f6704n = motionEventObtain;
                VelocityTracker velocityTracker2 = this.f6711u;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f6711u = null;
                }
                this.f6705o = false;
                this.f6699i = false;
                this.f6695e.removeMessages(1);
                this.f6695e.removeMessages(2);
            } else {
                if (i7 != 2) {
                    if (i7 == 3) {
                        e();
                        return false;
                    }
                    if (i7 == 5) {
                        this.f6706p = f9;
                        this.f6708r = f9;
                        this.f6707q = f10;
                        this.f6709s = f10;
                        f();
                        return false;
                    }
                    if (i7 != 6) {
                        return false;
                    }
                    this.f6706p = f9;
                    this.f6708r = f9;
                    this.f6707q = f10;
                    this.f6709s = f10;
                    this.f6711u.computeCurrentVelocity(1000, this.f6694d);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.f6711u.getXVelocity(pointerId2);
                    float yVelocity2 = this.f6711u.getYVelocity(pointerId2);
                    for (int i9 = 0; i9 < pointerCount; i9++) {
                        if (i9 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i9);
                            if ((this.f6711u.getXVelocity(pointerId3) * xVelocity2) + (this.f6711u.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.f6711u.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
                if (this.f6700j) {
                    return false;
                }
                float f11 = this.f6706p - f9;
                float f12 = this.f6707q - f10;
                if (this.f6705o) {
                    return false | this.f6697g.onDoubleTapEvent(motionEvent);
                }
                if (!this.f6701k) {
                    if (Math.abs(f11) < 1.0f && Math.abs(f12) < 1.0f) {
                        return false;
                    }
                    boolean zOnScroll = this.f6696f.onScroll(this.f6703m, motionEvent, f11, f12);
                    this.f6706p = f9;
                    this.f6707q = f10;
                    return zOnScroll;
                }
                int i10 = (int) (f9 - this.f6708r);
                int i11 = (int) (f10 - this.f6709s);
                int i12 = (i10 * i10) + (i11 * i11);
                if (i12 > this.f6691a) {
                    zOnFling = this.f6696f.onScroll(this.f6703m, motionEvent, f11, f12);
                    this.f6706p = f9;
                    this.f6707q = f10;
                    this.f6701k = false;
                    this.f6695e.removeMessages(3);
                    this.f6695e.removeMessages(1);
                    this.f6695e.removeMessages(2);
                } else {
                    zOnFling = false;
                }
                if (i12 > this.f6691a) {
                    this.f6702l = false;
                }
            }
            return zOnFling;
        }

        @Override // androidx.core.view.m0.a
        public void b(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f6697g = onDoubleTapListener;
        }

        @Override // androidx.core.view.m0.a
        public void c(boolean z7) {
            this.f6710t = z7;
        }

        @Override // androidx.core.view.m0.a
        public boolean d() {
            return this.f6710t;
        }

        void g() {
            this.f6695e.removeMessages(3);
            this.f6699i = false;
            this.f6700j = true;
            this.f6696f.onLongPress(this.f6703m);
        }

        private class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i7 = message.what;
                if (i7 == 1) {
                    b bVar = b.this;
                    bVar.f6696f.onShowPress(bVar.f6703m);
                    return;
                }
                if (i7 == 2) {
                    b.this.g();
                    return;
                }
                if (i7 != 3) {
                    throw new RuntimeException("Unknown message " + message);
                }
                b bVar2 = b.this;
                GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f6697g;
                if (onDoubleTapListener != null) {
                    if (bVar2.f6698h) {
                        bVar2.f6699i = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.f6703m);
                    }
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GestureDetector f6713a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f6713a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.m0.a
        public boolean a(MotionEvent motionEvent) {
            return this.f6713a.onTouchEvent(motionEvent);
        }

        @Override // androidx.core.view.m0.a
        public void b(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f6713a.setOnDoubleTapListener(onDoubleTapListener);
        }

        @Override // androidx.core.view.m0.a
        public void c(boolean z7) {
            this.f6713a.setIsLongpressEnabled(z7);
        }

        @Override // androidx.core.view.m0.a
        public boolean d() {
            return this.f6713a.isLongpressEnabled();
        }
    }

    public m0(@c.m0 Context context, @c.m0 GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a() {
        return this.f6685a.d();
    }

    public boolean b(@c.m0 MotionEvent motionEvent) {
        return this.f6685a.a(motionEvent);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void c(boolean z7) {
        this.f6685a.c(z7);
    }

    public void d(@c.o0 GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f6685a.b(onDoubleTapListener);
    }

    public m0(@c.m0 Context context, @c.m0 GestureDetector.OnGestureListener onGestureListener, @c.o0 Handler handler) {
        this.f6685a = new c(context, onGestureListener, handler);
    }
}
