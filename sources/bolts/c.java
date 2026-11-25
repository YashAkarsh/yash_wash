package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f11334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<a> f11335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f11336c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f11337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f11340d;

        public a(String str, String str2, Uri uri, String str3) {
            this.f11338b = str;
            this.f11339c = str2;
            this.f11337a = uri;
            this.f11340d = str3;
        }

        public String a() {
            return this.f11340d;
        }

        public String b() {
            return this.f11339c;
        }

        public String c() {
            return this.f11338b;
        }

        public Uri d() {
            return this.f11337a;
        }
    }

    public c(Uri uri, List<a> list, Uri uri2) {
        this.f11334a = uri;
        this.f11335b = list == null ? Collections.emptyList() : list;
        this.f11336c = uri2;
    }

    public Uri a() {
        return this.f11334a;
    }

    public List<a> b() {
        return Collections.unmodifiableList(this.f11335b);
    }

    public Uri c() {
        return this.f11336c;
    }
}
