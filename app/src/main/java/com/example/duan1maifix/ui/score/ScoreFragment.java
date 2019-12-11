package com.example.duan1maifix.ui.score;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1maifix.MainActivity;
import com.example.duan1maifix.R;
import com.example.duan1maifix.ui.question.DBHelper;

public class ScoreFragment extends Fragment {
    ListView lvScore;
//    ScoreController scoreController;
    ScoreAdapter scoreAdapter;
    DBHelper dbHelper;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách điểm");
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHelper = new DBHelper(getActivity());
        lvScore = (ListView) getActivity().findViewById(R.id.lvScore);
        Cursor cursor = dbHelper.getScore();
        scoreAdapter = new ScoreAdapter(getActivity(), cursor, true);
        lvScore.setAdapter(scoreAdapter);
    }
}
