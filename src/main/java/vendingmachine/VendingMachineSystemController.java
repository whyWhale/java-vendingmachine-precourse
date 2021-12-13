package vendingmachine;

import vendingmachine.system.Validation;
import vendingmachine.system.ValidationImplementation;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachineSystemController {

    private static final String INPUT_HOLDING_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ERROR_INPUT_HOLDING_MONEY_MESSAGE = "[ERROR] 금액은 100 이상 그리고 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다.";
    private static final String INPUT_PRODUCT_PRICE_STOCK_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ERROR_PRODUCT_PRICE_STOCK_MESSAGE = "[ERROR] [{상품명},{가격},{수량}] 형식으로 입력하셔야 하며 공백이 포함되선 안됩니다. 상품 구분자는 ';' 입니다.";
    private static final String INPUT_USER_INSERT_MONEY_MESSAGE = "투입 금액을 입력해주세요. ";
    private static final String ERROR_USER_INSERT_MONEY_MESSAGE = "[ERROR] 투입 금액은 1억 이하의 숫자이여야 하며 10으로 나누어 떨어져야 합니다.";
    private static final String INPUT_PRODUCT_NAME_TO_BUY_MESSAGE = "구매할 상품명을 입력해주세요 ";
    private static final String ERROR_PRODUCT_NAME_TO_BUY_MESSAGE = "[ERROR] 상품명은 한글로 입력해야 합니다. 또는 존재하지 않습니다.";
    private final Validation validation;

    public VendingMachineSystemController() {
        validation = new ValidationImplementation();
    }

    public void start() {
        inputHoldingMoney();
        inputProductNameAndPriceAndStock();
        inputUserInsertMoney();
        inputProductNameToBuy();
    }

    public void inputHoldingMoney() {
        boolean isValidInput = false;
        do {
            try {
                printConsoleMessage(INPUT_HOLDING_MONEY_MESSAGE);
                isValidInput = validation.isValidHoldingMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_INPUT_HOLDING_MONEY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
    }

    public void inputProductNameAndPriceAndStock() {
        boolean isValidInput = false;
        do {
            try {
                printConsoleMessage(INPUT_PRODUCT_PRICE_STOCK_MESSAGE);
                isValidInput = validation.isValidProductNameAndPriceAndStock(Console.readLine());
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_PRODUCT_PRICE_STOCK_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
    }

    public void inputUserInsertMoney(){
        boolean isValidInput = false;
        do {
            try {
                printConsoleMessage(INPUT_USER_INSERT_MONEY_MESSAGE);
                isValidInput = validation.isValidUserInsertMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_USER_INSERT_MONEY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
    }

    public void inputProductNameToBuy(){
        boolean isValidInput = false;
        do {
            try {
                printConsoleMessage(INPUT_PRODUCT_NAME_TO_BUY_MESSAGE);
                isValidInput = validation.isValidProductNameToBuy(Console.readLine());
            } catch (IllegalArgumentException e) {
                printConsoleMessage(ERROR_PRODUCT_NAME_TO_BUY_MESSAGE);
                isValidInput = false;
            }
        } while (!isValidInput);
    }

    public void printConsoleMessage(String message) {
        System.out.println(message);
    }

}