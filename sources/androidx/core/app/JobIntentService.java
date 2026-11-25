package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final String f5050h = "JobIntentService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final boolean f5051i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Object f5052j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final HashMap<ComponentName, h> f5053k = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f5054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    h f5055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a f5056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f5057d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f5058e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5059f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ArrayList<d> f5060g;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e eVarA = JobIntentService.this.a();
                if (eVarA == null) {
                    return null;
                }
                JobIntentService.this.h(eVarA.getIntent());
                eVarA.q();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r7) {
            JobIntentService.this.j();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r7) {
            JobIntentService.this.j();
        }
    }

    interface b {
        IBinder a();

        e b();
    }

    static final class c extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Context f5062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final PowerManager.WakeLock f5063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final PowerManager.WakeLock f5064f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f5065g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f5066h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f5062d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f5063e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f5064f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.h
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f5079a);
            if (this.f5062d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f5065g) {
                        this.f5065g = true;
                        if (!this.f5066h) {
                            this.f5063e.acquire(DateUtils.MILLIS_PER_MINUTE);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void c() {
            synchronized (this) {
                if (this.f5066h) {
                    if (this.f5065g) {
                        this.f5063e.acquire(DateUtils.MILLIS_PER_MINUTE);
                    }
                    this.f5066h = false;
                    this.f5064f.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void d() {
            synchronized (this) {
                if (!this.f5066h) {
                    this.f5066h = true;
                    this.f5064f.acquire(600000L);
                    this.f5063e.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.h
        public void e() {
            synchronized (this) {
                this.f5065g = false;
            }
        }
    }

    final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f5067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f5068b;

        d(Intent intent, int i7) {
            this.f5067a = intent;
            this.f5068b = i7;
        }

        @Override // androidx.core.app.JobIntentService.e
        public Intent getIntent() {
            return this.f5067a;
        }

        @Override // androidx.core.app.JobIntentService.e
        public void q() {
            JobIntentService.this.stopSelf(this.f5068b);
        }
    }

    interface e {
        Intent getIntent();

        void q();
    }

    @c.t0(26)
    static final class f extends JobServiceEngine implements b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final String f5070d = "JobServiceEngineImpl";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final boolean f5071e = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JobIntentService f5072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f5073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        JobParameters f5074c;

        final class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final JobWorkItem f5075a;

            a(JobWorkItem jobWorkItem) {
                this.f5075a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.e
            public Intent getIntent() {
                return this.f5075a.getIntent();
            }

            @Override // androidx.core.app.JobIntentService.e
            public void q() {
                synchronized (f.this.f5073b) {
                    JobParameters jobParameters = f.this.f5074c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f5075a);
                    }
                }
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f5073b = new Object();
            this.f5072a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public e b() {
            synchronized (this.f5073b) {
                JobParameters jobParameters = this.f5074c;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                if (jobWorkItemDequeueWork == null) {
                    return null;
                }
                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f5072a.getClassLoader());
                return new a(jobWorkItemDequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f5074c = jobParameters;
            this.f5072a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean zB = this.f5072a.b();
            synchronized (this.f5073b) {
                this.f5074c = null;
            }
            return zB;
        }
    }

    @c.t0(26)
    static final class g extends h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JobInfo f5077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final JobScheduler f5078e;

        g(Context context, ComponentName componentName, int i7) {
            super(componentName);
            b(i7);
            this.f5077d = new JobInfo.Builder(i7, this.f5079a).setOverrideDeadline(0L).build();
            this.f5078e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.h
        void a(Intent intent) {
            JobScheduler jobScheduler = this.f5078e;
            JobInfo jobInfo = this.f5077d;
            e0.a();
            jobScheduler.enqueue(jobInfo, d0.a(intent));
        }
    }

    static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ComponentName f5079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5081c;

        h(ComponentName componentName) {
            this.f5079a = componentName;
        }

        abstract void a(Intent intent);

        void b(int i7) {
            if (!this.f5080b) {
                this.f5080b = true;
                this.f5081c = i7;
            } else {
                if (this.f5081c == i7) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i7 + " is different than previous " + this.f5081c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5060g = null;
        } else {
            this.f5060g = new ArrayList<>();
        }
    }

    public static void c(@c.m0 Context context, @c.m0 ComponentName componentName, int i7, @c.m0 Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f5052j) {
            h hVarF = f(context, componentName, true, i7);
            hVarF.b(i7);
            hVarF.a(intent);
        }
    }

    public static void d(@c.m0 Context context, @c.m0 Class<?> cls, int i7, @c.m0 Intent intent) {
        c(context, new ComponentName(context, cls), i7, intent);
    }

    static h f(Context context, ComponentName componentName, boolean z7, int i7) {
        h cVar;
        HashMap<ComponentName, h> map = f5053k;
        h hVar = map.get(componentName);
        if (hVar != null) {
            return hVar;
        }
        if (Build.VERSION.SDK_INT < 26) {
            cVar = new c(context, componentName);
        } else {
            if (!z7) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            cVar = new g(context, componentName, i7);
        }
        h hVar2 = cVar;
        map.put(componentName, hVar2);
        return hVar2;
    }

    e a() {
        b bVar = this.f5054a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f5060g) {
            if (this.f5060g.size() <= 0) {
                return null;
            }
            return this.f5060g.remove(0);
        }
    }

    boolean b() {
        a aVar = this.f5056c;
        if (aVar != null) {
            aVar.cancel(this.f5057d);
        }
        this.f5058e = true;
        return i();
    }

    void e(boolean z7) {
        if (this.f5056c == null) {
            this.f5056c = new a();
            h hVar = this.f5055b;
            if (hVar != null && z7) {
                hVar.d();
            }
            this.f5056c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean g() {
        return this.f5058e;
    }

    protected abstract void h(@c.m0 Intent intent);

    public boolean i() {
        return true;
    }

    void j() {
        ArrayList<d> arrayList = this.f5060g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f5056c = null;
                ArrayList<d> arrayList2 = this.f5060g;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    e(false);
                } else if (!this.f5059f) {
                    this.f5055b.c();
                }
            }
        }
    }

    public void k(boolean z7) {
        this.f5057d = z7;
    }

    @Override // android.app.Service
    public IBinder onBind(@c.m0 Intent intent) {
        b bVar = this.f5054a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5054a = new f(this);
            this.f5055b = null;
        } else {
            this.f5054a = null;
            this.f5055b = f(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f5060g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f5059f = true;
                this.f5055b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@c.o0 Intent intent, int i7, int i8) {
        if (this.f5060g == null) {
            return 2;
        }
        this.f5055b.e();
        synchronized (this.f5060g) {
            ArrayList<d> arrayList = this.f5060g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i8));
            e(true);
        }
        return 3;
    }
}
