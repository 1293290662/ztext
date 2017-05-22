package com.baway.zhangyuanyang1503a20170522;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.limxing.xlistview.view.XListView;

import org.xutils.x;

public class MainActivity extends AppCompatActivity implements IView{

    private XListView list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_item = (XListView) findViewById(R.id.list_item);
//        进入页面做网络判断，网络未连接跳转到设置网络页面进行设置
       if(!getCheckWork()){
           Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
           startActivity(intent);
           return;
       }

        GetHttpData getHttpData=new GetHttpData(this);
        getHttpData.getHttpData(0);
        MyAdpater myAdpater = new MyAdpater(this);
        list_item.setAdapter(myAdpater);

        list_item.setPullLoadEnable(true);

    }

//    判断网络是否连接
    public boolean getCheckWork(){
        ConnectivityManager conn=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net = conn.getActiveNetworkInfo();
        if(net!=null&&net.isConnected()){
            return true;
        }else {

            return false;
        }
    }

    @Override
    public void callData(Bean bean) {
        MyAdpater myAdpater = new MyAdpater(this);
        myAdpater.setList(bean.getData());
        list_item.setAdapter(myAdpater);
    }
}
