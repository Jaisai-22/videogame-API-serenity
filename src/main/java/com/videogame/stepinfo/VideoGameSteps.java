package com.videogame.stepinfo;

import com.videogame.constant.EndPoints;
import com.videogame.model.VideoGamePojo;
import com.videogame.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;

public class VideoGameSteps {


    @Step("Creating New Video Games with id:{0},name:{1}, releaseDate:{2}, reviewScore:{3}, category:{4},rating:{5}")
    public ValidatableResponse createNewVideoGames(int id, String name, String releaseDate, int reviewScore, String category,
                                                   String rating) {

        VideoGamePojo videoGamePojo= new VideoGamePojo();
        videoGamePojo.setId(id);
        videoGamePojo.setName(name);
        videoGamePojo.setReleaseDate(releaseDate);
        videoGamePojo.setReviewScore(reviewScore);
        videoGamePojo.setCategory(category);
        videoGamePojo.setRating(rating);

        return SerenityRest.rest().given().log().all()
                .header("Content-Type", "application/json")
                .body(videoGamePojo).accept("application/json")
                .when()
                .post(EndPoints.CREAT_NEW_VIDEOGAME)
                .then();

    }

    @Step("Getting vediogame with information with id")
    public ValidatableResponse getVedioGameByID(int videogameid ) {
        return SerenityRest.rest()
                .given().accept("application/json")
                .pathParam("id", videogameid).accept("application/json")
                .log().all()
                .when()
                .get(EndPoints.GET_SINGLE_VIDEOGAME_BY_ID)
                .then();
    }
    @Step("updating Video Games with id:{0} name:{1}, releaseDate:{2}, reviewScore:{3}, category:{4},rating:{5}")
    public ValidatableResponse updateVideoGamesbyid(int id, String name, String releaseDate, int reviewScore, String category,
                                                   String rating) {

        VideoGamePojo videoGamePojo = new VideoGamePojo();
       videoGamePojo.setId(id);
        videoGamePojo.setName(name);
        videoGamePojo.setReleaseDate(releaseDate);
        videoGamePojo.setReviewScore(reviewScore);
        videoGamePojo.setCategory(category);
        videoGamePojo.setRating(rating);

        return SerenityRest.rest().given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", id).accept("application/json")
                .body(videoGamePojo).accept("application/json")
                .when()
                .put(EndPoints.UPDATE_VIDEOGAME_BY_ID)
                .then();
    }

    @Step("Deleting vediogame information with product Id")
    public ValidatableResponse deleteVediogameById(int vediogameid) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", vediogameid).accept("application/json")
                .log().all()
                .when()
                .delete(EndPoints.DELETE_VIDEOGAME_BY_ID)
                .then();
    }


    @Step("Getting all vediogames information")
    public ValidatableResponse getAllvedioGames() {
        return SerenityRest.rest()
                .given().accept("application/json")
                .when()
                .get(EndPoints.GET_ALL_VIDEOGAMES)
                .then();
    }

    }








