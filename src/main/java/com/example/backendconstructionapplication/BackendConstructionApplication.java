package com.example.backendconstructionapplication;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.ConstructionDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BackendConstructionApplication {

        public static void main(String[] args) {
        SpringApplication.run(BackendConstructionApplication.class, args);
    }
//    public static void main(String[] args) {
//
//        System.out.println("Wszystkie teamy");
//        DataSupplier.getTeams().forEach(System.out::println);
//
//        System.out.println("Team z id");
//        System.out.println(DataSupplier.getTeamById(1L));
//
//        System.out.println("Teamy z wyjebanym id = 1");
//        DataSupplier.deleteTeamById(1L);
//        DataSupplier.getTeams().forEach(System.out::println);
//
//
//        ConstructionDTO construction1 = ConstructionDTO.builder()
//                .id(1L)
//                .name("Test name")
//                .location("Wroclaw")
//                .estimatedCostOfRealization(new BigDecimal(100000000))
//                .percentOfRealization(0.10)
//                .currentCost(new BigDecimal(10000))
//                .project("Projekt A")
//                .contractors(Arrays.asList("Firma A", "Firma B"))
//                .teams(Arrays.asList("Ekipa 1", "Ekipa 2"))
//                .milestones(Arrays.asList("Roboty dekarskie", "Roboty murarskie", "Roboty ziemne"))
//                .build();
//
//        System.out.println("Stara budowa");
//        System.out.println(DataSupplier.getConstructionById(1L));
//
//        System.out.println("Nowa budowa");
//
//        System.out.println("Wszytskie budowy z nową");
//        DataSupplier.getConstruction().forEach(System.out::println);
//    }

}
