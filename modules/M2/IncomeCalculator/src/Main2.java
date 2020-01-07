import java.util.Scanner;

public class Main2 {
    private static int minIncome = 200000; // минимальный доход
    private static int maxIncome = 900000; // максимальный доход

    private static int officeRentCharge = 140000; // аренда
    private static int telephonyCharge = 12000; // цена доступа к телефону
    private static int internetAccessCharge = 7200; // цена доступа к интернет

    private static int assistantSalary = 45000; // зп помощника
    private static int financeManagerSalary = 90000; // зп финансового менеджера

    private static double mainTaxPercent = 0.24; // основной налог
    private static double managerPercent = 0.15; // процент менеджера

    private static double minInvestmentsAmount = 100000; // минимальная сумма инвестиций

    public static void main(String[] args) {
        // расчет минимальной суммы дохода для инвестирования
        double minIncomeForInvestments = (minInvestmentsAmount / (1 - mainTaxPercent) + calculateFixedCharges())
                / (1 - managerPercent);
        System.out.println(minIncomeForInvestments);
        while (true) {
            System.out.println("Введите сумму доходов компании за месяц " +
                    "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt(); // считывание числа из терминала

            if (!checkIncomeRange(income)) {   // проверка на то что доход вписан в границы от 200 тыс до 900 тыс
                continue;
            }

            double managerSalary = income * managerPercent; //подсчет зарплаты менеджера
            double pureIncome = income - managerSalary -
                    calculateFixedCharges();  // подсчет чистого дохода
            double taxAmount = mainTaxPercent * pureIncome; // подсчет основного налога
            double pureIncomeAfterTax = pureIncome - taxAmount; // подсчет доход - налог

            boolean canMakeInvestments = pureIncomeAfterTax >=
                    minInvestmentsAmount; // при таком условии можно делать инвестиции

            System.out.println("Зарплата менеджера: " + managerSalary); // вывод информации по зп менеджера
            System.out.println("Общая сумма налогов: " +
                    (taxAmount > 0 ? taxAmount : 0)); // информация по сумме налогов
            System.out.println("Компания может инвестировать: " +
                    (canMakeInvestments ? "да" : "нет")); // вывод информации о возможности инвестиций
            if (pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!"); // выводится сообщение если доход отрицательный
            }
        }
    }

    private static boolean checkIncomeRange(int income) //метод который проверяет правильность введенного дохода
    {
        if (income < minIncome) // проверка нижней границы
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if (income > maxIncome) // проверка вверхней границы
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() //метод рассчитывания расходов
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary; // сумма трат на аренду офиса, телефонную связь, интернет,
    }                                 // зп помощника и зп менеджера
}
