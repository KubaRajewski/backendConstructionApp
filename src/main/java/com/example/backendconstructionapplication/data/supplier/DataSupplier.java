package com.example.backendconstructionapplication.data.supplier;

import com.example.backendconstructionapplication.dto.*;
import com.example.backendconstructionapplication.exception.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataSupplier {

    private static final List<ProjectDTO> projects = getProjects();

    private static final List<TeamDTO> teams = getTeams();

    private static final List<UserDTO> users = getUsers();

    private static final List<WorkerDTO> workers = getWorkers();

    private static final List<ConstructionDTO> constructions = List.copyOf(getConstruction());

    private static final List<ContractorDTO> contractors = getContractors();

    private static final List<MaterialDTO> materials = getMaterials();

    private static final List<ElementDTO> elements = getElements();

    private static final List<DocumentDTO> documents = getDocuments();

    private static final List<MilestoneDTO> milestones = getMilestone();

    /// =============== Project ================///

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

        return new ArrayList<>(List.of(project1, project2, project3));
    }

    public static ProjectDTO getProjectById(Long id) {
        Optional<ProjectDTO> project = getExtensionProject().stream().filter(p -> p.getId().equals(id)).findFirst();
        return project.orElse(null);
    }

    public static void updateProjectById(Long id, ProjectDTO updateCommand) {
        ProjectDTO projectToUpdate = getProjectById(id);
        if (projectToUpdate == null) {
            throw new ProjectNotFoundException();
        }
        Optional.ofNullable(updateCommand.getName()).ifPresent(projectToUpdate::setName);
        Optional.ofNullable(updateCommand.getLocation()).ifPresent(projectToUpdate::setLocation);
        Optional.of(updateCommand.getPlannedPrizeOfRealization()).ifPresent(projectToUpdate::setPlannedPrizeOfRealization);
        Optional.of(updateCommand.getPercentOfRealization()).ifPresent(projectToUpdate::setPercentOfRealization);
        Optional.of(updateCommand.getCurrentCostOfRealization()).ifPresent(projectToUpdate::setCurrentCostOfRealization);
        Optional.ofNullable(updateCommand.getMaterials()).ifPresent(projectToUpdate::setMaterials);
        Optional.ofNullable(updateCommand.getContractors()).ifPresent(projectToUpdate::setContractors);
        Optional.ofNullable(updateCommand.getProjectManager()).ifPresent(projectToUpdate::setProjectManager);
        Optional.ofNullable(updateCommand.getMilestones()).ifPresent(projectToUpdate::setMilestones);
    }

    public static void deleteProjectById(Long id) {
        ProjectDTO project = getProjectById(id);
        if (project == null){
            throw new ProjectNotFoundException();
        }
        getExtensionProject().remove(project);
    }

    public static void addProject(ProjectDTO project) {
        Long newId = getExtensionProject().stream().mapToLong(ProjectDTO::getId).max().orElse(0L) + 1;
        project.setId(newId);
        getExtensionProject().add(project);
    }

    public static List<ProjectDTO> getExtensionProject() {
        return projects;
    }

    /// =============== Team ================///

    public static List<TeamDTO> getTeams() {
        TeamDTO team1 = TeamDTO.builder()
                .id(1L)
                .name("Ekipa 1")
                .construction("Budowa Osiedla Mieszkalnego")
                .workers(Arrays.asList("Wiesiek", "Zbuszek"))
                .users(Arrays.asList("Kierownik", "Prezes", "Inwestor"))
                .build();

        TeamDTO team2 = TeamDTO.builder()
                .id(2L)
                .name("Ekipa 2")
                .construction("Budowa Osiedla Mieszkalnego")
                .workers(Arrays.asList("Krzysiek", "Pawel"))
                .users(Arrays.asList("Kierownik", "Prezes", "Inwestor"))
                .build();

        TeamDTO team3 = TeamDTO.builder()
                .id(3L)
                .name("Ekipa 2")
                .construction("Budowa Osiedla Mieszkalnego")
                .workers(Arrays.asList("Stefan", "Szwagier stefana"))
                .users(Arrays.asList("Kierownik", "Prezes", "Inwestor"))
                .build();

        return new ArrayList<>(List.of(team1, team2, team3));
    }

    public static TeamDTO getTeamById(Long id) {
        Optional<TeamDTO> team = getExtensionTeam().stream().filter(t -> t.getId().equals(id)).findFirst();
        return team.orElse(null);
    }

    public static void updateTeamById(Long id, TeamDTO updateCommand) {
        TeamDTO teamToUpdate = getTeamById(id);
        if (teamToUpdate == null) {
            throw new TeamNotFoundException();
        }
        Optional.ofNullable(updateCommand.getName()).ifPresent(teamToUpdate::setName);
        Optional.ofNullable(updateCommand.getConstruction()).ifPresent(teamToUpdate::setConstruction);
        Optional.ofNullable(updateCommand.getWorkers()).ifPresent(teamToUpdate::setWorkers);
        Optional.ofNullable(updateCommand.getUsers()).ifPresent(teamToUpdate::setUsers);
    }

    public static void deleteTeamById(Long id) {
        TeamDTO team = getTeamById(id);
        if (team == null){
            throw new TeamNotFoundException();
        }
        getExtensionTeam().remove(team);
    }

    public static void addTeam(TeamDTO team) {
        Long newId = getExtensionTeam().stream().mapToLong(TeamDTO::getId).max().orElse(0L) + 1;
        team.setId(newId);
        getExtensionTeam().add(team);
    }

    public static List<TeamDTO> getExtensionTeam() {
        return teams;
    }

    /// =============== Users ================///

    public static List<UserDTO> getUsers() {
        UserDTO user1 = UserDTO.builder()
                .id(1L)
                .email("janek@company.pl")
                .firstName("Janek")
                .lastName("Kowalski")
                .roleInTheCompany("Kierownik budowy")
                .team("Ekipa 1")
                .build();

        UserDTO user2 = UserDTO.builder()
                .id(2L)
                .email("maciek@company.pl")
                .firstName("Maciej")
                .lastName("Nowak")
                .roleInTheCompany("Dyrektor operacyjny")
                .team("Ekipa 1")
                .build();

        UserDTO user3 = UserDTO.builder()
                .id(3L)
                .email("heniekk@company.pl")
                .firstName("Henryk")
                .lastName("Owca")
                .roleInTheCompany("Menedzer magazynu")
                .team("Ekipa 1")
                .build();

        return new ArrayList<>(List.of(user1, user2, user3));
    }

    public static UserDTO getUserById(Long id) {
        Optional<UserDTO> user = getExtensionUser().stream().filter(t -> t.getId().equals(id)).findFirst();
        return user.orElse(null);
    }

    public static void updateUserById(Long id, UserDTO updateCommand) {
        UserDTO userToUpdate = getUserById(id);
        if (userToUpdate == null) {
            throw new UserNotFoundException();
        }
        Optional.ofNullable(updateCommand.getEmail()).ifPresent(userToUpdate::setEmail);
        Optional.ofNullable(updateCommand.getFirstName()).ifPresent(userToUpdate::setFirstName);
        Optional.ofNullable(updateCommand.getLastName()).ifPresent(userToUpdate::setLastName);
        Optional.ofNullable(updateCommand.getRoleInTheCompany()).ifPresent(userToUpdate::setRoleInTheCompany);
        Optional.ofNullable(updateCommand.getTeam()).ifPresent(userToUpdate::setTeam);
    }

    public static void deleteUserById(Long id) {
        UserDTO user = getUserById(id);
        if (user == null){
            throw new UserNotFoundException();
        }
        getExtensionUser().remove(user);
    }

    // method to returning real extension
    public static List<UserDTO> getExtensionUser() {
        return users;
    }

    public static void addUser(UserDTO user) {
        Long newId = getExtensionUser().stream().mapToLong(UserDTO::getId).max().orElse(0L) + 1;
        user.setId(newId);
        getExtensionUser().add(user);
    }

    /// =============== Workers ================///

    public static List<WorkerDTO> getWorkers() {
        WorkerDTO worker1 = WorkerDTO.builder()
                .id(1L)
                .firstName("Pawel")
                .lastName("Wiewiorka")
                .specialization("Koparkowy")
                .construction("Budowa Osiedla Mieszkalnego")
                .milestone("Roboty ziemne")
                .team("Ekipa 1")
                .build();

        WorkerDTO worker2 = WorkerDTO.builder()
                .id(2L)
                .firstName("Michal")
                .lastName("Skowronek")
                .specialization("Murarz")
                .construction("Budowa Osiedla Mieszkalnego")
                .milestone("Roboty murarskie")
                .team("Ekipa 1")
                .build();

        WorkerDTO worker3 = WorkerDTO.builder()
                .id(3L)
                .firstName("Mariusz")
                .lastName("Walaszek")
                .specialization("Dekarz")
                .construction("Budowa Nowego Biura")
                .milestone("Roboty dekarskie")
                .team("Ekipa 2")
                .build();

        return new ArrayList<>(List.of(worker1, worker2, worker3));
    }

    public static WorkerDTO getWorkerById(Long id) {
        Optional<WorkerDTO> worker = getExtensionWorker().stream().filter(t -> t.getId().equals(id)).findFirst();
        return worker.orElse(null);
    }

    public static void updateWorkerById(Long id, WorkerDTO updateCommand) {
        WorkerDTO workerToUpdate = getWorkerById(id);
        if (workerToUpdate == null) {
            throw new WorkerNotFoundException();
        }
        Optional.ofNullable(updateCommand.getFirstName()).ifPresent(workerToUpdate::setFirstName);
        Optional.ofNullable(updateCommand.getLastName()).ifPresent(workerToUpdate::setLastName);
        Optional.ofNullable(updateCommand.getSpecialization()).ifPresent(workerToUpdate::setSpecialization);
        Optional.ofNullable(updateCommand.getConstruction()).ifPresent(workerToUpdate::setConstruction);
        Optional.ofNullable(updateCommand.getMilestone()).ifPresent(workerToUpdate::setMilestone);
        Optional.ofNullable(updateCommand.getTeam()).ifPresent(workerToUpdate::setTeam);
    }

    public static void deleteWorkerById(Long id) {
        WorkerDTO worker = getWorkerById(id);
        if (worker == null){
            throw new WorkerNotFoundException();
        }
        getExtensionWorker().remove(worker);
    }

    public static void addWorker(WorkerDTO worker) {
        Long newId = getExtensionWorker().stream().mapToLong(WorkerDTO::getId).max().orElse(0L) + 1;
        worker.setId(newId);
        getExtensionWorker().add(worker);
    }

    // method to returning real extension
    public static List<WorkerDTO> getExtensionWorker() {
        return workers;
    }

    /// =============== Construction ================///

    public static List<ConstructionDTO> getConstruction() {
        ConstructionDTO construction1 = ConstructionDTO.builder()
                .id(1L)
                .name("Budowa Osiedla Mieszkalnego")
                .location("Wroclaw")
                .estimatedCostOfRealization(new BigDecimal(100000000))
                .percentOfRealization(0.10)
                .currentCost(new BigDecimal(10000))
                .project("Projekt A")
                .contractors(Arrays.asList("Firma A", "Firma B"))
                .teams(Arrays.asList("Ekipa 1", "Ekipa 2"))
                .milestones(Arrays.asList("Roboty dekarskie", "Roboty murarskie", "Roboty ziemne"))
                .build();

        ConstructionDTO construction2 = ConstructionDTO.builder()
                .id(2L)
                .name("Budowa mostu")
                .location("Gdansk")
                .estimatedCostOfRealization(new BigDecimal(100000000))
                .percentOfRealization(0.10)
                .currentCost(new BigDecimal(10000))
                .project("Projekt B")
                .contractors(Arrays.asList("Firma A", "Firma B"))
                .teams(Arrays.asList("Ekipa 1", "Ekipa 2"))
                .milestones(Arrays.asList("Roboty dekarskie", "Roboty murarskie", "Roboty ziemne"))
                .build();

        return new ArrayList<>(List.of(construction1, construction2));
    }

    public static ConstructionDTO getConstructionById(Long id) {
        Optional<ConstructionDTO> construction = getExtensionConstruction().stream().filter(t -> t.getId().equals(id)).findFirst();
        return construction.orElse(null);
    }

    public static void updateConstructionById(Long id, ConstructionDTO updateCommand) {
        ConstructionDTO construction = getConstructionById(id);
        if (construction == null) {
            throw new ConstructionNotFoundException();
        }
        Optional.ofNullable(updateCommand.getName())
                .ifPresent(construction::setName);
        Optional.ofNullable(updateCommand.getLocation())
                .ifPresent(construction::setLocation);
        Optional.ofNullable(updateCommand.getEstimatedCostOfRealization())
                .ifPresent(construction::setEstimatedCostOfRealization);
        Optional.ofNullable(updateCommand.getPercentOfRealization())
                .ifPresent(construction::setPercentOfRealization);
        Optional.ofNullable(updateCommand.getCurrentCost())
                .ifPresent(construction::setCurrentCost);
        Optional.ofNullable(updateCommand.getProject())
                .ifPresent(construction::setProject);
        Optional.ofNullable(updateCommand.getContractors())
                .ifPresent(construction::setContractors);
        Optional.ofNullable(updateCommand.getTeams())
                .ifPresent(construction::setTeams);
        Optional.ofNullable(updateCommand.getMilestones())
                .ifPresent(construction::setMilestones);
    }

    public static void deleteConstructionById(Long id) {
        ConstructionDTO construction = getConstructionById(id);
        if (construction == null) {
            throw new ConstructionNotFoundException();
        }
        getExtensionConstruction().remove(construction);
    }

    public static void addConstruction(ConstructionDTO construction) {
        Long newId = getExtensionConstruction().stream().mapToLong(ConstructionDTO::getId).max().orElse(0L) + 1;
        construction.setId(newId);
        getExtensionConstruction().add(construction);
    }

    // method to returning real extension
    public static List<ConstructionDTO> getExtensionConstruction() {
        return constructions;
    }

    /// =============== Contractors ================///

    public static List<ContractorDTO> getContractors() {
        ContractorDTO contractor1 = ContractorDTO.builder()
                .id(1L)
                .companyName("Firma A")
                .construction("Budowa Osiedla Mieszkalnego")
                .contract("Umowa o dzieło")
                .build();

        ContractorDTO contractor2 = ContractorDTO.builder()
                .id(2L)
                .companyName("Firma B")
                .construction("Budowa Osiedla Mieszkalnego")
                .contract("Umowa o dzieło")
                .build();

        ContractorDTO contractor3 = ContractorDTO.builder()
                .id(1L)
                .companyName("Firma C")
                .construction("Budowa Osiedla Mieszkalnego")
                .contract("Umowa akordowa")
                .build();

        return new ArrayList<>(List.of(contractor1, contractor2, contractor3));
    }

    public static ContractorDTO getContractorById(Long id) {
        Optional<ContractorDTO> contractor = getExtensionContractor().stream().filter(t -> t.getId().equals(id)).findFirst();
        return contractor.orElse(null);
    }

    public static void updateContractorById(Long id, ContractorDTO updateCommand) {
        ContractorDTO contractorToUpdate = getContractorById(id);
        if (contractorToUpdate == null) {
            throw new ContractorNotFoundException();
        }
        Optional.ofNullable(updateCommand.getCompanyName()).ifPresent(contractorToUpdate::setCompanyName);
        Optional.ofNullable(updateCommand.getConstruction()).ifPresent(contractorToUpdate::setConstruction);
        Optional.ofNullable(updateCommand.getContract()).ifPresent(contractorToUpdate::setContract);
    }

    public static void deleteContractorById(Long id) {
        ContractorDTO contractor = getContractorById(id);
        if (contractor == null){
            throw new ContractorNotFoundException();
        }
        getExtensionContractor().remove(contractor);
    }

    public static void addContractor(ContractorDTO contractor) {
        Long newId = getExtensionContractor().stream().mapToLong(ContractorDTO::getId).max().orElse(0L) + 1;
        contractor.setId(newId);
        getExtensionContractor().add(contractor);
    }

    public static List<ContractorDTO> getExtensionContractor(){
        return contractors;
    }

    /// =============== Materials ================///

    public static List<MaterialDTO> getMaterials() {
        MaterialDTO material1 = MaterialDTO.builder()
                .id(1L)
                .name("Bloczki Ytoong 12x24x26cm")
                .dateOfConclusion(LocalDate.of(2025, 1, 2))
                .value(new BigDecimal(2000))
                .milestone("Roboty murarskie")
                .build();

        MaterialDTO material2 = MaterialDTO.builder()
                .id(2L)
                .name("Łaty drewniane")
                .dateOfConclusion(LocalDate.of(2025, 1, 2))
                .value(new BigDecimal(20000))
                .milestone("Roboty dekarskie")
                .build();

        MaterialDTO material3 = MaterialDTO.builder()
                .id(3L)
                .name("Kontener na gruz")
                .dateOfConclusion(LocalDate.of(2025, 1, 2))
                .value(new BigDecimal(20000))
                .milestone("Roboty ziemne")
                .build();

        return new ArrayList<>(List.of(material1, material2, material3));
    }

    public static MaterialDTO getMaterialById(Long id) {
        Optional<MaterialDTO> material = getExtensionMaterial().stream().filter(t -> t.getId().equals(id)).findFirst();
        return material.orElse(null);
    }

    public static void updateMaterialById(Long id, MaterialDTO updateCommand) {
        MaterialDTO materialToUpdate = getMaterialById(id);
        if (materialToUpdate == null) {
            throw new MaterialNotFoundException();
        }

        Optional.ofNullable(updateCommand.getName()).ifPresent(materialToUpdate::setName);
        Optional.ofNullable(updateCommand.getDateOfConclusion()).ifPresent(materialToUpdate::setDateOfConclusion);
        Optional.ofNullable(updateCommand.getValue()).ifPresent(materialToUpdate::setValue);
        Optional.ofNullable(updateCommand.getMilestone()).ifPresent(materialToUpdate::setMilestone);
    }

    public static void deleteMaterialById(Long id) {
        MaterialDTO material = getMaterialById(id);
        if (material == null){
            throw new MaterialNotFoundException();
        }
        getExtensionMaterial().remove(material);
    }

    public static void addMaterial(MaterialDTO material) {
        Long newId = getExtensionMaterial().stream().mapToLong(MaterialDTO::getId).max().orElse(0L) + 1;
        material.setId(newId);
        getExtensionMaterial().add(material);
    }

    public static List<MaterialDTO> getExtensionMaterial(){
        return materials;
    }

    /// =============== Elements ================///

    public static List<ElementDTO> getElements() {
        ElementDTO element1 = ElementDTO.builder()
                .id(1L)
                .name("Montaż belek drewnianych")
                .description("Nalezy najpierw zabezpieczyc belki " +
                        "oraz zamontowac za pomoca wkretow 50mm")
                .status("isDoing")
                .dateOfExecute(LocalDate.of(2025, 1, 5))
                .durationDay(4)
                .milestone("Roboty dekarskie")
                .build();

        ElementDTO element2 = ElementDTO.builder()
                .id(2L)
                .name("Wyburzenie fundamentow")
                .description("Nalezy przy uzyciu mlota wykuc stare fundamenty" +
                        "i gruz umiescic w kontenerze")
                .status("toDo")
                .dateOfExecute(LocalDate.of(2025, 1, 5))
                .durationDay(2)
                .milestone("Roboty ziemne")
                .build();

        ElementDTO element3 = ElementDTO.builder()
                .id(3L)
                .name("Murownie kawalka sciany")
                .description("Nalezy uzyc zaprawy oraz bloczkow ytoong")
                .status("toDo")
                .dateOfExecute(LocalDate.of(2025, 1, 5))
                .durationDay(5)
                .milestone("Roboty murarskie")
                .build();

        return new ArrayList<>(List.of(element1, element2, element2));
    }

    public static ElementDTO getElementById(Long id) {
        Optional<ElementDTO> element = getExtensionElement().stream().filter(t -> t.getId().equals(id)).findFirst();
        return element.orElse(null);
    }

    public static void updateElementById(Long id, ElementDTO updateCommand) {
        ElementDTO elementToUpdate = getElementById(id);
        if (elementToUpdate == null) {
            throw new ElementNotFoundException();
        }
        Optional.ofNullable(updateCommand.getName()).ifPresent(elementToUpdate::setName);
        Optional.ofNullable(updateCommand.getDescription()).ifPresent(elementToUpdate::setDescription);
        Optional.ofNullable(updateCommand.getStatus()).ifPresent(elementToUpdate::setStatus);
        Optional.ofNullable(updateCommand.getDateOfExecute()).ifPresent(elementToUpdate::setDateOfExecute);
        Optional.ofNullable(updateCommand.getDurationDay()).ifPresent(elementToUpdate::setDurationDay);
        Optional.ofNullable(updateCommand.getMilestone()).ifPresent(elementToUpdate::setMilestone);
    }

    public static void deleteElementById(Long id) {
        ElementDTO element = getElementById(id);
        if (element == null){
            throw new ElementNotFoundException();
        }
        getExtensionElement().remove(element);
    }

    public static void addElement(ElementDTO element) {
        Long newId = getExtensionElement().stream().mapToLong(ElementDTO::getId).max().orElse(0L) + 1;
        element.setId(newId);
        getExtensionElement().add(element);
    }

    public static List<ElementDTO> getExtensionElement(){
        return elements;
    }

    /// =============== Documents ================///

    public static List<DocumentDTO> getDocuments() {
        DocumentDTO document1 = DocumentDTO.builder()
                .id(1L)
                .name("Umowa o dzielo")
                .type("Umowa podwykonawcza")
                .dateOfIssue(LocalDate.of(2024, 9, 9))
                .sender("Dyrektor operacyjny")
                .recipients(Arrays.asList("Firma A", "Firma B"))
                .milestone("Roboty murarskie")
                .build();

        DocumentDTO document2 = DocumentDTO.builder()
                .id(2L)
                .name("Umowa o prace")
                .type("Umowa wewnetrzna")
                .dateOfIssue(LocalDate.of(2024, 9, 9))
                .sender("Dyrektor operacyjny")
                .recipients(Arrays.asList("Waldek Zieliscki", "Grzes P"))
                .milestone("Roboty dekarskie")
                .build();

        return new ArrayList<>(List.of(document1, document2));
    }

    public static DocumentDTO getDocumentById(Long id) {
        Optional<DocumentDTO> document = getExtensionDocument().stream().filter(t -> t.getId().equals(id)).findFirst();
        return document.orElse(null);
    }

    public static void updateDocumentById(Long id, DocumentDTO updateCommand) {
        DocumentDTO documentToUpdate = getDocumentById(id);
        if (documentToUpdate == null) {
         throw new DocumentNotFoundException();
        }
        Optional.ofNullable(updateCommand.getName()).ifPresent(documentToUpdate::setName);
        Optional.ofNullable(updateCommand.getType()).ifPresent(documentToUpdate::setType);
        Optional.ofNullable(updateCommand.getDateOfIssue()).ifPresent(documentToUpdate::setDateOfIssue);
        Optional.ofNullable(updateCommand.getSender()).ifPresent(documentToUpdate::setSender);
        Optional.ofNullable(updateCommand.getRecipients()).ifPresent(documentToUpdate::setRecipients);
        Optional.ofNullable(updateCommand.getMilestone()).ifPresent(documentToUpdate::setMilestone);
    }

    public static void deleteDocumentById(Long id) {
        DocumentDTO document = getDocumentById(id);
        if (document == null){
            throw new DocumentNotFoundException();
        }
        getExtensionDocument().remove(document);
    }

    public static void addDocument(DocumentDTO document) {
        Long newId = getExtensionDocument().stream().mapToLong(DocumentDTO::getId).max().orElse(0L) + 1;
        document.setId(newId);
        getExtensionDocument().add(document);
    }

    public static List<DocumentDTO> getExtensionDocument(){
        return documents;
    }

    /// =============== Milestone ================///

    public static List<MilestoneDTO> getMilestone() {
        MilestoneDTO milestone1 = MilestoneDTO.builder()
                .id(1L)
                .name("Roboty dekarskie")
                .executor("Firma A")
                .status("toDo")
                .estimatedDateOfRealization(LocalDate.of(2025, 4, 9))
                .documents(Arrays.asList("Umowa o dzielo", "Faktura za bloczki"))
                .material(Arrays.asList("Belki drewniane", "Wkrety do drewna"))
                .elements(Arrays.asList("Usuniecie starego dachu", "Oczyszczenie konstruckji",
                        "Zamontowanie nowych belek", "Ulozenie dachowek"))
                .build();

        MilestoneDTO milestone2 = MilestoneDTO.builder()
                .id(1L)
                .name("Roboty murarskie")
                .executor("Firma B")
                .status("toDo")
                .estimatedDateOfRealization(LocalDate.of(2025, 4, 9))
                .documents(Arrays.asList("Umowa o dzielo", "Faktura nr FV/2024/09/1112"))
                .material(Arrays.asList("Beton C15", "Bloczki ytoong", "Mieszadlo"))
                .elements(Arrays.asList("Wymierzenie pionu", "Ulozenie papy", "Zamonotwanie 1 warstwy",
                        "Ulozenie 2 warstwy"))
                .build();

        return new ArrayList<>(List.of(milestone1, milestone2));
    }

    public static MilestoneDTO getMilestoneById(Long id) {
        Optional<MilestoneDTO> milestone = getExtensionMilestone().stream().filter(t -> t.getId().equals(id)).findFirst();
        return milestone.orElse(null);
    }

    public static void updateMilestoneById(Long id, MilestoneDTO updateCommand) {
        MilestoneDTO milestoneToUpdate = getMilestoneById(id);
        if (milestoneToUpdate == null) {
            throw new MilestoneNotFoundException();
        }
        Optional.ofNullable(updateCommand.getName()).ifPresent(milestoneToUpdate::setName);
        Optional.ofNullable(updateCommand.getExecutor()).ifPresent(milestoneToUpdate::setExecutor);
        Optional.ofNullable(updateCommand.getStatus()).ifPresent(milestoneToUpdate::setStatus);
        Optional.ofNullable(updateCommand.getEstimatedDateOfRealization()).ifPresent(milestoneToUpdate::setEstimatedDateOfRealization);
        Optional.ofNullable(updateCommand.getDocuments()).ifPresent(milestoneToUpdate::setDocuments);
        Optional.ofNullable(updateCommand.getMaterial()).ifPresent(milestoneToUpdate::setMaterial);
        Optional.ofNullable(updateCommand.getElements()).ifPresent(milestoneToUpdate::setElements);
    }

    public static void deleteMilestoneById(Long id) {
        MilestoneDTO milestone = getMilestoneById(id);
        if (milestone == null){
            throw new MilestoneNotFoundException();
        }
        getExtensionMilestone().remove(milestone);
    }

    public static void addMilestone(MilestoneDTO milestone) {
        Long newId = getExtensionMilestone().stream().mapToLong(MilestoneDTO::getId).max().orElse(0L) + 1;
        milestone.setId(newId);
        getExtensionMilestone().add(milestone);
    }

    public static List<MilestoneDTO> getExtensionMilestone(){
        return milestones;
    }

}