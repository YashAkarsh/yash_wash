package com.haier.library.common.b;

import android.text.TextUtils;
import com.haier.library.common.util.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f26406k = 1000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f26407l = 100;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f26408m = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f26409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Timer f26411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f26412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.library.common.thread.m f26413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f26415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f26416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f26417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f26418j;

    class a extends com.haier.library.common.thread.m<Void, Void, f<List<o>>> {

        /* JADX INFO: renamed from: com.haier.library.common.b.n$a$a, reason: collision with other inner class name */
        class C0349a extends TimerTask {
            C0349a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!n.this.w()) {
                    n.this.B();
                }
                c cVarH = n.this.h(false);
                if (cVarH == null) {
                    n.this.B();
                } else {
                    n.this.H(cVarH);
                }
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.haier.library.common.thread.m
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public f<List<o>> doInBackground(Void... voidArr) {
            n.this.f26409a = 0.0d;
            n.this.v(new C0349a());
            return n.this.G();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.haier.library.common.thread.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(f<List<o>> fVar) {
            c cVarH = n.this.h(true);
            if (cVarH == null || fVar == null) {
                return;
            }
            if (fVar.a() == 0) {
                n.this.n(cVarH, fVar.d());
            } else {
                n.this.m(cVarH, "ping fail");
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f26421a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f26422b = 100;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f26423c = 64;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f26424d = 500;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f26425e = 1000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f26426f = true;

        public b a(int i7, int i8) {
            this.f26422b = i7;
            this.f26423c = i8;
            return this;
        }

        public b b(long j7) {
            this.f26424d = j7;
            return this;
        }

        public b c(List<String> list) {
            this.f26421a = list;
            return this;
        }

        public b d(boolean z7) {
            this.f26426f = z7;
            return this;
        }

        public n e() {
            n nVar = new n(null);
            nVar.f26414f = this.f26422b;
            nVar.f26415g = this.f26423c;
            nVar.f26416h = this.f26424d;
            nVar.f26417i = this.f26425e;
            nVar.f26418j = this.f26421a;
            nVar.f26410b = this.f26426f;
            return nVar;
        }

        public b f(long j7) {
            this.f26425e = j7;
            return this;
        }
    }

    public interface c {
        void a(double d8);

        void a(String str);

        void a(List<o> list);
    }

    private class d extends Exception {
        private d() {
        }

        /* synthetic */ d(n nVar, a aVar) {
            this();
        }
    }

    private class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Process f26428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        InputStream f26429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        BufferedReader f26430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        StringBuffer f26431d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        o f26432e;

        private e() {
        }

        /* synthetic */ e(n nVar, a aVar) {
            this();
        }
    }

    public class f<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private R f26434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f26435b;

        public f() {
        }

        public int a() {
            return this.f26435b;
        }

        public void b(int i7) {
            this.f26435b = i7;
        }

        public void c(R r7) {
            this.f26434a = r7;
        }

        public R d() {
            return this.f26434a;
        }
    }

    /* synthetic */ n(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        Timer timer = this.f26411c;
        if (timer != null) {
            timer.cancel();
        }
    }

    private synchronized void C(c cVar) {
        this.f26412d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<List<o>> G() {
        f<List<o>> fVar = new f<>();
        fVar.b(-1);
        a aVar = null;
        if (u.h(this.f26418j)) {
            fVar.c(null);
            fVar.b(-1);
            return fVar;
        }
        ArrayList<e> arrayList = new ArrayList();
        try {
            try {
                for (String str : this.f26418j) {
                    o oVar = new o();
                    oVar.d(str);
                    oVar.k(this.f26415g);
                    e eVarZ = z(str);
                    if (eVarZ == null) {
                        throw new d(this, aVar);
                    }
                    arrayList.add(eVarZ);
                    eVarZ.f26432e = oVar;
                }
                double d8 = 0.0d;
                while (true) {
                    double d9 = 1.0d;
                    int i7 = 0;
                    for (e eVar : arrayList) {
                        String line = eVar.f26430c.readLine();
                        if (line != null) {
                            StringBuffer stringBuffer = eVar.f26431d;
                            stringBuffer.append(line);
                            stringBuffer.append("\n");
                            u(line, eVar.f26432e);
                        } else {
                            i7++;
                        }
                        double size = ((double) eVar.f26432e.r().size()) / ((double) this.f26415g);
                        if (d9 > size) {
                            d9 = size;
                        }
                    }
                    if (!w() || d8 > this.f26409a) {
                        throw new d(this, null);
                    }
                    k(d9);
                    if (i7 == arrayList.size()) {
                        fVar.b(0);
                        for (e eVar2 : arrayList) {
                            try {
                                BufferedReader bufferedReader = eVar2.f26430c;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                InputStream inputStream = eVar2.f26429b;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (IOException e8) {
                                e3.a.v("close onePing stream get Excp %s", e8);
                            }
                            Process process = eVar2.f26428a;
                            if (process != null) {
                                process.destroy();
                            }
                        }
                        break;
                    }
                    d8 = d9;
                }
            } catch (Exception e9) {
                e3.a.v("tryPingWithUrls get Excp %s", e9);
                for (e eVar3 : arrayList) {
                    try {
                        BufferedReader bufferedReader2 = eVar3.f26430c;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        InputStream inputStream2 = eVar3.f26429b;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (IOException e10) {
                        e3.a.v("close onePing stream get Excp %s", e10);
                    }
                    Process process2 = eVar3.f26428a;
                    if (process2 != null) {
                        process2.destroy();
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (e eVar4 : arrayList) {
                arrayList2.add(eVar4.f26432e);
                e3.a.e("ping result:" + ((Object) eVar4.f26431d), new Object[0]);
            }
            fVar.c(arrayList2);
            return fVar;
        } catch (Throwable th) {
            for (e eVar5 : arrayList) {
                try {
                    BufferedReader bufferedReader3 = eVar5.f26430c;
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    InputStream inputStream3 = eVar5.f26429b;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                } catch (IOException e11) {
                    e3.a.v("close onePing stream get Excp %s", e11);
                }
                Process process3 = eVar5.f26428a;
                if (process3 != null) {
                    process3.destroy();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(c cVar) {
        if (cVar == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.library.common.b.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f26403a.I();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        c cVar = this.f26412d;
        if (cVar != null) {
            cVar.a(this.f26409a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c h(boolean z7) {
        c cVar;
        cVar = this.f26412d;
        if (z7) {
            C(null);
        }
        return cVar;
    }

    private String i(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str3) && str3.contains(str) && str3.contains(str2)) ? str3.substring(str3.indexOf(str) + str.length(), str3.indexOf(str2)) : "";
    }

    private void k(double d8) {
        this.f26409a = d8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final c cVar, final String str) {
        if (cVar == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.library.common.b.k
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final c cVar, final List<o> list) {
        if (cVar == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.library.common.b.m
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a((List<o>) list);
            }
        });
    }

    private void u(String str, o oVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (str.contains("icmp_seq")) {
                q qVar = new q();
                qVar.f(System.currentTimeMillis());
                qVar.b(Double.valueOf(i("time=", " ms", str)).doubleValue());
                oVar.r().put(Integer.valueOf(i("icmp_seq=", " ttl", str)), qVar);
            } else if (str.contains("received")) {
                oVar.c(Integer.valueOf(str.substring(0, str.indexOf(" packets transmitted"))).intValue());
                oVar.h(Integer.valueOf(i("transmitted, ", " received", str)).intValue());
                oVar.b(Double.valueOf(i("received, ", "% packet loss", str)).doubleValue() / 100.0d);
            } else if (str.contains("rtt min/avg/max")) {
                String[] strArrSplit = i("min/avg/max/mdev = ", " ms", str).split("/");
                oVar.j(Double.valueOf(strArrSplit[0]).doubleValue());
                oVar.m(Double.valueOf(strArrSplit[1]).doubleValue());
                oVar.g(Double.valueOf(strArrSplit[2]).doubleValue());
            }
        } catch (Exception e8) {
            e3.a.h("parsePingResult fail !!! srcStr = %s, exp = %s", str, e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(TimerTask timerTask) {
        if (this.f26410b) {
            B();
            Timer timer = new Timer();
            this.f26411c = timer;
            timer.schedule(timerTask, 0L, 1000L);
        }
    }

    private e z(String str) {
        e eVar = new e(this, null);
        try {
            String str2 = String.format(Locale.ENGLISH, "ping -c %d -s %d -i %s -W %d %s", Integer.valueOf(this.f26414f), Integer.valueOf(this.f26415g - 8), new DecimalFormat("0.0").format(this.f26416h / 1000.0d), Long.valueOf(this.f26417i / 1000), str);
            e3.a.e(str2, new Object[0]);
            Process processExec = Runtime.getRuntime().exec(str2);
            eVar.f26428a = processExec;
            eVar.f26429b = processExec.getInputStream();
            eVar.f26430c = new BufferedReader(new InputStreamReader(eVar.f26429b));
            eVar.f26431d = new StringBuffer();
        } catch (Exception e8) {
            e3.a.v("getPingMaterial getExcp %s", e8);
        }
        return eVar;
    }

    public void l(c cVar) {
        if (w()) {
            m(cVar, "in ping");
        } else {
            C(cVar);
            this.f26413e = new a().execute(new Void[0]);
        }
    }

    public void t(String str) {
        com.haier.library.common.thread.m mVar = this.f26413e;
        if (mVar != null) {
            mVar.cancel(true);
        }
        c cVarH = h(true);
        if (str == null) {
            str = "ping stop";
        }
        m(cVarH, str);
    }

    public boolean w() {
        return h(false) != null;
    }

    private n() {
        this.f26409a = 0.0d;
    }
}
