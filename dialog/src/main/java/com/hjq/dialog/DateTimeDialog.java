package com.hjq.dialog;

import android.app.Dialog;

import androidx.fragment.app.FragmentActivity;

import com.hjq.dialog.widget.LoopView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/12/17
 *    desc   : 日期选择对话框
 */
public final class DateTimeDialog extends AbsLooperDialog {

    private static final int START_YEAR = 2012;
    private static final int EDN_YEAR = 2022;

    public final static class Builder
            extends AbsLooperDialog.Builder<Builder>
            implements LoopView.LoopScrollListener {

        private LoopView mYearView;
        private LoopView mMonthView;
        private LoopView mDayView;
        private LoopView mHourView;
        private LoopView mMinuteView;

        private OnListener mListener;

        public Builder(FragmentActivity activity) {
            super(activity);

            // 生产年份
            ArrayList<String> yearList = new ArrayList<>(10);
            for (int i = START_YEAR; i <= EDN_YEAR; i++) {
                yearList.add(i + " " + getString(R.string.dialog_date_year));
            }

            // 生产月份
            ArrayList<String> monthList = new ArrayList<>(12);
            for (int i = 1; i <= 12; i++) {
                monthList.add(i + " " + getString(R.string.dialog_date_month));
            }

            // 生产小时
            ArrayList<String> hourList = new ArrayList<>(24);
            for (int i = 1; i <= 24; i++) {
                hourList.add(i + " " + getString(R.string.dialog_date_hour));
            }

            // 生产分钟
            ArrayList<String> minuteList = new ArrayList<>(60);
            for (int i = 1; i <= 60; i++) {
                minuteList.add(i + " " + getString(R.string.dialog_date_minute));
            }

            mYearView = createLoopView(true);
            mMonthView = createLoopView();
            mDayView = createLoopView();
            mHourView = createLoopView();
            mMinuteView = createLoopView();

            mYearView.setData(yearList);
            mMonthView.setData(monthList);

            mHourView.setData(hourList);
            mMinuteView.setData(minuteList);

            mYearView.setLoopListener(this);
            mMonthView.setLoopListener(this);

            Calendar calendar = Calendar.getInstance();
            mYearView.setInitPosition(calendar.get(Calendar.YEAR) - START_YEAR);
            mMonthView.setInitPosition(calendar.get(Calendar.MONTH));
            mDayView.setInitPosition(calendar.get(Calendar.DAY_OF_MONTH) - 1);
            mHourView.setInitPosition(calendar.get(Calendar.HOUR_OF_DAY));
            mMinuteView.setInitPosition(calendar.get(Calendar.MINUTE));
        }

        @Override
        public void onItemSelect(LoopView loopView, int position) {
            // 获取这个月最多有多少天
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            if (loopView == mYearView) {
                calendar.set(START_YEAR + mYearView.getSelectedItem(), mMonthView.getSelectedItem(), 1);
            }else if (loopView == mMonthView) {
                calendar.set(START_YEAR + mYearView.getSelectedItem(), mMonthView.getSelectedItem(), 1);
            }
            int day = calendar.getActualMaximum(Calendar.DATE);

            ArrayList<String> dayList = new ArrayList<>(day);
            for (int i = 1; i <= day; i++) {
                dayList.add(i + " " + getString(R.string.dialog_date_day));
            }

            mDayView.setData(dayList);
        }

        public Builder setListener(OnListener l) {
            mListener = l;
            return this;
        }

        @Override
        protected void onConfirm() {
            if (mListener != null) {
                mListener.onSelected(getDialog(), START_YEAR + mYearView.getSelectedItem(),
                        mMonthView.getSelectedItem() + 1, mDayView.getSelectedItem() + 1,
                        mHourView.getSelectedItem() + 1,mMinuteView.getSelectedItem() + 1);
            }
            dismiss();
        }

        protected void onCancel() {
            if (mListener != null) {
                mListener.onCancel(getDialog());
            }
            dismiss();
        }
    }

    public interface OnListener {

        /**
         * 选择完日期后回调
         *
         * @param year              年
         * @param month             月
         * @param day               日
         */
        void onSelected(Dialog dialog, int year, int month, int day,int hour,int minute);

        /**
         * 点击取消时回调
         */
        void onCancel(Dialog dialog);
    }
}
