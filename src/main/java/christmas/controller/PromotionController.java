package christmas.controller;

import christmas.domain.unit.Day;
import christmas.domain.total.ExpectedTotalAfterDiscount;
import christmas.domain.total.OrderTotalBeforeDiscount;
import christmas.domain.profit.TotalProfit;
import christmas.domain.unit.OrdersMenuCount;
import christmas.domain.policy.*;
import christmas.view.input.Reader;
import christmas.view.output.Writer;

public class PromotionController {
    private final DomainController domainController;
    private final ViewController viewController;
    private Day day;
    private OrdersMenuCount ordersMenuCount;
    private OrderTotalBeforeDiscount orderTotalBeforeDiscount;
    private PresentPolicy presentPolicy;
    private ProfitPolicies profitPolicies;
    private TotalProfit profitTotal;
    private ExpectedTotalAfterDiscount expectedTotalAfterDiscount;
    private BadgePolicy badgePolicy;

    public PromotionController(Reader reader, Writer writer) {
        viewController = new ViewController(reader, writer);
        domainController = new DomainController();
    }

    public void run() {
        welcomeMessage();

        day = inputDate();

        ordersMenuCount = inputOrdersMenuCount();

        orderTotalBeforeDiscount = getOrderTotalBeforeDiscount();

        presentPolicy = getPresentPolicy();

        profitPolicies = getProfitPolicies();

        profitTotal = getProfitTotal();

        expectedTotalAfterDiscount = getExpectedTotalAfterDiscount();

        badgePolicy = getBadgePolicy();

        showResult();
    }

    private void welcomeMessage() {
        viewController.outputWelcome();
    }

    private Day inputDate() {
        return viewController.inputDate();
    }

    private OrdersMenuCount inputOrdersMenuCount() {
        return viewController.inputOrdersMenuCount();
    }

    private OrderTotalBeforeDiscount getOrderTotalBeforeDiscount() {
        return domainController.getOrderTotalBeforeDiscount(ordersMenuCount);
    }

    private PresentPolicy getPresentPolicy() {
        return domainController.getPresentPolicy(day, orderTotalBeforeDiscount);
    }

    private ProfitPolicies getProfitPolicies() {
        return domainController.getProfitPolicies(day, ordersMenuCount, orderTotalBeforeDiscount);
    }

    private TotalProfit getProfitTotal() {
        return domainController.getProfitTotal(profitPolicies);
    }

    private ExpectedTotalAfterDiscount getExpectedTotalAfterDiscount() {
        return domainController.getExpectedTotalAfterDiscount(orderTotalBeforeDiscount, profitTotal);
    }

    private BadgePolicy getBadgePolicy() {
        return domainController.getBadgePolicy(profitTotal);
    }

    private void showResult() {
        viewController.output(day);
        viewController.output(ordersMenuCount);
        viewController.output(orderTotalBeforeDiscount);
        viewController.output(presentPolicy.showPresents());
        viewController.output(profitPolicies);
        viewController.output(profitTotal);
        viewController.output(expectedTotalAfterDiscount);
        viewController.output(badgePolicy);
    }
}
