package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4031b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4032c = "CustomMethod";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4033d = "CustomAttribute";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static HashMap<String, Constructor<? extends f>> f4034e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f4035f = "KeyFrames";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Integer, ArrayList<f>> f4036a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends f>> map = new HashMap<>();
        f4034e = map;
        try {
            map.put("KeyAttribute", g.class.getConstructor(new Class[0]));
            f4034e.put("KeyPosition", j.class.getConstructor(new Class[0]));
            f4034e.put("KeyCycle", h.class.getConstructor(new Class[0]));
            f4034e.put("KeyTimeCycle", l.class.getConstructor(new Class[0]));
            f4034e.put("KeyTrigger", m.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e8) {
            Log.e(f4035f, "unable to load", e8);
        }
    }

    public i() {
    }

    static String f(int viewId, Context context) {
        return context.getResources().getResourceEntryName(viewId);
    }

    public void a(o motionController) {
        ArrayList<f> arrayList = this.f4036a.get(-1);
        if (arrayList != null) {
            motionController.b(arrayList);
        }
    }

    public void b(o motionController) {
        ArrayList<f> arrayList = this.f4036a.get(Integer.valueOf(motionController.f4155c));
        if (arrayList != null) {
            motionController.b(arrayList);
        }
        ArrayList<f> arrayList2 = this.f4036a.get(-1);
        if (arrayList2 != null) {
            for (f fVar : arrayList2) {
                if (fVar.g(((ConstraintLayout.LayoutParams) motionController.f4154b.getLayoutParams()).f4523c0)) {
                    motionController.a(fVar);
                }
            }
        }
    }

    public void c(f key) {
        if (!this.f4036a.containsKey(Integer.valueOf(key.f3973b))) {
            this.f4036a.put(Integer.valueOf(key.f3973b), new ArrayList<>());
        }
        ArrayList<f> arrayList = this.f4036a.get(Integer.valueOf(key.f3973b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<f> d(int id) {
        return this.f4036a.get(Integer.valueOf(id));
    }

    public Set<Integer> e() {
        return this.f4036a.keySet();
    }

    public i(Context context, XmlPullParser parser) {
        Exception e8;
        f fVarNewInstance;
        HashMap<String, androidx.constraintlayout.widget.a> map;
        HashMap<String, androidx.constraintlayout.widget.a> map2;
        try {
            int eventType = parser.getEventType();
            f fVar = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && z.f4332z.equals(parser.getName())) {
                        return;
                    }
                } else {
                    String name = parser.getName();
                    if (f4034e.containsKey(name)) {
                        try {
                            Constructor<? extends f> constructor = f4034e.get(name);
                            if (constructor != null) {
                                fVarNewInstance = constructor.newInstance(new Object[0]);
                                try {
                                    fVarNewInstance.f(context, Xml.asAttributeSet(parser));
                                    c(fVarNewInstance);
                                } catch (Exception e9) {
                                    e8 = e9;
                                    Log.e(f4035f, "unable to create ", e8);
                                }
                                fVar = fVarNewInstance;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception e10) {
                            f fVar2 = fVar;
                            e8 = e10;
                            fVarNewInstance = fVar2;
                        }
                        Log.e(f4035f, "unable to create ", e8);
                        fVar = fVarNewInstance;
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (fVar != null && (map2 = fVar.f3976e) != null) {
                            androidx.constraintlayout.widget.a.q(context, parser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && fVar != null && (map = fVar.f3976e) != null) {
                        androidx.constraintlayout.widget.a.q(context, parser, map);
                    }
                }
                eventType = parser.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }
}
