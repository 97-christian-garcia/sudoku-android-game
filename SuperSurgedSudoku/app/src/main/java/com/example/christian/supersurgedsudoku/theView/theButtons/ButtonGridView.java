package com.example.christian.supersurgedsudoku.theView.theButtons;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.christian.supersurgedsudoku.R;

public class ButtonGridView extends GridView {
    public ButtonGridView(Context context, AttributeSet attrs){
        super(context, attrs);
        ButtonGridViewAdapter gridViewAdapter = new ButtonGridViewAdapter(context);
        setAdapter(gridViewAdapter);
    }


    class ButtonGridViewAdapter extends BaseAdapter{

        private Context context;

        public ButtonGridViewAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;

            if(v == null){
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                v = inflater.inflate(R.layout.button, parent, false);

                ButtonNumbers btn;
                btn = (ButtonNumbers) v;
                btn.setTextSize(10);
                btn.setId(position);
                if(position != 9) {
                    btn.setText(String.valueOf(position + 1));
                    btn.setNumber(position + 1);
                }
                else{
                    btn.setText(String.valueOf("DEL"));
                    btn.setNumber(0);
                }
                return btn;
            }
            return v;
        }
    }
}


