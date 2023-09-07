package com.example.fpoly.metmoi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fpoly.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<PersonObject> personList;

    public PersonAdapter(List<PersonObject> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        PersonObject person = personList.get(position);
        holder.bind(person);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profileImage;
        TextView studentNameTextView;
        TextView studentCon;
        TextView teacherNameTextView;
        TextView teacherName;
        ImageView phoneIcon;
        ImageView smsIcon;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profileImage);
            studentNameTextView = itemView.findViewById(R.id.studentNameTextView);
            studentCon = itemView.findViewById(R.id.studentCon);
            teacherNameTextView = itemView.findViewById(R.id.teacherNameTextView);
            teacherName = itemView.findViewById(R.id.teacherName);
            phoneIcon = itemView.findViewById(R.id.phoneIcon);
            smsIcon = itemView.findViewById(R.id.smsIcon);
        }

        public void bind(PersonObject person) {
            studentNameTextView.setText(person.getStudentName());
            studentCon.setText(person.getPresonCon());
            if (profileImage != null) {
                profileImage.setImageDrawable(person.getProfileImageDrawable());
            }
            phoneIcon.setImageDrawable(person.getPhoneIconDrawable());
            smsIcon.setImageDrawable(person.getSmsIconDrawable());


            // Check if the person is a teacher and show teacher-specific data
            if (person.isTeacher() && teacherNameTextView != null) {
                teacherNameTextView.setVisibility(View.VISIBLE);
                if (teacherName != null) {
                    teacherName.setVisibility(View.VISIBLE);
                    teacherName.setText(person.getTeacherName());
                    // You may also set the teacher's profile image here if available
                }
            } else {
                // Hide teacher-specific views for students
                if (teacherNameTextView != null) {
                    teacherNameTextView.setVisibility(View.GONE);
                }
                if (teacherName != null) {
                    teacherName.setVisibility(View.GONE);
                }
            }
        }
    }
}
