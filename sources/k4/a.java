package k4;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import m4.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f34413j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f34414k = "/sdcard/btsnoop_hci.log";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f34415l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f34416m = 7;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f34417n = {"logcat", "-c"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile a f34418o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f34420b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f34423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f34424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f34425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Process f34426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f34427i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f34419a = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f34421c = "/saveLog/";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f34422d = f34414k;

    public a(Context context, String str, int i7) {
        this.f34427i = context;
        this.f34420b = str;
        this.f34423e = i7;
        i();
    }

    public static a j() {
        return f34418o;
    }

    public static synchronized void k(Context context) {
        f34418o = new a(context.getApplicationContext(), context.getPackageName(), -1);
    }

    public static synchronized void l(Context context, String str) {
        f34418o = new a(context.getApplicationContext(), str, -1);
    }

    public static synchronized void m(Context context, String str, int i7) {
        f34418o = new a(context.getApplicationContext(), str, i7);
    }

    public final void a() {
        if (this.f34423e <= -1) {
            b.e("保留所有日志数据： " + this.f34423e);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 0 - this.f34423e);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        File file = new File(this.f34421c);
        if (!file.exists()) {
            b.s(String.format("%s 不存在", file.getAbsolutePath()));
            return;
        }
        if (!file.isDirectory()) {
            b.s(String.format("%s 不是目录", file.getAbsolutePath()));
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            b.s("日志目录为空" + this.f34421c);
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.isDirectory()) {
                String name = file2.getName();
                String strS = f.s(file2);
                if (!TextUtils.isEmpty(name) && name.length() >= 10 && !TextUtils.isEmpty(strS) && ("logcat".equals(strS) || "cfa".equals(strS))) {
                    try {
                        if (this.f34419a.parse(name.substring(0, 10)).before(calendar.getTime())) {
                            file2.delete();
                        }
                    } catch (ParseException e8) {
                        file2.delete();
                        b.h(e8.toString());
                    }
                }
            }
        }
    }

    public final void b(List<String> list) {
        try {
            String[] strArr = (String[]) list.toArray(new String[list.size()]);
            Runtime.getRuntime().exec(strArr);
            if (f34413j) {
                b.e("[>_]" + Arrays.toString(strArr));
            }
        } catch (Exception e8) {
            b.h(e8.toString());
        }
    }

    public final void c() {
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] strArr = f34417n;
            Process processExec = runtime.exec(strArr);
            if (f34413j) {
                b.e("[>_]" + Arrays.toString(strArr));
            }
            processExec.destroy();
        } catch (Exception e8) {
            b.h(e8.toString());
        }
    }

    public final boolean d() {
        File file = new File(this.f34421c);
        if (file.isDirectory()) {
            return false;
        }
        if (f34413j) {
            b.p("createLogDir start");
        }
        boolean zMkdirs = file.mkdirs();
        if (f34413j) {
            b.p("mkdirs " + zMkdirs);
        }
        return zMkdirs;
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        arrayList.add("-f");
        arrayList.add(this.f34424f);
        arrayList.add("-v");
        arrayList.add("time");
        try {
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.f34426h = Runtime.getRuntime().exec(strArr);
            if (f34413j) {
                b.e("[>_]" + Arrays.toString(strArr));
            }
        } catch (Exception e8) {
            b.h(e8.toString());
        }
    }

    public boolean f() {
        try {
            return new File(this.f34424f).delete();
        } catch (Exception e8) {
            b.h(e8.toString());
            return false;
        }
    }

    public final String g() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + this.f34420b + "/";
        }
        return "/data/data/" + this.f34427i.getPackageName() + "/" + this.f34420b + "/";
    }

    public final String h() {
        InputStreamReader inputStreamReader;
        String line;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(new File("/etc/bluetooth/bt_stack.conf")), "UTF-8");
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
                inputStreamReader = null;
            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        return "/sdcard/btsnoop_hci.cfa";
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                    return "/sdcard/btsnoop_hci.cfa";
                }
            } while (!line.contains("BtSnoopFileName="));
            if (f34413j) {
                b.p("line: " + line);
            }
            return line.substring(16);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "/sdcard/btsnoop_hci.cfa";
        }
    }

    public final void i() {
        this.f34421c = g() + "saveLog/";
        this.f34422d = h();
        b.e(String.format(Locale.US, "mRetionDays=%d, mRootDirName=%s, mSaveLogDir=%s, mHciFilePath==%s", Integer.valueOf(this.f34423e), this.f34420b, this.f34421c, this.f34422d));
        d();
    }

    public void n() {
        o(false);
    }

    public void o(boolean z7) {
        t();
        if (z7) {
            f();
        }
        s();
    }

    public void p() {
        d();
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.f13640m);
        arrayList.add(this.f34422d);
        arrayList.add(this.f34425g);
        b(arrayList);
    }

    public void q() {
        d();
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.f13640m);
        arrayList.add(this.f34422d);
        arrayList.add(this.f34421c + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US).format(new Date()) + ".cfa");
        b(arrayList);
    }

    public void r(int i7) {
        this.f34423e = i7;
    }

    public void s() {
        d();
        String str = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US).format(new Date());
        this.f34424f = this.f34421c + str + ".logcat";
        this.f34425g = this.f34421c + str + "_btsnoop.cfa";
        c();
        e();
        a();
    }

    public void t() {
        Process process = this.f34426h;
        if (process != null) {
            process.destroy();
        }
    }
}
