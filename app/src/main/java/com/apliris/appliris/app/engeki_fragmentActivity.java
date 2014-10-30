package com.apliris.appliris.app;

import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class engeki_fragmentActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View v = inflater.inflate(R.layout.fragment_engeki, container, false);
        TextView title = (TextView) v.findViewById(R.id.title);
        ImageView image = (ImageView) v.findViewById(R.id.picture);
        TextView honbun = (TextView) v.findViewById(R.id.honbun);
        switch(bundle.getInt("position")) {
            case 0:
                title.setText("The industrial soul");
                image.setImageResource(R.drawable.engeki_m);
                honbun.setText("長岡高専は変わってしまった。生徒は工業への情熱を失い、入学者は徐々に減っていき、5つあった学科は1つを残して全てとり潰された。残された学科は、「機械工学科」だった。その後まもなくして、長岡高専は国から廃校を言い渡される。廃校を回避するたった一つの条件は、「『全国工業高等専門学校工業加工技術大会』で優勝すること」だった。しかしそんな絶望の最中、卓越した加工技術を持つ主人公、鉄 鋼太郎が機械工学科に転校してくる。鋼太郎ら機械工学科は廃校の危機から長岡高専を救うため、全国の高専に戦いを挑むのであった。\n\n場所：第一体育館\n上演時間：11月 1日(土) 10：00～11：00");
                break;
            case 1:
                title.setText("college order club");
                image.setImageResource(R.drawable.engeki_ee);
                honbun.setText("Androidというと皆さんは、スマホのOSをイメージされる方が多いでしょう。ですが、本来は、人造人間のことを指す用語です。今回は、そんな人造人間と人間とのお話です。\n\n場所：第一体育館\n上演時間：11月 1日(土) 11：15～12：15");
                break;
            case 2:
                title.setText("コンティニュー？");
                image.setImageResource(R.drawable.engeki_ci);
                honbun.setText("ヤンチャな男子3人組がテストを盗み出すために奮闘する物語です．笑いあり感動ありのストーリーで，大人より学生の方が共感できるかも！\n学年関係なく仲の良い環境都市工学科が一丸となってつくり上げる演劇を，是非見に来てください！\n\n場所：第一体育館\n上演時間：11月 1日(土) 13：30～14：30");
                break;
            case 3:
                title.setText("天才少年と未来少女");
                image.setImageResource(R.drawable.engeki_ec);
                honbun.setText("周囲を見下して生きている，その辺にいそうな『極普通』の天才少年の前に現れたのは，その辺にいそうな『極普通』の自称未来人の少女．発展しきった世界．人間の腐った心．時を渡る少女．知能と苦悩．世界に存在してはいけないモノ． 少年は何を得て何を捨てるのか．本当に大切なモノを知る物語\n3連覇します．\n\n場所：第一体育館\n上演時間：11月 1日(土) 14：45～15：45");
                break;
            case 4:
                title.setText("高校期");
                image.setImageResource(R.drawable.engeki_mb);
                honbun.setText("誰もが経験した青春時代。幼馴染の3人は高校進学を機に少しずつ距離を持つようになる。すれ違う友情の結末は．．．\n\n場所：第一体育館\n上演時間：11月 1日(土) 16：00～17：00");
                break;

        }
        return v;

    }
}