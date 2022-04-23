package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ReadingListFragment extends Fragment {

    public static int num;
    public static String status;
    public static ArrayList<ListItem> progressList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public static ListAdapter adapter;

    public ReadingListFragment() {
        // Required empty public constructor
    }

    public static ReadingListFragment newInstance(String param1, String param2) {
        ReadingListFragment fragment = new ReadingListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reading_list, container, false);

        recyclerView = rootView.findViewById(R.id.list_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new ListAdapter(progressList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener (new ListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                num = position;
                status = progressList.get(position).getCurrStatus();

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new EditDataFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}