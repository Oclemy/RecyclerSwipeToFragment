package com.tutorials.hp.recyclerswipetofrag.mRecycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorials.hp.recyclerswipetofrag.R;
import com.tutorials.hp.recyclerswipetofrag.mData.SpaceCraft;
import com.tutorials.hp.recyclerswipetofrag.mFragment.SpaceCraftFragment;

import java.util.ArrayList;

/**
 * Created by Oclemy on 5/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<SpaceCraft> spaceCrafts;
    FragmentManager fm;
    SpaceCraft spaceCraft;

    public MyAdapter(Context c, ArrayList<SpaceCraft> spaceCrafts, FragmentManager fm) {
        this.c = c;
        this.spaceCrafts = spaceCrafts;
        this.fm = fm;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
         String name=spaceCrafts.get(position).getName();
        int image=spaceCrafts.get(position).getImage();

        holder.nameTxt.setText(name);
        holder.img.setImageResource(image);

        holder.setItemTouchListener(new ItemTouchListener() {
            @Override
            public void onItemTouch(int pos) {
                spaceCraft=spaceCrafts.get(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return spaceCrafts.size();
    }

    public void openDialogFragment()
    {
        //BUNDLE DATA
        Bundle b=new Bundle();
        b.putString("NAME_KEY", spaceCraft.getName());
        b.putInt("IMAGE_KEY", spaceCraft.getImage());

        SpaceCraftFragment spaceCraftFragment=new SpaceCraftFragment();
        spaceCraftFragment.setArguments(b);
        spaceCraftFragment.show(fm,"mTag");

        this.notifyDataSetChanged();
    }
}
