package com.example.U1M4SummativeTurnerTerrence.controller;

import com.example.U1M4SummativeTurnerTerrence.model.Answer;
import com.example.U1M4SummativeTurnerTerrence.model.Definition;
import com.example.U1M4SummativeTurnerTerrence.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Random;

import static com.example.U1M4SummativeTurnerTerrence.model.Answer.answers;
import static com.example.U1M4SummativeTurnerTerrence.model.Definition.definitionList;
import static com.example.U1M4SummativeTurnerTerrence.model.Quote.quoteList;

@RestController
public class Controller {

    //Get
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Quote retrieveQuote(){

        quoteList.add(new Quote("No, I am your father","- Star Wars"));
        quoteList.add(new Quote("Why so serious?", " - The Dark Knight"));
        quoteList.add(new Quote("Frankly my dear, I don't give a damn.", "- Gone With the Wind"));
        quoteList.add(new Quote("I'll make him an offer he can't refuse", "- The Godfather"));
        quoteList.add(new Quote("Life is like a box of chocolates", "- Forest Gump"));
        quoteList.add(new Quote("I'll be back.", " - The Terminatior"));
        quoteList.add(new Quote("Say 'hello' to my little friend", "- Scarface"));
        quoteList.add(new Quote("You'll always remember this as the day that you almost caught Captain Jack Sparrow", "- Pirates of the Caribbean"));
        quoteList.add(new Quote("Heeere's Johnny!", "- The Shining"));
        quoteList.add(new Quote("Bond, James Bond", "- James Bond"));

        Random random = new Random();

        return quoteList.get(random.nextInt(10));
    }



    //Get
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Definition retrieveWord(){


        definitionList.add(new Definition("Serendipity (n.)", "- The chance occurrence of events in a beneficial way." ));
        definitionList.add(new Definition("Petrichor (n.)", "- The pleasant, earthy smell after rain."));
        definitionList.add(new Definition("Supine (adj.)", "- Lying face upwards"));
        definitionList.add(new Definition("Solitude (n.)", "- A state of seclusion or isolation."));
        definitionList.add(new Definition("Aurora (n.)", "- The dawn in the early morning."));
        definitionList.add(new Definition("Idyllic (adj.)", "- Like an idyll; extremely happy, peaceful, or picturesque."));
        definitionList.add(new Definition("Clinomania (n.)", " - Excessive desire to stay in bed."));
        definitionList.add(new Definition("Pluviophile (n.)", "- A lover of rain; someone who finds joy and peace of mind during rainy days."));
        definitionList.add(new Definition("Euphoria (n.)", "- A feeling or state of intense excitement and happiness."));
        definitionList.add(new Definition("Sequoia (n.)", "- A redwood tree, especially the California redwood."));


        Random random = new Random();
        return definitionList.get(random.nextInt(10));
    }



    //Post
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)

    public Answer generateAnswer(@RequestBody Answer question){

        answers.add(new Answer(question.getQuestion(),"Without a doubt"));
        answers.add(new Answer(question.getQuestion(),"Don't count on it"));
        answers.add(new Answer(question.getQuestion(),"No"));
        answers.add(new Answer(question.getQuestion(),"Yes - definitely"));
        answers.add(new Answer(question.getQuestion(),"Ask again later"));
        answers.add(new Answer(question.getQuestion(),"Better not to tell you now"));

        Random random = new Random();
        return answers.get(random.nextInt(6));
    }




}
