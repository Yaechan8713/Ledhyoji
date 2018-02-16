package reduce.project.yaerei.ledhyoji;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by yaerei on 2018/02/04.
 */

public class snsActivity extends AppCompatActivity {

    ImageView imageview,typeimage;

    Intent intent;
    int traintypenum,notraintype,noikisaki,ikisakinum;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snspicture_main);

        typeimage = (ImageView)findViewById(R.id.traintypeimage);//列車別
        imageview = (ImageView)findViewById(R.id.forimageview);//行先

        intent = getIntent();
        traintypenum = intent.getIntExtra("traintypenum",0);
        notraintype = intent.getIntExtra("notraintype",0);
        noikisaki = intent.getIntExtra("noikisaki",0);
        ikisakinum = intent.getIntExtra("ikisakinum",0);

        if(notraintype == 1){

            imageview.setImageDrawable(null);

            if(noikisaki == 0) {

                new AlertDialog.Builder(snsActivity.this)
                        .setTitle("エラー")
                        .setMessage("列車別が選択されていないため、「回送」表示します。")
                        .setPositiveButton(
                                R.string.ryoukai,

                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        traintypenum = R.drawable.outofservice;
                                    }
                                }
                        ).show();
            }

            typeimage.setImageResource(traintypenum);


        }else if(notraintype == 0){
            typeimage.setImageResource(traintypenum);

            if(noikisaki == 1){
                ikisakinum = R.drawable.noikisaki;
            }
            imageview.setImageResource(ikisakinum);
        }

    }

}
