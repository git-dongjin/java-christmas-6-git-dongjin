package christmas.controller;

import christmas.domain.day.Day;
import christmas.domain.money.ExpectedTotalAfterDiscount;
import christmas.domain.money.OrderTotalBeforeDiscount;
import christmas.domain.money.ProfitTotal;
import christmas.domain.order.OrdersMenuCount;
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

    public ProfitTotal getProfitTotal(ProfitPolicies profitPolicies) {
        return new ProfitTotal(profitPolicies);
    }

    private MinimumOrderTotalPolicy getMinimumOrderTotalPolicy(OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        return new MinimumOrderTotalPolicy(orderTotalBeforeDiscount);
    }

    public ExpectedTotalAfterDiscount getExpectedTotalAfterDiscount(OrderTotalBeforeDiscount orderTotalBeforeDiscount, ProfitTotal profitTotal) {
        return new ExpectedTotalAfterDiscount(orderTotalBeforeDiscount, profitTotal);
    }

    public BadgePolicy getBadgePolicy(ProfitTotal profitTotal) {
        return new BadgePolicy(profitTotal);
    }
}
