package easypay.appinvoke;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GestureDetector f33837a;

    /* JADX INFO: renamed from: easypay.appinvoke.b$b, reason: collision with other inner class name */
    private final class C0415b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f33838b = 100;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f33839c = 100;

        private C0415b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
            float x7 = motionEvent2.getX() - motionEvent.getX();
            float y7 = motionEvent2.getY() - motionEvent.getY();
            if (Math.abs(x7) > Math.abs(y7) && Math.abs(x7) > 100.0f && Math.abs(f8) > 100.0f) {
                if (x7 > 0.0f) {
                    b.this.d();
                    return true;
                }
                b.this.c();
                return true;
            }
            if (Math.abs(y7) <= 100.0f || Math.abs(f9) <= 100.0f) {
                return false;
            }
            if (y7 > 0.0f) {
                b.this.b();
                return false;
            }
            b.this.e();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b.this.a();
            return true;
        }
    }

    public b(Context context) {
        this.f33837a = new GestureDetector(context, new C0415b());
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f33837a.onTouchEvent(motionEvent);
    }
}
