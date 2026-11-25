package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.util.w;
import c.e0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import c.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
@c.d
public class f {
    public static final int A = 2;

    @x0({x0.a.LIBRARY})
    static final int B = Integer.MAX_VALUE;
    private static final Object C = new Object();
    private static final Object D = new Object();

    @o0
    @z("INSTANCE_LOCK")
    private static volatile f E = null;

    @z("CONFIG_LOCK")
    private static volatile boolean F = false;
    private static final String G = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7461n = "android.support.text.emoji.emojiCompat_metadataVersion";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7462o = "android.support.text.emoji.emojiCompat_replaceAll";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7463p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7464q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7465r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7466s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f7467t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f7468u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7469v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f7470w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f7471x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f7472y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f7473z = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @z("mInitLock")
    @m0
    private final Set<AbstractC0093f> f7475b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    private final c f7478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    final i f7479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f7480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f7481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    final int[] f7482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f7483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f7484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f7485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final e f7486m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final ReadWriteLock f7474a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @z("mInitLock")
    private volatile int f7476c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final Handler f7477d = new Handler(Looper.getMainLooper());

    @x0({x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @t0(19)
    private static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile androidx.emoji2.text.j f7487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile p f7488c;

        class a extends j {
            a() {
            }

            @Override // androidx.emoji2.text.f.j
            public void a(@o0 Throwable th) {
                b.this.f7490a.s(th);
            }

            @Override // androidx.emoji2.text.f.j
            public void b(@m0 p pVar) {
                b.this.h(pVar);
            }
        }

        b(f fVar) {
            super(fVar);
        }

        @Override // androidx.emoji2.text.f.c
        String a() {
            String strN = this.f7488c.g().N();
            return strN == null ? "" : strN;
        }

        @Override // androidx.emoji2.text.f.c
        public int b(CharSequence charSequence, int i7) {
            return this.f7487b.d(charSequence, i7);
        }

        @Override // androidx.emoji2.text.f.c
        boolean c(@m0 CharSequence charSequence) {
            return this.f7487b.c(charSequence) == 1;
        }

        @Override // androidx.emoji2.text.f.c
        boolean d(@m0 CharSequence charSequence, int i7) {
            return this.f7487b.d(charSequence, i7) == 1;
        }

        @Override // androidx.emoji2.text.f.c
        void e() {
            try {
                this.f7490a.f7479f.a(new a());
            } catch (Throwable th) {
                this.f7490a.s(th);
            }
        }

        @Override // androidx.emoji2.text.f.c
        CharSequence f(@m0 CharSequence charSequence, int i7, int i8, int i9, boolean z7) {
            return this.f7487b.j(charSequence, i7, i8, i9, z7);
        }

        @Override // androidx.emoji2.text.f.c
        void g(@m0 EditorInfo editorInfo) {
            editorInfo.extras.putInt(f.f7461n, this.f7488c.h());
            editorInfo.extras.putBoolean(f.f7462o, this.f7490a.f7480g);
        }

        void h(@m0 p pVar) {
            if (pVar == null) {
                this.f7490a.s(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f7488c = pVar;
            p pVar2 = this.f7488c;
            l lVar = new l();
            e eVar = this.f7490a.f7486m;
            f fVar = this.f7490a;
            this.f7487b = new androidx.emoji2.text.j(pVar2, lVar, eVar, fVar.f7481h, fVar.f7482i);
            this.f7490a.t();
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f f7490a;

        c(f fVar) {
            this.f7490a = fVar;
        }

        String a() {
            return "";
        }

        public int b(CharSequence charSequence, int i7) {
            return 0;
        }

        boolean c(@m0 CharSequence charSequence) {
            return false;
        }

        boolean d(@m0 CharSequence charSequence, int i7) {
            return false;
        }

        void e() {
            this.f7490a.t();
        }

        CharSequence f(@m0 CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8, @e0(from = 0) int i9, boolean z7) {
            return charSequence;
        }

        void g(@m0 EditorInfo editorInfo) {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        final i f7491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f7492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @o0
        int[] f7494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        Set<AbstractC0093f> f7495e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f7496f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f7497g = -16711936;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f7498h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @m0
        e f7499i = new androidx.emoji2.text.e();

        protected d(@m0 i iVar) {
            w.m(iVar, "metadataLoader cannot be null.");
            this.f7491a = iVar;
        }

        @m0
        protected final i a() {
            return this.f7491a;
        }

        @m0
        public d b(@m0 AbstractC0093f abstractC0093f) {
            w.m(abstractC0093f, "initCallback cannot be null");
            if (this.f7495e == null) {
                this.f7495e = new androidx.collection.b();
            }
            this.f7495e.add(abstractC0093f);
            return this;
        }

        @m0
        public d c(@c.l int i7) {
            this.f7497g = i7;
            return this;
        }

        @m0
        public d d(boolean z7) {
            this.f7496f = z7;
            return this;
        }

        @m0
        public d e(@m0 e eVar) {
            w.m(eVar, "GlyphChecker cannot be null");
            this.f7499i = eVar;
            return this;
        }

        @m0
        public d f(int i7) {
            this.f7498h = i7;
            return this;
        }

        @m0
        public d g(boolean z7) {
            this.f7492b = z7;
            return this;
        }

        @m0
        public d h(boolean z7) {
            return i(z7, null);
        }

        @m0
        public d i(boolean z7, @o0 List<Integer> list) {
            this.f7493c = z7;
            if (!z7 || list == null) {
                this.f7494d = null;
            } else {
                this.f7494d = new int[list.size()];
                Iterator<Integer> it = list.iterator();
                int i7 = 0;
                while (it.hasNext()) {
                    this.f7494d[i7] = it.next().intValue();
                    i7++;
                }
                Arrays.sort(this.f7494d);
            }
            return this;
        }

        @m0
        public d j(@m0 AbstractC0093f abstractC0093f) {
            w.m(abstractC0093f, "initCallback cannot be null");
            Set<AbstractC0093f> set = this.f7495e;
            if (set != null) {
                set.remove(abstractC0093f);
            }
            return this;
        }
    }

    public interface e {
        boolean a(@m0 CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8, @e0(from = 0) int i9);
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0093f {
        public void a(@o0 Throwable th) {
        }

        public void b() {
        }
    }

    private static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<AbstractC0093f> f7500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f7501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f7502c;

        g(@m0 AbstractC0093f abstractC0093f, int i7) {
            this(Arrays.asList((AbstractC0093f) w.m(abstractC0093f, "initCallback cannot be null")), i7, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f7500a.size();
            int i7 = 0;
            if (this.f7502c != 1) {
                while (i7 < size) {
                    this.f7500a.get(i7).a(this.f7501b);
                    i7++;
                }
            } else {
                while (i7 < size) {
                    this.f7500a.get(i7).b();
                    i7++;
                }
            }
        }

        g(@m0 Collection<AbstractC0093f> collection, int i7) {
            this(collection, i7, null);
        }

        g(@m0 Collection<AbstractC0093f> collection, int i7, @o0 Throwable th) {
            w.m(collection, "initCallbacks cannot be null");
            this.f7500a = new ArrayList(collection);
            this.f7502c = i7;
            this.f7501b = th;
        }
    }

    @x0({x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    public interface i {
        void a(@m0 j jVar);
    }

    public static abstract class j {
        public abstract void a(@o0 Throwable th);

        public abstract void b(@m0 p pVar);
    }

    @x0({x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    @t0(19)
    @x0({x0.a.LIBRARY})
    static class l {
        l() {
        }

        androidx.emoji2.text.k a(@m0 androidx.emoji2.text.i iVar) {
            return new r(iVar);
        }
    }

    private f(@m0 d dVar) {
        this.f7480g = dVar.f7492b;
        this.f7481h = dVar.f7493c;
        this.f7482i = dVar.f7494d;
        this.f7483j = dVar.f7496f;
        this.f7484k = dVar.f7497g;
        this.f7479f = dVar.f7491a;
        this.f7485l = dVar.f7498h;
        this.f7486m = dVar.f7499i;
        androidx.collection.b bVar = new androidx.collection.b();
        this.f7475b = bVar;
        Set<AbstractC0093f> set = dVar.f7495e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(dVar.f7495e);
        }
        this.f7478e = new b(this);
        r();
    }

    @o0
    @x0({x0.a.TESTS})
    public static f A(@o0 f fVar) {
        f fVar2;
        synchronized (C) {
            E = fVar;
            fVar2 = E;
        }
        return fVar2;
    }

    @x0({x0.a.TESTS})
    public static void B(boolean z7) {
        synchronized (D) {
            F = z7;
        }
    }

    @m0
    public static f b() {
        f fVar;
        synchronized (C) {
            fVar = E;
            w.o(fVar != null, G);
        }
        return fVar;
    }

    public static boolean g(@m0 InputConnection inputConnection, @m0 Editable editable, @e0(from = 0) int i7, @e0(from = 0) int i8, boolean z7) {
        return androidx.emoji2.text.j.e(inputConnection, editable, i7, i8, z7);
    }

    public static boolean h(@m0 Editable editable, int i7, @m0 KeyEvent keyEvent) {
        return androidx.emoji2.text.j.f(editable, i7, keyEvent);
    }

    @o0
    public static f k(@m0 Context context) {
        return l(context, null);
    }

    @o0
    @x0({x0.a.LIBRARY})
    public static f l(@m0 Context context, @o0 androidx.emoji2.text.d.a aVar) {
        f fVar;
        if (F) {
            return E;
        }
        if (aVar == null) {
            aVar = new androidx.emoji2.text.d.a(null);
        }
        d dVarC = aVar.c(context);
        synchronized (D) {
            if (!F) {
                if (dVarC != null) {
                    m(dVarC);
                }
                F = true;
            }
            fVar = E;
        }
        return fVar;
    }

    @m0
    public static f m(@m0 d dVar) {
        f fVar = E;
        if (fVar == null) {
            synchronized (C) {
                fVar = E;
                if (fVar == null) {
                    fVar = new f(dVar);
                    E = fVar;
                }
            }
        }
        return fVar;
    }

    public static boolean n() {
        return E != null;
    }

    private boolean p() {
        return f() == 1;
    }

    private void r() {
        this.f7474a.writeLock().lock();
        try {
            if (this.f7485l == 0) {
                this.f7476c = 0;
            }
            this.f7474a.writeLock().unlock();
            if (f() == 0) {
                this.f7478e.e();
            }
        } catch (Throwable th) {
            this.f7474a.writeLock().unlock();
            throw th;
        }
    }

    @m0
    public static f z(@m0 d dVar) {
        f fVar;
        synchronized (C) {
            fVar = new f(dVar);
            E = fVar;
        }
        return fVar;
    }

    public void C(@m0 AbstractC0093f abstractC0093f) {
        w.m(abstractC0093f, "initCallback cannot be null");
        this.f7474a.writeLock().lock();
        try {
            this.f7475b.remove(abstractC0093f);
        } finally {
            this.f7474a.writeLock().unlock();
        }
    }

    public void D(@m0 EditorInfo editorInfo) {
        if (!p() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f7478e.g(editorInfo);
    }

    @m0
    public String c() {
        w.o(p(), "Not initialized yet");
        return this.f7478e.a();
    }

    public int d(@m0 CharSequence charSequence, @e0(from = 0) int i7) {
        w.o(p(), "Not initialized yet");
        w.m(charSequence, "sequence cannot be null");
        return this.f7478e.b(charSequence, i7);
    }

    @x0({x0.a.LIBRARY_GROUP})
    @c.l
    public int e() {
        return this.f7484k;
    }

    public int f() {
        this.f7474a.readLock().lock();
        try {
            return this.f7476c;
        } finally {
            this.f7474a.readLock().unlock();
        }
    }

    @Deprecated
    public boolean i(@m0 CharSequence charSequence) {
        w.o(p(), "Not initialized yet");
        w.m(charSequence, "sequence cannot be null");
        return this.f7478e.c(charSequence);
    }

    @Deprecated
    public boolean j(@m0 CharSequence charSequence, @e0(from = 0) int i7) {
        w.o(p(), "Not initialized yet");
        w.m(charSequence, "sequence cannot be null");
        return this.f7478e.d(charSequence, i7);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean o() {
        return this.f7483j;
    }

    public void q() {
        w.o(this.f7485l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (p()) {
            return;
        }
        this.f7474a.writeLock().lock();
        try {
            if (this.f7476c == 0) {
                this.f7474a.writeLock().unlock();
                return;
            }
            this.f7476c = 0;
            this.f7474a.writeLock().unlock();
            this.f7478e.e();
        } catch (Throwable th) {
            this.f7474a.writeLock().unlock();
            throw th;
        }
    }

    void s(@o0 Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f7474a.writeLock().lock();
        try {
            this.f7476c = 2;
            arrayList.addAll(this.f7475b);
            this.f7475b.clear();
            this.f7474a.writeLock().unlock();
            this.f7477d.post(new g(arrayList, this.f7476c, th));
        } catch (Throwable th2) {
            this.f7474a.writeLock().unlock();
            throw th2;
        }
    }

    void t() {
        ArrayList arrayList = new ArrayList();
        this.f7474a.writeLock().lock();
        try {
            this.f7476c = 1;
            arrayList.addAll(this.f7475b);
            this.f7475b.clear();
            this.f7474a.writeLock().unlock();
            this.f7477d.post(new g(arrayList, this.f7476c));
        } catch (Throwable th) {
            this.f7474a.writeLock().unlock();
            throw th;
        }
    }

    @o0
    @c.j
    public CharSequence u(@o0 CharSequence charSequence) {
        return v(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    @o0
    @c.j
    public CharSequence v(@o0 CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8) {
        return w(charSequence, i7, i8, Integer.MAX_VALUE);
    }

    @o0
    @c.j
    public CharSequence w(@o0 CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8, @e0(from = 0) int i9) {
        return x(charSequence, i7, i8, i9, 0);
    }

    @o0
    @c.j
    public CharSequence x(@o0 CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8, @e0(from = 0) int i9, int i10) {
        boolean z7;
        w.o(p(), "Not initialized yet");
        w.j(i7, "start cannot be negative");
        w.j(i8, "end cannot be negative");
        w.j(i9, "maxEmojiCount cannot be negative");
        w.b(i7 <= i8, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        w.b(i7 <= charSequence.length(), "start should be < than charSequence length");
        w.b(i8 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i7 == i8) {
            return charSequence;
        }
        if (i10 != 1) {
            z7 = i10 != 2 ? this.f7480g : false;
        } else {
            z7 = true;
        }
        return this.f7478e.f(charSequence, i7, i8, i9, z7);
    }

    public void y(@m0 AbstractC0093f abstractC0093f) {
        w.m(abstractC0093f, "initCallback cannot be null");
        this.f7474a.writeLock().lock();
        try {
            if (this.f7476c == 1 || this.f7476c == 2) {
                this.f7477d.post(new g(abstractC0093f, this.f7476c));
            } else {
                this.f7475b.add(abstractC0093f);
            }
        } finally {
            this.f7474a.writeLock().unlock();
        }
    }
}
