package com.example.duan1maifix.ui.slide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1maifix.MainActivity;
import com.example.duan1maifix.R;

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Giới Thiệu");

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.about_fragment, container, false);
        return viewGroup;
    }
}
