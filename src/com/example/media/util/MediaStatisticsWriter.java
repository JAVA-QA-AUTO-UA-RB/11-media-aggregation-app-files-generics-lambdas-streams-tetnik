package com.example.media.util;

import com.example.media.classes.Playlist;
import com.example.media.classes.Track;
import com.example.media.classes.Video;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Клас-утиліта для запису статистики у вихідні файли.
 *
 * Студенти мають реалізувати методи нижче з використанням:
 * - Stream API
 * - лямбда-виразів
 * - method references
 *
 * Формат вихідних файлів має бути простим і "людиночитабельним"
 * (див. приклади у README.md).
 */
public class MediaStatisticsWriter {

    /**
     * Запис статистики по музичних треках у файл.
     *
     * Очікуваний формат файлу `tracks_output.txt`:
     * --------------------------------------------
     * Tracks count: <загальна кількість треків>
     * Average duration: <середня тривалість у секундах> seconds
     *
     * Top 3 tracks by rating:
     * 1. <назва треку> (rating <рейтинг>)
     * 2. <назва треку> (rating <рейтинг>)
     * 3. <назва треку> (rating <рейтинг>)
     *
     * Pop tracks:
     * - <назва треку>
     * - <назва треку>
     * --------------------------------------------
     *
     * Пояснення:
     * - Tracks count → кількість елементів у плейлисті
     * - Average duration → середня тривалість у секундах
     * - Top 3 → відсортовані за рейтингом спаданням,
     *   при однаковому рейтингу брати найдовші
     * - Pop tracks → усі треки, у яких жанр == "Pop"
     */
    public static void writeTrackStats(Playlist<Track> playlist, String filename) throws IOException {
        List<Track> tracks = playlist.getItems();

        int total = tracks.size();
        double avgDuration = tracks.stream().mapToInt(Track::getDuration).average().orElse(0);

        List<Track> top3 = tracks.stream()
                .sorted(Comparator
                        .comparingInt(Track::getRating)
                        .reversed()
                        .thenComparing(Comparator.comparingInt(Track::getDuration).reversed()))
                .limit(3)
                .collect(Collectors.toList());

        List<Track> popTracks = tracks.stream()
                .filter(t -> t.getGenre().equalsIgnoreCase("Pop"))
                .collect(Collectors.toList());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Tracks count: " + total);
            bw.newLine();
            bw.write(String.format("Average duration: %.0f seconds", avgDuration));
            bw.newLine();
            bw.newLine();
            bw.write("Top 3 tracks by rating:");
            bw.newLine();

            int index = 1;
            for (Track t : top3) {
                bw.write(index++ + ". " + t.getTitle() + " (rating " + t.getRating() + ")");
                bw.newLine();
            }

            bw.newLine();
            bw.write("Pop tracks:");
            bw.newLine();
            for (Track t : popTracks) {
                bw.write("- " + t.getTitle());
                bw.newLine();
            }
        } // 🔹 ← правильно закрили try
    }
        // TODO: Реалізуйте цей метод
        // Підказки:
        // - Використайте playlist.getItems().size() для підрахунку кількості
        // - Використайте stream().mapToInt(Track::getDuration).average() для середньої тривалості
        // - Використайте stream().sorted(...).limit(3) для топ-3 за рейтингом
        // - Використайте stream().filter(t -> t.getGenre().equalsIgnoreCase("Pop")) для відбору Pop-треків
        // - Запишіть результати у файл через PrintWriter або Files.write()


    /**
     * Запис статистики по відео у файл.
     *
     * Очікуваний формат файлу `videos_output.txt`:
     * --------------------------------------------
     * Videos count: <загальна кількість відео>
     * Average duration: <середня тривалість у секундах> seconds
     *
     * Top 3 videos by views:
     * 1. <назва відео> (<кількість переглядів> views)
     * 2. <назва відео> (<кількість переглядів> views)
     * 3. <назва відео> (<кількість переглядів> views)
     *
     * Education videos:
     * - <назва відео>
     * - <назва відео>
     * --------------------------------------------
     *
     * Пояснення:
     * - Videos count → кількість елементів у плейлисті
     * - Average duration → середня тривалість у секундах
     * - Top 3 → відсортовані за views спаданням
     * - Education videos → усі відео, у яких category == "Education"
     */
    public static void writeVideoStats(Playlist<Video> playlist, String filename) throws IOException {
        List<Video> videos = playlist.getItems();

        int total = videos.size();
        double avgDuration = videos.stream().mapToInt(Video::getDuration).average().orElse(0);

        List<Video> top3 = videos.stream()
                .sorted(Comparator.comparingLong(Video::getViews).reversed())                .limit(3)
                .collect(Collectors.toList());
        List<Video> educationVideos = videos.stream().filter(v -> v.getCategory().equalsIgnoreCase("Education")).collect(Collectors.toList());

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                bw.write("Videos count: " + total);
                bw.newLine();
                bw.write(String.format("Average duration: %.0f seconds", avgDuration));
                bw.newLine();
                bw.newLine();
                bw.write("Top 3 videos by views:");
                bw.newLine();

                int index = 1;
                for (Video v : top3) {
                    bw.write(index++ + ". " + v.getTitle() + " (" + v.getViews() + " views)");
                    bw.newLine();
                }

                bw.newLine();
                bw.write("Education videos:");
                bw.newLine();
                for (Video v : educationVideos) {
                    bw.write("- " + v.getTitle());
                    bw.newLine();
                }
            } // 🔹 ← і тут закрили try
        }
    }
                // TODO: Реалізуйте цей метод
                // Підказки:
                // - Використайте playlist.getItems().size() для підрахунку кількості
                // - Використайте stream().mapToInt(Video::getDuration).average() для середньої тривалості
                // - Використайте stream().sorted(...).limit(3) для топ-3 за views
                // - Використайте stream().filter(v -> v.getCategory().equalsIgnoreCase("Education")) для Education-відео
                // - Запишіть результати у файл через PrintWriter або Files.write()

