package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    //тестировать конструктор на исключения из условия

    @Test
    public void shouldConstructorInitialAllPozitiv() throws IllegalArgumentException { // начальные условия удовлетворяют требованиям

        Assertions.assertDoesNotThrow(
                () -> {
                    new CreditAccount(0, 5_000, 5);
                });
    }

    @Test
    public void shouldConstructorInitialBalanceNegativ() throws IllegalArgumentException { // начальный баланс не может быть отрицательным числом

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-5, 5_000, 5);
        });
    }

    @Test
    public void shouldConstructorInitialLimitNegativ() throws IllegalArgumentException {//лимит не может быть отрицательным числом

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, -5_000, 5);
        });
    }

    @Test
    public void shouldConstructorRateNegativ() throws IllegalArgumentException {//ставка не может быть отрицательным числом

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, 5_000, -5);
        });

    }

    //тестировать метод add (пополнения карты)

    @Test
    public void shouldAddToBalanceNull() { //пополнение счета при нулевом балансе
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToBalanceNeg() {//пополнение счета при отрицательном балансе
        CreditAccount account = new CreditAccount(
                -5,
                5_000,
                15
        );

        account.add(5);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToBalancePoz() {//пополнение счета при положительном балансе
        CreditAccount account = new CreditAccount(
                5,
                5_000,
                15
        );

        account.add(5);

        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void shouldAddToBalanceNegativAmount() {//пополнение счета на отрицательную сумму
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                5
        );

        account.add(-10);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceNullAmount() {//пополнение счета на ноль
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

  //   тестировать метод pay, покупка с карты
    @Test
    public void shouldPayToPositiveBalancePozAmount() {//покупка при положительном балансе на счету
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToNullBalancePozAmount() {//покупка при нулевом балансе на счету
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                5
        );

        account.pay(100);

        Assertions.assertEquals(-100, account.getBalance());
    }

    @Test
    public void shouldPayToNegBalancePozAmount() {//покупка при отрицательном балансе на счету
        CreditAccount account = new CreditAccount(
                -100,
                5_000,
                5
        );

        account.pay(100);

        Assertions.assertEquals(-200, account.getBalance());
    }

    @Test
    public void shouldPayToMinBalancePozAmount() {//покупка, приводящая к выходу за лимит
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                5
        );

        account.pay(5_500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToNullBalanceNegAmount() {//недопустимое значение суммы покупки (отрицтельное)
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                5
        );

        account.pay(-3_500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayToYearChange() {//вычисление процентной ставки при нулевом балансе
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldPayToYearChangePozBalance() {//вычисление процентной ставки при положительном балансе
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldPayToYearChangeNegBalance() {//вычисление процентной ставки при отрицательном балансе
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

}

