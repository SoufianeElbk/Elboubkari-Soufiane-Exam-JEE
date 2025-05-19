package ma.elboubkari.soufiane;

import ma.elboubkari.soufiane.entities.*;
import ma.elboubkari.soufiane.enums.StatutCredit;
import ma.elboubkari.soufiane.enums.TypeBien;
import ma.elboubkari.soufiane.enums.TypeRemboursement;
import ma.elboubkari.soufiane.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ExamJeeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExamJeeApplication.class, args);
    }

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreditPersonnelRepository creditPersonnelRepository;

    @Autowired
    private CreditImmobilierRepository creditImmobilierRepository;

    @Autowired
    private CreditProfessionnelRepository creditProfessionnelRepository;

    @Autowired
    private RemboursementRepository remboursementRepository;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("*************** Initialisation des données ***************");

        // Création des clients
        Client client1 = new Client(null, "Soufiane ELBOUBKARI", "soufiane@gmail.com", new ArrayList<>());
        Client client2 = new Client(null, "Mohammed El Youssfi", "mohammed@gmail.com", new ArrayList<>());
        Client client3 = new Client(null, "Kamal El Guemmat", "kamal@gmail.com", new ArrayList<>());

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        System.out.println("Clients créés avec succès !");

        // Création des crédits personnels
        CreditPersonnel creditPersonnel1 = new CreditPersonnel();
        creditPersonnel1.setClient(client1);
        creditPersonnel1.setDateDemande(dateFormat.parse("2023-01-15"));
        creditPersonnel1.setStatut(StatutCredit.ACCEPTE);
        creditPersonnel1.setDateAcceptation(dateFormat.parse("2023-01-30"));
        creditPersonnel1.setMontant(15000.0);
        creditPersonnel1.setDureeRemboursement(36); // 36 mois
        creditPersonnel1.setTauxInteret(5.5);
        creditPersonnel1.setMotif("Achat voiture");
        creditPersonnel1.setRemboursements(new ArrayList<>());

        CreditPersonnel creditPersonnel2 = new CreditPersonnel();
        creditPersonnel2.setClient(client2);
        creditPersonnel2.setDateDemande(dateFormat.parse("2023-02-10"));
        creditPersonnel2.setStatut(StatutCredit.EN_COURS);
        creditPersonnel2.setMontant(8000.0);
        creditPersonnel2.setDureeRemboursement(24); // 24 mois
        creditPersonnel2.setTauxInteret(4.2);
        creditPersonnel2.setMotif("Études");
        creditPersonnel2.setRemboursements(new ArrayList<>());

        creditPersonnelRepository.save(creditPersonnel1);
        creditPersonnelRepository.save(creditPersonnel2);

        System.out.println("Crédits personnels créés avec succès !");

        // Création des crédits immobiliers
        CreditImmobilier creditImmobilier1 = new CreditImmobilier();
        creditImmobilier1.setClient(client1);
        creditImmobilier1.setDateDemande(dateFormat.parse("2023-03-05"));
        creditImmobilier1.setStatut(StatutCredit.ACCEPTE);
        creditImmobilier1.setDateAcceptation(dateFormat.parse("2023-03-25"));
        creditImmobilier1.setMontant(200000.0);
        creditImmobilier1.setDureeRemboursement(240); // 20 ans
        creditImmobilier1.setTauxInteret(2.8);
        creditImmobilier1.setTypeBien(TypeBien.APPARTEMENT);
        creditImmobilier1.setRemboursements(new ArrayList<>());

        CreditImmobilier creditImmobilier2 = new CreditImmobilier();
        creditImmobilier2.setClient(client3);
        creditImmobilier2.setDateDemande(dateFormat.parse("2023-04-12"));
        creditImmobilier2.setStatut(StatutCredit.REJETE);
        creditImmobilier2.setMontant(350000.0);
        creditImmobilier2.setDureeRemboursement(300); // 25 ans
        creditImmobilier2.setTauxInteret(3.1);
        creditImmobilier2.setTypeBien(TypeBien.MAISON);
        creditImmobilier2.setRemboursements(new ArrayList<>());

        creditImmobilierRepository.save(creditImmobilier1);
        creditImmobilierRepository.save(creditImmobilier2);

        System.out.println("Crédits immobiliers créés avec succès !");

        // Création des crédits professionnels
        CreditProfessionnel creditProfessionnel1 = new CreditProfessionnel();
        creditProfessionnel1.setClient(client3);
        creditProfessionnel1.setDateDemande(dateFormat.parse("2023-05-20"));
        creditProfessionnel1.setStatut(StatutCredit.ACCEPTE);
        creditProfessionnel1.setDateAcceptation(dateFormat.parse("2023-06-05"));
        creditProfessionnel1.setMontant(75000.0);
        creditProfessionnel1.setDureeRemboursement(60); // 5 ans
        creditProfessionnel1.setTauxInteret(6.0);
        creditProfessionnel1.setMotif("Achat de matériel");
        creditProfessionnel1.setRaisonSociale("Dubois Consulting SARL");
        creditProfessionnel1.setRemboursements(new ArrayList<>());

        creditProfessionnelRepository.save(creditProfessionnel1);

        System.out.println("Crédit professionnel créé avec succès !");

        // Création des remboursements
        // Pour le crédit personnel 1
        Remboursement remboursement1 = new Remboursement();
        remboursement1.setCredit(creditPersonnel1);
        remboursement1.setDate(dateFormat.parse("2023-02-28"));
        remboursement1.setMontant(450.0);
        remboursement1.setType(TypeRemboursement.MENSUALITE);

        Remboursement remboursement2 = new Remboursement();
        remboursement2.setCredit(creditPersonnel1);
        remboursement2.setDate(dateFormat.parse("2023-03-31"));
        remboursement2.setMontant(450.0);
        remboursement2.setType(TypeRemboursement.MENSUALITE);

        // Pour le crédit immobilier 1
        Remboursement remboursement3 = new Remboursement();
        remboursement3.setCredit(creditImmobilier1);
        remboursement3.setDate(dateFormat.parse("2023-04-30"));
        remboursement3.setMontant(950.0);
        remboursement3.setType(TypeRemboursement.MENSUALITE);

        Remboursement remboursement4 = new Remboursement();
        remboursement4.setCredit(creditImmobilier1);
        remboursement4.setDate(dateFormat.parse("2023-05-15"));
        remboursement4.setMontant(10000.0);
        remboursement4.setType(TypeRemboursement.REMBOURSEMENT_ANTICIPE);

        // Pour le crédit professionnel 1
        Remboursement remboursement5 = new Remboursement();
        remboursement5.setCredit(creditProfessionnel1);
        remboursement5.setDate(dateFormat.parse("2023-07-05"));
        remboursement5.setMontant(1500.0);
        remboursement5.setType(TypeRemboursement.MENSUALITE);

        remboursementRepository.save(remboursement1);
        remboursementRepository.save(remboursement2);
        remboursementRepository.save(remboursement3);
        remboursementRepository.save(remboursement4);
        remboursementRepository.save(remboursement5);

        System.out.println("Remboursements créés avec succès !");

        // Affichage des statistiques
        System.out.println("Nombre de clients: " + clientRepository.count());
        System.out.println("Nombre de crédits personnels: " + creditPersonnelRepository.count());
        System.out.println("Nombre de crédits immobiliers: " + creditImmobilierRepository.count());
        System.out.println("Nombre de crédits professionnels: " + creditProfessionnelRepository.count());
        System.out.println("Nombre de remboursements: " + remboursementRepository.count());

        // Test de quelques requêtes
        System.out.println("\n********** Test de requêtes **********");

        System.out.println("\nListe des clients:");
        clientRepository.findAll().forEach(c -> System.out.println(" - " + c.getNom() + " (" + c.getEmail() + ")"));

        System.out.println("\nRecherche des remboursements après le 01/04/2023:");
        try {
            Date date = dateFormat.parse("2023-04-01");
            remboursementRepository.findByDateAfter(date).forEach(r ->
                    System.out.println(" - Remboursement du " + dateFormat.format(r.getDate()) + ", Montant: " + r.getMontant() + " DH, Type: " + r.getType()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nRecherche des crédits immobiliers par type de bien:");
        creditImmobilierRepository.findByTypeBien(TypeBien.APPARTEMENT).forEach(c ->
                System.out.println(" - Crédit pour un " + c.getTypeBien() + ", Montant: " + c.getMontant() + " DH"));

        System.out.println("\n*************** Fin de l'initialisation ***************");

    }
}
