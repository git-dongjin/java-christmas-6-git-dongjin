package christmas.controller;

import christmas.controller.domain.DomainController;
import christmas.controller.view.ViewController;
import christmas.domain.day.Day;
import christmas.domain.money.ExpectedTotalAfterDiscount;
import christmas.domain.money.OrderTotalBeforeDiscount;
import christmas.domain.money.ProfitTotal;
import christmas.domain.order.OrdersMenuCount;
import christmas.domain.policy.*;
import christmas.enums.Badge;
import christmas.view.input.Reader;
import christmas.view.output.Writer;

import java.util.ArrayList;
import java.util.List;

public class PromotionController {
    private final DomainController domainController;
    private final ViewController viewController;

    public PromotionController(Reader reader, Writer writer) {
        viewController = new ViewController(reader, writer);
        domainController = new DomainController();
    }

    public void run() {
        viewController.outputWelcome();
        Day day = viewController.inputDate();
        OrdersMenuCount ordersMenuCount = viewController.inputOrdersMenuCount();
        OrderTotalBeforeDiscount orderTotalBeforeDiscount = new OrderTotalBeforeDiscount(ordersMenuCount);

        List<ProfitPolicy> profitPoliciesList = new ArrayList<>();
        profitPoliciesList.add(new ChristmasDiscountPolicy(day));
        profitPoliciesList.add(new WeekdayDiscountPolicy(day, ordersMenuCount));
        profitPoliciesList.add(new WeekendDiscountPolicy(day, ordersMenuCount));
        profitPoliciesList.add(new SpecialDiscountPolicy(day));
        PresentMenuPolicy presentPolicy = new PresentMenuPolicy(day, orderTotalBeforeDiscount);
        profitPoliciesList.add(presentPolicy);

        ProfitPolicies profitPolicies = new ProfitPolicies(profitPoliciesList);
        ProfitTotal profitTotal = new ProfitTotal(profitPolicies);
        ExpectedTotalAfterDiscount expectedTotalAfterDiscount = new ExpectedTotalAfterDiscount(orderTotalBeforeDiscount, profitTotal);
        BadgePolicy badgePolicy = new BadgePolicy(profitTotal);

        viewController.outputNewLine();
        viewController.output(presentPolicy.showPresents());
        viewController.output(profitPolicies);
        viewController.output(profitTotal);
        viewController.output(expectedTotalAfterDiscount);
        viewController.output(badgePolicy);
    }
}
