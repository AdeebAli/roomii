package com.example.roomii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesFragment extends Fragment {
    //a list to store all the products
    List<Profile> profileList;

    // THe recycler view
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        View rootView =  inflater.inflate(R.layout.fragment_favorites, null);
        //getting a reference to the recycler view
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        profileList = new ArrayList<>();


        //adding some items to our list
        profileList.add(
                new Profile(
                        "Adeeb Ali",
                        R.drawable.adeeb,
                        "It's a rare night that I'm not up til 4am watching Twitch streams!",
                        77));
        profileList.add(
                new Profile(
                        "Cole Wallin",
                        R.drawable.cole,
                        "I'm a quiet person who likes to study all the time and go to bed early!",
                        90));
        profileList.add(
                new Profile(
                        "Kennedy Mindermann",
                        R.drawable.kennedy,
                        "I'm a great roommii as long as I've had my coffee first!",
                        64));
        profileList.add(
                new Profile(
                        "Zachary Trosvig",
                        R.drawable.zach,
                        "I'm a studious person but I am known to occasionally blast music out my front windows!",
                        85));


        //creating recyclerview adapter
        FavoritesAdapter adapter = new FavoritesAdapter(getActivity(), profileList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return rootView;

    }
}

