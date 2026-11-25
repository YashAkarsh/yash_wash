package n3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f37499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f37500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f37502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f37503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f37504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f37505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f37506j;

    public void A(String str) {
        this.f37505i = str;
    }

    public void B(String str) {
        this.f37506j = str;
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e clone() {
        try {
            return (e) super.clone();
        } catch (CloneNotSupportedException e8) {
            e3.a.g("Clone cpTcg info error", e8);
            return null;
        }
    }

    public String h() {
        return this.f37497a;
    }

    public String i() {
        return this.f37498b;
    }

    public String j() {
        return this.f37499c;
    }

    public String k() {
        return this.f37500d;
    }

    public String l() {
        return this.f37501e;
    }

    public String m() {
        return this.f37502f;
    }

    public String n() {
        return this.f37503g;
    }

    public String o() {
        return this.f37504h;
    }

    public String p() {
        return this.f37505i;
    }

    public String q() {
        return this.f37506j;
    }

    public void r(String str) {
        this.f37497a = str;
    }

    public void t(String str) {
        this.f37498b = str;
    }

    public String toString() {
        return "TransConfigGuide{step1='" + this.f37497a + "', step1Img='" + this.f37498b + "', step2='" + this.f37499c + "', step2Img='" + this.f37500d + "', step3='" + this.f37501e + "', step3Img='" + this.f37502f + "', step4='" + this.f37503g + "', step4Img='" + this.f37504h + "', step5='" + this.f37505i + "', step5Img='" + this.f37506j + "'}";
    }

    public void u(String str) {
        this.f37499c = str;
    }

    public void v(String str) {
        this.f37500d = str;
    }

    public void w(String str) {
        this.f37501e = str;
    }

    public void x(String str) {
        this.f37502f = str;
    }

    public void y(String str) {
        this.f37503g = str;
    }

    public void z(String str) {
        this.f37504h = str;
    }
}
