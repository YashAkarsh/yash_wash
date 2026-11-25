package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.widget.u;
import c.g1;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2082f = "BrowserActionskMenuUi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f2084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<androidx.browser.browseractions.a> f2085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c f2086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.browser.browseractions.c f2087e;

    class a implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2088a;

        a(View view) {
            this.f2088a = view;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            d.this.f2086d.a(this.f2088a);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f2090a;

        b(TextView textView) {
            this.f2090a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (u.k(this.f2090a) == Integer.MAX_VALUE) {
                this.f2090a.setMaxLines(1);
                this.f2090a.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.f2090a.setMaxLines(Integer.MAX_VALUE);
                this.f2090a.setEllipsize(null);
            }
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    interface c {
        void a(View view);
    }

    d(Context context, Uri uri, List<androidx.browser.browseractions.a> list) {
        this.f2083a = context;
        this.f2084b = uri;
        this.f2085c = list;
    }

    private BrowserActionsFallbackMenuView b(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(R.id.browser_actions_menu_view);
        TextView textView = (TextView) view.findViewById(R.id.browser_actions_header_text);
        textView.setText(this.f2084b.toString());
        textView.setOnClickListener(new b(textView));
        ListView listView = (ListView) view.findViewById(R.id.browser_actions_menu_items);
        listView.setAdapter((ListAdapter) new androidx.browser.browseractions.b(this.f2085c, this.f2083a));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void a() {
        View viewInflate = LayoutInflater.from(this.f2083a).inflate(R.layout.browser_actions_context_menu_page, (ViewGroup) null);
        androidx.browser.browseractions.c cVar = new androidx.browser.browseractions.c(this.f2083a, b(viewInflate));
        this.f2087e = cVar;
        cVar.setContentView(viewInflate);
        if (this.f2086d != null) {
            this.f2087e.setOnShowListener(new a(viewInflate));
        }
        this.f2087e.show();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    void c(c cVar) {
        this.f2086d = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
        try {
            this.f2085c.get(i7).a().send();
            this.f2087e.dismiss();
        } catch (PendingIntent.CanceledException e8) {
            Log.e(f2082f, "Failed to send custom item action", e8);
        }
    }
}
