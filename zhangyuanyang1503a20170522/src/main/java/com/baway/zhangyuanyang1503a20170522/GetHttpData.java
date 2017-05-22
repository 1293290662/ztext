package com.baway.zhangyuanyang1503a20170522;

import android.util.Log;

import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 张芫阳 on 2017/5/22.
 */

public class GetHttpData {
    private  IView iview;

    private  DbManager db;

    public GetHttpData(IView iview) {
        this.iview=iview;

        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                //设置数据库名，默认xutils.db
                .setDbName("myapp.db")
                //设置数据库路径，默认存储在app的私有目录
                .setDbDir(new File("/mnt/sdcard/"))
                .setDbVersion(1)
                ;
        db = x.getDb(daoConfig);

    }


    public void getHttpData(int startNum){
        RequestParams params=new RequestParams();
        params.setUri("http://www.93.gov.cn/93app/data.do?channelId=0&startNum="+startNum);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                Bean bean = gson.fromJson(result, Bean.class);

                ArrayList<NewsInfo> newsInfos = new ArrayList<>();
                for (int i = 0; i < bean.getData().size() ; i++) {

                    newsInfos.add(new NewsInfo(bean.getData().get(i).getIMAGEURL()
                            ,bean.getData().get(i).getTITLE()
                            ,bean.getData().get(i).getFROMNAME()
                            ,bean.getData().get(i).getSHOWTIME()));
                }
                try {
                    db.saveOrUpdate(newsInfos);
                } catch (DbException e) {
                    e.printStackTrace();
                }

                iview.callData(bean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
