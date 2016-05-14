package com.tutorials.hp.recyclerswipetofrag.mFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.recyclerswipetofrag.R;

/**
 * Created by Oclemy on 5/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class SpaceCraftFragment extends DialogFragment {

    TextView nameTxt;
    ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.spacecraftdetail,container,false);

        nameTxt= (TextView) rootView.findViewById(R.id.nameTxtDetail);
        img= (ImageView) rootView.findViewById(R.id.spacecraftImageDetail);

        //RECEIVE DATA
        String name=this.getArguments().getString("NAME_KEY");
        int image=this.getArguments().getInt("IMAGE_KEY");

        //SHOW THEM
        nameTxt.setText(name);
        img.setImageResource(image);

        return rootView;
    }
}
