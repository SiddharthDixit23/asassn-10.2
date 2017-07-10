package com.acadgild.siddharth.fragmentportraitlandscapeapp102;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by siddharth on 6/23/2017.
 */

public class HeadlinesFragment extends ListFragment {
    onHeadlineSelectedListener mCallBack;
    public interface onHeadlineSelectedListener
    {
        public void onArticleSelected(int position);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB?android.R.layout.simple_list_item_activated_1:android.R.layout.simple_list_item_1;
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout,Ipsum.Headlines));
    }

    public void onStart()
    {
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.article_fragment)!=null)
        {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try{
            mCallBack=(onHeadlineSelectedListener)activity;
        }catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallBack.onArticleSelected(position);
        getListView().setItemChecked(position,true);
        super.onListItemClick(l, v, position, id);
    }
}
