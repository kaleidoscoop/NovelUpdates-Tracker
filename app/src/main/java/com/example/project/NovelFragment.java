package com.example.project;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NovelFragment extends DialogFragment {
    TextView txtName;
    TextView txtAlt;
    TextView txtAuthor;
    TextView txtChap;
    TextView txtDescrip;

    public NovelFragment() {
        // Required empty public constructor
    }

    public static NovelFragment newInstance(String param1, String param2) {
        NovelFragment fragment = new NovelFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_novel, container, false);
        txtName = rootView.findViewById(R.id.txtName);
        txtAlt = rootView.findViewById(R.id.txtAlt);
        txtAuthor = rootView.findViewById(R.id.txtAuthor);
        txtChap = rootView.findViewById(R.id.numChap);
        txtDescrip = rootView.findViewById(R.id.txtDescription);

        txtName.setText(SearchFragment.novelData.get(SearchFragment.num).getName());
        txtAlt.setText((SearchFragment.novelData.get(SearchFragment.num).getNameAlt()));
        txtAuthor.setText(SearchFragment.novelData.get(SearchFragment.num).getAuthor());
        if (SearchFragment.novelData.get(SearchFragment.num).getNumSide() != null)
            txtChap.setText(String.format("%s • %s Chapters + %s Extras", SearchFragment.novelData.get(SearchFragment.num).getStatus(), SearchFragment.novelData.get(SearchFragment.num).getNumChap(),SearchFragment.novelData.get(SearchFragment.num).getNumSide()));
        else {
            txtChap.setText(String.format("%s • %s Chapters", SearchFragment.novelData.get(SearchFragment.num).getStatus(), SearchFragment.novelData.get(SearchFragment.num).getNumChap()));
        }
        txtDescrip.setText(SearchFragment.novelData.get(SearchFragment.num).getDescrip());

        Button btnBack = (Button) rootView.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        Button btnAdd = (Button) rootView.findViewById(R.id.btnAdd);

//        btnAdd.setEnabled();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = (String) SearchFragment.novelData.get(SearchFragment.num).getName();
                String author = (String) SearchFragment.novelData.get(SearchFragment.num).getAuthor();
                int numChap = Integer.valueOf(SearchFragment.novelData.get(SearchFragment.num).getNumChap());
                ListItem item = new ListItem(name, author, 0, numChap, "Currently Reading", 0);
                Toast.makeText(getActivity(), "Novel added to Library", Toast.LENGTH_SHORT).show();

                if (ReadingListFragment.progressList.isEmpty()) {
                    ReadingListFragment.progressList.add(0, item);
                    ReadingListFragment.adapter.notifyDataSetChanged();
                    dismiss();
                }
                else {
                    for (int i = 0; i < ReadingListFragment.progressList.size(); i++) {
                        if (!item.getListName().equals(ReadingListFragment.progressList.get(ReadingListFragment.num).getListName())) {
                            ReadingListFragment.progressList.add(0, item);
                            ReadingListFragment.adapter.notifyDataSetChanged();
                            Toast.makeText(getActivity(), "Novel added to Library", Toast.LENGTH_SHORT).show();
                            dismiss();
                        }
                    }
                }
            }
        });
        return rootView;
    }
}