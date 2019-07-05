package com.yuhaokui.statistics.bean

import java.text.SimpleDateFormat

class DateRegion {
    String beginDate
    String endDate

    DateRegion() {
        Calendar cal = Calendar.getInstance()
        int year = cal.get(Calendar.YEAR)
        int month = cal.get(Calendar.MONTH) + 1
        //设置年份
        cal.set(Calendar.YEAR, year)
        //设置月份
        cal.set(Calendar.MONTH, month-1)
        int firstDay = cal.getMinimum(Calendar.DATE)
        cal.set(Calendar.DAY_OF_MONTH,firstDay)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
        this.beginDate = sdf.format(cal.getTime())
        int lastDay = cal.getActualMaximum(Calendar.DATE)
        cal.set(Calendar.DAY_OF_MONTH, lastDay)
        this.endDate = sdf.format(cal.getTime())
    }

    DateRegion(int month) {
        Calendar cal = Calendar.getInstance()
        int year = cal.get(Calendar.YEAR)
        //设置年份
        cal.set(Calendar.YEAR, year)
        //设置月份
        cal.set(Calendar.MONTH, month-1)
        int firstDay = cal.getMinimum(Calendar.DATE)
        cal.set(Calendar.DAY_OF_MONTH,firstDay)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
        this.beginDate = sdf.format(cal.getTime())
        int lastDay = cal.getActualMaximum(Calendar.DATE)
        cal.set(Calendar.DAY_OF_MONTH, lastDay)
        this.endDate = sdf.format(cal.getTime())
    }
}
