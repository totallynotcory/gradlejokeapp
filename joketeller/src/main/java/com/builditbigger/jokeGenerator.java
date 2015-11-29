package com.builditbigger;

import java.util.Random;

public class jokeGenerator {

    static String[] jokes = {
            "What do you call a bear with no teeth? -- A gummy bear!",
            "What did the fish say when he swam into the wall? -- Damn",
            "How do you make a tissue dance? You put a little boogie in it.",
            "What did the Zen Buddist say to the hotdog vendor? Make me one with everything.",
            "Horse walks into a bar. Bartender asks, why the long face?",
            "What’s Beethoven’s favorite fruit?…Ba-na-na-naaa!",
            "Where does a sheep go for a haircut? To the baaaaa baaaaa shop!",
            "What did the grape say when he was pinched? Nothing, he gave a little wine.",
            "What do you call cheese that’s not yours? It’s nacho cheese.",
            "Have you heard about corduroy pillows?! They’re making headlines!"
    };


    public static String tellJoke(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(jokes.length) + 1;
        return jokes[randomNumber];
    }
}
