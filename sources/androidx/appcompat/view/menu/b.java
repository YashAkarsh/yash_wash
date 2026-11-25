package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public abstract class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f1131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f1132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected g f1133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f1134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f1135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private n.a f1136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected o f1139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1140j;

    public b(Context context, int i7, int i8) {
        this.f1131a = context;
        this.f1134d = LayoutInflater.from(context);
        this.f1137g = i7;
        this.f1138h = i8;
    }

    @Override // androidx.appcompat.view.menu.n
    public int a() {
        return this.f1140j;
    }

    protected void c(View view, int i7) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1139i).addView(view, i7);
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(g gVar, boolean z7) {
        n.a aVar = this.f1136f;
        if (aVar != null) {
            aVar.d(gVar, z7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        ViewGroup viewGroup = (ViewGroup) this.f1139i;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f1133c;
        int i7 = 0;
        if (gVar != null) {
            gVar.u();
            ArrayList<j> arrayListH = this.f1133c.H();
            int size = arrayListH.size();
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                j jVar = arrayListH.get(i9);
                if (u(i8, jVar)) {
                    View childAt = viewGroup.getChildAt(i8);
                    j itemData = childAt instanceof o.a ? ((o.a) childAt).getItemData() : null;
                    View viewS = s(jVar, childAt, viewGroup);
                    if (jVar != itemData) {
                        viewS.setPressed(false);
                        viewS.jumpDrawablesToCurrentState();
                    }
                    if (viewS != childAt) {
                        c(viewS, i8);
                    }
                    i8++;
                }
            }
            i7 = i8;
        }
        while (i7 < viewGroup.getChildCount()) {
            if (!q(viewGroup, i7)) {
                i7++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean g(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean h(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void i(n.a aVar) {
        this.f1136f = aVar;
    }

    @Override // androidx.appcompat.view.menu.n
    public void j(Context context, g gVar) {
        this.f1132b = context;
        this.f1135e = LayoutInflater.from(context);
        this.f1133c = gVar;
    }

    public abstract void l(j jVar, o.a aVar);

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.n
    public boolean m(s sVar) {
        n.a aVar = this.f1136f;
        g gVar = sVar;
        if (aVar == null) {
            return false;
        }
        if (sVar == null) {
            gVar = this.f1133c;
        }
        return aVar.e(gVar);
    }

    @Override // androidx.appcompat.view.menu.n
    public o n(ViewGroup viewGroup) {
        if (this.f1139i == null) {
            o oVar = (o) this.f1134d.inflate(this.f1137g, viewGroup, false);
            this.f1139i = oVar;
            oVar.e(this.f1133c);
            e(true);
        }
        return this.f1139i;
    }

    public o.a p(ViewGroup viewGroup) {
        return (o.a) this.f1134d.inflate(this.f1138h, viewGroup, false);
    }

    protected boolean q(ViewGroup viewGroup, int i7) {
        viewGroup.removeViewAt(i7);
        return true;
    }

    public n.a r() {
        return this.f1136f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View s(j jVar, View view, ViewGroup viewGroup) {
        o.a aVarP = view instanceof o.a ? (o.a) view : p(viewGroup);
        l(jVar, aVarP);
        return (View) aVarP;
    }

    public void t(int i7) {
        this.f1140j = i7;
    }

    public boolean u(int i7, j jVar) {
        return true;
    }
}
