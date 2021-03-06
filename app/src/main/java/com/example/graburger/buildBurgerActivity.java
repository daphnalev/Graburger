package com.example.graburger;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Adapter;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import java.util.Objects;

public class buildBurgerActivity extends AppCompatActivity {

    static int CREATE_NEW_ACTIVITY_CODE = 0;
    static int EDIT_ACTIVITY_CODE = 1;

    public static int HALF_LOOPS = 500;

    BurgerItemModel curBurger;
    private ViewPager upperBunPager;
    private ViewPager bottomBunPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_burger);

        Intent intent = getIntent();
        curBurger = (BurgerItemModel) Objects.requireNonNull(intent.getExtras()).getSerializable("curBurger");

        upperBunPager = findViewById(R.id.UpperBun);
        bottomBunPager = findViewById(R.id.BottomBun);

        setViewPager(BunType.getAsListArray(true),
                R.id.UpperBun,
                curBurger.getBun().getPosition() + (HALF_LOOPS * BunType.size()),
                new ViewPager.OnPageChangeListener() {
                    private int mScrollState = ViewPager.SCROLL_STATE_IDLE;

                    @Override
                    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                        if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                            return;
                        }
                        curBurger.updateBurger(BunType.get(position % BunType.size()));
                        buildBurgerActivity.this.bottomBunPager.scrollTo(buildBurgerActivity.this.upperBunPager.getScrollX(),
                                buildBurgerActivity.this.upperBunPager.getScrollY());
                        updateCurrentBurgerDesc();
                    }

                    @Override
                    public void onPageSelected(final int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(final int state) {
                        mScrollState = state;
                        if (state == ViewPager.SCROLL_STATE_IDLE) {
                            buildBurgerActivity.this.bottomBunPager.setCurrentItem(buildBurgerActivity.this.upperBunPager.getCurrentItem() , false);
                        }
                    }
                });

        setViewPager(BunType.getAsListArray(false),
                R.id.BottomBun,
                curBurger.getBun().getPosition() + (HALF_LOOPS * BunType.size()),
                new ViewPager.OnPageChangeListener() {
                    private int mScrollState = ViewPager.SCROLL_STATE_IDLE;

                    @Override
                    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                        if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                            return;
                        }
                        curBurger.updateBurger(BunType.get(position % BunType.size()));
                        buildBurgerActivity.this.upperBunPager.scrollTo(buildBurgerActivity.this.bottomBunPager.getScrollX(),
                                buildBurgerActivity.this.bottomBunPager.getScrollY());
                        updateCurrentBurgerDesc();

                    }

                    @Override
                    public void onPageSelected(final int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(final int state) {
                        mScrollState = state;
                        if (state == ViewPager.SCROLL_STATE_IDLE) {
                            buildBurgerActivity.this.upperBunPager.setCurrentItem(buildBurgerActivity.this.bottomBunPager.getCurrentItem() , false);
                        }
                    }
                });

        setViewPager(CheeseType.getAsListArray(),
                R.id.Cheese,
                curBurger.getCheese().getPosition() + (HALF_LOOPS * CheeseType.size()),
                new ViewPager.OnPageChangeListener() {
            private int mScrollState = ViewPager.SCROLL_STATE_IDLE;

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                curBurger.updateBurger(CheeseType.get(position % CheeseType.size()));
                updateCurrentBurgerDesc();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mScrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    updateCurrentBurgerDesc();
                }
            }
        });

        setViewPager(PattyType.getAsListArray(),
                R.id.Patty,
                curBurger.getPatty().getPosition() + (HALF_LOOPS * PattyType.size()),
                new ViewPager.OnPageChangeListener() {
            private int mScrollState = ViewPager.SCROLL_STATE_IDLE;

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                curBurger.updateBurger(PattyType.get(position % PattyType.size()));
                updateCurrentBurgerDesc();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mScrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    updateCurrentBurgerDesc();
                }
            }
        });

        setViewPager(TomatoType.getAsListArray(),
                R.id.Tomato,
                curBurger.getTomato().getPosition() + (HALF_LOOPS * TomatoType.size()),
                new ViewPager.OnPageChangeListener() {

            private int mScrollState = ViewPager.SCROLL_STATE_IDLE;
            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                curBurger.updateBurger(TomatoType.get(position % TomatoType.size()));
                updateCurrentBurgerDesc();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mScrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    updateCurrentBurgerDesc();
                }
            }
        });

        setViewPager(LettuceType.getAsListArray(),
                R.id.Lettuce,
                curBurger.getLettuce().getPosition() + (HALF_LOOPS * LettuceType.size()),
                new ViewPager.OnPageChangeListener() {
            private int mScrollState = ViewPager.SCROLL_STATE_IDLE;
            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                curBurger.updateBurger(LettuceType.get(position % LettuceType.size()));
                updateCurrentBurgerDesc();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mScrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    updateCurrentBurgerDesc();
                }
            }
        });

        setViewPager(SauceType.getAsListArray(),
                R.id.Sauce,
                curBurger.getSauce().getPosition() + (HALF_LOOPS * SauceType.size()),
                new ViewPager.OnPageChangeListener() {
            private int mScrollState = ViewPager.SCROLL_STATE_IDLE;

            @Override
            public void onPageSelected(int position) {}

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                curBurger.updateBurger(SauceType.get(position % SauceType.size()));
                updateCurrentBurgerDesc();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mScrollState = state;
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    updateCurrentBurgerDesc();
                }
            }
        });

        ImageButton orderButton = findViewById(R.id.add);

        orderButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent resultIntent = new Intent(buildBurgerActivity.this, MainActivity.class);
                resultIntent.putExtra("order", curBurger);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        updateCurrentBurgerDesc();
    }

    private void updateCurrentBurgerDesc() {
        TextView curOrderText = findViewById(R.id.CurOrder);
        curOrderText.setText(Html.fromHtml(String.format(getString(R.string.curOrder), curBurger.getDescription())));
    }

    private void setViewPager(List<FoodItemModel> model, int id, int position, ViewPager.OnPageChangeListener listener ) {
        CardAdapter adapter;
        ViewPager viewPager;

        adapter = new CardAdapter(model, this, true);
        viewPager = findViewById(id);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position, false);
        viewPager.addOnPageChangeListener(listener);
    }
}
