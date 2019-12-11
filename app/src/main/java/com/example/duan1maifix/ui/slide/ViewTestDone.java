package com.example.duan1maifix.ui.slide;

import com.example.duan1maifix.ui.question.Question;

import java.util.ArrayList;

public interface ViewTestDone {
    interface View {
        void setRefresh();

        void setResult();

    }

    interface Presenter {
        void checkResult(ArrayList<Question> arr_QuesBegin, int numNoAns, int numTrue, int numFalse);

        void checkRefresh(ArrayList<Question> arr_QuesBegin);

    }
}
