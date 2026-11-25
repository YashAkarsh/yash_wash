package kotlin.concurrent;

import a7.d;
import a7.e;
import h5.h;
import i5.l;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.a1;
import kotlin.internal.f;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "TimersKt")
public final class c {

    public static final class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l<TimerTask, l2> f34666a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super TimerTask, l2> lVar) {
            this.f34666a = lVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f34666a.z(this);
        }
    }

    @f
    private static final Timer a(String str, boolean z7, long j7, long j8, l<? super TimerTask, l2> action) {
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.scheduleAtFixedRate(new a(action), j7, j8);
        return timerK;
    }

    @f
    private static final Timer b(String str, boolean z7, Date startAt, long j7, l<? super TimerTask, l2> action) {
        l0.p(startAt, "startAt");
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.scheduleAtFixedRate(new a(action), startAt, j7);
        return timerK;
    }

    static /* synthetic */ Timer c(String str, boolean z7, long j7, long j8, l action, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = null;
        }
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        if ((i7 & 4) != 0) {
            j7 = 0;
        }
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.scheduleAtFixedRate(new a(action), j7, j8);
        return timerK;
    }

    static /* synthetic */ Timer d(String str, boolean z7, Date startAt, long j7, l action, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = null;
        }
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        l0.p(startAt, "startAt");
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.scheduleAtFixedRate(new a(action), startAt, j7);
        return timerK;
    }

    @f
    private static final TimerTask e(Timer timer, long j7, long j8, l<? super TimerTask, l2> action) {
        l0.p(timer, "<this>");
        l0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j7, j8);
        return aVar;
    }

    @f
    private static final TimerTask f(Timer timer, long j7, l<? super TimerTask, l2> action) {
        l0.p(timer, "<this>");
        l0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j7);
        return aVar;
    }

    @f
    private static final TimerTask g(Timer timer, Date time, long j7, l<? super TimerTask, l2> action) {
        l0.p(timer, "<this>");
        l0.p(time, "time");
        l0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time, j7);
        return aVar;
    }

    @f
    private static final TimerTask h(Timer timer, Date time, l<? super TimerTask, l2> action) {
        l0.p(timer, "<this>");
        l0.p(time, "time");
        l0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time);
        return aVar;
    }

    @f
    private static final TimerTask i(Timer timer, long j7, long j8, l<? super TimerTask, l2> action) {
        l0.p(timer, "<this>");
        l0.p(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, j7, j8);
        return aVar;
    }

    @f
    private static final TimerTask j(Timer timer, Date time, long j7, l<? super TimerTask, l2> action) {
        l0.p(timer, "<this>");
        l0.p(time, "time");
        l0.p(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, time, j7);
        return aVar;
    }

    @d
    @a1
    public static final Timer k(@e String str, boolean z7) {
        return str == null ? new Timer(z7) : new Timer(str, z7);
    }

    @f
    private static final Timer l(String str, boolean z7, long j7, long j8, l<? super TimerTask, l2> action) {
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.schedule(new a(action), j7, j8);
        return timerK;
    }

    @f
    private static final Timer m(String str, boolean z7, Date startAt, long j7, l<? super TimerTask, l2> action) {
        l0.p(startAt, "startAt");
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.schedule(new a(action), startAt, j7);
        return timerK;
    }

    static /* synthetic */ Timer n(String str, boolean z7, long j7, long j8, l action, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = null;
        }
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        if ((i7 & 4) != 0) {
            j7 = 0;
        }
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.schedule(new a(action), j7, j8);
        return timerK;
    }

    static /* synthetic */ Timer o(String str, boolean z7, Date startAt, long j7, l action, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = null;
        }
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        l0.p(startAt, "startAt");
        l0.p(action, "action");
        Timer timerK = k(str, z7);
        timerK.schedule(new a(action), startAt, j7);
        return timerK;
    }

    @f
    private static final TimerTask p(l<? super TimerTask, l2> action) {
        l0.p(action, "action");
        return new a(action);
    }
}
