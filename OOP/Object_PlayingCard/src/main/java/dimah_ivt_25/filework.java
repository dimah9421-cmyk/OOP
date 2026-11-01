package dimah_ivt_25;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class filework {
    /// Функция для сохранения данных для будущего использования
    /// Функция может вызвать исключение если нет доступа к файлу
    /// @param Card - динамический массив типа Playing_card для взятия данных
    /// Возможно исключение throws IOException
    static void print_el_array_in_file(String file_name1, ArrayList<Playing_card> Card){
        // Если массив пуст или не выделен, то завершаем функцию
        if (Card == null) return;
        // Проверка исключения (попытка открыть файл для записи)
        try (PrintWriter out = new PrintWriter(new java.io.FileWriter(file_name1, true))) {
            for (Playing_card card: Card) {
                out.printf("%s\n", card.toString()); // Запись значений массива в файл через пробел
            }
        }
        catch (IOException e){  // Обработка исключения
            System.out.println("Ошибка записи файла");
        }
    }

    /// Функция для очистки файла (удаления данных из файла)
    /// Функция может вызвать исключение если нет доступа к файлу
    /// Возможно исключение throws IOException
    static void clear_file_open_array(String filename1){
        // Проверка исключения (пытаемся открыть файл для его очистки
        try (java.io.FileWriter writer = new java.io.FileWriter(filename1,false)){
        } catch (IOException e){    // Обработка исключений
            System.out.println("Ошибка удаления файла");
        }
    }
}
