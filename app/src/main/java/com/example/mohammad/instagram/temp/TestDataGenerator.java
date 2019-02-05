package com.example.mohammad.instagram.temp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mohammad.instagram.R;
import com.example.mohammad.instagram.recycler_view.comment.CommentCard;
import com.example.mohammad.instagram.recycler_view.profile.ProfileCard;

import java.util.ArrayList;
import java.util.Random;

public class TestDataGenerator {

    public static ArrayList<ProfileCard> generateSomePosts(Context context) {
        ArrayList<ProfileCard> informations = new ArrayList<>();
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.like_icon_fill);
        ProfileCard first =
                new ProfileCard(null, bm
                        , "example"
                        , "16 likes"
                        , "This is a example's dynamic description"
                        , "2 Days ago", true, false);
        bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.like_icon_stroke);
        ProfileCard second =
                new ProfileCard(null, bm
                        , "alisafri98"
                        , "120 likes"
                        , "This is a Ali Safari's dynamic description "
                        , "14 May 2018",
                        false, true);
        bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.instagram_icon);
        ProfileCard third =
                new ProfileCard(null, bm
                        , "amisoheyli77"
                        , "200 likes"
                        , "This is a Amin Soheyli's dynamic description"
                        , "20 minutes ago", false, false);
        bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.saved_icon_fill);
        ProfileCard fourth =
                new ProfileCard(null, bm
                        , "test19"
                        , "17 likes"
                        , "This is a test's dynamic description"
                        , "Just now", true, true);
        Random random = new Random();

        ProfileCard test;
        for (int i = 0; i < 25; i++) {
            int x = random.nextInt(4) + 1;
            switch (x) {
                case 1:
                    test = first;
                    break;
                case 2:
                    test = second;
                    break;
                case 3:
                    test = third;
                    break;
                case 4:
                    test = fourth;
                    break;
                default:
                    test = first;
                    break;
            }
            informations.add(test);
        }
        return informations;
    }

    public static ArrayList<String> generateSomeName() {
        String[] myDataset = new String[]{
                "ramin",
                "arian",
                "razi",
                "..."
        };
        ArrayList<String> names = new ArrayList<>();
        for (String name : myDataset) {
            names.add(name);
        }
        return names;
    }

    public static ArrayList<CommentCard> generateSomeComments() {
        ArrayList<String> names = generateSomeName();
        ArrayList<CommentCard> comments = new ArrayList<>();
        for (String name : names) {
            comments.add(new CommentCard(name, name));
        }
        return comments;
    }

    public static ArrayList<String> generateSomeStringImageUri() {
        ArrayList<String> images = new ArrayList<>();
        images.add("https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/11/naturo-monkey-selfie.jpg?w968h681");
        images.add("https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/242ce817-97a3-48fe-9acd-b1bf97930b01/09-posterization-opt.jpg");
        images.add("http://media.pixcove.com/I/5/8/Image-Editing-Textures-Backgrounds-Unleashed-Ebv-W-8490.jpg");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShT4IeDM1hqoW-SY_q3WrvniwjzUyaLUIJffeIJv379zfHzY3iCA");
        images.add("https://www.gstatic.com/images/branding/product/2x/photos_96dp.png");
        images.add("https://www.esa.int/var/esa/storage/images/esa_multimedia/images/2015/05/saint_george_basin_australia/15411139-1-eng-GB/Saint_George_Basin_Australia.jpg");
        images.add("https://s3-us-west-1.amazonaws.com/powr/defaults/image-slider2.jpg");
        images.add("data:image/jpeg;base64,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");
        images.add("data:image/jpeg;base64,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");
        return images;
    }
}
