package com.example.media.app;

import com.example.media.classes.Playlist;
import com.example.media.classes.Track;
import com.example.media.classes.Video;
import com.example.media.util.FileUtil;
import com.example.media.util.MediaStatisticsWriter;

import java.io.IOException;

public class MediaProcessor {

    // Константи для шляхів до файлів
    private static final String TRACKS_INPUT = "data/tracks.txt";
    private static final String VIDEOS_INPUT = "data/videos.txt";
    private static final String TRACKS_OUTPUT = "tracks_output.txt";
    private static final String VIDEOS_OUTPUT = "videos_output.txt";

    public static void main(String[] args) throws IOException {
        // TODO: Реалізуйте логіку всередині класів (Media, Track, Video, Playlist<T>, MediaFilter<T>, FileUtil, MediaStatisticsWriter)
        // TODO: Коли ви реалізуєте потрібні методи, цей код має компілюватися і запускатися
        // TODO: Ну і звісно результатом виконання програми будуть два файли - їх вміст має бути згенеровано відовідно до завдання визначеного у README.txt

        // Створюємо плейлист треків і завантажуємо з файлу
        Playlist<Track> trackPlaylist = new Playlist<>();
        trackPlaylist.getItems().addAll(FileUtil.readTracks(TRACKS_INPUT));

        // Створюємо плейлист відео і завантажуємо з файлу
        Playlist<Video> videoPlaylist = new Playlist<>();
        videoPlaylist.getItems().addAll(FileUtil.readVideos(VIDEOS_INPUT));

        // Виводимо статистику треків у файл
        MediaStatisticsWriter.writeTrackStats(trackPlaylist, TRACKS_OUTPUT);

        // Виводимо статистику відео у файл
        MediaStatisticsWriter.writeVideoStats(videoPlaylist, VIDEOS_OUTPUT);

        System.out.println("Processing complete. Output files generated.");
    }
}
