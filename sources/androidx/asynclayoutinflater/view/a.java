package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.v;
import c.f1;
import c.h0;
import c.m0;
import c.o0;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2053e = "AsyncLayoutInflater";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LayoutInflater f2054a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler.Callback f2057d = new C0028a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Handler f2055b = new Handler(this.f2057d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f2056c = d.b();

    /* JADX INFO: renamed from: androidx.asynclayoutinflater.view.a$a, reason: collision with other inner class name */
    class C0028a implements Handler.Callback {
        C0028a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.f2063d == null) {
                cVar.f2063d = a.this.f2054a.inflate(cVar.f2062c, cVar.f2061b, false);
            }
            cVar.f2064e.a(cVar.f2063d, cVar.f2062c, cVar.f2061b);
            a.this.f2056c.d(cVar);
            return true;
        }
    }

    private static class b extends LayoutInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f2059a = {"android.widget.", "android.webkit.", "android.app."};

        b(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            for (String str2 : f2059a) {
                try {
                    View viewCreateView = createView(str, str2, attributeSet);
                    if (viewCreateView != null) {
                        return viewCreateView;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f2060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f2061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        View f2063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e f2064e;

        c() {
        }
    }

    private static class d extends Thread {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final d f2065c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayBlockingQueue<c> f2066a = new ArrayBlockingQueue<>(10);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private v.c<c> f2067b = new v.c<>(10);

        static {
            d dVar = new d();
            f2065c = dVar;
            dVar.start();
        }

        private d() {
        }

        public static d b() {
            return f2065c;
        }

        public void a(c cVar) {
            try {
                this.f2066a.put(cVar);
            } catch (InterruptedException e8) {
                throw new RuntimeException("Failed to enqueue async inflate request", e8);
            }
        }

        public c c() {
            c cVarB = this.f2067b.b();
            return cVarB == null ? new c() : cVarB;
        }

        public void d(c cVar) {
            cVar.f2064e = null;
            cVar.f2060a = null;
            cVar.f2061b = null;
            cVar.f2062c = 0;
            cVar.f2063d = null;
            this.f2067b.a(cVar);
        }

        public void e() {
            try {
                c cVarTake = this.f2066a.take();
                try {
                    cVarTake.f2063d = cVarTake.f2060a.f2054a.inflate(cVarTake.f2062c, cVarTake.f2061b, false);
                } catch (RuntimeException e8) {
                    Log.w(a.f2053e, "Failed to inflate resource in the background! Retrying on the UI thread", e8);
                }
                Message.obtain(cVarTake.f2060a.f2055b, 0, cVarTake).sendToTarget();
            } catch (InterruptedException e9) {
                Log.w(a.f2053e, e9);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                e();
            }
        }
    }

    public interface e {
        void a(@m0 View view, @h0 int i7, @o0 ViewGroup viewGroup);
    }

    public a(@m0 Context context) {
        this.f2054a = new b(context);
    }

    @f1
    public void a(@h0 int i7, @o0 ViewGroup viewGroup, @m0 e eVar) {
        if (eVar == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        c cVarC = this.f2056c.c();
        cVarC.f2060a = this;
        cVarC.f2062c = i7;
        cVarC.f2061b = viewGroup;
        cVarC.f2064e = eVar;
        this.f2056c.a(cVarC);
    }
}
