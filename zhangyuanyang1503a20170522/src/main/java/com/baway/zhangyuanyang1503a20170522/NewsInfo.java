package com.baway.zhangyuanyang1503a20170522;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by 张芫阳 on 2017/5/22.
 */
//IMAGEURL，TITLE，FROMNAME，SHOWTIME)
@Table(name = "news",onCreated = "create table news(id integer autoincrement primary key," +
        "imageuri varchar(20)," +
        "title varchar(50)," +
        "fromname varchar(50)," +
        "showtime varchar(50))")
public class NewsInfo {

    @Column(name = "id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;

    @Column(name = "imageuri")
    private String imageuri;
    @Column(name = "title")
    private String title;
    @Column(name = "fromname")
    private String fromname;
    @Column(name = "showtime")
    private String showtime;

    public NewsInfo() {
    }

    public NewsInfo(String imageuri, String title, String fromname, String showtime) {
        this.imageuri = imageuri;
        this.title = title;
        this.fromname = fromname;
        this.showtime = showtime;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", imageuri='" + imageuri + '\'' +
                ", title='" + title + '\'' +
                ", fromname='" + fromname + '\'' +
                ", showtime='" + showtime + '\'' +
                '}';
    }
}
