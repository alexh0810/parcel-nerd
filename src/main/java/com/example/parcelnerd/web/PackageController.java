package com.example.parcelnerd.web;

import com.example.parcelnerd.domain.Package;
import com.example.parcelnerd.domain.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PackageController {

    @Autowired
    private PackageRepository repository;

    @RequestMapping(value = {"/", "/packages"})
    public String packageList(Model model) {
        model.addAttribute("packages", repository.findAll());
        return "packagelist";
    }

    // Get all packages

    @RequestMapping(value = "/packagelist", method = RequestMethod.GET)
    public @ResponseBody
    List<Package> packageListRest() {
        return (List<Package>)
                repository.findAll();
    }

    // Create a new package

    @RequestMapping(value = "/add")
    public String addPackage(Model model) {
        model.addAttribute("package", new Package());
        return "addpackage";
    }

    // Saving a new package

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String save(Package package) {
        repository.save(package);
        return "redirect: packagelist";
    }

}
