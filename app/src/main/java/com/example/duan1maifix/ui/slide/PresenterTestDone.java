package com.example.duan1maifix.ui.slide;

import com.example.duan1maifix.ui.question.Question;

import java.util.ArrayList;

public class PresenterTestDone implements ViewTestDone.Presenter {
    private ViewTestDone.View view;



    public PresenterTestDone(ViewTestDone.View view) {
        this.view = view;
    }



    //PT Check kết quả
    @Override
    public void checkResult(ArrayList<Question> arr_QuesBegin, int numNoAns, int numTrue, int numFalse) {
        for (int i = 0; i < arr_QuesBegin.size(); i++) {
            if (arr_QuesBegin.get(i).getTraloi().equals("") == true) {
                numNoAns++;
            } else if (arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi()) == true) {
                numTrue++;
            } else numFalse++;
        }
        view.setResult();

    }

    @Override
    public void checkRefresh(ArrayList<Question> arr_QuesBegin) {
        for (int i = 0; i < arr_QuesBegin.size(); i++) {
            arr_QuesBegin.get(i).setTraloi("");
        }
        view.setRefresh();
    }
}
