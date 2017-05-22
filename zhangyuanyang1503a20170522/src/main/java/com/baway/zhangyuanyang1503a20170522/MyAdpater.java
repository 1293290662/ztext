package com.baway.zhangyuanyang1503a20170522;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张芫阳 on 2017/5/22.
 */

public class MyAdpater extends BaseAdapter{
    private Context context;
    private List<Bean.DataBean> list=new ArrayList<>();
    private ImageOptions imageOptions;

    public MyAdpater(Context context) {
        this.context = context;
        imageOptions = new ImageOptions.Builder().setFadeIn(true).
                setSquare(true).setCrop(true).setSize(200,200).build();

    }
    public void setList(List<Bean.DataBean> list){
        this.list.addAll(0,list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item,null);
            holder.title= (TextView) convertView.findViewById(R.id.text);
            holder.iamge=(ImageView) convertView.findViewById(R.id.imager);

            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();


        }
        holder.title.setText(list.get(position).getTITLE());

        x.image().bind(holder.iamge,list.get(position).getIMAGEURL(), imageOptions);

        return convertView;
    }

    public static class ViewHolder{
        TextView title;
        ImageView iamge;
    }

}
