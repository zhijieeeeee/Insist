package com.zhijieeeeee.insist.contract;

import com.zhijieeeeee.insist.base.presenter.AbstractPresenter;
import com.zhijieeeeee.insist.base.view.BaseView;
import com.zhijieeeeee.insist.bean.Book;
import com.zhijieeeeee.insist.bean.Plan;

import java.util.List;

/**
 * Created by tangzhijie on 2018/3/23.
 */

public interface BookContract {

    interface View extends BaseView {

        void showBookList(List<Book> list);

        void notifyListChange();

        void refreshComplete();

        void showReadingBook(Book book);
    }

    interface Presenter extends AbstractPresenter<View> {

        void getReadBookList(boolean showLoading);

        void insertBook(String bookName);

        void getReadingBook();

        void setReadComplete(Book book);
    }
}
