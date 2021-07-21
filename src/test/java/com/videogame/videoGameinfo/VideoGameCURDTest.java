package com.videogame.videoGameinfo;

import com.videogame.stepinfo.VideoGameSteps;
import com.videogame.testbase.TestBase;
import com.videogame.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class VideoGameCURDTest extends TestBase {

    static int id = 1 + TestUtils.getRandomValueInt();
    static String name = ("Pac-Man");
    static String releaseDate = ("2021-07-15T19:08:27.609Z");
    static int reviewScore = (78);
    static String category = ("FunGame");
    static String rating = ("String");
    static int vediogameid;

    @Steps
    VideoGameSteps videoGameSteps;

    @Title("This will create new VideoGame")
    @Test
    public void test001() {
        videoGameSteps.createNewVideoGames(id, name, releaseDate, reviewScore, category, rating).log().all().statusCode(200).extract().response()
                .body().jsonPath();
    }

    @Title("This test will get the vediogame information by ID")
    @Test
    public void test002() {
        videoGameSteps.getVedioGameByID(id).statusCode(200).log().all();

    }

    @Title("This test will update the video game by existing id")
    @Test
    public void test003() {
         id = id;
        name = name + "_new";
        releaseDate = releaseDate;
        reviewScore = reviewScore +1;
        category = category + "_new";
        rating = rating + "_new";

        videoGameSteps.updateVideoGamesbyid( id, name, releaseDate, reviewScore, category, rating).statusCode(200).log().all();
        videoGameSteps.getVedioGameByID(id).body("id",equalTo(id));

    }
    @Title("This will delete and verify if product is deleted")
    @Test
    public void test004() {

        videoGameSteps.deleteVediogameById(id).statusCode(200).log().all();

    }

    @Title("This will get all products")
    @Test
    public void test005() {
        videoGameSteps.getAllvedioGames().log().all().statusCode(200);


    }



}