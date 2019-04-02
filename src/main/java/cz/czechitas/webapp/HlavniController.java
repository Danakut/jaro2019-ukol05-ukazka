package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HlavniController {

    private final int[] ANSWERS = {2,1,2,1,1,2,2,1};

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView model = new ModelAndView("index");
        List<String> filenameList = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            filenameList.add("man" + i + ".jpg");
        }

        model.addObject("portraits", filenameList);
        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView processIndex(IndexForm form) {
        ModelAndView model = new ModelAndView("results");

        model.addObject("myAnswers", form.answers);
        model.addObject("correctAnswers", ANSWERS);

        int correctAnswerCounter = 0;
        for (int i = 0; i < ANSWERS.length; i++) {
            if (form.answers[i] == ANSWERS[i]) {
                correctAnswerCounter++;
            }
        }
        model.addObject("scoredPoints", correctAnswerCounter);

        return model;
    }

}
