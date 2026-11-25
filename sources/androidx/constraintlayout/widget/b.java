package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4651h = "ConstraintLayoutStates";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f4652i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f4653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f4654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4655c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4656d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<a> f4657e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SparseArray<d> f4658f = new SparseArray<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f4659g = null;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<C0047b> f4661b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d f4663d;

        public a(Context context, XmlPullParser parser) {
            this.f4662c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.State_android_id) {
                    this.f4660a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4660a);
                } else if (index == R.styleable.State_constraints) {
                    this.f4662c = typedArrayObtainStyledAttributes.getResourceId(index, this.f4662c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4662c);
                    context.getResources().getResourceName(this.f4662c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f4663d = dVar;
                        dVar.G(context, this.f4662c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(C0047b size) {
            this.f4661b.add(size);
        }

        public int b(float width, float height) {
            for (int i7 = 0; i7 < this.f4661b.size(); i7++) {
                if (this.f4661b.get(i7).a(width, height)) {
                    return i7;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    static class C0047b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f4665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f4666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f4667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f4668e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4669f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        d f4670g;

        public C0047b(Context context, XmlPullParser parser) {
            this.f4665b = Float.NaN;
            this.f4666c = Float.NaN;
            this.f4667d = Float.NaN;
            this.f4668e = Float.NaN;
            this.f4669f = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.Variant_constraints) {
                    this.f4669f = typedArrayObtainStyledAttributes.getResourceId(index, this.f4669f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4669f);
                    context.getResources().getResourceName(this.f4669f);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f4670g = dVar;
                        dVar.G(context, this.f4669f);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f4668e = typedArrayObtainStyledAttributes.getDimension(index, this.f4668e);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f4666c = typedArrayObtainStyledAttributes.getDimension(index, this.f4666c);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f4667d = typedArrayObtainStyledAttributes.getDimension(index, this.f4667d);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f4665b = typedArrayObtainStyledAttributes.getDimension(index, this.f4665b);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float widthDp, float heightDp) {
            if (!Float.isNaN(this.f4665b) && widthDp < this.f4665b) {
                return false;
            }
            if (!Float.isNaN(this.f4666c) && heightDp < this.f4666c) {
                return false;
            }
            if (Float.isNaN(this.f4667d) || widthDp <= this.f4667d) {
                return Float.isNaN(this.f4668e) || heightDp <= this.f4668e;
            }
            return false;
        }
    }

    b(Context context, ConstraintLayout layout, int resourceID) {
        this.f4653a = layout;
        a(context, resourceID);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            int eventType = xml.getEventType();
            a aVar = null;
            while (true) {
                byte b8 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (!name.equals("ConstraintSet")) {
                                b8 = -1;
                            } else {
                                b8 = 4;
                            }
                            break;
                        case 80204913:
                            if (!name.equals("State")) {
                                b8 = -1;
                            } else {
                                b8 = 2;
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                b8 = -1;
                            }
                            break;
                        case 1657696882:
                            if (!name.equals("layoutDescription")) {
                                b8 = -1;
                            } else {
                                b8 = 0;
                            }
                            break;
                        case 1901439077:
                            if (!name.equals("Variant")) {
                                b8 = -1;
                            } else {
                                b8 = 3;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    if (b8 == 2) {
                        aVar = new a(context, xml);
                        this.f4657e.put(aVar.f4660a, aVar);
                    } else if (b8 == 3) {
                        C0047b c0047b = new C0047b(context, xml);
                        if (aVar != null) {
                            aVar.a(c0047b);
                        }
                    } else if (b8 == 4) {
                        c(context, xml);
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

    private void c(Context context, XmlPullParser parser) {
        d dVar = new d();
        int attributeCount = parser.getAttributeCount();
        for (int i7 = 0; i7 < attributeCount; i7++) {
            String attributeName = parser.getAttributeName(i7);
            String attributeValue = parser.getAttributeValue(i7);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.x0(context, parser);
                this.f4658f.put(identifier, dVar);
                return;
            }
        }
    }

    public boolean b(int id, float width, float height) {
        int i7 = this.f4655c;
        if (i7 != id) {
            return true;
        }
        a aVarValueAt = id == -1 ? this.f4657e.valueAt(0) : this.f4657e.get(i7);
        int i8 = this.f4656d;
        return (i8 == -1 || !aVarValueAt.f4661b.get(i8).a(width, height)) && this.f4656d != aVarValueAt.b(width, height);
    }

    public void d(e constraintsChangedListener) {
        this.f4659g = constraintsChangedListener;
    }

    public void e(int id, float width, float height) {
        int iB;
        int i7 = this.f4655c;
        if (i7 == id) {
            a aVarValueAt = id == -1 ? this.f4657e.valueAt(0) : this.f4657e.get(i7);
            int i8 = this.f4656d;
            if ((i8 == -1 || !aVarValueAt.f4661b.get(i8).a(width, height)) && this.f4656d != (iB = aVarValueAt.b(width, height))) {
                d dVar = iB == -1 ? this.f4654b : aVarValueAt.f4661b.get(iB).f4670g;
                int i9 = iB == -1 ? aVarValueAt.f4662c : aVarValueAt.f4661b.get(iB).f4669f;
                if (dVar == null) {
                    return;
                }
                this.f4656d = iB;
                e eVar = this.f4659g;
                if (eVar != null) {
                    eVar.b(-1, i9);
                }
                dVar.r(this.f4653a);
                e eVar2 = this.f4659g;
                if (eVar2 != null) {
                    eVar2.a(-1, i9);
                    return;
                }
                return;
            }
            return;
        }
        this.f4655c = id;
        a aVar = this.f4657e.get(id);
        int iB2 = aVar.b(width, height);
        d dVar2 = iB2 == -1 ? aVar.f4663d : aVar.f4661b.get(iB2).f4670g;
        int i10 = iB2 == -1 ? aVar.f4662c : aVar.f4661b.get(iB2).f4669f;
        if (dVar2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + id + ", dim =" + width + ", " + height);
            return;
        }
        this.f4656d = iB2;
        e eVar3 = this.f4659g;
        if (eVar3 != null) {
            eVar3.b(id, i10);
        }
        dVar2.r(this.f4653a);
        e eVar4 = this.f4659g;
        if (eVar4 != null) {
            eVar4.a(id, i10);
        }
    }
}
