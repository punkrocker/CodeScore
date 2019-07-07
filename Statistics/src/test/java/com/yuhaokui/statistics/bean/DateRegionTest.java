package com.yuhaokui.statistics.bean;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateRegionTest {

    @Test
    public void makeDate() {
        DateRegion dateRegion = new DateRegion();
        Assert.assertEquals("", "2019-07-01", dateRegion.getBeginDate());
        dateRegion = new DateRegion(6);
        Assert.assertEquals("", "2019-06-01", dateRegion.getBeginDate());
    }

}