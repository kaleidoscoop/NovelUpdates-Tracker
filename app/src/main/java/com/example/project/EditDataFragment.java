package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresPermission;
import androidx.fragment.app.DialogFragment;

import org.w3c.dom.Text;

public class EditDataFragment extends DialogFragment {
    Button btnCancel;
    Button btnSave;
    TextView txtName;
    TextView txtAuthor;
    TextView txtStatus;
    Button btnReading;
    Button btnCompleted;
    Button btnPTR;
    Button btnHold;
    Button btnDrop;
    NumberPicker numberPicker;
    NumberPicker numberPickerScore;
    Button btnDelete;

    private int numRead;
    private String status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.edit_data, container, false);

        numberPicker = (NumberPicker) rootView.findViewById(R.id.numberPicker);
        numberPickerScore = (NumberPicker) rootView.findViewById(R.id.numberPickerScore);
        txtName = (TextView) rootView.findViewById(R.id.txtDataName);
        txtAuthor = (TextView) rootView.findViewById(R.id.txtDataAuthor);
        txtStatus = (TextView) rootView.findViewById(R.id.txtCurrStatus);

        txtName.setText(ReadingListFragment.progressList.get(ReadingListFragment.num).getListName());
        txtAuthor.setText(ReadingListFragment.progressList.get(ReadingListFragment.num).getListAuthor());
        txtStatus.setText(ReadingListFragment.progressList.get(ReadingListFragment.num).getCurrStatus());

        numRead = numberPicker.getValue();
        status = (String) txtStatus.getText();

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(Integer.valueOf(ReadingListFragment.progressList.get(ReadingListFragment.num).getNumChaps()));
        numberPicker.setValue(ReadingListFragment.progressList.get(ReadingListFragment.num).getNumRead());

        numberPickerScore.setMinValue(0);
        numberPickerScore.setMaxValue(5);
        numberPickerScore.setValue(ReadingListFragment.progressList.get(ReadingListFragment.num).getScore());

        btnCancel = (Button) rootView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setCurrStatus(status.toString());
//                txtStatus.setText(status);
                numberPicker.setValue(numRead);
                dismiss();
                ReadingListFragment.adapter.notifyDataSetChanged();
            }
        });

        btnSave = (Button) rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setNumRead(numberPicker.getValue());
                ReadingListFragment.progressList.get(ReadingListFragment.num).setScore(numberPickerScore.getValue());
                ReadingListFragment.adapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "Update Saved", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        btnDelete = (Button) rootView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.remove(ReadingListFragment.num);
                ReadingListFragment.adapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "Removed from Library", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        btnReading = (Button) rootView.findViewById(R.id.btnReading);
        btnReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setCurrStatus("Currently Reading");
                txtStatus.setText("Currently Reading");
            }
        });

        btnCompleted = (Button) rootView.findViewById(R.id.btnCompleted);
        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setCurrStatus("Completed");
                numberPicker.setValue(numberPicker.getMaxValue());
                txtStatus.setText("Completed");
            }
        });

        btnPTR = (Button) rootView.findViewById(R.id.btnPTR);
        btnPTR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setCurrStatus("Plan to Read");
                numberPicker.setValue(0);
                txtStatus.setText("Plan to Read");
            }
        });

        btnHold = (Button) rootView.findViewById(R.id.btnHold);
        btnHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setCurrStatus("On Hold");
                txtStatus.setText("On Hold");
            }
        });

        btnDrop = (Button) rootView.findViewById(R.id.btnDropped);
        btnDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingListFragment.progressList.get(ReadingListFragment.num).setCurrStatus("Dropped");
                txtStatus.setText("Dropped");
            }
        });

        return rootView;
    }
}
