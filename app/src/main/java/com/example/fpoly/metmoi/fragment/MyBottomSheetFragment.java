package com.example.fpoly.metmoi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fpoly.R;
import com.example.fpoly.metmoi.adapter.PersonAdapter;
import com.example.fpoly.metmoi.adapter.PersonObject;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {

    public MyBottomSheetFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set hardcoded data to the views inside the bottom sheet layout
        CircleImageView profileImage = view.findViewById(R.id.profileImage);
        if (profileImage != null) {
            PersonObject person = getDummyPersonList().get(0);
            if (requireContext() == null) {
                // Use the parent fragment's context or activity's context here if required
                // Log.e("MyBottomSheetFragment", "Context is null!");
            } else {
                profileImage.setImageDrawable(ContextCompat.getDrawable(requireContext(), person.getProfileImage()));
            }
        }

        // Find the TextView by its ID
        TextView textView = view.findViewById(R.id.studentCon);
        if (textView != null) {
            // Set the text for the TextView
            textView.setText("Confirmation");
        }

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new PersonAdapter(getDummyPersonList()));
    }

    // Method to provide dummy data for the RecyclerView (Replace this with your actual data list)
    private List<PersonObject> getDummyPersonList() {
        List<PersonObject> personList = new ArrayList<>();

//        // Create PersonObject with customized data
//        PersonObject person1 = new PersonObject(
//                "2023-08-06", // Date
//                "15:30",      // Time
//                "Important announcement", // Message
//                "School Server", // Server
//                "John Doe", // Student's name
//                "Jane Smith", // Teacher's name
//                R.drawable.ic_phone, // Resource ID for phone icon
//                R.drawable.ic_sms, // Resource ID for SMS icon
//                "Confirmation", // Person confirmation (not used in this context)
//                requireContext(), // Context (should be valid when creating the object)
//                R.drawable.create1, // Resource ID for student's profile image
//                R.drawable.create2, // Resource ID for teacher's profile image
//                true // Set isTeacher to true for this person
//        );
//
//        personList.add(person1);

        // Array of resource IDs for student profile images
        int[] studentProfileImages = {
                R.drawable.create1,
                R.drawable.create2,
                R.drawable.create3,
                R.drawable.create4,
                R.drawable.create5,
                R.drawable.create6,
                // Add more resource IDs as needed
        };

        for (int i = 0; i < 40; i++) {
            PersonObject dummyPerson = new PersonObject(
                    "2023-08-" + (i + 1), // Date (dynamic value)
                    "16:45", // Time
                    "Message " + (i + 1), // Message (dynamic value)
                    "Server " + (i + 1), // Server (dynamic value)
                    "Student " + (i + 1), // Student's name
                    "Teacher " + (i + 1), // Teacher's name
                    R.drawable.ic_phone, // Resource ID for phone icon
                    R.drawable.ic_sms, // Resource ID for SMS icon
                    "Confirmation " + (i + 1), // Person confirmation (dynamic value)
                    requireContext(), // Context (should be valid when creating the object)
                    // Get the appropriate resource ID from the array based on the loop index
                    studentProfileImages[i % studentProfileImages.length],
                    R.drawable.create2, // Resource ID for teacher's profile image
                    true // Set isTeacher to true for this person
            );

            personList.add(dummyPerson);
        }

        return personList;
    }
}