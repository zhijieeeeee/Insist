package com.zhijieeeeee.insist.util;

import com.zhijieeeeee.insist.bean.Book;
import com.zhijieeeeee.insist.bean.Scheme;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CountListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Ashin on 2018/3/25.
 */

public class DataManager {

    /**
     * 获取完成的日期列表
     *
     * @param onGetDoneDateListener
     */
    public void getDoneDateList(final OnGetDoneDateListener onGetDoneDateListener) {
        BmobQuery<Scheme> query = new BmobQuery<>();
        query.setLimit(500);
        query.findObjects(new FindListener<Scheme>() {
            @Override
            public void done(List<Scheme> list, BmobException e) {
                if (e == null && list != null && list.size() != 0) {//查找成功
                    onGetDoneDateListener.onSuccess(list);
                } else {
                    onGetDoneDateListener.onFail(e.getMessage());
                }
            }
        });
    }

    /**
     * 获取总的完成天数
     */
    public void getDoneSum(final OnGetDoneSumListener onGetDoneSumListener) {
        BmobQuery<Scheme> query = new BmobQuery<>();
        query.count(Scheme.class, new CountListener() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {
                    onGetDoneSumListener.onSuccess(integer);
                }
            }
        });
    }

    /**
     * 插入完成日期
     */
    public void addDoneDate(int year, int month, int day, final OnAddDoneDateListener onAddDoneDateListener) {
        final Scheme scheme = new Scheme();
        scheme.setYear(year);
        scheme.setMonth(month);
        scheme.setDay(day);
        scheme.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    onAddDoneDateListener.onInsertSuccess(scheme);
                } else {
                    onAddDoneDateListener.onInsertFail(e.getMessage());
                }
            }
        });
    }

    /**
     * 添加正在读的书
     *
     * @param bookName 书名
     */
    public void insertNewBook(String bookName, final OnInsertListener onInsertListener) {
        Book book = new Book();
        book.setName(bookName);
        book.setStatus(0);
        book.setStartDate(DateUtil.getNowDay());
        book.setEndDate("");
        book.setComment("");
        book.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    onInsertListener.onInsertSuccess();
                } else {
                    onInsertListener.onInsertFail(e.getMessage());
                }
            }
        });
    }

    /**
     * 获取正在读的书
     */
    public void getReadingBook(final OnFindReadingBook onFindReadingBook) {
        BmobQuery<Book> query = new BmobQuery<>();
        query.addWhereEqualTo("status", 0);
        query.findObjects(new FindListener<Book>() {
            @Override
            public void done(List<Book> list, BmobException e) {
                if (e == null && list != null && list.size() != 0) {//查找成功
                    onFindReadingBook.onGetSuccess(list.get(0));
                } else {//查找失败
                    onFindReadingBook.onGetFail();
                }
            }
        });
    }

    /**
     * 获取已读图书列表
     */
    public void getReadBookList(final OnFindReadBook onFindReadBook) {
        BmobQuery<Book> query = new BmobQuery<>();
        query.addWhereEqualTo("status", 1);
        //采用更新时间降序排序
        query.order("-updatedAt");
        //一页多少条，最大500
        query.setLimit(500);
        query.findObjects(new FindListener<Book>() {
            @Override
            public void done(List<Book> list, BmobException e) {
                if (e == null && list != null && list.size() != 0) {//查找成功
                    onFindReadBook.onGetSuccess(list);
                } else {//查找失败
                    onFindReadBook.onGetFail();
                }
            }
        });
    }

    /**
     * 设置书已读完
     *
     * @param book 目标书
     */
    public void setReadComplete(Book book, final OnUpdateListener onUpdateListener) {
        book.setStatus(1);
        book.setEndDate(DateUtil.getNowDay());
        book.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    onUpdateListener.onUpdateSuccess();
                } else {
                    onUpdateListener.onUpdateFail(e.getMessage());
                }
            }
        });
    }

    public interface OnGetDoneDateListener {

        void onSuccess(List<Scheme> plans);

        void onFail(String reason);
    }

    public interface OnGetDoneSumListener {

        void onSuccess(int sum);
    }

    public interface OnAddDoneDateListener {
        void onInsertSuccess(Scheme scheme);

        void onInsertFail(String failReason);
    }

    public interface OnInsertListener {
        void onInsertSuccess();

        void onInsertFail(String failReason);
    }

    public interface OnUpdateListener {
        void onUpdateSuccess();

        void onUpdateFail(String failReason);
    }

    public interface OnFindReadingBook {
        void onGetSuccess(Book book);

        void onGetFail();
    }

    public interface OnFindReadBook {
        void onGetSuccess(List<Book> bookList);

        void onGetFail();
    }
}
