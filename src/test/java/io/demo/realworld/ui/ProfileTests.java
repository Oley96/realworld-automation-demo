package io.demo.realworld.ui;

import io.demo.realworld.TestBase;
import io.demo.realworld.data.StatusCode;
import io.demo.realworld.extention.WithLogin;
import io.demo.realworld.model.request.UpdateUser;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.demo.realworld.api.client.ApiClient.api;
import static io.demo.realworld.data.TestData.getFaker;

@Feature("profile")
class ProfileTests extends TestBase {

    @Test
    @WithLogin
    @Tag("UI")
    @DisplayName("follow to another member")
    void shouldFollowToMember() {
        homePage.open().goToGlobalFeed().goToAuthorProfilePage("Gerome");
        profilePage.clickFollowButton().verifyFollowing();
        profilePage.clickFollowButton().verifyUnfollowing();
    }

    @Test
    @WithLogin
    @Tags({@Tag("api"), @Tag("UI")})
    @DisplayName("edit profile. change bio")
    void shouldEditProfile() {
        UpdateUser request = UpdateUser.builder()
                .bio(getFaker().job().field())
                .build();

        api().profile().updateProfile(request, StatusCode.OK);

        homePage.open().getNavBar().goToProfilePage();
        profilePage.verifyBioEquals(request.getBio());
    }
}