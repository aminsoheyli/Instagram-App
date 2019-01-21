package com.example.mohammad.instagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class EditProfileActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProfileImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        recyclerViewProfileImages = findViewById(R.id.rv);
        ArrayList<ProfileCardInformations> informations = new ArrayList<>();
//        ProfileCardInformations first =
//                new ProfileCardInformations(R.drawable.like_icon_fill
//                        , R.drawable.instagram_icon
//                        , "example"
//                        , "16 likes"
//                        , "This is a example's dynamic description"
//                        , "2 Days ago");
//        ProfileCardInformations second =
//                new ProfileCardInformations(R.drawable.like_icon_stroke
//                        , R.drawable.saved_icon_stroke
//                        , "alisafri98"
//                        , "120 likes"
//                        , "This is a Ali Safari's dynamic description "
//                        , "14 May 2018");
//        ProfileCardInformations third =
//                new ProfileCardInformations(R.drawable.instagram_icon
//                        , R.drawable.like_icon_fill
//                        , "amisoheyli77"
//                        , "200 likes"
//                        , "This is a Amin Soheyli's dynamic description"
//                        , "20 minutes ago");
//        ProfileCardInformations fourth =
//                new ProfileCardInformations(R.drawable.saved_icon_fill
//                        , R.drawable.comment_icon
//                        , "test19"
//                        , "17 likes"
//                        , "This is a test's dynamic description"
//                        , "Just now");
//        Random random = new Random();
//
//        ProfileCardInformations test;
//        for (int i = 0; i < 25; i++) {
//            int x = random.nextInt(3) + 1;
//
//            switch (x) {
//                case 1:
//                    test = first;
//                    break;
//                case 2:
//                    test = second;
//                    break;
//                case 3:
//                    test = third;
//                    break;
//                case 4:
//                    test = fourth;
//                    break;
//                default:
//                    test = null;
//                    break;
//            }
//            test = fourth;
//            informations.add(test);
//        }
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewProfileImages.setLayoutManager(llm);
        ProfileImagesAdapter adapter = new ProfileImagesAdapter(informations);
        recyclerViewProfileImages.setAdapter(adapter);
    }
}
