package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private static final int A = -1;
    private static final int B = -2;
    public static final int C = -1;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    private static final String G = "MotionScene";
    private static final String H = "Transition";
    private static final String I = "OnSwipe";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String f4206J = "OnClick";
    private static final String K = "StateSet";
    private static final String L = "Include";
    private static final String M = "include";
    private static final String N = "KeyFrameSet";
    private static final String O = "ConstraintSet";
    private static final String P = "ViewTransition";
    static final int Q = 0;
    static final int R = 1;
    static final int S = 2;
    static final int T = 3;
    static final int U = 4;
    static final int V = 5;
    static final int W = 6;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f4207v = "MotionScene";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final boolean f4208w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f4209x = 8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f4210y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f4211z = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionLayout f4212a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MotionEvent f4225n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MotionLayout.i f4228q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f4229r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final a0 f4230s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f4231t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f4232u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    androidx.constraintlayout.widget.g f4213b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b f4214c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4215d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<b> f4216e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f4217f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<b> f4218g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SparseArray<androidx.constraintlayout.widget.d> f4219h = new SparseArray<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap<String, Integer> f4220i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SparseIntArray f4221j = new SparseIntArray();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4222k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4223l = 400;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4224m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4226o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4227p = false;

    class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.d f4233a;

        a(final s this$0, final androidx.constraintlayout.core.motion.utils.d val$easing) {
            this.f4233a = val$easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float v7) {
            return (float) this.f4233a.a(v7);
        }
    }

    public s(MotionLayout layout) {
        this.f4212a = layout;
        this.f4230s = new a0(layout);
    }

    static String A(Context context, int resourceId, XmlPullParser pullParser) {
        return ".(" + c.i(context, resourceId) + ".xml:" + pullParser.getLineNumber() + ") \"" + pullParser.getName() + "\"";
    }

    private int G(int stateId) {
        int iE;
        androidx.constraintlayout.widget.g gVar = this.f4213b;
        return (gVar == null || (iE = gVar.e(stateId, -1, -1)) == -1) ? stateId : iE;
    }

    private boolean R(int key) {
        int i7 = this.f4221j.get(key);
        int size = this.f4221j.size();
        while (i7 > 0) {
            if (i7 == key) {
                return true;
            }
            int i8 = size - 1;
            if (size < 0) {
                return true;
            }
            i7 = this.f4221j.get(i7);
            size = i8;
        }
        return false;
    }

    private boolean T() {
        return this.f4228q != null;
    }

    private void V(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            int eventType = xml.getEventType();
            b bVar = null;
            while (true) {
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.f4222k) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name) {
                        case "MotionScene":
                            c0(context, xml);
                            break;
                        case "Transition":
                            ArrayList<b> arrayList = this.f4216e;
                            bVar = new b(this, context, xml);
                            arrayList.add(bVar);
                            if (this.f4214c == null && !bVar.f4243b) {
                                this.f4214c = bVar;
                                if (bVar.f4253l != null) {
                                    this.f4214c.f4253l.D(this.f4229r);
                                }
                            }
                            if (!bVar.f4243b) {
                                break;
                            } else {
                                if (bVar.f4244c == -1) {
                                    this.f4217f = bVar;
                                } else {
                                    this.f4218g.add(bVar);
                                }
                                this.f4216e.remove(bVar);
                                break;
                            }
                            break;
                        case "OnSwipe":
                            if (bVar == null) {
                                Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(resourceId) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.f4253l = new v(context, this.f4212a, xml);
                                break;
                            }
                            break;
                        case "OnClick":
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.v(context, xml);
                                break;
                            }
                            break;
                        case "StateSet":
                            this.f4213b = new androidx.constraintlayout.widget.g(context, xml);
                            break;
                        case "ConstraintSet":
                            Z(context, xml);
                            break;
                        case "include":
                        case "Include":
                            b0(context, xml);
                            break;
                        case "KeyFrameSet":
                            i iVar = new i(context, xml);
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.f4252k.add(iVar);
                                break;
                            }
                            break;
                        case "ViewTransition":
                            this.f4230s.b(new z(context, xml));
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    private int Z(Context context, XmlPullParser parser) {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.a1(false);
        int attributeCount = parser.getAttributeCount();
        int iV = -1;
        int iV2 = -1;
        for (int i7 = 0; i7 < attributeCount; i7++) {
            String attributeName = parser.getAttributeName(i7);
            String attributeValue = parser.getAttributeValue(i7);
            if (this.f4222k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            switch (attributeName) {
                case "deriveConstraintsFrom":
                    iV2 = v(context, attributeValue);
                    break;
                case "constraintRotate":
                    try {
                        dVar.f4761d = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException unused) {
                        attributeValue.hashCode();
                        switch (attributeValue) {
                            case "x_left":
                                dVar.f4761d = 4;
                                break;
                            case "left":
                                dVar.f4761d = 2;
                                break;
                            case "none":
                                dVar.f4761d = 0;
                                break;
                            case "right":
                                dVar.f4761d = 1;
                                break;
                            case "x_right":
                                dVar.f4761d = 3;
                                break;
                        }
                    }
                    break;
                case "id":
                    iV = v(context, attributeValue);
                    this.f4220i.put(q0(attributeValue), Integer.valueOf(iV));
                    dVar.f4759b = c.i(context, iV);
                    break;
            }
        }
        if (iV != -1) {
            if (this.f4212a.I0 != 0) {
                dVar.z1(true);
            }
            dVar.x0(context, parser);
            if (iV2 != -1) {
                this.f4221j.put(iV, iV2);
            }
            this.f4219h.put(iV, dVar);
        }
        return iV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a0(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && O.equals(name)) {
                    return Z(context, xml);
                }
            }
            return -1;
        } catch (IOException e8) {
            e8.printStackTrace();
            return -1;
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
            return -1;
        }
    }

    private void b0(Context context, XmlPullParser mainParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(mainParser), R.styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i7);
            if (index == R.styleable.include_constraintSet) {
                a0(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void c0(Context context, XmlPullParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i7);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i8 = typedArrayObtainStyledAttributes.getInt(index, this.f4223l);
                this.f4223l = i8;
                if (i8 < 8) {
                    this.f4223l = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.f4224m = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void g0(int key, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.d dVar = this.f4219h.get(key);
        dVar.f4760c = dVar.f4759b;
        int i7 = this.f4221j.get(key);
        if (i7 > 0) {
            g0(i7, motionLayout);
            androidx.constraintlayout.widget.d dVar2 = this.f4219h.get(i7);
            if (dVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + c.i(this.f4212a.getContext(), i7));
                return;
            }
            dVar.f4760c += "/" + dVar2.f4760c;
            dVar.J0(dVar2);
        } else {
            dVar.f4760c += "  layout";
            dVar.I0(motionLayout);
        }
        dVar.q(dVar);
    }

    public static String q0(String id) {
        if (id == null) {
            return "";
        }
        int iIndexOf = id.indexOf(47);
        return iIndexOf < 0 ? id : id.substring(iIndexOf + 1);
    }

    private int v(Context context, String idString) {
        int identifier;
        if (idString.contains("/")) {
            identifier = context.getResources().getIdentifier(idString.substring(idString.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f4222k) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (idString.length() > 1) {
            return Integer.parseInt(idString.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return identifier;
    }

    private int w(b transition) {
        int i7 = transition.f4242a;
        if (i7 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i8 = 0; i8 < this.f4216e.size(); i8++) {
            if (this.f4216e.get(i8).f4242a == i7) {
                return i8;
            }
        }
        return -1;
    }

    float B() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.i();
    }

    float C() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.j();
    }

    boolean D() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return false;
        }
        return this.f4214c.f4253l.k();
    }

    public float E(View view, int position) {
        return 0.0f;
    }

    float F(float dx, float dy) {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.l(dx, dy);
    }

    int H() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0;
        }
        return this.f4214c.f4253l.m();
    }

    float I() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.n();
    }

    float J() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.o();
    }

    float K() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.p();
    }

    float L() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0.0f;
        }
        return this.f4214c.f4253l.q();
    }

    public float M() {
        b bVar = this.f4214c;
        if (bVar != null) {
            return bVar.f4250i;
        }
        return 0.0f;
    }

    int N() {
        b bVar = this.f4214c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f4245d;
    }

    public b O(int id) {
        for (b bVar : this.f4216e) {
            if (bVar.f4242a == id) {
                return bVar;
            }
        }
        return null;
    }

    int P(int stateId) {
        Iterator<b> it = this.f4216e.iterator();
        while (it.hasNext()) {
            if (it.next().f4245d == stateId) {
                return 0;
            }
        }
        return 1;
    }

    public List<b> Q(int stateId) {
        int iG = G(stateId);
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f4216e) {
            if (bVar.f4245d == iG || bVar.f4244c == iG) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    boolean S(View view, int position) {
        b bVar = this.f4214c;
        if (bVar == null) {
            return false;
        }
        Iterator it = bVar.f4252k.iterator();
        while (it.hasNext()) {
            Iterator<f> it2 = ((i) it.next()).d(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().f3972a == position) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean U(int id) {
        return this.f4230s.h(id);
    }

    public int W(String id) {
        Integer num = this.f4220i.get(id);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String X(int id) {
        for (Map.Entry<String, Integer> entry : this.f4220i.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == id) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected void Y(boolean changed, int left, int top, int right, int bottom) {
    }

    void d0(float dx, float dy) {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return;
        }
        this.f4214c.f4253l.w(dx, dy);
    }

    void e0(float dx, float dy) {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return;
        }
        this.f4214c.f4253l.x(dx, dy);
    }

    public void f(MotionLayout motionLayout, int currentState) {
        for (b bVar : this.f4216e) {
            if (bVar.f4254m.size() > 0) {
                Iterator it = bVar.f4254m.iterator();
                while (it.hasNext()) {
                    ((b.a) it.next()).c(motionLayout);
                }
            }
        }
        for (b bVar2 : this.f4218g) {
            if (bVar2.f4254m.size() > 0) {
                Iterator it2 = bVar2.f4254m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        for (b bVar3 : this.f4216e) {
            if (bVar3.f4254m.size() > 0) {
                Iterator it3 = bVar3.f4254m.iterator();
                while (it3.hasNext()) {
                    ((b.a) it3.next()).a(motionLayout, currentState, bVar3);
                }
            }
        }
        for (b bVar4 : this.f4218g) {
            if (bVar4.f4254m.size() > 0) {
                Iterator it4 = bVar4.f4254m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).a(motionLayout, currentState, bVar4);
                }
            }
        }
    }

    void f0(MotionEvent event, int currentState, MotionLayout motionLayout) {
        MotionLayout.i iVar;
        MotionEvent motionEvent;
        RectF rectF = new RectF();
        if (this.f4228q == null) {
            this.f4228q = this.f4212a.N0();
        }
        this.f4228q.e(event);
        if (currentState != -1) {
            int action = event.getAction();
            boolean z7 = false;
            if (action == 0) {
                this.f4231t = event.getRawX();
                this.f4232u = event.getRawY();
                this.f4225n = event;
                this.f4226o = false;
                if (this.f4214c.f4253l != null) {
                    RectF rectFG = this.f4214c.f4253l.g(this.f4212a, rectF);
                    if (rectFG != null && !rectFG.contains(this.f4225n.getX(), this.f4225n.getY())) {
                        this.f4225n = null;
                        this.f4226o = true;
                        return;
                    }
                    RectF rectFR = this.f4214c.f4253l.r(this.f4212a, rectF);
                    if (rectFR == null || rectFR.contains(this.f4225n.getX(), this.f4225n.getY())) {
                        this.f4227p = false;
                    } else {
                        this.f4227p = true;
                    }
                    this.f4214c.f4253l.A(this.f4231t, this.f4232u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f4226o) {
                float rawY = event.getRawY() - this.f4232u;
                float rawX = event.getRawX() - this.f4231t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent = this.f4225n) == null) {
                    return;
                }
                b bVarJ = j(currentState, rawX, rawY, motionEvent);
                if (bVarJ != null) {
                    motionLayout.setTransition(bVarJ);
                    RectF rectFR2 = this.f4214c.f4253l.r(this.f4212a, rectF);
                    if (rectFR2 != null && !rectFR2.contains(this.f4225n.getX(), this.f4225n.getY())) {
                        z7 = true;
                    }
                    this.f4227p = z7;
                    this.f4214c.f4253l.G(this.f4231t, this.f4232u);
                }
            }
        }
        if (this.f4226o) {
            return;
        }
        b bVar = this.f4214c;
        if (bVar != null && bVar.f4253l != null && !this.f4227p) {
            this.f4214c.f4253l.u(event, this.f4228q, currentState, this);
        }
        this.f4231t = event.getRawX();
        this.f4232u = event.getRawY();
        if (event.getAction() != 1 || (iVar = this.f4228q) == null) {
            return;
        }
        iVar.a();
        this.f4228q = null;
        int i7 = motionLayout.N;
        if (i7 != -1) {
            i(motionLayout, i7);
        }
    }

    public void g(b transition) {
        int iW = w(transition);
        if (iW == -1) {
            this.f4216e.add(transition);
        } else {
            this.f4216e.set(iW, transition);
        }
    }

    public boolean h(int viewTransitionId, o motionController) {
        return this.f4230s.e(viewTransitionId, motionController);
    }

    void h0(MotionLayout motionLayout) {
        for (int i7 = 0; i7 < this.f4219h.size(); i7++) {
            int iKeyAt = this.f4219h.keyAt(i7);
            if (R(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            g0(iKeyAt, motionLayout);
        }
    }

    boolean i(MotionLayout motionLayout, int currentState) {
        b bVar;
        if (T() || this.f4215d) {
            return false;
        }
        for (b bVar2 : this.f4216e) {
            if (bVar2.f4255n != 0 && ((bVar = this.f4214c) != bVar2 || !bVar.L(2))) {
                if (currentState == bVar2.f4245d && (bVar2.f4255n == 4 || bVar2.f4255n == 2)) {
                    MotionLayout.m mVar = MotionLayout.m.FINISHED;
                    motionLayout.setState(mVar);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f4255n == 4) {
                        motionLayout.Z0();
                        motionLayout.setState(MotionLayout.m.SETUP);
                        motionLayout.setState(MotionLayout.m.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.s0(true);
                        motionLayout.setState(MotionLayout.m.SETUP);
                        motionLayout.setState(MotionLayout.m.MOVING);
                        motionLayout.setState(mVar);
                        motionLayout.O0();
                    }
                    return true;
                }
                if (currentState == bVar2.f4244c && (bVar2.f4255n == 3 || bVar2.f4255n == 1)) {
                    MotionLayout.m mVar2 = MotionLayout.m.FINISHED;
                    motionLayout.setState(mVar2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f4255n == 3) {
                        motionLayout.b1();
                        motionLayout.setState(MotionLayout.m.SETUP);
                        motionLayout.setState(MotionLayout.m.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.s0(true);
                        motionLayout.setState(MotionLayout.m.SETUP);
                        motionLayout.setState(MotionLayout.m.MOVING);
                        motionLayout.setState(mVar2);
                        motionLayout.O0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void i0(b transition) {
        int iW = w(transition);
        if (iW != -1) {
            this.f4216e.remove(iW);
        }
    }

    public b j(int currentState, float dx, float dy, MotionEvent lastTouchDown) {
        if (currentState == -1) {
            return this.f4214c;
        }
        List<b> listQ = Q(currentState);
        RectF rectF = new RectF();
        float f8 = 0.0f;
        b bVar = null;
        for (b bVar2 : listQ) {
            if (!bVar2.f4256o && bVar2.f4253l != null) {
                bVar2.f4253l.D(this.f4229r);
                RectF rectFR = bVar2.f4253l.r(this.f4212a, rectF);
                if (rectFR == null || lastTouchDown == null || rectFR.contains(lastTouchDown.getX(), lastTouchDown.getY())) {
                    RectF rectFG = bVar2.f4253l.g(this.f4212a, rectF);
                    if (rectFG == null || lastTouchDown == null || rectFG.contains(lastTouchDown.getX(), lastTouchDown.getY())) {
                        float fA = bVar2.f4253l.a(dx, dy);
                        if (bVar2.f4253l.f4311l && lastTouchDown != null) {
                            float x7 = lastTouchDown.getX() - bVar2.f4253l.f4308i;
                            float y7 = lastTouchDown.getY() - bVar2.f4253l.f4309j;
                            fA = ((float) (Math.atan2(dy + y7, dx + x7) - Math.atan2(x7, y7))) * 10.0f;
                        }
                        float f9 = fA * (bVar2.f4244c == currentState ? -1.0f : 1.1f);
                        if (f9 > f8) {
                            bVar = bVar2;
                            f8 = f9;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public void j0(int id, androidx.constraintlayout.widget.d set) {
        this.f4219h.put(id, set);
    }

    public void k(boolean disable) {
        this.f4215d = disable;
    }

    public void k0(int duration) {
        b bVar = this.f4214c;
        if (bVar != null) {
            bVar.O(duration);
        } else {
            this.f4223l = duration;
        }
    }

    public void l(int id, boolean enable) {
        this.f4230s.f(id, enable);
    }

    public void l0(View view, int position, String name, Object value) {
        b bVar = this.f4214c;
        if (bVar == null) {
            return;
        }
        Iterator it = bVar.f4252k.iterator();
        while (it.hasNext()) {
            Iterator<f> it2 = ((i) it.next()).d(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().f3972a == position) {
                    if (value != null) {
                        ((Float) value).floatValue();
                    }
                    name.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public int m() {
        b bVar = this.f4214c;
        if (bVar != null) {
            return bVar.f4257p;
        }
        return -1;
    }

    public void m0(boolean rtl) {
        this.f4229r = rtl;
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return;
        }
        this.f4214c.f4253l.D(this.f4229r);
    }

    int n() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return 0;
        }
        return this.f4214c.f4253l.e();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0073 A[SYNTHETIC] */
    void n0(int beginId, int endId) {
        int iE;
        int iE2;
        b bVar;
        Iterator<b> it;
        b bVar2;
        b bVar3;
        b next;
        androidx.constraintlayout.widget.g gVar = this.f4213b;
        if (gVar != null) {
            iE = gVar.e(beginId, -1, -1);
            if (iE == -1) {
                iE = beginId;
            }
            iE2 = this.f4213b.e(endId, -1, -1);
            if (iE2 == -1) {
            }
            bVar = this.f4214c;
            if (bVar == null && bVar.f4244c == endId && this.f4214c.f4245d == beginId) {
                return;
            }
            it = this.f4216e.iterator();
            while (true) {
                if (it.hasNext()) {
                    bVar2 = this.f4217f;
                    for (b bVar4 : this.f4218g) {
                        if (bVar4.f4244c == endId) {
                            bVar2 = bVar4;
                        }
                    }
                    bVar3 = new b(this, bVar2);
                    bVar3.f4245d = iE;
                    bVar3.f4244c = iE2;
                    if (iE != -1) {
                        this.f4216e.add(bVar3);
                    }
                    this.f4214c = bVar3;
                    return;
                }
                next = it.next();
                if ((next.f4244c != iE2 && next.f4245d == iE) || (next.f4244c == endId && next.f4245d == beginId)) {
                    break;
                }
            }
            this.f4214c = next;
            if (next != null || next.f4253l == null) {
            }
            this.f4214c.f4253l.D(this.f4229r);
            return;
        }
        iE = beginId;
        iE2 = endId;
        bVar = this.f4214c;
        if (bVar == null) {
        }
        it = this.f4216e.iterator();
        while (true) {
            if (it.hasNext()) {
                bVar2 = this.f4217f;
                while (r3.hasNext()) {
                    if (bVar4.f4244c == endId) {
                        bVar2 = bVar4;
                    }
                }
                bVar3 = new b(this, bVar2);
                bVar3.f4245d = iE;
                bVar3.f4244c = iE2;
                if (iE != -1) {
                    this.f4216e.add(bVar3);
                }
                this.f4214c = bVar3;
                return;
            }
            next = it.next();
            if (next.f4244c != iE2) {
            }
        }
        this.f4214c = next;
        if (next != null) {
        }
    }

    androidx.constraintlayout.widget.d o(int id) {
        return p(id, -1, -1);
    }

    public void o0(b transition) {
        this.f4214c = transition;
        if (transition == null || transition.f4253l == null) {
            return;
        }
        this.f4214c.f4253l.D(this.f4229r);
    }

    androidx.constraintlayout.widget.d p(int id, int width, int height) {
        int iE;
        if (this.f4222k) {
            System.out.println("id " + id);
            System.out.println("size " + this.f4219h.size());
        }
        androidx.constraintlayout.widget.g gVar = this.f4213b;
        if (gVar != null && (iE = gVar.e(id, width, height)) != -1) {
            id = iE;
        }
        if (this.f4219h.get(id) != null) {
            return this.f4219h.get(id);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + c.i(this.f4212a.getContext(), id) + " In MotionScene");
        SparseArray<androidx.constraintlayout.widget.d> sparseArray = this.f4219h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    void p0() {
        b bVar = this.f4214c;
        if (bVar == null || bVar.f4253l == null) {
            return;
        }
        this.f4214c.f4253l.H();
    }

    public androidx.constraintlayout.widget.d q(Context context, String id) {
        if (this.f4222k) {
            System.out.println("id " + id);
            System.out.println("size " + this.f4219h.size());
        }
        for (int i7 = 0; i7 < this.f4219h.size(); i7++) {
            int iKeyAt = this.f4219h.keyAt(i7);
            String resourceName = context.getResources().getResourceName(iKeyAt);
            if (this.f4222k) {
                System.out.println("Id for <" + i7 + "> is <" + resourceName + "> looking for <" + id + ">");
            }
            if (id.equals(resourceName)) {
                return this.f4219h.get(iKeyAt);
            }
        }
        return null;
    }

    public int[] r() {
        int size = this.f4219h.size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            iArr[i7] = this.f4219h.keyAt(i7);
        }
        return iArr;
    }

    boolean r0() {
        Iterator<b> it = this.f4216e.iterator();
        while (it.hasNext()) {
            if (it.next().f4253l != null) {
                return true;
            }
        }
        b bVar = this.f4214c;
        return (bVar == null || bVar.f4253l == null) ? false : true;
    }

    public ArrayList<b> s() {
        return this.f4216e;
    }

    public boolean s0(MotionLayout layout) {
        return layout == this.f4212a && layout.I == this;
    }

    public int t() {
        b bVar = this.f4214c;
        return bVar != null ? bVar.f4249h : this.f4223l;
    }

    public void t0(int id, View... view) {
        this.f4230s.m(id, view);
    }

    int u() {
        b bVar = this.f4214c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f4244c;
    }

    public Interpolator x() {
        int i7 = this.f4214c.f4246e;
        if (i7 == -2) {
            return AnimationUtils.loadInterpolator(this.f4212a.getContext(), this.f4214c.f4248g);
        }
        if (i7 == -1) {
            return new a(this, androidx.constraintlayout.core.motion.utils.d.c(this.f4214c.f4247f));
        }
        if (i7 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i7 == 1) {
            return new AccelerateInterpolator();
        }
        if (i7 == 2) {
            return new DecelerateInterpolator();
        }
        if (i7 == 4) {
            return new BounceInterpolator();
        }
        if (i7 == 5) {
            return new OvershootInterpolator();
        }
        if (i7 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    f y(Context context, int type, int target, int position) {
        b bVar = this.f4214c;
        if (bVar == null) {
            return null;
        }
        for (i iVar : bVar.f4252k) {
            for (Integer num : iVar.e()) {
                if (target == num.intValue()) {
                    for (f fVar : iVar.d(num.intValue())) {
                        if (fVar.f3972a == position && fVar.f3975d == type) {
                            return fVar;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void z(o motionController) {
        b bVar = this.f4214c;
        if (bVar != null) {
            Iterator it = bVar.f4252k.iterator();
            while (it.hasNext()) {
                ((i) it.next()).b(motionController);
            }
        } else {
            b bVar2 = this.f4217f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.f4252k.iterator();
                while (it2.hasNext()) {
                    ((i) it2.next()).b(motionController);
                }
            }
        }
    }

    public static class b {
        public static final int A = -2;
        public static final int B = -1;
        public static final int C = 0;
        public static final int D = 1;
        public static final int E = 2;
        public static final int F = 3;
        public static final int G = 4;
        public static final int H = 5;
        public static final int I = 6;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f4234s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f4235t = 1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f4236u = 2;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f4237v = 3;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f4238w = 4;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        static final int f4239x = 1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        static final int f4240y = 2;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        static final int f4241z = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f4247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f4248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f4249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f4250i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final s f4251j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ArrayList<i> f4252k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private v f4253l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ArrayList<a> f4254m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f4255n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f4256o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f4257p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f4258q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f4259r;

        b(s motionScene, b global) {
            this.f4242a = -1;
            this.f4243b = false;
            this.f4244c = -1;
            this.f4245d = -1;
            this.f4246e = 0;
            this.f4247f = null;
            this.f4248g = -1;
            this.f4249h = 400;
            this.f4250i = 0.0f;
            this.f4252k = new ArrayList<>();
            this.f4253l = null;
            this.f4254m = new ArrayList<>();
            this.f4255n = 0;
            this.f4256o = false;
            this.f4257p = -1;
            this.f4258q = 0;
            this.f4259r = 0;
            this.f4251j = motionScene;
            this.f4249h = motionScene.f4223l;
            if (global != null) {
                this.f4257p = global.f4257p;
                this.f4246e = global.f4246e;
                this.f4247f = global.f4247f;
                this.f4248g = global.f4248g;
                this.f4249h = global.f4249h;
                this.f4252k = global.f4252k;
                this.f4250i = global.f4250i;
                this.f4258q = global.f4258q;
            }
        }

        private void x(s motionScene, Context context, TypedArray a8) {
            int indexCount = a8.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = a8.getIndex(i7);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.f4244c = a8.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4244c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        dVar.w0(context, this.f4244c);
                        motionScene.f4219h.append(this.f4244c, dVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f4244c = motionScene.a0(context, this.f4244c);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.f4245d = a8.getResourceId(index, this.f4245d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f4245d);
                    if ("layout".equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.d dVar2 = new androidx.constraintlayout.widget.d();
                        dVar2.w0(context, this.f4245d);
                        motionScene.f4219h.append(this.f4245d, dVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f4245d = motionScene.a0(context, this.f4245d);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i8 = a8.peekValue(index).type;
                    if (i8 == 1) {
                        int resourceId = a8.getResourceId(index, -1);
                        this.f4248g = resourceId;
                        if (resourceId != -1) {
                            this.f4246e = -2;
                        }
                    } else if (i8 == 3) {
                        String string = a8.getString(index);
                        this.f4247f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f4248g = a8.getResourceId(index, -1);
                                this.f4246e = -2;
                            } else {
                                this.f4246e = -1;
                            }
                        }
                    } else {
                        this.f4246e = a8.getInteger(index, this.f4246e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i9 = a8.getInt(index, this.f4249h);
                    this.f4249h = i9;
                    if (i9 < 8) {
                        this.f4249h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.f4250i = a8.getFloat(index, this.f4250i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.f4255n = a8.getInteger(index, this.f4255n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f4242a = a8.getResourceId(index, this.f4242a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.f4256o = a8.getBoolean(index, this.f4256o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.f4257p = a8.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.f4258q = a8.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.f4259r = a8.getInteger(index, 0);
                }
            }
            if (this.f4245d == -1) {
                this.f4243b = true;
            }
        }

        private void y(s motionScene, Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Transition);
            x(motionScene, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f4249h;
        }

        public int B() {
            return this.f4244c;
        }

        public int C() {
            return this.f4242a;
        }

        public List<i> D() {
            return this.f4252k;
        }

        public int E() {
            return this.f4258q;
        }

        public List<a> F() {
            return this.f4254m;
        }

        public int G() {
            return this.f4257p;
        }

        public float H() {
            return this.f4250i;
        }

        public int I() {
            return this.f4245d;
        }

        public v J() {
            return this.f4253l;
        }

        public boolean K() {
            return !this.f4256o;
        }

        public boolean L(int flag) {
            return (flag & this.f4259r) != 0;
        }

        public void M(int id) {
            a next;
            Iterator<a> it = this.f4254m.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.f4266b != id);
            if (next != null) {
                this.f4254m.remove(next);
            }
        }

        public void N(int type) {
            this.f4255n = type;
        }

        public void O(int duration) {
            this.f4249h = Math.max(duration, 8);
        }

        public void P(boolean enable) {
            Q(enable);
        }

        public void Q(boolean enable) {
            this.f4256o = !enable;
        }

        public void R(int interpolator, String interpolatorString, int interpolatorID) {
            this.f4246e = interpolator;
            this.f4247f = interpolatorString;
            this.f4248g = interpolatorID;
        }

        public void S(int mode) {
            this.f4258q = mode;
        }

        public void T(t onSwipe) {
            this.f4253l = onSwipe == null ? null : new v(this.f4251j.f4212a, onSwipe);
        }

        public void U(int touchUpMode) {
            v vVarJ = J();
            if (vVarJ != null) {
                vVarJ.F(touchUpMode);
            }
        }

        public void V(int arcMode) {
            this.f4257p = arcMode;
        }

        public void W(float stagger) {
            this.f4250i = stagger;
        }

        public void X(int flag) {
            this.f4259r = flag;
        }

        public void t(i keyFrames) {
            this.f4252k.add(keyFrames);
        }

        public void u(int id, int action) {
            for (a aVar : this.f4254m) {
                if (aVar.f4266b == id) {
                    aVar.f4267c = action;
                    return;
                }
            }
            this.f4254m.add(new a(this, id, action));
        }

        public void v(Context context, XmlPullParser parser) {
            this.f4254m.add(new a(context, this, parser));
        }

        public String w(Context context) {
            String resourceEntryName = this.f4245d == -1 ? "null" : context.getResources().getResourceEntryName(this.f4245d);
            if (this.f4244c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f4244c);
        }

        public int z() {
            return this.f4255n;
        }

        public static class a implements View.OnClickListener {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f4260d = 1;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f4261e = 17;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f4262f = 16;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f4263g = 256;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f4264h = 4096;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final b f4265a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f4266b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f4267c;

            public a(Context context, b transition, XmlPullParser parser) {
                this.f4266b = -1;
                this.f4267c = 17;
                this.f4265a = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i7 = 0; i7 < indexCount; i7++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i7);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f4266b = typedArrayObtainStyledAttributes.getResourceId(index, this.f4266b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f4267c = typedArrayObtainStyledAttributes.getInt(index, this.f4267c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i7, b bVar) {
                boolean z7;
                View viewFindViewById;
                int i8 = this.f4266b;
                View view = motionLayout;
                if (i8 != -1) {
                    viewFindViewById = motionLayout.findViewById(i8);
                }
                if (view == null) {
                    view = viewFindViewById;
                    Log.e("MotionScene", "OnClick could not find id " + this.f4266b);
                    return;
                }
                int i9 = bVar.f4245d;
                int i10 = bVar.f4244c;
                if (i9 == -1) {
                    view = viewFindViewById;
                    view.setOnClickListener(this);
                    return;
                }
                int i11 = this.f4267c;
                boolean z8 = false;
                if ((i11 & 1) == 0 || i7 != i9) {
                    view = viewFindViewById;
                    z7 = false;
                } else {
                    z7 = true;
                }
                boolean z9 = ((i11 & 1) != 0 && i7 == i9) | z7 | ((i11 & 256) != 0 && i7 == i9) | ((i11 & 16) != 0 && i7 == i10);
                if ((i11 & 4096) != 0 && i7 == i10) {
                    z8 = true;
                }
                if (z9 || z8) {
                    view.setOnClickListener(this);
                }
            }

            boolean b(b current, MotionLayout tl) {
                b bVar = this.f4265a;
                if (bVar == current) {
                    return true;
                }
                int i7 = bVar.f4244c;
                int i8 = this.f4265a.f4245d;
                if (i8 == -1) {
                    return tl.N != i7;
                }
                int i9 = tl.N;
                return i9 == i8 || i9 == i7;
            }

            public void c(MotionLayout motionLayout) {
                int i7 = this.f4266b;
                if (i7 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i7);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.f4266b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.f4265a.f4251j.f4212a;
                if (motionLayout.J0()) {
                    if (this.f4265a.f4245d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.c1(this.f4265a.f4244c);
                            return;
                        }
                        b bVar = new b(this.f4265a.f4251j, this.f4265a);
                        bVar.f4245d = currentState;
                        bVar.f4244c = this.f4265a.f4244c;
                        motionLayout.setTransition(bVar);
                        motionLayout.Z0();
                        return;
                    }
                    b bVar2 = this.f4265a.f4251j.f4214c;
                    int i7 = this.f4267c;
                    boolean z7 = false;
                    boolean z8 = ((i7 & 1) == 0 && (i7 & 256) == 0) ? false : true;
                    boolean z9 = ((i7 & 16) == 0 && (i7 & 4096) == 0) ? false : true;
                    if (z8 && z9) {
                        b bVar3 = this.f4265a.f4251j.f4214c;
                        b bVar4 = this.f4265a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z9 = false;
                            z7 = z8;
                        }
                    } else {
                        z7 = z8;
                    }
                    if (b(bVar2, motionLayout)) {
                        if (z7 && (this.f4267c & 1) != 0) {
                            motionLayout.setTransition(this.f4265a);
                            motionLayout.Z0();
                            return;
                        }
                        if (z9 && (this.f4267c & 16) != 0) {
                            motionLayout.setTransition(this.f4265a);
                            motionLayout.b1();
                        } else if (z7 && (this.f4267c & 256) != 0) {
                            motionLayout.setTransition(this.f4265a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z9 || (this.f4267c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.f4265a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public a(b transition, int id, int action) {
                this.f4265a = transition;
                this.f4266b = id;
                this.f4267c = action;
            }
        }

        public b(int id, s motionScene, int constraintSetStartId, int constraintSetEndId) {
            this.f4242a = -1;
            this.f4243b = false;
            this.f4244c = -1;
            this.f4245d = -1;
            this.f4246e = 0;
            this.f4247f = null;
            this.f4248g = -1;
            this.f4249h = 400;
            this.f4250i = 0.0f;
            this.f4252k = new ArrayList<>();
            this.f4253l = null;
            this.f4254m = new ArrayList<>();
            this.f4255n = 0;
            this.f4256o = false;
            this.f4257p = -1;
            this.f4258q = 0;
            this.f4259r = 0;
            this.f4242a = id;
            this.f4251j = motionScene;
            this.f4245d = constraintSetStartId;
            this.f4244c = constraintSetEndId;
            this.f4249h = motionScene.f4223l;
            this.f4258q = motionScene.f4224m;
        }

        b(s motionScene, Context context, XmlPullParser parser) {
            this.f4242a = -1;
            this.f4243b = false;
            this.f4244c = -1;
            this.f4245d = -1;
            this.f4246e = 0;
            this.f4247f = null;
            this.f4248g = -1;
            this.f4249h = 400;
            this.f4250i = 0.0f;
            this.f4252k = new ArrayList<>();
            this.f4253l = null;
            this.f4254m = new ArrayList<>();
            this.f4255n = 0;
            this.f4256o = false;
            this.f4257p = -1;
            this.f4258q = 0;
            this.f4259r = 0;
            this.f4249h = motionScene.f4223l;
            this.f4258q = motionScene.f4224m;
            this.f4251j = motionScene;
            y(motionScene, context, Xml.asAttributeSet(parser));
        }
    }

    s(Context context, MotionLayout layout, int resourceID) {
        this.f4212a = layout;
        this.f4230s = new a0(layout);
        V(context, resourceID);
        this.f4219h.put(R.id.motion_base, new androidx.constraintlayout.widget.d());
        this.f4220i.put("motion_base", Integer.valueOf(R.id.motion_base));
    }
}
