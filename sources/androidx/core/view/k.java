package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import com.facebook.share.internal.ShareConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6640b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6641c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6642d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6643e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6644f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6645g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6646h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final g f6647a;

    @c.t0(31)
    private static final class a {
        private a() {
        }

        @c.m0
        @c.t
        public static Pair<ContentInfo, ContentInfo> a(@c.m0 ContentInfo contentInfo, @c.m0 final Predicate<ClipData.Item> predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() == 1) {
                boolean zTest = predicate.test(clip.getItemAt(0));
                ContentInfo contentInfo2 = zTest ? contentInfo : null;
                if (zTest) {
                    contentInfo = null;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(predicate);
            Pair<ClipData, ClipData> pairH = k.h(clip, new androidx.core.util.x() { // from class: androidx.core.view.j
                @Override // androidx.core.util.x
                public final boolean test(Object obj) {
                    return predicate.test((ClipData.Item) obj);
                }
            });
            if (pairH.first == null) {
                return Pair.create(null, contentInfo);
            }
            if (pairH.second == null) {
                return Pair.create(contentInfo, null);
            }
            androidx.core.view.i.a();
            ContentInfo contentInfoBuild = androidx.core.view.h.a(contentInfo).setClip((ClipData) pairH.first).build();
            androidx.core.view.i.a();
            return Pair.create(contentInfoBuild, androidx.core.view.h.a(contentInfo).setClip((ClipData) pairH.second).build());
        }
    }

    private interface d {
        void a(int i7);

        void b(@c.o0 Uri uri);

        @c.m0
        k build();

        void c(@c.m0 ClipData clipData);

        void j(int i7);

        void setExtras(@c.o0 Bundle bundle);
    }

    @c.t0(31)
    private static final class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final ContentInfo f6655a;

        f(@c.m0 ContentInfo contentInfo) {
            this.f6655a = androidx.core.view.c.a(androidx.core.util.w.l(contentInfo));
        }

        @Override // androidx.core.view.k.g
        @c.o0
        public Uri a() {
            return this.f6655a.getLinkUri();
        }

        @Override // androidx.core.view.k.g
        @c.m0
        public ClipData b() {
            return this.f6655a.getClip();
        }

        @Override // androidx.core.view.k.g
        @c.m0
        public ContentInfo c() {
            return this.f6655a;
        }

        @Override // androidx.core.view.k.g
        public int d() {
            return this.f6655a.getSource();
        }

        @Override // androidx.core.view.k.g
        @c.o0
        public Bundle getExtras() {
            return this.f6655a.getExtras();
        }

        @c.m0
        public String toString() {
            return "ContentInfoCompat{" + this.f6655a + com.alipay.sdk.util.j.f13808d;
        }

        @Override // androidx.core.view.k.g
        public int w() {
            return this.f6655a.getFlags();
        }
    }

    private interface g {
        @c.o0
        Uri a();

        @c.m0
        ClipData b();

        @c.o0
        ContentInfo c();

        int d();

        @c.o0
        Bundle getExtras();

        int w();
    }

    private static final class h implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final ClipData f6656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.o0
        private final Uri f6659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.o0
        private final Bundle f6660e;

        h(e eVar) {
            this.f6656a = (ClipData) androidx.core.util.w.l(eVar.f6650a);
            this.f6657b = androidx.core.util.w.g(eVar.f6651b, 0, 5, ShareConstants.FEED_SOURCE_PARAM);
            this.f6658c = androidx.core.util.w.k(eVar.f6652c, 1);
            this.f6659d = eVar.f6653d;
            this.f6660e = eVar.f6654e;
        }

        @Override // androidx.core.view.k.g
        @c.o0
        public Uri a() {
            return this.f6659d;
        }

        @Override // androidx.core.view.k.g
        @c.m0
        public ClipData b() {
            return this.f6656a;
        }

        @Override // androidx.core.view.k.g
        @c.o0
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.k.g
        public int d() {
            return this.f6657b;
        }

        @Override // androidx.core.view.k.g
        @c.o0
        public Bundle getExtras() {
            return this.f6660e;
        }

        @c.m0
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f6656a.getDescription());
            sb.append(", source=");
            sb.append(k.k(this.f6657b));
            sb.append(", flags=");
            sb.append(k.b(this.f6658c));
            if (this.f6659d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f6659d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f6660e != null ? ", hasExtras" : "");
            sb.append(com.alipay.sdk.util.j.f13808d);
            return sb.toString();
        }

        @Override // androidx.core.view.k.g
        public int w() {
            return this.f6658c;
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    k(@c.m0 g gVar) {
        this.f6647a = gVar;
    }

    @c.m0
    static ClipData a(@c.m0 ClipDescription clipDescription, @c.m0 List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i7 = 1; i7 < list.size(); i7++) {
            clipData.addItem(list.get(i7));
        }
        return clipData;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    static String b(int i7) {
        return (i7 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i7);
    }

    @c.m0
    static Pair<ClipData, ClipData> h(@c.m0 ClipData clipData, @c.m0 androidx.core.util.x<ClipData.Item> xVar) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i7 = 0; i7 < clipData.getItemCount(); i7++) {
            ClipData.Item itemAt = clipData.getItemAt(i7);
            if (xVar.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        if (arrayList == null) {
            return Pair.create(null, clipData);
        }
        return arrayList2 == null ? Pair.create(clipData, null) : Pair.create(a(clipData.getDescription(), arrayList), a(clipData.getDescription(), arrayList2));
    }

    @c.t0(31)
    @c.m0
    public static Pair<ContentInfo, ContentInfo> i(@c.m0 ContentInfo contentInfo, @c.m0 Predicate<ClipData.Item> predicate) {
        return a.a(contentInfo, predicate);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    static String k(int i7) {
        if (i7 == 0) {
            return "SOURCE_APP";
        }
        if (i7 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i7 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i7 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i7 != 4) {
            return i7 != 5 ? String.valueOf(i7) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    @c.t0(31)
    @c.m0
    public static k m(@c.m0 ContentInfo contentInfo) {
        return new k(new f(contentInfo));
    }

    @c.m0
    public ClipData c() {
        return this.f6647a.b();
    }

    @c.o0
    public Bundle d() {
        return this.f6647a.getExtras();
    }

    public int e() {
        return this.f6647a.w();
    }

    @c.o0
    public Uri f() {
        return this.f6647a.a();
    }

    public int g() {
        return this.f6647a.d();
    }

    @c.m0
    public Pair<k, k> j(@c.m0 androidx.core.util.x<ClipData.Item> xVar) {
        ClipData clipDataB = this.f6647a.b();
        if (clipDataB.getItemCount() == 1) {
            boolean zTest = xVar.test(clipDataB.getItemAt(0));
            return Pair.create(zTest ? this : null, zTest ? null : this);
        }
        Pair<ClipData, ClipData> pairH = h(clipDataB, xVar);
        if (pairH.first == null) {
            return Pair.create(null, this);
        }
        return pairH.second == null ? Pair.create(this, null) : Pair.create(new b(this).b((ClipData) pairH.first).a(), new b(this).b((ClipData) pairH.second).a());
    }

    @c.t0(31)
    @c.m0
    public ContentInfo l() {
        ContentInfo contentInfoC = this.f6647a.c();
        Objects.requireNonNull(contentInfoC);
        return androidx.core.view.c.a(contentInfoC);
    }

    @c.m0
    public String toString() {
        return this.f6647a.toString();
    }

    @c.t0(31)
    private static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final ContentInfo.Builder f6649a;

        c(@c.m0 ClipData clipData, int i7) {
            androidx.core.view.i.a();
            this.f6649a = p.a(clipData, i7);
        }

        @Override // androidx.core.view.k.d
        public void a(int i7) {
            this.f6649a.setSource(i7);
        }

        @Override // androidx.core.view.k.d
        public void b(@c.o0 Uri uri) {
            this.f6649a.setLinkUri(uri);
        }

        @Override // androidx.core.view.k.d
        @c.m0
        public k build() {
            return new k(new f(this.f6649a.build()));
        }

        @Override // androidx.core.view.k.d
        public void c(@c.m0 ClipData clipData) {
            this.f6649a.setClip(clipData);
        }

        @Override // androidx.core.view.k.d
        public void j(int i7) {
            this.f6649a.setFlags(i7);
        }

        @Override // androidx.core.view.k.d
        public void setExtras(@c.o0 Bundle bundle) {
            this.f6649a.setExtras(bundle);
        }

        c(@c.m0 k kVar) {
            androidx.core.view.i.a();
            this.f6649a = androidx.core.view.h.a(kVar.l());
        }
    }

    private static final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        ClipData f6650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.o0
        Uri f6653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.o0
        Bundle f6654e;

        e(@c.m0 ClipData clipData, int i7) {
            this.f6650a = clipData;
            this.f6651b = i7;
        }

        @Override // androidx.core.view.k.d
        public void a(int i7) {
            this.f6651b = i7;
        }

        @Override // androidx.core.view.k.d
        public void b(@c.o0 Uri uri) {
            this.f6653d = uri;
        }

        @Override // androidx.core.view.k.d
        @c.m0
        public k build() {
            return new k(new h(this));
        }

        @Override // androidx.core.view.k.d
        public void c(@c.m0 ClipData clipData) {
            this.f6650a = clipData;
        }

        @Override // androidx.core.view.k.d
        public void j(int i7) {
            this.f6652c = i7;
        }

        @Override // androidx.core.view.k.d
        public void setExtras(@c.o0 Bundle bundle) {
            this.f6654e = bundle;
        }

        e(@c.m0 k kVar) {
            this.f6650a = kVar.c();
            this.f6651b = kVar.g();
            this.f6652c = kVar.e();
            this.f6653d = kVar.f();
            this.f6654e = kVar.d();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final d f6648a;

        public b(@c.m0 k kVar) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f6648a = new c(kVar);
            } else {
                this.f6648a = new e(kVar);
            }
        }

        @c.m0
        public k a() {
            return this.f6648a.build();
        }

        @c.m0
        public b b(@c.m0 ClipData clipData) {
            this.f6648a.c(clipData);
            return this;
        }

        @c.m0
        public b c(@c.o0 Bundle bundle) {
            this.f6648a.setExtras(bundle);
            return this;
        }

        @c.m0
        public b d(int i7) {
            this.f6648a.j(i7);
            return this;
        }

        @c.m0
        public b e(@c.o0 Uri uri) {
            this.f6648a.b(uri);
            return this;
        }

        @c.m0
        public b f(int i7) {
            this.f6648a.a(i7);
            return this;
        }

        public b(@c.m0 ClipData clipData, int i7) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f6648a = new c(clipData, i7);
            } else {
                this.f6648a = new e(clipData, i7);
            }
        }
    }
}
