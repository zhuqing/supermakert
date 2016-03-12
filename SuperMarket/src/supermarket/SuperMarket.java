/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import com.supermarket.data.relationship.BuyGiveProductPreferentialData;
import com.supermarket.data.relationship.DBProductPreferentialData;
import com.supermarket.data.relationship.DiscountProductPreferentialData;
import com.supermarket.data.relationship.ProductPreferentialData;
import com.supermarket.entity.Bill;
import com.supermarket.util.BillUtil;
import com.supermarket.util.PreferentialUtil;
import com.supermarket.util.data.DataUtil;
import com.supermarket.util.log.LogUtil;
import com.supermarket.util.print.PrintUtil;

/**
 *
 * @author zhuleqi
 */
public class SuperMarket {

    static String data = "["
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000001',"
            + "    'ITEM000003-2',"
            + "    'ITEM000005',"
            + "    'ITEM000005',"
            + "    'ITEM000005'"
            + "]";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataUtil.initData();
        LogUtil.logInfo("\n\n当购买的商品中，没有优惠条件的商品时：");
        printBill(null);
        LogUtil.logInfo("\n\n当购买的商品中，有符合“买二赠一”优惠条件的商品时：");
        printBill(BuyGiveProductPreferentialData.getInstance());

        LogUtil.logInfo("\n\n当购买的商品中，有符合“95折优惠条件的商品时：");
        printBill(DiscountProductPreferentialData.getInstance());
        
        
         LogUtil.logInfo("\n\n当购买的商品中，有符合“95折“和“买二赠一”优惠条件的商品时：");
        printBill(DBProductPreferentialData.getInstance());

    }

    public static void printBill(ProductPreferentialData productPreferentialData) {
        PreferentialUtil.initProductPreferentialData(productPreferentialData);
        Bill bill = BillUtil.create(data);
        PrintUtil.print(bill);
    }

}
