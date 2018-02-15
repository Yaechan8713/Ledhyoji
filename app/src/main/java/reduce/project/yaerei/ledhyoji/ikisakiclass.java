package reduce.project.yaerei.ledhyoji;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yaerei on 2018/02/01.
 */

public class ikisakiclass extends AppCompatActivity {

    //    traintypeは列車別を表示するImageView
//    trainfromは行先を表示するImageView
    ImageView traintype, trainfrom;

    int inputtypejapanese, inputtypeenglish;

    private CountUPTimertask timerTask;

    int num, noikisakinum,k,tc;

    int traintypenum,trainfromnum;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikisaki_main);

//    traintypeは列車別を表示するImageView
//    trainfromは行先を表示するImageView
        traintype = (ImageView) findViewById(R.id.traintypeikisaki);
        trainfrom = (ImageView) findViewById(R.id.trainfrom);

        num = -10;
        tc = k = noikisakinum = 0;

        traintypenum = trainfromnum = 0;

//        noikisakinum = R.drawable.noikisaki;

    }

    public void limitedexpress(View v) {
//        特急表示
        hyoji(1, R.drawable.limitedexpressenglish, R.drawable.limitedexpressjapanese, noikisakinum, noikisakinum);
    }

    public void semilimitedexpress(View v) {
//        準特急表示
        hyoji(1, R.drawable.semilimitedexpressenglish, R.drawable.semilimitedexpressjapanese, noikisakinum, noikisakinum);
    }

    public void express(View v) {
//        急行表示
        hyoji(1, R.drawable.expressenglish, R.drawable.expressjapanese, noikisakinum, noikisakinum);
    }

    public void semiexpress(View v) {
//        区間急行表示
        hyoji(1, R.drawable.semiexpressenglish, R.drawable.semiexpressjapanese, noikisakinum, noikisakinum);
    }

    public void rapid(View v) {
//        快速表示
        hyoji(1, R.drawable.rapidenglish, R.drawable.rapidjapanese, noikisakinum, noikisakinum);
    }

    public void local(View v) {
//        各駅停車表示
        hyoji(1, R.drawable.localenglish, R.drawable.localjapanese, noikisakinum, noikisakinum);
    }

    public void outofservice(View v) {
//        回送表示
        hyoji(0, R.drawable.outofserviceenglish, R.drawable.outofservicejapanese, 0, 0);
    }

    public void testrun(View v) {
//        試運転表示
        hyoji(0, R.drawable.testrunenglish, R.drawable.testrunjapanese, 0, 0);
    }

    public void extra(View v) {
//        臨時表示
        hyoji(0, R.drawable.extraenglish, R.drawable.extrajapanese, 0, 0);
    }


    public void ikisaki(int english, int japanese) {
//        行先処理メソッド
        hyoji(1, inputtypeenglish, inputtypejapanese, english, japanese);
    }

    public void chofu(View v) {
//        調布行き表示
        ikisaki(R.drawable.chofuenglish, R.drawable.chofujapanese);
    }

    public void eifukucho(View v) {
//        永福町行き表示
        ikisaki(R.drawable.eifukuchoenglish, R.drawable.eifukuchojapanese);
    }

    public void fuchu(View v) {
//        府中行き表示
        ikisaki(R.drawable.fuchuenglishi, R.drawable.fuchujapanese);
    }

    public void fuchukeibaseimonmae(View v) {
//        府中競馬正門前行き表示
        ikisaki(R.drawable.fuchukeibaseimonmaeenglish, R.drawable.fuchukeibaseimonmaejapanese);
    }

    public void fujimigaoka(View v) {
//        富士見ヶ丘行き表示
        ikisaki(R.drawable.fujimigaokaenglish, R.drawable.fujimigaokajapanese);
    }

    public void hachimanyama(View v) {
//        八幡山行き表示
        ikisaki(R.drawable.hachimanyamaenglish, R.drawable.hachimanyamajapanese);
    }

    public void hashimoto(View v) {
//        橋本行き表示
        ikisaki(R.drawable.hashimotoenglish, R.drawable.hashimotojapanese);
    }

    public void higashifuchu(View v) {
//        東府中行き表示
        ikisaki(R.drawable.higashifuchuenglish, R.drawable.higashifuchujapanese);
    }

    public void iwamotocho(View v) {
//        岩本町行き表示
        ikisaki(R.drawable.iwamotochoenglish, R.drawable.iwamotochojapanese);
    }

    public void keiohachioji(View v) {
//        京王八王子行き表示
        ikisaki(R.drawable.keiohachiojienglishi, R.drawable.keiohachiojijapanese);
    }

    public void keioinadazutsumi(View v) {
//        京王稲田堤行き表示
        ikisaki(R.drawable.keioinadazutsumienglish, R.drawable.keioinadazutsumijapanese);
    }

    public void shinjuku(View v) {
//        (京王線)新宿行き表示
        ikisaki(R.drawable.shinjukuenglish, R.drawable.keiolineshinjukujapanese);
    }

    public void keiotamacenter(View v) {
//        京王多摩センター行き表示
        ikisaki(R.drawable.keiotamacenterenglish, R.drawable.keiotamacenterjapanese);
    }

    public void kichijoji(View v) {
//        吉祥寺行き表示
        ikisaki(R.drawable.kichijojienglish, R.drawable.kichijojijapanese);
    }

    public void kitano(View v) {
//        北野行き表示
        ikisaki(R.drawable.kitanoenglish, R.drawable.kitanojapanese);
    }

    public void meidaimae(View v) {
//        明大前行き表示
        ikisaki(R.drawable.meidaimaeenglish, R.drawable.meidaimaejapanese);
    }

    public void minamiosawa(View v) {
//        南大沢行き表示
        ikisaki(R.drawable.minamiosawaenglish, R.drawable.minamiosawajapanese);
    }

    public void mizue(View v) {
//        瑞江行き表示
        ikisaki(R.drawable.mizueenglish, R.drawable.mizuejapanese);
    }

    public void motoyawata(View v) {
//        本八幡行き表示
        ikisaki(R.drawable.motoyawataenglish, R.drawable.motoyawatajaoanese);
    }

    public void newlineshinjuku(View v) {
//        (新線)新宿行き表示
        ikisaki(R.drawable.shinjukuenglish, R.drawable.newlineshinjukujapanese);
    }

    public void ojima(View v) {
//        大島行き表示
        ikisaki(R.drawable.ojimaenglish, R.drawable.ojimajapanese);
    }

    public void sakurajosui(View v) {
//        桜上水行き表示
        ikisaki(R.drawable.sakurajosuienglish, R.drawable.sakurajosuijapanese);
    }

    public void sasazuka(View v) {
//        笹塚行き表示
        ikisaki(R.drawable.sasazukaenglish, R.drawable.sasazukajapanese);
    }

    public void shibuya(View v) {
//        渋谷行き表示
        ikisaki(R.drawable.shibuyaenglish, R.drawable.shibuyajapanese);
    }

    public void takahatafudo(View v) {
//        高幡不動行き表示
        ikisaki(R.drawable.takahatafudoenglish, R.drawable.takahatafudojapanese);
    }

    public void takao(View v) {
//        高尾行き表示
        ikisaki(R.drawable.takaoenglish, R.drawable.takaojapanese);
    }

    public void takaosanguchi(View v) {
//        高尾山口行き(温泉マークなし)表示
        ikisaki(R.drawable.takaosanguchienglish, R.drawable.takaosanguchijapanese);
    }

    public void takaosanguchionsen(View v) {
//        高尾山口行き(温泉マークあり)表示
        ikisaki(R.drawable.takaosanguchienglish, R.drawable.takaosanguchijapaneseonsen);
    }

    public void tamadobutukoen(View v) {
//        多摩動物公園行き表示
        ikisaki(R.drawable.tamadobutukoennenglish, R.drawable.tamadobutukoennjapanese);
    }

    public void tobitakyu(View v) {
//        飛田給行き表示
        ikisaki(R.drawable.tobitakyuenglish, R.drawable.tobitakyujapanese);
    }

    public void tsutsujigaoka(View v) {
//        つつじヶ丘行き表示
        ikisaki(R.drawable.tsutsujigaokaenglish, R.drawable.tsutsujigaokajapanese);
    }

    public void wakabadai(View v) {
//        若葉台行き表示
        ikisaki(R.drawable.wakabadaienglish, R.drawable.wakabadaijapanese);
    }

    public void snssend(int a, int b, int c, int d) {
//        snsActivityに整数を送る処理
        intent = new Intent(this, snsActivity.class);
        intent.putExtra("traintypenum", a);
        intent.putExtra("notraintype", b);
        intent.putExtra("noikisaki", c);
        intent.putExtra("ikisakinum", d);
        startActivity(intent);
    }

    public void sns(View v){
        int a,b;
        a = b= 0;
        if(traintypenum == 0){
            a = 1;
        }
        if(trainfromnum == 0){
            b = 1;
        }
        snssend(traintypenum,a,b,trainfromnum);
    }


    // traintypejudge = 0は列車別のみ表示。
    // traintypejudge = 1は列車別と行先を表示。
    // englishtypetrain = R.drawable.(英語版列車別素材データ)は英語版列車別素材データが選択されている状態。
    // japanesetypetrain = R.drawable.(日本語版列車別素材データ)は日本語版列車別素材データが選択されている状態。
    // ※「回送」や「試運転」表示も列車別素材データとする。
    // englishtrainfrom = 0とjapanesefrom = 0は行先が選択されていない状態。
    // englishtrainfrom = R.drawable.(行先素材データ)は行先素材データが選択されている状態。

    public void hyoji(int traintypejudge, int englishtypetrain, int japanesetypetrain, int englishtrainfrom, int japanesefrom) {
        //素材を表示

        //列車別を表示

        if (traintypejudge == 0) {
//            列車別のみ表示の場合
            hyouji2(englishtypetrain, japanesetypetrain, num, num);
        } else {

            if (englishtrainfrom == 0 || japanesefrom == 0) {
                //行先が選択されていない場合
                englishtrainfrom = japanesefrom = R.drawable.noikisaki;
            }
            hyouji2(englishtypetrain, japanesetypetrain, englishtrainfrom, japanesefrom);
        }

        inputtypeenglish = englishtypetrain;
        inputtypejapanese = japanesetypetrain;
    }

    public void hyouji2(int englishtypetrain, int japanesetypetrain, int englishtrainfrom, int japanesefrom) {
        for (int t = 0; t < 10; t++) {

            int i = 0;

            k = 0;

            for (k = 0; k < 3; k++) {

                if (k == 0) {
                    //日本語列車別表示
                    i = japanesetypetrain;
                } else {
                    //英語列車別表示
                    i = englishtypetrain;
                }

                if(i == 0){
                    if(k == 0) {
                        i = R.drawable.outofservicejapanese;
                    }else{
                        i = R.drawable.outofserviceenglish;
                    }
                }

                int it;

                if (englishtrainfrom == num && japanesefrom == num) {
                    it = 0;
                } else {

                    if (k == 0) {
                        //日本語行先表示
                        it = japanesefrom;
                    } else {
                        //英語行先表示
                        it = englishtrainfrom;
                    }
                }

                train(i,it);

//                Timer生成のコード
                Timer timer = new Timer();
                timer.schedule(timerTask,0,5);

            }

            if (t == 9) {
                t = 0;
            }

        }

    }

    public void train(int a,int b){
        traintype.setImageResource(a);
        if(b == 0){
            trainfrom.setImageDrawable(null);
            b = -1;
        }else {
            trainfrom.setImageResource(b);
        }

        traintypenum = a;
        trainfromnum = b;
    }

    class CountUPTimertask extends TimerTask{

        @Override
        public void run(){

            //時間のカウントコード
            if(k == 0){
                k = 1;
            }else{
                k = 0;
            }

        }

    }

}
