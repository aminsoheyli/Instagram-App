package com.example.mohammad.instagram.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohammad.instagram.PersonalFragmentType;
import com.example.mohammad.instagram.ProfileInformations;
import com.example.mohammad.instagram.R;
import com.example.mohammad.instagram.recycler_view.profile.ProfileAdapter;
import com.example.mohammad.instagram.recycler_view.profile.ProfileCard;
import com.example.mohammad.instagram.temp.TestDataGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
 * Fragment than the current user can click on the
 * username of each post and be directed to the profile
 * page of clicked user.
 *
 * Consist of:
 *
 *           I.     Saved fragment
 *           II.    Global fragment
 *           III.   Home fragment*/

public class PersonalsFragment extends Fragment {
    private static final String DIRECTABLE_TYPE_KEY = "directable_type";
    private PersonalFragmentType personalFragmentType;
    private View rootView;
    private RecyclerView recyclerViewProfileImages;


    public static PersonalsFragment newInstance(PersonalFragmentType personalFragmentType, ProfileInformations profileInformations) {
        Bundle args = new Bundle();
        args.putSerializable(DIRECTABLE_TYPE_KEY, personalFragmentType);
        PersonalsFragment fragment = new PersonalsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personalFragmentType = (PersonalFragmentType) getArguments().getSerializable(DIRECTABLE_TYPE_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_directables, container, false);
        if (personalFragmentType == PersonalFragmentType.HOME_FRAGMENT)
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initials(rootView);
        onClickListeners();

        return rootView;
    }

    private void initials(View rootView) {
        recyclerViewProfileImages = rootView.findViewById(R.id.recycler_view_profile_images);
        if (personalFragmentType == PersonalFragmentType.ACTIVITY_FRAGMENT) {

            return;
        }
        prepareRecyclerView();
    }


    /**
     * Prepare recycler view's informations based on directable type
     */
    private void prepareRecyclerView() {
        recyclerViewProfileImages.setNestedScrollingEnabled(false);
        recyclerViewProfileImages.setHasFixedSize(true);
        ArrayList<ProfileCard> informations;
        informations = prepareInformations(personalFragmentType);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewProfileImages.setLayoutManager(llm);
        ProfileAdapter adapter = new ProfileAdapter(informations, personalFragmentType);
        recyclerViewProfileImages.setAdapter(adapter);
    }

    private ArrayList<ProfileCard> prepareInformations(PersonalFragmentType personalFragmentType) {
        ArrayList<ProfileCard> informations = new ArrayList<>();
        switch (personalFragmentType) {
            case HOME_FRAGMENT:
                // User's posts and following's posts
                informations = homeFragmentInformationsQuery();
                break;
            case SEARCH_FRAGMENT:
                // All posts without current user posts
                informations = searchFragmentInformationsQuery();
                break;
            default:
                new Exception("In the PersonalsFragment you can't set the directable type to HOME_FRAGMENT.");
                break;
        }

        return informations;
    }


    private ArrayList<ProfileCard> homeFragmentInformationsQuery() {
        ArrayList<ProfileCard> informations = TestDataGenerator.generateSomePosts(getContext());
        return informations;
    }

    private ArrayList<ProfileCard> searchFragmentInformationsQuery() {
        ArrayList<ProfileCard> informations = TestDataGenerator.generateSomePosts(getContext());
        return informations;
    }


    private void onClickListeners() {

    }


    // Query to specify whether the user has a biography or not.
    private String hasBiography() {
        return null;
    }


    int SumHashItem(HashMap<Integer, Integer> hashMap) {
        int sum = 0;

        for (Map.Entry<Integer, Integer> myItem : hashMap.entrySet()) {
            sum += myItem.getValue();
        }

        return sum;
    }
}
