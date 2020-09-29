package com.javarush.task.task37.task3714;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {
    @Test
    public void test(){
        Assert.assertEquals(Solution.romanToInteger("IV"), 4);
        Assert.assertEquals(Solution.romanToInteger("VI"), 6);
        Assert.assertEquals(Solution.romanToInteger("VIII"), 8);
        Assert.assertEquals(Solution.romanToInteger("IX"), 9);
        Assert.assertEquals(Solution.romanToInteger("XV"), 15);
        Assert.assertEquals(Solution.romanToInteger("XIX"), 19);
        Assert.assertEquals(Solution.romanToInteger("XL"), 40);
        Assert.assertEquals(Solution.romanToInteger("XLII"), 42);
        Assert.assertEquals(Solution.romanToInteger("LX"), 60);
        Assert.assertEquals(Solution.romanToInteger("LXXX"), 80);
        Assert.assertEquals(Solution.romanToInteger("LXXXIII"), 83);
        Assert.assertEquals(Solution.romanToInteger("XCIV"), 94);
        Assert.assertEquals(Solution.romanToInteger("XC"), 90);
        Assert.assertEquals(Solution.romanToInteger("CL"), 150);
        Assert.assertEquals(Solution.romanToInteger("CCLXXXIII"), 283);
        Assert.assertEquals(Solution.romanToInteger("DCCC"), 800);
        Assert.assertEquals(Solution.romanToInteger("MCMLXXXVIII"), 1988);
        Assert.assertEquals(Solution.romanToInteger("MMDCLXXXIII"), 2683);
        Assert.assertEquals(Solution.romanToInteger("MMDDCCLLXXVVII"), 3332);
        Assert.assertEquals(Solution.romanToInteger("MMMD"), 3500);
    }
}
