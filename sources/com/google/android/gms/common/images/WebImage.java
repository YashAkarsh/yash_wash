package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "WebImageCreator")
public final class WebImage extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<WebImage> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getUrl", id = 2)
    private final Uri f15598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWidth", id = 3)
    private final int f15599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getHeight", id = 4)
    private final int f15600d;

    @SafeParcelable.b
    WebImage(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) Uri uri, @SafeParcelable.e(id = 3) int i8, @SafeParcelable.e(id = 4) int i9) {
        this.f15597a = i7;
        this.f15598b = uri;
        this.f15599c = i8;
        this.f15600d = i9;
    }

    public int K() {
        return this.f15600d;
    }

    @m0
    public Uri Q() {
        return this.f15598b;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (s.b(this.f15598b, webImage.f15598b) && this.f15599c == webImage.f15599c && this.f15600d == webImage.f15600d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return s.c(this.f15598b, Integer.valueOf(this.f15599c), Integer.valueOf(this.f15600d));
    }

    public int p0() {
        return this.f15599c;
    }

    @c1.a
    @m0
    public JSONObject r0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f15598b.toString());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f15599c);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f15600d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @m0
    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f15599c), Integer.valueOf(this.f15600d), this.f15598b.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15597a);
        e1.b.S(parcel, 2, Q(), i7, false);
        e1.b.F(parcel, 3, p0());
        e1.b.F(parcel, 4, K());
        e1.b.b(parcel, iA);
    }

    public WebImage(@m0 Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(@m0 Uri uri, int i7, int i8) throws IllegalArgumentException {
        this(1, uri, i7, i8);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i7 < 0 || i8 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @c1.a
    public WebImage(@m0 JSONObject jSONObject) throws IllegalArgumentException {
        Uri uri = Uri.EMPTY;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        this(uri, jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0), jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0));
    }
}
