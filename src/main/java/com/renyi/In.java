package com.renyi;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: dsy
 * @Date: 2023-12-16 17:04
 * @Description: TODO
 * @Version:1.0
 */
public class In {
    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.US;

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static final Pattern EMPTY_PATTERN = Pattern.compile("");

    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    private Scanner scanner;

    public In() {
        scanner = new Scanner(new BufferedInputStream(System.in),CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }

    public In(Socket socket){
        if (socket == null)throw new IllegalArgumentException("socket argument is null");
        try {
            InputStream is = socket.getInputStream();
            scanner = new Scanner(new BufferedInputStream(is),CHARSET_NAME);
            scanner.useLocale(LOCALE);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cloud not open " + socket,e);
        }
    }
    public In(URL url){
        if (url == null) throw  new IllegalArgumentException("url argument is null");
        try {
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            scanner = new Scanner(new BufferedInputStream(is),CHARSET_NAME);
            scanner.useLocale(LOCALE);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cloud not open " + url,e);
        }
    }


    public static void main(String[] args) {
        In in = new In();

    }

}
