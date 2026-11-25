package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class c extends DataSetObservable {
    private static final Object A = new Object();
    private static final Map<String, c> B = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final boolean f1759n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final String f1760o = "c";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final String f1761p = "historical-records";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final String f1762q = "historical-record";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final String f1763r = "activity";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final String f1764s = "time";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f1765t = "weight";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f1766u = "activity_choser_model_history.xml";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f1767v = 50;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f1768w = 5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final float f1769x = 1.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f1770y = ".xml";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f1771z = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Context f1775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f1776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f1777f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private f f1784m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1772a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f1773b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<e> f1774c = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InterfaceC0025c f1778g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1779h = 50;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1780i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1781j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1782k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1783l = false;

    public interface a {
        void setActivityChooserModel(c cVar);
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolveInfo f1785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1786b;

        public b(ResolveInfo resolveInfo) {
            this.f1785a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return Float.floatToIntBits(bVar.f1786b) - Float.floatToIntBits(this.f1786b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && b.class == obj.getClass() && Float.floatToIntBits(this.f1786b) == Float.floatToIntBits(((b) obj).f1786b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1786b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f1785a.toString() + "; weight:" + new BigDecimal(this.f1786b) + "]";
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    public interface InterfaceC0025c {
        void a(Intent intent, List<b> list, List<e> list2);
    }

    private static final class d implements InterfaceC0025c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final float f1787b = 0.95f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<ComponentName, b> f1788a = new HashMap();

        d() {
        }

        @Override // androidx.appcompat.widget.c.InterfaceC0025c
        public void a(Intent intent, List<b> list, List<e> list2) {
            Map<ComponentName, b> map = this.f1788a;
            map.clear();
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                b bVar = list.get(i7);
                bVar.f1786b = 0.0f;
                ActivityInfo activityInfo = bVar.f1785a.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), bVar);
            }
            float f8 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                e eVar = list2.get(size2);
                b bVar2 = map.get(eVar.f1789a);
                if (bVar2 != null) {
                    bVar2.f1786b += eVar.f1791c * f8;
                    f8 *= f1787b;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f1789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1791c;

        public e(String str, long j7, float f8) {
            this(ComponentName.unflattenFromString(str), j7, f8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            ComponentName componentName = this.f1789a;
            if (componentName == null) {
                if (eVar.f1789a != null) {
                    return false;
                }
            } else if (!componentName.equals(eVar.f1789a)) {
                return false;
            }
            return this.f1790b == eVar.f1790b && Float.floatToIntBits(this.f1791c) == Float.floatToIntBits(eVar.f1791c);
        }

        public int hashCode() {
            ComponentName componentName = this.f1789a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j7 = this.f1790b;
            return ((((iHashCode + 31) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + Float.floatToIntBits(this.f1791c);
        }

        public String toString() {
            return "[; activity:" + this.f1789a + "; time:" + this.f1790b + "; weight:" + new BigDecimal(this.f1791c) + "]";
        }

        public e(ComponentName componentName, long j7, float f8) {
            this.f1789a = componentName;
            this.f1790b = j7;
            this.f1791c = f8;
        }
    }

    public interface f {
        boolean a(c cVar, Intent intent);
    }

    private final class g extends AsyncTask<Object, Void, Void> {
        g() {
        }

        /* JADX WARN: Code duplicated, block: B:43:0x006d A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = c.this.f1775d.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, c.f1761p);
                    int size = list.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        e eVar = (e) list.remove(0);
                        xmlSerializerNewSerializer.startTag(null, c.f1762q);
                        xmlSerializerNewSerializer.attribute(null, c.f1763r, eVar.f1789a.flattenToString());
                        xmlSerializerNewSerializer.attribute(null, c.f1764s, String.valueOf(eVar.f1790b));
                        xmlSerializerNewSerializer.attribute(null, c.f1765t, String.valueOf(eVar.f1791c));
                        xmlSerializerNewSerializer.endTag(null, c.f1762q);
                    }
                    xmlSerializerNewSerializer.endTag(null, c.f1761p);
                    xmlSerializerNewSerializer.endDocument();
                } catch (IOException e8) {
                    Log.e(c.f1760o, "Error writing historical record file: " + c.this.f1776e, e8);
                } catch (IllegalArgumentException e9) {
                    Log.e(c.f1760o, "Error writing historical record file: " + c.this.f1776e, e9);
                } catch (IllegalStateException e10) {
                    Log.e(c.f1760o, "Error writing historical record file: " + c.this.f1776e, e10);
                } finally {
                    c.this.f1780i = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                }
                return null;
            } catch (FileNotFoundException e11) {
                Log.e(c.f1760o, "Error writing historical record file: " + str, e11);
                return null;
            }
        }
    }

    private c(Context context, String str) {
        this.f1775d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(f1770y)) {
            this.f1776e = str;
            return;
        }
        this.f1776e = str + f1770y;
    }

    private boolean a(e eVar) {
        boolean zAdd = this.f1774c.add(eVar);
        if (zAdd) {
            this.f1782k = true;
            n();
            m();
            v();
            notifyChanged();
        }
        return zAdd;
    }

    private void c() {
        boolean zL = l() | o();
        n();
        if (zL) {
            v();
            notifyChanged();
        }
    }

    public static c d(Context context, String str) {
        c cVar;
        synchronized (A) {
            Map<String, c> map = B;
            cVar = map.get(str);
            if (cVar == null) {
                cVar = new c(context, str);
                map.put(str, cVar);
            }
        }
        return cVar;
    }

    private boolean l() {
        if (!this.f1783l || this.f1777f == null) {
            return false;
        }
        this.f1783l = false;
        this.f1773b.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f1775d.getPackageManager().queryIntentActivities(this.f1777f, 0);
        int size = listQueryIntentActivities.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f1773b.add(new b(listQueryIntentActivities.get(i7)));
        }
        return true;
    }

    private void m() {
        if (!this.f1781j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f1782k) {
            this.f1782k = false;
            if (TextUtils.isEmpty(this.f1776e)) {
                return;
            }
            new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f1774c), this.f1776e);
        }
    }

    private void n() {
        int size = this.f1774c.size() - this.f1779h;
        if (size <= 0) {
            return;
        }
        this.f1782k = true;
        for (int i7 = 0; i7 < size; i7++) {
            this.f1774c.remove(0);
        }
    }

    private boolean o() {
        if (!this.f1780i || !this.f1782k || TextUtils.isEmpty(this.f1776e)) {
            return false;
        }
        this.f1780i = false;
        this.f1781j = true;
        p();
        return true;
    }

    private void p() {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.f1775d.openFileInput(this.f1776e);
            try {
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!f1761p.equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<e> list = this.f1774c;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput != null) {
                                    break;
                                } else {
                                    return;
                                }
                            } else if (next2 != 3 && next2 != 4) {
                                if (!f1762q.equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new e(xmlPullParserNewPullParser.getAttributeValue(null, f1763r), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, f1764s)), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, f1765t))));
                            }
                        }
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException e8) {
                        Log.e(f1760o, "Error reading historical recrod file: " + this.f1776e, e8);
                        if (fileInputStreamOpenFileInput == null) {
                        }
                    }
                } catch (XmlPullParserException e9) {
                    Log.e(f1760o, "Error reading historical recrod file: " + this.f1776e, e9);
                    if (fileInputStreamOpenFileInput == null) {
                    }
                }
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean v() {
        if (this.f1778g == null || this.f1777f == null || this.f1773b.isEmpty() || this.f1774c.isEmpty()) {
            return false;
        }
        this.f1778g.a(this.f1777f, this.f1773b, Collections.unmodifiableList(this.f1774c));
        return true;
    }

    public Intent b(int i7) {
        synchronized (this.f1772a) {
            if (this.f1777f == null) {
                return null;
            }
            c();
            ActivityInfo activityInfo = this.f1773b.get(i7).f1785a.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent(this.f1777f);
            intent.setComponent(componentName);
            if (this.f1784m != null) {
                if (this.f1784m.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new e(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo e(int i7) {
        ResolveInfo resolveInfo;
        synchronized (this.f1772a) {
            c();
            resolveInfo = this.f1773b.get(i7).f1785a;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f1772a) {
            c();
            size = this.f1773b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f1772a) {
            c();
            List<b> list = this.f1773b;
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (list.get(i7).f1785a == resolveInfo) {
                    return i7;
                }
            }
            return -1;
        }
    }

    public ResolveInfo h() {
        synchronized (this.f1772a) {
            c();
            if (this.f1773b.isEmpty()) {
                return null;
            }
            return this.f1773b.get(0).f1785a;
        }
    }

    public int i() {
        int i7;
        synchronized (this.f1772a) {
            i7 = this.f1779h;
        }
        return i7;
    }

    public int j() {
        int size;
        synchronized (this.f1772a) {
            c();
            size = this.f1774c.size();
        }
        return size;
    }

    public Intent k() {
        Intent intent;
        synchronized (this.f1772a) {
            intent = this.f1777f;
        }
        return intent;
    }

    public void q(InterfaceC0025c interfaceC0025c) {
        synchronized (this.f1772a) {
            if (this.f1778g == interfaceC0025c) {
                return;
            }
            this.f1778g = interfaceC0025c;
            if (v()) {
                notifyChanged();
            }
        }
    }

    public void r(int i7) {
        synchronized (this.f1772a) {
            c();
            b bVar = this.f1773b.get(i7);
            b bVar2 = this.f1773b.get(0);
            float f8 = bVar2 != null ? (bVar2.f1786b - bVar.f1786b) + 5.0f : 1.0f;
            ActivityInfo activityInfo = bVar.f1785a.activityInfo;
            a(new e(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f8));
        }
    }

    public void s(int i7) {
        synchronized (this.f1772a) {
            if (this.f1779h == i7) {
                return;
            }
            this.f1779h = i7;
            n();
            if (v()) {
                notifyChanged();
            }
        }
    }

    public void t(Intent intent) {
        synchronized (this.f1772a) {
            if (this.f1777f == intent) {
                return;
            }
            this.f1777f = intent;
            this.f1783l = true;
            c();
        }
    }

    public void u(f fVar) {
        synchronized (this.f1772a) {
            this.f1784m = fVar;
        }
    }
}
