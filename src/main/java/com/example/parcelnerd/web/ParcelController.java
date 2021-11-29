package com.example.parcelnerd.web;


import com.example.parcelnerd.domain.Parcel;
import com.example.parcelnerd.domain.ParcelRepository;
import com.example.parcelnerd.domain.ParcelService;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class ParcelController {


    @Autowired
    private ParcelRepository repository;
    @Autowired
    ParcelService parcelService;

    // Show all parcels in Thymeleaf template
    @RequestMapping(value = {"/", "/home"})
    public String parcelList(Model model) {
        model.addAttribute("parcels", repository.findAll());
        return "home";
    }

    // Restful service to get all parcels
    @RequestMapping(value = "/api/parcels", method = RequestMethod.GET)
    public @ResponseBody
    List<Parcel> getParcels() {
        return (List<Parcel>) repository.findAll();
    }

    // Restful service to get parcel by ID
    @RequestMapping(value = "/api/parcel/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Parcel> getParcelById(@PathVariable("id") Long parcelId) {
        return repository.findById(parcelId);

    }

    // Adding a new parcel (limited to Admin)
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addParcelAction(Model model) {
        model.addAttribute("parcel", new Parcel());
        return "addparcel";
    }

    // Save parcel
    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String saveParcelAction(Parcel parcel) {
        repository.save(parcel);
        return "redirect:home";
    }

    // Delete parcel (Limited to Admin)
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteParcelAction(@PathVariable("id") Long parcelId, Model model) {
        repository.deleteById(parcelId);
        return "redirect:../home";
    }

    // Update a parcel (Limited to Admin)
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/e it/{id}", method = RequestMethod.GET)
    public String editParcelAction(@PathVariable("id") Long parcelId, Model model) {
        model.addAttribute("parcel", repository.findById(parcelId));
        return "edit";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportCSV(HttpServletResponse response) throws Exception {
        // Set file name and content type
        String filename = "parcels.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

        // Create a CSV Writer
        StatefulBeanToCsv<Parcel> writer = new StatefulBeanToCsvBuilder<Parcel>(response.getWriter())
                .withOrderedResults(true).build();
        // Write all employees to CSV file
        writer.write(parcelService.fetchAll());
    }

}
