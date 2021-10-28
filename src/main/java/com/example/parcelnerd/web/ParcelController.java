package com.example.parcelnerd.web;


import com.example.parcelnerd.domain.Parcel;
import com.example.parcelnerd.domain.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ParcelController {


    @Autowired
    private ParcelRepository repository;

    @RequestMapping(value = {"/", "/home"})
    public String parcelList(Model model) {
        model.addAttribute("parcels", repository.findAll());
        return "home";
    }

    //Restful service to get all parcels
    @RequestMapping(value = "/parcels", method = RequestMethod.GET)
    public @ResponseBody
    List<Parcel> parcelListRest() {
        return (List<Parcel>) repository.findAll();
    }

    //Restful service to get parcel by ID

    @RequestMapping(value = "/parcel/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Parcel> findParcelRest(@PathVariable("id") Long parcelId) {
        return repository.findById(parcelId);

    }

    //Adding a new parcel (limited to Admin)

    @RequestMapping(value = "/addparcel")
    public String addParcel(Model model) {
        model.addAttribute("parcel", new Parcel());
        return "addparcel";
    }

    //Save parcel

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String save(Parcel parcel) {
        repository.save(parcel);
        return "redirect:home";
    }

    //Delete parcel (Limited to Admin)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteParcel(@PathVariable("id") Long parcelId, Model model) {
        repository.deleteById(parcelId);
        return "redirect:../home";
    }

    //Update a parcel (Limited to Admin)
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editParcel(@PathVariable("id") Long parcelId, Model model) {
        model.addAttribute("parcel", repository.findById(parcelId));
        return "edit";
    }


}
