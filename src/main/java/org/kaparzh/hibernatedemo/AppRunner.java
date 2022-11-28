package org.kaparzh.hibernatedemo;

import org.kaparzh.hibernatedemo.view.ConsoleView;

public class AppRunner {

    public static void main(String[] args) {
        ConsoleView console = new ConsoleView();
        console.run();
    }
}