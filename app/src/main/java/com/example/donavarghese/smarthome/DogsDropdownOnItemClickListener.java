package com.example.donavarghese.smarthome;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Donavarghese on 10/18/17.
 */

public class DogsDropdownOnItemClickListener extends FragmentActivity implements OnItemClickListener {

    String TAG = "DogsDropdownOnItemClickListener.java";

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

        Context mContext = v.getContext();
      //  Context mContext2 = v.getContext();
        Light mainActivity = ((Light) mContext);

      //  mainActivity.visibility();
        mainActivity.seebbarr();
        // get the context and main activity to access variables



        // add some animation when a list item was clicked
        Animation fadeInAnimation =
                AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);

        // dismiss the pop up
        mainActivity.popupWindowDogs.dismiss();

        // get the text and set it as the button text
    //    TextView textView  = (TextView) fin
        String selectedItemText = ((TextView) v).getText().toString();
        mainActivity.textView.setText(selectedItemText);

        // get the id
        String selectedItemTag = v.getTag().toString();
        int num = Integer.parseInt(selectedItemTag);
        switch(num){
            case 1:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();


               // mainActivity.seebbarr();
             //
               // break;
            case 2:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
              //  break;
            case 3:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
             //   break;
            case 4:
                Toast.makeText(mContext, "Dog ID is: " + selectedItemTag,
                        Toast.LENGTH_SHORT).show();
               // break;
            default:
                Toast.makeText(mContext, "Something else " ,Toast.LENGTH_SHORT);
        }


    }


}