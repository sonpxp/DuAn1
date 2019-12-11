package com.example.duan1maifix.ui.slide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1maifix.R;
import com.example.duan1maifix.ui.question.DBHelper;
import com.example.duan1maifix.ui.question.Question;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity implements ViewTestDone.View {
    ArrayList<Question> arr_QuesBegin = new ArrayList<Question>();
    PresenterTestDone presenterTestDone;

    int numNoAns = 0;
    int numTrue = 0;
    int numFalse = 0;
    int totalScore = 0;
    DBHelper dbHelper;
//    ScoreController scoreController;

    TextView tvTrue, tvFalse, tvNotAns, tvTotalScore;
    Button btnSaveScore, btnAgain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);
//        scoreController = new ScoreController(TestDoneActivity.this);
        dbHelper = new DBHelper(TestDoneActivity.this);
        final Intent intent = getIntent();
        presenterTestDone = new PresenterTestDone(this);
        arr_QuesBegin = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        presenterTestDone.checkResult(arr_QuesBegin, numNoAns, numTrue, numFalse);
        totalScore = numTrue * 10;
        tvNotAns.setText("" + numNoAns);
        tvFalse.setText("" + numFalse);
        tvTrue.setText("" + numTrue);
        tvTotalScore.setText("" + totalScore);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.show();
            }
        });

        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater = TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.allert_dialog_save_score, null);
                builder.setView(view);

                final EditText edtName = (EditText) view.findViewById(R.id.edtName);
                final EditText edtRoom = (EditText) view.findViewById(R.id.edtRoom);
                TextView tvScore = (TextView) view.findViewById(R.id.tvScore);
                final int numTotal = numTrue * 10;
                tvScore.setText(numTotal + " điểm");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edtName.getText().toString();
                        String room = edtRoom.getText().toString();
                        dbHelper.insertScore(name, numTotal, room);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công!", Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog b = builder.create();
                b.show();
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterTestDone.checkRefresh(arr_QuesBegin);

                finish();
                Intent intent2 = new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent2.putExtra("arr_Ques", arr_QuesBegin);
                intent2.putExtra("test", "no");
                startActivity(intent2);
            }
        });
    }

//    public void refresh() {
//        for (int i = 0; i < arr_QuesBegin.size(); i++) {
//            arr_QuesBegin.get(i).setTraloi("");
//        }
//    }

    public void begin() {
        tvFalse = (TextView) findViewById(R.id.tvFalse);
        tvTrue = (TextView) findViewById(R.id.tvTrue);
        tvNotAns = (TextView) findViewById(R.id.tvNotAns);
        tvTotalScore = (TextView) findViewById(R.id.tvTotalPoint);
        btnAgain = (Button) findViewById(R.id.btnAgain);
        btnSaveScore = (Button) findViewById(R.id.btnSaveScore);
        btnExit = (Button) findViewById(R.id.btnExit);
    }

    @Override
    public void setRefresh() {

    }

    @Override
    public void setResult() {

    }

    //PT Check kết quả
//    public void checkResult() {
//        for (int i = 0; i < arr_QuesBegin.size(); i++) {
//            if (arr_QuesBegin.get(i).getTraloi().equals("") == true) {
//                numNoAns++;
//            } else if (arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi()) == true) {
//                numTrue++;
//            } else numFalse++;
//        }
//    }
}

