package com.example.backendconstructionapplication.data.supplier;

import com.example.backendconstructionapplication.dto.ProjectDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataSupplier {

    private static final List<ProjectDTO> projects = getProjects();

    public static List<ProjectDTO> getProjects() {
        ProjectDTO project1 = ProjectDTO.builder()
                .id(1L)
                .name("Budowa Nowego Biura")
                .plannedPrizeOfRealization(500000)
                .percentOfRealization(65.5)
                .currentCostOfRealization(350000)
                .location("Warszawa")
                .materials(Arrays.asList("Beton", "Stal"))
                .contractors(Arrays.asList("Firma A", "Firma B"))
                .projectManager("Jan Kowalski")
                .milestones(Arrays.asList("Przygotowanie terenu", "Budowa fundamentów"))
                .build();

        ProjectDTO project2 = ProjectDTO.builder()
                .id(2L)
                .name("Budowa Osiedla Mieszkalnego")
                .plannedPrizeOfRealization(1200000)
                .percentOfRealization(40.0)
                .currentCostOfRealization(480000)
                .location("Kraków")
                .materials(Arrays.asList("Cegła", "Drewno"))
                .contractors(Arrays.asList("Firma C", "Firma D"))
                .projectManager("Anna Nowak")
                .milestones(Arrays.asList("Przygotowanie projektu", "Budowa ścian"))
                .build();

        ProjectDTO project3 = ProjectDTO.builder()
                .id(3L)
                .name("Renowacja Starego Dworu")
                .plannedPrizeOfRealization(200000)
                .percentOfRealization(85.0)
                .currentCostOfRealization(170000)
                .location("Poznań")
                .materials(Arrays.asList("Kamień", "Drewno", "Szkło"))
                .contractors(Arrays.asList("Firma E", "Firma F"))
                .projectManager("Marek Wójcik")
                .milestones(Arrays.asList("Renowacja elewacji", "Wymiana okien"))
                .build();

        return List.of(project1, project2, project3);
    }

    public static ProjectDTO getProjectById(Long id) {
        Optional<ProjectDTO> project = projects.stream().filter(p -> p.getId().equals(id)).findFirst();
        return project.orElse(null);
    }
}