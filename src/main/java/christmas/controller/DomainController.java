package christmas.controller;

import christmas.domain.unit.Day;
import christmas.domain.total.ExpectedTotalAfterDiscount;
import christmas.domain.total.OrderTotalBeforeDiscount;
import christmas.domain.profit.TotalProfit;
import christmas.domain.unit.OrdersMenuCount;
import christmas.domain.policy.*;

import java.util.ArrayList;
import java.util.List;

public class DomainController {

    public OrderTotalBeforeDiscount getOrderTotalBeforeDiscount(OrdersMenuCount ordersMenuCount) {
        return new OrderTotalBeforeDiscount(ordersMenuCount);
    }

    public PresentPolicy getPresentPolicy(Day day, OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        return new PresentMenuPolicy(day, orderTotalBeforeDiscount);
    }

    public ProfitPolicies getProfitPolicies(Day day, OrdersMenuCount ordersMenuCount, OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        List<ProfitPolicy> profitPoliciesList = new ArrayList<>();
        MinimumOrderTotalPolicy minimumOrderTotalPolicy = getMinimumOrderTotalPolicy(orderTotalBeforeDiscount);
        if (!minimumOrderTotalPolicy.isEventAvailable()) {
            return new ProfitPolicies(profitPoliciesList);
        }

        profitPoliciesList.add(new ChristmasDiscountPolicy(day));
        profitPoliciesList.add(new WeekdayDiscountPolicy(day, ordersMenuCount));
        profitPoliciesList.add(new WeekendDiscountPolicy(day, ordersMenuCount));
        profitPoliciesList.add(new SpecialDiscountPolicy(day));
        profitPoliciesList.add(new PresentMenuPolicy(day, orderTotalBeforeDiscount));

        return new ProfitPolicies(profitPoliciesList);
    }

    public TotalProfit getProfitTotal(ProfitPolicies profitPolicies) {
        return new TotalProfit(profitPolicies);
    }

    private MinimumOrderTotalPolicy getMinimumOrderTotalPolicy(OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        return new MinimumOrderTotalPolicy(orderTotalBeforeDiscount);
    }

    public ExpectedTotalAfterDiscount getExpectedTotalAfterDiscount(OrderTotalBeforeDiscount orderTotalBeforeDiscount, TotalProfit profitTotal) {
        return new ExpectedTotalAfterDiscount(orderTotalBeforeDiscount, profitTotal);
    }

    public BadgePolicy getBadgePolicy(TotalProfit profitTotal) {
        return new BadgePolicy(profitTotal);
    }
}
