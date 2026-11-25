package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d implements u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f3941g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f3942h = "DesignTool";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f3943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final HashMap<String, String> f3944j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionLayout f3945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s f3946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3947c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3948d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3949e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3950f = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> map = new HashMap<>();
        f3943i = map;
        HashMap<String, String> map2 = new HashMap<>();
        f3944j = map2;
        map.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        map.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        map.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        map.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        map.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        map.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        map.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        map.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        map.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        map.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        map.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        map.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        map.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        map2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        map2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        map2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        map2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        map2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        map2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        map2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        map2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        map2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        map2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        map2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        map2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public d(MotionLayout motionLayout) {
        this.f3945a = motionLayout;
    }

    private static void j(int dpi, androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes, int from, int to) {
        String str = f3943i.get(Pair.create(Integer.valueOf(from), Integer.valueOf(to)));
        String str2 = attributes.get(str);
        if (str2 != null) {
            String str3 = f3944j.get(str);
            int iK = str3 != null ? k(dpi, attributes.get(str3)) : 0;
            set.L(view.getId(), from, Integer.parseInt(str2), to, iK);
        }
    }

    private static int k(int dpi, String value) {
        int iIndexOf;
        if (value == null || (iIndexOf = value.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(value.substring(0, iIndexOf)).intValue() * dpi) / 160.0f);
    }

    private static void l(int dpi, androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes) {
        String str = attributes.get("layout_editor_absoluteX");
        if (str != null) {
            set.W0(view.getId(), k(dpi, str));
        }
        String str2 = attributes.get("layout_editor_absoluteY");
        if (str2 != null) {
            set.X0(view.getId(), k(dpi, str2));
        }
    }

    private static void m(androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes, int type) {
        String str = attributes.get(type == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (type == 0) {
                set.f1(view.getId(), Float.parseFloat(str));
            } else if (type == 1) {
                set.A1(view.getId(), Float.parseFloat(str));
            }
        }
    }

    private static void n(int dpi, androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes, int type) {
        String str = attributes.get(type == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int iK = !str.equalsIgnoreCase("wrap_content") ? k(dpi, str) : -2;
            if (type == 0) {
                set.W(view.getId(), iK);
            } else {
                set.P(view.getId(), iK);
            }
        }
    }

    public String A() {
        if (this.f3947c != null && this.f3948d != null) {
            float fY = y();
            if (fY <= 0.01f) {
                return this.f3947c;
            }
            if (fY >= 0.99f) {
                return this.f3948d;
            }
        }
        return this.f3947c;
    }

    public boolean B() {
        return (this.f3947c == null || this.f3948d == null) ? false : true;
    }

    public void C(Object keyFrame, String tag, Object value) {
        if (keyFrame instanceof f) {
            ((f) keyFrame).j(tag, value);
            this.f3945a.R0();
            this.f3945a.D0 = true;
        }
    }

    public void D(String id) {
        if (id == null) {
            id = "motion_base";
        }
        if (this.f3947c == id) {
            return;
        }
        this.f3947c = id;
        this.f3948d = null;
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I == null) {
            motionLayout.I = this.f3946b;
        }
        int iM0 = motionLayout.M0(id);
        this.f3949e = iM0;
        if (iM0 != 0) {
            if (iM0 == this.f3945a.getStartState()) {
                this.f3945a.setProgress(0.0f);
            } else if (iM0 == this.f3945a.getEndState()) {
                this.f3945a.setProgress(1.0f);
            } else {
                this.f3945a.c1(iM0);
                this.f3945a.setProgress(1.0f);
            }
        }
        this.f3945a.requestLayout();
    }

    public void E(String start, String end) {
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I == null) {
            motionLayout.I = this.f3946b;
        }
        int iM0 = motionLayout.M0(start);
        int iM1 = this.f3945a.M0(end);
        this.f3945a.setTransition(iM0, iM1);
        this.f3949e = iM0;
        this.f3950f = iM1;
        this.f3947c = start;
        this.f3948d = end;
    }

    public void F(Object view, int debugMode) {
        o oVar;
        if ((view instanceof View) && (oVar = this.f3945a.S.get(view)) != null) {
            oVar.S(debugMode);
            this.f3945a.invalidate();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public long a() {
        return this.f3945a.getTransitionTimeMs();
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public int b(int cmd, String type, Object viewObject, float[] in, int inLength, float[] out, int outLength) {
        o oVar;
        View view = (View) viewObject;
        if (cmd != 0) {
            MotionLayout motionLayout = this.f3945a;
            if (motionLayout.I == null || view == null || (oVar = motionLayout.S.get(view)) == null) {
                return -1;
            }
        } else {
            oVar = null;
        }
        if (cmd == 0) {
            return 1;
        }
        if (cmd == 1) {
            int iT = this.f3945a.I.t() / 16;
            oVar.f(out, iT);
            return iT;
        }
        if (cmd == 2) {
            int iT2 = this.f3945a.I.t() / 16;
            oVar.e(out, null);
            return iT2;
        }
        if (cmd != 3) {
            return -1;
        }
        int iT3 = this.f3945a.I.t() / 16;
        return oVar.l(type, out, outLength);
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public boolean c(Object view, int position, int type, float x7, float y7) {
        if (!(view instanceof View)) {
            return false;
        }
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I != null) {
            o oVar = motionLayout.S.get(view);
            MotionLayout motionLayout2 = this.f3945a;
            int i7 = (int) (motionLayout2.V * 100.0f);
            if (oVar != null) {
                View view2 = (View) view;
                if (motionLayout2.I.S(view2, i7)) {
                    float fY = oVar.y(2, x7, y7);
                    float fY2 = oVar.y(5, x7, y7);
                    this.f3945a.I.l0(view2, i7, "motion:percentX", Float.valueOf(fY));
                    this.f3945a.I.l0(view2, i7, "motion:percentY", Float.valueOf(fY2));
                    this.f3945a.R0();
                    this.f3945a.s0(true);
                    this.f3945a.invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public void d(float position) {
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I == null) {
            motionLayout.I = this.f3946b;
        }
        motionLayout.setProgress(position);
        this.f3945a.s0(true);
        this.f3945a.requestLayout();
        this.f3945a.invalidate();
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public Boolean e(Object keyFrame, Object view, float x7, float y7, String[] attribute, float[] value) {
        if (!(keyFrame instanceof k)) {
            return Boolean.FALSE;
        }
        View view2 = (View) view;
        this.f3945a.S.get(view2).N(view2, (k) keyFrame, x7, y7, attribute, value);
        this.f3945a.R0();
        this.f3945a.D0 = true;
        return Boolean.TRUE;
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public void f(Object view, int position, String name, Object value) {
        s sVar = this.f3945a.I;
        if (sVar != null) {
            sVar.l0((View) view, position, name, value);
            MotionLayout motionLayout = this.f3945a;
            motionLayout.B0 = position / 100.0f;
            motionLayout.W = 0.0f;
            motionLayout.R0();
            this.f3945a.s0(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public void g(int dpi, String constraintSetId, Object opaqueView, Object opaqueAttributes) {
        View view = (View) opaqueView;
        HashMap map = (HashMap) opaqueAttributes;
        int iM0 = this.f3945a.M0(constraintSetId);
        androidx.constraintlayout.widget.d dVarO = this.f3945a.I.o(iM0);
        if (dVarO == null) {
            return;
        }
        dVarO.E(view.getId());
        n(dpi, dVarO, view, map, 0);
        n(dpi, dVarO, view, map, 1);
        j(dpi, dVarO, view, map, 6, 6);
        j(dpi, dVarO, view, map, 6, 7);
        j(dpi, dVarO, view, map, 7, 7);
        j(dpi, dVarO, view, map, 7, 6);
        j(dpi, dVarO, view, map, 1, 1);
        j(dpi, dVarO, view, map, 1, 2);
        j(dpi, dVarO, view, map, 2, 2);
        j(dpi, dVarO, view, map, 2, 1);
        j(dpi, dVarO, view, map, 3, 3);
        j(dpi, dVarO, view, map, 3, 4);
        j(dpi, dVarO, view, map, 4, 3);
        j(dpi, dVarO, view, map, 4, 4);
        j(dpi, dVarO, view, map, 5, 5);
        m(dVarO, view, map, 0);
        m(dVarO, view, map, 1);
        l(dpi, dVarO, view, map);
        this.f3945a.h1(iM0, dVarO);
        this.f3945a.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public float h(Object view, int type, float x7, float y7) {
        o oVar;
        if ((view instanceof View) && (oVar = this.f3945a.S.get((View) view)) != null) {
            return oVar.y(type, x7, y7);
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.u
    public Object i(Object viewObject, float x7, float y7) {
        o oVar;
        View view = (View) viewObject;
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I == null) {
            return -1;
        }
        if (view == null || (oVar = motionLayout.S.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return oVar.B(viewGroup.getWidth(), viewGroup.getHeight(), x7, y7);
    }

    public void o(boolean disable) {
        this.f3945a.o0(disable);
    }

    public void p(String set) {
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I == null) {
            motionLayout.I = this.f3946b;
        }
        int iM0 = motionLayout.M0(set);
        System.out.println(" dumping  " + set + " (" + iM0 + ")");
        try {
            this.f3945a.I.o(iM0).g0(this.f3945a.I, new int[0]);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public int q(Object view, float[] key) {
        s sVar = this.f3945a.I;
        if (sVar == null) {
            return -1;
        }
        int iT = sVar.t() / 16;
        o oVar = this.f3945a.S.get(view);
        if (oVar == null) {
            return 0;
        }
        oVar.e(key, null);
        return iT;
    }

    public int r(Object view, float[] path, int len) {
        MotionLayout motionLayout = this.f3945a;
        if (motionLayout.I == null) {
            return -1;
        }
        o oVar = motionLayout.S.get(view);
        if (oVar == null) {
            return 0;
        }
        oVar.f(path, len);
        return len;
    }

    public void s(Object view, float[] path) {
        s sVar = this.f3945a.I;
        if (sVar == null) {
            return;
        }
        int iT = sVar.t() / 16;
        o oVar = this.f3945a.S.get(view);
        if (oVar == null) {
            return;
        }
        oVar.h(path, iT);
    }

    public String t() {
        int endState = this.f3945a.getEndState();
        if (this.f3950f == endState) {
            return this.f3948d;
        }
        String strA0 = this.f3945a.A0(endState);
        if (strA0 != null) {
            this.f3948d = strA0;
            this.f3950f = endState;
        }
        return strA0;
    }

    public int u(Object view, int type, int[] info) {
        o oVar = this.f3945a.S.get((View) view);
        if (oVar == null) {
            return 0;
        }
        return oVar.x(type, info);
    }

    public int v(Object view, int[] type, float[] pos) {
        o oVar = this.f3945a.S.get((View) view);
        if (oVar == null) {
            return 0;
        }
        return oVar.z(type, pos);
    }

    public Object w(int type, int target, int position) {
        MotionLayout motionLayout = this.f3945a;
        s sVar = motionLayout.I;
        if (sVar == null) {
            return null;
        }
        return sVar.y(motionLayout.getContext(), type, target, position);
    }

    public Object x(Object view, int type, int position) {
        if (this.f3945a.I == null) {
            return null;
        }
        int id = ((View) view).getId();
        MotionLayout motionLayout = this.f3945a;
        return motionLayout.I.y(motionLayout.getContext(), type, id, position);
    }

    public float y() {
        return this.f3945a.getProgress();
    }

    public String z() {
        int startState = this.f3945a.getStartState();
        if (this.f3949e == startState) {
            return this.f3947c;
        }
        String strA0 = this.f3945a.A0(startState);
        if (strA0 != null) {
            this.f3947c = strA0;
            this.f3949e = startState;
        }
        return this.f3945a.A0(startState);
    }
}
