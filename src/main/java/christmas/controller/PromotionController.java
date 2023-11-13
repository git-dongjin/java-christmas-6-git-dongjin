package christmas.controller;

import christmas.domain.unit.Day;
import christmas.domain.total.ExpectedTotalAfterDiscount;
import christmas.domain.total.OrderTotalBeforeDiscount;
import christmas.domain.policy.TotalProfitPolicy;
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
    private ProfitPresentPolicy profitPresentPolicy;
    private TotalProfitPolicy totalProfitPolicy;
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

        profitPresentPolicy = getProfitPresentPolicy();

        totalProfitPolicy = getTotalProfitPolicy();

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

    private ProfitPresentPolicy getProfitPresentPolicy() {
        return domainController.getProfitPresentPolicy(day, ordersMenuCount, orderTotalBeforeDiscount);
    }

    private TotalProfitPolicy getTotalProfitPolicy() {
        return domainController.getTotalProfitPolicy(profitPresentPolicy);
    }

    private ExpectedTotalAfterDiscount getExpectedTotalAfterDiscount() {
        return domainController.getExpectedTotalAfterDiscount(orderTotalBeforeDiscount, totalProfitPolicy);
    }

    private BadgePolicy getBadgePolicy() {
        return domainController.getBadgePolicy(totalProfitPolicy);
    }

    private void showResult() {
        viewController.output(day);
        viewController.output(ordersMenuCount);
        viewController.output(orderTotalBeforeDiscount);
        viewController.output(profitPresentPolicy.presentsDetails());
        viewController.output(profitPresentPolicy.profitDetails());
        viewController.output(totalProfitPolicy);
        viewController.output(expectedTotalAfterDiscount);
        viewController.output(badgePolicy);
    }
}
