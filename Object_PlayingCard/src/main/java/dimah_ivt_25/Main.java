package dimah_ivt_25;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static void asserts(){
        Playing_card card = new Playing_card(1,10);
        assert card.getCart_color() == ("Черный"): "Ошибка: Неверный цвет карты";
        assert card.getCart_power() == 10: "Ошибка: Неверная мощность карты";
        assert card.getSuit_cart() == 1: "Ошибка: Неверная масть карты";
    }
    static void main(String[] args) {
        asserts();
        // card1 -- ссылка на объект
        Playing_card card1;
        // card2 -- ссылка на объект (объектов пока нет)
        Playing_card card2 = null;

        // Создаем объект (new), инициализируем объект (Playing_card)
        card1 = new Playing_card();
        card2 = new Playing_card(2, 14);

        try {
            // Создаем объект (карта король черви)
            Playing_card card3 = new Playing_card(3,13);
            // Переназначаем поле мощности объекта (с короля на даму)
            card3.setCart_power(12);
            // Вывод сеттера масти карты (черви/3)
            IO.println(card3.getSuit_cart());
            // Вывод сеттера мощности карты (дама/12)
            IO.println(card3.getCart_power());
            IO.println(card3);  // Вывод строки
        } catch (IllegalArgumentException e){   // Проверка исключения неверных данных
            IO.println(e.toString());
        }
        // Массив со всей колодой (по очереди)
        ArrayList<Playing_card> deck = new work_to_Playingcards().getDeck();

        IO.println("Вся колода:");
        // Вывод массива
        for (int i = 0; i < 36; i++) {
            // get() - метод для поссылочному обращению к элементу динамического списка ArrayList
            IO.println(deck.get(i).toString());
        }
        // Начальные карты для игры (6 радомных карт)
        ArrayList<Playing_card> Cards_for_game = new work_to_Playingcards().get_start_cards(deck);

        IO.println("\nВыданные карты");
        for (Playing_card card: Cards_for_game) {
            IO.println(card.toString());
        }

        filework.clear_file_open_array("Колода.txt");    //
        filework.print_el_array_in_file("Колода.txt", deck);

        // Создание автоматического массива из объектов Playing_card
        Playing_card[] deck1 = new Playing_card[3];
        for (int i = 0; i < 3; i++) {   // Запись в массив 3 карты валета пики
            deck1[i] = new Playing_card(2,12);
        }
        deck1[0].setSuit_cart(1);   // Замена первой карты в массиве на вальта крести
    }
}
