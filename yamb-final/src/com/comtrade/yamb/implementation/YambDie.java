package com.comtrade.yamb.implementation;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Die;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.RequestType;

class YambDie implements Die {
   private int value;
   private boolean fixed;

   @Override
   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   @Override
   public boolean isFixed() {
      return fixed;
   }

   @Override
   public void setFixed(boolean fixed) {
      this.fixed = fixed;
   }
}
