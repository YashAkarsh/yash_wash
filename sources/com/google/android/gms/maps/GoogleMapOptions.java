package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleMapOptionsCreator")
@SafeParcelable.f({1})
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @c.m0
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getZOrderOnTopForParcel", id = 2, type = "byte")
    private Boolean f16450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getUseViewLifecycleInFragmentForParcel", id = 3, type = "byte")
    private Boolean f16451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMapType", id = 4)
    private int f16452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getCamera", id = 5)
    private CameraPosition f16453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getZoomControlsEnabledForParcel", id = 6, type = "byte")
    private Boolean f16454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getCompassEnabledForParcel", id = 7, type = "byte")
    private Boolean f16455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getScrollGesturesEnabledForParcel", id = 8, type = "byte")
    private Boolean f16456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getZoomGesturesEnabledForParcel", id = 9, type = "byte")
    private Boolean f16457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getTiltGesturesEnabledForParcel", id = 10, type = "byte")
    private Boolean f16458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getRotateGesturesEnabledForParcel", id = 11, type = "byte")
    private Boolean f16459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getLiteModeForParcel", id = 12, type = "byte")
    private Boolean f16460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getMapToolbarEnabledForParcel", id = 14, type = "byte")
    private Boolean f16461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getAmbientEnabledForParcel", id = 15, type = "byte")
    private Boolean f16462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getMinZoomPreference", id = 16)
    private Float f16463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getMaxZoomPreference", id = 17)
    private Float f16464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getLatLngBoundsForCameraTarget", id = 18)
    private LatLngBounds f16465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValue = "-1", getter = "getScrollGesturesEnabledDuringRotateOrZoomForParcel", id = 19, type = "byte")
    private Boolean f16466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getBackgroundColor", id = 20)
    @c.l
    private Integer f16467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getMapId", id = 21)
    private String f16468s;

    public GoogleMapOptions() {
        this.f16452c = -1;
        this.f16463n = null;
        this.f16464o = null;
        this.f16465p = null;
        this.f16467r = null;
        this.f16468s = null;
    }

    @c.o0
    public static CameraPosition h2(@c.o0 Context context, @c.o0 AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f, typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f);
        CameraPosition.a aVarK = CameraPosition.K();
        aVarK.c(latLng);
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            aVarK.e(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            aVarK.a(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            aVarK.d(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        typedArrayObtainAttributes.recycle();
        return aVarK.b();
    }

    @c.o0
    public static LatLngBounds i2(@c.o0 Context context, @c.o0 AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        Float fValueOf = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float fValueOf2 = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float fValueOf3 = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float fValueOf4 = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        typedArrayObtainAttributes.recycle();
        if (fValueOf == null || fValueOf2 == null || fValueOf3 == null || fValueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
    }

    private static int j2(Context context, String str) {
        return context.getResources().getIdentifier(str, "attr", context.getPackageName());
    }

    @c.o0
    public static GoogleMapOptions r0(@c.o0 Context context, @c.o0 AttributeSet attributeSet) {
        String string;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.W1(typedArrayObtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.e2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.d2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.p0(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.Z1(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.b2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.a2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.c2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.g2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.f2(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.B1(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.R1(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.s(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.Y1(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.X1(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        TypedArray typedArrayObtainAttributes2 = context.getResources().obtainAttributes(attributeSet, new int[]{j2(context, "backgroundColor"), j2(context, "mapId")});
        if (typedArrayObtainAttributes2.hasValue(0)) {
            googleMapOptions.K(Integer.valueOf(typedArrayObtainAttributes2.getColor(0, 0)));
        }
        if (typedArrayObtainAttributes2.hasValue(1) && (string = typedArrayObtainAttributes2.getString(1)) != null && !string.isEmpty()) {
            googleMapOptions.N1(string);
        }
        typedArrayObtainAttributes2.recycle();
        googleMapOptions.A1(i2(context, attributeSet));
        googleMapOptions.Q(h2(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    @c.m0
    public GoogleMapOptions A1(@c.o0 LatLngBounds latLngBounds) {
        this.f16465p = latLngBounds;
        return this;
    }

    @c.m0
    public GoogleMapOptions B1(boolean z7) {
        this.f16460k = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean G0() {
        return this.f16455f;
    }

    @c.o0
    public LatLngBounds I0() {
        return this.f16465p;
    }

    @c.o0
    public Boolean J0() {
        return this.f16460k;
    }

    @c.m0
    public GoogleMapOptions K(@c.o0 @c.l Integer num) {
        this.f16467r = num;
        return this;
    }

    @c.o0
    public String L0() {
        return this.f16468s;
    }

    @c.m0
    public GoogleMapOptions N1(@c.m0 String str) {
        this.f16468s = str;
        return this;
    }

    @c.m0
    public GoogleMapOptions Q(@c.o0 CameraPosition cameraPosition) {
        this.f16453d = cameraPosition;
        return this;
    }

    @c.o0
    public Boolean Q0() {
        return this.f16461l;
    }

    @c.m0
    public GoogleMapOptions R1(boolean z7) {
        this.f16461l = Boolean.valueOf(z7);
        return this;
    }

    public int T0() {
        return this.f16452c;
    }

    @c.o0
    public Float V0() {
        return this.f16464o;
    }

    @c.m0
    public GoogleMapOptions W1(int i7) {
        this.f16452c = i7;
        return this;
    }

    @c.m0
    public GoogleMapOptions X1(float f8) {
        this.f16464o = Float.valueOf(f8);
        return this;
    }

    @c.o0
    public Float Y0() {
        return this.f16463n;
    }

    @c.m0
    public GoogleMapOptions Y1(float f8) {
        this.f16463n = Float.valueOf(f8);
        return this;
    }

    @c.m0
    public GoogleMapOptions Z1(boolean z7) {
        this.f16459j = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean a1() {
        return this.f16459j;
    }

    @c.m0
    public GoogleMapOptions a2(boolean z7) {
        this.f16456g = Boolean.valueOf(z7);
        return this;
    }

    @c.m0
    public GoogleMapOptions b2(boolean z7) {
        this.f16466q = Boolean.valueOf(z7);
        return this;
    }

    @c.m0
    public GoogleMapOptions c2(boolean z7) {
        this.f16458i = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean d1() {
        return this.f16456g;
    }

    @c.m0
    public GoogleMapOptions d2(boolean z7) {
        this.f16451b = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean e1() {
        return this.f16466q;
    }

    @c.m0
    public GoogleMapOptions e2(boolean z7) {
        this.f16450a = Boolean.valueOf(z7);
        return this;
    }

    @c.m0
    public GoogleMapOptions f2(boolean z7) {
        this.f16454e = Boolean.valueOf(z7);
        return this;
    }

    @c.m0
    public GoogleMapOptions g2(boolean z7) {
        this.f16457h = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean i1() {
        return this.f16458i;
    }

    @c.m0
    public GoogleMapOptions p0(boolean z7) {
        this.f16455f = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean q1() {
        return this.f16451b;
    }

    @c.m0
    public GoogleMapOptions s(boolean z7) {
        this.f16462m = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Boolean s0() {
        return this.f16462m;
    }

    @c.o0
    public Boolean s1() {
        return this.f16450a;
    }

    @c.m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("MapType", Integer.valueOf(this.f16452c)).a("LiteMode", this.f16460k).a("Camera", this.f16453d).a("CompassEnabled", this.f16455f).a("ZoomControlsEnabled", this.f16454e).a("ScrollGesturesEnabled", this.f16456g).a("ZoomGesturesEnabled", this.f16457h).a("TiltGesturesEnabled", this.f16458i).a("RotateGesturesEnabled", this.f16459j).a("ScrollGesturesEnabledDuringRotateOrZoom", this.f16466q).a("MapToolbarEnabled", this.f16461l).a("AmbientEnabled", this.f16462m).a("MinZoomPreference", this.f16463n).a("MaxZoomPreference", this.f16464o).a("BackgroundColor", this.f16467r).a("LatLngBoundsForCameraTarget", this.f16465p).a("ZOrderOnTop", this.f16450a).a("UseViewLifecycleInFragment", this.f16451b).toString();
    }

    @c.o0
    @c.l
    public Integer v0() {
        return this.f16467r;
    }

    @c.o0
    public Boolean w1() {
        return this.f16454e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.l(parcel, 2, com.google.android.gms.maps.internal.m.a(this.f16450a));
        e1.b.l(parcel, 3, com.google.android.gms.maps.internal.m.a(this.f16451b));
        e1.b.F(parcel, 4, T0());
        e1.b.S(parcel, 5, x0(), i7, false);
        e1.b.l(parcel, 6, com.google.android.gms.maps.internal.m.a(this.f16454e));
        e1.b.l(parcel, 7, com.google.android.gms.maps.internal.m.a(this.f16455f));
        e1.b.l(parcel, 8, com.google.android.gms.maps.internal.m.a(this.f16456g));
        e1.b.l(parcel, 9, com.google.android.gms.maps.internal.m.a(this.f16457h));
        e1.b.l(parcel, 10, com.google.android.gms.maps.internal.m.a(this.f16458i));
        e1.b.l(parcel, 11, com.google.android.gms.maps.internal.m.a(this.f16459j));
        e1.b.l(parcel, 12, com.google.android.gms.maps.internal.m.a(this.f16460k));
        e1.b.l(parcel, 14, com.google.android.gms.maps.internal.m.a(this.f16461l));
        e1.b.l(parcel, 15, com.google.android.gms.maps.internal.m.a(this.f16462m));
        e1.b.z(parcel, 16, Y0(), false);
        e1.b.z(parcel, 17, V0(), false);
        e1.b.S(parcel, 18, I0(), i7, false);
        e1.b.l(parcel, 19, com.google.android.gms.maps.internal.m.a(this.f16466q));
        e1.b.I(parcel, 20, v0(), false);
        e1.b.Y(parcel, 21, L0(), false);
        e1.b.b(parcel, iA);
    }

    @c.o0
    public CameraPosition x0() {
        return this.f16453d;
    }

    @c.o0
    public Boolean z1() {
        return this.f16457h;
    }

    @SafeParcelable.b
    GoogleMapOptions(@SafeParcelable.e(id = 2) byte b8, @SafeParcelable.e(id = 3) byte b9, @SafeParcelable.e(id = 4) int i7, @c.o0 @SafeParcelable.e(id = 5) CameraPosition cameraPosition, @SafeParcelable.e(id = 6) byte b10, @SafeParcelable.e(id = 7) byte b11, @SafeParcelable.e(id = 8) byte b12, @SafeParcelable.e(id = 9) byte b13, @SafeParcelable.e(id = 10) byte b14, @SafeParcelable.e(id = 11) byte b15, @SafeParcelable.e(id = 12) byte b16, @SafeParcelable.e(id = 14) byte b17, @SafeParcelable.e(id = 15) byte b18, @c.o0 @SafeParcelable.e(id = 16) Float f8, @c.o0 @SafeParcelable.e(id = 17) Float f9, @c.o0 @SafeParcelable.e(id = 18) LatLngBounds latLngBounds, @SafeParcelable.e(id = 19) byte b19, @c.o0 @SafeParcelable.e(id = 20) @c.l Integer num, @c.o0 @SafeParcelable.e(id = 21) String str) {
        this.f16452c = -1;
        this.f16463n = null;
        this.f16464o = null;
        this.f16465p = null;
        this.f16467r = null;
        this.f16468s = null;
        this.f16450a = com.google.android.gms.maps.internal.m.b(b8);
        this.f16451b = com.google.android.gms.maps.internal.m.b(b9);
        this.f16452c = i7;
        this.f16453d = cameraPosition;
        this.f16454e = com.google.android.gms.maps.internal.m.b(b10);
        this.f16455f = com.google.android.gms.maps.internal.m.b(b11);
        this.f16456g = com.google.android.gms.maps.internal.m.b(b12);
        this.f16457h = com.google.android.gms.maps.internal.m.b(b13);
        this.f16458i = com.google.android.gms.maps.internal.m.b(b14);
        this.f16459j = com.google.android.gms.maps.internal.m.b(b15);
        this.f16460k = com.google.android.gms.maps.internal.m.b(b16);
        this.f16461l = com.google.android.gms.maps.internal.m.b(b17);
        this.f16462m = com.google.android.gms.maps.internal.m.b(b18);
        this.f16463n = f8;
        this.f16464o = f9;
        this.f16465p = latLngBounds;
        this.f16466q = com.google.android.gms.maps.internal.m.b(b19);
        this.f16467r = num;
        this.f16468s = str;
    }
}
