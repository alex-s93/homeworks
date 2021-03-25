package com.alevel.homework26;

import com.alevel.homework26.model.Job;
import com.mongodb.client.model.Filters;
import com.alevel.homework26.dao.UserDao;
import com.alevel.homework26.model.User;
import org.bson.conversions.Bson;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Task 1
        Bson filterTitleAndAge = Filters.and(Filters.eq("title", "Senior Java Dev"), Filters.lte("age", 25));
        List<User> developers = userDao.findAllByFilter(filterTitleAndAge);
        System.out.println(developers);

        // Task 2
        Bson filterTitleContainsJunior = Filters.regex("title", "Junior");
        List<User> juniors = userDao.findAllByFilter(filterTitleContainsJunior);
        System.out.println(juniors);

        // Task 3
        Bson filterOrganizationAmazon = Filters.elemMatch("jobs", Filters.in("organization", "Amazon"));
        List<User> amazonWorkers = userDao.findAllByFilter(filterOrganizationAmazon);
        System.out.println(amazonWorkers.size());

        // Task 4
        Bson filterJobsSize = Filters.exists("jobs.3");
        List<User> jobsGTThree = userDao.findAllByFilter(filterJobsSize);
        System.out.println(jobsGTThree);

    }

    private static User createUser(int age, String fullName, String title, List<Job> jobs) {
        User user = new User();
        user.setAge(age);
        user.setFullName(fullName);
        user.setTitle(title);
        user.setJobs(jobs);
        return user;
    }
}
