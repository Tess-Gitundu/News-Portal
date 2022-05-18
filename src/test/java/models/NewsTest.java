package models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {
    public  News setUpNews(){
        News testNews = new News("School", "Closing school", 1);
        return testNews;
    }

    @Test
    void getTitle() {
        News testNews = setUpNews();
        assertEquals("School", testNews.getTitle());
    }

    @Test
    void getContent() {
        News testNews = setUpNews();
        assertEquals("Closing school", testNews.getContent());
    }

    @Test
    void getEmployeeId() {
        News testNews = setUpNews();
        assertEquals(1, testNews.getEmployeeId());
    }
}