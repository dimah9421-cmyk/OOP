package dimah_ivt_25;

import java.util.ArrayList;
import java.util.Random;

public class work_to_Playingcards {
    /// Метод создаем новый Arraylist и записывает в него всевозможные карты в колоде
    ///
    /// @return созданный и заполненный массив Arraylist
    public ArrayList<Playing_card> getDeck() {
        // Создаем динамический массив типа Playing_card
        ArrayList<Playing_card> deck = new ArrayList<Playing_card>();
        for (int suit = 1; suit <= 4; suit++) {          // Цикл по 4 мастям
            for (int power = 6; power <= 14; power++) {  // Цикл по мощности от 6 до Туза (14)
                Playing_card card = new Playing_card();  // Создаем объект
                card.setSuit_cart(suit);                 // Заполняем поле масти нашей карты
                card.setCart_power(power);               // Заполняем поле мощности нашей карты
                deck.add(card);  // Добавляем в конец списка значения переменной card
            }
        }
        return deck;
    }

    /// Метод создает и записывает в Arraylist 6 рандомных карт
    ///
    /// @return заполненный массив
    public ArrayList<Playing_card> get_start_cards(ArrayList<Playing_card> deck) {

        if (deck == null || deck.size() < 6)
            return new ArrayList<Playing_card>();

        Random rand = new Random(); // Инициализация генератора псевдо-случайныйх чисел
        ArrayList<Playing_card> Cards_for_game = new ArrayList<Playing_card>();
        while (Cards_for_game.size() < 6) {
            // Генерируем случайный индекс в пределах размера колоды (0 до 35)
            int randInd = rand.nextInt(deck.size());
            Playing_card randCard = deck.get(randInd);

            // Проверяем, нет ли уже этой карты у игрока в руке
            if (!Cards_for_game.contains(randCard)) {
                // contains - метод проверяет есть ли уже подобный элемент в arraylist-е
                // если есть, то возвращает 1, если нет то 0
                Cards_for_game.add(randCard);
            }
        }
        return Cards_for_game;
    }
}