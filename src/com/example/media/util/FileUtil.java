package com.example.media.util;

import com.example.media.classes.Track;
import com.example.media.classes.Video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас-утиліта для зчитування вхідних файлів з даними.
 *
 * Файли:
 * - tracks.txt (список музичних треків)
 * - videos.txt (список відео)
 *
 * Завдання студентів:
 * Реалізувати методи readTracks(...) та readVideos(...),
 * які відкривають відповідні .txt файли, читають їх рядок за рядком
 * і перетворюють кожен рядок у об'єкт Track або Video.
 *
 * Використайте:
 * - java.nio.file.Files
 * - java.nio.file.Paths
 * - метод Files.readAllLines(...)
 * або Files.lines(...) для роботи зі Stream API.
 */
public class FileUtil {

    /**
     * Зчитує список треків із файлу.
     *
     * Формат вхідного файлу tracks.txt:
     * ---------------------------------
     * Title;Artist;Genre;Duration;Rating
     * Shape of You;Ed Sheeran;Pop;240;9
     * Smells Like Teen Spirit;Nirvana;Rock;301;10
     * ...
     *
     * Пояснення полів:
     * - Title (String)    → назва треку
     * - Artist (String)   → виконавець
     * - Genre (String)    → жанр (Pop, Rock, Electronic, HipHop)
     * - Duration (int)    → тривалість у секундах
     * - Rating (int)      → рейтинг від 1 до 10
     *
     * TODO: Реалізувати:
     * - Пропустити перший рядок (заголовки колонок)
     * - Розбити кожен рядок по символу ";"
     * - Створити об'єкт Track з цих даних
     * - Додати його у список
     */
    public static List<Track> readTracks(String filename) throws IOException {
        List<Track> tracks = new ArrayList<>();
        // TODO: зчитати рядки з файлу
        // TODO: пропустити перший рядок (headers)
        // TODO: для кожного рядка розбити його на частини (split(";"))
        // TODO: створити новий Track(...) і додати у список
        return tracks;
    }

    /**
     * Зчитує список відео із файлу.
     *
     * Формат вхідного файлу videos.txt:
     * ---------------------------------
     * Title;Channel;Category;Duration;Views
     * Top 10 Java Tips;CodeAcademy;Education;600;25000
     * Funny Cats Compilation;AnimalFun;Entertainment;420;1000000
     * ...
     *
     * Пояснення полів:
     * - Title (String)     → назва відео
     * - Channel (String)   → канал, який виклав відео
     * - Category (String)  → категорія (Education, Entertainment, Sports, Food)
     * - Duration (int)     → тривалість у секундах
     * - Views (int)        → кількість переглядів
     *
     * TODO: Реалізувати:
     * - Пропустити перший рядок (заголовки колонок)
     * - Розбити кожен рядок по символу ";"
     * - Створити об'єкт Video з цих даних
     * - Додати його у список
     */
    public static List<Video> readVideos(String filename) throws IOException {
        List<Video> videos = new ArrayList<>();
        // TODO: зчитати рядки з файлу
        // TODO: пропустити перший рядок (headers)
        // TODO: для кожного рядка розбити його на частини (split(";"))
        // TODO: створити новий Video(...) і додати у список
        return videos;
    }
}

