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
    private DiscountPresentPolicy profitPresentPolicy;
    private TotalProfitPolicy totalProfitPolicy;
    private ExpectedTotalAfterDiscount expectedTotalAfterDiscount;
    private BadgePolicy badgePolicy;

    public PromotionController(Reader reader, Writer writer) {
        viewController = new ViewController(reader, writer);
        domainController = new DomainController();
    }

    public void run() {
        viewController.outputWelcome();

        day = viewController.inputDate();

        ordersMenuCount = viewController.inputOrdersMenuCount();

        orderTotalBeforeDiscount = domainController.getOrderTotalBeforeDiscount(ordersMenuCount);

        profitPresentPolicy = domainController.getProfitPresentPolicy(day, ordersMenuCount, orderTotalBeforeDiscount);

        totalProfitPolicy = domainController.getTotalProfitPolicy(profitPresentPolicy);

        expectedTotalAfterDiscount = domainController.getExpectedTotalAfterDiscount(orderTotalBeforeDiscount, totalProfitPolicy);

        badgePolicy = domainController.getBadgePolicy(totalProfitPolicy);

        showResult();
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
