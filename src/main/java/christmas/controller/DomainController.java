package christmas.controller;

import christmas.domain.unit.Day;
import christmas.domain.total.ExpectedTotalAfterDiscount;
import christmas.domain.total.OrderTotalBeforeDiscount;
import christmas.domain.policy.TotalProfitPolicy;
import christmas.domain.unit.OrdersMenuCount;
import christmas.domain.policy.*;

import java.util.List;

public class DomainController {

    public OrderTotalBeforeDiscount getOrderTotalBeforeDiscount(OrdersMenuCount ordersMenuCount) {
        return new OrderTotalBeforeDiscount(ordersMenuCount);
    }

    public ProfitPresentPolicy getProfitPresentPolicy(Day day, OrdersMenuCount ordersMenuCount, OrderTotalBeforeDiscount orderTotalBeforeDiscount) {
        PresentPolicy presentPolicy = new PresentMenuPolicy(day, orderTotalBeforeDiscount);

        ChristmasDiscountPolicy christmasDiscountPolicy = new ChristmasDiscountPolicy(day);
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy(day, ordersMenuCount);
        WeekendDiscountPolicy weekendDiscountPolicy = new WeekendDiscountPolicy(day, ordersMenuCount);
        SpecialDiscountPolicy specialDiscountPolicy = new SpecialDiscountPolicy(day);
        List<ProfitPolicy> profitPoliciesList = List.of(christmasDiscountPolicy, weekdayDiscountPolicy, weekendDiscountPolicy, specialDiscountPolicy);
        ProfitPolicies profitPolicies = new ProfitPolicies(List.copyOf(profitPoliciesList));

        MinimumOrderTotalPolicy minimumOrderTotalPolicy = new MinimumOrderTotalPolicy(orderTotalBeforeDiscount);

        return new ProfitPresentPolicy(presentPolicy, profitPolicies, minimumOrderTotalPolicy);
    }

    public TotalProfitPolicy getTotalProfitPolicy(ProfitPresentPolicy profitPresentPolicy) {
        return new TotalProfitPolicy(profitPresentPolicy);
    }

    public ExpectedTotalAfterDiscount getExpectedTotalAfterDiscount(OrderTotalBeforeDiscount orderTotalBeforeDiscount, TotalProfitPolicy profitTotal) {
        return new ExpectedTotalAfterDiscount(orderTotalBeforeDiscount, profitTotal);
    }

    public BadgePolicy getBadgePolicy(TotalProfitPolicy profitTotal) {
        return new BadgePolicy(profitTotal);
    }
}
