package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mora_gamer=-1;
    String[] MoraString={"剪刀","石頭","布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText gamer=(EditText)findViewById(R.id.gamer);
        final TextView status=(TextView)findViewById(R.id.status);
        RadioButton v=(RadioButton)findViewById(R.id.v);
        RadioButton o=(RadioButton)findViewById(R.id.o);
        RadioButton w=(RadioButton)findViewById(R.id.w);
        final RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        Button play=(Button)findViewById(R.id.play);
        final TextView name=(TextView)findViewById(R.id.name);
        final TextView winner=(TextView)findViewById(R.id.winner);
        final TextView mymora=(TextView)findViewById(R.id.mymora);
        final TextView pcmora=(TextView)findViewById(R.id.pcmora);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.v:
                        mora_gamer = 0;
                        break;
                    case R.id.o:
                        mora_gamer = 1;
                        break;
                    case R.id.w:
                        mora_gamer = 2;
                        break;

                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gamer.getText().toString().equals(""))
                    status.setText("請輸入玩家名稱");
                else if(mora_gamer==-1)
                    status.setText("請選擇出拳的種類");
                else{
                    name.setText(gamer.getText());
                    mymora.setText(MoraString[mora_gamer]);
                    int mora_computer=(int)(Math.random()*3);
                    pcmora.setText(MoraString[mora_computer]);
                    if((mora_gamer==0 && mora_computer==1)||(mora_gamer==1 && mora_computer==2)||(mora_gamer==2 && mora_computer==0)){
                        winner.setText("電腦");
                        status.setText("可惜，電腦獲勝了");
                    }else if(mora_computer==mora_gamer){
                        winner.setText("平局");
                        status.setText("平局!在試一場看看");
                    }else{
                        winner.setText(gamer.getText());
                        status.setText("恭喜你獲勝了");
                    }
                }
            }
        });
    }
}
