package com.learnMVP.todolist.module.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.learnMVP.todolist.R;
import com.learnMVP.todolist.base.BaseFragment;

import java.util.Objects;

public class AddTaskFragment extends BaseFragment<AddTaskActivity, AddTaskContract.Presenter> implements AddTaskContract.View {

    TextInputEditText tietTaskName;
    TextInputEditText tietTaskTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_task, container, false);
        presenter.start();

        final TextView taskTitle = fragmentView.findViewById(R.id.tv_task_title);
        final Button btnTaskAdd = fragmentView.findViewById(R.id.btn_task_add);
        tietTaskName = fragmentView.findViewById(R.id.tiet_task_name);
        tietTaskTime = fragmentView.findViewById(R.id.tiet_task_time);

        setTitle(getResources().getString(R.string.task_title_add));
        taskTitle.setText(R.string.task_title_add);
        btnTaskAdd.setVisibility(View.VISIBLE);
        btnTaskAdd.setOnClickListener(view -> this.onClickSave());

        return fragmentView;
    }

    private void onClickSave() {
        String name = Objects.requireNonNull(tietTaskName.getText()).toString();
        String time = Objects.requireNonNull(tietTaskTime.getText()).toString();
        presenter.saveData(name, time);
    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
        activity.finish();
    }
}
