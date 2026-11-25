package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.w;
import androidx.constraintlayout.core.widgets.j;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.s;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final int A = 1;
    private static final int A0 = 29;
    private static final int A1 = 81;
    public static final int B = 0;
    private static final int B0 = 30;
    private static final int B1 = 82;
    public static final int C = 1;
    private static final int C0 = 31;
    private static final int C1 = 83;
    public static final int D = 0;
    private static final int D0 = 32;
    private static final int D1 = 84;
    public static final int E = 4;
    private static final int E0 = 33;
    private static final int E1 = 85;
    public static final int F = 8;
    private static final int F0 = 34;
    private static final int F1 = 86;
    public static final int G = 1;
    private static final int G0 = 35;
    private static final int G1 = 87;
    public static final int H = 2;
    private static final int H0 = 36;
    private static final int H1 = 88;
    public static final int I = 3;
    private static final int I0 = 37;
    private static final int I1 = 89;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f4686J = 4;
    private static final int J0 = 38;
    private static final int J1 = 90;
    public static final int K = 5;
    private static final int K0 = 39;
    private static final int K1 = 91;
    public static final int L = 6;
    private static final int L0 = 40;
    private static final int L1 = 92;
    public static final int M = 7;
    private static final int M0 = 41;
    private static final int M1 = 93;
    public static final int N = 8;
    private static final int N0 = 42;
    private static final int N1 = 94;
    public static final int O = 0;
    private static final int O0 = 43;
    private static final int O1 = 95;
    public static final int P = 1;
    private static final int P0 = 44;
    private static final int P1 = 96;
    public static final int Q = 0;
    private static final int Q0 = 45;
    private static final int Q1 = 97;
    public static final int R = 1;
    private static final int R0 = 46;
    private static final int R1 = 98;
    public static final int S = 2;
    private static final int S0 = 47;
    private static final int S1 = 99;
    private static final boolean T = false;
    private static final int T0 = 48;
    private static final String T1 = "weight";
    private static final int U0 = 49;
    private static final String U1 = "ratio";
    private static final int V = 1;
    private static final int V0 = 50;
    private static final String V1 = "parent";
    private static final int W0 = 51;
    private static final int X0 = 52;
    private static final int Y = 1;
    private static final int Y0 = 53;
    private static final int Z = 2;
    private static final int Z0 = 54;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final int f4687a0 = 3;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private static final int f4688a1 = 55;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final int f4689b0 = 4;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private static final int f4690b1 = 56;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final int f4691c0 = 5;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private static final int f4692c1 = 57;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int f4693d0 = 6;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private static final int f4694d1 = 58;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final int f4695e0 = 7;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private static final int f4696e1 = 59;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final int f4697f0 = 8;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private static final int f4698f1 = 60;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final int f4699g0 = 9;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private static final int f4700g1 = 61;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f4701h = "ConstraintSet";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final int f4702h0 = 10;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private static final int f4703h1 = 62;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f4704i = "XML parser error must be within a Constraint ";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final int f4705i0 = 11;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private static final int f4706i1 = 63;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f4707j = -1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final int f4708j0 = 12;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private static final int f4709j1 = 64;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f4710k = -2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final int f4711k0 = 13;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private static final int f4712k1 = 65;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f4713l = -3;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final int f4714l0 = 14;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private static final int f4715l1 = 66;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f4716m = -4;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final int f4717m0 = 15;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private static final int f4718m1 = 67;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4719n = 0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final int f4720n0 = 16;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private static final int f4721n1 = 68;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4722o = 1;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final int f4723o0 = 17;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private static final int f4724o1 = 69;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f4725p = 2;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final int f4726p0 = 18;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final int f4727p1 = 70;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f4728q = 3;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final int f4729q0 = 19;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private static final int f4730q1 = 71;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4731r = 4;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final int f4732r0 = 20;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private static final int f4733r1 = 72;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f4734s = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final int f4735s0 = 21;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private static final int f4736s1 = 73;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f4737t = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final int f4738t0 = 22;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private static final int f4739t1 = 74;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f4740u = -2;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final int f4741u0 = 23;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private static final int f4742u1 = 75;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f4743v = 1;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static final int f4744v0 = 24;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private static final int f4745v1 = 76;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f4746w = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static final int f4747w0 = 25;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private static final int f4748w1 = 77;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f4749x = 2;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static final int f4750x0 = 26;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private static final int f4751x1 = 78;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f4752y = 0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final int f4753y0 = 27;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private static final int f4754y1 = 79;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f4755z = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final int f4756z0 = 28;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    private static final int f4757z1 = 80;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4760c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4761d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.a> f4762e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4763f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<Integer, a> f4764g = new HashMap<>();
    private static final int[] U = {0, 4, 8};
    private static SparseIntArray W = new SparseIntArray();
    private static SparseIntArray X = new SparseIntArray();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f4766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0049d f4767c = new C0049d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f4768d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f4769e = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f4770f = new e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.a> f4771g = new HashMap<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        C0048a f4772h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        static class C0048a {

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private static final int f4773m = 4;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private static final int f4774n = 10;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private static final int f4775o = 10;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private static final int f4776p = 5;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int[] f4777a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int[] f4778b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f4779c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f4780d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            float[] f4781e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f4782f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int[] f4783g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            String[] f4784h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f4785i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int[] f4786j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            boolean[] f4787k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f4788l = 0;

            C0048a() {
            }

            void a(int type, float value) {
                int i7 = this.f4782f;
                int[] iArr = this.f4780d;
                if (i7 >= iArr.length) {
                    this.f4780d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f4781e;
                    this.f4781e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f4780d;
                int i8 = this.f4782f;
                iArr2[i8] = type;
                float[] fArr2 = this.f4781e;
                this.f4782f = i8 + 1;
                fArr2[i8] = value;
            }

            void b(int type, int value) {
                int i7 = this.f4779c;
                int[] iArr = this.f4777a;
                if (i7 >= iArr.length) {
                    this.f4777a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f4778b;
                    this.f4778b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f4777a;
                int i8 = this.f4779c;
                iArr3[i8] = type;
                int[] iArr4 = this.f4778b;
                this.f4779c = i8 + 1;
                iArr4[i8] = value;
            }

            void c(int type, String value) {
                int i7 = this.f4785i;
                int[] iArr = this.f4783g;
                if (i7 >= iArr.length) {
                    this.f4783g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f4784h;
                    this.f4784h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f4783g;
                int i8 = this.f4785i;
                iArr2[i8] = type;
                String[] strArr2 = this.f4784h;
                this.f4785i = i8 + 1;
                strArr2[i8] = value;
            }

            void d(int type, boolean value) {
                int i7 = this.f4788l;
                int[] iArr = this.f4786j;
                if (i7 >= iArr.length) {
                    this.f4786j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f4787k;
                    this.f4787k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f4786j;
                int i8 = this.f4788l;
                iArr2[i8] = type;
                boolean[] zArr2 = this.f4787k;
                this.f4788l = i8 + 1;
                zArr2[i8] = value;
            }

            void e(a c8) {
                for (int i7 = 0; i7 < this.f4779c; i7++) {
                    d.S0(c8, this.f4777a[i7], this.f4778b[i7]);
                }
                for (int i8 = 0; i8 < this.f4782f; i8++) {
                    d.R0(c8, this.f4780d[i8], this.f4781e[i8]);
                }
                for (int i9 = 0; i9 < this.f4785i; i9++) {
                    d.T0(c8, this.f4783g[i9], this.f4784h[i9]);
                }
                for (int i10 = 0; i10 < this.f4788l; i10++) {
                    d.U0(c8, this.f4786j[i10], this.f4787k[i10]);
                }
            }

            @SuppressLint({"LogConditional"})
            void f(String tag) {
                Log.v(tag, "int");
                for (int i7 = 0; i7 < this.f4779c; i7++) {
                    Log.v(tag, this.f4777a[i7] + " = " + this.f4778b[i7]);
                }
                Log.v(tag, w.b.f3028c);
                for (int i8 = 0; i8 < this.f4782f; i8++) {
                    Log.v(tag, this.f4780d[i8] + " = " + this.f4781e[i8]);
                }
                Log.v(tag, "strings");
                for (int i9 = 0; i9 < this.f4785i; i9++) {
                    Log.v(tag, this.f4783g[i9] + " = " + this.f4784h[i9]);
                }
                Log.v(tag, w.b.f3031f);
                for (int i10 = 0; i10 < this.f4788l; i10++) {
                    Log.v(tag, this.f4786j[i10] + " = " + this.f4787k[i10]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int viewId, ConstraintLayout.LayoutParams param) {
            this.f4765a = viewId;
            b bVar = this.f4769e;
            bVar.f4843j = param.f4526e;
            bVar.f4845k = param.f4528f;
            bVar.f4847l = param.f4530g;
            bVar.f4849m = param.f4532h;
            bVar.f4851n = param.f4534i;
            bVar.f4853o = param.f4536j;
            bVar.f4855p = param.f4538k;
            bVar.f4857q = param.f4540l;
            bVar.f4859r = param.f4542m;
            bVar.f4860s = param.f4544n;
            bVar.f4861t = param.f4546o;
            bVar.f4862u = param.f4554s;
            bVar.f4863v = param.f4556t;
            bVar.f4864w = param.f4558u;
            bVar.f4865x = param.f4560v;
            bVar.f4866y = param.G;
            bVar.f4867z = param.H;
            bVar.A = param.I;
            bVar.B = param.f4548p;
            bVar.C = param.f4550q;
            bVar.D = param.f4552r;
            bVar.E = param.X;
            bVar.F = param.Y;
            bVar.G = param.Z;
            bVar.f4839h = param.f4522c;
            bVar.f4835f = param.f4518a;
            bVar.f4837g = param.f4520b;
            bVar.f4831d = ((ViewGroup.MarginLayoutParams) param).width;
            bVar.f4833e = ((ViewGroup.MarginLayoutParams) param).height;
            bVar.H = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            bVar.I = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            bVar.f4824J = ((ViewGroup.MarginLayoutParams) param).topMargin;
            bVar.K = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            bVar.N = param.D;
            bVar.V = param.M;
            bVar.W = param.L;
            bVar.Y = param.O;
            bVar.X = param.N;
            bVar.f4852n0 = param.f4519a0;
            bVar.f4854o0 = param.f4521b0;
            bVar.Z = param.P;
            bVar.f4826a0 = param.Q;
            bVar.f4828b0 = param.T;
            bVar.f4830c0 = param.U;
            bVar.f4832d0 = param.R;
            bVar.f4834e0 = param.S;
            bVar.f4836f0 = param.V;
            bVar.f4838g0 = param.W;
            bVar.f4850m0 = param.f4523c0;
            bVar.P = param.f4564x;
            bVar.R = param.f4566z;
            bVar.O = param.f4562w;
            bVar.Q = param.f4565y;
            bVar.T = param.A;
            bVar.S = param.B;
            bVar.U = param.C;
            bVar.f4858q0 = param.f4525d0;
            bVar.L = param.getMarginEnd();
            this.f4769e.M = param.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int viewId, Constraints.LayoutParams param) {
            k(viewId, param);
            this.f4767c.f4897d = param.V0;
            e eVar = this.f4770f;
            eVar.f4912b = param.Y0;
            eVar.f4913c = param.Z0;
            eVar.f4914d = param.f4614a1;
            eVar.f4915e = param.f4615b1;
            eVar.f4916f = param.f4616c1;
            eVar.f4917g = param.f4617d1;
            eVar.f4918h = param.f4618e1;
            eVar.f4920j = param.f4619f1;
            eVar.f4921k = param.f4620g1;
            eVar.f4922l = param.f4621h1;
            eVar.f4924n = param.X0;
            eVar.f4923m = param.W0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(ConstraintHelper helper, int viewId, Constraints.LayoutParams param) {
            l(viewId, param);
            if (helper instanceof Barrier) {
                b bVar = this.f4769e;
                bVar.f4844j0 = 1;
                Barrier barrier = (Barrier) helper;
                bVar.f4840h0 = barrier.getType();
                this.f4769e.f4846k0 = barrier.getReferencedIds();
                this.f4769e.f4842i0 = barrier.getMargin();
            }
        }

        private androidx.constraintlayout.widget.a n(String attributeName, androidx.constraintlayout.widget.a.b attributeType) {
            if (!this.f4771g.containsKey(attributeName)) {
                androidx.constraintlayout.widget.a aVar = new androidx.constraintlayout.widget.a(attributeName, attributeType);
                this.f4771g.put(attributeName, aVar);
                return aVar;
            }
            androidx.constraintlayout.widget.a aVar2 = this.f4771g.get(attributeName);
            if (aVar2.j() == attributeType) {
                return aVar2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + aVar2.j().name());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(String attributeName, int value) {
            n(attributeName, androidx.constraintlayout.widget.a.b.COLOR_TYPE).s(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(String attributeName, float value) {
            n(attributeName, androidx.constraintlayout.widget.a.b.FLOAT_TYPE).t(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(String attributeName, int value) {
            n(attributeName, androidx.constraintlayout.widget.a.b.INT_TYPE).u(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(String attributeName, String value) {
            n(attributeName, androidx.constraintlayout.widget.a.b.STRING_TYPE).v(value);
        }

        public void h(a c8) {
            C0048a c0048a = this.f4772h;
            if (c0048a != null) {
                c0048a.e(c8);
            }
        }

        public void i(ConstraintLayout.LayoutParams param) {
            b bVar = this.f4769e;
            param.f4526e = bVar.f4843j;
            param.f4528f = bVar.f4845k;
            param.f4530g = bVar.f4847l;
            param.f4532h = bVar.f4849m;
            param.f4534i = bVar.f4851n;
            param.f4536j = bVar.f4853o;
            param.f4538k = bVar.f4855p;
            param.f4540l = bVar.f4857q;
            param.f4542m = bVar.f4859r;
            param.f4544n = bVar.f4860s;
            param.f4546o = bVar.f4861t;
            param.f4554s = bVar.f4862u;
            param.f4556t = bVar.f4863v;
            param.f4558u = bVar.f4864w;
            param.f4560v = bVar.f4865x;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = bVar.I;
            ((ViewGroup.MarginLayoutParams) param).topMargin = bVar.f4824J;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = bVar.K;
            param.A = bVar.T;
            param.B = bVar.S;
            param.f4564x = bVar.P;
            param.f4566z = bVar.R;
            param.G = bVar.f4866y;
            param.H = bVar.f4867z;
            param.f4548p = bVar.B;
            param.f4550q = bVar.C;
            param.f4552r = bVar.D;
            param.I = bVar.A;
            param.X = bVar.E;
            param.Y = bVar.F;
            param.M = bVar.V;
            param.L = bVar.W;
            param.O = bVar.Y;
            param.N = bVar.X;
            param.f4519a0 = bVar.f4852n0;
            param.f4521b0 = bVar.f4854o0;
            param.P = bVar.Z;
            param.Q = bVar.f4826a0;
            param.T = bVar.f4828b0;
            param.U = bVar.f4830c0;
            param.R = bVar.f4832d0;
            param.S = bVar.f4834e0;
            param.V = bVar.f4836f0;
            param.W = bVar.f4838g0;
            param.Z = bVar.G;
            param.f4522c = bVar.f4839h;
            param.f4518a = bVar.f4835f;
            param.f4520b = bVar.f4837g;
            ((ViewGroup.MarginLayoutParams) param).width = bVar.f4831d;
            ((ViewGroup.MarginLayoutParams) param).height = bVar.f4833e;
            String str = bVar.f4850m0;
            if (str != null) {
                param.f4523c0 = str;
            }
            param.f4525d0 = bVar.f4858q0;
            param.setMarginStart(bVar.M);
            param.setMarginEnd(this.f4769e.L);
            param.e();
        }

        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f4769e.a(this.f4769e);
            aVar.f4768d.a(this.f4768d);
            aVar.f4767c.a(this.f4767c);
            aVar.f4770f.a(this.f4770f);
            aVar.f4765a = this.f4765a;
            aVar.f4772h = this.f4772h;
            return aVar;
        }

        public void o(String tag) {
            C0048a c0048a = this.f4772h;
            if (c0048a != null) {
                c0048a.f(tag);
            } else {
                Log.v(tag, "DELTA IS NULL");
            }
        }
    }

    public static class b {
        private static final int A0 = 7;
        private static final int A1 = 82;
        private static final int B0 = 8;
        private static final int B1 = 83;
        private static final int C0 = 9;
        private static final int C1 = 84;
        private static final int D0 = 10;
        private static final int D1 = 85;
        private static final int E0 = 11;
        private static final int E1 = 86;
        private static final int F0 = 12;
        private static final int F1 = 87;
        private static final int G0 = 13;
        private static final int G1 = 88;
        private static final int H0 = 14;
        private static final int H1 = 89;
        private static final int I0 = 15;
        private static final int I1 = 90;
        private static final int J0 = 16;
        private static final int J1 = 91;
        private static final int K0 = 17;
        private static final int L0 = 18;
        private static final int M0 = 19;
        private static final int N0 = 20;
        private static final int O0 = 21;
        private static final int P0 = 22;
        private static final int Q0 = 23;
        private static final int R0 = 24;
        private static final int S0 = 25;
        private static final int T0 = 26;
        private static final int U0 = 27;
        private static final int V0 = 28;
        private static final int W0 = 29;
        private static final int X0 = 30;
        private static final int Y0 = 31;
        private static final int Z0 = 32;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        private static final int f4789a1 = 33;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        private static final int f4790b1 = 34;

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        private static final int f4791c1 = 35;

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        private static final int f4792d1 = 36;

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        private static final int f4793e1 = 37;

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        private static final int f4794f1 = 38;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        private static final int f4795g1 = 39;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        private static final int f4796h1 = 40;

        /* JADX INFO: renamed from: i1, reason: collision with root package name */
        private static final int f4797i1 = 41;

        /* JADX INFO: renamed from: j1, reason: collision with root package name */
        private static final int f4798j1 = 42;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        private static final int f4799k1 = 61;

        /* JADX INFO: renamed from: l1, reason: collision with root package name */
        private static final int f4800l1 = 62;

        /* JADX INFO: renamed from: m1, reason: collision with root package name */
        private static final int f4801m1 = 63;

        /* JADX INFO: renamed from: n1, reason: collision with root package name */
        private static final int f4802n1 = 69;

        /* JADX INFO: renamed from: o1, reason: collision with root package name */
        private static final int f4803o1 = 70;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        private static final int f4804p1 = 71;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        private static final int f4805q1 = 72;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static final int f4806r0 = -1;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        private static final int f4807r1 = 73;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public static final int f4808s0 = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: s1, reason: collision with root package name */
        private static final int f4809s1 = 74;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        private static SparseIntArray f4810t0 = null;

        /* JADX INFO: renamed from: t1, reason: collision with root package name */
        private static final int f4811t1 = 75;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        private static final int f4812u0 = 1;

        /* JADX INFO: renamed from: u1, reason: collision with root package name */
        private static final int f4813u1 = 76;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        private static final int f4814v0 = 2;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        private static final int f4815v1 = 77;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        private static final int f4816w0 = 3;

        /* JADX INFO: renamed from: w1, reason: collision with root package name */
        private static final int f4817w1 = 78;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        private static final int f4818x0 = 4;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private static final int f4819x1 = 79;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        private static final int f4820y0 = 5;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private static final int f4821y1 = 80;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        private static final int f4822z0 = 6;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        private static final int f4823z1 = 81;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4831d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4833e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f4846k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f4848l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f4850m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4825a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4827b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4829c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4835f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4837g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f4839h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f4841i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4843j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4845k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f4847l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4849m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4851n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f4853o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f4855p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f4857q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f4859r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f4860s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f4861t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f4862u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f4863v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f4864w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f4865x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f4866y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f4867z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f4824J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f4826a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f4828b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f4830c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f4832d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f4834e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f4836f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f4838g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f4840h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f4842i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f4844j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f4852n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f4854o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f4856p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f4858q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4810t0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f4810t0.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f4810t0.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f4810t0.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            f4810t0.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            f4810t0.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f4810t0.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f4810t0.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f4810t0.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f4810t0.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            f4810t0.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            f4810t0.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            f4810t0.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            f4810t0.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            f4810t0.append(R.styleable.Layout_guidelineUseRtl, 90);
            f4810t0.append(R.styleable.Layout_android_orientation, 26);
            f4810t0.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            f4810t0.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            f4810t0.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f4810t0.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f4810t0.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            f4810t0.append(R.styleable.Layout_layout_goneMarginTop, 16);
            f4810t0.append(R.styleable.Layout_layout_goneMarginRight, 14);
            f4810t0.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            f4810t0.append(R.styleable.Layout_layout_goneMarginStart, 15);
            f4810t0.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            f4810t0.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            f4810t0.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            f4810t0.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f4810t0.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f4810t0.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            f4810t0.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            f4810t0.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            f4810t0.append(R.styleable.Layout_layout_constraintLeft_creator, J1);
            f4810t0.append(R.styleable.Layout_layout_constraintTop_creator, J1);
            f4810t0.append(R.styleable.Layout_layout_constraintRight_creator, J1);
            f4810t0.append(R.styleable.Layout_layout_constraintBottom_creator, J1);
            f4810t0.append(R.styleable.Layout_layout_constraintBaseline_creator, J1);
            f4810t0.append(R.styleable.Layout_android_layout_marginLeft, 23);
            f4810t0.append(R.styleable.Layout_android_layout_marginRight, 27);
            f4810t0.append(R.styleable.Layout_android_layout_marginStart, 30);
            f4810t0.append(R.styleable.Layout_android_layout_marginEnd, 8);
            f4810t0.append(R.styleable.Layout_android_layout_marginTop, 33);
            f4810t0.append(R.styleable.Layout_android_layout_marginBottom, 2);
            f4810t0.append(R.styleable.Layout_android_layout_width, 22);
            f4810t0.append(R.styleable.Layout_android_layout_height, 21);
            f4810t0.append(R.styleable.Layout_layout_constraintWidth, 41);
            f4810t0.append(R.styleable.Layout_layout_constraintHeight, 42);
            f4810t0.append(R.styleable.Layout_layout_constrainedWidth, 41);
            f4810t0.append(R.styleable.Layout_layout_constrainedHeight, 42);
            f4810t0.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            f4810t0.append(R.styleable.Layout_layout_constraintCircle, 61);
            f4810t0.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            f4810t0.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            f4810t0.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            f4810t0.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            f4810t0.append(R.styleable.Layout_chainUseRtl, f4804p1);
            f4810t0.append(R.styleable.Layout_barrierDirection, 72);
            f4810t0.append(R.styleable.Layout_barrierMargin, 73);
            f4810t0.append(R.styleable.Layout_constraint_referenced_ids, f4809s1);
            f4810t0.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b src) {
            this.f4825a = src.f4825a;
            this.f4831d = src.f4831d;
            this.f4827b = src.f4827b;
            this.f4833e = src.f4833e;
            this.f4835f = src.f4835f;
            this.f4837g = src.f4837g;
            this.f4839h = src.f4839h;
            this.f4841i = src.f4841i;
            this.f4843j = src.f4843j;
            this.f4845k = src.f4845k;
            this.f4847l = src.f4847l;
            this.f4849m = src.f4849m;
            this.f4851n = src.f4851n;
            this.f4853o = src.f4853o;
            this.f4855p = src.f4855p;
            this.f4857q = src.f4857q;
            this.f4859r = src.f4859r;
            this.f4860s = src.f4860s;
            this.f4861t = src.f4861t;
            this.f4862u = src.f4862u;
            this.f4863v = src.f4863v;
            this.f4864w = src.f4864w;
            this.f4865x = src.f4865x;
            this.f4866y = src.f4866y;
            this.f4867z = src.f4867z;
            this.A = src.A;
            this.B = src.B;
            this.C = src.C;
            this.D = src.D;
            this.E = src.E;
            this.F = src.F;
            this.G = src.G;
            this.H = src.H;
            this.I = src.I;
            this.f4824J = src.f4824J;
            this.K = src.K;
            this.L = src.L;
            this.M = src.M;
            this.N = src.N;
            this.O = src.O;
            this.P = src.P;
            this.Q = src.Q;
            this.R = src.R;
            this.S = src.S;
            this.T = src.T;
            this.U = src.U;
            this.V = src.V;
            this.W = src.W;
            this.X = src.X;
            this.Y = src.Y;
            this.Z = src.Z;
            this.f4826a0 = src.f4826a0;
            this.f4828b0 = src.f4828b0;
            this.f4830c0 = src.f4830c0;
            this.f4832d0 = src.f4832d0;
            this.f4834e0 = src.f4834e0;
            this.f4836f0 = src.f4836f0;
            this.f4838g0 = src.f4838g0;
            this.f4840h0 = src.f4840h0;
            this.f4842i0 = src.f4842i0;
            this.f4844j0 = src.f4844j0;
            this.f4850m0 = src.f4850m0;
            int[] iArr = src.f4846k0;
            if (iArr == null || src.f4848l0 != null) {
                this.f4846k0 = null;
            } else {
                this.f4846k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f4848l0 = src.f4848l0;
            this.f4852n0 = src.f4852n0;
            this.f4854o0 = src.f4854o0;
            this.f4856p0 = src.f4856p0;
            this.f4858q0 = src.f4858q0;
        }

        public void b(s sVar, StringBuilder sb) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object objX = sVar.X(num.intValue());
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(objX == null ? num : objX);
                                sb.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f8 = (Float) obj;
                            if (f8.floatValue() != -1.0f) {
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(f8);
                                sb.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e8) {
                        e8.printStackTrace();
                    }
                }
            }
        }

        void c(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Layout);
            this.f4827b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                int i8 = f4810t0.get(index);
                switch (i8) {
                    case 1:
                        this.f4859r = d.y0(typedArrayObtainStyledAttributes, index, this.f4859r);
                        break;
                    case 2:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f4857q = d.y0(typedArrayObtainStyledAttributes, index, this.f4857q);
                        break;
                    case 4:
                        this.f4855p = d.y0(typedArrayObtainStyledAttributes, index, this.f4855p);
                        break;
                    case 5:
                        this.A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f4865x = d.y0(typedArrayObtainStyledAttributes, index, this.f4865x);
                        break;
                    case 10:
                        this.f4864w = d.y0(typedArrayObtainStyledAttributes, index, this.f4864w);
                        break;
                    case 11:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f4835f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4835f);
                        break;
                    case 18:
                        this.f4837g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4837g);
                        break;
                    case 19:
                        this.f4839h = typedArrayObtainStyledAttributes.getFloat(index, this.f4839h);
                        break;
                    case 20:
                        this.f4866y = typedArrayObtainStyledAttributes.getFloat(index, this.f4866y);
                        break;
                    case 21:
                        this.f4833e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f4833e);
                        break;
                    case 22:
                        this.f4831d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f4831d);
                        break;
                    case 23:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f4843j = d.y0(typedArrayObtainStyledAttributes, index, this.f4843j);
                        break;
                    case 25:
                        this.f4845k = d.y0(typedArrayObtainStyledAttributes, index, this.f4845k);
                        break;
                    case 26:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f4847l = d.y0(typedArrayObtainStyledAttributes, index, this.f4847l);
                        break;
                    case 29:
                        this.f4849m = d.y0(typedArrayObtainStyledAttributes, index, this.f4849m);
                        break;
                    case 30:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.f4862u = d.y0(typedArrayObtainStyledAttributes, index, this.f4862u);
                        break;
                    case 32:
                        this.f4863v = d.y0(typedArrayObtainStyledAttributes, index, this.f4863v);
                        break;
                    case 33:
                        this.f4824J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4824J);
                        break;
                    case 34:
                        this.f4853o = d.y0(typedArrayObtainStyledAttributes, index, this.f4853o);
                        break;
                    case 35:
                        this.f4851n = d.y0(typedArrayObtainStyledAttributes, index, this.f4851n);
                        break;
                    case 36:
                        this.f4867z = typedArrayObtainStyledAttributes.getFloat(index, this.f4867z);
                        break;
                    case 37:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        d.A0(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        d.A0(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i8) {
                            case 61:
                                this.B = d.y0(typedArrayObtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i8) {
                                    case 69:
                                        this.f4836f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f4838g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case f4804p1 /* 71 */:
                                        Log.e(d.f4701h, "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f4840h0 = typedArrayObtainStyledAttributes.getInt(index, this.f4840h0);
                                        break;
                                    case 73:
                                        this.f4842i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4842i0);
                                        break;
                                    case f4809s1 /* 74 */:
                                        this.f4848l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f4856p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4856p0);
                                        break;
                                    case 76:
                                        this.f4858q0 = typedArrayObtainStyledAttributes.getInt(index, this.f4858q0);
                                        break;
                                    case f4815v1 /* 77 */:
                                        this.f4860s = d.y0(typedArrayObtainStyledAttributes, index, this.f4860s);
                                        break;
                                    case f4817w1 /* 78 */:
                                        this.f4861t = d.y0(typedArrayObtainStyledAttributes, index, this.f4861t);
                                        break;
                                    case 79:
                                        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case f4821y1 /* 80 */:
                                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case f4823z1 /* 81 */:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case A1 /* 82 */:
                                        this.f4826a0 = typedArrayObtainStyledAttributes.getInt(index, this.f4826a0);
                                        break;
                                    case B1 /* 83 */:
                                        this.f4830c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4830c0);
                                        break;
                                    case C1 /* 84 */:
                                        this.f4828b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4828b0);
                                        break;
                                    case D1 /* 85 */:
                                        this.f4834e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4834e0);
                                        break;
                                    case E1 /* 86 */:
                                        this.f4832d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4832d0);
                                        break;
                                    case 87:
                                        this.f4852n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4852n0);
                                        break;
                                    case G1 /* 88 */:
                                        this.f4854o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4854o0);
                                        break;
                                    case 89:
                                        this.f4850m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f4841i = typedArrayObtainStyledAttributes.getBoolean(index, this.f4841i);
                                        break;
                                    case J1 /* 91 */:
                                        Log.w(d.f4701h, "unused attribute 0x" + Integer.toHexString(index) + "   " + f4810t0.get(index));
                                        break;
                                    default:
                                        Log.w(d.f4701h, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f4810t0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class c {
        private static final int A = 9;
        private static final int B = 10;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f4868o = -2;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f4869p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final int f4870q = -3;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static SparseIntArray f4871r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final int f4872s = 1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final int f4873t = 2;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final int f4874u = 3;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final int f4875v = 4;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private static final int f4876w = 5;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final int f4877x = 6;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final int f4878y = 7;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int f4879z = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4880a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4881b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4882c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4883d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4884e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4885f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f4886g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4887h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f4888i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f4889j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4890k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f4891l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4892m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4893n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4871r = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            f4871r.append(R.styleable.Motion_pathMotionArc, 2);
            f4871r.append(R.styleable.Motion_transitionEasing, 3);
            f4871r.append(R.styleable.Motion_drawPath, 4);
            f4871r.append(R.styleable.Motion_animateRelativeTo, 5);
            f4871r.append(R.styleable.Motion_animateCircleAngleTo, 6);
            f4871r.append(R.styleable.Motion_motionStagger, 7);
            f4871r.append(R.styleable.Motion_quantizeMotionSteps, 8);
            f4871r.append(R.styleable.Motion_quantizeMotionPhase, 9);
            f4871r.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(c src) {
            this.f4880a = src.f4880a;
            this.f4881b = src.f4881b;
            this.f4883d = src.f4883d;
            this.f4884e = src.f4884e;
            this.f4885f = src.f4885f;
            this.f4888i = src.f4888i;
            this.f4886g = src.f4886g;
            this.f4887h = src.f4887h;
        }

        void b(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Motion);
            this.f4880a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (f4871r.get(index)) {
                    case 1:
                        this.f4888i = typedArrayObtainStyledAttributes.getFloat(index, this.f4888i);
                        break;
                    case 2:
                        this.f4884e = typedArrayObtainStyledAttributes.getInt(index, this.f4884e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f4883d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f4883d = androidx.constraintlayout.core.motion.utils.d.f2786o[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f4885f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f4881b = d.y0(typedArrayObtainStyledAttributes, index, this.f4881b);
                        break;
                    case 6:
                        this.f4882c = typedArrayObtainStyledAttributes.getInteger(index, this.f4882c);
                        break;
                    case 7:
                        this.f4886g = typedArrayObtainStyledAttributes.getFloat(index, this.f4886g);
                        break;
                    case 8:
                        this.f4890k = typedArrayObtainStyledAttributes.getInteger(index, this.f4890k);
                        break;
                    case 9:
                        this.f4889j = typedArrayObtainStyledAttributes.getFloat(index, this.f4889j);
                        break;
                    case 10:
                        int i8 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i8 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f4893n = resourceId;
                            if (resourceId != -1) {
                                this.f4892m = -2;
                            }
                        } else if (i8 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f4891l = string;
                            if (string.indexOf("/") > 0) {
                                this.f4893n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f4892m = -2;
                            } else {
                                this.f4892m = -1;
                            }
                        } else {
                            this.f4892m = typedArrayObtainStyledAttributes.getInteger(index, this.f4893n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0049d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4894a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4895b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4896c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4897d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4898e = Float.NaN;

        public void a(C0049d src) {
            this.f4894a = src.f4894a;
            this.f4895b = src.f4895b;
            this.f4897d = src.f4897d;
            this.f4898e = src.f4898e;
            this.f4896c = src.f4896c;
        }

        void b(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.PropertySet);
            this.f4894a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f4897d = typedArrayObtainStyledAttributes.getFloat(index, this.f4897d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.f4895b = typedArrayObtainStyledAttributes.getInt(index, this.f4895b);
                    this.f4895b = d.U[this.f4895b];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f4896c = typedArrayObtainStyledAttributes.getInt(index, this.f4896c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f4898e = typedArrayObtainStyledAttributes.getFloat(index, this.f4898e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {
        private static final int A = 12;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static SparseIntArray f4899o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f4900p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final int f4901q = 2;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final int f4902r = 3;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final int f4903s = 4;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final int f4904t = 5;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final int f4905u = 6;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final int f4906v = 7;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private static final int f4907w = 8;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final int f4908x = 9;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final int f4909y = 10;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int f4910z = 11;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4911a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f4912b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4913c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4914d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4915e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f4916f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f4917g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f4918h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4919i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f4920j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f4921k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f4922l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4923m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f4924n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4899o = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            f4899o.append(R.styleable.Transform_android_rotationX, 2);
            f4899o.append(R.styleable.Transform_android_rotationY, 3);
            f4899o.append(R.styleable.Transform_android_scaleX, 4);
            f4899o.append(R.styleable.Transform_android_scaleY, 5);
            f4899o.append(R.styleable.Transform_android_transformPivotX, 6);
            f4899o.append(R.styleable.Transform_android_transformPivotY, 7);
            f4899o.append(R.styleable.Transform_android_translationX, 8);
            f4899o.append(R.styleable.Transform_android_translationY, 9);
            f4899o.append(R.styleable.Transform_android_translationZ, 10);
            f4899o.append(R.styleable.Transform_android_elevation, 11);
            f4899o.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e src) {
            this.f4911a = src.f4911a;
            this.f4912b = src.f4912b;
            this.f4913c = src.f4913c;
            this.f4914d = src.f4914d;
            this.f4915e = src.f4915e;
            this.f4916f = src.f4916f;
            this.f4917g = src.f4917g;
            this.f4918h = src.f4918h;
            this.f4919i = src.f4919i;
            this.f4920j = src.f4920j;
            this.f4921k = src.f4921k;
            this.f4922l = src.f4922l;
            this.f4923m = src.f4923m;
            this.f4924n = src.f4924n;
        }

        void b(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Transform);
            this.f4911a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (f4899o.get(index)) {
                    case 1:
                        this.f4912b = typedArrayObtainStyledAttributes.getFloat(index, this.f4912b);
                        break;
                    case 2:
                        this.f4913c = typedArrayObtainStyledAttributes.getFloat(index, this.f4913c);
                        break;
                    case 3:
                        this.f4914d = typedArrayObtainStyledAttributes.getFloat(index, this.f4914d);
                        break;
                    case 4:
                        this.f4915e = typedArrayObtainStyledAttributes.getFloat(index, this.f4915e);
                        break;
                    case 5:
                        this.f4916f = typedArrayObtainStyledAttributes.getFloat(index, this.f4916f);
                        break;
                    case 6:
                        this.f4917g = typedArrayObtainStyledAttributes.getDimension(index, this.f4917g);
                        break;
                    case 7:
                        this.f4918h = typedArrayObtainStyledAttributes.getDimension(index, this.f4918h);
                        break;
                    case 8:
                        this.f4920j = typedArrayObtainStyledAttributes.getDimension(index, this.f4920j);
                        break;
                    case 9:
                        this.f4921k = typedArrayObtainStyledAttributes.getDimension(index, this.f4921k);
                        break;
                    case 10:
                        this.f4922l = typedArrayObtainStyledAttributes.getDimension(index, this.f4922l);
                        break;
                    case 11:
                        this.f4923m = true;
                        this.f4924n = typedArrayObtainStyledAttributes.getDimension(index, this.f4924n);
                        break;
                    case 12:
                        this.f4919i = d.y0(typedArrayObtainStyledAttributes, index, this.f4919i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class f {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f4925o = "       ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Writer f4926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ConstraintLayout f4927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Context f4928c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4929d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4930e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f4931f = "'left'";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final String f4932g = "'right'";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final String f4933h = "'baseline'";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final String f4934i = "'bottom'";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final String f4935j = "'top'";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final String f4936k = "'start'";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final String f4937l = "'end'";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        HashMap<Integer, String> f4938m = new HashMap<>();

        f(Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.f4926a = writer;
            this.f4927b = layout;
            this.f4928c = layout.getContext();
            this.f4929d = flags;
        }

        private void e(String dimString, int dim, int dimDefault, float dimPercent, int dimMin, int dimMax, boolean constrainedDim) throws IOException {
            if (dim != 0) {
                if (dim == -2) {
                    this.f4926a.write(f4925o + dimString + ": 'wrap'\n");
                    return;
                }
                if (dim == -1) {
                    this.f4926a.write(f4925o + dimString + ": 'parent'\n");
                    return;
                }
                this.f4926a.write(f4925o + dimString + ": " + dim + ",\n");
                return;
            }
            if (dimMax == -1 && dimMin == -1) {
                if (dimDefault == 1) {
                    this.f4926a.write(f4925o + dimString + ": '???????????',\n");
                    return;
                }
                if (dimDefault != 2) {
                    return;
                }
                this.f4926a.write(f4925o + dimString + ": '" + dimPercent + "%',\n");
                return;
            }
            if (dimDefault == 0) {
                this.f4926a.write(f4925o + dimString + ": {'spread' ," + dimMin + ", " + dimMax + "}\n");
                return;
            }
            if (dimDefault == 1) {
                this.f4926a.write(f4925o + dimString + ": {'wrap' ," + dimMin + ", " + dimMax + "}\n");
                return;
            }
            if (dimDefault != 2) {
                return;
            }
            this.f4926a.write(f4925o + dimString + ": {'" + dimPercent + "'% ," + dimMin + ", " + dimMax + "}\n");
        }

        private void f(int orientation, int guideBegin, int guideEnd, float guidePercent) {
        }

        String a(int id) {
            if (this.f4938m.containsKey(Integer.valueOf(id))) {
                return "'" + this.f4938m.get(Integer.valueOf(id)) + "'";
            }
            if (id == 0) {
                return "'parent'";
            }
            String strB = b(id);
            this.f4938m.put(Integer.valueOf(id), strB);
            return "'" + strB + "'";
        }

        String b(int id) {
            try {
                if (id != -1) {
                    return this.f4928c.getResources().getResourceEntryName(id);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown");
                int i7 = this.f4930e + 1;
                this.f4930e = i7;
                sb.append(i7);
                return sb.toString();
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i8 = this.f4930e + 1;
                this.f4930e = i8;
                sb2.append(i8);
                return sb2.toString();
            }
        }

        void c(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint == -1) {
                return;
            }
            this.f4926a.write("       circle");
            this.f4926a.write(":[");
            this.f4926a.write(a(circleConstraint));
            this.f4926a.write(", " + circleAngle);
            this.f4926a.write(circleRadius + "]");
        }

        void d(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            this.f4926a.write(f4925o + my);
            this.f4926a.write(":[");
            this.f4926a.write(a(leftToLeft));
            this.f4926a.write(" , ");
            this.f4926a.write(other);
            if (margin != 0) {
                this.f4926a.write(" , " + margin);
            }
            this.f4926a.write("],\n");
        }

        void g() throws IOException {
            this.f4926a.write("\n'ConstraintSet':{\n");
            for (Integer num : d.this.f4764g.keySet()) {
                a aVar = (a) d.this.f4764g.get(num);
                String strA = a(num.intValue());
                this.f4926a.write(strA + ":{\n");
                b bVar = aVar.f4769e;
                e(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, bVar.f4833e, bVar.f4826a0, bVar.f4838g0, bVar.f4834e0, bVar.f4830c0, bVar.f4854o0);
                e(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, bVar.f4831d, bVar.Z, bVar.f4836f0, bVar.f4832d0, bVar.f4828b0, bVar.f4852n0);
                d("'left'", bVar.f4843j, "'left'", bVar.H, bVar.O);
                d("'left'", bVar.f4845k, "'right'", bVar.H, bVar.O);
                d("'right'", bVar.f4847l, "'left'", bVar.I, bVar.Q);
                d("'right'", bVar.f4849m, "'right'", bVar.I, bVar.Q);
                d("'baseline'", bVar.f4859r, "'baseline'", -1, bVar.U);
                d("'baseline'", bVar.f4860s, "'top'", -1, bVar.U);
                d("'baseline'", bVar.f4861t, "'bottom'", -1, bVar.U);
                d("'top'", bVar.f4853o, "'bottom'", bVar.f4824J, bVar.P);
                d("'top'", bVar.f4851n, "'top'", bVar.f4824J, bVar.P);
                d("'bottom'", bVar.f4857q, "'bottom'", bVar.K, bVar.R);
                d("'bottom'", bVar.f4855p, "'top'", bVar.K, bVar.R);
                d("'start'", bVar.f4863v, "'start'", bVar.M, bVar.T);
                d("'start'", bVar.f4862u, "'end'", bVar.M, bVar.T);
                d("'end'", bVar.f4864w, "'start'", bVar.L, bVar.S);
                d("'end'", bVar.f4865x, "'end'", bVar.L, bVar.S);
                i("'horizontalBias'", bVar.f4866y, 0.5f);
                i("'verticalBias'", bVar.f4867z, 0.5f);
                c(bVar.B, bVar.D, bVar.C);
                f(bVar.G, bVar.f4835f, bVar.f4837g, bVar.f4839h);
                k("'dimensionRatio'", bVar.A);
                j("'barrierMargin'", bVar.f4842i0);
                j("'type'", bVar.f4844j0);
                k("'ReferenceId'", bVar.f4848l0);
                m("'mBarrierAllowsGoneWidgets'", bVar.f4856p0, true);
                j("'WrapBehavior'", bVar.f4858q0);
                h("'verticalWeight'", bVar.V);
                h("'horizontalWeight'", bVar.W);
                j("'horizontalChainStyle'", bVar.X);
                j("'verticalChainStyle'", bVar.Y);
                j("'barrierDirection'", bVar.f4840h0);
                int[] iArr = bVar.f4846k0;
                if (iArr != null) {
                    n("'ReferenceIds'", iArr);
                }
                this.f4926a.write("}\n");
            }
            this.f4926a.write("}\n");
        }

        void h(String name, float value) throws IOException {
            if (value == -1.0f) {
                return;
            }
            this.f4926a.write(f4925o + name);
            this.f4926a.write(": " + value);
            this.f4926a.write(",\n");
        }

        void i(String name, float value, float def) throws IOException {
            if (value == def) {
                return;
            }
            this.f4926a.write(f4925o + name);
            this.f4926a.write(": " + value);
            this.f4926a.write(",\n");
        }

        void j(String name, int value) throws IOException {
            if (value == 0 || value == -1) {
                return;
            }
            this.f4926a.write(f4925o + name);
            this.f4926a.write(":");
            this.f4926a.write(", " + value);
            this.f4926a.write("\n");
        }

        void k(String name, String value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4926a.write(f4925o + name);
            this.f4926a.write(":");
            this.f4926a.write(", " + value);
            this.f4926a.write("\n");
        }

        void l(String name, boolean value) throws IOException {
            if (value) {
                this.f4926a.write(f4925o + name);
                this.f4926a.write(": " + value);
                this.f4926a.write(",\n");
            }
        }

        void m(String name, boolean value, boolean def) throws IOException {
            if (value == def) {
                return;
            }
            this.f4926a.write(f4925o + name);
            this.f4926a.write(": " + value);
            this.f4926a.write(",\n");
        }

        void n(String name, int[] value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4926a.write(f4925o + name);
            this.f4926a.write(": ");
            int i7 = 0;
            while (i7 < value.length) {
                Writer writer = this.f4926a;
                StringBuilder sb = new StringBuilder();
                sb.append(i7 == 0 ? "[" : ", ");
                sb.append(a(value[i7]));
                writer.write(sb.toString());
                i7++;
            }
            this.f4926a.write("],\n");
        }
    }

    class g {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final String f4940o = "\n       ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Writer f4941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ConstraintLayout f4942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Context f4943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4945e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f4946f = "'left'";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final String f4947g = "'right'";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final String f4948h = "'baseline'";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final String f4949i = "'bottom'";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final String f4950j = "'top'";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final String f4951k = "'start'";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final String f4952l = "'end'";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        HashMap<Integer, String> f4953m = new HashMap<>();

        g(Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.f4941a = writer;
            this.f4942b = layout;
            this.f4943c = layout.getContext();
            this.f4944d = flags;
        }

        private void c(String dimString, int dim, int def) throws IOException {
            if (dim != def) {
                if (dim == -2) {
                    this.f4941a.write(f4940o + dimString + "=\"wrap_content\"");
                    return;
                }
                if (dim == -1) {
                    this.f4941a.write(f4940o + dimString + "=\"match_parent\"");
                    return;
                }
                this.f4941a.write(f4940o + dimString + "=\"" + dim + "dp\"");
            }
        }

        private void d(String dimString, boolean val, boolean def) throws IOException {
            if (val != def) {
                this.f4941a.write(f4940o + dimString + "=\"" + val + "dp\"");
            }
        }

        private void g(String dimString, int dim, int def) throws IOException {
            if (dim != def) {
                this.f4941a.write(f4940o + dimString + "=\"" + dim + "dp\"");
            }
        }

        private void h(String dimString, int val, String[] types, int def) throws IOException {
            if (val != def) {
                this.f4941a.write(f4940o + dimString + "=\"" + types[val] + "\"");
            }
        }

        String a(int id) {
            if (this.f4953m.containsKey(Integer.valueOf(id))) {
                return "@+id/" + this.f4953m.get(Integer.valueOf(id)) + "";
            }
            if (id == 0) {
                return d.V1;
            }
            String strB = b(id);
            this.f4953m.put(Integer.valueOf(id), strB);
            return "@+id/" + strB + "";
        }

        String b(int id) {
            try {
                if (id != -1) {
                    return this.f4943c.getResources().getResourceEntryName(id);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown");
                int i7 = this.f4945e + 1;
                this.f4945e = i7;
                sb.append(i7);
                return sb.toString();
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i8 = this.f4945e + 1;
                this.f4945e = i8;
                sb2.append(i8);
                return sb2.toString();
            }
        }

        void e(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint == -1) {
                return;
            }
            this.f4941a.write("circle");
            this.f4941a.write(":[");
            this.f4941a.write(a(circleConstraint));
            this.f4941a.write(", " + circleAngle);
            this.f4941a.write(circleRadius + "]");
        }

        void f(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            this.f4941a.write(f4940o + my);
            this.f4941a.write(":[");
            this.f4941a.write(a(leftToLeft));
            this.f4941a.write(" , ");
            this.f4941a.write(other);
            if (margin != 0) {
                this.f4941a.write(" , " + margin);
            }
            this.f4941a.write("],\n");
        }

        void i() throws IOException {
            this.f4941a.write("\n<ConstraintSet>\n");
            for (Integer num : d.this.f4764g.keySet()) {
                a aVar = (a) d.this.f4764g.get(num);
                String strA = a(num.intValue());
                this.f4941a.write("  <Constraint");
                this.f4941a.write("\n       android:id=\"" + strA + "\"");
                b bVar = aVar.f4769e;
                c("android:layout_width", bVar.f4831d, -5);
                c("android:layout_height", bVar.f4833e, -5);
                j("app:layout_constraintGuide_begin", (float) bVar.f4835f, -1.0f);
                j("app:layout_constraintGuide_end", bVar.f4837g, -1.0f);
                j("app:layout_constraintGuide_percent", bVar.f4839h, -1.0f);
                j("app:layout_constraintHorizontal_bias", bVar.f4866y, 0.5f);
                j("app:layout_constraintVertical_bias", bVar.f4867z, 0.5f);
                m("app:layout_constraintDimensionRatio", bVar.A, null);
                o("app:layout_constraintCircle", bVar.B);
                j("app:layout_constraintCircleRadius", bVar.C, 0.0f);
                j("app:layout_constraintCircleAngle", bVar.D, 0.0f);
                j("android:orientation", bVar.G, -1.0f);
                j("app:layout_constraintVertical_weight", bVar.V, -1.0f);
                j("app:layout_constraintHorizontal_weight", bVar.W, -1.0f);
                j("app:layout_constraintHorizontal_chainStyle", bVar.X, 0.0f);
                j("app:layout_constraintVertical_chainStyle", bVar.Y, 0.0f);
                j("app:barrierDirection", bVar.f4840h0, -1.0f);
                j("app:barrierMargin", bVar.f4842i0, 0.0f);
                g("app:layout_marginLeft", bVar.H, 0);
                g("app:layout_goneMarginLeft", bVar.O, Integer.MIN_VALUE);
                g("app:layout_marginRight", bVar.I, 0);
                g("app:layout_goneMarginRight", bVar.Q, Integer.MIN_VALUE);
                g("app:layout_marginStart", bVar.M, 0);
                g("app:layout_goneMarginStart", bVar.T, Integer.MIN_VALUE);
                g("app:layout_marginEnd", bVar.L, 0);
                g("app:layout_goneMarginEnd", bVar.S, Integer.MIN_VALUE);
                g("app:layout_marginTop", bVar.f4824J, 0);
                g("app:layout_goneMarginTop", bVar.P, Integer.MIN_VALUE);
                g("app:layout_marginBottom", bVar.K, 0);
                g("app:layout_goneMarginBottom", bVar.R, Integer.MIN_VALUE);
                g("app:goneBaselineMargin", bVar.U, Integer.MIN_VALUE);
                g("app:baselineMargin", bVar.N, 0);
                d("app:layout_constrainedWidth", bVar.f4852n0, false);
                d("app:layout_constrainedHeight", bVar.f4854o0, false);
                d("app:barrierAllowsGoneWidgets", bVar.f4856p0, true);
                j("app:layout_wrapBehaviorInParent", bVar.f4858q0, 0.0f);
                o("app:baselineToBaseline", bVar.f4859r);
                o("app:baselineToBottom", bVar.f4861t);
                o("app:baselineToTop", bVar.f4860s);
                o("app:layout_constraintBottom_toBottomOf", bVar.f4857q);
                o("app:layout_constraintBottom_toTopOf", bVar.f4855p);
                o("app:layout_constraintEnd_toEndOf", bVar.f4865x);
                o("app:layout_constraintEnd_toStartOf", bVar.f4864w);
                o("app:layout_constraintLeft_toLeftOf", bVar.f4843j);
                o("app:layout_constraintLeft_toRightOf", bVar.f4845k);
                o("app:layout_constraintRight_toLeftOf", bVar.f4847l);
                o("app:layout_constraintRight_toRightOf", bVar.f4849m);
                o("app:layout_constraintStart_toEndOf", bVar.f4862u);
                o("app:layout_constraintStart_toStartOf", bVar.f4863v);
                o("app:layout_constraintTop_toBottomOf", bVar.f4853o);
                o("app:layout_constraintTop_toTopOf", bVar.f4851n);
                String[] strArr = {"spread", "wrap", "percent"};
                h("app:layout_constraintHeight_default", bVar.f4826a0, strArr, 0);
                j("app:layout_constraintHeight_percent", bVar.f4838g0, 1.0f);
                g("app:layout_constraintHeight_min", bVar.f4834e0, 0);
                g("app:layout_constraintHeight_max", bVar.f4830c0, 0);
                d("android:layout_constrainedHeight", bVar.f4854o0, false);
                h("app:layout_constraintWidth_default", bVar.Z, strArr, 0);
                j("app:layout_constraintWidth_percent", bVar.f4836f0, 1.0f);
                g("app:layout_constraintWidth_min", bVar.f4832d0, 0);
                g("app:layout_constraintWidth_max", bVar.f4828b0, 0);
                d("android:layout_constrainedWidth", bVar.f4852n0, false);
                j("app:layout_constraintVertical_weight", bVar.V, -1.0f);
                j("app:layout_constraintHorizontal_weight", bVar.W, -1.0f);
                k("app:layout_constraintHorizontal_chainStyle", bVar.X);
                k("app:layout_constraintVertical_chainStyle", bVar.Y);
                h("app:barrierDirection", bVar.f4840h0, new String[]{ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "start", "end"}, -1);
                m("app:layout_constraintTag", bVar.f4850m0, null);
                int[] iArr = bVar.f4846k0;
                if (iArr != null) {
                    n("'ReferenceIds'", iArr);
                }
                this.f4941a.write(" />\n");
            }
            this.f4941a.write("</ConstraintSet>\n");
        }

        void j(String name, float value, float def) throws IOException {
            if (value == def) {
                return;
            }
            this.f4941a.write(f4940o + name);
            this.f4941a.write("=\"" + value + "\"");
        }

        void k(String name, int value) throws IOException {
            if (value == 0 || value == -1) {
                return;
            }
            this.f4941a.write(f4940o + name + "=\"" + value + "\"\n");
        }

        void l(String name, String value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4941a.write(name);
            this.f4941a.write(":");
            this.f4941a.write(", " + value);
            this.f4941a.write("\n");
        }

        void m(String name, String value, String def) throws IOException {
            if (value == null || value.equals(def)) {
                return;
            }
            this.f4941a.write(f4940o + name);
            this.f4941a.write("=\"" + value + "\"");
        }

        void n(String name, int[] value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4941a.write(f4940o + name);
            this.f4941a.write(":");
            int i7 = 0;
            while (i7 < value.length) {
                Writer writer = this.f4941a;
                StringBuilder sb = new StringBuilder();
                sb.append(i7 == 0 ? "[" : ", ");
                sb.append(a(value[i7]));
                writer.write(sb.toString());
                i7++;
            }
            this.f4941a.write("],\n");
        }

        void o(String str, int leftToLeft) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            this.f4941a.write(f4940o + str);
            this.f4941a.write("=\"" + a(leftToLeft) + "\"");
        }
    }

    static {
        W.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        W.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        W.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        W.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        W.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        W.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        W.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        W.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        W.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        W.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, K1);
        W.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, L1);
        W.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        W.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        W.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        W.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        W.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        W.append(R.styleable.Constraint_guidelineUseRtl, 99);
        W.append(R.styleable.Constraint_android_orientation, 27);
        W.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        W.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        W.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        W.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        W.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        W.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        W.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        W.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        W.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        W.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        W.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        W.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        W.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        W.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        W.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        W.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        W.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        W.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        W.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        W.append(R.styleable.Constraint_android_layout_marginRight, 28);
        W.append(R.styleable.Constraint_android_layout_marginStart, 31);
        W.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        W.append(R.styleable.Constraint_android_layout_marginTop, 34);
        W.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        W.append(R.styleable.Constraint_android_layout_width, 23);
        W.append(R.styleable.Constraint_android_layout_height, 21);
        W.append(R.styleable.Constraint_layout_constraintWidth, O1);
        W.append(R.styleable.Constraint_layout_constraintHeight, 96);
        W.append(R.styleable.Constraint_android_visibility, 22);
        W.append(R.styleable.Constraint_android_alpha, 43);
        W.append(R.styleable.Constraint_android_elevation, 44);
        W.append(R.styleable.Constraint_android_rotationX, 45);
        W.append(R.styleable.Constraint_android_rotationY, 46);
        W.append(R.styleable.Constraint_android_rotation, 60);
        W.append(R.styleable.Constraint_android_scaleX, 47);
        W.append(R.styleable.Constraint_android_scaleY, 48);
        W.append(R.styleable.Constraint_android_transformPivotX, 49);
        W.append(R.styleable.Constraint_android_transformPivotY, 50);
        W.append(R.styleable.Constraint_android_translationX, 51);
        W.append(R.styleable.Constraint_android_translationY, 52);
        W.append(R.styleable.Constraint_android_translationZ, 53);
        W.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        W.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        W.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        W.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        W.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        W.append(R.styleable.Constraint_layout_constraintHeight_min, f4696e1);
        W.append(R.styleable.Constraint_layout_constraintCircle, 61);
        W.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        W.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        W.append(R.styleable.Constraint_animateRelativeTo, 64);
        W.append(R.styleable.Constraint_transitionEasing, 65);
        W.append(R.styleable.Constraint_drawPath, 66);
        W.append(R.styleable.Constraint_transitionPathRotate, 67);
        W.append(R.styleable.Constraint_motionStagger, 79);
        W.append(R.styleable.Constraint_android_id, 38);
        W.append(R.styleable.Constraint_motionProgress, 68);
        W.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        W.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        W.append(R.styleable.Constraint_layout_wrapBehaviorInParent, Q1);
        W.append(R.styleable.Constraint_chainUseRtl, f4730q1);
        W.append(R.styleable.Constraint_barrierDirection, 72);
        W.append(R.styleable.Constraint_barrierMargin, 73);
        W.append(R.styleable.Constraint_constraint_referenced_ids, f4739t1);
        W.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        W.append(R.styleable.Constraint_pathMotionArc, 76);
        W.append(R.styleable.Constraint_layout_constraintTag, f4748w1);
        W.append(R.styleable.Constraint_visibilityMode, f4751x1);
        W.append(R.styleable.Constraint_layout_constrainedWidth, f4757z1);
        W.append(R.styleable.Constraint_layout_constrainedHeight, A1);
        W.append(R.styleable.Constraint_polarRelativeTo, B1);
        W.append(R.styleable.Constraint_transformPivotTarget, C1);
        W.append(R.styleable.Constraint_quantizeMotionSteps, D1);
        W.append(R.styleable.Constraint_quantizeMotionPhase, E1);
        W.append(R.styleable.Constraint_quantizeMotionInterpolator, F1);
        X.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        X.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        X.append(R.styleable.ConstraintOverride_android_orientation, 27);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        X.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        X.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        X.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        X.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        X.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        X.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        X.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        X.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        X.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        X.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        X.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        X.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        X.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        X.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        X.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        X.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth, O1);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        X.append(R.styleable.ConstraintOverride_android_visibility, 22);
        X.append(R.styleable.ConstraintOverride_android_alpha, 43);
        X.append(R.styleable.ConstraintOverride_android_elevation, 44);
        X.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        X.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        X.append(R.styleable.ConstraintOverride_android_rotation, 60);
        X.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        X.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        X.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        X.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        X.append(R.styleable.ConstraintOverride_android_translationX, 51);
        X.append(R.styleable.ConstraintOverride_android_translationY, 52);
        X.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, f4696e1);
        X.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        X.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        X.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        X.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        X.append(R.styleable.ConstraintOverride_drawPath, 66);
        X.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        X.append(R.styleable.ConstraintOverride_motionStagger, 79);
        X.append(R.styleable.ConstraintOverride_android_id, 38);
        X.append(R.styleable.ConstraintOverride_motionTarget, R1);
        X.append(R.styleable.ConstraintOverride_motionProgress, 68);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        X.append(R.styleable.ConstraintOverride_chainUseRtl, f4730q1);
        X.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        X.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        X.append(R.styleable.ConstraintOverride_constraint_referenced_ids, f4739t1);
        X.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        X.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        X.append(R.styleable.ConstraintOverride_layout_constraintTag, f4748w1);
        X.append(R.styleable.ConstraintOverride_visibilityMode, f4751x1);
        X.append(R.styleable.ConstraintOverride_layout_constrainedWidth, f4757z1);
        X.append(R.styleable.ConstraintOverride_layout_constrainedHeight, A1);
        X.append(R.styleable.ConstraintOverride_polarRelativeTo, B1);
        X.append(R.styleable.ConstraintOverride_transformPivotTarget, C1);
        X.append(R.styleable.ConstraintOverride_quantizeMotionSteps, D1);
        X.append(R.styleable.ConstraintOverride_quantizeMotionPhase, E1);
        X.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, F1);
        X.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, Q1);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0031  */
    /* JADX WARN: Code duplicated, block: B:23:0x0035  */
    /* JADX WARN: Code duplicated, block: B:24:0x003a  */
    /* JADX WARN: Code duplicated, block: B:25:0x003f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    /* JADX WARN: Code duplicated, block: B:29:0x0047  */
    /* JADX WARN: Code duplicated, block: B:30:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0051  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:35:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    static void A0(Object data, TypedArray a8, int attr, int orientation) {
        int dimensionPixelSize;
        boolean z7;
        a.C0048a c0048a;
        b bVar;
        ConstraintLayout.LayoutParams layoutParams;
        if (data == null) {
            return;
        }
        int i7 = a8.peekValue(attr).type;
        if (i7 == 3) {
            B0(data, a8.getString(attr), orientation);
            return;
        }
        int i8 = 0;
        if (i7 != 5) {
            dimensionPixelSize = a8.getInt(attr, 0);
            if (dimensionPixelSize == -4) {
                z7 = true;
                i8 = -2;
            } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                z7 = false;
            }
            if (data instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) data;
                if (orientation == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i8;
                    layoutParams.f4519a0 = z7;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i8;
                    layoutParams.f4521b0 = z7;
                    return;
                }
            }
            if (data instanceof b) {
                bVar = (b) data;
                if (orientation == 0) {
                    bVar.f4831d = i8;
                    bVar.f4852n0 = z7;
                    return;
                } else {
                    bVar.f4833e = i8;
                    bVar.f4854o0 = z7;
                    return;
                }
            }
            if (data instanceof a.C0048a) {
                c0048a = (a.C0048a) data;
                if (orientation == 0) {
                    c0048a.b(23, i8);
                    c0048a.d(f4757z1, z7);
                } else {
                    c0048a.b(21, i8);
                    c0048a.d(A1, z7);
                }
            }
        }
        dimensionPixelSize = a8.getDimensionPixelSize(attr, 0);
        i8 = dimensionPixelSize;
        z7 = false;
        if (data instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) data;
            if (orientation == 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = i8;
                layoutParams.f4519a0 = z7;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = i8;
                layoutParams.f4521b0 = z7;
                return;
            }
        }
        if (data instanceof b) {
            bVar = (b) data;
            if (orientation == 0) {
                bVar.f4831d = i8;
                bVar.f4852n0 = z7;
                return;
            } else {
                bVar.f4833e = i8;
                bVar.f4854o0 = z7;
                return;
            }
        }
        if (data instanceof a.C0048a) {
            c0048a = (a.C0048a) data;
            if (orientation == 0) {
                c0048a.b(23, i8);
                c0048a.d(f4757z1, z7);
            } else {
                c0048a.b(21, i8);
                c0048a.d(A1, z7);
            }
        }
    }

    static void B0(Object data, String value, int orientation) {
        if (value == null) {
            return;
        }
        int iIndexOf = value.indexOf(61);
        int length = value.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = value.substring(0, iIndexOf);
        String strSubstring2 = value.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if (U1.equalsIgnoreCase(strTrim)) {
                if (data instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) data;
                    if (orientation == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                    }
                    C0(layoutParams, strTrim2);
                    return;
                }
                if (data instanceof b) {
                    ((b) data).A = strTrim2;
                    return;
                } else {
                    if (data instanceof a.C0048a) {
                        ((a.C0048a) data).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if (T1.equalsIgnoreCase(strTrim)) {
                    float f8 = Float.parseFloat(strTrim2);
                    if (data instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                            layoutParams2.L = f8;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                            layoutParams2.M = f8;
                        }
                    } else if (data instanceof b) {
                        b bVar = (b) data;
                        if (orientation == 0) {
                            bVar.f4831d = 0;
                            bVar.W = f8;
                        } else {
                            bVar.f4833e = 0;
                            bVar.V = f8;
                        }
                    } else if (data instanceof a.C0048a) {
                        a.C0048a c0048a = (a.C0048a) data;
                        if (orientation == 0) {
                            c0048a.b(23, 0);
                            c0048a.a(39, f8);
                        } else {
                            c0048a.b(21, 0);
                            c0048a.a(40, f8);
                        }
                    }
                } else {
                    if (!V1.equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (data instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                            layoutParams3.V = fMax;
                            layoutParams3.P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                            layoutParams3.W = fMax;
                            layoutParams3.Q = 2;
                        }
                    } else if (data instanceof b) {
                        b bVar2 = (b) data;
                        if (orientation == 0) {
                            bVar2.f4831d = 0;
                            bVar2.f4836f0 = fMax;
                            bVar2.Z = 2;
                        } else {
                            bVar2.f4833e = 0;
                            bVar2.f4838g0 = fMax;
                            bVar2.f4826a0 = 2;
                        }
                    } else if (data instanceof a.C0048a) {
                        a.C0048a c0048a2 = (a.C0048a) data;
                        if (orientation == 0) {
                            c0048a2.b(23, 0);
                            c0048a2.b(54, 2);
                        } else {
                            c0048a2.b(21, 0);
                            c0048a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    static void C0(ConstraintLayout.LayoutParams params, String value) {
        float fAbs = Float.NaN;
        int i7 = -1;
        if (value != null) {
            int length = value.length();
            int iIndexOf = value.indexOf(44);
            int i8 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = value.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i7 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i7 = 1;
                }
                i8 = iIndexOf + 1;
            }
            int iIndexOf2 = value.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = value.substring(i8);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = value.substring(i8, iIndexOf2);
                    String strSubstring4 = value.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f8 = Float.parseFloat(strSubstring3);
                        float f9 = Float.parseFloat(strSubstring4);
                        if (f8 > 0.0f && f9 > 0.0f) {
                            fAbs = i7 == 1 ? Math.abs(f9 / f8) : Math.abs(f8 / f9);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        params.I = value;
        params.f4517J = fAbs;
        params.K = i7;
    }

    private String F1(int side) {
        switch (side) {
            case 1:
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            case 2:
                return "right";
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private void G0(Context ctx, a c8, TypedArray a8, boolean override) {
        if (override) {
            H0(ctx, c8, a8);
            return;
        }
        int indexCount = a8.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = a8.getIndex(i7);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                c8.f4768d.f4880a = true;
                c8.f4769e.f4827b = true;
                c8.f4767c.f4894a = true;
                c8.f4770f.f4911a = true;
            }
            switch (W.get(index)) {
                case 1:
                    b bVar = c8.f4769e;
                    bVar.f4859r = y0(a8, index, bVar.f4859r);
                    break;
                case 2:
                    b bVar2 = c8.f4769e;
                    bVar2.K = a8.getDimensionPixelSize(index, bVar2.K);
                    break;
                case 3:
                    b bVar3 = c8.f4769e;
                    bVar3.f4857q = y0(a8, index, bVar3.f4857q);
                    break;
                case 4:
                    b bVar4 = c8.f4769e;
                    bVar4.f4855p = y0(a8, index, bVar4.f4855p);
                    break;
                case 5:
                    c8.f4769e.A = a8.getString(index);
                    break;
                case 6:
                    b bVar5 = c8.f4769e;
                    bVar5.E = a8.getDimensionPixelOffset(index, bVar5.E);
                    break;
                case 7:
                    b bVar6 = c8.f4769e;
                    bVar6.F = a8.getDimensionPixelOffset(index, bVar6.F);
                    break;
                case 8:
                    b bVar7 = c8.f4769e;
                    bVar7.L = a8.getDimensionPixelSize(index, bVar7.L);
                    break;
                case 9:
                    b bVar8 = c8.f4769e;
                    bVar8.f4865x = y0(a8, index, bVar8.f4865x);
                    break;
                case 10:
                    b bVar9 = c8.f4769e;
                    bVar9.f4864w = y0(a8, index, bVar9.f4864w);
                    break;
                case 11:
                    b bVar10 = c8.f4769e;
                    bVar10.R = a8.getDimensionPixelSize(index, bVar10.R);
                    break;
                case 12:
                    b bVar11 = c8.f4769e;
                    bVar11.S = a8.getDimensionPixelSize(index, bVar11.S);
                    break;
                case 13:
                    b bVar12 = c8.f4769e;
                    bVar12.O = a8.getDimensionPixelSize(index, bVar12.O);
                    break;
                case 14:
                    b bVar13 = c8.f4769e;
                    bVar13.Q = a8.getDimensionPixelSize(index, bVar13.Q);
                    break;
                case 15:
                    b bVar14 = c8.f4769e;
                    bVar14.T = a8.getDimensionPixelSize(index, bVar14.T);
                    break;
                case 16:
                    b bVar15 = c8.f4769e;
                    bVar15.P = a8.getDimensionPixelSize(index, bVar15.P);
                    break;
                case 17:
                    b bVar16 = c8.f4769e;
                    bVar16.f4835f = a8.getDimensionPixelOffset(index, bVar16.f4835f);
                    break;
                case 18:
                    b bVar17 = c8.f4769e;
                    bVar17.f4837g = a8.getDimensionPixelOffset(index, bVar17.f4837g);
                    break;
                case 19:
                    b bVar18 = c8.f4769e;
                    bVar18.f4839h = a8.getFloat(index, bVar18.f4839h);
                    break;
                case 20:
                    b bVar19 = c8.f4769e;
                    bVar19.f4866y = a8.getFloat(index, bVar19.f4866y);
                    break;
                case 21:
                    b bVar20 = c8.f4769e;
                    bVar20.f4833e = a8.getLayoutDimension(index, bVar20.f4833e);
                    break;
                case 22:
                    C0049d c0049d = c8.f4767c;
                    c0049d.f4895b = a8.getInt(index, c0049d.f4895b);
                    C0049d c0049d2 = c8.f4767c;
                    c0049d2.f4895b = U[c0049d2.f4895b];
                    break;
                case 23:
                    b bVar21 = c8.f4769e;
                    bVar21.f4831d = a8.getLayoutDimension(index, bVar21.f4831d);
                    break;
                case 24:
                    b bVar22 = c8.f4769e;
                    bVar22.H = a8.getDimensionPixelSize(index, bVar22.H);
                    break;
                case 25:
                    b bVar23 = c8.f4769e;
                    bVar23.f4843j = y0(a8, index, bVar23.f4843j);
                    break;
                case 26:
                    b bVar24 = c8.f4769e;
                    bVar24.f4845k = y0(a8, index, bVar24.f4845k);
                    break;
                case 27:
                    b bVar25 = c8.f4769e;
                    bVar25.G = a8.getInt(index, bVar25.G);
                    break;
                case 28:
                    b bVar26 = c8.f4769e;
                    bVar26.I = a8.getDimensionPixelSize(index, bVar26.I);
                    break;
                case 29:
                    b bVar27 = c8.f4769e;
                    bVar27.f4847l = y0(a8, index, bVar27.f4847l);
                    break;
                case 30:
                    b bVar28 = c8.f4769e;
                    bVar28.f4849m = y0(a8, index, bVar28.f4849m);
                    break;
                case 31:
                    b bVar29 = c8.f4769e;
                    bVar29.M = a8.getDimensionPixelSize(index, bVar29.M);
                    break;
                case 32:
                    b bVar30 = c8.f4769e;
                    bVar30.f4862u = y0(a8, index, bVar30.f4862u);
                    break;
                case 33:
                    b bVar31 = c8.f4769e;
                    bVar31.f4863v = y0(a8, index, bVar31.f4863v);
                    break;
                case 34:
                    b bVar32 = c8.f4769e;
                    bVar32.f4824J = a8.getDimensionPixelSize(index, bVar32.f4824J);
                    break;
                case 35:
                    b bVar33 = c8.f4769e;
                    bVar33.f4853o = y0(a8, index, bVar33.f4853o);
                    break;
                case 36:
                    b bVar34 = c8.f4769e;
                    bVar34.f4851n = y0(a8, index, bVar34.f4851n);
                    break;
                case 37:
                    b bVar35 = c8.f4769e;
                    bVar35.f4867z = a8.getFloat(index, bVar35.f4867z);
                    break;
                case 38:
                    c8.f4765a = a8.getResourceId(index, c8.f4765a);
                    break;
                case 39:
                    b bVar36 = c8.f4769e;
                    bVar36.W = a8.getFloat(index, bVar36.W);
                    break;
                case 40:
                    b bVar37 = c8.f4769e;
                    bVar37.V = a8.getFloat(index, bVar37.V);
                    break;
                case 41:
                    b bVar38 = c8.f4769e;
                    bVar38.X = a8.getInt(index, bVar38.X);
                    break;
                case 42:
                    b bVar39 = c8.f4769e;
                    bVar39.Y = a8.getInt(index, bVar39.Y);
                    break;
                case 43:
                    C0049d c0049d3 = c8.f4767c;
                    c0049d3.f4897d = a8.getFloat(index, c0049d3.f4897d);
                    break;
                case 44:
                    e eVar = c8.f4770f;
                    eVar.f4923m = true;
                    eVar.f4924n = a8.getDimension(index, eVar.f4924n);
                    break;
                case 45:
                    e eVar2 = c8.f4770f;
                    eVar2.f4913c = a8.getFloat(index, eVar2.f4913c);
                    break;
                case 46:
                    e eVar3 = c8.f4770f;
                    eVar3.f4914d = a8.getFloat(index, eVar3.f4914d);
                    break;
                case 47:
                    e eVar4 = c8.f4770f;
                    eVar4.f4915e = a8.getFloat(index, eVar4.f4915e);
                    break;
                case 48:
                    e eVar5 = c8.f4770f;
                    eVar5.f4916f = a8.getFloat(index, eVar5.f4916f);
                    break;
                case 49:
                    e eVar6 = c8.f4770f;
                    eVar6.f4917g = a8.getDimension(index, eVar6.f4917g);
                    break;
                case 50:
                    e eVar7 = c8.f4770f;
                    eVar7.f4918h = a8.getDimension(index, eVar7.f4918h);
                    break;
                case 51:
                    e eVar8 = c8.f4770f;
                    eVar8.f4920j = a8.getDimension(index, eVar8.f4920j);
                    break;
                case 52:
                    e eVar9 = c8.f4770f;
                    eVar9.f4921k = a8.getDimension(index, eVar9.f4921k);
                    break;
                case 53:
                    e eVar10 = c8.f4770f;
                    eVar10.f4922l = a8.getDimension(index, eVar10.f4922l);
                    break;
                case 54:
                    b bVar40 = c8.f4769e;
                    bVar40.Z = a8.getInt(index, bVar40.Z);
                    break;
                case 55:
                    b bVar41 = c8.f4769e;
                    bVar41.f4826a0 = a8.getInt(index, bVar41.f4826a0);
                    break;
                case 56:
                    b bVar42 = c8.f4769e;
                    bVar42.f4828b0 = a8.getDimensionPixelSize(index, bVar42.f4828b0);
                    break;
                case 57:
                    b bVar43 = c8.f4769e;
                    bVar43.f4830c0 = a8.getDimensionPixelSize(index, bVar43.f4830c0);
                    break;
                case 58:
                    b bVar44 = c8.f4769e;
                    bVar44.f4832d0 = a8.getDimensionPixelSize(index, bVar44.f4832d0);
                    break;
                case f4696e1 /* 59 */:
                    b bVar45 = c8.f4769e;
                    bVar45.f4834e0 = a8.getDimensionPixelSize(index, bVar45.f4834e0);
                    break;
                case 60:
                    e eVar11 = c8.f4770f;
                    eVar11.f4912b = a8.getFloat(index, eVar11.f4912b);
                    break;
                case 61:
                    b bVar46 = c8.f4769e;
                    bVar46.B = y0(a8, index, bVar46.B);
                    break;
                case 62:
                    b bVar47 = c8.f4769e;
                    bVar47.C = a8.getDimensionPixelSize(index, bVar47.C);
                    break;
                case 63:
                    b bVar48 = c8.f4769e;
                    bVar48.D = a8.getFloat(index, bVar48.D);
                    break;
                case 64:
                    c cVar = c8.f4768d;
                    cVar.f4881b = y0(a8, index, cVar.f4881b);
                    break;
                case 65:
                    if (a8.peekValue(index).type == 3) {
                        c8.f4768d.f4883d = a8.getString(index);
                    } else {
                        c8.f4768d.f4883d = androidx.constraintlayout.core.motion.utils.d.f2786o[a8.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    c8.f4768d.f4885f = a8.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = c8.f4768d;
                    cVar2.f4888i = a8.getFloat(index, cVar2.f4888i);
                    break;
                case 68:
                    C0049d c0049d4 = c8.f4767c;
                    c0049d4.f4898e = a8.getFloat(index, c0049d4.f4898e);
                    break;
                case 69:
                    c8.f4769e.f4836f0 = a8.getFloat(index, 1.0f);
                    break;
                case 70:
                    c8.f4769e.f4838g0 = a8.getFloat(index, 1.0f);
                    break;
                case f4730q1 /* 71 */:
                    Log.e(f4701h, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = c8.f4769e;
                    bVar49.f4840h0 = a8.getInt(index, bVar49.f4840h0);
                    break;
                case 73:
                    b bVar50 = c8.f4769e;
                    bVar50.f4842i0 = a8.getDimensionPixelSize(index, bVar50.f4842i0);
                    break;
                case f4739t1 /* 74 */:
                    c8.f4769e.f4848l0 = a8.getString(index);
                    break;
                case 75:
                    b bVar51 = c8.f4769e;
                    bVar51.f4856p0 = a8.getBoolean(index, bVar51.f4856p0);
                    break;
                case 76:
                    c cVar3 = c8.f4768d;
                    cVar3.f4884e = a8.getInt(index, cVar3.f4884e);
                    break;
                case f4748w1 /* 77 */:
                    c8.f4769e.f4850m0 = a8.getString(index);
                    break;
                case f4751x1 /* 78 */:
                    C0049d c0049d5 = c8.f4767c;
                    c0049d5.f4896c = a8.getInt(index, c0049d5.f4896c);
                    break;
                case 79:
                    c cVar4 = c8.f4768d;
                    cVar4.f4886g = a8.getFloat(index, cVar4.f4886g);
                    break;
                case f4757z1 /* 80 */:
                    b bVar52 = c8.f4769e;
                    bVar52.f4852n0 = a8.getBoolean(index, bVar52.f4852n0);
                    break;
                case A1 /* 81 */:
                    b bVar53 = c8.f4769e;
                    bVar53.f4854o0 = a8.getBoolean(index, bVar53.f4854o0);
                    break;
                case B1 /* 82 */:
                    c cVar5 = c8.f4768d;
                    cVar5.f4882c = a8.getInteger(index, cVar5.f4882c);
                    break;
                case C1 /* 83 */:
                    e eVar12 = c8.f4770f;
                    eVar12.f4919i = y0(a8, index, eVar12.f4919i);
                    break;
                case D1 /* 84 */:
                    c cVar6 = c8.f4768d;
                    cVar6.f4890k = a8.getInteger(index, cVar6.f4890k);
                    break;
                case E1 /* 85 */:
                    c cVar7 = c8.f4768d;
                    cVar7.f4889j = a8.getFloat(index, cVar7.f4889j);
                    break;
                case F1 /* 86 */:
                    int i8 = a8.peekValue(index).type;
                    if (i8 == 1) {
                        c8.f4768d.f4893n = a8.getResourceId(index, -1);
                        c cVar8 = c8.f4768d;
                        if (cVar8.f4893n != -1) {
                            cVar8.f4892m = -2;
                        }
                    } else if (i8 == 3) {
                        c8.f4768d.f4891l = a8.getString(index);
                        if (c8.f4768d.f4891l.indexOf("/") > 0) {
                            c8.f4768d.f4893n = a8.getResourceId(index, -1);
                            c8.f4768d.f4892m = -2;
                        } else {
                            c8.f4768d.f4892m = -1;
                        }
                    } else {
                        c cVar9 = c8.f4768d;
                        cVar9.f4892m = a8.getInteger(index, cVar9.f4893n);
                    }
                    break;
                case 87:
                    Log.w(f4701h, "unused attribute 0x" + Integer.toHexString(index) + "   " + W.get(index));
                    break;
                case H1 /* 88 */:
                case 89:
                case 90:
                default:
                    Log.w(f4701h, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + W.get(index));
                    break;
                case K1 /* 91 */:
                    b bVar54 = c8.f4769e;
                    bVar54.f4860s = y0(a8, index, bVar54.f4860s);
                    break;
                case L1 /* 92 */:
                    b bVar55 = c8.f4769e;
                    bVar55.f4861t = y0(a8, index, bVar55.f4861t);
                    break;
                case M1 /* 93 */:
                    b bVar56 = c8.f4769e;
                    bVar56.N = a8.getDimensionPixelSize(index, bVar56.N);
                    break;
                case N1 /* 94 */:
                    b bVar57 = c8.f4769e;
                    bVar57.U = a8.getDimensionPixelSize(index, bVar57.U);
                    break;
                case O1 /* 95 */:
                    A0(c8.f4769e, a8, index, 0);
                    break;
                case 96:
                    A0(c8.f4769e, a8, index, 1);
                    break;
                case Q1 /* 97 */:
                    b bVar58 = c8.f4769e;
                    bVar58.f4858q0 = a8.getInt(index, bVar58.f4858q0);
                    break;
            }
        }
        b bVar59 = c8.f4769e;
        if (bVar59.f4848l0 != null) {
            bVar59.f4846k0 = null;
        }
    }

    private static String[] G1(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        boolean z7 = false;
        for (int i8 = 0; i8 < charArray.length; i8++) {
            char c8 = charArray[i8];
            if (c8 == ',' && !z7) {
                arrayList.add(new String(charArray, i7, i8 - i7));
                i7 = i8 + 1;
            } else if (c8 == '\"') {
                z7 = !z7;
            }
        }
        arrayList.add(new String(charArray, i7, charArray.length - i7));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static void H0(Context ctx, a c8, TypedArray a8) {
        int indexCount = a8.getIndexCount();
        a.C0048a c0048a = new a.C0048a();
        c8.f4772h = c0048a;
        c8.f4768d.f4880a = false;
        c8.f4769e.f4827b = false;
        c8.f4767c.f4894a = false;
        c8.f4770f.f4911a = false;
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = a8.getIndex(i7);
            switch (X.get(index)) {
                case 2:
                    c0048a.b(2, a8.getDimensionPixelSize(index, c8.f4769e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case H1 /* 88 */:
                case 89:
                case 90:
                case K1 /* 91 */:
                case L1 /* 92 */:
                default:
                    Log.w(f4701h, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + W.get(index));
                    break;
                case 5:
                    c0048a.c(5, a8.getString(index));
                    break;
                case 6:
                    c0048a.b(6, a8.getDimensionPixelOffset(index, c8.f4769e.E));
                    break;
                case 7:
                    c0048a.b(7, a8.getDimensionPixelOffset(index, c8.f4769e.F));
                    break;
                case 8:
                    c0048a.b(8, a8.getDimensionPixelSize(index, c8.f4769e.L));
                    break;
                case 11:
                    c0048a.b(11, a8.getDimensionPixelSize(index, c8.f4769e.R));
                    break;
                case 12:
                    c0048a.b(12, a8.getDimensionPixelSize(index, c8.f4769e.S));
                    break;
                case 13:
                    c0048a.b(13, a8.getDimensionPixelSize(index, c8.f4769e.O));
                    break;
                case 14:
                    c0048a.b(14, a8.getDimensionPixelSize(index, c8.f4769e.Q));
                    break;
                case 15:
                    c0048a.b(15, a8.getDimensionPixelSize(index, c8.f4769e.T));
                    break;
                case 16:
                    c0048a.b(16, a8.getDimensionPixelSize(index, c8.f4769e.P));
                    break;
                case 17:
                    c0048a.b(17, a8.getDimensionPixelOffset(index, c8.f4769e.f4835f));
                    break;
                case 18:
                    c0048a.b(18, a8.getDimensionPixelOffset(index, c8.f4769e.f4837g));
                    break;
                case 19:
                    c0048a.a(19, a8.getFloat(index, c8.f4769e.f4839h));
                    break;
                case 20:
                    c0048a.a(20, a8.getFloat(index, c8.f4769e.f4866y));
                    break;
                case 21:
                    c0048a.b(21, a8.getLayoutDimension(index, c8.f4769e.f4833e));
                    break;
                case 22:
                    c0048a.b(22, U[a8.getInt(index, c8.f4767c.f4895b)]);
                    break;
                case 23:
                    c0048a.b(23, a8.getLayoutDimension(index, c8.f4769e.f4831d));
                    break;
                case 24:
                    c0048a.b(24, a8.getDimensionPixelSize(index, c8.f4769e.H));
                    break;
                case 27:
                    c0048a.b(27, a8.getInt(index, c8.f4769e.G));
                    break;
                case 28:
                    c0048a.b(28, a8.getDimensionPixelSize(index, c8.f4769e.I));
                    break;
                case 31:
                    c0048a.b(31, a8.getDimensionPixelSize(index, c8.f4769e.M));
                    break;
                case 34:
                    c0048a.b(34, a8.getDimensionPixelSize(index, c8.f4769e.f4824J));
                    break;
                case 37:
                    c0048a.a(37, a8.getFloat(index, c8.f4769e.f4867z));
                    break;
                case 38:
                    int resourceId = a8.getResourceId(index, c8.f4765a);
                    c8.f4765a = resourceId;
                    c0048a.b(38, resourceId);
                    break;
                case 39:
                    c0048a.a(39, a8.getFloat(index, c8.f4769e.W));
                    break;
                case 40:
                    c0048a.a(40, a8.getFloat(index, c8.f4769e.V));
                    break;
                case 41:
                    c0048a.b(41, a8.getInt(index, c8.f4769e.X));
                    break;
                case 42:
                    c0048a.b(42, a8.getInt(index, c8.f4769e.Y));
                    break;
                case 43:
                    c0048a.a(43, a8.getFloat(index, c8.f4767c.f4897d));
                    break;
                case 44:
                    c0048a.d(44, true);
                    c0048a.a(44, a8.getDimension(index, c8.f4770f.f4924n));
                    break;
                case 45:
                    c0048a.a(45, a8.getFloat(index, c8.f4770f.f4913c));
                    break;
                case 46:
                    c0048a.a(46, a8.getFloat(index, c8.f4770f.f4914d));
                    break;
                case 47:
                    c0048a.a(47, a8.getFloat(index, c8.f4770f.f4915e));
                    break;
                case 48:
                    c0048a.a(48, a8.getFloat(index, c8.f4770f.f4916f));
                    break;
                case 49:
                    c0048a.a(49, a8.getDimension(index, c8.f4770f.f4917g));
                    break;
                case 50:
                    c0048a.a(50, a8.getDimension(index, c8.f4770f.f4918h));
                    break;
                case 51:
                    c0048a.a(51, a8.getDimension(index, c8.f4770f.f4920j));
                    break;
                case 52:
                    c0048a.a(52, a8.getDimension(index, c8.f4770f.f4921k));
                    break;
                case 53:
                    c0048a.a(53, a8.getDimension(index, c8.f4770f.f4922l));
                    break;
                case 54:
                    c0048a.b(54, a8.getInt(index, c8.f4769e.Z));
                    break;
                case 55:
                    c0048a.b(55, a8.getInt(index, c8.f4769e.f4826a0));
                    break;
                case 56:
                    c0048a.b(56, a8.getDimensionPixelSize(index, c8.f4769e.f4828b0));
                    break;
                case 57:
                    c0048a.b(57, a8.getDimensionPixelSize(index, c8.f4769e.f4830c0));
                    break;
                case 58:
                    c0048a.b(58, a8.getDimensionPixelSize(index, c8.f4769e.f4832d0));
                    break;
                case f4696e1 /* 59 */:
                    c0048a.b(f4696e1, a8.getDimensionPixelSize(index, c8.f4769e.f4834e0));
                    break;
                case 60:
                    c0048a.a(60, a8.getFloat(index, c8.f4770f.f4912b));
                    break;
                case 62:
                    c0048a.b(62, a8.getDimensionPixelSize(index, c8.f4769e.C));
                    break;
                case 63:
                    c0048a.a(63, a8.getFloat(index, c8.f4769e.D));
                    break;
                case 64:
                    c0048a.b(64, y0(a8, index, c8.f4768d.f4881b));
                    break;
                case 65:
                    if (a8.peekValue(index).type == 3) {
                        c0048a.c(65, a8.getString(index));
                    } else {
                        c0048a.c(65, androidx.constraintlayout.core.motion.utils.d.f2786o[a8.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    c0048a.b(66, a8.getInt(index, 0));
                    break;
                case 67:
                    c0048a.a(67, a8.getFloat(index, c8.f4768d.f4888i));
                    break;
                case 68:
                    c0048a.a(68, a8.getFloat(index, c8.f4767c.f4898e));
                    break;
                case 69:
                    c0048a.a(69, a8.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0048a.a(70, a8.getFloat(index, 1.0f));
                    break;
                case f4730q1 /* 71 */:
                    Log.e(f4701h, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0048a.b(72, a8.getInt(index, c8.f4769e.f4840h0));
                    break;
                case 73:
                    c0048a.b(73, a8.getDimensionPixelSize(index, c8.f4769e.f4842i0));
                    break;
                case f4739t1 /* 74 */:
                    c0048a.c(f4739t1, a8.getString(index));
                    break;
                case 75:
                    c0048a.d(75, a8.getBoolean(index, c8.f4769e.f4856p0));
                    break;
                case 76:
                    c0048a.b(76, a8.getInt(index, c8.f4768d.f4884e));
                    break;
                case f4748w1 /* 77 */:
                    c0048a.c(f4748w1, a8.getString(index));
                    break;
                case f4751x1 /* 78 */:
                    c0048a.b(f4751x1, a8.getInt(index, c8.f4767c.f4896c));
                    break;
                case 79:
                    c0048a.a(79, a8.getFloat(index, c8.f4768d.f4886g));
                    break;
                case f4757z1 /* 80 */:
                    c0048a.d(f4757z1, a8.getBoolean(index, c8.f4769e.f4852n0));
                    break;
                case A1 /* 81 */:
                    c0048a.d(A1, a8.getBoolean(index, c8.f4769e.f4854o0));
                    break;
                case B1 /* 82 */:
                    c0048a.b(B1, a8.getInteger(index, c8.f4768d.f4882c));
                    break;
                case C1 /* 83 */:
                    c0048a.b(C1, y0(a8, index, c8.f4770f.f4919i));
                    break;
                case D1 /* 84 */:
                    c0048a.b(D1, a8.getInteger(index, c8.f4768d.f4890k));
                    break;
                case E1 /* 85 */:
                    c0048a.a(E1, a8.getFloat(index, c8.f4768d.f4889j));
                    break;
                case F1 /* 86 */:
                    int i8 = a8.peekValue(index).type;
                    if (i8 == 1) {
                        c8.f4768d.f4893n = a8.getResourceId(index, -1);
                        c0048a.b(89, c8.f4768d.f4893n);
                        c cVar = c8.f4768d;
                        if (cVar.f4893n != -1) {
                            cVar.f4892m = -2;
                            c0048a.b(H1, -2);
                        }
                    } else if (i8 == 3) {
                        c8.f4768d.f4891l = a8.getString(index);
                        c0048a.c(90, c8.f4768d.f4891l);
                        if (c8.f4768d.f4891l.indexOf("/") > 0) {
                            c8.f4768d.f4893n = a8.getResourceId(index, -1);
                            c0048a.b(89, c8.f4768d.f4893n);
                            c8.f4768d.f4892m = -2;
                            c0048a.b(H1, -2);
                        } else {
                            c8.f4768d.f4892m = -1;
                            c0048a.b(H1, -1);
                        }
                    } else {
                        c cVar2 = c8.f4768d;
                        cVar2.f4892m = a8.getInteger(index, cVar2.f4893n);
                        c0048a.b(H1, c8.f4768d.f4892m);
                    }
                    break;
                case 87:
                    Log.w(f4701h, "unused attribute 0x" + Integer.toHexString(index) + "   " + W.get(index));
                    break;
                case M1 /* 93 */:
                    c0048a.b(M1, a8.getDimensionPixelSize(index, c8.f4769e.N));
                    break;
                case N1 /* 94 */:
                    c0048a.b(N1, a8.getDimensionPixelSize(index, c8.f4769e.U));
                    break;
                case O1 /* 95 */:
                    A0(c0048a, a8, index, 0);
                    break;
                case 96:
                    A0(c0048a, a8, index, 1);
                    break;
                case Q1 /* 97 */:
                    c0048a.b(Q1, a8.getInt(index, c8.f4769e.f4858q0));
                    break;
                case R1 /* 98 */:
                    if (MotionLayout.W1) {
                        int resourceId2 = a8.getResourceId(index, c8.f4765a);
                        c8.f4765a = resourceId2;
                        if (resourceId2 == -1) {
                            c8.f4766b = a8.getString(index);
                        }
                    } else if (a8.peekValue(index).type == 3) {
                        c8.f4766b = a8.getString(index);
                    } else {
                        c8.f4765a = a8.getResourceId(index, c8.f4765a);
                    }
                    break;
                case 99:
                    c0048a.d(99, a8.getBoolean(index, c8.f4769e.f4841i));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R0(a c8, int type, float value) {
        if (type == 19) {
            c8.f4769e.f4839h = value;
        }
        if (type == 20) {
            c8.f4769e.f4866y = value;
            return;
        }
        if (type == 37) {
            c8.f4769e.f4867z = value;
            return;
        }
        if (type == 60) {
            c8.f4770f.f4912b = value;
            return;
        }
        if (type == 63) {
            c8.f4769e.D = value;
            return;
        }
        if (type == 79) {
            c8.f4768d.f4886g = value;
            return;
        }
        if (type == E1) {
            c8.f4768d.f4889j = value;
            return;
        }
        if (type != 87) {
            if (type == 39) {
                c8.f4769e.W = value;
                return;
            }
            if (type == 40) {
                c8.f4769e.V = value;
                return;
            }
            switch (type) {
                case 43:
                    c8.f4767c.f4897d = value;
                    break;
                case 44:
                    e eVar = c8.f4770f;
                    eVar.f4924n = value;
                    eVar.f4923m = true;
                    break;
                case 45:
                    c8.f4770f.f4913c = value;
                    break;
                case 46:
                    c8.f4770f.f4914d = value;
                    break;
                case 47:
                    c8.f4770f.f4915e = value;
                    break;
                case 48:
                    c8.f4770f.f4916f = value;
                    break;
                case 49:
                    c8.f4770f.f4917g = value;
                    break;
                case 50:
                    c8.f4770f.f4918h = value;
                    break;
                case 51:
                    c8.f4770f.f4920j = value;
                    break;
                case 52:
                    c8.f4770f.f4921k = value;
                    break;
                case 53:
                    c8.f4770f.f4922l = value;
                    break;
                default:
                    switch (type) {
                        case 67:
                            c8.f4768d.f4888i = value;
                            break;
                        case 68:
                            c8.f4767c.f4898e = value;
                            break;
                        case 69:
                            c8.f4769e.f4836f0 = value;
                            break;
                        case 70:
                            c8.f4769e.f4838g0 = value;
                            break;
                        default:
                            Log.w(f4701h, "Unknown attribute 0x");
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S0(a c8, int type, int value) {
        if (type == 6) {
            c8.f4769e.E = value;
        }
        if (type == 7) {
            c8.f4769e.F = value;
            return;
        }
        if (type == 8) {
            c8.f4769e.L = value;
            return;
        }
        if (type == 27) {
            c8.f4769e.G = value;
            return;
        }
        if (type == 28) {
            c8.f4769e.I = value;
            return;
        }
        if (type == 41) {
            c8.f4769e.X = value;
            return;
        }
        if (type == 42) {
            c8.f4769e.Y = value;
            return;
        }
        if (type == 61) {
            c8.f4769e.B = value;
            return;
        }
        if (type == 62) {
            c8.f4769e.C = value;
            return;
        }
        if (type == 72) {
            c8.f4769e.f4840h0 = value;
            return;
        }
        if (type == 73) {
            c8.f4769e.f4842i0 = value;
            return;
        }
        switch (type) {
            case 2:
                c8.f4769e.K = value;
                break;
            case 11:
                c8.f4769e.R = value;
                break;
            case 12:
                c8.f4769e.S = value;
                break;
            case 13:
                c8.f4769e.O = value;
                break;
            case 14:
                c8.f4769e.Q = value;
                break;
            case 15:
                c8.f4769e.T = value;
                break;
            case 16:
                c8.f4769e.P = value;
                break;
            case 17:
                c8.f4769e.f4835f = value;
                break;
            case 18:
                c8.f4769e.f4837g = value;
                break;
            case 31:
                c8.f4769e.M = value;
                break;
            case 34:
                c8.f4769e.f4824J = value;
                break;
            case 38:
                c8.f4765a = value;
                break;
            case 64:
                c8.f4768d.f4881b = value;
                break;
            case 66:
                c8.f4768d.f4885f = value;
                break;
            case 76:
                c8.f4768d.f4884e = value;
                break;
            case f4751x1 /* 78 */:
                c8.f4767c.f4896c = value;
                break;
            case M1 /* 93 */:
                c8.f4769e.N = value;
                break;
            case N1 /* 94 */:
                c8.f4769e.U = value;
                break;
            case Q1 /* 97 */:
                c8.f4769e.f4858q0 = value;
                break;
            default:
                switch (type) {
                    case 21:
                        c8.f4769e.f4833e = value;
                        break;
                    case 22:
                        c8.f4767c.f4895b = value;
                        break;
                    case 23:
                        c8.f4769e.f4831d = value;
                        break;
                    case 24:
                        c8.f4769e.H = value;
                        break;
                    default:
                        switch (type) {
                            case 54:
                                c8.f4769e.Z = value;
                                break;
                            case 55:
                                c8.f4769e.f4826a0 = value;
                                break;
                            case 56:
                                c8.f4769e.f4828b0 = value;
                                break;
                            case 57:
                                c8.f4769e.f4830c0 = value;
                                break;
                            case 58:
                                c8.f4769e.f4832d0 = value;
                                break;
                            case f4696e1 /* 59 */:
                                c8.f4769e.f4834e0 = value;
                                break;
                            default:
                                switch (type) {
                                    case B1 /* 82 */:
                                        c8.f4768d.f4882c = value;
                                        break;
                                    case C1 /* 83 */:
                                        c8.f4770f.f4919i = value;
                                        break;
                                    case D1 /* 84 */:
                                        c8.f4768d.f4890k = value;
                                        break;
                                    default:
                                        switch (type) {
                                            case 87:
                                                break;
                                            case H1 /* 88 */:
                                                c8.f4768d.f4892m = value;
                                                break;
                                            case 89:
                                                c8.f4768d.f4893n = value;
                                                break;
                                            default:
                                                Log.w(f4701h, "Unknown attribute 0x");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T0(a c8, int type, String value) {
        if (type == 5) {
            c8.f4769e.A = value;
            return;
        }
        if (type == 65) {
            c8.f4768d.f4883d = value;
            return;
        }
        if (type == f4739t1) {
            b bVar = c8.f4769e;
            bVar.f4848l0 = value;
            bVar.f4846k0 = null;
        } else if (type == f4748w1) {
            c8.f4769e.f4850m0 = value;
        } else if (type != 87) {
            if (type != 90) {
                Log.w(f4701h, "Unknown attribute 0x");
            } else {
                c8.f4768d.f4891l = value;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void U0(a c8, int type, boolean value) {
        if (type == 44) {
            c8.f4770f.f4923m = value;
            return;
        }
        if (type == 75) {
            c8.f4769e.f4856p0 = value;
            return;
        }
        if (type != 87) {
            if (type == f4757z1) {
                c8.f4769e.f4852n0 = value;
            } else if (type != A1) {
                Log.w(f4701h, "Unknown attribute 0x");
            } else {
                c8.f4769e.f4854o0 = value;
            }
        }
    }

    private int[] Z(View view, String referenceIdString) {
        int iIntValue;
        Object objN;
        String[] strArrSplit = referenceIdString.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i7 = 0;
        int i8 = 0;
        while (i7 < strArrSplit.length) {
            String strTrim = strArrSplit[i7].trim();
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objN = ((ConstraintLayout) view.getParent()).n(0, strTrim)) != null && (objN instanceof Integer)) {
                iIntValue = ((Integer) objN).intValue();
            }
            iArr[i8] = iIntValue;
            i7++;
            i8++;
        }
        return i8 != strArrSplit.length ? Arrays.copyOf(iArr, i8) : iArr;
    }

    private void d0(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style, int left, int right) {
        if (chainIds.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null && weights.length != chainIds.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null) {
            i0(chainIds[0]).f4769e.W = weights[0];
        }
        i0(chainIds[0]).f4769e.X = style;
        L(chainIds[0], left, leftId, leftSide, -1);
        for (int i7 = 1; i7 < chainIds.length; i7++) {
            int i8 = i7 - 1;
            L(chainIds[i7], left, chainIds[i8], right, -1);
            L(chainIds[i8], right, chainIds[i7], left, -1);
            if (weights != null) {
                i0(chainIds[i7]).f4769e.W = weights[i7];
            }
        }
        L(chainIds[chainIds.length - 1], right, rightId, rightSide, -1);
    }

    private void h(androidx.constraintlayout.widget.a.b attributeType, String... attributeName) {
        for (int i7 = 0; i7 < attributeName.length; i7++) {
            if (this.f4762e.containsKey(attributeName[i7])) {
                androidx.constraintlayout.widget.a aVar = this.f4762e.get(attributeName[i7]);
                if (aVar != null && aVar.j() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + aVar.j().name());
                }
            } else {
                this.f4762e.put(attributeName[i7], new androidx.constraintlayout.widget.a(attributeName[i7], attributeType));
            }
        }
    }

    private a h0(Context context, AttributeSet attrs, boolean override) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, override ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        G0(context, aVar, typedArrayObtainStyledAttributes, override);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private a i0(int id) {
        if (!this.f4764g.containsKey(Integer.valueOf(id))) {
            this.f4764g.put(Integer.valueOf(id), new a());
        }
        return this.f4764g.get(Integer.valueOf(id));
    }

    static String m0(int v7) {
        for (Field field : d.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt(null) == v7) {
                        return field.getName();
                    }
                    continue;
                } catch (IllegalAccessException e8) {
                    e8.printStackTrace();
                }
            }
        }
        return "UNKNOWN";
    }

    static String p0(Context context, int resourceId, XmlPullParser pullParser) {
        return ".(" + androidx.constraintlayout.motion.widget.c.i(context, resourceId) + ".xml:" + pullParser.getLineNumber() + ") \"" + pullParser.getName() + "\"";
    }

    public static a w(Context context, XmlPullParser parser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(parser);
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R.styleable.ConstraintOverride);
        H0(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int y0(TypedArray a8, int index, int def) {
        int resourceId = a8.getResourceId(index, def);
        return resourceId == -1 ? a8.getInt(index, -1) : resourceId;
    }

    public void A(int viewId, int toView) {
        if (toView == 0) {
            x(viewId, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            x(viewId, toView, 7, 0, toView, 6, 0, 0.5f);
        }
    }

    public void A1(int viewId, float bias) {
        i0(viewId).f4769e.f4867z = bias;
    }

    public void B(int centerID, int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        L(centerID, 6, startId, startSide, startMargin);
        L(centerID, 7, endId, endSide, endMargin);
        a aVar = this.f4764g.get(Integer.valueOf(centerID));
        if (aVar != null) {
            aVar.f4769e.f4866y = bias;
        }
    }

    public void B1(int viewId, int chainStyle) {
        i0(viewId).f4769e.Y = chainStyle;
    }

    public void C(int viewId, int toView) {
        if (toView == 0) {
            x(viewId, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            x(viewId, toView, 4, 0, toView, 3, 0, 0.5f);
        }
    }

    public void C1(int viewId, float weight) {
        i0(viewId).f4769e.V = weight;
    }

    public void D(int centerID, int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        L(centerID, 3, topId, topSide, topMargin);
        L(centerID, 4, bottomId, bottomSide, bottomMargin);
        a aVar = this.f4764g.get(Integer.valueOf(centerID));
        if (aVar != null) {
            aVar.f4769e.f4867z = bias;
        }
    }

    public void D0(a set, String attributes) {
        String[] strArrSplit = attributes.split(",");
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            String[] strArrSplit2 = strArrSplit[i7].split("=");
            if (strArrSplit2.length != 2) {
                Log.w(f4701h, " Unable to parse " + strArrSplit[i7]);
            } else {
                set.q(strArrSplit2[0], Float.parseFloat(strArrSplit2[1]));
            }
        }
    }

    public void D1(int viewId, int visibility) {
        i0(viewId).f4767c.f4895b = visibility;
    }

    public void E(int viewId) {
        this.f4764g.remove(Integer.valueOf(viewId));
    }

    public void E0(a set, String attributes) {
        String[] strArrSplit = attributes.split(",");
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            String[] strArrSplit2 = strArrSplit[i7].split("=");
            if (strArrSplit2.length != 2) {
                Log.w(f4701h, " Unable to parse " + strArrSplit[i7]);
            } else {
                set.q(strArrSplit2[0], Integer.decode(strArrSplit2[1]).intValue());
            }
        }
    }

    public void E1(int viewId, int visibilityMode) {
        i0(viewId).f4767c.f4896c = visibilityMode;
    }

    public void F(int viewId, int anchor) {
        a aVar;
        if (!this.f4764g.containsKey(Integer.valueOf(viewId)) || (aVar = this.f4764g.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        switch (anchor) {
            case 1:
                b bVar = aVar.f4769e;
                bVar.f4845k = -1;
                bVar.f4843j = -1;
                bVar.H = -1;
                bVar.O = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = aVar.f4769e;
                bVar2.f4849m = -1;
                bVar2.f4847l = -1;
                bVar2.I = -1;
                bVar2.Q = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = aVar.f4769e;
                bVar3.f4853o = -1;
                bVar3.f4851n = -1;
                bVar3.f4824J = 0;
                bVar3.P = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = aVar.f4769e;
                bVar4.f4855p = -1;
                bVar4.f4857q = -1;
                bVar4.K = 0;
                bVar4.R = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = aVar.f4769e;
                bVar5.f4859r = -1;
                bVar5.f4860s = -1;
                bVar5.f4861t = -1;
                bVar5.N = 0;
                bVar5.U = Integer.MIN_VALUE;
                return;
            case 6:
                b bVar6 = aVar.f4769e;
                bVar6.f4862u = -1;
                bVar6.f4863v = -1;
                bVar6.M = 0;
                bVar6.T = Integer.MIN_VALUE;
                return;
            case 7:
                b bVar7 = aVar.f4769e;
                bVar7.f4864w = -1;
                bVar7.f4865x = -1;
                bVar7.L = 0;
                bVar7.S = Integer.MIN_VALUE;
                return;
            case 8:
                b bVar8 = aVar.f4769e;
                bVar8.D = -1.0f;
                bVar8.C = -1;
                bVar8.B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void F0(a set, String attributes) {
        String[] strArrG1 = G1(attributes);
        for (int i7 = 0; i7 < strArrG1.length; i7++) {
            String[] strArrSplit = strArrG1[i7].split("=");
            Log.w(f4701h, " Unable to parse " + strArrG1[i7]);
            set.s(strArrSplit[0], strArrSplit[1]);
        }
    }

    public void G(Context context, int constraintLayoutId) {
        H((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public void H(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f4764g.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f4763f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4764g.containsKey(Integer.valueOf(id))) {
                this.f4764g.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f4764g.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f4771g = androidx.constraintlayout.widget.a.d(this.f4762e, childAt);
                aVar.k(id, layoutParams);
                aVar.f4767c.f4895b = childAt.getVisibility();
                aVar.f4767c.f4897d = childAt.getAlpha();
                aVar.f4770f.f4912b = childAt.getRotation();
                aVar.f4770f.f4913c = childAt.getRotationX();
                aVar.f4770f.f4914d = childAt.getRotationY();
                aVar.f4770f.f4915e = childAt.getScaleX();
                aVar.f4770f.f4916f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f4770f;
                    eVar.f4917g = pivotX;
                    eVar.f4918h = pivotY;
                }
                aVar.f4770f.f4920j = childAt.getTranslationX();
                aVar.f4770f.f4921k = childAt.getTranslationY();
                aVar.f4770f.f4922l = childAt.getTranslationZ();
                e eVar2 = aVar.f4770f;
                if (eVar2.f4923m) {
                    eVar2.f4924n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f4769e.f4856p0 = barrier.getAllowsGoneWidget();
                    aVar.f4769e.f4846k0 = barrier.getReferencedIds();
                    aVar.f4769e.f4840h0 = barrier.getType();
                    aVar.f4769e.f4842i0 = barrier.getMargin();
                }
            }
        }
    }

    public void H1(Writer writer, ConstraintLayout layout, int flags) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((flags & 1) == 1) {
            new g(writer, layout, flags).i();
        } else {
            new f(writer, layout, flags).g();
        }
        writer.write("\n---------------------------------------------\n");
    }

    public void I(d set) {
        this.f4764g.clear();
        for (Integer num : set.f4764g.keySet()) {
            a aVar = set.f4764g.get(num);
            if (aVar != null) {
                this.f4764g.put(num, aVar.clone());
            }
        }
    }

    public void I0(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f4763f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4764g.containsKey(Integer.valueOf(id))) {
                this.f4764g.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f4764g.get(Integer.valueOf(id));
            if (aVar != null) {
                if (!aVar.f4769e.f4827b) {
                    aVar.k(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f4769e.f4846k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f4769e.f4856p0 = barrier.getAllowsGoneWidget();
                            aVar.f4769e.f4840h0 = barrier.getType();
                            aVar.f4769e.f4842i0 = barrier.getMargin();
                        }
                    }
                    aVar.f4769e.f4827b = true;
                }
                C0049d c0049d = aVar.f4767c;
                if (!c0049d.f4894a) {
                    c0049d.f4895b = childAt.getVisibility();
                    aVar.f4767c.f4897d = childAt.getAlpha();
                    aVar.f4767c.f4894a = true;
                }
                e eVar = aVar.f4770f;
                if (!eVar.f4911a) {
                    eVar.f4911a = true;
                    eVar.f4912b = childAt.getRotation();
                    aVar.f4770f.f4913c = childAt.getRotationX();
                    aVar.f4770f.f4914d = childAt.getRotationY();
                    aVar.f4770f.f4915e = childAt.getScaleX();
                    aVar.f4770f.f4916f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f4770f;
                        eVar2.f4917g = pivotX;
                        eVar2.f4918h = pivotY;
                    }
                    aVar.f4770f.f4920j = childAt.getTranslationX();
                    aVar.f4770f.f4921k = childAt.getTranslationY();
                    aVar.f4770f.f4922l = childAt.getTranslationZ();
                    e eVar3 = aVar.f4770f;
                    if (eVar3.f4923m) {
                        eVar3.f4924n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void J(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f4764g.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraints.getChildAt(i7);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f4763f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4764g.containsKey(Integer.valueOf(id))) {
                this.f4764g.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f4764g.get(Integer.valueOf(id));
            if (aVar != null) {
                if (childAt instanceof ConstraintHelper) {
                    aVar.m((ConstraintHelper) childAt, id, layoutParams);
                }
                aVar.l(id, layoutParams);
            }
        }
    }

    public void J0(d set) {
        for (Integer num : set.f4764g.keySet()) {
            int iIntValue = num.intValue();
            a aVar = set.f4764g.get(num);
            if (!this.f4764g.containsKey(Integer.valueOf(iIntValue))) {
                this.f4764g.put(Integer.valueOf(iIntValue), new a());
            }
            a aVar2 = this.f4764g.get(Integer.valueOf(iIntValue));
            if (aVar2 != null) {
                b bVar = aVar2.f4769e;
                if (!bVar.f4827b) {
                    bVar.a(aVar.f4769e);
                }
                C0049d c0049d = aVar2.f4767c;
                if (!c0049d.f4894a) {
                    c0049d.a(aVar.f4767c);
                }
                e eVar = aVar2.f4770f;
                if (!eVar.f4911a) {
                    eVar.a(aVar.f4770f);
                }
                c cVar = aVar2.f4768d;
                if (!cVar.f4880a) {
                    cVar.a(aVar.f4768d);
                }
                for (String str : aVar.f4771g.keySet()) {
                    if (!aVar2.f4771g.containsKey(str)) {
                        aVar2.f4771g.put(str, aVar.f4771g.get(str));
                    }
                }
            }
        }
    }

    public void K(int startID, int startSide, int endID, int endSide) {
        if (!this.f4764g.containsKey(Integer.valueOf(startID))) {
            this.f4764g.put(Integer.valueOf(startID), new a());
        }
        a aVar = this.f4764g.get(Integer.valueOf(startID));
        if (aVar == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    b bVar = aVar.f4769e;
                    bVar.f4843j = endID;
                    bVar.f4845k = -1;
                    return;
                } else if (endSide == 2) {
                    b bVar2 = aVar.f4769e;
                    bVar2.f4845k = endID;
                    bVar2.f4843j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + F1(endSide) + " undefined");
                }
            case 2:
                if (endSide == 1) {
                    b bVar3 = aVar.f4769e;
                    bVar3.f4847l = endID;
                    bVar3.f4849m = -1;
                    return;
                } else if (endSide == 2) {
                    b bVar4 = aVar.f4769e;
                    bVar4.f4849m = endID;
                    bVar4.f4847l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
            case 3:
                if (endSide == 3) {
                    b bVar5 = aVar.f4769e;
                    bVar5.f4851n = endID;
                    bVar5.f4853o = -1;
                    bVar5.f4859r = -1;
                    bVar5.f4860s = -1;
                    bVar5.f4861t = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar6 = aVar.f4769e;
                bVar6.f4853o = endID;
                bVar6.f4851n = -1;
                bVar6.f4859r = -1;
                bVar6.f4860s = -1;
                bVar6.f4861t = -1;
                return;
            case 4:
                if (endSide == 4) {
                    b bVar7 = aVar.f4769e;
                    bVar7.f4857q = endID;
                    bVar7.f4855p = -1;
                    bVar7.f4859r = -1;
                    bVar7.f4860s = -1;
                    bVar7.f4861t = -1;
                    return;
                }
                if (endSide != 3) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar8 = aVar.f4769e;
                bVar8.f4855p = endID;
                bVar8.f4857q = -1;
                bVar8.f4859r = -1;
                bVar8.f4860s = -1;
                bVar8.f4861t = -1;
                return;
            case 5:
                if (endSide == 5) {
                    b bVar9 = aVar.f4769e;
                    bVar9.f4859r = endID;
                    bVar9.f4857q = -1;
                    bVar9.f4855p = -1;
                    bVar9.f4851n = -1;
                    bVar9.f4853o = -1;
                    return;
                }
                if (endSide == 3) {
                    b bVar10 = aVar.f4769e;
                    bVar10.f4860s = endID;
                    bVar10.f4857q = -1;
                    bVar10.f4855p = -1;
                    bVar10.f4851n = -1;
                    bVar10.f4853o = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar11 = aVar.f4769e;
                bVar11.f4861t = endID;
                bVar11.f4857q = -1;
                bVar11.f4855p = -1;
                bVar11.f4851n = -1;
                bVar11.f4853o = -1;
                return;
            case 6:
                if (endSide == 6) {
                    b bVar12 = aVar.f4769e;
                    bVar12.f4863v = endID;
                    bVar12.f4862u = -1;
                    return;
                } else if (endSide == 7) {
                    b bVar13 = aVar.f4769e;
                    bVar13.f4862u = endID;
                    bVar13.f4863v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
            case 7:
                if (endSide == 7) {
                    b bVar14 = aVar.f4769e;
                    bVar14.f4865x = endID;
                    bVar14.f4864w = -1;
                    return;
                } else if (endSide == 6) {
                    b bVar15 = aVar.f4769e;
                    bVar15.f4864w = endID;
                    bVar15.f4865x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
            default:
                throw new IllegalArgumentException(F1(startSide) + " to " + F1(endSide) + " unknown");
        }
    }

    public void K0(String attributeName) {
        this.f4762e.remove(attributeName);
    }

    public void L(int startID, int startSide, int endID, int endSide, int margin) {
        if (!this.f4764g.containsKey(Integer.valueOf(startID))) {
            this.f4764g.put(Integer.valueOf(startID), new a());
        }
        a aVar = this.f4764g.get(Integer.valueOf(startID));
        if (aVar == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    b bVar = aVar.f4769e;
                    bVar.f4843j = endID;
                    bVar.f4845k = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("Left to " + F1(endSide) + " undefined");
                    }
                    b bVar2 = aVar.f4769e;
                    bVar2.f4845k = endID;
                    bVar2.f4843j = -1;
                }
                aVar.f4769e.H = margin;
                return;
            case 2:
                if (endSide == 1) {
                    b bVar3 = aVar.f4769e;
                    bVar3.f4847l = endID;
                    bVar3.f4849m = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar4 = aVar.f4769e;
                    bVar4.f4849m = endID;
                    bVar4.f4847l = -1;
                }
                aVar.f4769e.I = margin;
                return;
            case 3:
                if (endSide == 3) {
                    b bVar5 = aVar.f4769e;
                    bVar5.f4851n = endID;
                    bVar5.f4853o = -1;
                    bVar5.f4859r = -1;
                    bVar5.f4860s = -1;
                    bVar5.f4861t = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar6 = aVar.f4769e;
                    bVar6.f4853o = endID;
                    bVar6.f4851n = -1;
                    bVar6.f4859r = -1;
                    bVar6.f4860s = -1;
                    bVar6.f4861t = -1;
                }
                aVar.f4769e.f4824J = margin;
                return;
            case 4:
                if (endSide == 4) {
                    b bVar7 = aVar.f4769e;
                    bVar7.f4857q = endID;
                    bVar7.f4855p = -1;
                    bVar7.f4859r = -1;
                    bVar7.f4860s = -1;
                    bVar7.f4861t = -1;
                } else {
                    if (endSide != 3) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar8 = aVar.f4769e;
                    bVar8.f4855p = endID;
                    bVar8.f4857q = -1;
                    bVar8.f4859r = -1;
                    bVar8.f4860s = -1;
                    bVar8.f4861t = -1;
                }
                aVar.f4769e.K = margin;
                return;
            case 5:
                if (endSide == 5) {
                    b bVar9 = aVar.f4769e;
                    bVar9.f4859r = endID;
                    bVar9.f4857q = -1;
                    bVar9.f4855p = -1;
                    bVar9.f4851n = -1;
                    bVar9.f4853o = -1;
                    return;
                }
                if (endSide == 3) {
                    b bVar10 = aVar.f4769e;
                    bVar10.f4860s = endID;
                    bVar10.f4857q = -1;
                    bVar10.f4855p = -1;
                    bVar10.f4851n = -1;
                    bVar10.f4853o = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar11 = aVar.f4769e;
                bVar11.f4861t = endID;
                bVar11.f4857q = -1;
                bVar11.f4855p = -1;
                bVar11.f4851n = -1;
                bVar11.f4853o = -1;
                return;
            case 6:
                if (endSide == 6) {
                    b bVar12 = aVar.f4769e;
                    bVar12.f4863v = endID;
                    bVar12.f4862u = -1;
                } else {
                    if (endSide != 7) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar13 = aVar.f4769e;
                    bVar13.f4862u = endID;
                    bVar13.f4863v = -1;
                }
                aVar.f4769e.M = margin;
                return;
            case 7:
                if (endSide == 7) {
                    b bVar14 = aVar.f4769e;
                    bVar14.f4865x = endID;
                    bVar14.f4864w = -1;
                } else {
                    if (endSide != 6) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar15 = aVar.f4769e;
                    bVar15.f4864w = endID;
                    bVar15.f4865x = -1;
                }
                aVar.f4769e.L = margin;
                return;
            default:
                throw new IllegalArgumentException(F1(startSide) + " to " + F1(endSide) + " unknown");
        }
    }

    public void L0(int viewId) {
        a aVar;
        if (!this.f4764g.containsKey(Integer.valueOf(viewId)) || (aVar = this.f4764g.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        b bVar = aVar.f4769e;
        int i7 = bVar.f4845k;
        int i8 = bVar.f4847l;
        if (i7 != -1 || i8 != -1) {
            if (i7 == -1 || i8 == -1) {
                int i9 = bVar.f4849m;
                if (i9 != -1) {
                    L(i7, 2, i9, 2, 0);
                } else {
                    int i10 = bVar.f4843j;
                    if (i10 != -1) {
                        L(i8, 1, i10, 1, 0);
                    }
                }
            } else {
                L(i7, 2, i8, 1, 0);
                L(i8, 1, i7, 2, 0);
            }
            F(viewId, 1);
            F(viewId, 2);
            return;
        }
        int i11 = bVar.f4862u;
        int i12 = bVar.f4864w;
        if (i11 != -1 || i12 != -1) {
            if (i11 != -1 && i12 != -1) {
                L(i11, 7, i12, 6, 0);
                L(i12, 6, i7, 7, 0);
            } else if (i12 != -1) {
                int i13 = bVar.f4849m;
                if (i13 != -1) {
                    L(i7, 7, i13, 7, 0);
                } else {
                    int i14 = bVar.f4843j;
                    if (i14 != -1) {
                        L(i12, 6, i14, 6, 0);
                    }
                }
            }
        }
        F(viewId, 6);
        F(viewId, 7);
    }

    public void M(int viewId, int id, int radius, float angle) {
        b bVar = i0(viewId).f4769e;
        bVar.B = id;
        bVar.C = radius;
        bVar.D = angle;
    }

    public void M0(int viewId) {
        if (this.f4764g.containsKey(Integer.valueOf(viewId))) {
            a aVar = this.f4764g.get(Integer.valueOf(viewId));
            if (aVar == null) {
                return;
            }
            b bVar = aVar.f4769e;
            int i7 = bVar.f4853o;
            int i8 = bVar.f4855p;
            if (i7 != -1 || i8 != -1) {
                if (i7 == -1 || i8 == -1) {
                    int i9 = bVar.f4857q;
                    if (i9 != -1) {
                        L(i7, 4, i9, 4, 0);
                    } else {
                        int i10 = bVar.f4851n;
                        if (i10 != -1) {
                            L(i8, 3, i10, 3, 0);
                        }
                    }
                } else {
                    L(i7, 4, i8, 3, 0);
                    L(i8, 3, i7, 4, 0);
                }
            }
        }
        F(viewId, 3);
        F(viewId, 4);
    }

    public void N(int viewId, int height) {
        i0(viewId).f4769e.f4826a0 = height;
    }

    public void N0(int viewId, float alpha) {
        i0(viewId).f4767c.f4897d = alpha;
    }

    public void O(int viewId, int width) {
        i0(viewId).f4769e.Z = width;
    }

    public void O0(int viewId, boolean apply) {
        i0(viewId).f4770f.f4923m = apply;
    }

    public void P(int viewId, int height) {
        i0(viewId).f4769e.f4833e = height;
    }

    public void P0(int id, int type) {
        i0(id).f4769e.f4844j0 = type;
    }

    public void Q(int viewId, int height) {
        i0(viewId).f4769e.f4830c0 = height;
    }

    public void Q0(int viewId, String attributeName, int value) {
        i0(viewId).p(attributeName, value);
    }

    public void R(int viewId, int width) {
        i0(viewId).f4769e.f4828b0 = width;
    }

    public void S(int viewId, int height) {
        i0(viewId).f4769e.f4834e0 = height;
    }

    public void T(int viewId, int width) {
        i0(viewId).f4769e.f4832d0 = width;
    }

    public void U(int viewId, float percent) {
        i0(viewId).f4769e.f4838g0 = percent;
    }

    public void V(int viewId, float percent) {
        i0(viewId).f4769e.f4836f0 = percent;
    }

    public void V0(int viewId, String ratio) {
        i0(viewId).f4769e.A = ratio;
    }

    public void W(int viewId, int width) {
        i0(viewId).f4769e.f4831d = width;
    }

    public void W0(int viewId, int position) {
        i0(viewId).f4769e.E = position;
    }

    public void X(int viewId, boolean constrained) {
        i0(viewId).f4769e.f4854o0 = constrained;
    }

    public void X0(int viewId, int position) {
        i0(viewId).f4769e.F = position;
    }

    public void Y(int viewId, boolean constrained) {
        i0(viewId).f4769e.f4852n0 = constrained;
    }

    public void Y0(int viewId, float elevation) {
        i0(viewId).f4770f.f4924n = elevation;
        i0(viewId).f4770f.f4923m = true;
    }

    public void Z0(int viewId, String attributeName, float value) {
        i0(viewId).q(attributeName, value);
    }

    public void a0(int guidelineID, int orientation) {
        b bVar = i0(guidelineID).f4769e;
        bVar.f4825a = true;
        bVar.G = orientation;
    }

    public void a1(boolean forceId) {
        this.f4763f = forceId;
    }

    public void b0(int id, int direction, int margin, int... referenced) {
        b bVar = i0(id).f4769e;
        bVar.f4844j0 = 1;
        bVar.f4840h0 = direction;
        bVar.f4842i0 = margin;
        bVar.f4825a = false;
        bVar.f4846k0 = referenced;
    }

    public void b1(int viewId, int anchor, int value) {
        a aVarI0 = i0(viewId);
        switch (anchor) {
            case 1:
                aVarI0.f4769e.O = value;
                return;
            case 2:
                aVarI0.f4769e.Q = value;
                return;
            case 3:
                aVarI0.f4769e.P = value;
                return;
            case 4:
                aVarI0.f4769e.R = value;
                return;
            case 5:
                aVarI0.f4769e.U = value;
                return;
            case 6:
                aVarI0.f4769e.T = value;
                return;
            case 7:
                aVarI0.f4769e.S = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void c0(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style) {
        d0(leftId, leftSide, rightId, rightSide, chainIds, weights, style, 1, 2);
    }

    public void c1(int guidelineID, int margin) {
        i0(guidelineID).f4769e.f4835f = margin;
        i0(guidelineID).f4769e.f4837g = -1;
        i0(guidelineID).f4769e.f4839h = -1.0f;
    }

    public void d1(int guidelineID, int margin) {
        i0(guidelineID).f4769e.f4837g = margin;
        i0(guidelineID).f4769e.f4835f = -1;
        i0(guidelineID).f4769e.f4839h = -1.0f;
    }

    public void e0(int startId, int startSide, int endId, int endSide, int[] chainIds, float[] weights, int style) {
        d0(startId, startSide, endId, endSide, chainIds, weights, style, 6, 7);
    }

    public void e1(int guidelineID, float ratio) {
        i0(guidelineID).f4769e.f4839h = ratio;
        i0(guidelineID).f4769e.f4837g = -1;
        i0(guidelineID).f4769e.f4835f = -1;
    }

    public void f0(int topId, int topSide, int bottomId, int bottomSide, int[] chainIds, float[] weights, int style) {
        if (chainIds.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null && weights.length != chainIds.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null) {
            i0(chainIds[0]).f4769e.V = weights[0];
        }
        i0(chainIds[0]).f4769e.Y = style;
        L(chainIds[0], 3, topId, topSide, 0);
        for (int i7 = 1; i7 < chainIds.length; i7++) {
            int i8 = i7 - 1;
            L(chainIds[i7], 3, chainIds[i8], 4, 0);
            L(chainIds[i8], 4, chainIds[i7], 3, 0);
            if (weights != null) {
                i0(chainIds[i7]).f4769e.V = weights[i7];
            }
        }
        L(chainIds[chainIds.length - 1], 4, bottomId, bottomSide, 0);
    }

    public void f1(int viewId, float bias) {
        i0(viewId).f4769e.f4866y = bias;
    }

    public void g0(s scene, int... ids) {
        HashSet hashSet;
        Set<Integer> setKeySet = this.f4764g.keySet();
        if (ids.length != 0) {
            hashSet = new HashSet();
            for (int i7 : ids) {
                hashSet.add(Integer.valueOf(i7));
            }
        } else {
            hashSet = new HashSet(setKeySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            a aVar = this.f4764g.get(num);
            if (aVar != null) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                aVar.f4769e.b(scene, sb);
                sb.append("/>\n");
            }
        }
        System.out.println(sb.toString());
    }

    public void g1(int viewId, int chainStyle) {
        i0(viewId).f4769e.X = chainStyle;
    }

    public void h1(int viewId, float weight) {
        i0(viewId).f4769e.W = weight;
    }

    public void i(String... attributeName) {
        h(androidx.constraintlayout.widget.a.b.COLOR_TYPE, attributeName);
    }

    public void i1(int viewId, String attributeName, int value) {
        i0(viewId).r(attributeName, value);
    }

    public void j(String... attributeName) {
        h(androidx.constraintlayout.widget.a.b.FLOAT_TYPE, attributeName);
    }

    public boolean j0(int viewId) {
        return i0(viewId).f4770f.f4923m;
    }

    public void j1(int viewId, int behavior) {
        if (behavior < 0 || behavior > 3) {
            return;
        }
        i0(viewId).f4769e.f4858q0 = behavior;
    }

    public void k(String... attributeName) {
        h(androidx.constraintlayout.widget.a.b.INT_TYPE, attributeName);
    }

    public a k0(int id) {
        if (this.f4764g.containsKey(Integer.valueOf(id))) {
            return this.f4764g.get(Integer.valueOf(id));
        }
        return null;
    }

    public void k1(int viewId, int anchor, int value) {
        a aVarI0 = i0(viewId);
        switch (anchor) {
            case 1:
                aVarI0.f4769e.H = value;
                return;
            case 2:
                aVarI0.f4769e.I = value;
                return;
            case 3:
                aVarI0.f4769e.f4824J = value;
                return;
            case 4:
                aVarI0.f4769e.K = value;
                return;
            case 5:
                aVarI0.f4769e.N = value;
                return;
            case 6:
                aVarI0.f4769e.M = value;
                return;
            case 7:
                aVarI0.f4769e.L = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void l(String... attributeName) {
        h(androidx.constraintlayout.widget.a.b.STRING_TYPE, attributeName);
    }

    public HashMap<String, androidx.constraintlayout.widget.a> l0() {
        return this.f4762e;
    }

    public void l1(int id, int... referenced) {
        i0(id).f4769e.f4846k0 = referenced;
    }

    public void m(int viewId, int leftId, int rightId) {
        L(viewId, 1, leftId, leftId == 0 ? 1 : 2, 0);
        L(viewId, 2, rightId, rightId == 0 ? 2 : 1, 0);
        if (leftId != 0) {
            L(leftId, 2, viewId, 1, 0);
        }
        if (rightId != 0) {
            L(rightId, 1, viewId, 2, 0);
        }
    }

    public void m1(int viewId, float rotation) {
        i0(viewId).f4770f.f4912b = rotation;
    }

    public void n(int viewId, int leftId, int rightId) {
        L(viewId, 6, leftId, leftId == 0 ? 6 : 7, 0);
        L(viewId, 7, rightId, rightId == 0 ? 7 : 6, 0);
        if (leftId != 0) {
            L(leftId, 7, viewId, 6, 0);
        }
        if (rightId != 0) {
            L(rightId, 6, viewId, 7, 0);
        }
    }

    public int n0(int viewId) {
        return i0(viewId).f4769e.f4833e;
    }

    public void n1(int viewId, float rotationX) {
        i0(viewId).f4770f.f4913c = rotationX;
    }

    public void o(int viewId, int topId, int bottomId) {
        L(viewId, 3, topId, topId == 0 ? 3 : 4, 0);
        L(viewId, 4, bottomId, bottomId == 0 ? 4 : 3, 0);
        if (topId != 0) {
            L(topId, 4, viewId, 3, 0);
        }
        if (bottomId != 0) {
            L(bottomId, 3, viewId, 4, 0);
        }
    }

    public int[] o0() {
        Integer[] numArr = (Integer[]) this.f4764g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = numArr[i7].intValue();
        }
        return iArr;
    }

    public void o1(int viewId, float rotationY) {
        i0(viewId).f4770f.f4914d = rotationY;
    }

    public void p(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            int id = childAt.getId();
            if (!this.f4764g.containsKey(Integer.valueOf(id))) {
                Log.w(f4701h, "id unknown " + androidx.constraintlayout.motion.widget.c.k(childAt));
            } else {
                if (this.f4763f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f4764g.containsKey(Integer.valueOf(id)) && (aVar = this.f4764g.get(Integer.valueOf(id))) != null) {
                    androidx.constraintlayout.widget.a.r(childAt, aVar.f4771g);
                }
            }
        }
    }

    public void p1(int viewId, float scaleX) {
        i0(viewId).f4770f.f4915e = scaleX;
    }

    public void q(d cs) {
        for (a aVar : cs.f4764g.values()) {
            if (aVar.f4772h != null) {
                if (aVar.f4766b != null) {
                    Iterator<Integer> it = this.f4764g.keySet().iterator();
                    while (it.hasNext()) {
                        a aVarK0 = k0(it.next().intValue());
                        String str = aVarK0.f4769e.f4850m0;
                        if (str != null && aVar.f4766b.matches(str)) {
                            aVar.f4772h.e(aVarK0);
                            aVarK0.f4771g.putAll((HashMap) aVar.f4771g.clone());
                        }
                    }
                } else {
                    aVar.f4772h.e(k0(aVar.f4765a));
                }
            }
        }
    }

    public a q0(int mId) {
        return i0(mId);
    }

    public void q1(int viewId, float scaleY) {
        i0(viewId).f4770f.f4916f = scaleY;
    }

    public void r(ConstraintLayout constraintLayout) {
        t(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public int[] r0(int id) {
        int[] iArr = i0(id).f4769e.f4846k0;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public void r1(int viewId, String attributeName, String value) {
        i0(viewId).s(attributeName, value);
    }

    public void s(ConstraintHelper helper, androidx.constraintlayout.core.widgets.e child, ConstraintLayout.LayoutParams layoutParams, SparseArray<androidx.constraintlayout.core.widgets.e> mapIdToWidget) {
        a aVar;
        int id = helper.getId();
        if (this.f4764g.containsKey(Integer.valueOf(id)) && (aVar = this.f4764g.get(Integer.valueOf(id))) != null && (child instanceof j)) {
            helper.z(aVar, (j) child, layoutParams, mapIdToWidget);
        }
    }

    public int s0(int viewId) {
        return i0(viewId).f4767c.f4895b;
    }

    public void s1(int viewId, float transformPivotX, float transformPivotY) {
        e eVar = i0(viewId).f4770f;
        eVar.f4918h = transformPivotY;
        eVar.f4917g = transformPivotX;
    }

    void t(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f4764g.keySet());
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            int id = childAt.getId();
            if (!this.f4764g.containsKey(Integer.valueOf(id))) {
                Log.w(f4701h, "id unknown " + androidx.constraintlayout.motion.widget.c.k(childAt));
            } else {
                if (this.f4763f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f4764g.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f4764g.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f4769e.f4844j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(aVar.f4769e.f4840h0);
                                barrier.setMargin(aVar.f4769e.f4842i0);
                                barrier.setAllowsGoneWidget(aVar.f4769e.f4856p0);
                                b bVar = aVar.f4769e;
                                int[] iArr = bVar.f4846k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f4848l0;
                                    if (str != null) {
                                        bVar.f4846k0 = Z(barrier, str);
                                        barrier.setReferencedIds(aVar.f4769e.f4846k0);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.e();
                            aVar.i(layoutParams);
                            if (applyPostLayout) {
                                androidx.constraintlayout.widget.a.r(childAt, aVar.f4771g);
                            }
                            childAt.setLayoutParams(layoutParams);
                            C0049d c0049d = aVar.f4767c;
                            if (c0049d.f4896c == 0) {
                                childAt.setVisibility(c0049d.f4895b);
                            }
                            childAt.setAlpha(aVar.f4767c.f4897d);
                            childAt.setRotation(aVar.f4770f.f4912b);
                            childAt.setRotationX(aVar.f4770f.f4913c);
                            childAt.setRotationY(aVar.f4770f.f4914d);
                            childAt.setScaleX(aVar.f4770f.f4915e);
                            childAt.setScaleY(aVar.f4770f.f4916f);
                            e eVar = aVar.f4770f;
                            if (eVar.f4919i != -1) {
                                View viewFindViewById = ((View) childAt.getParent()).findViewById(aVar.f4770f.f4919i);
                                if (viewFindViewById != null) {
                                    float top = (viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2.0f;
                                    float left = (viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        float left2 = left - childAt.getLeft();
                                        float top2 = top - childAt.getTop();
                                        childAt.setPivotX(left2);
                                        childAt.setPivotY(top2);
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f4917g)) {
                                    childAt.setPivotX(aVar.f4770f.f4917g);
                                }
                                if (!Float.isNaN(aVar.f4770f.f4918h)) {
                                    childAt.setPivotY(aVar.f4770f.f4918h);
                                }
                            }
                            childAt.setTranslationX(aVar.f4770f.f4920j);
                            childAt.setTranslationY(aVar.f4770f.f4921k);
                            childAt.setTranslationZ(aVar.f4770f.f4922l);
                            e eVar2 = aVar.f4770f;
                            if (eVar2.f4923m) {
                                childAt.setElevation(eVar2.f4924n);
                            }
                        }
                    } else {
                        Log.v(f4701h, "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = this.f4764g.get(num);
            if (aVar2 != null) {
                if (aVar2.f4769e.f4844j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar2 = aVar2.f4769e;
                    int[] iArr2 = bVar2.f4846k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.f4848l0;
                        if (str2 != null) {
                            bVar2.f4846k0 = Z(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f4769e.f4846k0);
                        }
                    }
                    barrier2.setType(aVar2.f4769e.f4840h0);
                    barrier2.setMargin(aVar2.f4769e.f4842i0);
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.I();
                    aVar2.i(layoutParamsGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
                }
                if (aVar2.f4769e.f4825a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.i(layoutParamsGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = constraintLayout.getChildAt(i8);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).r(constraintLayout);
            }
        }
    }

    public int t0(int viewId) {
        return i0(viewId).f4767c.f4896c;
    }

    public void t1(int viewId, float transformPivotX) {
        i0(viewId).f4770f.f4917g = transformPivotX;
    }

    public void u(int id, ConstraintLayout.LayoutParams layoutParams) {
        a aVar;
        if (!this.f4764g.containsKey(Integer.valueOf(id)) || (aVar = this.f4764g.get(Integer.valueOf(id))) == null) {
            return;
        }
        aVar.i(layoutParams);
    }

    public int u0(int viewId) {
        return i0(viewId).f4769e.f4831d;
    }

    public void u1(int viewId, float transformPivotY) {
        i0(viewId).f4770f.f4918h = transformPivotY;
    }

    public void v(ConstraintLayout constraintLayout) {
        t(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public boolean v0() {
        return this.f4763f;
    }

    public void v1(int viewId, float translationX, float translationY) {
        e eVar = i0(viewId).f4770f;
        eVar.f4920j = translationX;
        eVar.f4921k = translationY;
    }

    public void w0(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarH0 = h0(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarH0.f4769e.f4825a = true;
                    }
                    this.f4764g.put(Integer.valueOf(aVarH0.f4765a), aVarH0);
                }
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    public void w1(int viewId, float translationX) {
        i0(viewId).f4770f.f4920j = translationX;
    }

    public void x(int centerID, int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (secondMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (bias <= 0.0f || bias > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (firstSide == 1 || firstSide == 2) {
            L(centerID, 1, firstID, firstSide, firstMargin);
            L(centerID, 2, secondId, secondSide, secondMargin);
            a aVar = this.f4764g.get(Integer.valueOf(centerID));
            if (aVar != null) {
                aVar.f4769e.f4866y = bias;
                return;
            }
            return;
        }
        if (firstSide == 6 || firstSide == 7) {
            L(centerID, 6, firstID, firstSide, firstMargin);
            L(centerID, 7, secondId, secondSide, secondMargin);
            a aVar2 = this.f4764g.get(Integer.valueOf(centerID));
            if (aVar2 != null) {
                aVar2.f4769e.f4866y = bias;
                return;
            }
            return;
        }
        L(centerID, 3, firstID, firstSide, firstMargin);
        L(centerID, 4, secondId, secondSide, secondMargin);
        a aVar3 = this.f4764g.get(Integer.valueOf(centerID));
        if (aVar3 != null) {
            aVar3.f4769e.f4867z = bias;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void x0(Context context, XmlPullParser parser) {
        a aVarH0;
        try {
            int eventType = parser.getEventType();
            a aVar = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    parser.getName();
                } else if (eventType == 2) {
                    switch (parser.getName()) {
                        case "Constraint":
                            aVarH0 = h0(context, Xml.asAttributeSet(parser), false);
                            break;
                        case "ConstraintOverride":
                            aVarH0 = h0(context, Xml.asAttributeSet(parser), true);
                            break;
                        case "Guideline":
                            aVarH0 = h0(context, Xml.asAttributeSet(parser), false);
                            b bVar = aVarH0.f4769e;
                            bVar.f4825a = true;
                            bVar.f4827b = true;
                            break;
                        case "Barrier":
                            aVarH0 = h0(context, Xml.asAttributeSet(parser), false);
                            aVarH0.f4769e.f4844j0 = 1;
                            break;
                        case "PropertySet":
                            if (aVar == null) {
                                throw new RuntimeException(f4704i + parser.getLineNumber());
                            }
                            aVar.f4767c.b(context, Xml.asAttributeSet(parser));
                            continue;
                            break;
                            break;
                        case "Transform":
                            if (aVar == null) {
                                throw new RuntimeException(f4704i + parser.getLineNumber());
                            }
                            aVar.f4770f.b(context, Xml.asAttributeSet(parser));
                            continue;
                            break;
                            break;
                        case "Layout":
                            if (aVar == null) {
                                throw new RuntimeException(f4704i + parser.getLineNumber());
                            }
                            aVar.f4769e.c(context, Xml.asAttributeSet(parser));
                            continue;
                            break;
                            break;
                        case "Motion":
                            if (aVar == null) {
                                throw new RuntimeException(f4704i + parser.getLineNumber());
                            }
                            aVar.f4768d.b(context, Xml.asAttributeSet(parser));
                            continue;
                            break;
                            break;
                        case "CustomAttribute":
                        case "CustomMethod":
                            if (aVar == null) {
                                throw new RuntimeException(f4704i + parser.getLineNumber());
                            }
                            androidx.constraintlayout.widget.a.q(context, parser, aVar.f4771g);
                            continue;
                            break;
                            break;
                        default:
                            continue;
                            break;
                    }
                    aVar = aVarH0;
                } else if (eventType == 3) {
                    String lowerCase = parser.getName().toLowerCase(Locale.ROOT);
                    switch (lowerCase.hashCode()) {
                        case -2075718416:
                            if (lowerCase.equals("guideline")) {
                            }
                            break;
                        case -190376483:
                            if (lowerCase.equals("constraint")) {
                            }
                            break;
                        case 426575017:
                            if (lowerCase.equals("constraintoverride")) {
                            }
                            break;
                        case 2146106725:
                            if (lowerCase.equals("constraintset")) {
                            }
                            break;
                    }
                    if (r4 == 0) {
                        return;
                    }
                    if (r4 == 1 || r4 == 2 || r4 == 3) {
                        this.f4764g.put(Integer.valueOf(aVar.f4765a), aVar);
                        aVar = null;
                    }
                }
                eventType = parser.next();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    public void x1(int viewId, float translationY) {
        i0(viewId).f4770f.f4921k = translationY;
    }

    public void y(int viewId, int toView) {
        if (toView == 0) {
            x(viewId, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            x(viewId, toView, 2, 0, toView, 1, 0, 0.5f);
        }
    }

    public void y1(int viewId, float translationZ) {
        i0(viewId).f4770f.f4922l = translationZ;
    }

    public void z(int centerID, int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        L(centerID, 1, leftId, leftSide, leftMargin);
        L(centerID, 2, rightId, rightSide, rightMargin);
        a aVar = this.f4764g.get(Integer.valueOf(centerID));
        if (aVar != null) {
            aVar.f4769e.f4866y = bias;
        }
    }

    public void z0(a set, String attributes) {
        String[] strArrSplit = attributes.split(",");
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            String[] strArrSplit2 = strArrSplit[i7].split("=");
            if (strArrSplit2.length != 2) {
                Log.w(f4701h, " Unable to parse " + strArrSplit[i7]);
            } else {
                set.p(strArrSplit2[0], Color.parseColor(strArrSplit2[1]));
            }
        }
    }

    public void z1(boolean validate) {
        this.f4758a = validate;
    }
}
