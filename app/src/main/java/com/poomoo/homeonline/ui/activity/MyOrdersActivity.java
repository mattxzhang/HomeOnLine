/**
 * Copyright (c) 2016. 李苜菲 Inc. All rights reserved.
 */
package com.poomoo.homeonline.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.poomoo.homeonline.R;
import com.poomoo.homeonline.ui.base.BaseActivity;
import com.poomoo.homeonline.ui.fragment.MyOrdersFragment;
import com.poomoo.homeonline.ui.fragment.TabFragment;
import com.poomoo.model.response.ROrderBO;

/**
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 * 作者: 李苜菲
 * 日期: 2016/7/14 9:45
 * <p/>
 * 我的订单
 */
public class MyOrdersActivity extends BaseActivity {
    int type;
    private TabFragment mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getIntExtra(getString(R.string.intent_value), 0);
        setDefaultMenuItem();
    }

    @Override
    protected int onSetTitle() {
        return R.string.title_myOrders;
    }

    @Override
    protected int onBindLayout() {
        return R.layout.activity_my_orders;
    }

    /**
     * 设置默认的页面
     */
    @SuppressLint("ValidFragment")
    private void setDefaultMenuItem() {
        mTab = new TabFragment() {
            @Override
            public void onSetupTabs() {
                addTab(getResources().getString(R.string.tab_order_all), MyOrdersFragment.class, ROrderBO.ORDER_ALL);
                addTab(getResources().getString(R.string.tab_order_pay), MyOrdersFragment.class, ROrderBO.ORDER_PAY);
                addTab(getResources().getString(R.string.tab_order_deliver), MyOrdersFragment.class, ROrderBO.ORDER_DELIVER);
                addTab(getResources().getString(R.string.tab_order_receipt), MyOrdersFragment.class, ROrderBO.ORDER_RECEIPT);
                addTab(getResources().getString(R.string.tab_order_evaluate), MyOrdersFragment.class, ROrderBO.ORDER_EVALUATE);
                addTab(getResources().getString(R.string.tab_order_after_sale), MyOrdersFragment.class, ROrderBO.ORDER_AFTER_SALE);
            }
        };
        mTab.setPage(type);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, mTab)
                .commit();
    }
}
