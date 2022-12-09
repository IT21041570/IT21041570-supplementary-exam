package com.example.it21041570supplementaryassessment.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.it21041570supplementaryassessment.Adapters.NotesAdapter;
import com.example.it21041570supplementaryassessment.Database.Constants;
import com.example.it21041570supplementaryassessment.Database.DatabaseHelper;
import com.example.it21041570supplementaryassessment.R;

public class ViewNotes extends Fragment {

    RecyclerView mRecyclerView;
    DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view_notes, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recylceView);
        databaseHelper = new DatabaseHelper(getActivity());

        showRercord();

        return view;
    }

    public void showRercord() {

        NotesAdapter adapter = new NotesAdapter(getActivity(), databaseHelper.getAllData(Constants.ID + " DESC"));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        showRercord();
    }

}