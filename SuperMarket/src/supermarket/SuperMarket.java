/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import com.supermarket.entity.Bill;
import com.supermarket.util.BillUtil;
import com.supermarket.util.ScanUtil;
import com.supermarket.util.data.DataUtil;

/**
 *
 * @author zhuleqi
 */
public class SuperMarket {

    static String data = "[" +
"    'ITEM000001'," +
"    'ITEM000001'," +
"    'ITEM000001'," +
"    'ITEM000001'," +
"    'ITEM000001'," +
"    'ITEM000003-2'," +
"    'ITEM000005'," +
"    'ITEM000005'," +
"    'ITEM000005'" +
"]";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataUtil.initAllData();
        Bill bill = BillUtil.create(data);
        BillUtil.printBill(bill);
    }
    
}
