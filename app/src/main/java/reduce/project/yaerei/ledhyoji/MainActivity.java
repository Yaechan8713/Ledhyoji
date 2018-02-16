package reduce.project.yaerei.ledhyoji;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    int ikisakiokは行先表示の入力を許可するかどうかをジャッジするための整数。
//    int noikisakiは行先表示が入力されているかどうかをジャッジする整数。
//    int notraintypeは列車別が入力されているかをジャッジするための整数。

    int ikisakiok,noikisaki,notraintype,traintypenum,ikisakinum;

    ImageView traintype,ikisaki;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        traintype = (ImageView)findViewById(R.id.traintype);

        ikisaki = (ImageView)findViewById(R.id.ikisaki);

        ikisakiok = 0;

        traintypenum = R.drawable.outofservice;

        ikisakinum = R.drawable.noikisaki;

        noikisaki = 1;

        notraintype = 1;

    }

    public void snssend(int a,int b,int c,int d){

        intent = new Intent(this,snsActivity.class);
        intent.putExtra("traintypenum",a);
        intent.putExtra("notraintype",b);
        intent.putExtra("noikisaki",c);
        intent.putExtra("ikisakinum",d);
        startActivity(intent);

    }

    public void sns(View v){

        if(noikisaki == 0){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.error)
                    .setMessage(R.string.choicefrom)
                    .setPositiveButton(
                            R.string.ryoukai,

                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    noikisaki = 1;
                                }
                            }
                    ).show();
        }else{
            snssend(traintypenum,notraintype,noikisaki,ikisakinum);
        }
    }

    public void hyoji(){
        if(notraintype == 1){

            traintype.setImageResource(traintypenum);

            ikisaki.setImageDrawable(null);

            if(noikisaki == 0){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.error)
                        .setMessage(R.string.choicefrom)
                        .setPositiveButton(
                                R.string.ryoukai,

                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        noikisaki = 1;
                                    }
                                }
                        ).show();
            }

        }else if(notraintype == 0){

            traintype.setImageResource(traintypenum);

            if(noikisaki == 1){
                ikisakinum = R.drawable.noikisaki;
            }
            ikisaki.setImageResource(ikisakinum);

        }

    }

    public void limitedexpress(View v){
        notraintype = 0;
        traintypenum = R.drawable.limitedexpress;
        hyoji();
    }

    public void semilimitedexpress(View v){
        notraintype = 0;
        traintypenum = R.drawable.semilimitedexpress;
        hyoji();
    }

    public void express(View v){
        notraintype = 0;
        traintypenum = R.drawable.express;
        hyoji();
    }

    public void semiexpress(View v){
        notraintype = 0;
        traintypenum = R.drawable.semiexpress;
        hyoji();
    }

    public void rapid(View v){
        notraintype = 0;
        traintypenum = R.drawable.rapid;
        hyoji();
    }

    public void local(View v){
        notraintype = 0;
        traintypenum = R.drawable.local;
        hyoji();
    }

    public void extra(View v){
        traintypenum = R.drawable.extra;
        noikisakimethod();
    }

    public void outofsevice(View v){
        traintypenum = R.drawable.outofservice;
        noikisakimethod();
    }

    public void testrun(View v){
        traintypenum = R.drawable.testrun;
        noikisakimethod();
    }

    public void expressintoeishinjuku(View v){
        traintypenum = R.drawable.expressintoeisubwayshinjukuline;
        noikisakimethod();
    }

    public void localintoeishinjuku(View v){
        traintypenum = R.drawable.localintoeisubwayshinjukuline;
        noikisakimethod();
    }

    public void localfromshinjuku(View v){
        traintypenum = R.drawable.localfromshinjuku;
        noikisakimethod();
    }

    public void localfromtakahatafudo(View v){
        traintypenum = R.drawable.localfromtakahatafudo;
        noikisakimethod();
    }

    public void semilimitedexpressfromkitano(View v){
        traintypenum = R.drawable.semispecialexpressfromkitano;
        noikisakimethod();
    }

    public void limitedexpressfromkitano(View v){
        traintypenum = R.drawable.specialexpressfromkitano;
        noikisakimethod();
    }

    public void viathekeioline(View v){
        traintypenum = R.drawable.viathekeioline;
        noikisakimethod();
    }

    public void viathetoeishinjukuline(View v){
        traintypenum = R.drawable.viathetoeisubwayshinjukuline;
        noikisakimethod();
    }

    public void semilimitedexpressfromtakahatafudo(View v){
        traintypenum = R.drawable.semilimitedexpressfromtakahatafudo;
        noikisakimethod();
    }

    public void limitedexpressfromtakahatafudo(View v){
        traintypenum = R.drawable.limitedexpressfromtakahatafudo;
        noikisakimethod();
    }

    public void ikisakimethod(View v){
        intent = new Intent(this,ikisakiActivity.class);
        startActivity(intent);
        finish();
    }


    public void noikisakimethod(){
        notraintype = noikisaki = 1;
        hyoji();
    }

    public void iwamotocho(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.iwamotocho;
        hyoji();
    }

    public void ojima(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.ojima;
        hyoji();
    }

    public void motoyawata(View v) {
        noikisaki = 0;
        ikisakinum = R.drawable.motoyawata;
        hyoji();
    }

    public void keioinadazutsumi(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.keioinadazutsumi;
        hyoji();
    }

    public void mizue(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.mizue;
        hyoji();
    }

    public void takao(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.takao;
        hyoji();
    }

    public void shinjuku(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.shinjuku;
        hyoji();
    }

    public void sasazuka(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.sasazuka;
        hyoji();
    }

    public void sakurajosui(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.sakurajosui;
        hyoji();
    }

    public void hachimanyama(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.hachimanyama;
        hyoji();
    }

    public void tsutsujigaoka(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.tsutsujigaoka;
        hyoji();
    }

    public void chofu(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.chofu;
        hyoji();
    }

    public void tobitakyu(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.tobitakyu;
        hyoji();
    }

    public void higashifuchu(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.higashifuchu;
        hyoji();
    }

    public void fuchu(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.fuchu;
        hyoji();
    }

    public void takahatafudo(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.takahatafudo;
        hyoji();
    }

    public void kitano(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.kitano;
        hyoji();
    }

    public void keiohachioji(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.keiohachioji;
        hyoji();
    }

    public void shibuya(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.shibuya;
        hyoji();
    }

    public void meidaimae(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.meidaimae;
        hyoji();
    }

    public void eifukucho(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.eifukucho;
        hyoji();
    }

    public void fujimigaoka(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.fujimigaoka;
        hyoji();
    }

    public void kichijoji(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.kichijoji;
        hyoji();
    }

    public void wakabadai(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.wakabadai;
        hyoji();
    }

    public void keiotamacenter(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.keiotamacenter;
        hyoji();
    }

    public void minamiosawa(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.minamiosawa;
        hyoji();
    }

    public void hashimoto(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.hashimoto;
        hyoji();
    }

    public void fuchukeibaseimonmae(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.fuchukeibaseimonmae;
        hyoji();
    }

    public void tamadobutukoen(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.tamadobutsukoen;
        hyoji();
    }

    public void takaosanguchionsen(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.takaosanguchionsen;
        hyoji();
    }

    public void newlineshinjuku(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.newlineshinjuku;
        hyoji();
    }

    public void takaosanguchi(View v){
        noikisaki = 0;
        ikisakinum = R.drawable.takaosanguchi;
        hyoji();
    }

}
