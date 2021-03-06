package com.zhijieeeeee.insist.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.orhanobut.logger.Logger;
import com.zhijieeeeee.insist.base.presenter.BasePresenter;
import com.zhijieeeeee.insist.bean.Book;
import com.zhijieeeeee.insist.contract.BookContract;
import com.zhijieeeeee.insist.util.DataManager;
import com.zhijieeeeee.insist.util.SpManager;
import com.zhijieeeeee.insist.util.ToastUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by tangzhijie on 2018/3/26.
 */

public class BookPresenter extends BasePresenter<BookContract.View> implements BookContract.Presenter, LifecycleObserver {

    private DataManager mDataManager;
    private SpManager spManager;

    @Inject
    public BookPresenter(DataManager mDataManager, SpManager spManager) {
        this.mDataManager = mDataManager;
        this.spManager = spManager;
    }

    @Override
    public void getReadBookList(boolean showLoading) {
        if (showLoading) {
            mView.showLoading();
        }
        mDataManager.getReadBookList(new DataManager.OnFindReadBook() {
            @Override
            public void onGetSuccess(List<Book> bookList) {
                mView.showBookList(bookList);
                mView.closeLoading();
                mView.refreshComplete();
            }

            @Override
            public void onGetFail() {
                mView.closeLoading();
                mView.refreshComplete();
            }
        });
    }

    @Override
    public void insertBook(String bookName) {
        mView.showLoading();
        mDataManager.insertNewBook(bookName, new DataManager.OnInsertListener() {
            @Override
            public void onInsertSuccess() {
                ToastUtil.show("添加成功");
                getReadingBook();
                getReadBookList(true);
            }

            @Override
            public void onInsertFail(String failReason) {
                mView.closeLoading();
            }
        });
    }

    @Override
    public void getReadingBook() {
        mView.showLoading();
        mDataManager.getReadingBook(new DataManager.OnFindReadingBook() {
            @Override
            public void onGetSuccess(Book book) {
                mView.showReadingBook(book);
                mView.closeLoading();
            }

            @Override
            public void onGetFail() {
                mView.showReadingBook(null);
                mView.closeLoading();
            }
        });
    }

    @Override
    public void setReadComplete(Book book) {
        mView.showLoading();
        mDataManager.setReadComplete(book, new DataManager.OnUpdateListener() {
            @Override
            public void onUpdateSuccess() {
                ToastUtil.show("恭喜读完了这本书");
                mView.showReadingBook(null);
                getReadBookList(true);
            }

            @Override
            public void onUpdateFail(String failReason) {
                ToastUtil.show(failReason);
                mView.closeLoading();
            }
        });
    }

    //下面是测试Lifecycle组件

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        getReadingBook();
        getReadBookList(true);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
    }
}
