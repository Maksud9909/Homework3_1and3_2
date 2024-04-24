package org.example.Homework3_1;


import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс для реализации домашнего задания номер три, часть 1.
 * Для решения этой задачи было использовано regex, Stream API а также параллельный стрим(потоки)
 */
public class Homework3_1 {
    /**
     *
     *
     * @param text - заданный текст
     * @return - словарь слов и количество их появлений в данном тексте
     */
    public Map<String, Integer> countWords(String text){
        if (text == null || text.isEmpty()) {
            return null; // Или более подходящее значение по умолчанию
        }

        // Используем параллельный стрим для обработки текста
        return Arrays.stream(text.split("\\P{L}+"))
                .parallel() // Включаем параллельность
                .map(String::toLowerCase)
                .collect(Collectors
                        .groupingByConcurrent(Function.identity(), ConcurrentHashMap::new, Collectors.summingInt(w -> 1)));
    }
}