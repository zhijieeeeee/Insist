package com.zhijieeeeee.insist.util;

import com.zhijieeeeee.insist.app.Constants;
import com.zhijieeeeee.insist.bean.Book;
import com.zhijieeeeee.insist.bean.Plan;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Ashin on 2018/3/25.
 */

public class DataManager {

    /**
     * 获取当天计划
     */
    public void getCurrentDayPlan(final OnFindCurrentDayPlanListener onFindCurrentDayPlanListener) {
        String day = DateUtil.getNowDay();
        BmobQuery<Plan> query = new BmobQuery<>();
        query.addWhereEqualTo("day", day);
        query.findObjects(new FindListener<Plan>() {
            @Override
            public void done(List<Plan> list, BmobException e) {
                if (e == null && list != null && list.size() != 0) {//查找成功
                    onFindCurrentDayPlanListener.onGetCurrentDayPlanSuccess(list);
                } else {//查找失败
                    onFindCurrentDayPlanListener.onGetCurrentDayPlanFail();
                }
            }
        });
    }

    /**
     * 插入当天计划新条目
     */
    public void insertCurrentDayPlan(final OnInsertListener onInsertListener) {
        String day = DateUtil.getNowDay();
        List<BmobObject> planList = new ArrayList<>();
        for (int i = 0; i < Constants.PLANS.length; i++) {
            Plan plan = new Plan();
            plan.setDay(day);
            plan.setDone(0);
            plan.setName(Constants.PLANS[i]);
            planList.add(plan);
        }
        new BmobBatch().insertBatch(planList).doBatch(new QueryListListener<BatchResult>() {
            @Override
            public void done(List<BatchResult> list, BmobException e) {
                if (e == null) {
                    onInsertListener.onInsertSuccess();
                } else {
                    onInsertListener.onInsertFail(e.getMessage());
                }
            }
        });

    }

    /**
     * 设置某项任务完成
     *
     * @param plan 任务
     */
    public void setPlanDone(Plan plan, final OnUpdateListener onUpdateListener) {
        plan.setDone(1);
        plan.update(plan.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    onUpdateListener.onUpdateSuccess();
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
                }
            }
        });
    }


    public interface OnFindCurrentDayPlanListener {

        void onGetCurrentDayPlanSuccess(List<Plan> plans);

        void onGetCurrentDayPlanFail();
    }

    public interface OnInsertListener {
        void onInsertSuccess();

        void onInsertFail(String failReason);
    }

    public interface OnUpdateListener {
        void onUpdateSuccess();
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
