package n3;

import java.io.Serializable;
import o3.g;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f37509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f37512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f37513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f37514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f37515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f37516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f37517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f37518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f37519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f37520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f37521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f37522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f37523q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f37524r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f37525s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private e f37526t;

    public static f g(g gVar) {
        f fVar = new f();
        fVar.D(gVar.e());
        fVar.C(gVar.a());
        fVar.T(gVar.c());
        fVar.O(gVar.b());
        return fVar;
    }

    public String A() {
        return this.f37522p;
    }

    public String B() {
        return this.f37509c;
    }

    public void C(String str) {
        this.f37520n = str;
    }

    public void D(String str) {
        this.f37525s = str;
    }

    public void E(String str) {
        this.f37515i = str;
    }

    public void F(String str) {
        this.f37516j = str;
    }

    public void H(String str) {
        this.f37513g = str;
    }

    public void I(String str) {
        this.f37514h = str;
    }

    public void J(String str) {
        this.f37519m = str;
    }

    public void L(e eVar) {
        this.f37526t = eVar;
    }

    public void M(String str) {
        this.f37512f = str;
    }

    public void N(String str) {
        this.f37521o = str;
    }

    public void O(String str) {
        this.f37518l = str;
    }

    public void P(String str) {
        this.f37508b = str;
    }

    public void R(String str) {
        this.f37507a = str;
    }

    public void S(String str) {
        this.f37517k = str;
    }

    public void T(String str) {
        this.f37510d = str;
    }

    public void U(String str) {
        this.f37511e = str;
    }

    public void V(String str) {
        this.f37523q = str;
    }

    public void W(String str) {
        this.f37524r = str;
    }

    public void X(String str) {
        this.f37522p = str;
    }

    public void Y(String str) {
        this.f37509c = str;
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public f clone() {
        f fVar;
        CloneNotSupportedException e8;
        try {
            fVar = (f) super.clone();
            try {
                e eVar = this.f37526t;
                if (eVar != null) {
                    fVar.L(eVar.clone());
                }
            } catch (CloneNotSupportedException e9) {
                e8 = e9;
                e3.a.g("Clone device model info error", e8);
            }
        } catch (CloneNotSupportedException e10) {
            fVar = null;
            e8 = e10;
        }
        return fVar;
    }

    public String h() {
        return this.f37520n;
    }

    public String i() {
        return this.f37525s;
    }

    public String j() {
        return this.f37515i;
    }

    public String k() {
        return this.f37516j;
    }

    public String l() {
        return this.f37513g;
    }

    public String m() {
        return this.f37514h;
    }

    public String n() {
        return this.f37519m;
    }

    public e o() {
        return this.f37526t;
    }

    public String p() {
        return this.f37512f;
    }

    public String q() {
        return this.f37521o;
    }

    public String r() {
        return this.f37518l;
    }

    public String t() {
        return this.f37508b;
    }

    public String toString() {
        return "TransDeviceModelInfo{productCode='" + this.f37507a + "', modelCode='" + this.f37508b + "', typeId='" + this.f37509c + "', productImg1='" + this.f37510d + "', productImg2='" + this.f37511e + "', configMode='" + this.f37512f + "', bindSuccess='" + this.f37513g + "', bindSuccessImg='" + this.f37514h + "', bindFailed='" + this.f37515i + "', bindFailedImg='" + this.f37516j + "', productDesc='" + this.f37517k + "', hotspotName='" + this.f37518l + "', brandCode='" + this.f37519m + "', appTypeCode='" + this.f37520n + "', deviceRole='" + this.f37521o + "', state='" + this.f37522p + "', selfDiscoverySignCode='" + this.f37523q + "', selfDiscoverySignName='" + this.f37524r + "', appTypeName='" + this.f37525s + "', configGuide=" + this.f37526t + '}';
    }

    public String u() {
        return this.f37507a;
    }

    public String v() {
        return this.f37517k;
    }

    public String w() {
        return this.f37510d;
    }

    public String x() {
        return this.f37511e;
    }

    public String y() {
        return this.f37523q;
    }

    public String z() {
        return this.f37524r;
    }
}
