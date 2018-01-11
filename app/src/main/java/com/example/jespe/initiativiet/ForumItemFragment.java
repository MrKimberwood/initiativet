package com.example.jespe.initiativiet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class ForumItemFragment extends Fragment {

    ListView CommentList;
    EditText comment;
    ImageButton send;
    String[] test = {"test1", "test2", "test3","test4", "test5"};


    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View v = i.inflate(R.layout.fragment_forum_item, container, false);

        CommentList = (ListView) v.findViewById(R.id.CommentList);


        comment = (EditText) v.findViewById(R.id.editText);
        send= (ImageButton) v.findViewById(R.id.imageButton);

        comment.setText("Deltag i debatten her");

        final Lovforslag[] lfs = {
                new Lovforslag("Sammy", "Test", "test", "Vi skal lukke dem alle ind og give dem en fair chance"),
                new Lovforslag("Niklas", "test", "test", "Vi har allerede lukket for mange ind, nu må det stoppe!"),
                new Lovforslag("Jonathan", "test", "test", "Vi skal lukke dem ind hvis de i fremtiden kan bidrage til samfundet"),
                new Lovforslag("Gustav", "test", "test", "Jeg har intet input til denne diskussion"),
                new Lovforslag("Jesper", "test", "test", "Så længe de ikke forstyrer mig har jeg intet problem med dem")
        };
        ArrayAdapter aa = new ArrayAdapter(getActivity(), R.layout.postlistitem, R.id.author, test){
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {

                View v = super.getView(position, cachedView, parent);

                if (position != lfs.length) {
                    // TextView headline = (TextView) v.findViewById(R.id.headline);
                    // TextView category = (TextView) v.findViewById(R.id.category);
                    TextView description = (TextView) v.findViewById(R.id.description);
                    TextView author = (TextView) v.findViewById(R.id.author);
                    // headline.setText(lfs[position].getHeadline());
                    // category.setText(lfs[position].getCategory());
                    description.setText(lfs[position].getDescription());
                    author.setText(lfs[position].getAuthor());
                }



                return v;
            }
        };
        CommentList.setAdapter(aa);


        return v;
    }

}