package christmas.controller;

import christmas.domain.Day;
import christmas.domain.policy.PresentGivePolicy;
import christmas.domain.money.OrderTotalBeforeDiscount;
import christmas.domain.order.OrdersMenuCount;
import christmas.enums.Gift;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printWelcome();
        Day day = inputView.readDate();
        OrdersMenuCount ordersMenuCount = inputView.readOrdersMenuCount();
        outputView.print(day);
        outputView.print(ordersMenuCount);
        OrderTotalBeforeDiscount orderTotalBeforeDiscount = new OrderTotalBeforeDiscount(ordersMenuCount);
        outputView.print(orderTotalBeforeDiscount);
        PresentGivePolicy gifts = new PresentGivePolicy(Gift.getPresents(ordersMenuCount.calculateOrderTotal()));
        outputView.print(gifts);
    }
}
