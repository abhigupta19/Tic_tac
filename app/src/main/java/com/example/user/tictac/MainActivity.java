package com.example.user.tictac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int a=0;
    int [] arr={2,2,2,2,2,2,2,2,2};
    int [][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void yellow(View view)
 {

     ImageView c=(ImageView)view;
     int d=Integer.parseInt(c.getTag().toString());
     if(arr[d]==2) {
         arr[d]=a;
         c.setTranslationY(-1000f);
         if (a == 0) {
             c.setImageResource(R.drawable.la);
             a = 1;
             
         } else {
             c.setImageResource(R.drawable.images);
             a = 0;
         }

         for(int []won: win)
         {
             if(arr[won[0]]==arr[won[1]]&&arr[won[1]]==arr[won[2]]&&arr[won[0]]!=2)
             {
                 String s="2nd";
                 if(arr[won[0]]==0)
                 {
                      s="1st" ;
                 }
                 TextView t=(TextView)findViewById(R.id.textView);
                 t.setText(s+" has won!");
                 LinearLayout l=(LinearLayout)findViewById(R.id.tryagain);
                 l.setVisibility(View.VISIBLE);
             }
             
             else
             {
                 boolean b=true;
                 for(int r:arr)
                 {
                     if(r==2)
                         b=false;
                 }
                 if(b)
                 {
                     TextView t=(TextView)findViewById(R.id.textView);
                     t.setText("its draw");
                     LinearLayout l=(LinearLayout)findViewById(R.id.tryagain);
                     l.setVisibility(View.VISIBLE);
                 }
             }
         }
     }

 }
    public void buttona(View view)
    {
        LinearLayout la=(LinearLayout)findViewById(R.id.tryagain);
        la.setVisibility(View.INVISIBLE);
        a=0;
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=2;
        }
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gh);
        for(int j=0;j<gridLayout.getChildCount();j++)
        {
            ((ImageView)gridLayout.getChildAt(j)).setImageResource(0);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
