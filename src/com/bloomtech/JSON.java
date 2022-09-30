package com.bloomtech;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JSON {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

    }  // End of main

    /******************************************************************************
     * Helper methods used by the main() method in it's processing
     *
     * Note to Learner: You will be using this method during this Guided Project
     *                  It is not necessary for you to understand what it is doing
     *                  you will learn about this later in your training.
     *
     *                  Using methods and processes you do not fully understand is
     *                  a normal occurrence in the life of a developer.
     *
     *                  All you really need to know about any method is:
     *                      1. What it receives as parameters
     *                      2. What it returns
     *                      3. A general idea of what it does which you usually get
     *                         from the name.
     *******************************************************************************/

    /**
     * Helper method to call external API to get book data based on ISBN
     *
     * @param isbn
     * @return
     */
    protected static String fetchBookByISBN(String isbn) {

        final String BASE_URL = "http://openlibrary.org/search.json";

        Request request = new Request.Builder().url(BASE_URL+"?isbn="+isbn).build();

        try {
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}