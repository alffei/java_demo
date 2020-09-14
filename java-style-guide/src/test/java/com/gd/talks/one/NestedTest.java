package com.gd.talks.one;

import com.gd.talks.one.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;

public class NestedTest {

    private UserDTO user;

    @Before
    public void createUser() {
        user = new UserDTO(1, "Trump", 222);
    }

    @Test
    public void genTest() {
        Integer score = user.getScore();
        if (score.compareTo(100) < 0) {
            if ("Andrew".equals(user.getName())) {
                System.out.println("很遗憾，Andrew先生，这届选民不太行 ~ ");
            } else {
                System.out.println("很遗憾，您的票数过低，未通过预选！");
            }
        } else if (score.compareTo(200) < 0) {
            if ("Trump".equals(user.getName())) {
                user.setScore(user.getScore() - 100);
                System.out.println("很遗憾，您的票数过低，未通过预选！");
            } else if ("Andrew".equals(user.getName())) {
                user.setScore(user.getScore() + 100);
                System.out.println("恭喜您，Andrew先生，您获得大量选票! ");
            } else {
                System.out.println("恭喜您，获得了还不错的竞选成绩，通过了预选");
            }
        } else {
            System.out.println("恭喜您，您获得大量选票!");
        }
    }
}
