package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.MessageBeen;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.adapter.b;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.presenter.f;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class MessageActivity extends BaseListActivity<MessageBeen> implements d<MessageBeen, b> {
    private com.haier.globalwasher.mvp_api.adapter.a<MessageBeen, b> C;
    XListView E;
    Resources F;
    private f B = new f();
    private ArrayList<MessageBeen> D = new ArrayList<>();
    private int G = 0;

    class a extends BaseListActivity<MessageBeen>.a {

        /* JADX INFO: renamed from: com.haier.globalwasher.view.activity.my_page.MessageActivity$a$a, reason: collision with other inner class name */
        class C0335a implements AdapterView.OnItemClickListener {
            C0335a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                int i8 = i7 - 1;
                MessageActivity.this.G = i8;
                Intent intent = new Intent(MessageActivity.this, (Class<?>) WebActivity.class);
                Bundle bundle = new Bundle();
                if (i8 < 0 || i7 > MessageActivity.this.D.size()) {
                    return;
                }
                bundle.putString("title", (((MessageBeen) MessageActivity.this.D.get(i8)).getTittle() == null || "".equals(((MessageBeen) MessageActivity.this.D.get(i8)).getTittle())) ? MessageActivity.this.F.getString(R.string.my_page_message) : ((MessageBeen) MessageActivity.this.D.get(i8)).getTittle());
                HashMap map = new HashMap();
                map.put(y.f25408f, ((MessageBeen) MessageActivity.this.D.get(i8)).getId() + "");
                String str = i2.a.C1;
                try {
                    int i9 = 0;
                    for (String str2 : com.haier.globalwasher.modle.network.a.m(map, "message.queryAppMessageById").keySet()) {
                        if (str2.equals("tokenId") || str2.equals("appId") || str2.equals("timestamp") || str2.equals("nonce") || str2.equals("method") || str2.equals("format") || str2.equals("charset") || str2.equals("version") || str2.equals("country") || str2.equals("language") || str2.equals("bizcontent") || str2.equals("outAccess") || str2.equals("sign") || str2.equals("timeZone")) {
                            i9++;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(i9 == 1 ? "?" : m0.a.f37445e);
                            str = sb.toString() + str2 + "=" + ((String) map.get(str2));
                            q.c("RequestNetWork", "key=" + str2 + "--map.get(key)=" + ((String) map.get(str2)));
                        }
                    }
                    q.c("RequestNetWork", "" + str);
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
                bundle.putInt(y.f25409g, 1008);
                bundle.putString(y.f25407e, str);
                intent.putExtra(y.f25405c, bundle);
                MessageActivity.this.startActivityForResult(intent, 1008);
            }
        }

        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<MessageBeen> arrayList) {
            MessageActivity.this.D = arrayList;
            if (MessageActivity.this.C != null) {
                MessageActivity.this.C.notifyDataSetChanged();
                return;
            }
            MessageActivity messageActivity = MessageActivity.this;
            MessageActivity messageActivity2 = MessageActivity.this;
            messageActivity.C = new com.haier.globalwasher.mvp_api.adapter.a(messageActivity2, messageActivity2.D, MessageActivity.this);
            MessageActivity messageActivity3 = MessageActivity.this;
            messageActivity3.E.setAdapter((ListAdapter) messageActivity3.C);
            MessageActivity.this.E.setOnItemClickListener(new C0335a());
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_message;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.B;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        Resources resources = getResources();
        this.F = resources;
        d0(resources.getString(R.string.my_page_message), 1, new View[0]);
        n0(true);
        this.E = (XListView) findViewById(R.id.xlv);
        V(getResources().getString(R.string.no_message_msg));
        return this.E;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        q.c("WebFragment", "onActivityResult--requestCode" + i7 + "  resultCode" + i8);
        if (i7 != 1008) {
            return;
        }
        this.D.get(this.G).setReadFlag("1");
        this.C.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.B.g(i8, i7, "1", new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, b bVar, MessageBeen messageBeen) {
        bVar.b(R.id.tv_time, R.id.iv_read_tag, R.id.tv_content);
        TextView textView = (TextView) bVar.a(R.id.tv_time);
        TextView textView2 = (TextView) bVar.a(R.id.tv_content);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_read_tag);
        textView.setText(messageBeen.getModifiedDate());
        textView2.setText(messageBeen.getSynopsis());
        if (messageBeen.getReadFlag().equals("1")) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public b x(int i7, ViewGroup viewGroup) {
        return new b(this, View.inflate(this, R.layout.message_item, null), 1);
    }
}
