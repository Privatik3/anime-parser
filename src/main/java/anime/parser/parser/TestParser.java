package anime.parser.parser;

import anime.parser.domain.AnimesEntity;

import java.io.IOException;

public class TestParser {

    public static void main(String[] args) throws IOException {

        AnimeParser parser = new WorldArtParser();

        AnimesEntity anime = parser.getParseAnimeInfoById(315);

        System.out.println("-------- Anime info ---------");
        System.out.println("Anime id: " + anime.getId());
        System.out.println("Main img: " + anime.getMainImg());
        System.out.println("Main title: " + anime.getMainTitle());
        System.out.println("Type Info: " + anime.getTypeInfo());
        System.out.println("Review: " + anime.getReview());
        System.out.println("Average: " + anime.getAverage());
        System.out.println("Ranced: " + anime.getRanced());
        System.out.println("Voted: " + anime.getVoted());
    }
}
