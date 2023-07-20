package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("participants", participantRepository.findAll());
        return "participants";
    }

    @GetMapping("/add")
    public String showAddParticipantForm(Model model) {
        model.addAttribute("participant", new Participant());
        return "addParticipant";
    }

    @PostMapping
    public String addParticipant(Participant participant, BindingResult result) {
        if (result.hasErrors()) {
            return "addParticipant";
        }
        participantRepository.save(participant);
        return "redirect:/participants";
    }

    @GetMapping("/check")
    public String checkParticipant(@RequestParam Long id, Model model) {
        if (participantRepository.existsById(id)) {
            Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid participant Id:" + id));
            model.addAttribute("participant", participant);
            return "participantDetail";
        }
        return "notFound";
    }
}
