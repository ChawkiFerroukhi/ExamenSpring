package com.example.revision.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.revision.entities.Complexe;
import com.example.revision.entities.Salle;
import com.example.revision.entities.Visiteur;
import com.example.revision.serviceInterface.IComplexeService;
import com.example.revision.serviceInterface.ISalleService;
import com.example.revision.serviceInterface.IVisiteurService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "GestioTOUSSSxes")
@RequestMapping("/examen")
public class RestControllers {
    @Autowired
    private IComplexeService complexeService;

    @Autowired
    private ISalleService salleService;

    @Autowired
    private IVisiteurService visiteurService;

    @PostMapping("/addComplexe")
    @ResponseBody
    public void addComplexe(@RequestBody Complexe complexe) {
        complexeService.addComplexe(complexe);
    }

    @PostMapping("/addSalle")
    public void addSalle(@RequestBody Salle salle) {
        salleService.addSalle(salle);
    }

    @PostMapping("/addVisiteur")
    public void addVisiteur(@RequestBody Visiteur visiteur) {
        visiteurService.addVisiteur(visiteur);
    }

    @PutMapping("/assignSalleToComplexe/{idSalle}/{idComplexe}")
    public void assignSalleToComplexe(@PathVariable Long idSalle, @PathVariable Long idComplexe) {
        salleService.assignSalleToComplexe(idSalle, idComplexe);
    }

   // assign visiteur to salle
    @PutMapping("/assignVisiteurToSalle/{idVisiteur}/{idSalle}")
    public void assignVisiteurToSalle(@PathVariable Long idVisiteur, @PathVariable Long idSalle) {
        visiteurService.assignVisiteurToSalle(idVisiteur, idSalle);
    }

    // get all salle by nom complexe
    @GetMapping("/getListSalleByNomComplexe/{nomComplexe}")
    public void getListSalleByNomComplexe(@PathVariable String nomComplexe) {
        salleService.getListSalleByNomComplexe(nomComplexe);
    }

    @GetMapping("/getAllVisiteur")
	@ResponseBody
	public List<Visiteur> getListSalleByNomComplexe() {
		return visiteurService.getAllVisiteur();
	}
    
}
